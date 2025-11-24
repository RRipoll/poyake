package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Window;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event.eventfiles.EventFilesControler;
import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.misc.MiscUtility;
import com.etantolling.testrunner.test.zkweb.forms.ZulDataWirerSql;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;

public class EventEditControler extends MTEditScreenControler{
	Combobox comboEventDefinitionId= null;
	Combobox comboEventFolderId=null;
	Component dataRecordEditorWindow = null;
	Component createNewFolder=null;
	Component createNewEventType=null;
	Component editEventType=null;
	
	Component newParameterType=null;
	
	EditScreenControler controlerDataRecord = null;
	
	EventFilesControler filesControler;

	public EventEditControler(Integer pk, MTTable table) throws SQLException {
		super(pk, table, "/zul/panel/test/event/eventeditor.zul");
	}

	@SuppressWarnings("static-access")
	@Override
	public void save() throws SQLException{
		Connection conn=MainDb.getConnection();
		try{
			conn.setAutoCommit(false);
			wireFields();

			view.dr.set(MT.EVENT.PARAMETERS,controlerDataRecord.getParam());
				
			view.dr.save(conn);

			filesControler.saveNewImages(conn, view.dr.getPk(), view.dr.getInt(MT.EVENT.TESTID));

			saveExtraObjects(conn);
			if(null== view.dr.getOriginalValues().get(MT.EVENT.EVENTORDER))
					saveOrder(conn);
			
			conn.commit();
		}
		catch (Exception e){
			conn.rollback();
			throw new RuntimeException(e);
		}
		finally{
			conn.setAutoCommit(true);
			conn.close();
		}
		view.window.detach();
	}

	private void saveOrder(Connection conn) throws SQLException {
		
		String sql="update event set eventorder= "+view.dr.getPk()*100+
				" where EVENTID="+view.dr.getPk();
		conn.createStatement().executeUpdate(sql);
}
	
	public void buildForm(Component parent) throws WrongValueException, SQLException {
		super.buildForm(parent);
		filesControler = new EventFilesControler(this.pk);
		filesControler.getView().div.setParent(this.view.window.getFellow("EVENT_FILES_AREA"));
		
		Connection conn=MainDb.getConnection();
		try{
			comboEventFolderId=(Combobox) view.window.getFellow("folderevent");
			String sql="select distinct  eventdeffolderid as value,folderpath as label from eventfolderpaths order by label";
			ZulDataWirerSql.fillEnumerationBySql(conn,comboEventFolderId,sql,null,null);
			comboEventFolderId.addEventListener(Events.ON_SELECT, this);
			comboEventDefinitionId = (Combobox)view.window.getFellow("eventtype");
			comboEventDefinitionId.addEventListener(Events.ON_SELECT, this);
			createNewEventType=view.window.getFellow("createEventType");
			createNewEventType.addEventListener(Events.ON_CLICK, this);
			editEventType=view.window.getFellow("editEventType");
			editEventType.addEventListener(Events.ON_CLICK, this);
			
			createNewFolder=view.window.getFellow("createFolderEvent");
			createNewFolder.addEventListener(Events.ON_CLICK, this);
			
		}finally{conn.close();}
	}

