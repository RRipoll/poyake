package com.jsantos.metadata.plugin.ui.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.factory.SessionFactory;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ExportDocumentFormat;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.ui.PlatformUI;

public class TestHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		try {
			displayProgressDialog(event);

			//new DependencyFileParser().parseSqlFiles(UIUtil.getProject().getName());
			
			//displaySiriusScreen();
			
			/*
			ConnectionProfileSelectionDialog dialog = new ConnectionProfileSelectionDialog(window.getShell());
		    dialog.open();
			try {
				new LoadCatalog().test(MetaDslUtil.getConnectionProfile());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
		}
		catch (Throwable e) {
			e.printStackTrace();
			throw new ExecutionException(e.getMessage(), e);
		}
		return null;
	}
	
	public void displayProgressDialog(ExecutionEvent event) {

	    try {
			//ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell());  
			//progressDialog.run(false, true, new YourThread(10));
			PlatformUI.getWorkbench().getProgressService().runInUI(PlatformUI.getWorkbench().getProgressService(), new YourThread(100), ResourcesPlugin.getWorkspace().getRoot());
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }

	}
	
	private static class YourThread implements IRunnableWithProgress
    {
        private int workload;

        public YourThread(int workload)
        {
            this.workload = workload;
        }

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
        {
        	SubMonitor subMonitor = SubMonitor.convert(monitor, workload);

            // Do your work
            for(int i = 0; i < workload; i++)
            {
                // Optionally add subtasks
                //monitor.subTask("Copying file " + (i+1) + " of "+ workload + "...");

                // Tell the monitor that you successfully finished one item of "workload"-many
                //monitor.worked(1);

            	subMonitor.split(1);
            	//subMonitor.wait(100);
                // Check if the user pressed "cancel"
                if(subMonitor.isCanceled())
                {
                    monitor.done();
                    throw new OperationCanceledException();
                }
            }

            // You are done
            monitor.done();
        }

    }
	
	public void displaySiriusScreen() { //TODO:this is not even tested
		// Step 1: get the .aird file and the corresponding Sirius Session
		//SiriusDiagramTest/src/main/resources/MetaDsl.aird
		URI myRepresentationsFileURI = URI.createURI("/SiriusDiagramTest/src/main/resources/representations.aird");
		Session siriusSession = SessionManager.INSTANCE.getSession(myRepresentationsFileURI , new NullProgressMonitor());
		/*
		for (org.eclipse.emf.ecore.resource.Resource resource:siriusSession.getSemanticResources()) {
			System.out.println(resource.getURI());
		}
		siriusSession.addSemanticResource(URI.createURI("/SiriusDiagramTest/src/main/resources/MetaDsl.odesign"), new NullProgressMonitor());
		for (org.eclipse.emf.ecore.resource.Resource resource:siriusSession.getSemanticResources()) {
			System.out.println(resource.getURI());
		}
		*/

		// Step 2: get the DRepresentation to open
		DAnalysis root =(DAnalysis) siriusSession.getSessionResource().getContents().get(0);
		//root.getSemanticResources().add(new ResourceDescriptor(URI.createURI("/SiriusDiagramTest/src/main/resources/MetaDsl.odesign")));
		siriusSession.addSemanticResource(URI.createURI("/SiriusDiagramTest/src/main/resources/Company.metadata"), new NullProgressMonitor());
		
		DView dView = root.getOwnedViews().get(0);
		DRepresentation myRepresentation = dView.getOwnedRepresentationDescriptors().get(0).getRepresentation();

		// Step 3: open representation
		DialectUIManager.INSTANCE.openEditor(siriusSession, myRepresentation,new NullProgressMonitor());		
	}
	
	public void displaySiriusScreen2() throws CoreException { //TODO:this is not even tested
		Session siriusSession = SessionFactory.INSTANCE.createSession(URI.createURI("/SiriusDiagramTest/src/main/resources/representations2.aird"), new NullProgressMonitor());
		siriusSession.getTransactionalEditingDomain();
		siriusSession.addSemanticResource(URI.createURI("/SiriusDiagramTest/src/main/resources/MetaDsl.odesign"), new NullProgressMonitor());
		//DialectManager.INSTANCE.createRepresentation("pepito", semantic, description, siriusSession, new NullProgressMonitor())
	}	
	
	public void createSiriusImage() throws SizeTooLargeException {
		URI myRepresentationsFileURI = URI.createURI("/SiriusDiagramTest/src/main/resources/representations.aird");
		Session session = SessionManager.INSTANCE.getExistingSession(myRepresentationsFileURI);
		
		Collection<DRepresentation> allRepresentations = DialectManager.INSTANCE.getAllRepresentations(session);
		DRepresentation representation = (DRepresentation) allRepresentations.toArray()[0];

		IPath absoluteImagePath = new Path("pepe.png");

		// Export the image
		DialectUIManager.INSTANCE.export(representation, session, absoluteImagePath, new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG), new NullProgressMonitor());		
	}
	
	
}
