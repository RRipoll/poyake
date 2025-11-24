package com.etantolling.testrunner.test.core.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import com.etantolling.testrunner.test.core.db.DataGridQuery;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class FillTextTable {

	String pattern;
	String originalPage;
	String flag="<!--TR-->";
	Hashtable<String,String> templates= new Hashtable<String,String>();
	String fieldName;
	
	public FillTextTable(String originalPage) {
		super();
		this.pattern = "###";
		this.originalPage=originalPage;
	}
	
	public FillTextTable(String originalPage,  String pattern) {
		super();
		this.pattern = pattern;
		this.originalPage=originalPage;
	}
	
	public void insertParameters(Connection conn,DataGridQuery dGQ) throws SQLException{
		insertParameters(conn,flag,dGQ);
	}

	public void insertParameters(DataGridQuery dGQ) throws SQLException{
		insertParameters(flag,dGQ);
	}
	
	public void insertParametersByTemplate(DataGridQuery dGQ) throws SQLException{
		
		try(Connection conn = MainDb.getConnection()){
			insertParametersByTemplate(conn,dGQ);
		}
	}
	
	public Vector<LinkedHashMap<String, Object>> insertParametersByTemplate(Connection conn,DataGridQuery dGQ) throws SQLException{
		
			Vector<LinkedHashMap<String, Object>> data=dGQ.getTotalResults(conn);
			insertParametersByTemplate(conn,flag, data);
			return data;
	};
	
	
	public void insertParametersByTemplate(Connection conn,String flag,Vector<LinkedHashMap<String, Object>> data) throws SQLException{
			
		if(null==flag) flag=this.flag;	
		if(null==data || data.size()==0){
			getTextPat(flag, true);
			return;
		}	

		String pat=getTextPat(flag);
		String retValue="";
		
		for (LinkedHashMap<String, Object> map : data) {
			String textTr=getTextPat(flag);
			if(null!= fieldName && templates.containsKey(map.get(fieldName))){
				textTr=templates.get(map.get(fieldName));
			}
			for (String fieldName : map.keySet()) {
				String searchValue=pattern+fieldName+pattern;
				String value=DataFormatter.formatValue(map.get(fieldName),null);
				textTr=textTr.replace(searchValue, value==null?"":value);
			}
			retValue+=textTr;
		}
		originalPage=originalPage.replace(pat,retValue );
	}
	
	public Vector<LinkedHashMap<String, Object>> insertParameters(String flag,DataGridQuery dGQ) throws SQLException {
		
		try(Connection conn = MainDb.getConnection()){
			return insertParameters(conn,flag,dGQ);
		}
	}
	
	public Vector<LinkedHashMap<String, Object>> insertParameters(Connection conn,String flag,DataGridQuery dGQ) throws SQLException {

		Vector<LinkedHashMap<String, Object>> data=dGQ.getTotalResults(conn);
		insertParameters(conn,flag, data);
		return data;
	}
	
	public void insertParameters(Connection conn,String flag,Vector<LinkedHashMap<String, Object>> data) throws SQLException {

		if(null==data) return;
		for (LinkedHashMap<String, Object> map : data) {
			insertParameters(conn,flag,map);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void insertParameters(Connection conn,String flag,LinkedHashMap<String, Object> data) throws SQLException {

		if(null==data)return;
		String pat=getTextPat(flag);
			String textTr=pat;
			for (String fieldName : data.keySet()) {
				if(fieldName.startsWith("<!--") && fieldName.endsWith("-->") && originalPage.contains("<!--") && fieldName.endsWith("-->"))
					insertParametersByTemplate(conn,fieldName,(Vector<LinkedHashMap<String, Object>>)data.get(fieldName));
				else{	
					String searchValue=pattern+fieldName+pattern;
					String value=DataFormatter.formatValue(data.get(fieldName),null);
					if(null==flag){ 
						originalPage=originalPage.replace(searchValue, value==null?"":value);
						if(null==data.get(fieldName) )
							getTextPat("<!--"+fieldName+"-->", true);
					}else textTr=textTr.replace(searchValue, value==null?"":value);
				}
			}
			if(null!=flag)originalPage=originalPage.replace(pat,textTr );
			;
	}

	private String getTextPat(String flag) {
		
		String retValue="";
		
		if(null==flag || !originalPage.contains(flag))return originalPage; 
		try {
			Integer startIndex=originalPage.indexOf(flag);
			String midlePage=originalPage.substring(startIndex+flag.length());
			Integer endIndex=midlePage.indexOf(flag)+flag.length()+startIndex;
			retValue= originalPage.substring(startIndex,endIndex );
		} catch (Exception e) {
			retValue= originalPage;
		}
		return retValue;
	}

	public String getTextPat(String tflag, boolean removeText) {
			
			String retValue=getTextPat(tflag);
			if(removeText && null!=tflag && retValue.contains(tflag))
				originalPage=originalPage.replace(retValue, "");
			return retValue;
	}
	
	public String getOriginalPage() {
		return originalPage;
	}

	public void setOriginalPage(String originalPage) {
		this.originalPage = originalPage;
	}
	
	
	 public class TemplateItem{
		 String fieldName;
		 String Value;
		 String templateName;
		 
		 public TemplateItem(String fieldName, String value, String templateName) {
			super();
			this.fieldName = fieldName;
			Value = value;
			this.templateName = templateName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getValue() {
			return Value;
		}

		public void setValue(String value) {
			Value = value;
		}

		public String getTemplateName() {
			return templateName;
		}

		public void setTemplateName(String templateName) {
			this.templateName = templateName;
		}
	 }

	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public Hashtable<String, String> getTemplates() {
		return templates;
	}


	public void setTemplates(Hashtable<String, String> templates) {
		this.templates = templates;
	}  
	
	static public Object getHash(String key,Vector<LinkedHashMap<String, Object>> data){
		
		for (LinkedHashMap<String, Object> lHM : data) {
			for (String lKey : lHM.keySet()) {
				if(lKey.equals(key))
					return  lHM.get(lKey);
			}
		}
	return null;	
	}
	
	
}