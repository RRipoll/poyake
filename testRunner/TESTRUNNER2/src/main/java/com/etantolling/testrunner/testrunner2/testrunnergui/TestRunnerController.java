package com.etantolling.testrunner.testrunner2.testrunnergui;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.zkoss.zhtml.Textarea;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.dto.HistoryDTO;
import com.etantolling.testrunner.test.core.testing.Wildcards;
import com.etantolling.testrunner.test.core.testingws.TestRunner;
import com.etantolling.testrunner.test.core.testrun.TestRun;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.testevents.TestEventFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestRunnerController implements EventListener<Event> {
	Integer testId;
	TestRunnerView view;
	TestRunner trc;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	Logger logger = Logger.getLogger(TestRunnerController.class);
	String jobsServiceBaseURL = null;
	TestResultController testResult;
	boolean showlog=false;
	LinkedHashMap<String, Object> storeValues= new LinkedHashMap<>();
	Wildcards wildcards = new Wildcards();
	
	public TestRunnerController(Integer testId) throws Exception {
		this.testId = testId;
		view = new TestRunnerView(this, testId);
		trc = new TestRunner(testId, new TestEventFactory(),DesktopHelper.getTestLibraryURL(),DesktopHelper.getAppBaseUrl(),DesktopHelper.getAppJobUrl());
		trc.setWildcards(wildcards);
		trc.setStoreValues(storeValues);
		trc.setDefaultAuthorization(DesktopHelper.getDefaultTokken());
		testResult=new TestResultController(this);
		view.window.doModal();
	}
	
	public TestRunnerController(Integer testId,LinkedHashMap<String, Object> storeValues) throws Exception {
		this.testId = testId;
		this.storeValues=storeValues;
		view = new TestRunnerView(this, testId);
		trc = new TestRunner(testId, new TestEventFactory(),DesktopHelper.getTestLibraryURL(),DesktopHelper.getAppBaseUrl(),DesktopHelper.getAppJobUrl());
		trc.setWildcards(wildcards);
		trc.setStoreValues(storeValues);
		trc.setDefaultAuthorization(DesktopHelper.getDefaultTokken());
		testResult=new TestResultController(this);
		view.window.doModal();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onEvent(Event event) throws Exception {
		ServletContext sc = Sessions.getCurrent().getWebApp().getServletContext();
		if(event.getName().equals(Events.ON_CLOSE)) {
			sc.removeAttribute(TestRun.class.getName());
		}
		if ("BUTTON_FEATURE".equals(event.getTarget().getId())) {
			
			TestRun tr = (TestRun) sc.getAttribute(TestRun.class.getName());
			if(tr == null) {
				tr = new TestRun();
				tr.setFinished(true);
				sc.setAttribute(TestRun.class.getName(), tr);
			}
				
			tr.setTestId(testId);
			tr.setFinished(false);
			tr.setIpAddress(Executions.getCurrent().getRemoteAddr());

			if(isShowlog())logger.info("Running test: " + testId + " to target Date: " 
			);
			String sb=new CucumberFeature().runToTargetDate(tr,new TestEventFactory());	
					
			Window win = new Window();
			win.setTitle("Feature");
			win.setClosable(true);
			Textarea test= new Textarea(sb);//.replaceAll("\r\n", "<br/>")
			test.setParent(win);
			test.setStyle("width:100%;height:100%");
			win.setParent(view.window);
			win.setWidth("50%");
			win.setHeight("50%");
			
			win.doModal();
		}else if ("BUTTON_RUN_TO_SELECTION".equals(event.getTarget().getId())) {
				TestRun tr = (TestRun) sc.getAttribute(TestRun.class.getName());
				if(null !=trc.getStoreValues() && trc.getStoreValues().size()>1)
					if(Messagebox.NO==Messagebox.show("do you want to use Stored_values_list in this test? ", "Stored Values",  Messagebox.NO | Messagebox.YES , Messagebox.EXCLAMATION)){
						trc.getStoreValues().clear();
						trc.setDefaultAuthorization(DesktopHelper.getDefaultTokken());
					}	
				
				try	{
					if(tr == null) {
						tr = new TestRun();
						tr.setTestId(testId);
						tr.setFinished(true);
						sc.setAttribute(TestRun.class.getName(), tr);
						tr.getHistoryDto().setEnviroment(DesktopHelper.getAppBaseUrl());
						ResponseEntity<String> json = ClientWS.call(DesktopHelper.getTestLibraryURL()+"/rest/history", tr.getHistoryDto(), HttpMethod.POST, null);
						ObjectMapper mapper = new ObjectMapper();		 
						HistoryDTO history=	mapper.readValue(json.getBody().toString(), HistoryDTO.class);
						tr.setHistoryDto(history);
						
					}
					
					if(tr.isFinished()) {
						Integer stopEventId=null;
						if (null != view.dataTable.getSelectionMan().getSingleSelectedKey())
							 stopEventId=(Integer) ((HashMap<String, Object>) view.dataTable.getSelectionMan().getSingleSelectedKey()).get("eventId");
						
						try {
							tr.getHistoryDto().setLastEventId(stopEventId);
							trc.runToTargetEvent(stopEventId);
							tr.getHistoryDto().setStatusId(1);
							ResponseEntity<String> json = ClientWS.call(DesktopHelper.getTestLibraryURL()+"/rest/history", tr.getHistoryDto(), HttpMethod.POST, null);
							ObjectMapper mapper = new ObjectMapper();		 
							HistoryDTO history=	mapper.readValue(json.getBody().toString(), HistoryDTO.class);
							tr.setHistoryDto(history);
							
						} catch (Exception e) {
							trc.bTestSuccess = false;
							trc.errorMessage = "Running eventId: " + trc.currentRunningEventId + "\r\n Error: " +  e.getMessage();
							tr.setFinished(true);
							tr.getHistoryDto().setStatusId(0);
							ResponseEntity<String> json = ClientWS.call(DesktopHelper.getTestLibraryURL()+"/rest/history", tr.getHistoryDto(), HttpMethod.POST, null);
							ObjectMapper mapper = new ObjectMapper();		 
							HistoryDTO history=	mapper.readValue(json.getBody().toString(), HistoryDTO.class);
							tr.setHistoryDto(history);
						}
						
						tr.setFinished(true);
						
						tr.setLastEventId(stopEventId);
						sc.setAttribute(TestRun.class.getName(), tr);
						
						Messagebox.show("Done. last eventId : " +trc.currentRunningEventId );
						testResult.showDialog();
					}
					else {
						String message = "There is a test running right now. Please wait until it finishes. " + tr.toString();					
						Messagebox.show(message, "Test Running", Messagebox.OK, Messagebox.INFORMATION);
						tr.setFinished(true);
					}
				}
				catch(Exception e) {
					tr.setFinished(true);
					sc.setAttribute(TestRun.class.getName(), tr);
				}
		}else if ("onSelectorClick".equals(event.getName())) {
			LinkedHashMap<String, Object> eventSelected=(LinkedHashMap<String, Object>) view.dataTable.getSelectionMan().getSingleSelectedKey();
			((Label)view.window.getFellow("EVENT_SELECTED")).setValue("   To Event: {eventId="+ eventSelected.get("eventId")+", eventType= "+ eventSelected.get("eventType")+" }");
		}else if ("BUTTON_STORE_VALUES".equals(event.getTarget().getId())) {
			new EditStoreValueController(trc.getStoreValues());
		}else if ("BUTTON_HISTORY".equals(event.getTarget().getId())) {
				new HistoryController(testId);	
		}else if(event.getName().equals("onDataGridCellClick")) {
			Object data=event.getData();
			if(null==data || !(data instanceof Integer) )return;
			new TestRunnerController((Integer)data);
		}
	}

	public boolean isShowlog() {
		return showlog;
	}

	public void setShowlog(boolean showlog) {
		this.showlog = showlog;
	}
}