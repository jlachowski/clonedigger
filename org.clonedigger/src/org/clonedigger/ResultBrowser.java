package org.clonedigger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.browser.WebBrowserEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Implementation of WebBrowser with support for "clone:" links. 
 * Make a hook on location change event and navigate to editor.  
 */
@SuppressWarnings("restriction")
public class ResultBrowser extends WebBrowserEditor {
	
	private class CloneLocation implements LocationListener
	{

		public void changed(LocationEvent event) {}

		public void changing(LocationEvent event)
		{
			boolean WINDOWS = java.io.File.separatorChar == '\\';
			
			if(event.location.startsWith("clone:"))
			{
				event.doit = false;
				try
				{ 
					String [] args = event.location.split("clone://|\\?|&");
					
					//patch on strange browsersupport behavior on links with "\" character
					args[1] = args[1].replaceAll("/+$", "");
					if(WINDOWS) args[1] = args[1].replaceAll("/", "\\\\");
					
					IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
					
					IFile file = ResourcesPlugin.getWorkspace().getRoot().
						getFileForLocation(Path.fromOSString(args[1])); 
					
					IEditorInput editInput = null;
					
					if(file == null)
					{
						// Process external files, files that arent present in workspace for some reasons.
						IFileStore fileStore = EFS.getLocalFileSystem().getStore(
								new URI("file:/" + args[1].replaceAll("^/+", "").replaceAll("\\\\", "/")));
						editInput = new FileStoreEditorInput(fileStore);
					}
					else
					{
						editInput = new FileEditorInput(file);
					}

					ITextEditor editor = 
						(ITextEditor)IDE.openEditor(page, editInput,
								IDE.getEditorDescriptor(args[1]).getId(), true);
								//"org.python.pydev.editor.PythonEditor", true);
					IDocument doc = editor.getDocumentProvider().getDocument(editInput);

					try
					{
						int start = doc.getLineInformation(Integer.parseInt(args[2])).getOffset();
						int end = doc.getLineInformation(Integer.parseInt(args[3]) + 1).getOffset();
						editor.setHighlightRange(start, end-start, true);
					}
					catch (BadLocationException e) {
						Activator.log(e);
					} 					
				}
				catch (PartInitException e) {
					Activator.log(e);
				} catch (URISyntaxException e) {
					Activator.log(e);
				}
			}
			
			if(event.location.startsWith("http:")) event.doit = false;
			
			if(event.location.startsWith(System.getProperty("java.io.tmpdir")) || 
					event.location.startsWith("file:"))
			{
				String src = event.location;
				if(src.startsWith("file:")) 
				{
					src = src.replaceAll("^file:", "");
					src = src.replaceAll("^/+", "");
					if(!WINDOWS) src = "/" + src;
				}
				
				event.doit = false;
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				//SaveAsDialog dialog = new SaveAsDialog(shell);
				FileDialog dialog = new FileDialog(shell, SWT.SAVE);
				String[] exts = {"*.html"};
				dialog.setFilterExtensions(exts);
				String dest = dialog.open();
				if(dest != null)
				//if(dialog.open() == Window.OK)
				{
					//String dest = dialog.getResult().toOSString();
					
					//ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(dest)).
					
					//dest = ResourcesPlugin.getPlugin().find(new Path(dest)).getPath();
					//if(WINDOWS) dest = dest.replaceAll("^/+", "");
					
					try {
						copy(new File(src), new File(dest));
					} catch (IOException e) {
						Activator.log(e);
					}
				}
			}
		}
	}
	
	public static void copy(File source, File dest) throws IOException {
	     FileChannel in = null, out = null;
	     try {          
	          in = new FileInputStream(source).getChannel();
	          out = new FileOutputStream(dest).getChannel();
	 
	          long size = in.size();
	          MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
	 
	          out.write(buf);
	 
	     } finally {
	          if (in != null) in.close();
	          if (out != null) out.close();
	     }
	}
	
	public ResultBrowser() {
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		if(webBrowser == null || webBrowser.getBrowser() == null)
			Activator.log(new Exception("No Browser support found"));
		webBrowser.getBrowser().addLocationListener(new CloneLocation());
	}

}


