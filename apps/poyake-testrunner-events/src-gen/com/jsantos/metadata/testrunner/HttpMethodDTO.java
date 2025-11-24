package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class HttpMethodDTO extends DetachedRecord{

	public HttpMethodDTO(){
		super(MTBase.getTable("HTTPMETHOD"));
	}

	public HttpMethodDTO(ResultSet rs){
		super(MTBase.getTable("HTTPMETHOD"), rs);
	}

	public HttpMethodDTO(Integer pk) {
		super(MTBase.getTable("HTTPMETHOD"), pk);
	}

	public HttpMethodDTO(String whereClause) {
		super(MTBase.getTable("HTTPMETHOD"), whereClause);
	}

	public java.lang.Integer getHttpMethodId(){ 
		return (java.lang.Integer) get(MTTableHTTPMETHOD.HTTPMETHODID);
	}

	public void setHttpMethodId(java.lang.Integer httpMethodId){ 
		set(MTTableHTTPMETHOD.HTTPMETHODID, httpMethodId);
	} 

	public java.lang.String getShortCode(){ 
		return (java.lang.String) get(MTTableHTTPMETHOD.SHORTCODE);
	}

	public void setShortCode(java.lang.String shortCode){ 
		set(MTTableHTTPMETHOD.SHORTCODE, shortCode);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableHTTPMETHOD.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableHTTPMETHOD.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public HttpMethodDTO insert() {
		return (HttpMethodDTO) super.insert();
	}

	public static HttpMethodDTO find(String whereExpression) {
		try {
			return new HttpMethodDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}