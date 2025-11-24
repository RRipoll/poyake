package com.jsantos.metadata.plugin.ui.grapheditor;

import java.io.InputStream;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.zest.core.widgets.Graph;

import com.jsantos.metadata.plugin.ui.builder.BuildStateManager;
import com.jsantos.metadata.plugin.ui.grapheditor.serialization.SerializableNodeInfo;
import com.jsantos.metadata.plugin.ui.grapheditor.serialization.Serializer;

public class GraphEditorPart extends EditorPart implements IDirtyStateEventManager{
	
	
	ModelManager modelManager;
	GraphControls graphControls;
	private Graph graph = null;
	Composite parent;
	Composite grid;
	ArrayList<SerializableNodeInfo> initializationList;
	ModelChangeListener modelChangeListener = new ModelChangeListener();
	IProject project = null;

	public GraphEditorPart() throws CoreException {
		modelManager = new ModelManager(this);
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		InputStream is = null;
		try {
			IEditorInput input = getEditorInput();
			if (input instanceof IFileEditorInput) {
				IFileEditorInput fei = (IFileEditorInput) input;
				System.out.println(fei.getName());
				fei.getFile().setContents(Serializer.serialize(graph), IResource.FORCE, null);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error saving", e.getMessage());
		} 
		finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error saving", e.getMessage());
			}
		}		
		modelManager.setDirty(false);
	}

	@Override
	public void doSaveAs() {
		InputStream is = null;
		try {
			IEditorInput input = getEditorInput();
			if (input instanceof IFileEditorInput) {
				IFileEditorInput fei = (IFileEditorInput) input;

				SaveAsDialog dialog = new SaveAsDialog(parent.getShell());
				dialog.setOriginalFile(fei.getFile());
				dialog.setBlockOnOpen(true);
				if (Window.OK == dialog.open()) {
					  IPath path = dialog.getResult();
					  if (path != null) {
					    IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
					    if(file.exists()) {
					    	file.setContents(Serializer.serialize(graph), IResource.FORCE, null);
					    }
					    else
					    	file.create(Serializer.serialize(graph), IResource.FORCE, null);
					  }
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error saving", e.getMessage());
		} 
		finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error saving", e.getMessage());
			}
		}		
		modelManager.setDirty(false);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
		if (input instanceof IFileEditorInput) {
			try {
				IFileEditorInput fei = (IFileEditorInput) input;
				setTitle(fei.getFile().getName());
				project = fei.getFile().getProject();
				modelManager.init(project.getName());
				BuildStateManager.ensureBuilt(project);
				initializationList = Serializer.deserialize(fei.getFile().getContents());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		modelManager.setDirty(false);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(modelChangeListener);
	}

	@Override
	public boolean isDirty() {
		return modelManager.isDirty();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void createPartControl(Composite parent) {
			this.parent = parent;
			grid = new Composite(parent, SWT.NONE);
	        GridLayout gridLayout = new GridLayout();
	        gridLayout.numColumns=3;
	        
	        
			grid.setLayout(gridLayout);

			buildGraph();
			graphControls= new GraphControls(grid);
			graphControls.init(modelManager, graph);
	}

	@Override
	public void setFocus() {
		try {
			if (modelChangeListener.isMetadataChanged()) {
				modelManager.refresh(graph, project.getName());
				graphControls.refreshEntityTableRows();
				modelChangeListener.setMetadataChanged(false);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}
	
	void buildGraph() {
		
		graph = new Graph(grid, SWT.NONE);
		graph.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,1,1));
		
		
		// Selection listener on graphConnect or GraphNode is not supported
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=236528
		graph.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(e);
			}

		});
		
		graph.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(e);
				if (e.character == '+' && e.stateMask==SWT.CTRL) {
					graph.getRootLayer().setScale(graph.getRootLayer().getScale() * 1.1d);
					graph.getRootLayer().invalidate();
				}
				if (e.character == '-' && e.stateMask==SWT.CTRL) {
					graph.getRootLayer().setScale(graph.getRootLayer().getScale() * 0.9d);
					graph.getRootLayer().invalidate();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		graph.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseScrolled(MouseEvent e) {
				if (e.count>0 && e.stateMask==SWT.CTRL) {
					graph.getRootLayer().setScale(graph.getRootLayer().getScale() * 1.05d);
					graph.getRootLayer().invalidate();
				}
				if (e.count<0 && e.stateMask==SWT.CTRL) {
					graph.getRootLayer().setScale(graph.getRootLayer().getScale() * 0.95d);
					graph.getRootLayer().invalidate();
				}
				
			}
		});
		
		graph.addMenuDetectListener(new MenuDetectListener() {
			
			@Override
			public void menuDetected(MenuDetectEvent e) {
				System.out.println("show menu" + e);
				System.out.println(e.widget);
				
				Point point = graph.toControl(e.x, e.y);
				Rectangle clientArea = graph.getViewport().getClientArea();
				//IFigure fig = graph.getViewport().findFigureAt(point.x, point.y);
	            IFigure fig = graph.getFigureAt(point.x + clientArea.x, point.y + clientArea.y);
	            EntityGraphNode node = modelManager.getNodeForFigure(fig, graph);

	            if (fig != null && node !=null){
	                Menu menu = new Menu(parent.getShell(), SWT.POP_UP);

	                MenuItem showDefinitionItem = new MenuItem(menu, SWT.NONE);
	                showDefinitionItem.setText("Show definition file");
	                showDefinitionItem.addListener(SWT.Selection, new Listener() {
						@Override
						public void handleEvent(Event event) {
							IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
							URI uri = node.getEntity().eResource().getURI();
							if (uri.toString().contains("platform:/resource")) {
								IPath path = new Path(uri.toString().replace("platform:/resource", ""));
								IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
								if (file.exists()) {
									IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
									try {
										page.openEditor(new FileEditorInput(file), desc.getId());
									} catch (PartInitException e) {
										e.printStackTrace();
									}
								}
							}
							/*
							*/
							//IFile file = ((IFileEditorInput)getEditorInput()).getFile();
							//IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
							//page.openEditor(new FileEditorInput(file), desc.getId());							
						}
					});

	                
	                MenuItem removeItem = new MenuItem(menu, SWT.NONE);
	                removeItem.setText("Remove");
	                removeItem.addListener(SWT.Selection, new Listener() {
						@Override
						public void handleEvent(Event event) {
							modelManager.removeNode(node);
						}
					});
	                
	                MenuItem addAssociatedNodesItem = new MenuItem(menu, SWT.NONE);
	                addAssociatedNodesItem.setText("Add associated nodes");
	                addAssociatedNodesItem.addListener(SWT.Selection, new Listener() {
						@Override
						public void handleEvent(Event event) {
							modelManager.addAssociatedNodes(node, graph);
						}
	                });
	                
	                new MenuItem(menu, SWT.SEPARATOR);
	                
	                MenuItem showPksItem = new MenuItem(menu, SWT.CHECK);
	                showPksItem.setText("Show Primary Key Fields");
	                showPksItem.setSelection(node.getShowPks());
	                showPksItem.addListener(SWT.Selection, new Listener() {
						@Override
						public void handleEvent(Event event) {
							node.setShowPks(!node.getShowPks());
							modelManager.setDirty(true);
						}
					});

	                MenuItem showFksItem = new MenuItem(menu, SWT.CHECK);
	                showFksItem.setText("Show Foreign Key Fields");
	                showFksItem.setSelection(node.getShowFks());
	                showFksItem.addListener(SWT.Selection, new Listener() {
						@Override
						public void handleEvent(Event event) {
							node.setShowFks(!node.getShowFks());
							modelManager.setDirty(true);
						}
					});

	                MenuItem showAllItem = new MenuItem(menu, SWT.CHECK);
	                showAllItem.setText("Show not Key Fields");
	                showAllItem.setSelection(node.getShowNonKeyFields());
	                showAllItem.addListener(SWT.Selection, new Listener() {
						@Override
						public void handleEvent(Event event) {
							node.setShowNonKeyFields(!node.getShowNonKeyFields());
							modelManager.setDirty(true);
						}
					});
	                
	                
	                menu.setVisible(true);
	            }
	            else
	            {
	                Menu menu = new Menu(parent.getShell(), SWT.POP_UP);
	                MenuItem exit = new MenuItem(menu, SWT.NONE);
	                exit.setText("Nothing here...");
	                menu.setVisible(true);
	            }				
			}
		});
		
		graph.addDragDetectListener(new DragDetectListener() {
			
			@Override
			public void dragDetected(DragDetectEvent e) {
				modelManager.setDirty(true);
			}
		});
		
		try {
			if (null != initializationList) {
				Serializer.applyList(initializationList, modelManager, graph, project.getName());
				modelManager.setDirty(false);
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
	
		
	}

	
	public void reportDirtyChange() {
		firePropertyChange(EditorPart.PROP_DIRTY);		
	}
	

}
