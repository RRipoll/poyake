package com.jsantos.metadata.plugin.ui.grapheditor;

import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.layouts.Filter;
import org.eclipse.zest.layouts.LayoutItem;

public class LayoutFilter implements Filter{

	Graph graph;
	
	public LayoutFilter(Graph graph) {
		this.graph = graph;
	}

	@Override
	public boolean isObjectFiltered(LayoutItem item) {
		System.out.println(item.getGraphData() + ":" + graph.getSelection().contains(item.getGraphData()));
		return !graph.getSelection().contains(item.getGraphData());
	}

}
