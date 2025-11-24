package com.etantolling.testrunner.test.zkweb.datagrid3ws;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.util.resource.Labels;

public class DataGridModel {
	protected LinkedHashMap<String, String> headerLabels = new LinkedHashMap<String, String>();
	private Hashtable<String, String> columnSize = new Hashtable<String, String>();
	private Hashtable<String, String> columnHFlex = new Hashtable<String, String>();
	private Hashtable<String, String> columnWidths = new Hashtable<String, String>();
	private Hashtable<String, String> columnFormat = new Hashtable<String, String>();
	private Hashtable<String, String> columnAlign = new Hashtable<String, String>();
	private Hashtable<String, Object> initialMetaData= new Hashtable<String, Object>();

	public Hashtable<String, String> getColumnAlign() {
		return columnAlign;
	}

	protected Vector<String> hiddenColumns = new Vector<String>();
	int orderByField = 0;
	public DataGridQuery dgQuery;
	
	int pageNumber = 0;
	protected String headerZul;
	private String height = null;
	private String dataTableNameId=null;
	
	public Hashtable<String, String> getColumnFormat() {
		return columnFormat;
	}

	public DataGridModel(String wsURL, String wsHeader, String wsRequest, String wsHttpMethod, Class<?> refClass) throws Exception {
		init(wsURL, wsHeader, wsRequest, wsHttpMethod, refClass, null);
	}

	public DataGridModel(String wsURL, String wsHeader, String wsRequest, String wsHttpMethod, Class<?> refClass, Hashtable<String,Object>initialParameters) throws Exception {
		init(wsURL, wsHeader, wsRequest, wsHttpMethod, refClass, initialParameters);
	}
	
	public void init(String wsURL, String wsHeader, String wsRequest, String wsHttpMethod, Class<?> refClass, Hashtable<String,Object>initialParameters) throws Exception{
		dgQuery = new DataGridQuery(wsURL, wsHeader, wsRequest, wsHttpMethod, refClass, initialParameters, initialMetaData);
		for (String headerName : dgQuery.columnNames)
			if(null!=Labels.getLabel(dataTableNameId+"."+headerName))
				headerLabels.put(headerName,Labels.getLabel(dataTableNameId+"."+headerName));
			else if(null!=Labels.getLabel(headerName))
				headerLabels.put(headerName,Labels.getLabel(headerName));
			else headerLabels.put(headerName, headerName);
	}
	
	
	public LinkedHashMap<String, String> getHeaderLabels() {
		return headerLabels;
	}

	public DataGridQuery getDgQuery() {
		return dgQuery;
	}
	public String getColumnWidth(String headerName) {
		if (null != columnWidths.get(headerName)) return columnWidths.get(headerName) ;
		/*
		if (0 == columnWidths.size())
			return Integer.toString(100 / headerLabels.size()) + "%";
		*/
		return null;
	}
	
	
	public Hashtable<String, String> getColumnWidths() {
		return columnWidths;
	}
	public String getColumnSize(String headerName) {
		if (null != columnSize.get(headerName)) return columnSize.get(headerName) ;
		return null;
	}
	
	public String getColumnHFlex(String headerName) {
		if (null != columnHFlex.get(headerName)) return columnHFlex.get(headerName) ;
		return null;
	}
	
	public Hashtable<String, String> getColumnSize() {
		return columnSize;
	}

	public Hashtable<String, String> getColumnHFlex() {
		return columnHFlex;
	}
	
	public Vector<LinkedHashMap<String, Object>> getPage() throws Exception {
		return dgQuery.getPage(pageNumber);
	}

	public Vector<LinkedHashMap<String, Object>> getTotalResults() throws Exception {
		return dgQuery.getTotalResults();
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setPage(int newPage) {
		pageNumber = newPage;
	}

	public void setHeaderLabels(LinkedHashMap<String, String> headerLabels) {
		if (null != headerLabels)
			this.headerLabels = headerLabels;
	}
	
	public void setHeaderLabel(String columnName, String label){
		headerLabels.put(columnName, label);
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return "100%";
	}
	
	public void setColumnSize(String columnName, String style){
		columnSize.put(columnName, style);
	}
    public void setColumnWidth(String columnName, String width){
		columnWidths.put(columnName, width);
	}
	public Vector<String> getHiddenColumns() {
		return hiddenColumns;
	}

	public void setHiddenColumn(String hiddenColumn) {
		this.hiddenColumns.add(hiddenColumn);
	}
	
	public String getHeaderZul() {
		return headerZul;
	}

	public String getDataTableNameId() {
		return dataTableNameId;
	}

	public void setDataTableNameId(String dataTableNameId) {
		this.dataTableNameId = dataTableNameId;
	}
}