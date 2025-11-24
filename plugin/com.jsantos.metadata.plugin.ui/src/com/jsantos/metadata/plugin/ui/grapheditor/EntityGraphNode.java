package com.jsantos.metadata.plugin.ui.grapheditor;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LabeledContainer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;

import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;

public class EntityGraphNode extends GraphNode{
	Boolean showPks = true;
	Boolean showFks = true;
	Boolean showNonKeyFields = true;
	Boolean entityMissing = false;
	
	LabeledContainer labeledContainer;
	
	public EntityGraphNode(Graph graph, Entity entity) {
		super(graph, SWT.NONE, entity);
		setBackgroundColor(new Color(graph.getDisplay(), 255, 255, 200));
		setData(ModelManager.ENTITY, entity);
		buildFigure();
		getNodeFigure().add(labeledContainer);
		recalculateSize();
		
	}

	void recalculateSize() {
		setSize(labeledContainer.getPreferredSize().width+10, labeledContainer.getPreferredSize().height+10);
	}
	
	
	public Entity getEntity() {
		return (Entity)getData();
	}
	
	public void setEntity(Entity entity) {
		setData(entity);
	}

	void buildFigure() {
		labeledContainer = new LabeledContainer();
		labeledContainer.setBorder(new EntityNodeBorder());
		labeledContainer.setLabel(getEntity().getName());
		labeledContainer.setLayoutManager(new org.eclipse.draw2d.FlowLayout(false));
		Label label = new Label();
		labeledContainer.add(label);
		for (Attribute attribute:getEntity().getAttributes()) {
			label = new Label();
			boolean show = false;
			if (attribute.isPk()) {
				if (showPks) {
					label.setIcon(ImageManager.getPrimaryKeyImage());
					show = true;
				}
			}
			else if (null !=attribute.getFkto() ) {
				if (showFks) {
					label.setIcon(ImageManager.getForeignKeyImage());
					show = true;
				}
			}
			else if (showNonKeyFields) {
				label.setIcon(ImageManager.getRegularFieldImage());
				show = true;
			}
			if (show) {
				label.setText(attribute.getName() + " : " + attribute.getType().getName());
				labeledContainer.add(label);
			}
		}
	}

	void rebuildFigure() {
		getNodeFigure().remove(labeledContainer);
		labeledContainer.setParent(null);
		buildFigure();
		getNodeFigure().add(labeledContainer);
		getNodeFigure().invalidate();
		recalculateSize();
	}
	
	public Boolean getShowPks() {
		return showPks;
	}

	public void setShowPks(Boolean showPks) {
		this.showPks = showPks;
		rebuildFigure();
	}

	public Boolean getShowFks() {
		return showFks;
	}

	public void setShowFks(Boolean showFks) {
		this.showFks = showFks;
		rebuildFigure();
	}

	public Boolean getShowNonKeyFields() {
		return showNonKeyFields;
	}

	public void setShowNonKeyFields(Boolean showNonKeyFields) {
		this.showNonKeyFields = showNonKeyFields;
		rebuildFigure();
	}

	public Boolean getEntityMissing() {
		return entityMissing;
	}

	public void setEntityMissing(Boolean entityMissing) {
		this.entityMissing = entityMissing;
	}

	

}
