package com.jsantos.metadata.plugin.ui.grapheditor.operations;

import java.io.Serializable;

import org.eclipse.zest.core.widgets.GraphNode;

import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.ui.grapheditor.ModelManager;

public class Operation implements Serializable{
	private static final long serialVersionUID = 1L;
	
	static final String TYPE_LAYOUT = "LAYOUT";
	static final String TYPE_ADD_NODE = "ADD_NODE";
	static final String TYPE_REMOVE_NODE = "REMOVE_NODE";
	static final String TYPE_ADD_ASSOCIATED_NODES = "ADD_ASSOCIATED_NODES";
	
	String type;
	String entityFQN;
	
	public Operation(String type, GraphNode graphNode) {
		this.type = type;
		if (null != graphNode) {
			Entity entity = (Entity)graphNode.getData(ModelManager.ENTITY);
			this.entityFQN = entity.getName();
		}
	}
	
	public String toString() {
		return type + ":" + entityFQN;
	}
}
