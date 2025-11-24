package com.etantolling.testrunner.testrunner2.regresion;

import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;

import com.etantolling.testrunner.test.zkweb.datagrid3.BasicRowAdapterEventId;

public class HistoryAdapter extends BasicRowAdapterEventId{

	@Override
	public void renderCell(HtmlBasedComponent div, String columnName, EventListener<Event> eventListener) throws SQLException {

		
		if(columnName.equals("FILES") ){
			
			Button button= new Button("Files");
			button.setAttribute("testRunnerId", row.get("TESTRUNNERID"));
			button.addEventListener(Events.ON_CLICK, eventListener);
			button.setParent(div);
			button.setAttribute("CELL_CLICK_INFO", div);
			((Component)div.getAttribute("container")).setAttribute("CELL_CLICK_INFO", div);
			
		}else 
			super.renderCell(div, columnName, eventListener);
	}
	
}
