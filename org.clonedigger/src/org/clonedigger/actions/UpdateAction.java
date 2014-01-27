package org.clonedigger.actions;

import java.io.File;
import java.io.IOException;

import org.clonedigger.Activator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.osgi.framework.Bundle;

/**
 * Implementation of Update CloneDigger action. 
 */
public class UpdateAction implements IWorkbenchWindowActionDelegate 
{
	boolean WINDOWS = java.io.File.separatorChar == '\\';
		
	public UpdateAction() {
	}
	
	public void dispose() {
	}
	
	public void init(IWorkbenchWindow window) {
	}
	
	/**
	 * Recursively delete directory.
	 * @param f
	 * @throws java.io.IOException
	 */
	private void delrec(File f) throws java.io.IOException {
		if (f.isDirectory()) {
		    File[] fs=f.listFiles();
		    for (int i=0;i<fs.length;i++) {
			delrec(fs[i]);
		    }
		}
		if (!(f.delete())) {
		    throw new java.io.IOException("cannot delete "+f.getPath());
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
		Bundle bundle = Platform.getBundle("org.clonedigger");
		String runpath = "";
		try {
			runpath = FileLocator.toFileURL(bundle.getEntry("runclonedigger.py")).getPath();
			if(WINDOWS) runpath = runpath.replaceAll("^/+", "");

			String ppath = (new File(runpath)).getParent() + "/CloneDigger";

			delrec(new File(ppath));

			MessageDialog.openInformation(
					null,
					"CloneDigger Plug-in",
					"CloneDigger will be automatically updated during the next run."
			);
		} catch (IOException e) {
			Activator.log(e);
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}
	
}