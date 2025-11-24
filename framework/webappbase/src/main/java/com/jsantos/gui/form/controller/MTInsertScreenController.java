package com.jsantos.gui.form.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.form.FormFieldListManager;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.form.IMTForm;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.orm.DBTransaction;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.mt.MTTable;

public class MTInsertScreenController   implements IMTForm{
	protected MTForm mtForm;
	protected String mainEntityName = null;
	protected Window modalWindow;
	
	
	public MTInsertScreenController(Component parent, MTTable... tables) {
		FormFieldListManager listManager = new FormFieldListManager();
		for (MTTable table:tables)
			listManager.add(table);
		FormZulBuilder zulBuilder = new FormZulBuilder();
		zulBuilder.addFieldsToZul(listManager.getFields(),EditMode.INSERT);
		
		mtForm = new MTForm(zulBuilder.buildForm(parent), EditMode.INSERT,tables).init();
		
		mtForm.getSaveButton().addEventListener(Events.ON_CLICK, this::save);
		mainEntityName = Zklabel.getLabel(tables[0].getTableName(),LocaleFactory.getProvider().getLocale());
		mtForm.setHeaderLabel("Create " + mainEntityName);
		if (null != mtForm.getCancelButton())
			mtForm.getCancelButton().addEventListener(Events.ON_CLICK, this::closeWindow);
	}

	public MTInsertScreenController(Component parent, String zul, MTTable... tables){
		FormZulBuilder zulBuilder = new FormZulBuilder();
		zulBuilder.setZulURI(zul);
		mtForm = new MTForm(zulBuilder.buildForm(parent), EditMode.INSERT,tables).init();
		
		mtForm.getSaveButton().addEventListener(Events.ON_CLICK, this::save);
		if (null != mtForm.getCancelButton())
			mtForm.getCancelButton().addEventListener(Events.ON_CLICK, this::closeWindow);
		mainEntityName = Zklabel.getLabel(tables[0].getTableName(),LocaleFactory.getProvider().getLocale());
		ZulDataWirer.initializeFieldLabels(parent);
		//ZulDataWirer.initializeFieldDefaults(mtForm.getFormComponent());		
	}

	public void closeWindow(Event event) {
		if(null!= modalWindow)
			modalWindow.detach();
		//if(((Window)mtForm.getFormComponent()).inModal())
			//mtForm.getFormComponent().detach();
		//else 
		else if(mtForm.getFormComponent() instanceof Window)
			mtForm.getFormComponent().detach();
		else if (mtForm.getFormComponent().getParent() instanceof Window)
			mtForm.getFormComponent().getParent().detach();
		else mtForm.getFormComponent().detach();
	}

	public boolean doModal(){
		if (mtForm.getFormComponent() instanceof Window) {
			modalWindow=(Window) mtForm.getFormComponent();
			((Window)mtForm.getFormComponent()).doModal();
			((Window)mtForm.getFormComponent()).detach();;
		}else {
			modalWindow = new Window();
			modalWindow.setBorder(false);
			modalWindow.setClosable(false);
			modalWindow.setParent(DesktopHelper.getRootComponent());
			modalWindow.appendChild(mtForm.getFormComponent());
			modalWindow.doModal();
		}
			
		return isSaved();
	}
	
	public MTForm getMtForm() {
		return mtForm;
	}

	
	
	protected void save(Event event){
		
		
		try {
			new DBTransaction() {
				@Override
				protected void exec() {
					mtForm.save();
				}
			}.run();
			Clients.showNotification(mainEntityName + " Created Success !!!", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			//Messagebox.show(mainEntityName + " Created","Success !!!",Messagebox.OK, Messagebox.INFORMATION);
		    closeWindow(event);
		} catch (Throwable ex) {
			if((ex instanceof ConstraintsException) )
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
//				Messagebox.show(mainEntityName + "Not Created"," Error !!!",Messagebox.OK, Messagebox.ERROR);
		}
		
	}
	
	public boolean isSaved() {
		return mtForm.isSaved();
	}

	@Override
	public void setMtForm(MTForm form) {
		mtForm=form;
		
	}

	

}
