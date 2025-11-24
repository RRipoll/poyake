package com.jsantos.gui.form.controller;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.gui.form.FormFieldListManager;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.form.IMTForm;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DetachedRecord;


public class MTUpdateScreenController   implements IMTForm{
	protected MTForm mtForm;
	
	
	public MTUpdateScreenController(DetachedRecord dr, Component parent){
		FormZulBuilder zulBuilder = new FormZulBuilder();
		
		
		zulBuilder.addFieldsToZul(new FormFieldListManager().add(dr).getFields(),EditMode.UPDATE);
		
		
		mtForm = new MTForm(zulBuilder.buildForm(parent), EditMode.UPDATE,null).init();
		
		mtForm.setHeaderLabel(Zklabel.getLabel(dr.getTable().getTableName()));
		
		mtForm.addDetachedRecord(dr);
		mtForm.getSaveButton().addEventListener(Events.ON_CLICK, this::save);
		if (null != mtForm.getCancelButton())
			mtForm.getCancelButton().addEventListener(Events.ON_CLICK, this::closeWindow);
	}
	
	public boolean doModal(){
		((Window)mtForm.getFormComponent()).doModal();
		return isSaved();
	}
	
	
	public void closeWindow(Event event) {
		mtForm.getFormComponent().detach();
	}
	
	
	
	protected void save(Event event) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("MTEditScreenControllerTransaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = MainDb.getTxManager().getTransaction(def);
		try {
			mtForm.save();
			MainDb.getTxManager().commit(status);
			Clients.showNotification(" Updated Success !!!", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			//Messagebox.show("Success !!!", "Success !!!", Messagebox.OK, Messagebox.INFORMATION);
			closeWindow(event);
		}
		catch (Throwable ex) {
			MainDb.getTxManager().rollback(status);
		    throw new RuntimeException(ex);
		}
        
	}
	
	
	public boolean isSaved() {
		return mtForm.isSaved();
	}

	

	@Override
	public MTForm getMtForm() {
		
		return mtForm;
	}

	@Override
	public void setMtForm(MTForm form) {
		mtForm=form;
		
	}
}