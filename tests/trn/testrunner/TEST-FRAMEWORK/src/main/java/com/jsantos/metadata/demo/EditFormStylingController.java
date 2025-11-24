package com.jsantos.metadata.demo;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.jsantos.orm.mt.MTTable;

public class EditFormStylingController extends GenericForwardComposer<Component> {
	private static final long serialVersionUID = 1L;
	public Component comp;
	Combobox entitiesCombo;
	Combobox langsCombo;
	MTTable mtTable;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception{
		this.comp=comp;
		comp.getFellow("ButtonOK").addEventListener(Events.ON_CLICK, this);
		
	}

	@Override
	public void onEvent(Event evt) throws Exception {
		String message = "Nombre: " + ((Textbox)comp.getFellow("nombre")).getText() + " " + ((Textbox)comp.getFellow("apellido")).getText() + "\r\n";
		message += ((Textbox)comp.getFellow("direccion")).getText();
		Messagebox.show(message);
		super.onEvent(evt);
	}

	
	
}
