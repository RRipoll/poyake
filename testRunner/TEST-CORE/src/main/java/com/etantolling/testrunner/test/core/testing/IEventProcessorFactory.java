package com.etantolling.testrunner.test.core.testing;


public interface IEventProcessorFactory {
	
	public ITestEventRunner getEventRunner(Integer eventDefinitionId, Integer eventTypeId);

}
