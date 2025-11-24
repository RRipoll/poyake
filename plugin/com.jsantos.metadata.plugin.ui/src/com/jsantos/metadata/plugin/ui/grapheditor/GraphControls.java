package com.jsantos.metadata.plugin.ui.grapheditor;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.IPath;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.ui.grapheditor.pagination.PageBorders;
import com.jsantos.metadata.plugin.ui.grapheditor.serialization.Serializer;

public class GraphControls extends ExpandBar{
	ModelManager modelManager;
	Graph graph;
	Table entityListTable;
	Text packageFilter;
	Text entityFilter;
	PageBorders pageBorders = new PageBorders();
	Button buttonPortrait;
	Button buttonLandscape;
	Combo comboPagesize;
	
	public GraphControls(Composite parent) {
		super(parent, SWT.V_SCROLL);
	}
	
	
	@Override
	protected void checkSubclass() {
	}



	public void init(ModelManager modelManager, Graph graph) {
		GridData gridDataExpandBar = new GridData(SWT.CENTER|SWT.FILL, SWT.TOP|SWT.FILL, false, true); 
		gridDataExpandBar.widthHint = 250;
		this.setLayoutData(gridDataExpandBar);
		//this.setBackground(new Color(this.getDisplay(), 100,0,100));
		this.modelManager = modelManager;
		this.graph = graph;
		//this.setBackground(this.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		
		this.setLayout(new FillLayout(SWT.VERTICAL));

		buildZoomControl(this);
		buildEntityList(this);
		buildLayoutControl(this);
		buildPrintControl(this);
		
		pageBorders.addFigures(graph);
		//buildExportControl();
	}
	
	void refreshEntityTableRows() {
		entityListTable.removeAll();
		Iterators.<Entity>filter(modelManager.getResourceSet().getAllContents(), Entity.class).forEachRemaining(
				entity -> {
					if (filterOut(entity.getName()))
						return;
					TableItem item = new TableItem(entityListTable, SWT.None);
					item.setText(0, "");
					item.setText(1, entity.getName());
					item.setData(ModelManager.ENTITY, entity);
				});
		
		for (int i=0; i<entityListTable.getColumnCount(); i++)
			entityListTable.getColumn(i).pack();
	}
	
	Boolean filterOut(String entityName) {
		if (StringUtils.isNotBlank(packageFilter.getText())) {
			if (!entityName.toUpperCase().contains(packageFilter.getText().toUpperCase()))
				return true;
		}
		if (StringUtils.isNotBlank(entityFilter.getText())) {
			if (!entityName.toUpperCase().contains(entityFilter.getText().toUpperCase()))
				return true;
		}
		return false;
	}
	
