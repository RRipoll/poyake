package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class TestTreeDTO extends DetachedRecord{

	public TestTreeDTO(){
		super(MTBase.getTable("TESTTREE"));
	}

	public TestTreeDTO(ResultSet rs){
		super(MTBase.getTable("TESTTREE"), rs);
	}

	public TestTreeDTO(Integer pk) {
		super(MTBase.getTable("TESTTREE"), pk);
	}

	public TestTreeDTO(String whereClause) {
		super(MTBase.getTable("TESTTREE"), whereClause);
	}

	public java.lang.String getTestUuid(){ 
		return (java.lang.String) get(MTTableTESTTREE.TESTUUID);
	}

	public void setTestUuid(java.lang.String testUuid){ 
		set(MTTableTESTTREE.TESTUUID, testUuid);
	} 

	public java.lang.String getTestname(){ 
		return (java.lang.String) get(MTTableTESTTREE.TESTNAME);
	}

	public void setTestname(java.lang.String testname){ 
		set(MTTableTESTTREE.TESTNAME, testname);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableTESTTREE.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableTESTTREE.DESCRIPTION, description);
	} 

	public java.lang.String getKeywords(){ 
		return (java.lang.String) get(MTTableTESTTREE.KEYWORDS);
	}

	public void setKeywords(java.lang.String keywords){ 
		set(MTTableTESTTREE.KEYWORDS, keywords);
	} 

	public java.lang.Object getEvents(){ 
		return (java.lang.Object) get(MTTableTESTTREE.EVENTS);
	}

	public void setEvents(java.lang.Object events){ 
		set(MTTableTESTTREE.EVENTS, events);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableTESTTREE.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableTESTTREE.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableTESTTREE.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableTESTTREE.INPUTSOURCEID, inputSourceId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableTESTTREE.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableTESTTREE.CREATED, created);
	} 

	public java.lang.String getFOLDERPATH(){ 
		return (java.lang.String) get(MTTableTESTTREE.FOLDERPATH);
	}

	public void setFOLDERPATH(java.lang.String FOLDERPATH){ 
		set(MTTableTESTTREE.FOLDERPATH, FOLDERPATH);
	} 

	public void update() {
		super.update();
	}

	public TestTreeDTO insert() {
		return (TestTreeDTO) super.insert();
	}

	public static TestTreeDTO find(String whereExpression) {
		try {
			return new TestTreeDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}