	private void fillEventType() throws SQLException {
		
		Connection conn=MainDb.getConnection();
		try{
		comboEventDefinitionId.getChildren().clear();
		comboEventDefinitionId.setValue(null);
		comboEventDefinitionId.setDisabled(false);
		Integer eventFolderId=comboEventFolderId.getSelectedItem().getValue();
		
		String sql="select distinct eventdefinitionid value,description  label from eventdefinition where deleted=0 and  startdate<="+EnvironmentHelper.getVersionDate()+" and enddate>="+EnvironmentHelper.getVersionDate()+" and  folderid= "+eventFolderId + "order by label";
		ZulDataWirerSql.fillEnumerationBySql(conn,comboEventDefinitionId,sql,null,null);
		
		((Button)createNewEventType).setDisabled(false);
		((Button)editEventType).setDisabled(false);
		
		}finally{conn.close();}
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		super.onEvent(event);
		
		if (event.getTarget() == comboEventFolderId){
			fillEventType();
			editEventType.setVisible(false);
		
		}else if (event.getTarget() == comboEventDefinitionId){
			if (null != dataRecordEditorWindow) dataRecordEditorWindow.detach();

			Integer eventDefinitionId=comboEventDefinitionId.getSelectedItem().getValue();

			 String sql="select * from eventdefinition where deleted=0 and  startdate<="+EnvironmentHelper.getVersionDate()+" and enddate>="+EnvironmentHelper.getVersionDate()+" and eventdefinitionid="+eventDefinitionId ;

			String 	xmldata=null;
				try(Connection conn= MainDb.getConnection();Statement st= conn.createStatement(); ResultSet rs=st.executeQuery(sql)){
					rs.next();
					xmldata=rs.getString("parameters");
				}	
			
			createEventDataArea(xmldata);
				editEventType.setVisible(true);
		}else if(event.getTarget().equals(createNewEventType)){
					new EventCreatedController(comboEventFolderId,view.window,null);
			 fillEventType() ;
		
		
		}else if(event.getTarget().equals(editEventType)){
			Integer eventDefinitionId=comboEventDefinitionId.getSelectedItem().getValue();
			if(null==eventDefinitionId)return;
			//MTTable mtTableDataRecord = findDataTableRecordFromEventDefinitionId(eventDefinitionId);
			//EventCreatedController createEventController= 
					new EventCreatedController(comboEventFolderId,view.window,eventDefinitionId);
			fillEventType() ;
			
	}
		
		else if(event.getTarget().equals(createNewFolder)){
			MTEditScreenControler editEventFolder = new MTEditScreenControler(null, MT.EVENTDEFFOLDER, "/zul/panel/test/event/eventfoldereditor.zul");
			editEventFolder.buildForm(view.window);
			editEventFolder.doModal();
			//Integer eventFolderPk=editEventFolder.getPk();
			//String project=EnvironmentHelper.getProject();
			String sql="select eventdeffolderid as value,folderpath as label from eventfolderpaths order by folderpath";
			try(Connection conn= MainDb.getConnection()){
				ZulDataWirerSql.fillEnumerationBySql(conn,comboEventFolderId,sql,null,null);
			}
		}
	}
	
	public void createEventDataArea(String xmldata) throws SQLException{
		
		controlerDataRecord=new EditScreenControler((LinkedHashMap<String, Object>) new MiscUtility().getObjectFromString(xmldata));
		controlerDataRecord.buildForm(view.window);
		ZulDataWirerSql.initializeFieldValues(controlerDataRecord.drr.getOriginalValues(), controlerDataRecord.window);
		dataRecordEditorWindow = controlerDataRecord.window;
			
		((Window)dataRecordEditorWindow).setClosable(false);
		((Window)dataRecordEditorWindow).setTitle(null);
		((Window)dataRecordEditorWindow).getFellowIfAny("SAVE_BUTTON").setVisible(false);
	}
	
	public Combobox getComboEventDefinitionId() {
		return comboEventDefinitionId;
	}

	public void setComboEventDefinitionId(Combobox comboEventDefinitionId) {
		this.comboEventDefinitionId = comboEventDefinitionId;
	}

	public Component getDataRecordEditorWindow() {
		return dataRecordEditorWindow;
	}

	public void setDataRecordEditorWindow(Component dataRecordEditorWindow) {
		this.dataRecordEditorWindow = dataRecordEditorWindow;
	}

	public EventFilesControler getFilesControler() {
		return filesControler;
	}

	public void setFilesControler(EventFilesControler filesControler) {
		this.filesControler = filesControler;
	}
}