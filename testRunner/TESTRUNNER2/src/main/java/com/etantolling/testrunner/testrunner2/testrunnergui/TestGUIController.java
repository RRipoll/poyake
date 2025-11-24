package com.etantolling.testrunner.testrunner2.testrunnergui;
        
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Label;

import com.etantolling.testrunner.test.core.dblog.ApplicationLog;
import com.etantolling.testrunner.test.core.dto.FolderDTO;
import com.etantolling.testrunner.test.core.dto.TestViewDTO;
import com.etantolling.testrunner.test.core.testrun.TestRun;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataTable;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataTableCompressed;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestGUIController extends GenericForwardComposer implements EventListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedHashMap<String, Object> storeValues= new LinkedHashMap<>();
	Component comp;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		this.comp=comp;
		comp.getFellow("RECORDER").addEventListener(Events.ON_CLICK, this::recorder);
		
		
		((Label)comp.getFellow("testUrl")).setValue(DesktopHelper.getTestLibraryURL());
		((Label)comp.getFellow("bosUrl")).setValue(DesktopHelper.getAppBaseUrl());

		if(null==DesktopHelper.getAttribute("folderValues")) {
			ResponseEntity<String> json = ClientWS.call(DesktopHelper.getTestLibraryURL()+"/rest/folders" , FolderDTO.class, HttpMethod.GET, null);
			ObjectMapper mapper = new ObjectMapper();
			List<FolderDTO> folders = (List<FolderDTO>) mapper.readValue(json.getBody(),
					mapper.getTypeFactory().constructCollectionType(List.class, FolderDTO.class));
			
			Map<String,String> values= new LinkedHashMap<String,String>();
			values.put("", "");
			for (FolderDTO folderDTO : folders) {
				values.put(folderDTO.getFolderId().toString(), folderDTO.getFolderPath());
			}
			DesktopHelper.setAttribute("folderValues",values);
		}
		
		comp.addEventListener(Events.ON_CLIENT_INFO, this);
		try {
			comp.addEventListener(Events.ON_CLIENT_INFO, this);
			DataTableCompressed dtc = new DataTableCompressed(DesktopHelper.getTestServerUrl("/rest/tests"), null, null, "GET", TestViewDTO.class, comp.getFellow("TEST_FILTER"), comp.getFellow("TEST_LIST"), this);
			dtc.setSelector(DataTable.SELECTOR_NONE);
			dtc.setRefreshOnFilterChange(true);
			dtc.init();
			dtc.render();
		
		} catch (Exception e) {
			if(e.getMessage().length()>4000)e=new Exception(e.getMessage().substring(0,3900));
			ApplicationLog.reportException(null, null, null, e);
		}		
		
		ServletContext sc = Sessions.getCurrent().getWebApp().getServletContext();
		TestRun tr = (TestRun) sc.getAttribute(TestRun.class.getName());
		if(tr != null) {
			if(tr.isFinished())
				((Label)comp.getFellow("lblTestRunning")).setValue("LAST TEST RUN >> " + tr.toString());
			else
				((Label)comp.getFellow("lblTestRunning")).setValue("TEST RUNNING >> " + tr.toString());
			
			((Div)comp.getFellow("divTestRunning")).setVisible(true);			
		}
		else
			((Div)comp.getFellow("divTestRunning")).setVisible(false);
	} 
	
	
	
	void recorder(Event event) {
		Integer recorderUuid=DesktopHelper.getRecorderUuid();
		if(null==recorderUuid) {
			((Button)comp.getFellow("RECORDER")).setStyle("background:red");
			try {
				ResponseEntity<String> response=ClientWS.call(DesktopHelper.getAppBaseUrl()+"/api/recorder/set", HttpMethod.GET);
				ObjectMapper mapper = new ObjectMapper();
				Map<String,Object> jsonResponse = mapper.readValue(response.getBody().toString(), Map.class);
				Integer uuid=(Integer) jsonResponse.get("RecorderMasterId");
				DesktopHelper.setRecorderUuid(uuid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			DesktopHelper.deleteRecorderUuid();
			((Button)comp.getFellow("RECORDER")).setStyle("background:'#5687a8'");
			ResponseEntity<String> response;
			try {
				response = ClientWS.call(DesktopHelper.getAppBaseUrl()+"/api/recorder/get/"+recorderUuid , Map.class, HttpMethod.GET, null);
				ObjectMapper mapper = new ObjectMapper();
				Map<String,String> jsonResponse = mapper.readValue(response.getBody().toString(), Map.class);
				String url=jsonResponse.get("urlFile");
				if(null!=url) {
					//File file= new File(url);
					//System.out.println(file.exists());
					Filedownload.save(new URL(url), "application/file");
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	@Override
	public void onEvent(Event event) throws Exception {
		
		if(Events.ON_CLIENT_INFO.equals(event.getName())){
			
			 int height = ((ClientInfoEvent) event).getDesktopHeight();
	         int width = ((ClientInfoEvent) event).getDesktopWidth();
			
			DesktopHelper.setAttribute("ClientHeight", height);
			DesktopHelper.setAttribute("ClientWidth", width);
		}
		
		
		if ("onDataGridCellClick".equals(event.getName())){
			int testId = (int)((LinkedHashMap)event.getData()).get("testId");
			new TestRunnerController(testId,storeValues);
		}if(Events.ON_CLIENT_INFO.equals(event.getName())){
			
			 int height = ((ClientInfoEvent) event).getDesktopHeight();
	         int width = ((ClientInfoEvent) event).getDesktopWidth();
			
			DesktopHelper.setAttribute("ClientHeight", height);
			DesktopHelper.setAttribute("ClientWidth", width);
		}		
	}
}
