package com.testrunner.test.framework.toll.testframework.panel.screens.testcheck;



import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import com.etantolling.testrunner.test.zkweb.IPanel;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTableCompressed;
import com.jsantos.orm.MainDb;

public class TestCheckView implements IPanel{

	Component panel = null;
	EventListener<Event> eventListener = null;
	public DataTableCompressed dtc;
	private Button checkBtn;
	private Button fixSequenceNumberBtn;
    private Textbox testIdTb;
    private Textbox resultsTb;
    private LinkedHashMap<Integer,String> finleNameByFileRefId = new LinkedHashMap<Integer,String> ();
    private LinkedHashMap<Integer,String> postingDateByFileRefId = new LinkedHashMap<Integer,String>();
    private LinkedHashMap<Integer,File> fileByEvnetId = new LinkedHashMap<Integer,File>();
    private LinkedHashMap<Integer,Integer> eventIdByFileRefId = new LinkedHashMap<Integer,Integer>();
    private LinkedHashMap<Integer,String> fileUrlByFileRefId = new LinkedHashMap<Integer,String>();
    private static final Logger log = LoggerFactory.getLogger(TestCheckView.class);
	public TestCheckView(Component panel,EventListener<Event> eventListener) throws SQLException {
		
		this.panel= panel;
		this.eventListener=eventListener;
		layout();
		
	}

	@Override
	public void layout() throws SQLException {
		
		checkBtn = (Button)panel.getFellow("CHECK");
		checkBtn.addEventListener(Events.ON_CLICK,eventListener);
		fixSequenceNumberBtn = (Button)panel.getFellow("FIX_SEQUENCE_NUMBERS");
		fixSequenceNumberBtn.addEventListener(Events.ON_CLICK,eventListener);
		testIdTb = (Textbox)panel.getFellow("TEST_ID");
		resultsTb = (Textbox)panel.getFellow("CHECK_RESULTS");
	}
	
	public void getFilesToBeChecked(Integer testId){
		this.clearCollections();
    	String sql = "select e.testId, e.eventid, e.postingDate,fr.filerefid,fr.name, fr.azureurl from  testrepository.event e  join testrepository.eventfile ef on ef.eventId=e.eventId join testrepository.fileref fr on fr.fileRefId=ef.fileRefId and e.testId="+testId+" order by postingdate asc";		    
		Connection conn = null;
		try {
			conn = MainDb.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);				 
			while (rs.next()){	
				if(rs.getString("name").endsWith(".xls")||rs.getString("name").endsWith(".xlsx")){
					log.info(rs.getInt("eventid")+","+rs.getString("name"));
					finleNameByFileRefId.put(rs.getInt("filerefid"),rs.getString("name"));
					postingDateByFileRefId.put(rs.getInt("filerefid"),new SimpleDateFormat(" dd/MM/ yyyy HH:mm").format(rs.getDate("postingdate")));
					fileByEvnetId.put(rs.getInt("eventid"),new File(rs.getString("azureurl")));
					fileUrlByFileRefId.put(rs.getInt("filerefid"),rs.getString("azureurl"));
					eventIdByFileRefId.put(rs.getInt("filerefid"),rs.getInt("eventid"));
				}
				
			}	
			
			st.close();
			rs.close();
			conn.close();
		} 
		catch (Exception e) {
			log.error("ERROR STACKTRACE:",e);
		}
    	
    }
	
	public void setId(Object Id) {
	}
	@Override
	public Component getPanel() {
		return panel;
	}
	public void clearCollections(){
		finleNameByFileRefId.clear();
		postingDateByFileRefId.clear();
		fileByEvnetId.clear();
		fileUrlByFileRefId.clear();
		eventIdByFileRefId.clear();
	}
	public Button getCheckBtn(){
		return checkBtn;
	}
	public Button getFixSequenceNumber(){
		return fixSequenceNumberBtn;
	}
	
	public Textbox getTestIdTb(){
		return testIdTb;
	}
	
	public Textbox getResultsTb(){
		return resultsTb;
	}
	
	public LinkedHashMap<Integer,String> getFileNameByFileRefId(){
		return this.finleNameByFileRefId;
	}
	public LinkedHashMap<Integer,String> getPostingDateByFileRefId(){
		return this.postingDateByFileRefId;
	}
	
	public LinkedHashMap<Integer,File> getFileByEventId(){
		return this.fileByEvnetId;
	}
	public LinkedHashMap<Integer,String> getFileUrlByFileRefId(){
		return this.fileUrlByFileRefId;
	}
	
	public LinkedHashMap<Integer,Integer> getEventIdByFileRefId(){
		return this.eventIdByFileRefId;
	}
	
}