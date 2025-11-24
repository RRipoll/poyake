package org.zkoss.admin;

import org.apache.commons.lang.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;

public class Test extends GenericForwardComposer<Component>{

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		comp.addEventListener(Events.ON_FOCUS, this);
		comp.addEventListener(Events.ON_BLUR, this);
		super.doAfterCompose(comp);
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if (Events.ON_CHANGE.equals(event.getName())) 
			manageContent(event.getTarget());
		
		if (Events.ON_FOCUS.equals(event.getName()))
			setFocused(event.getTarget());
		
		if (Events.ON_BLUR.equals(event.getName())) 
			removeFocused(event.getTarget());
	}

	public void manageContent(Component target) {
		if (hasValue(target))
			setFocused(target);
		else
			removeFocused(target);
	}
	
	public boolean hasValue(Component target) {
		if (target instanceof Textbox) {
			if (StringUtils.isNotBlank(((Textbox)target).getValue()))
				return true;
		}
		if (target instanceof Intbox) {
			if (null !=((Intbox)target).getValue())
				return true;
		}
		return false;
	}
	
	public void setFocused(Component target) {
		Div div = findFormLine(target);
		if (null != div)
			div.setClass(div.getSclass()  + " focused");
	}

	public void removeFocused(Component target) {
		if (!hasValue(target)) {
			Div div = findFormLine(target);
			if (null != div)
				div.setClass(div.getSclass().replace("focused", ""));
		}
	}
	
	
	Div findFormLine(Component input) {
		for (Component c=input.getParent(); c !=null; c=c.getParent())
			if (c instanceof Div)
				if (((Div)c).getSclass().contains("form-line"))
					return (Div)c;
		return null;
	}
}
