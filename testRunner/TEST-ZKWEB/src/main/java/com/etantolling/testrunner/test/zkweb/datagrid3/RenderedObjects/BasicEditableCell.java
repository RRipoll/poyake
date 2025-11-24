package com.etantolling.testrunner.test.zkweb.datagrid3.RenderedObjects;

import java.util.LinkedHashMap;

import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.impl.InputElement;

import com.etantolling.testrunner.test.core.db.DetachedRow;

public class BasicEditableCell extends Components implements EventListener<Event>, IEditableCell{

	DetachedRow detachedRow;
	String columnName;
	InputElement editor;
	LinkedHashMap<String, Object> row;
	LinkedHashMap<LinkedHashMap<String, Object>, DetachedRow> detachedRowVector;
	HtmlBasedComponent parent;
	
	public BasicEditableCell(String columnName,LinkedHashMap<String, Object> row,LinkedHashMap<LinkedHashMap<String, Object>, DetachedRow> detachedRowVector,HtmlBasedComponent parent,InputElement editor ) {
		super();
		this.row=row;
		this.detachedRowVector=detachedRowVector;
		this.parent=parent;
		this.editor=editor;
		this.columnName=columnName;
		addEventListener(this);
	}

	@Override
	public InputElement getEditor() {
		
		return editor;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if(event.getName().equals(Events.ON_CHANGE) || event.getName().equals(Events.ON_OK) ){
			editor.setStyle(editor.getStyle()+";background: red;");
			DetachedRow detachedRow=null;
			if(detachedRowVector.containsKey(row)){
				detachedRow=detachedRowVector.get(row);
			}else{
				detachedRow= new DetachedRow(row);
			}	
			detachedRowVector.put(row, detachedRow);
			detachedRow.set(columnName, getValue());
		}
	}
}