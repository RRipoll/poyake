package com.jsantos.metadata.plugin.ui.builder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.IAllContainersState;

import com.google.inject.Inject;
import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionPreferences;
import com.jsantos.metadata.plugin.generator.templates.resourceset.DBCreationScriptGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.MTGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.VersionMarkerGenerator;
import com.jsantos.metadata.plugin.ui.util.MetaDslUtil;
import com.jsantos.metadata.plugin.ui.util.ResourceSetLoader;
import com.jsantos.metadata.plugin.util.Logger;

public class JavaProjectBasedBuilderParticipant2 extends BuilderParticipant {
	@Inject
	private IAllContainersState.Provider stateProvider;

	/*
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	@Inject
	private IContainer.Manager containerManager;
	*/

	
	
	protected ThreadLocal<Boolean> buildSemaphor = new ThreadLocal<Boolean>();

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		buildSemaphor.set(false);
		super.build(context, monitor);
	}

	@Override
	protected void handleChangedContents(Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) throws CoreException {
		super.handleChangedContents(delta, context, fileSystemAccess);
		if (!buildSemaphor.get()) {
			try {
				invokeGenerator(delta, context, fileSystemAccess);
			}
			catch(Throwable e) {
				e.printStackTrace();
				throw e;
			}
		}
	}


	/*
	void reportChanges(Delta delta, IBuildContext context) {
		Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		

	}
	*/
	
	/*
  @Override
  protected void handleDeletion(Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) {
    super.handleDeletion(delta, context, fileSystemAccess);
    if (!buildSemaphor.get() && generator != null) {
      invokeGenerator(delta, context, fileSystemAccess);
    }
  }
	 */

	
	
	List<URI> buildArchiveURIs(IBuildContext context){
		ArrayList<URI> uris = new ArrayList<>(); 
		String projectName = context.getBuiltProject().getName();
		String  root = "=" + projectName + "/src\\/main\\/resources=/maven.pomderived=/true=/";
		List<String> handles = stateProvider.get(null).getVisibleContainerHandles(root);
		for (String handle:handles) {
			for (URI uri:stateProvider.get(null).getContainedURIs(handle)) {
				//if (uri.toString().contains(".jar!"))
				uris.add(uri);
			}
		}
		
		return uris;
	}

	
	private void invokeGenerator (Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) {
		buildSemaphor.set(true);
		Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
		if (shouldGenerate(resource, context)) {
			/*
			IResourceDescriptions index = resourceDescriptionsProvider.createResourceDescriptions();
			IResourceDescription resDesc = index.getResourceDescription(resource.getURI());
			List<IContainer> visibleContainers = containerManager.getVisibleContainers(resDesc, index);
			for (IContainer c : visibleContainers) {
				for (IResourceDescription rd : c.getResourceDescriptions()) {
					context.getResourceSet().getResource(rd.getURI(), true);
					Logger.info("Resource URI for script generation: " + rd.getURI());
				}
			}

			//tryToBuildXMI(context.getResourceSet());
			new MTGenerator().generate(context.getResourceSet(), fileSystemAccess);
			*/

			try {
//				System.out.println(context.getBuiltProject().getName());
				XtextResourceSet rSet = new ResourceSetLoader().buildResourceSet(context.getBuiltProject().getName(), false, buildArchiveURIs(context));
				ResourceSetLoader.logResourceList(rSet);
				new MTGenerator().generate(rSet, fileSystemAccess, context.getBuiltProject().getName());
				//new LabelGenerator().generate(rSet, fileSystemAccess);
				
				ConnectionPreferences connectionPreferences = MetaDslUtil.readConnectionPreferences(context.getBuiltProject().getName());
				new DBCreationScriptGenerator().generate(rSet, fileSystemAccess, connectionPreferences);
				new VersionMarkerGenerator().generate(rSet, fileSystemAccess);
			}
			catch (Exception e) {
				e.printStackTrace();
				Logger.error("Exception building XtextResourceSet for file generation", e);
			}
			//new DBDropSQLGenerator().generate(context.getResourceSet(), fileSystemAccess);
		}
	}
	
	
	void tryToBuildXMI(ResourceSet resourceSet) {
		//Injector injector = new MetaDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		//ResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());

		//URI uri = URI.createURI("person.cm");
		//Resource xtextResource = resourceSet.getResource(uri, true);
		//try {
		//	xtextResource.load(null);
		//} catch (IOException e1) {
		//	e1.printStackTrace();
		//}
		//EcoreUtil.resolveAll(xtextResource);
		try {
			for (Resource resource:resourceSet.getResources()) {
				if (resource.getURI().toString().contains("Company")) {
					Resource xmiResource = resourceSet.createResource(URI.createURI(resource.getURI()+".xmi"));
					xmiResource.getContents().add(resource.getContents().get(0));
					xmiResource.save(null);
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}