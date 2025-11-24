package com.etantolling.testrunner.test.zkweb.datagrid3.RenderedObjects;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zhtml.Table;
import org.zkoss.zhtml.Tbody;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Text;
import org.zkoss.zhtml.Thead;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;

import com.etantolling.testrunner.test.core.db.DataGridQuery;
import com.etantolling.testrunner.test.zkweb.datagrid3.BasicRowAdapter;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataGridModel;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTable;
import com.etantolling.testrunner.test.zkweb.datagrid3.filter.DataGridFilter;



public class DataTableBackOffice extends DataTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5055117073696286506L;

	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataTableBackOffice(DataGridModel dgModel, DataGridFilter filter, BasicRowAdapter rowAdapter, EventListener eventListener, String cssClass) throws SQLException {
		super(dgModel, filter, rowAdapter, eventListener, cssClass);

	}

	@Override
	public Vector<LinkedHashMap<String, Object>> render() throws SQLException {
		this.setVisible(true);
		if(isOnlyPageCheckbox){
			//selectionMan.selectedSet.clear();
			VectorCheckBox.clear();
			
		}
		
		
		dgModel.getDgQuery().getRowCount();
		
		if(null!=dgModel.getDgQuery().getMaxResults() && dgModel.getDgQuery().getMaxResults()<dgModel.getDgQuery().getRowCount())
			throw new WrongValueException(null,"Search returns more than "+dgModel.getDgQuery().getMaxResults()+" results, Please refine your search ");
	
		
		if (null != mainComponent)
			parentComponent.removeChild(mainComponent);

		Table table = new Table();

		table.setStyle("border-collapse:collapse;");
		Radiogroup group = null;
		if (SELECTOR_RADIO == getSelectorType()) {
			group = new Radiogroup();
			table.setParent(group);
		}

		table.setStyle("width:" + dgModel.getWidth());
		// table.setStyle("height:" + getRowAdapter().getHeight());

		renderHeaders(table);
		Vector<LinkedHashMap<String, Object>> page=renderBody(table);

		if (SELECTOR_RADIO == getSelectorType())
			mainComponent = group;
		else
			mainComponent = table;

		mainComponent.setParent(parentComponent);
		
		if(null != pagination){
			pagination.setPageSize(dgModel.dgQuery.getPageSize());
			pagination.setRowCount(dgModel.getDgQuery().getRowCount());
		}
		return page;
	}

	@Override
	public void renderHeaders(Component table) {
		Tr tr = new Tr();
		tr.setParent(table);
		Td td = new Td();
		td.setParent(tr);
		Table tablehead = new Table();
		tablehead.setStyle("width:100%;align:left;");
		tablehead.setParent(td);

		Thead thead = new Thead();
		thead.setParent(tablehead);
		Tr trHead = new Tr();
		trHead.setParent(thead);

		if (SELECTOR_CHECKBOX == selectorType) {
			td = new Td();
			td.setParent(trHead);
			td.setSclass("hederTDplaincheckbox");
			//td.setStyle("width:25px;");
			pageCheckbox.setParent(td);
			pageCheckbox.setAttribute("GLOBAL_CHECKBOX", "YES");
			pageCheckbox.addEventListener("onCheck", this);
		}
		if (SELECTOR_RADIO == selectorType) {
			td = new Td();
			td.setParent(trHead);
			td.setSclass("hederTDplaincheckbox");
			//td.setStyle("width:25px;");
		}

		DataGridQuery dgQuery = dgModel.getDgQuery();
		for (String headerName : dgQuery.getColumnNames()) {
			if (dgModel.getHiddenColumns().contains(headerName))
				continue;
			
			if (null != getDgModel().getHeaderLabels().get(headerName)) {
				td = new Td();
				td.setParent(trHead);
				td.setAttribute("COLUMN_POSITION", new Integer(dgQuery.getColumnNames().indexOf(headerName)));
				td.setAttribute("COLUMN_ORDERBY_NAME", headerName);
				td.setSclass("hederTDplain");

			}
			if (null != dgModel.getColumnSize(headerName))
				td.setStyle(dgModel.getColumnSize(headerName)
						 );
			Text text = new Text();
				text.setParent(td);
				text.setValue(dgModel.getHeaderLabels().get(headerName));
				td.addEventListener("onClick", this);
				if (null != dgQuery.getOrderByField()){
					if (dgQuery.getOrderByField().equals(headerName)) {
						if (!dgQuery.isAsc(headerName))
							text.setValue(text.getValue() + ((char) 8595));
						else
							text.setValue(text.getValue() + ((char) 8593));
					}
				}
		}
		
	}

	@Override
	public Vector<LinkedHashMap<String, Object>> renderBody(Component table) throws SQLException {
		boolean allChecked = true;

		Tr tr = new Tr();
		tr.setParent(table);
		Td td = new Td();
		td.setParent(tr);
		Div divBody = new Div();
		divBody.setParent(td);
		divBody.setStyle("height:" + dgModel.getHeight() + ";width:" + dgModel.getWidth() + ";overflow-y:auto;overflow-x:hidden");
		Table tablebody = new Table();
		// tablebody.setStyle("height:" + getRowAdapter().getHeight());
		// table.setStyle("height:" + getRowAdapter().getHeight());
		tablebody.setParent(divBody);

		Tbody tbody = new Tbody();
		if (SELECTOR_RADIO == selectorType) {
			Radiogroup group = new Radiogroup();
			group.setParent(tablebody);
			tbody.setParent(group);
		} else {
			tbody.setParent(tablebody);
		}
		Vector<LinkedHashMap<String, Object>> page = dgModel.getPage();
		for (LinkedHashMap<String, Object> row : page) {
			rowAdapter.setRow(dgModel, row);
			tr = new Tr();
			tr.setParent(tbody);
			tr.setSclass((0 == page.indexOf(row) % 2 ? "trOdd" : "trEven"));
			if (SELECTOR_CHECKBOX == selectorType) {
				td = new Td();
				td.setParent(tr);
				// td.setSclass("fieldValue");
				td.setSclass("headerTDcheckbox");
				//td.setStyle("width:25px;");
				Checkbox checkbox = new Checkbox();
				checkbox.setParent(td);
				checkbox.addEventListener("onCheck", this);
				String id = rowAdapter.getRowId();
				if (null != id)
					checkbox.setAttribute("ROW_ID", id);
				checkbox.setAttribute("container", td);
				checkbox.setChecked(selectionMan.isChecked(id));
				if (!checkbox.isChecked())
					allChecked = false;
				applyTrSelectionStyle(checkbox, selectionMan.isChecked(id));
				VectorCheckBox.add(checkbox);
			}
			if (SELECTOR_RADIO == selectorType) {
				td = new Td();
				td.setParent(tr);
				// td.setSclass("fieldValue");
				td.setSclass("headerTDcheckbox");
				//td.setStyle("width:25px;border:0");
				Radio radio = new Radio();
				radio.setParent(td);
				radio.addEventListener("onCheck", this);
				radio.setAttribute("container", td);
				Object id = rowAdapter.getRowId();
				if (null != id){
					radio.setAttribute("ROW_ID", id);
					radio.setChecked(selectionMan.isChecked(id));
				}
			}
			for (String columnName : dgModel.getDgQuery().getColumnNames()) {
				if (dgModel.getHiddenColumns().contains(columnName))
					continue;
				
				if (null == getDgModel().getHeaderLabels() || null != getDgModel().getHeaderLabels().get(columnName)) {
					td = new Td();
					td.setParent(tr);
					td.setAttribute("container", tr);
					td.setSclass("headerTD");
					if (null != dgModel.getColumnWidth(columnName)) {
						td.setStyle("max-width:" + dgModel.getColumnWidth(columnName) + ";min-width:" + dgModel.getColumnWidth(columnName) + ";width:" + dgModel.getColumnWidth(columnName));

					}
					Div div = new Div();
					div.setAttribute("datamodel", dgModel);
					div.setParent(td);
					div.setAttribute("container", td);
					// if (null != dgModel.getColumnWidths().get(columnName))
					// div.setStyle("width:" + dgModel.getColumnWidths().get(columnName) + "px");
					rowAdapter.renderCell(div, columnName, this);
				}
			}
			
		}
		/*
		if(null!=filter && null!=filter.pagingGoogle){
			filter.pagingGoogle.setParent(divBody);
		}
		*/
		pageCheckbox.setChecked(allChecked);
		
		return page;
	}

	@Override
	public void applyTrSelectionStyle(Component comp, boolean isChecked) {

	}

}