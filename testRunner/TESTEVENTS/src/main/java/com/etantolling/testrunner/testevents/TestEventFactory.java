package com.etantolling.testrunner.testevents;

import com.etantolling.fastlane.sandag.tcs.wsdl.trip.client.TripTransactionCorectionInterfaceClient;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.client.TripTransactionInterfaceClient;
import com.etantolling.fastlane.wsdot.tcs.wsdl.client.v2.TransactionPortV2Client;
import com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily.client.DailyReconciliationPortClient;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEnuEVENTTYPE;
import com.etantolling.testrunner.test.core.testing.IEventProcessorFactory;
import com.etantolling.testrunner.test.core.testing.ITestEventRunner;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.AddStoreValues;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.CheckValueNull;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.CheckValues;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.CicleOfTests;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.CicleTestParallel;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.CicleTestParallelWaiting;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.FileService;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.JobService;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.RemoveStoreValues;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.RestJobWebService;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.RestWebService;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.RunATest;
import com.etantolling.testrunner.testevents.eventprocessors.webservices.TransactionPort_Client;

public class TestEventFactory implements IEventProcessorFactory{
	@Override
	public ITestEventRunner getEventRunner(Integer eventDefinitionId,Integer eventTypeId) {
		
		if(eventDefinitionId<1000 || eventDefinitionId==2209 || eventDefinitionId==2222 || eventDefinitionId==2234 || eventDefinitionId==2235) {
			switch (eventDefinitionId) {
			case 10:
				return new RunATest();
			case 20:
				return new  CicleOfTests();
			case 25:
				return new  CicleTestParallel();//CicleOfTests
			case 27:
				return new  CicleTestParallelWaiting();//CicleOfTests	
			case 30:
				return new  CheckValues();
			case 40:
				return new  TransactionPort_Client();	
			case 2209:
				return new  TransactionPortV2Client();		
			case 2222:
				return new  DailyReconciliationPortClient();	
			case 2234:
				return new TripTransactionInterfaceClient();
			case 2235:
				return new TripTransactionCorectionInterfaceClient();	
			case 50:
				return new  CheckValueNull();		
			case 60:
				return new  RemoveStoreValues();		
			case 70:
				return new  AddStoreValues();	
				
			default:
				throw new RuntimeException("Test class not found for dataTableName: " + eventDefinitionId);
			}
		}else if(eventTypeId==MTEnuEVENTTYPE.Rest_Event) {
			return new RestWebService();
		}else if (eventTypeId==MTEnuEVENTTYPE.Job_Event)
			return new JobService();
		else if (eventTypeId==MTEnuEVENTTYPE.File_Event)
			return new FileService();
		else if (eventTypeId==MTEnuEVENTTYPE.Rest_Job_Event)
			return new RestJobWebService();
		else {
			throw new RuntimeException("Test class not found for dataTableName: " + eventDefinitionId);
		}
	}	
}