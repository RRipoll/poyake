package com.jsantos.auditimmo.screen.folder.children;

import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;

import com.jsantos.auditimmo.orm.FileTemplateLoader;
import com.jsantos.gui.form.EditMode;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.metadata.eva.NoteDTO;
import com.jsantos.metadata.general.EnuTemplateType;
import com.jsantos.orm.DBTransaction;
import com.jsantos.orm.fileexport.service.FileExportService;
import com.jsantos.orm.fileexport.service.TemplateData;

public class CreateNote implements EventListener<Event>{
	protected MTForm mtForm;
	protected Integer folderId;
	
	public Component buildEditorScreen(Integer folderId,Component parent){
		this.folderId=folderId;
		try {
			parent.getChildren().clear();
			
			/*
			FileExportService fes= new FileExportService(new FileTemplateLoader());
			TemplateData templateData= new TemplateData();
			templateData.setTemplateTypeId(EnuTemplateType.TEST);
			templateData.setData(data);
			fes.generatePDF(templateData);
			*/
			
			FormZulBuilder zulBuilder = new FormZulBuilder();
			zulBuilder.setZulURI("/screen/folder/children/create_note.zul");
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
				NoteDTO note = new NoteDTO();
				
				ZulDataWirer.readFormFieldValues(note, mtForm.getFormComponent());
				note.setFolderId(folderId);
				
				note.insert();
	
			}
		}.run();
		
		Messagebox.show("Note Created","Success !!!",Messagebox.OK, Messagebox.INFORMATION);
		mtForm.getFormComponent().detach();
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

}
