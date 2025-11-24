package com.jsantos.gui.objectselector;

import org.zkoss.zhtml.Button;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;

import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
/**
 * @author raul ripoll
 * @author javier santos
 */
public class ObjectDescriptionItem extends Div{

	
	private static final long serialVersionUID = 1L;
	Div body;
	ListValues<IDetachedRecord>drs;
	IDetachedRecord dr;
	
	
	
	
	
	
	public ObjectDescriptionItem(IDetachedRecord dr,MTField mtField, Component parent,ListValues<IDetachedRecord>newDrs,boolean readOnly) {
		super();
		drs=newDrs;
		this.dr = dr;
		this.setSclass("card");
		body=new Div();
		body.setParent(this);
		body.setSclass("card-body");
		this.setParent(parent);
		
		
		String description=MultipleHelper.getDescription(dr, mtField,  LocaleFactory.getProvider().getLocale());
		
		
		
			A taglabel= new A();
			
			taglabel.setParent(body);
				Text text= new Text(description);
				text.setParent(taglabel);
					
				if(!readOnly) {
					Button x= new Button();
					x.setSclass("close");
					x.setParent(body);
					x.addEventListener(Events.ON_CLICK, this::remove);
					new Text("x").setParent(x);
				}
		}

	public void remove(Event event) {
		drs.remove(dr);
		event.stopPropagation();
		Events.sendEvent(Events.ON_CHANGE, this, "remove");
	}
	public void show(Event event) {
		
	}
	
}
