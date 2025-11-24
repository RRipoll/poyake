package com.etantolling.testrunner.test.zkweb.datagrid3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.util.resource.Labels;

import com.etantolling.testrunner.test.core.db.DataGridQuery;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;

public class DataGridModel {
	protected LinkedHashMap<String, String> headerLabels = new LinkedHashMap<String, String>();
	private Hashtable<String, String> columnSize = new Hashtable<String, String>();
	private Hashtable<String, String> columnHFlex = new Hashtable<String, String>();
	protected Hashtable<String, String> columnWidths = new Hashtable<String, String>();
	private Hashtable<String, String> columnFormat = new Hashtable<String, String>();
	private Hashtable<String, String> columnAlign = new Hashtable<String, String>();
	private Hashtable<String, String> columnDetail = new Hashtable<String, String>();
	private Hashtable<String, String> columnEditable = new Hashtable<String, String>();
	
	public Hashtable<String, String> getColumnEditable() {
		return columnEditable;
	}

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

	public Hashtable<String, String> getColumnDetail() {
		return columnDetail;
	}

	public DataGridModel(String sql) throws SQLException {
		init(sql,null);
	}

	public DataGridModel(String sql,Hashtable<String,Object>initialParameters) throws SQLException {
		init(sql,initialParameters);
	}
	
	public DataGridModel(String dataTableNameId,String sql,Hashtable<String,Object>initialParameters) throws SQLException {
		
		this.initialMetaData=DesktopHelper.getMetaDataSql(DataGridQuery.getMetaName(dataTableNameId,sql));
		this.dataTableNameId=dataTableNameId;
		init(sql,initialParameters);
		
	}

	
	public void init(String sql,Hashtable<String,Object>initialParameters) throws SQLException{
		Connection conn = MainDb.getConnection();
		try {
			dgQuery = new DataGridQuery(conn, sql,initialParameters, initialMetaData);
			DesktopHelper.setMetaDataSql(DataGridQuery.getMetaName(dataTableNameId,sql), dgQuery.getInitialMetaData());
			for (String headerName : dgQuery.columnNames)
				if(null!=Labels.getLabel(dataTableNameId+"."+headerName))
					headerLabels.put(headerName,Labels.getLabel(dataTableNameId+"."+headerName));
				else if(null!=Labels.getLabel(headerName))
					headerLabels.put(headerName,Labels.getLabel(headerName));
				else headerLabels.put(headerName, headerName);
		} finally {
			conn.close();
		}
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
	
	public Vector<LinkedHashMap<String, Object>> getPage() throws SQLException {
		Connection conn = MainDb.getConnection();
		try {
			return dgQuery.getPage(conn, pageNumber);
		} finally {
			conn.close();
		}
	}

	public Vector<LinkedHashMap<String, Object>> getTotalResults() throws SQLException {
		Connection conn = MainDb.getConnection();
		try {
			return dgQuery.getTotalResults(conn);
		} finally {
			conn.close();
		}
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