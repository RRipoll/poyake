package com.etantolling.testrunner.testrunner2.testrunnergui;

import javax.servlet.ServletContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.dblog.ApplicationLog;
import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.core.dto.TestViewDTO;
import com.etantolling.testrunner.test.core.testrun.TestRun;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataTable;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataTableCompressed;

public class TestRunnerView {
	
	Window window;
	public DataTableCompressed dataTable;
	EventListener<Event> eventListener;
	Integer testId;
	 Textbox testOutput;
	
	public TestRunnerView(EventListener<Event> eventListener, Integer testId) throws Exception {
		this.eventListener = eventListener;
		this.testId = testId;

		window = (Window) Executions.createComponents("/zul/testgui2/testrunner.zul", null, null);
		window.getFellow("BUTTON_FEATURE").addEventListener(Events.ON_CLICK, eventListener);
		window.getFellow("BUTTON_RUN_TO_SELECTION").addEventListener(Events.ON_CLICK, eventListener);
		window.getFellow("BUTTON_STORE_VALUES").addEventListener(Events.ON_CLICK, eventListener);
		window.getFellow("BUTTON_HISTORY").addEventListener(Events.ON_CLICK, eventListener);
		window.addEventListener(Events.ON_CLOSE, eventListener);
		
		 this.testOutput = (Textbox)window.getFellow("TEST_OUTPUT");
		renderEventList();
		fillHeader();
		
		ServletContext sc = Sessions.getCurrent().getWebApp().getServletContext();
		TestRun tr = (TestRun) sc.getAttribute(TestRun.class.getName());
		if(tr != null) {
			if(tr.isFinished())
				((Label)window.getFellow("lblTestRunning")).setValue("LAST TEST RUN >> " + tr.toString());
			else
				((Label)window.getFellow("lblTestRunning")).setValue("TEST RUNNING >> " + tr.toString());
			
			((Div)window.getFellow("divTestRunning")).setVisible(true);			
		}
		else
			((Div)window.getFellow("divTestRunning")).setVisible(false);
	}

	void fillHeader() throws Exception {
		String testServerRestUrl = DesktopHelper.getTestServerUrl("/rest/test/{testId}");
		ResponseEntity<TestViewDTO> responseEntity = new RestTemplate().getForEntity(testServerRestUrl, TestViewDTO.class, testId);
		TestViewDTO testViewDTO = responseEntity.getBody();
		((Label) window.getFellow("TEST_ID")).setValue(testId.toString());
		((Label) window.getFellow("TEST_NAME")).setValue(testViewDTO.getTestName());
		((Label) window.getFellow("TEST_DESCRIPTION")).setValue(testViewDTO.getDescription());
		((Textbox) window.getFellow("TEST_NOTES")).setValue(testViewDTO.getNotes());
		((Label) window.getFellow("CURRENT_POSTINGDATE")).setVisible(false);
	}

	public void renderEventList() throws Exception {
		try {
			dataTable = new DataTableCompressed(DesktopHelper.getTestServerUrl("/rest/events/" + testId), null, null, "GET", EventViewDTO.class, null, window.getFellow("EVENT_LIST"), this.eventListener);

			dataTable.setPageSize(10);
			dataTable.setSelector(DataTable.SELECTOR_RADIO);

			dataTable.setAdapter(new EventAdapter());
			dataTable.init();

			dataTable.setOrderByField("eventOrder", true);
			
			dataTable.getDgModel().getDgQuery().getColumnNames().clear();
			dataTable.getDgModel().getDgQuery().getColumnNames().add("eventId");
			dataTable.getDgModel().getDgQuery().getColumnNames().add("eventType");
			dataTable.getDgModel().getDgQuery().getColumnNames().add("manualDescription");
			dataTable.getDgModel().getDgQuery().getColumnNames().add("parameters");	
			dataTable.getDgModel().getDgQuery().getColumnNames().add("dataRecordPk");
			dataTable.getDgModel().getDgQuery().getColumnNames().add("eventFileId");
			
			dataTable.getDgModel().getHiddenColumns().add("dataRecordPk");
			dataTable.getDgModel().getHiddenColumns().add("automaticDescription");
			dataTable.getDgModel().getHiddenColumns().add("deleted");
			dataTable.getDgModel().getHiddenColumns().add("eventDefinitionId");
			dataTable.getDgModel().getHiddenColumns().add("eventOrder");
			dataTable.getDgModel().getHiddenColumns().add("testId");
			
			dataTable.getDgModel().getColumnHFlex().put("parameters", "max");
			dataTable.getDgModel().getColumnHFlex().put("eventFileId", "min");
			dataTable.getDgModel().getColumnHFlex().put("eventId", "min");

			dataTable.render();
		} catch (Exception e) {
			ApplicationLog.reportException(null, null, null, e);
		}
	}
}