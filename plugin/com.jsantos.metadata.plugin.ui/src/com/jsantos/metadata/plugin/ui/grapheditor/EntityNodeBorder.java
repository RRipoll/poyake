package com.jsantos.metadata.plugin.ui.grapheditor;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GroupBoxBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

public class EntityNodeBorder extends GroupBoxBorder{
	
	
	@Override
	protected Insets calculateInsets(IFigure figure) {
		return new Insets(4,4,4,4);
	}

	@Override
	public void paint(IFigure figure, Graphics g, Insets insets) {
		tempRect.setBounds(getPaintRectangle(figure, insets));
		if (tempRect.getTopLeft().x==1)
			System.out.println(tempRect);
		Rectangle r = tempRect;
		if (r.isEmpty())
			return;

		int y = tempRect.y + getTextExtents(figure).height;
		g.drawLine(tempRect.getTopLeft().x, y+1,  tempRect.getTopRight().x, y+1);

		Rectangle textLoc = new Rectangle(r.getTopLeft(),
				getTextExtents(figure));
		

		r.crop(new Insets(getTextExtents(figure).height / 2));
		//FigureUtilities.paintEtchedBorder(g, r);

		if (tempRect.getSize().width > getTextExtents(figure).width)
			textLoc.x += (tempRect.getSize().width -  getTextExtents(figure).width)/2;
		//textLoc.x += getInsets(figure).left;
		g.setFont(getFont(figure));
		g.setForegroundColor(getTextColor());
		g.clipRect(textLoc);
		g.fillText(getLabel(), textLoc.getTopLeft());
	}

}
