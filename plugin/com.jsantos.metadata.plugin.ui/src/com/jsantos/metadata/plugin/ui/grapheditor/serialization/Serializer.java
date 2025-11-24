package com.jsantos.metadata.plugin.ui.grapheditor.serialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;

import com.google.common.collect.Iterators;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.ui.grapheditor.EntityGraphNode;
import com.jsantos.metadata.plugin.ui.grapheditor.ModelManager;
import com.jsantos.metadata.plugin.ui.util.ResourceSetLoader;

public class Serializer {

	static public InputStream serialize(Graph graph) throws IOException {
		ArrayList<SerializableNodeInfo> list = new ArrayList<>();
		for (EntityGraphNode loopNode:(List<EntityGraphNode>)graph.getNodes()) {
			list.add(new SerializableNodeInfo(loopNode));
		}		
		
		/*
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream( baos );
		oos.writeObject(list);
		oos.close();
		*/
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(list);
		//String jsonStr = new ObjectMapper().writeValueAsString(list);
		return new ByteArrayInputStream(jsonStr.getBytes(StandardCharsets.UTF_8));
	}


	static public ArrayList<SerializableNodeInfo> deserialize(InputStream in) throws IOException, ClassNotFoundException {
		
		ArrayList<SerializableNodeInfo> list = new ArrayList<>();
		try {
			ArrayList<LinkedTreeMap> treeList = new Gson().fromJson(new InputStreamReader(in), ArrayList.class);
			for (LinkedTreeMap map:treeList) {
				SerializableNodeInfo info = new SerializableNodeInfo();
				info.setEntityFQN((String)map.get("entityFQN"));
				info.setX(((Double)map.get("x")).intValue());
				info.setY(((Double)map.get("y")).intValue());
				info.showPks = (Boolean)map.get("showPks");
				info.showFks = (Boolean)map.get("showFks");
				info.showNonKeyFields = (Boolean)map.get("showNonKeyFields");
				list.add(info);
			}
			return list;
		}
		catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		
		/*
		ObjectInputStream ois = new ObjectInputStream( in);
		final ArrayList<SerializableNodeInfo> list  = (ArrayList<SerializableNodeInfo>)ois.readObject();
		ois.close();
		*/
	}
	
	static public void applyList(ArrayList<SerializableNodeInfo> list, ModelManager modelManager, Graph graph, String sProject) throws CoreException {
		XtextResourceSet rSet = new ResourceSetLoader().buildResourceSet(sProject);
		Iterators.<Entity>filter(rSet.getAllContents(), Entity.class).forEachRemaining(
				loopEntity -> {
					try {
						for (SerializableNodeInfo info:list) {
							if (loopEntity.getName().equalsIgnoreCase(info.entityFQN)) {
								EntityGraphNode node = modelManager.addNode(loopEntity, graph); 
								if (null !=node) {
									//IFigure fig = node.getNodeFigure();
									node.setLocation(info.getX(), info.getY());
									node.setShowPks(info.showPks);
									node.setShowFks(info.showFks);
									node.setShowNonKeyFields(info.showNonKeyFields);
								}								
							}
						}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
		);
		
	}
	
	static public void exportImage(IPath path, Graph graph){
		GC gc = new GC(graph);
		Rectangle bounds = graph.getBounds();
		bounds.add(new Rectangle(0, 0, 2000, 2000));
		Image image = new Image(graph.getDisplay(), bounds);
		try {
		    gc.copyArea(image, 0, 0);
		    ImageLoader imageLoader = new ImageLoader();
		    imageLoader.data = new ImageData[] { image.getImageData() };
		    IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		    System.out.println(file.getRawLocation().toOSString());
		    System.out.println(file.getFullPath().toOSString());
		    imageLoader.save(file.getRawLocation().toOSString(), SWT.IMAGE_PNG);
		    

		} finally {
		    image.dispose();
		    gc.dispose();
		}		
		
		
	}

	
	static public void print(Graph graph, Boolean portrait) {
		if (null == graph)
			return;

		PrintDialog printDialog = new PrintDialog(graph.getShell(), SWT.NONE);
		printDialog.setPrintToFile(true);
		PrinterData printerData = new PrinterData();
		printerData.orientation = portrait?PrinterData.PORTRAIT:PrinterData.LANDSCAPE;
		printDialog.setPrinterData(printerData);
		printerData = printDialog.open();
		
	    if (null != printerData) {
			Printer printer = new Printer(printerData);
			printer.startJob("Poyake Graph " + graph.hashCode());
			System.out.println(printer.isAutoScalable());
	
			GC gc = new GC(printer);
			SWTGraphics g = new SWTGraphics(gc);
			//g.scale(4d);
			for (GraphNode loopNode:(List<GraphNode>)graph.getNodes()) {
				loopNode.getNodeFigure().paint(g);
			}	  
			for (GraphConnection connection: (List<GraphConnection>) graph.getConnections()) {
				connection.getConnectionFigure().paint(g);
				//LayoutRelationship lr  = connection.getLayoutRelationship();
			}
			
			g.dispose();
			gc.dispose();
			printer.endJob();
			printer.dispose();
	    }
	}
}
