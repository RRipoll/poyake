package com.jsantos.metadata.plugin.ui.grapheditor.pagination;

import java.util.LinkedHashMap;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.zest.core.widgets.Graph;

public class PageBorders {
	// Dimensions are for 300dpi without bleed area
	LinkedHashMap<String, Dimension> pageSizes = new LinkedHashMap<>();
	
	Boolean landscape = false;
	
	PageBorderFigure top;
	PageBorderFigure bottom;
	PageBorderFigure left;
	PageBorderFigure right;
	
	public PageBorders() {
		pageSizes.put("A1", new Dimension(7016,9933));
		pageSizes.put("A2", new Dimension(4961,7016));
		pageSizes.put("A3", new Dimension(3508,4961));
		pageSizes.put("A4", new Dimension(2480,3508));
		pageSizes.put("A5", new Dimension(1748,2480));
		pageSizes.put("A6", new Dimension(1240,1748));
		pageSizes.put("A7", new Dimension(874,1240));
		initFigures("A4", true);
	}
	
	public Dimension getDimension(String pageSize) {
		return pageSizes.get(pageSize);
	}
	
	public void initFigures(String pageSize, Boolean portrait) {
		Dimension dimension = pageSizes.get(pageSize);
		if (!portrait) dimension = new Dimension(dimension.height, dimension.width);
		top = new PageBorderFigure(true);
		top.setBounds(new Rectangle(1,1,dimension.width,7));
		left = new PageBorderFigure(false);
		left.setBounds(new Rectangle(1,1,7,dimension.height));
		bottom = new PageBorderFigure(true);
		bottom.setBounds(new Rectangle(1, dimension.height - PageBorderFigure.BOX_SIZE, dimension.width, 7));
		right = new PageBorderFigure(false);
		right.setBounds(new Rectangle(dimension.width - PageBorderFigure.BOX_SIZE, 1, 7, dimension.height));
		
	}
	
	public void removeFigures(Graph g) {
		g.getRootLayer().remove(top);
		g.getRootLayer().remove(left);
		g.getRootLayer().remove(bottom);
		g.getRootLayer().remove(right);
	}
	
	public void addFigures(Graph g) {
		g.getRootLayer().add(top);
		g.getRootLayer().add(left);
		g.getRootLayer().add(bottom);
		g.getRootLayer().add(right);
	}
}
