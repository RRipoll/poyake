package com.etantolling.testrunner.test.core.testing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ITestEventRunner {
	static final Logger log = LoggerFactory.getLogger(ITestEventRunner.class);

	void showSummary(String url, Object parameters, String json, String responseCode, String responseBody);
	void showStarting(String url, Object parameters, String json);
	LinkedHashMap<String, Object> runEvent(TestParameterList params, LinkedHashMap<String, Object> storeValues,
			String testBaseUrl, String appBaseUrl, String appJobUrl) throws Exception;
}
