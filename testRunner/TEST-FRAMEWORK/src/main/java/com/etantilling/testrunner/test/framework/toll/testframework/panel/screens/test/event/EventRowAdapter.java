package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import java.io.File;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Space;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.TestControler;
import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.utils.DataFormatter;
import com.etantolling.testrunner.test.utils.misc.MiscUtility;
import com.etantolling.testrunner.test.zkweb.EventFileUtils;
import com.etantolling.testrunner.test.zkweb.datagrid3.BasicRowAdapterEventId;

public class EventRowAdapter extends BasicRowAdapterEventId implements EventListener<Event>{
	
	HtmlBasedComponent div;
	
	@Override
	public void renderCell(HtmlBasedComponent div, String columnName, EventListener<Event> eventListener) throws SQLException {
		this.div=div;
		
		if(columnName.equals("FILES")){
			
			EventFileUtils.loadExistingImages((Integer)row.get("EVENTID"), this).setParent(div);
		}else if(columnName.equals("PARAMETERS")){
			Integer eventDescriptionId=(Integer) row.get("PARAMETERS");
					DetachedRecord dr= new DetachedRecord(MT.EVENT, (Integer)row.get("EVENTID"));
					LinkedHashMap<String, Object> par=(LinkedHashMap<String, Object>) new MiscUtility().getObjectFromString((String) dr.get(MT.EVENT.PARAMETERS));
					Grid grid = new Grid();
					grid.setParent(div);
					Columns columns = new Columns();
					columns.setParent(grid);
					for (String element : par.keySet()) {
						if(element.equals("AUTHORIZATION") || element.equals("HTTPMETHOD"))continue;
						Component column = new Column();
						column.setParent(columns);
						Label text = new Label();
						text.setParent(column);
						text.setValue(element);
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
							String label=DataFormatter.formatValue(((LinkedHashMap<String, Object>)par.get(element)).get("label"),null);
							String type=(String) ((LinkedHashMap<String, Object>)par.get(element)).get("type");
							
							if(type.startsWith("Conditional"))
								newValue+=" "+type;
							
							Label html = new Label(newValue);
							html.setParent(divv);

							if(Integer.parseInt(dr.get(MT.EVENT.EVENTDEFINITIONID).toString())<30
									&& label.equals("testId")) {
								divv.addEventListener(Events.ON_CLICK, this);
								divv.setAttribute("testId", Integer.parseInt(newValue));
								html.setStyle("text-weight:bold;padding:0px 0px 0px 4px;cursor:pointer;color:blue;");
							}
							
							if(null!=element && !label.equals(element)) {
								new Space().setParent(divv);
								Label htmllabel = new Label(label);
								htmllabel.setParent(divv);
							}
					}
		}else super.renderCell(div, columnName, eventListener);
	}

	@Override
	public void onEvent(Event event) throws Exception {

		if(event.getTarget() instanceof Div) {
			
			TestControler.editTest((Integer)event.getTarget().getAttribute("testId"),div.getParent()).doModal();
		}
		else {
			String url=(String) event.getTarget().getAttribute("AZUREURL");
			File file= new File(url);
			System.out.println(file.exists());
			Filedownload.save(file, "application/file");}
	}
}