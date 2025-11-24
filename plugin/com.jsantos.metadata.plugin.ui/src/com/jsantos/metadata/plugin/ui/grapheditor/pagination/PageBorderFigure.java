package com.jsantos.metadata.plugin.ui.grapheditor.pagination;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class PageBorderFigure extends Figure{
	public static final int BOX_SIZE = 6;
	Boolean horizontal;
	
	
	public PageBorderFigure(Boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	@Override
	public void paint(Graphics graphics) {
        Rectangle area = getClientArea();
        
        if (horizontal)
        	graphics.drawLine(area.x + BOX_SIZE, area.y + area.height/2, area.x + area.width - BOX_SIZE -1, area.y + area.height/2);
        else
        	graphics.drawLine(area.x + area.width/2, area.y + BOX_SIZE , area.x + area.width/2, area.y + area.height - BOX_SIZE -1);
        
        if (horizontal) {
        	graphics.drawRectangle(area.x , area.y + area.height/2 -3, 6,6);
        	graphics.drawRectangle(area.x + area.width - BOX_SIZE -1, area.y + area.height/2 -3, 6,6);
        }
		super.paint(graphics);
	}

}
