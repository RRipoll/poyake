package com.jsantos.gui.zkcomponent;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

import com.jsantos.common.util.ListValues;
import com.jsantos.custom.customfield.IMTComponent;
/**
 * @author javier santos
 */
public class BootstrapFocusEventListener implements EventListener<Event>{

	@Override
	public void onEvent(Event event) throws Exception {
		if (Events.ON_CHANGE.equals(event.getName())) 
			manageContent(event);
		if (Events.ON_SELECT.equals(event.getName()))
			manageContent(event);
		if (Events.ON_FOCUS.equals(event.getName()))
			setFocused(event);
		if (Events.ON_BLUR.equals(event.getName())) 
			removeFocused(event);
	}

	public void manageContent(Event event) {
		try {
			((IMTComponent)event.getTarget()).validate(event);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (hasValue(event))
			setFocused(event);
		else
			removeFocused(event);
	}
	
	public boolean hasValue(Event event) {
		if (event.getTarget() instanceof IMTComponent) {
			Object value=((IMTComponent)event.getTarget()).getValue();
			if(null==value || value.toString().isEmpty() || (value instanceof ListValues && ((ListValues)value).isEmpty())
					|| (value instanceof Boolean && !((Boolean)value)))
				return false;
		}
		return true;
	}
	
	public void setFocused(Event event) {
		Div div = findFormLine(event.getTarget());
		if (null != div) {
			div.setClass(div.getSclass().replace("focused", ""));
			div.setClass(div.getSclass()  + " focused");
		}
	}

	public void removeFocused(Event event) {
		if (!hasValue(event)) {
			Div div = findFormLine(event.getTarget());
			if (null != div)
				div.setClass(div.getSclass().replace("focused", ""));
	
		}
	}
	
	public static boolean setVisible(boolean visible,Component input) {
		Component comp=null;
		try {
			comp=findFormLine(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		comp=input.getParent();
		comp.setVisible(visible);
		return visible;
		
	}

	
	static Div  findFormLine(Component input) {
		for (Component c=input.getParent(); c !=null; c=c.getParent()) {
			if (c instanceof org.zkoss.zul.Div) 
				if (null !=((org.zkoss.zul.Div)c).getSclass() && ((org.zkoss.zul.Div)c).getSclass().contains("form-line"))
					return (org.zkoss.zul.Div)c;
			if (c instanceof org.zkoss.zhtml.Div) 
				if (null !=((org.zkoss.zhtml.Div)c).getSclass() && ((org.zkoss.zhtml.Div)c).getSclass().contains("form-line"))
					;//throw new RuntimeException("the parent of the input control should be org.zkoss.zul.Div and not org.zkoss.zhtml.Div");

		}
		
		return null;
	}
}
