package com.jsantos.metadata.testrunner;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class TestDTO extends DetachedRecord{

	public TestDTO(){
		super(MTBase.getTable("TEST"));
	}

	public TestDTO(ResultSet rs){
		super(MTBase.getTable("TEST"), rs);
	}

	public TestDTO(Integer pk) {
		super(MTBase.getTable("TEST"), pk);
	}

	public TestDTO(String whereClause) {
		super(MTBase.getTable("TEST"), whereClause);
	}

	public java.lang.String getTestUuid(){ 
		return (java.lang.String) get(MTTableTEST.TESTUUID);
	}

	public void setTestUuid(java.lang.String testUuid){ 
		set(MTTableTEST.TESTUUID, testUuid);
	} 

	public java.lang.String getTestname(){ 
		return (java.lang.String) get(MTTableTEST.TESTNAME);
	}

	public void setTestname(java.lang.String testname){ 
		set(MTTableTEST.TESTNAME, testname);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableTEST.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableTEST.DESCRIPTION, description);
	} 

	public java.lang.String getKeywords(){ 
		return (java.lang.String) get(MTTableTEST.KEYWORDS);
	}

	public void setKeywords(java.lang.String keywords){ 
		set(MTTableTEST.KEYWORDS, keywords);
	} 

	public java.lang.Object getEvents(){ 
		return (java.lang.Object) get(MTTableTEST.EVENTS);
	}

	public void setEvents(java.lang.Object events){ 
		set(MTTableTEST.EVENTS, events);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableTEST.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableTEST.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableTEST.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableTEST.INPUTSOURCEID, inputSourceId);
	} 

	public java.util.Date getCreated(){ 
		return (java.util.Date) get(MTTableTEST.CREATED);
	}

	public void setCreated(java.util.Date created){ 
		set(MTTableTEST.CREATED, created);
	} 

	public void update() {
		super.update();
	}

	public TestDTO insert() {
		return (TestDTO) super.insert();
	}

	public static TestDTO find(String whereExpression) {
		try {
			return new TestDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}