package com.etantolling.testrunner.test.core.utils;

import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.etantolling.testrunner.test.core.testing.TestParameterList;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;


public class JsonStore {
	
	public JsonStore() {
		super();
		
		String jsonHiWorld = "{\"message\":\"Hi\",\"place\":{\"name\":\"World!\"}}\"";
		  String message = JsonPath.read(jsonHiWorld, "$.message");
		  String place = JsonPath.read(jsonHiWorld, "$.place.name");
		  System.out.println(message + " " + place); // print "Hi World!"
		  ReadContext context=JsonPath.parse(jsonHiWorld);
		
		setJsonContext("{\"main\":0}");
	}

	
	

	
	
	ReadContext jsonContext;
	
	public ReadContext getJsonContext() {
		return jsonContext;
	}

	public void setJsonContext(ReadContext jsonContext) {
		this.jsonContext = jsonContext;
	}
	
	public void setJsonContext(String jsonDataSourceString) {
		if(null!=jsonDataSourceString)
		this.jsonContext= JsonPath.parse(jsonDataSourceString);
		else {
			this.jsonContext= JsonPath.parse("{}");
		}
	}
	
	public void addJsonString(String name,String jsonDataSourceString) {
		
		//jsonContext.set(JsonPath.compile("$."+name), jsonDataSourceString);
	}
	
	public Object getJsonString(String filter) {
		
		
		return jsonContext.read(filter);
	}
	
	public void checkValues(TestParameterList list) {
		for (Entry<String, Object> item :list.getInputValues().entrySet()) {
			item.setValue(replaceJonPath(item.getValue().toString()));
		}
	}
	
	public String replaceJonPath(String value) {
		
		final String regexAdd = "\\$[\\.\\w- (\\[\\d*\\])? \\?(@\\.\\d =<>)]*";
		final Pattern patternAdd = Pattern.compile(regexAdd);
		Matcher matcher = patternAdd.matcher(value);
		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));
			for (int i = 1; i <= matcher.groupCount(); i++) {
				String label = matcher.group(i);
				String jsonvalue=jsonContext.read(label);
				value=value.replace(label, jsonvalue);
			}
		}
		return value;
	}
	
}




