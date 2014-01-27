package org.clonedigger.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;

import org.clonedigger.Activator;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.wizard.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.*;
import org.eclipse.ui.internal.browser.WebBrowserEditorInput;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.osgi.framework.Bundle;
import org.python.pydev.navigator.elements.IWrappedResource;

/**
 * The main class of this plugin. Implementation of Dig Clones action.
 * The wizard implemented as enclosed class. 
 */
@SuppressWarnings("restriction")
public class DigAction implements 
	IViewActionDelegate, IWorkbenchWindowActionDelegate, IObjectActionDelegate, IPageChangedListener 
{
	boolean WINDOWS = java.io.File.separatorChar == '\\';
	Set<String> selectedFiles = new LinkedHashSet<String>();
	Set<IResource> selectedResources = new LinkedHashSet<IResource>();
	Set<IResource> grayedResources = new LinkedHashSet<IResource>();
	Process digProcess = null;
	Thread digThread = null;
	private String htmFile;
	private ProcessBuilder pb;
	private DigWizard digWizard;
		
	public DigAction() {
	}
	
	public void dispose() {
	}
	
	public void init(IViewPart view) {
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) { 
	}
	
	public void init(IWorkbenchWindow window) {
	}
	
	class ResourcesPage extends WizardPage implements 
		ITreeContentProvider, ILabelProvider, ICheckStateListener
	{
		private Combo langCombo;
		private CheckboxTreeViewer resourcesTree;
		private ILabelProvider labelProvider;
		private Button fastMode;
		private Spinner cloneSize;
		private Spinner cloneDist;

		public ResourcesPage() {
			super("ResourcesPage");
			setTitle("Please select files to dig");
			labelProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			GridLayout gl = new GridLayout();
			GridData gd;
			gl.numColumns = 2;
			gl.horizontalSpacing = 12;
			composite.setLayout(gl);
			new Label(composite, SWT.NONE).setText("Select language:");					
			
			Group opsGroup = new Group(composite, SWT.BEGINNING);
			opsGroup.setText("Dig options");
			opsGroup.setLayout(new GridLayout(5, false));
			
			gd = new GridData(GridData.BEGINNING);
			gd.verticalSpan = 2;
			opsGroup.setLayoutData(gd);
			
			fastMode = new Button(opsGroup, SWT.CHECK);
			fastMode.setText("Fast mode");
			fastMode.setToolTipText(
					"Find only clones, which differ in variable and function names and constants." +
					"Use this option if you don't want to wait.");
			Label label = new Label(opsGroup, SWT.NONE);
			label.setText("  Clone size:");
			label.setToolTipText("The minimum clone size (in lines of code)");
			cloneSize = new Spinner(opsGroup, SWT.BORDER);
			cloneSize.setMinimum(1);
			cloneSize.setMaximum(99);
			cloneSize.setTextLimit(2);
			cloneSize.setToolTipText(label.getToolTipText());
			label = new Label(opsGroup, SWT.NONE);
			label.setText("  Clone distance:");
			label.setToolTipText("The maximum amount of differences between fragments in clone pair");
			cloneDist = new Spinner(opsGroup, SWT.BORDER);
			cloneDist.setMinimum(1);
			cloneDist.setMaximum(99);
			cloneDist.setTextLimit(2);
			cloneDist.setToolTipText(label.getToolTipText());
			
			langCombo = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
			langCombo.add("Python");
			langCombo.add("Java");
			langCombo.add("JavaScript");
			langCombo.add("Lua");
			langCombo.select(0);
			gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
			langCombo.setLayoutData(gd);
			langCombo.addSelectionListener(new SelectionListener() 
			{

				public void widgetDefaultSelected(SelectionEvent e) {
					if(resourcesTree != null)
						resourcesTree.refresh();
				}
 
				public void widgetSelected(SelectionEvent e) {
					if(resourcesTree != null) {
						resourcesTree.refresh();
						resourcesTree.setCheckedElements(filterValidItems(selectedResources));
						resourcesTree.setGrayedElements(filterValidItems(grayedResources));
					} 
					if(langCombo.getSelectionIndex() == 0) {
						cloneSize.setSelection(5);
						cloneDist.setSelection(5);
					} else if (langCombo.getSelectionIndex() == 1) {
						cloneSize.setSelection(10);
						cloneDist.setSelection(7);
					} else if (langCombo.getSelectionIndex() == 2) {
						cloneSize.setSelection(5);
						cloneDist.setSelection(5);
					} else if (langCombo.getSelectionIndex() == 3) {
						cloneSize.setSelection(5);
						cloneDist.setSelection(5);
					}
				}
				
			});
			langCombo.notifyListeners(SWT.Selection, new Event());
									
			label = new Label(composite, SWT.NONE);
			label.setText("Select files:");
			gd = new GridData(SWT.BEGINNING);
			gd.horizontalSpan = 2;
			label.setLayoutData(gd);
			resourcesTree = new CheckboxTreeViewer(composite);
			//TODO: make normal tree grayed representation through counting of childs
			//resourcesTree.setLabelProvider(this);
			//resourcesTree.setContentProvider(this);
			resourcesTree.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
			resourcesTree.setContentProvider(new WorkbenchContentProvider()
			{
				public Object[] getChildren(Object o) {
	                if (o instanceof IContainer) {
	                    IResource[] members = null;
	                    try {
	                        members = ((IContainer) o).members();
	                    } catch (CoreException e) {
	                        return new Object[0];
	                    }

	                    List<Object> results = new ArrayList<Object>();
	                    for(Object member: members) {
	                        if(member instanceof IFile) {
	                        	if(((IFile)member).getFileExtension() != null)
	                        		if(langCombo.getSelectionIndex() == 0 &&
	                        				((IFile)member).getFileExtension().equals("py") ||
	                        		   langCombo.getSelectionIndex() == 1 &&
	                        				((IFile)member).getFileExtension().equals("java") ||
	                        		   langCombo.getSelectionIndex() == 2 &&
	                        				((IFile)member).getFileExtension().equals("js") ||
	                        		   langCombo.getSelectionIndex() == 3 &&
	                        				((IFile)member).getFileExtension().equals("lua"))


	                        			results.add(member);
	                        } else results.add(member);
	                    }
	                    return results.toArray();
	                } 
	                return new Object[0];
	            }
			});
			resourcesTree.addCheckStateListener(this);
			resourcesTree.setInput(ResourcesPlugin.getWorkspace().getRoot());
			gd = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
			gd.horizontalSpan = 2;
			resourcesTree.getControl().setLayoutData(gd);
			resourcesTree.refresh();
			resourcesTree.setCheckedElements(filterValidItems(selectedResources));
			resourcesTree.setGrayedElements(filterValidItems(grayedResources));
			
			setControl(composite); 
		}

		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof IContainer)
				try {
					return ((IContainer)parentElement).members();
				} catch (CoreException e) {
					Activator.log(e);
				}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if(element instanceof IResource)
				((IResource)element).getParent();
			return null;
		}

		public boolean hasChildren(Object element) {
			if(element instanceof IContainer)
				try {
					return ((IContainer)element).members().length > 0;
				} catch (CoreException e) {
					Activator.log(e);
				}
			return false;
		}

		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof IContainer)
				try {
					return ((IContainer)inputElement).members();
				} catch (CoreException e) {
					Activator.log(e);
				}
			return new Object[0];
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Image getImage(Object element) {
			return labelProvider.getImage(element);
		}

		public String getText(Object element) {
			return labelProvider.getText(element);
		}

		public void addListener(ILabelProviderListener listener) {
			labelProvider.addListener(listener);
		}

		public boolean isLabelProperty(Object element, String property) {
			return labelProvider.isLabelProperty(element, property);
		}

		public void removeListener(ILabelProviderListener listener) {
			labelProvider.removeListener(listener);
		}

		public void checkStateChanged(CheckStateChangedEvent event) {
			boolean checked = event.getChecked();
			IResource res = (IResource) event.getElement();
			selectResource(res, checked); 
			resourcesTree.setCheckedElements(filterValidItems(selectedResources));
			resourcesTree.setGrayedElements(filterValidItems(grayedResources));
		}
		
		/** 
		 * This method is a speedup. 
		 * When you trying to check or gray an absent element through setCheckedElements or 
		 * setGrayedElements, you may introduce an undesirable delay.  
		 */
		public Object[] filterValidItems(Collection<IResource> src)
		{
			List<Object> results = new ArrayList<Object>();
            for(Object member: src) {
                if(member instanceof IFile) {
                	if(((IFile)member).getFileExtension() != null)
                		if(langCombo.getSelectionIndex() == 0 &&
                				((IFile)member).getFileExtension().equals("py") ||
                		   langCombo.getSelectionIndex() == 1 &&
                		   		((IFile)member).getFileExtension().equals("java") ||
                		   langCombo.getSelectionIndex() == 2 &&
	                        	((IFile)member).getFileExtension().equals("js") ||
	                       langCombo.getSelectionIndex() == 3 &&
	                        	((IFile)member).getFileExtension().equals("lua"))
                			results.add(member);
                } else results.add(member);
            }
            return results.toArray();
		}
		
	}
	
	class ConsolePage extends WizardPage
	{
		Text console;

		public ConsolePage() {
			super("ConsolePage");
			setTitle("Running clonedigger");
			setPageComplete(false);
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			GridLayout gl = new GridLayout();
			int ncol = 1;
			gl.numColumns = ncol;
			composite.setLayout(gl);
			
			console = new Text(composite, SWT.READ_ONLY | SWT.WRAP | SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
			console.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
			console.setBackground(new Color(null, 0,0,0));
			console.setForeground(new Color(null, 255,255,255));
						
			setControl(composite);
		}		

	}
	
	class DigWizard extends Wizard
	{
		public ResourcesPage resourcePage;
		public ConsolePage consolePage;

		public void addPages() {
			super.addPages();
			addPage(resourcePage = new ResourcesPage());
			addPage(consolePage = new ConsolePage());
			setWindowTitle("Dig clones");
		}

		public boolean performFinish() {
			if((new java.io.File(htmFile)).exists())
				try {

					IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();

					IEditorInput htmInput = null;
					htmInput = new WebBrowserEditorInput(
							new URL("file:/" + htmFile.replaceAll("^/+", "")), 0);
					
					if(htmInput == null)
						Activator.log(new Exception(
							"Cant create WebBrowserEditorInput for file \"" + 
							(new java.io.File(htmFile)).getAbsolutePath() + 
							"\""));
 
					//IEditorPart	htmEditor = (IEditorPart)
					page.openEditor(htmInput,
						"org.clonedigger.resultbrowser");
					//"org.eclipse.ui.browser.editor");		

				} catch (MalformedURLException e) {
					Activator.log(e);
				} catch (PartInitException e) {
					Activator.log(e);
				}
			else
				Activator.log(new Exception("File not exists \"" + 
					(new java.io.File(htmFile)).getAbsolutePath() + "\""));
					
			return true;
		}
		
		public boolean performCancel() {
			synchronized(Activator.getDefault()) 
			{
				if(digThread == null) return true;
				if(digProcess != null)
					try {
						digProcess.destroy();
						digProcess.waitFor();
						
					} catch (InterruptedException e) {
						Activator.log(e);
					}
				digWizard = null;
			}
			return true;
		}
	}
	
	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) 
	{
		if(!PlatformUI.getWorkbench().saveAllEditors(true)) return;
		
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		digWizard = new DigWizard();
		WizardDialog wd = new WizardDialog(shell, digWizard);
		wd.addPageChangedListener(this);
		wd.open();
	}
	
	/**
	 * Select or deselect resource. Fix selected resources 
	 * and grayed resources according to new selection. 
	 */
	public void selectResource(IResource res, boolean select)
	{
		if(res == null) return;
		if(select && selectedResources.contains(res) && !grayedResources.contains(res)) return;
		if(res instanceof IContainer)
			try {
				for(IResource subRes: ((IContainer)res).members())
					selectResource(subRes, select);				
			} catch (CoreException e) {
				Activator.log(e);
			}
		else if(res instanceof IFile)
		{
			if(select)
				selectedFiles.add(res.getLocation().toOSString());
			else
				selectedFiles.remove(res.getLocation().toOSString());
		}
		
		if(select) 
			selectedResources.add(res);
		else
			selectedResources.remove(res);
		grayedResources.remove(res);
		
		res = res.getParent();
		while(res != null)
		{
			selectedResources.add(res);
			grayedResources.add(res);
			res = res.getParent();
		}
	}
	
	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) 
	{
		if(!(selection instanceof IStructuredSelection)) return;
		IStructuredSelection sel = (IStructuredSelection)selection;
		selectedFiles.clear();
		selectedResources.clear();
		grayedResources.clear();
		action.setEnabled(true);
		for(Object obj: sel.toArray())
		{
			IResource res = null;
			if(obj instanceof IResource) 
				res = (IResource)obj;
			if(obj instanceof IWrappedResource)
			{
  				Object unwrap = ((IWrappedResource)obj).getActualObject();
				if(unwrap instanceof IResource)
				res = (IResource) unwrap;
			}
			if(obj instanceof IJavaElement) 
				res = ((IJavaElement)obj).getResource();
			//if(res == null) action.setEnabled(false);
			selectResource(res, true);
		}
	}

	/**
	 * The handler of event from Wizard buttons next and back. 
	 * Running CloneDigger process or terminate it immediately. 
	 */
	public void pageChanged(PageChangedEvent event) {
		IDialogPage page = (IDialogPage) event.getSelectedPage();
		if(!(page instanceof ConsolePage))
		{
			synchronized(Activator.getDefault())
			{
				if(digThread == null) return;
				if(digProcess != null)
					try {
						digProcess.destroy();
						digProcess.waitFor();
					} catch (InterruptedException e) {
						Activator.log(e);
					}
				return;
			}
		}
		int langidx = digWizard.resourcePage.langCombo.getSelectionIndex();
		final ConsolePage consolePage = (ConsolePage) page;
		consolePage.console.setText("");
		consolePage.setPageComplete(false);
		
		//Normal output file name
		String ohtmFile = "";
		
		File flistFile = null;
		try {
			File tmpfile = File.createTempFile("cde_output", ".htm");
			htmFile = tmpfile.getAbsolutePath();
			tmpfile.deleteOnExit();
			
			tmpfile = File.createTempFile("cde_output_o", ".htm");
			ohtmFile = tmpfile.getAbsolutePath();
			tmpfile.deleteOnExit();
			
			flistFile = File.createTempFile("cde_flist", ".lst");
			flistFile.deleteOnExit();
		
			BufferedWriter flistStream = new BufferedWriter(new FileWriter(flistFile));
			for(String f: selectedFiles)
			{
				f = f.replaceAll("\\\\", "/"); //fix bug in browsersupport, which broke links with "\"
				if(langidx == 0 && f.endsWith(".py")) flistStream.write(f + "\n");
				if(langidx == 1 && f.endsWith(".java")) flistStream.write(f + "\n");
				if(langidx == 2 && f.endsWith(".js")) flistStream.write(f + "\n");
				if(langidx == 2 && f.endsWith(".lua")) flistStream.write(f + "\n");
			}
			flistStream.flush();
		} catch (IOException e) {
			Activator.log(e);
		}
		
		Bundle bundle = Platform.getBundle("org.clonedigger");
		String runpath = "";
		try {
			runpath = FileLocator.toFileURL(bundle.getEntry("runclonedigger.py")).getPath();
		} catch (IOException e) {
			Activator.log(e);
		}
		if(WINDOWS) runpath = runpath.replaceAll("^/+", "");
		
		pb = new ProcessBuilder();
		
		/* The use of shell to run runclonedigger.py was abandoned cause java can't kill grandchild processes
		 * in a case when we need to cancel our CloneDigger process.
		 * (see bug 4770092 as an example)
		 * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4770092
		 * 
		 *if(WINDOWS)
		{
			//cmd /C ""..." "..."  > 2>&1"
			pb.command().add("cmd");
			pb.command().add("/C");
			pb.command().add(
					"\"\"" + runpath + "\" " +
					//"\"\"" + FileLocator.getBundleFile(bundle).getAbsolutePath() + 
						"\\runclonedigger.py\" " +
					ops +
					" --output=\"" + htmFile + "\" " +
					" --file-list=\"" + flistFile.getAbsolutePath() + "\" " +
					" 2>&1 \"");
		}
		else
		{
			//sh -c python "..." "..." > 2>&1
			pb.command().add("sh");
			pb.command().add("-c");
			pb.command().add(
					"python \"" + runpath + "\" " +
					//"python \"" + FileLocator.getBundleFile(bundle).getAbsolutePath() + 
						"/runclonedigger.py\" " +
					ops +
					" --output=\"" + htmFile + "\" " +
					" --file-list=\"" + flistFile.getAbsolutePath() + "\" " +
					" 2>&1 ");
		}*/
		
		pb.command().add("python");
		pb.command().add(runpath);
		if(langidx == 1) 
			pb.command().add("--lang=java");
		else if (langidx == 2)
			pb.command().add("--lang=js");
		else if (langidx == 3)
			pb.command().add("--lang=lua");
		if(digWizard.resourcePage.fastMode.getSelection()) 
			pb.command().add("--fast");
		pb.command().add("--size-threshold=" + digWizard.resourcePage.cloneSize.getSelection());
		pb.command().add("--distance-threshold=" + digWizard.resourcePage.cloneDist.getSelection()); 
		pb.command().add("--output=" + ohtmFile);
		pb.command().add("--eclipse-output=" + htmFile);
		pb.command().add("--file-list=" + flistFile.getAbsolutePath());
		pb.redirectErrorStream(true);
		String ppath = (new File(runpath)).getParent() + "/CloneDigger";
		pb.environment().put("PYTHONPATH", ppath);
		
		System.out.println("pythonexec: " + pb.command().toString()); 
		
		consolePage.console.append("Running clonedigger...\n\n");

		synchronized(Activator.getDefault())
		{
			digWizard.resourcePage.setPageComplete(false); // This prevents us from running two 
			// threads. Why we shouldn't use digThread.join to wait for the thread? 
			// digThread use syncExec method and join operation in main thread cause 
			// digThread to deadlock, remember that Thread.stop is depricated 
			
			digThread = new Thread(new Runnable() {
				public void run() {
					try
					{
						final char[] buf = new char[1024]; 
						do
						{
							try {
								InputStreamReader pi;
								synchronized(Activator.getDefault())
								{
									digProcess = pb.start();
									// TODO: support for oem local encoding... on windows use "chcp" command
									// for now support only for cyrillic encoding CP866
									pi = new InputStreamReader(digProcess.getInputStream(), "CP866");
								}

								while(true)
								{
									final int len = pi.read(buf);
									if(len < 0) break;
									Display.getDefault().syncExec(new Runnable() {
										public void run() {
											if(digWizard != null)
												consolePage.console.append(new String(buf, 0, len));		
										}});
								}
							} catch (IOException e) {
								Activator.log(e);
							} 

							Display.getDefault().syncExec(new Runnable() {
								public void run() {
									if(digWizard != null)
										consolePage.console.append("\n");
								}});

							try {
								//On *nix systems output console closing a moment before terminating process
								digProcess.waitFor();
							} catch (InterruptedException e) { 
								Activator.log(e);
							}

						} while(digProcess.exitValue() == 143);
						Display.getDefault().syncExec(new Runnable() {
							public void run() {
								synchronized(Activator.getDefault())
								{
									//flistFile.delete(); we cant do this now through the stupid java 
									//limitation with "final" variables, also we cant make it final cause 
									//initialization of this variable may throw an error... 
									
									//Allow  to run other threads
									if(digWizard != null)
									{
										digWizard.resourcePage.setPageComplete(true);
										if((new File(htmFile)).exists() && (new File(htmFile)).length() != 0) 
										{
											consolePage.console.append("Press finish to view results...");
											consolePage.setPageComplete(true);
										}
										else
											consolePage.console.append("No output found...");
									}
									digProcess = null;
									digThread = null; 
								}
							}});
					}
					catch(Throwable e) 
					{ 
						synchronized(Activator.getDefault())
						{
							Display.getDefault().syncExec(new Runnable() {
								public void run() {
									//Allow  to run other threads
									if(digWizard != null)
										digWizard.resourcePage.setPageComplete(true); 
								}});
							digProcess = null;
							digThread = null;
						}
						Activator.log(e); 
					}
				}});
			digThread.start();
		}
	}
}
