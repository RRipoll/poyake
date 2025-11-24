package com.etantolling.testrunner.testrunner2.testrunnergui;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Html;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.etantolling.testrunner.test.core.dto.FileRefDTO;
import com.etantolling.testrunner.test.core.dto.TestViewDTO;
import com.etantolling.testrunner.test.core.utils.DataFormatter;
import com.etantolling.testrunner.test.utils.misc.MiscUtility;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.BasicRowAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
public class EventAdapter extends BasicRowAdapter {
	
	@SuppressWarnings("unchecked")
	@Override
	public void renderCell(Div div, String columnName, EventListener<Event> eventListener) throws Exception {
		
		if(columnName.equals("parameters")){
			
			String dataEvent=(String) row.get("parameters");
			
					LinkedHashMap<String, Object> par=(LinkedHashMap<String, Object>) new MiscUtility().getObjectFromString((String) dataEvent);
					Grid grid = new Grid();
					grid.setParent(div);
					Columns columns = new Columns();
					columns.setParent(grid);
					for (String element : par.keySet()) {
						if(element.equals("AUTHORIZATION") || element.equals("HTTPMETHOD"))continue;
						Component column = new Column();
						column.setParent(columns);
						Html text = new Html();
						text.setParent(column);
						text.setContent(element);
					}
					Rows rows = new Rows();
					rows.setStyle("border-collapse:collapse;");
					rows.setParent(grid);
					Row row = new Row();
					for (String element : par.keySet()) {
						if(element.equals("AUTHORIZATION") || element.equals("HTTPMETHOD"))continue;
						
						row.setParent(rows);
						HtmlBasedComponent divv=null;
						 divv = new Div();
						 divv.setParent(row);
							divv.setHflex("1");
							divv.setVflex("1");
							String newValue=DataFormatter.formatValue(((LinkedHashMap<String, Object>)par.get(element)).get("value"),null);
							String type=(String) ((LinkedHashMap<String, Object>)par.get(element)).get("type");
							if(type.startsWith("Conditional"))
								newValue+=" "+type;
							Label html = new Label(newValue);
							html.setParent(divv);
							if(element.equals("testId")) {
								divv.addEventListener(Events.ON_CLICK, eventListener);
								divv.setAttribute("CELL_CLICK_INFO", Integer.parseInt(newValue));
								divv.setStyle("float:left;text-weight:bold;padding:0px 0px 0px 4px;cursor:pointer;color:blue;");
							}
					}
			
		}else if(columnName.equals("eventFileId")){	
			/*
			Integer fileId=(Integer)row.get("eventFileId");
			if(null!=fileId)
				EventFileUtils.loadExistingImages(fileId, null).setParent(div);
			*/
		}else{
			super.renderCell(div, columnName, eventListener);
		}
	}
	
	
	private String findDataTableRecordFromEventDefinitionId(Integer eventDefinitionId) throws Exception{
		String testServerRestUrl = DesktopHelper.getTestServerUrl("/rest/tablename/{eventDefinitionId}");
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(testServerRestUrl, String.class, eventDefinitionId);
		return responseEntity.getBody();
	}
	
	private List<FileRefDTO> findFilesFromEventId(Integer eventId) throws Exception{
		String testServerRestUrl = DesktopHelper.getTestServerUrl("/files/{eventId}");
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(testServerRestUrl, String.class, eventId);
		ObjectMapper mapper = new ObjectMapper();
		 return (List<FileRefDTO>) mapper.readValue(responseEntity.getBody(), TestViewDTO.class);
	}
	

}