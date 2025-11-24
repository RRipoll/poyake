package com.jsantos.metadata.plugin.ui.grapheditor.serialization;

import java.io.Serializable;

import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.ui.grapheditor.EntityGraphNode;
import com.jsantos.metadata.plugin.ui.grapheditor.ModelManager;

public class SerializableNodeInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String entityFQN;
	int x;
	int y;
	Boolean showPks = true;
	Boolean showFks = true;
	Boolean showNonKeyFields = true;

	public SerializableNodeInfo() {
	}


	public SerializableNodeInfo(EntityGraphNode node) {
		entityFQN = ((Entity)node.getData(ModelManager.ENTITY)).getName();
		x = node.getLocation().x;
		y = node.getLocation().y;
		showPks = node.getShowPks();
		showFks = node.getShowFks();
		showNonKeyFields = node.getShowNonKeyFields();
	}
	
	public String toString(){
		return entityFQN + " (" + x + "," + y + ")";
	}

	public String getEntityFQN() {
		return entityFQN;
	}

	public void setEntityFQN(String entityFQN) {
		this.entityFQN = entityFQN;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
}
