package com.jsantos.runningTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jsantos.common.util.ListValues;
import com.jsantos.custom.extendeddto.StoreValuesTestExtDTO;
import com.jsantos.metadata.testrunner.StoreValuesTestDTO;
import com.jsantos.metadata.testrunner.TestDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.service.ITestEventRunner;

public class TestRunner {

	private static final Logger log = LoggerFactory.getLogger(TestRunner.class);
		
	TestDTO test;
	
	StoreValuesTestExtDTO storeValues;
	
	Wildcards wildcards = new Wildcards();

	public TestDTO getTest() {
		return test;
	}

	public void setTest(TestDTO test) {
		this.test = test;
	}

	public StoreValuesTestDTO getStoreValues() {
		return storeValues;
	}

	public void setStoreValues(StoreValuesTestExtDTO storeValues) {
		this.storeValues = storeValues;
	}

	public TestRunner(TestDTO test, StoreValuesTestExtDTO storeValues) throws Exception {
		this.test = test;
        this.storeValues=storeValues;		
		
	}

	@SuppressWarnings("unchecked")
	public void runTest() throws Exception {
		
		ListValues<IDetachedRecord> eventList=(ListValues<IDetachedRecord>)test.getEvents();
		for (IDetachedRecord event : eventList) {
			runEvent(event);
		}
	}

	public void runEvent(IDetachedRecord event) throws Exception {
		Object selected= event.get(event.findFieldByname("selected"));
		if(selected instanceof Boolean) {
			if(!(boolean)selected)
				return;
		}else if(((Integer)selected)!=1)
			return;
		
		ITestEventRunner eventRunner =  TestEventTypeFactory.getProvider(event.getString(event.findFieldByname("eventTypeId")));
	    eventRunner.runEvent(event, storeValues);
	}

	public Wildcards getWildcards() {
		return wildcards;
	}

	public void setWildcards(Wildcards wildcards) {
		this.wildcards = wildcards;
	}
}