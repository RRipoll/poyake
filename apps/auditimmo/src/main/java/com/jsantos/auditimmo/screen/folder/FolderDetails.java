package com.jsantos.auditimmo.screen.folder;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Window;

import com.jsantos.auditimmo.screen.evaluation.CreateEvaluation;
import com.jsantos.auditimmo.screen.folder.children.CreateMessage;
import com.jsantos.auditimmo.screen.folder.children.CreateNote;
import com.jsantos.auditimmo.screen.folder.children.CreateService;
import com.jsantos.gui.objectselector.popup.IDetachedRecordAcceptor;
import com.jsantos.gui.objectselector.popup.ObjectSelectorPopup;
import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.DetachedRecord;

public class FolderDetails implements EventListener<Event>, IDetachedRecordAcceptor{
	int folderId;
	Component parent;
	Component comp = null;
	
	public FolderDetails(int pk, Component parent) {
		this.folderId=pk;
		this.parent = parent;
	}
	
	public void buildAndShowComponent() throws Exception {
		comp = Executions.createComponents("/screen/folder/details.zul", parent, null);
		setDetails(comp);
		((Window)comp).doModal();
	}
	
	public void reload() throws Exception {
		comp.detach();
		buildAndShowComponent();
	}
	
	public void setDetails(Component comp) throws Exception {
		
		comp.getFellow("DETAILS_BUTTON_CLOSE").addEventListener(Events.ON_CLICK, this::closeWindow);
		comp.getFellow("BUTTON_CREATE_LINK").addEventListener(Events.ON_CLICK, this::createLink);
		comp.getFellow("BUTTON_CREATE_EVALUATION").addEventListener(Events.ON_CLICK, this::createEvaluation);
		comp.getFellow("BUTTON_CREATE_SERVICE").addEventListener(Events.ON_CLICK, this::createService);
		comp.getFellow("BUTTON_CREATE_APPOINTMENT").addEventListener(Events.ON_CLICK, this::createApointment);
		comp.getFellow("BUTTON_CREATE_NOTE").addEventListener(Events.ON_CLICK, this::createNote);
		comp.getFellow("BUTTON_CREATE_MESSAGE").addEventListener(Events.ON_CLICK, this::createMessage);
	
	}

	void createEvaluation(Event evt) {
		new CreateEvaluation().buildAndShow();
	}
	

	void createService(Event evt) {
		((Window)new CreateService().buildEditorScreen(folderId, parent)).doModal();
		}

	void createApointment(Event evt) {
		
	}
	
	void createNote(Event evt) {
		((Window)new CreateNote().buildEditorScreen(folderId, parent)).doModal();
	}
	
	void createMessage(Event evt) {
		((Window)new CreateMessage().buildEditorScreen(folderId, parent)).doModal();
	}
	



	
	
	
	void createLink(Event evt) {
		new ObjectSelectorPopup(MT.CONTACT, this::acceptDetachedRecord).doModal();
	}

	@Override
	public void acceptDetachedRecord(DetachedRecord dr) {
		System.out.println(dr);
		
	}
	
	void closeWindow(Event event) {
		comp.detach();
	}

	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
