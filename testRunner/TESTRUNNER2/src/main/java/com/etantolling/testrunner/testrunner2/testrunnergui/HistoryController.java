package com.etantolling.testrunner.testrunner2.testrunnergui;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.dblog.ApplicationLog;
import com.etantolling.testrunner.test.core.dto.HistoryDTO;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataTable;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataTableCompressed;

public class HistoryController {

	Window panel;
	Integer testId;
	public DataTableCompressed dataTable;
	
	public HistoryController(Integer testId) {
		this.testId=testId;
		panel=(Window) Executions.createComponents("/zul/testgui2/history.zul", null, null);
		init();
		panel.doModal();
	}

	private void init() {
		try {
			dataTable = new DataTableCompressed(DesktopHelper.getTestServerUrl("/rest/history/" + testId), null, null, "GET", HistoryDTO.class, null, panel.getFellow("EVENT_LIST"), null);

			dataTable.setPageSize(50);

			dataTable.setAdapter(new EventAdapter());
			dataTable.init();

			dataTable.setOrderByField("postingDate", false);
			
			dataTable.render();
		} catch (Exception e) {
			ApplicationLog.reportException(null, null, null, e);
		}
		
	}
}