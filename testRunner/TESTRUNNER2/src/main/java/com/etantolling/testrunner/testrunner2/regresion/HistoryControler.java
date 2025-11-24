package com.etantolling.testrunner.testrunner2.regresion;

import java.io.File;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Div;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.dblog.ApplicationLog;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTable;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTableCompressed;
import com.etantolling.testrunner.test.zkweb.serverfilebrowser.FileBrowser;

public class HistoryControler implements  EventListener<Event>{

	
	Component panel;
	DataTableCompressed dtc;
	
	Vector<LinkedHashMap<String, Object>> executedRows= new Vector<LinkedHashMap<String, Object>>();
	
	public HistoryControler(Component panel) {
		super();
		this.panel = panel;
		
		init();
	}

	
	private void init() {
		// TODO Auto-generated method stub
		panel.getFellow("TEST_LIST_HISTORY").getChildren().clear();
		String sql="SELECT * FROM("
				+ "	SELECT "
				+ " TESTRUNID,"
				+ " TESTID,"
				+ " (SELECT USERNAME FROM TESTREPOSITORY.INPUTUSER WHERE INPUTUSERID=TT.CREATOR) CREATOR,"
				+ " CASE WHEN EXITSTATUS=0 THEN 'NOK' WHEN EXITSTATUS=1 then 'OK' END STATUS,"
				+ " CREATED,"
				+ " '' FILES"
				+ " FROM TESTREPOSITORY.TESTRUN TT"
				+ " WHERE DELETED=0 "
				//+ "AND REGRESSIONTEST=1"
				+ ") WHERE (0=0) "; 
	try {
		DataTableCompressed dtcHistory= new DataTableCompressed(sql, panel.getFellow("TEST_FILTER_HISTORY"), panel.getFellow("TEST_LIST_HISTORY"), this);
		dtcHistory.setSelector(DataTable.SELECTOR_NONE);
		dtcHistory.setOrderByField("TESTID", false);
		dtcHistory.setRefreshOnFilterChange(true);
		dtcHistory.setAdapter(new HistoryAdapter());
		dtcHistory.init();
		dtcHistory.render();
		panel.invalidate();
		
	} catch (SQLException e) {
		ApplicationLog.reportException(null, null, null, e);
	}		
	
	}

	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		if( event.getData() instanceof Div ){
			
			
			Integer testRunnerId=(Integer) ((Div)event.getData()).getAttribute("testRunnerId");
			FileBrowser fileBrower= new FileBrowser(new File("/nasshare/test/test"+testRunnerId), null);
			Window win= new Window("Files", null, true);
			fileBrower.setParent(win);
			win.setParent(panel);
			
			win.doModal();
		}
	}
	
}
