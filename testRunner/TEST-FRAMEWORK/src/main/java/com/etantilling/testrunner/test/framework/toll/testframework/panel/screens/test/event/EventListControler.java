package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Combobox;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.FieldList;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.MTListScreenControler;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class EventListControler extends MTListScreenControler{
	Integer testPk;
	
	private static final long serialVersionUID = -5882815688800094692L;

	public EventListControler(Integer testPk) throws SQLException{
		
		super(MT.EVENT,false,"SELECT EVENTID, "
				+ "EVENTORDER , "
				+ "ED.EVENTNAME EVENTTYPE, MANUALDESCRIPTION DESCRIPTION,'' FILES,cast(ED.EVENTDEFINITIONID as int) PARAMETERS "
				+ "	FROM EVENT E JOIN EVENTDEFINITION ED ON  ED.EVENTDEFINITIONID=E.EVENTDEFINITIONID WHERE E.DELETED=0 and e.startdate<=:versionDate and e.enddate>=:versionDate and ed.startdate<:versionDate and ed.enddate>=:versionDate AND TESTID=" + testPk );

			this.testPk = testPk;
		super.setHeader(new EventListHeader(this));
		view.getDataGrid().setAdapter(new EventRowAdapter());
	}

	@Override
	public void layout() throws SQLException {
		super.layout();
		view.getDataGrid().getDgModel().dgQuery.setOrderByField("EVENTORDER, eventid ", true);
	}
	@Override
	public void render(){
		view.getDataGrid().getDgModel().dgQuery.setOrderByField("EVENTORDER, eventid ", true);
		view.getDataGrid().getDgModel().getHiddenColumns().add("EVENTORDER");
		view.getDataGrid().getDgModel().getColumnHFlex().put("PARAMETERS", "1");
		view.getDataGrid().getDgModel().getColumnHFlex().put("EVENTID", "min");
	}

	@SuppressWarnings("static-access")
	@Override
	public void create() throws WrongValueException, SQLException {
		MTEditScreenControler editControler = new EventEditControler(null, mtTable);
		FieldList fieldList = new FieldList(mtTable);
		fieldList.remove(MT.EVENT.TESTID);
		fieldList.remove(MT.EVENT.EVENTORDER);
		fieldList.remove(MT.EVENT.AUTOMATICDESCRIPTION);
		fieldList.remove(MT.EVENT.PARAMETERS);
		
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(view);
		editControler.getView().dr.set(MT.EVENT.TESTID, testPk);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		editControler.doModal();
		Integer newEventId=editControler.getPk();
		if(view.getDataGrid().getSelectionMan().getSelectionCount()>0){
			Vector<Object> st=view.getDataGrid().getSelectionMan().selectedSet;
			Integer eventOrder;
			if(null!=newEventId && view.getDataGrid().getSelectionMan().selectedSet.size()==2) {
				Integer eventOorder0=(Integer)((LinkedHashMap<String, Object>)st.get(0)).get("EVENTID");
				Integer eventOorder1=(Integer)((LinkedHashMap<String, Object>)st.get(1)).get("EVENTID");
				eventOrder=eventOorder0+(eventOorder1-eventOorder0)/2;
				changeOrder(newEventId,eventOrder);
			}
		}
	}

	@Override
	public Integer copy(Integer testId) throws WrongValueException, SQLException {
		CopyEventDialog copyEventDialog = new CopyEventDialog(testId);
		copyEventDialog.setParent(this);
		copyEventDialog.doModal();
		return null;
	}

	@SuppressWarnings("static-access")
	@Override
	public void edit(Integer pk) throws WrongValueException, SQLException {
		if (null == pk) return;
		EventEditControler editControler = new EventEditControler(pk, mtTable);
		FieldList fieldList = new FieldList(mtTable);
		fieldList.remove(MT.EVENT.TESTID);
		fieldList.remove(MT.EVENT.PARAMETERS);
		fieldList.remove(MT.EVENT.EVENTORDER);
		fieldList.remove(MT.EVENT.AUTOMATICDESCRIPTION);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(view);
		editControler.getView().dr.set(MT.EVENT.TESTID, testPk);
		 ((Combobox)ComponentTreeTransverser.findFieldEditorFor(getView(), MT.EVENT.EVENTDEFINITIONID)).setDisabled(true);
		 
		String 	xmldata=(String) editControler.getView().dr.get(MT.EVENT.PARAMETERS);
		 
		editControler.createEventDataArea(xmldata);
				
		editControler.doModal();
	}
}