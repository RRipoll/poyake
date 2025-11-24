package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event.EventCreatedController;
import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.FieldList;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class EventFolder  implements IFolder{
	 
	 String description;
	 Integer eventDefFolderId;
	 Integer parentfolderid;
	 Integer eventDefinitionId;
	 String eventName;
	 
	 
	 
	 
	public EventFolder(Integer eventDefFolderId, Integer eventDefinitionId,String description) {
		super();
		//super(eventDefFolderId, eventDefinitionId,eventName);
		this.eventDefFolderId = eventDefFolderId;
		this.parentfolderid = eventDefFolderId;
		this.eventDefinitionId = eventDefinitionId;
		this.description = description;
		this.eventName = description;
	}

	public EventFolder(String description, Integer eventDefFolderId, Integer parentfolderid) {
		super();
		this.description = description;
		this.eventName = description;
		this.eventDefFolderId = eventDefFolderId;
		this.parentfolderid = parentfolderid;
	}

	public Integer getParentfolderid() {
		return parentfolderid;
	}

	public void setParentfolderid(Integer parentfolderid) {
		this.parentfolderid = parentfolderid;
	}
	
	public MTEditScreenControler edit(Component parent) throws WrongValueException, SQLException{
		
		MTEditScreenControler editControler = new MTEditScreenControler(eventDefFolderId, MT.EVENTDEFFOLDER, "/zul/panel/folder/eventfoldereditor.zul");
		FieldList fieldList = new FieldList(MT.EVENTDEFFOLDER);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(parent);
		return editControler;

	}
	
	@SuppressWarnings("static-access")
	public MTEditScreenControler createFolder(Component parent) throws WrongValueException, SQLException{
		
		MTEditScreenControler editControler = new MTEditScreenControler(null, MT.EVENTDEFFOLDER, "/zul/panel/folder/eventfoldereditor.zul");
		FieldList fieldList = new FieldList(MT.EVENTDEFFOLDER);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(parent);
		Combobox parentFolder = (Combobox)ComponentTreeTransverser.findFieldEditorFor(parent, MT.EVENTDEFFOLDER.PARENTFOLDERID);
		Comboitem selectedItem=parentFolder.getItems().stream().filter(item -> null!=item.getValue() && item.getValue().toString().equals(getParentfolderid().toString())).findFirst().orElse(null);
		parentFolder.setSelectedItem(selectedItem);
		return editControler;
	}

	@SuppressWarnings("static-access")
	public MTEditScreenControler createTest(Component parent) throws WrongValueException, SQLException{
		
		MTEditScreenControler editControler=new EventCreatedController(null, parent, null);
		Combobox parentFolder = (Combobox)ComponentTreeTransverser.findFieldEditorFor(parent, MT.EVENTDEFINITION.FOLDERID);
		Comboitem selectedItem=parentFolder.getItems().stream().filter(item -> item.getValue().toString().equals(getParentfolderid().toString())).findFirst().orElse(null);
		parentFolder.setSelectedItem(selectedItem);
		return editControler;
	}
	
	
	@SuppressWarnings("static-access")
	public void delete(Connection conn) throws SQLException {
		
			if(null==getEventDefinitionId()){
				if(Messagebox.OK==Messagebox.show("forder "+getDescription() +" and its children will be removed, do you agree? ", "Remove", Messagebox.OK, Messagebox.NONE)){
					
					String sql="update eventdefinition set deleted=1, enddate="+EnvironmentHelper.getVersionDate()+" where enddate>"+EnvironmentHelper.getVersionDate()+"and  folderid="+ getEventDefFolderId();
					Statement st= conn.createStatement();
					st.executeUpdate(sql);
					st.close();
					DetachedRecord dr= new DetachedRecord(MT.EVENTDEFFOLDER, getEventDefFolderId());
					dr.set(MT.EVENTDEFFOLDER.DELETED, 1);
					dr.save(conn);
				}
			}else{
				DetachedRecord dr= new DetachedRecord(MT.EVENTDEFINITION, getEventDefinitionId());
				dr.set(MT.EVENTDEFINITION.DELETED, 1);
				dr.save(conn);
			}
	}

	@SuppressWarnings("static-access")
	public void move(Connection conn,Integer parentfolderid) throws SQLException {
	    if(null==eventDefinitionId){
			DetachedRecord dr= new DetachedRecord(MT.EVENTDEFFOLDER, getEventDefFolderId());
			dr.set(MT.EVENTDEFFOLDER.PARENTFOLDERID,parentfolderid);
			dr.save(conn);
	    }else{
	    	DetachedRecord dr= new DetachedRecord(MT.EVENTDEFINITION, getEventDefinitionId());
			dr.set(MT.EVENTDEFINITION.FOLDERID,parentfolderid);
			dr.save(conn);
	    	
	    }
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEventDefFolderId() {
		return eventDefFolderId;
	}

	public void setEventDefFolderId(Integer eventDefFolderId) {
		this.eventDefFolderId = eventDefFolderId;
	}

	public Integer getEventDefinitionId() {
		return eventDefinitionId;
	}

	public void setEventDefinitionId(Integer eventDefinitionId) {
		this.eventDefinitionId = eventDefinitionId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getFolderName() {
		return description;
	}

	public void setFolderName(String folderName) {
		this.description = folderName;
	}

	public Integer getFolderId() {
		return eventDefFolderId;
	}

	public void setFolderId(Integer folderId) {
		this.eventDefFolderId = folderId;
	}

	public Integer getTestid() {
		return eventDefinitionId;
	}

	public void setTestid(Integer testid) {
		this.eventDefFolderId = testid;
	}

	public String getTestName() {
		return eventName;
	}

	public void setTestName(String testName) {
		this.eventName = testName;
	}
}