	void buildEntityList(ExpandBar bar) {
		Composite composite = new Composite(bar, SWT.None);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns=5;
		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		Label labelPackage = new Label(composite, SWT.None);
		labelPackage.setText("package:");
		new Label(composite, SWT.None);
		Label entityLabel = new Label(composite, SWT.None);
		entityLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		entityLabel.setText("Entity:");
		new Label(composite, SWT.None);
		
		
		packageFilter = new Text(composite, SWT.None);
		packageFilter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		new Label(composite, SWT.None);
		entityFilter = new Text(composite, SWT.None);
		entityFilter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		Button filterButton = new Button(composite, SWT.None);
		filterButton.setText("Filter");
		filterButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		filterButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				refreshEntityTableRows();		
			}
		});
		
		entityListTable = new Table(composite, SWT. MULTI|SWT.V_SCROLL );
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false, 5, 1);
		gd.heightHint=180;
		gd.minimumHeight=180;
		entityListTable.setLayoutData(gd);
		entityListTable.setHeaderVisible(true);
		entityListTable.setLinesVisible(true);
		new TableColumn(entityListTable, SWT.None).setText("Package");
		new TableColumn(entityListTable, SWT.None).setText("Entity");
		
		refreshEntityTableRows();
		
		entityListTable.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				if (null != entityListTable.getSelection() && 1 == entityListTable.getSelection().length) {
					TableItem tableItem = entityListTable.getSelection()[0];
					if (modelManager.contains((Entity)tableItem.getData(ModelManager.ENTITY), graph)) {
						EntityGraphNode node = modelManager.getNode((Entity)tableItem.getData(ModelManager.ENTITY), graph); 
						graph.setSelection(new GraphItem[] {node});
						graph.scrollSmoothTo(node.getLocation().x, node.getLocation().y);
					}
				}
			}
		});
		
		for (int i=0; i<4; i++) new Label(composite, SWT.None);
		Button buttonAdd = new Button(composite, SWT.None);
		buttonAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		buttonAdd.setText("Add Node");
		buttonAdd.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				for (TableItem tableItem:entityListTable.getSelection()) {
					if (!modelManager.contains((Entity)tableItem.getData(ModelManager.ENTITY), graph)) {
						EntityGraphNode node = modelManager.addNode((Entity)tableItem.getData(ModelManager.ENTITY), graph);
						graph.setSelection(new GraphItem[] {node});
						graph.scrollSmoothTo(node.getLocation().x, node.getLocation().y);
					}
				}
			}
		});
		
		ExpandItem item = new ExpandItem (bar, SWT.NONE, 1);
		item.setText("Add Node");
		item.setHeight(300);
		item.setControl(composite);
		item.setExpanded(true);
	}
	
	void buildZoomControl(ExpandBar bar) {
		Composite composite = new Composite(bar, SWT.None);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		gridLayout.horizontalSpacing = 10;
		composite.setLayout(gridLayout);

		Button zoomOut = new Button(composite, SWT.None);
		zoomOut.setText("Out");
		zoomOut.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				graph.getRootLayer().setScale(graph.getRootLayer().getScale() * 0.9d);
				graph.getRootLayer().invalidate();
				
			}
		});
		
		Button zoomIn = new Button(composite, SWT.None);
		zoomIn.setText("In");
		zoomIn.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				graph.getRootLayer().setScale(graph.getRootLayer().getScale() * 1.1d);
				graph.getRootLayer().invalidate();
				
			}
		});
		

		Button showFullPage = new Button(composite, SWT.None);
		showFullPage.setText("Fit Page");
		showFullPage.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				System.out.println ("===========> Fit page ..........");
				System.out.println("Graph Size :" + graph.getSize());
				System.out.println("Root Layer Bounds :" + graph.getRootLayer().getBounds());
				System.out.println("Model Bounds: " + ModelManager.calculateModelBounds(graph));
				System.out.println("Viewport (x,y, width, heigth) : " + graph.getViewport().getClientArea());
				System.out.println("Scale: " + graph.getRootLayer().getScale());

				Dimension pageSize = pageBorders.getDimension(comboPagesize.getText());
				if (buttonLandscape.getSelection())
					pageSize = new Dimension(pageSize.height, pageSize.width);
				double scaleX = ((double)graph.getSize().x)/((double)pageSize.width);
				double scaleY = ((double)graph.getSize().y)/((double)pageSize.height);
				double scale = scaleX>scaleY?scaleY:scaleX;
				System.out.println("Setting scale: " + scale );
				graph.getRootLayer().setScale(scale);
				recalculatePageMarks();
				graph.getRootLayer().invalidate();
				graph.redraw();
				
			}
		});

		/*
		Button showGraph = new Button(composite, SWT.None);
		showGraph.setText("Fit Graph");
		showGraph.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				System.out.println ("===========> Fit graph ..........");
				System.out.println("Graph Size :" + graph.getSize());
				System.out.println("Root Layer Bounds :" + graph.getRootLayer().getBounds());
				System.out.println("Model Bounds: " + ModelManager.calculateModelBounds(graph));
				System.out.println("Viewport (x,y, width, heigth) : " + graph.getViewport().getClientArea());
				System.out.println("Scale: " + graph.getRootLayer().getScale());

				Rectangle modelBounds = ModelManager.calculateModelBounds(graph);
				double scaleX = ((double)graph.getSize().x)/((double)modelBounds.width);
				double scaleY = ((double)graph.getSize().y)/((double)modelBounds.height);
				double scale = scaleX>scaleY?scaleY:scaleX;
				if (scale>1) 
					scale = 1;
				int margin = (int)(50d / scale);
				int x = (int)(scale * modelBounds.x) - margin;
				int y = (int)(scale * modelBounds.y) - margin;
				System.out.println("Setting scale: " + scale + " x: " + x + " y: " + y);
				System.out.println("Viewport (x,y, width, heigth) : " + graph.getViewport().getClientArea());
				graph.getRootLayer().setScale(scale);
				graph.getViewport().setViewLocation(x, y);
				System.out.println("Viewport (x,y, width, heigth) : " + graph.getViewport().getClientArea());
				System.out.println("Scale: " + graph.getRootLayer().getScale());
				graph.getRootLayer().invalidate();
			}
		});
		*/

		
		ExpandItem item = new ExpandItem (bar, SWT.NONE, 0);
		item.setText("Zoom");
		item.setHeight(50);
		item.setControl(composite);
		item.setExpanded(true);
	}
	
	void buildLayoutControl(ExpandBar bar) {
		Composite composite = new Composite(bar, SWT.None);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.horizontalSpacing = 10;
		composite.setLayout(gridLayout);

		Combo combo = new Combo(composite, SWT.DROP_DOWN);
		combo.setItems("Tree Layout", "Spring Layout", "Radial Layout");
		combo.select(0);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.None, true, false, 2, 1));
		
		Label spacingLabel = new Label(composite, SWT.None);
		spacingLabel.setLayoutData(new GridData(SWT.FILL, SWT.None, true, false, 1, 1));
		Button button = new Button(composite, SWT.None);
		button.setLayoutData(new GridData(SWT.None, SWT.None, false, false, 1, 1));
		button.setText("Apply Layout");
		button.addListener(SWT.Selection, new Listener()
		{
		    @Override
		    public void handleEvent(Event event)
		    {
		    	AbstractLayoutAlgorithm algorithm = null;
		    	switch(combo.getSelectionIndex()) {
		    	case 0:
			    	algorithm = new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		    		break;
		    	case 1:
		    		algorithm = new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		    		break;
		    	case 2:
		    		algorithm = new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		    		break;
		    	}
		    	if (null != algorithm ) {
		    		if (null != graph.getSelection() && graph.getSelection().size()>1) 
		    			algorithm.setFilter(new LayoutFilter(graph));
		    		graph.setLayoutAlgorithm(algorithm, true);
			    	modelManager.setDirty(true);
		    	}
		    		
		    }
		});
		
		ExpandItem item = new ExpandItem (bar, SWT.NONE, 2);
		item.setText("Layout");
		item.setHeight(90);
		item.setControl(composite);
		item.setExpanded(true);
	}
	
	void buildExportControl() {
		Button button = new Button(this, SWT.None);
		button.setText("export");
		button.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				SaveAsDialog dialog = new SaveAsDialog(graph.getShell());
				dialog.setBlockOnOpen(true);
				if (Window.OK == dialog.open()) {
					  IPath path = dialog.getResult();
					  if (path != null) {
						  Serializer.exportImage(path, graph);
					  }
				}
			}
		});
	}
	
	void buildPrintControl(ExpandBar bar) {
		Composite composite = new Composite(bar, SWT.None);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.horizontalSpacing = 10;
		composite.setLayout(gridLayout);

		Label labelPageSize = new Label(composite, SWT.None);
		labelPageSize.setText("Page size:" );
		comboPagesize = new Combo(composite, SWT.DROP_DOWN);
		comboPagesize.setItems("A1", "A2", "A3", "A4", "A5", "A6", "A7");
		comboPagesize.select(2);
		comboPagesize.setLayoutData(new GridData(SWT.FILL, SWT.None, true, false, 1, 1));
		comboPagesize.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				recalculatePageMarks();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		buttonPortrait = new Button(composite, SWT.RADIO);
		buttonPortrait.setText("Portrait");
		buttonLandscape = new Button(composite, SWT.RADIO);
		buttonLandscape.setText("Landscape");
		buttonPortrait.setSelection(true);
		buttonPortrait.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				recalculatePageMarks();
			}
		});
		buttonLandscape.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				recalculatePageMarks();
			}
		});
		
		new Label(composite, SWT.None);
		Button buttonPrint = new Button(composite, SWT.None);
		buttonPrint.setText("Print");
		buttonPrint.setLayoutData(new GridData(SWT.RIGHT, SWT.None, false, false, 1, 1));
		
		buttonPrint.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				Serializer.print(graph, buttonPortrait.getSelection());
			}
		});
		
		ExpandItem item = new ExpandItem (bar, SWT.NONE, 2);
		item.setText("Print Options");
		item.setHeight(100);
		item.setControl(composite);
		item.setExpanded(true);
	}

	void recalculatePageMarks() {
		pageBorders.removeFigures(graph);
		pageBorders.initFigures(comboPagesize.getText(), buttonPortrait.getSelection());
		pageBorders.addFigures(graph);
	}
	
}
