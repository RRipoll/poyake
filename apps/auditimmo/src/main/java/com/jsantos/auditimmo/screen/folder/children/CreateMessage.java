package com.jsantos.auditimmo.screen.folder.children;

import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;

import com.jsantos.gui.form.EditMode;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.metadata.eva.MessageDTO;
import com.jsantos.orm.DBTransaction;

public class CreateMessage implements EventListener<Event>{
	protected MTForm mtForm;
	protected Integer folderId;
	
	public Component buildEditorScreen(Integer folderId,Component parent){
		this.folderId=folderId;
		try {
			parent.getChildren().clear();

			FormZulBuilder zulBuilder = new FormZulBuilder();
			zulBuilder.setZulURI("/screen/folder/children/create_message.zul");
			Component form=zulBuilder.buildForm(parent);
			mtForm = new MTForm(form, EditMode.INSERT,null);
			mtForm.getSaveButton().addEventListener(Events.ON_CLICK, this);
			mtForm.getCancelButton().addEventListener(Events.ON_CLICK, this::onCancelButton);
			return form;
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
	
	}
	
	void onCancelButton(Event evt) {
		mtForm.getFormComponent().detach();
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		if(event.getTarget().equals(mtForm.getSaveButton())){
			save();
		}
	}
	
	public void save() throws SQLException{
		new DBTransaction() {
			@Override
			protected void exec() {
				MessageDTO message = new MessageDTO();
				
				ZulDataWirer.readFormFieldValues(message, mtForm.getFormComponent());
				message.setFolderId(folderId);
				
				message.insert();
	
			}
		}.run();
		
		Messagebox.show("Message Created","Success !!!",Messagebox.OK, Messagebox.INFORMATION);
		mtForm.getFormComponent().detach();
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

}
