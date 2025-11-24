package com.jsantos.metadata.plugin.ui.grapheditor;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LabeledContainer;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.ui.util.ResourceSetLoader;

public class ModelManager {
	public static final String ENTITY = "ENTITY";
	XtextResourceSet rSet;
	boolean dirty = false;
	IDirtyStateEventManager dirtyManager;
	
	public ModelManager(IDirtyStateEventManager dirtyManager) throws CoreException {
		this.dirtyManager = dirtyManager;
	}
	
	public void init(String projectName) throws CoreException {
		rSet = new ResourceSetLoader().buildResourceSet(projectName);
	}
	
	@SuppressWarnings("unchecked")
	public void refresh(Graph graph, String projectName) throws CoreException {
		rSet = new ResourceSetLoader().buildResourceSet(projectName);
		for (EntityGraphNode loopNode:(List<EntityGraphNode>)graph.getNodes()) {
			loopNode.setEntityMissing(true);
			Iterators.<Entity>filter(rSet.getAllContents(), Entity.class).forEachRemaining(
					loopEntity -> {
						if (loopEntity.getName().equalsIgnoreCase(loopNode.getEntity().getName())) {
							loopNode.setEntityMissing(false);
							loopNode.setEntity(loopEntity);
						}
					});
			loopNode.rebuildFigure();
		}
	}
	
	@SuppressWarnings("unchecked")
	public EntityGraphNode addNode(Entity newEntity, Graph graph) {
		if (contains(newEntity, graph))
			return null;
		
		EntityGraphNode newEntityNode = new EntityGraphNode(graph, newEntity);
		
		//newEntityNode.getNodeFigure().add(buildFigure(newEntity));
		//newEntityNode.getNodeFigure().setBounds(new Rectangle(newEntityNode.getLocation(), new Dimension(100,100)));
		//newEntityNode.setData(ENTITY, newEntity);
		//newEntityNode.setData(SHOW_PKS, new Boolean(true));
		//newEntityNode.setData(SHOW_FKS, new Boolean(true));
		//newEntityNode.setData(SHOW_ALL, new Boolean(true));
		
		

		for (GraphNode loopNode:(List<GraphNode>)graph.getNodes()) {
			Entity loopEntity = (Entity)loopNode.getData(ENTITY);
			if (null != loopEntity) {
				for (Attribute attribute:newEntity.getAttributes()) {
					if (null != attribute.getFkto() && attribute.getFkto().getName().equals(loopEntity.getName()))
						new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, newEntityNode, loopNode);
					
				}
				for (Attribute attribute:loopEntity.getAttributes()) {
					if (null != attribute.getFkto() && attribute.getFkto().getName().equals(newEntity.getName()))
						new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, loopNode, newEntityNode);
				}
			}
		}
		
		dirty = true;
		dirtyManager.reportDirtyChange();
		
		return newEntityNode;
	}
	
	
	IFigure buildFigure(Entity newEntity) {
		LabeledContainer labeledContainer = new LabeledContainer();
		labeledContainer.setBorder(new EntityNodeBorder());
		labeledContainer.setLabel(newEntity.getName());
		labeledContainer.setLayoutManager(new org.eclipse.draw2d.FlowLayout(false));
		Label label = new Label();
		labeledContainer.add(label);
		for (Attribute attribute:newEntity.getAttributes()) {
			label = new Label();
			if (attribute.isPk())
				label.setIcon(ImageManager.getPrimaryKeyImage());
			else if (null !=attribute.getFkto())
				label.setIcon(ImageManager.getForeignKeyImage());
			else
				label.setIcon(ImageManager.getRegularFieldImage());
			label.setText(attribute.getName() + " : " + attribute.getType().getName());
			labeledContainer.add(label);
		}
		return labeledContainer;
	}
	
	
	void addAssociatedNodes(GraphNode node, Graph graph) {
		Entity nodeEntity = (Entity)node.getData(ENTITY);
		
			Iterators.<Entity>filter(rSet.getAllContents(), Entity.class).forEachRemaining(
					loopEntity -> {
						for (Attribute attribute:nodeEntity.getAttributes()) {
							if (null != attribute.getFkto() && attribute.getFkto().equals(loopEntity))
									addNode(attribute.getFkto(), graph);
						}
						for (Attribute attribute:loopEntity.getAttributes())
							if (null != attribute.getFkto() && attribute.getFkto().equals(nodeEntity))
								addNode(loopEntity, graph);
					}
			);
		dirty = true;
		dirtyManager.reportDirtyChange();
	}
	
	void removeNode(GraphNode node) {
		node.dispose();
		dirty = true;
		dirtyManager.reportDirtyChange();
	}

	@SuppressWarnings("unchecked")
	boolean contains(Entity entity, Graph graph) {
		for (EntityGraphNode loopNode:(List<EntityGraphNode>)graph.getNodes()) 
			if (entity.getName().equalsIgnoreCase(loopNode.getEntity().getName()))
				return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	EntityGraphNode getNode(Entity entity, Graph graph) {
		for (EntityGraphNode loopNode:(List<EntityGraphNode>)graph.getNodes()) 
			if (entity.getName().equalsIgnoreCase(loopNode.getEntity().getName()))
				return loopNode;
		return null;
	}

	XtextResourceSet getResourceSet() {
		return rSet;
	}
	


	@SuppressWarnings("unchecked")
	EntityGraphNode getNodeForFigure(IFigure fig, Graph graph) {
		for (GraphNode loopNode:(List<GraphNode>)graph.getNodes()) {
			if (loopNode.getNodeFigure().equals(fig))
				return (EntityGraphNode)loopNode;
			
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	GraphNode getNodeForEntity(Entity entity, Graph graph) {
		for (GraphNode loopNode:(List<GraphNode>)graph.getNodes()) {
			if (entity.equals(loopNode.getData(ENTITY)))
				return loopNode;
		}		
		return null;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
		dirtyManager.reportDirtyChange();
	}
	
	static public Rectangle calculateModelBounds(Graph graph) {
		Point topLeft = new Point();
		topLeft.x = Integer.MAX_VALUE;
		topLeft.y = Integer.MAX_VALUE;

		Point bottomRight = new Point();
		bottomRight.x = Integer.MIN_VALUE;
		bottomRight.y = Integer.MIN_VALUE;
		
		for (GraphNode loopNode:(List<GraphNode>)graph.getNodes()) {
			if (topLeft.x > loopNode.getLocation().x)
				topLeft.x = loopNode.getLocation().x;
			if (topLeft.y > loopNode.getLocation().y)
				topLeft.y = loopNode.getLocation().y;
			if (bottomRight.x < loopNode.getLocation().x + loopNode.getSize().width)
				bottomRight.x = loopNode.getLocation().x  + loopNode.getSize().width;
			if (bottomRight.y < loopNode.getLocation().y + loopNode.getSize().height)
				bottomRight.y = loopNode.getLocation().y + loopNode.getSize().height;
		}		
		return new Rectangle(topLeft, bottomRight);
	}
}
