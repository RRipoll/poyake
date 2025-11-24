package com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen;

import java.sql.Connection;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.metadata.FieldList;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.forms.ZulDataWirer;


public class MTEditScreenControler implements EventListener<Event>{

	protected MTEditScreenView view;
	boolean createMode = false;
	protected Integer pk;
	String zul;
	protected MTTable table;
	protected FieldList fields = null;
	protected boolean isSaved = false;
	
	public MTEditScreenControler(Integer pk, MTTable table, String zul) {
		this.pk = pk;
		this.table = table;
		this.zul = zul;
	}
	
	public void buildForm(Component parent) throws WrongValueException, SQLException{
		view= new MTEditScreenView(pk, this, zul, table, fields, parent);	
		setMainDetachedRecordValues(view.dr);
	}
	
	public void doModal(){
		((Window)view.getComponent()).doModal();
	}

	public void setMainDetachedRecordValues(DetachedRecord dr){
	}
	
	
	@Override
	public void onEvent(Event event) throws Exception {
		if(event.getTarget().equals(view.save)){
			save();
			isSaved = true;
		}
	}
	
	public void setFields(FieldList fields) {
		this.fields = fields;
	}
	
	public void save() throws SQLException{
		Connection conn=MainDb.getConnection();
		wireFields();
		view.dr.save(conn);
		setPk(view.dr.getPk());
		saveExtraObjects(conn);
		
		conn.close();
		view.window.detach();
	}

	

	public void setView(MTEditScreenView view){
		this.view = view;
	}
	
	public MTEditScreenView getView() {
		return view;
	}

	public void saveExtraObjects(Connection conn) throws SQLException{
		
	}
	
	
	protected void wireFields() throws SQLException{
		ZulDataWirer.readFormFieldValues(view.dr, view.window);
	}

	public boolean isSaved() {
		return isSaved;
	}

	public FieldList getFields() {
		return fields;
	}

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}
	
	
}