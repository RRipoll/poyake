package com.etantolling.testrunner.test.core.testing;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import com.etantolling.testrunner.test.core.utils.DataFormatter;
import com.etantolling.testrunner.test.core.utils.JsonStore;

public class TestParameterList {
	Map<String, Object> inputValues = new LinkedHashMap<String, Object>();
	Vector<TestInputFile> inputFiles = new Vector<TestInputFile>();
	Map<String, Object> outputValues = new LinkedHashMap<String, Object>();
	Wildcards wildcards = new Wildcards();
	JsonStore storeJson;
	
	public JsonStore getStoreJson() {
		return storeJson;
	}

	public void setStoreJson(JsonStore storeJson) {
		this.storeJson = storeJson;
	}

	public TestParameterList(){
		inputValues = new Hashtable<String, Object>();
	}
	
	public int getInt(Map<String, Object> values,String key) throws SQLException{
		if(null==values.get(key))return (Integer) null;
		Object value=null;
		if(values.get(key) instanceof Map) 
			value=((Map<String, Object>)values.get(key)).get("value");
		else value=values.get(key);
		if (value instanceof BigDecimal)
				return ((BigDecimal)value).intValue();
		else 
				return (int)value;
	}
	
	public String getString(Map<String, Object> values,String key)throws SQLException{
		if(null==values.get(key))return null;
		String retValue=values.get(key).toString();
		try {
			retValue= (String)((Map<String, Object>)values.get(key)).get("value");
		} catch (Exception e) {
			;
		}
		return retValue;
	}
	
	public BigDecimal getBigDecimal(Map<String, Object> values,String key) throws SQLException{
		if(null==values.get(key))return null;
		Object value=((Map<String, Object>)values.get(key)).get("value");
		
		if(value instanceof Integer)
			return new BigDecimal(value.toString());
		if (value instanceof String)
			return new BigDecimal(value.toString());
		else {
			if (value.toString().isEmpty()) {
				return null;
			}
			else {
				return (BigDecimal)value;
			}
		}
	}

	public Date getDate(Map<String, Object> values,String key) throws Exception{
		if(null==values.get(key))return null;
		Object value=((Map<String, Object>)values.get(key)).get("value");
		if (null == value)
			return null;
		if (value instanceof Date)
			return (Date)value;
		else if (value instanceof Timestamp)
			return new Date(((Timestamp)value).getTime());
		else if (value instanceof Long)
			return new Date((Long)value);
		else
			throw new Exception("TestParameterList coudn't map " + values.get(key).getClass() + " to Date for key: " + key);
	}
	
	public void setInt(Map<String, Object> values,String key, Integer value){
		if (null != values) values.put(key, value);
		else throw new RuntimeException("TestParameterList setInt should be used with a hashtable!");
	}
	
	public void setString(Map<String, Object> values,String key, String value){
		if (null != values) values.put(key, value);
		else throw new RuntimeException("TestParameterList setString should be used with a hashtable!");
	}

	public Vector<TestInputFile> getInputFiles() {
		return inputFiles;
	}

	public void setInputFiles(Vector<TestInputFile> inputFiles) {
		this.inputFiles = inputFiles;
	}
	
	public void setInputData(Map<String, Object> values,Map<String, Object> data) throws Exception {
		if(data != null) 
			for (String key : data.keySet())
				if (null != key && values != null && data.get(key) != null) {
					Map<String, Object> set=new LinkedHashMap<String, Object>((Map<String, Object>) data.get(key));
					
					set.put("label",wildcards.replaceWildCards((String) set.get("label"),null));
					if(null!=set.get("value") && set.get("value")  instanceof String) 
						set.put("value",wildcards.replaceWildCards((String) set.get("value"),null));
					
					if((boolean)set.get("isInput")==true)
							values.put(key, set);
					else values.put(key, set);
				}
	}

	public void setOutputData(Map<String, Object> values,Map<String, Object> data) throws Exception {
		if(data != null) 
			for (String key : data.keySet())
				if (null != key && values != null && data.get(key) != null) {
					Map<String, Object> set=new LinkedHashMap<String, Object>((Map<String, Object>) data.get(key));

					set.put("label",wildcards.replaceWildCards((String) set.get("label"),null));
					if(null!=set.get("value") && set.get("value")  instanceof String) 
						set.put("value",wildcards.replaceWildCards((String) set.get("value"),null));

					if((boolean)set.get("isOutput")==true)
							values.put(key, set);
				}
	}

	public void setEventData(Map<String, Object> values,Map<String, Object> data) throws Exception {
		if(data != null) 
			for (String key : data.keySet())
				if (null != key && values != null && data.get(key) != null) {
						values.put(key, data.get(key));
				}
	}

	public Map<String, Object> getInputValues() {
		return inputValues;
	}

	public Map<String, Object> getOutputValues() {
		return outputValues;
	}

	public  void checkStoreValues(LinkedHashMap<String, Object> storeValues) {
		
		//replacing inputValues list for storeValues
		for (String key : inputValues.keySet()) {
			if(key.equals("EVENT_ID") || key.equals("AUTHORIZATION"))continue;
			String label=(String) ((Map<String, Object>)inputValues.get(key)).get("label");
			Object value=((Map<String, Object>)inputValues.get(key)).get("value");
			Object type=((Map<String, Object>)inputValues.get(key)).get("type");
			if(type.toString().startsWith("Condition"))continue;
			if(null!=label && label.contains("<") && label.contains(">") ) {
					for (String name : storeValues.keySet()) {
						if(label.contains("<"+name+">")) {
							label=label.replaceAll("<"+name+">", DataFormatter.formatDate(storeValues.get(name)));
							((Map<String, Object>)inputValues.get(key)).put("label",label);
						}
					}
			}
		}

		//replacing inputValues with inputValues (Json and url in inputvalues)
		for (String inputkey : inputValues.keySet()) {
			if(inputkey.equals("EVENT_ID") || inputkey.equals("AUTHORIZATION"))continue;
			Object inputkeyValue=null;
			String label=null;
			if(inputValues.get(inputkey) instanceof Map) {
				 inputkeyValue=((Map<String, Object>) inputValues.get(inputkey)).get("value");
				 label=(String) ((Map<String, Object>) inputValues.get(inputkey)).get("label");
				 Object type=((Map<String, Object>)inputValues.get(inputkey)).get("type");
				 if(type.toString().startsWith("Condition"))continue;
			}else { 
				inputkeyValue=inputValues.get(inputkey);
				label=inputkey;
			}
			if(null!=inputkeyValue && inputkeyValue.toString().length()>0) { //insert inputvalues in json and url.
				for (String  inputKey2 : inputValues.keySet()) {
					if(inputkey.equals("EVENT_ID") || inputkey.equals("AUTHORIZATION"))continue;
					if(inputKey2.equals("JSON") || inputKey2.equals("URL")) {
						if(inputValues.get(inputKey2) instanceof Map) {
							Map<String,Object> input2=(Map<String, Object>) inputValues.get(inputKey2);
							if(null ==input2.get("value"))continue;
							String value2=DataFormatter.formatDate(input2.get("value"));
							String inputkeyValueString= DataFormatter.formatDate(inputkeyValue);
							if(null==inputkeyValueString) continue;
							if(!(input2.get("value") instanceof String) ) {
								value2=value2.replace("\"<"+label+">\"",inputkeyValueString);
								value2=value2.replace("\"{"+label+"}\"",inputkeyValueString);
								value2=value2.replace("\"<"+inputkey+">\"",inputkeyValueString);
								value2=value2.replace("\"{"+inputkey+"}\"",inputkeyValueString);
							}
							
							value2=value2.replace("<"+label+">", inputkeyValueString);
							value2=value2.replace("{"+label+"}",inputkeyValueString);
							value2=value2.replace("<"+inputkey+">",inputkeyValueString);
							value2=value2.replace("{"+inputkey+"}",inputkeyValueString);
							
							value2=wildcards.replaceWildCards(value2,storeValues);
							input2.put("value", value2);
					}
				}}
			}
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>stored values");

		for (String storekey : storeValues.keySet()) {
			System.out.println(storekey + ":"+ storeValues.get(storekey));
			if(null!=storeValues.get(storekey) ) {
				for (String  inputKey : inputValues.keySet()) { // insert store Values in inputvalues.
					if(inputKey.equals("EVENT_ID") || inputKey.equals("AUTHORIZATION"))continue;
					Object type=((Map<String, Object>)inputValues.get(inputKey)).get("type");
					 if(type.toString().startsWith("Condition"))continue;
					if(inputValues.get(inputKey) instanceof Map) {
						Map<String,Object> input=(Map<String, Object>) inputValues.get(inputKey);
						if(input.get("label").equals(storekey)) {
							if(null==input.get("value")  || (null!=input.get("value") && !input.get("value").toString().startsWith("<")))
								input.put("value", storeValues.get(storekey));
						
						}
						if(inputKey.equals("JSON") || inputKey.equals("URL")) {
							String value=input.get("value").toString();
//							if(!(storeValues.get(storekey) instanceof String) && !(storeValues.get(storekey) instanceof Date)  ) {
//								value=value.replace("\"<"+storekey+">\"", DataFormatter.formatDate(storeValues.get(storekey)));
//								value=value.replace("\"{"+storekey+"}\"",DataFormatter.formatDate(storeValues.get(storekey)));
//							}
							
							value=value.replace("<"+storekey+">",DataFormatter.formatDate(storeValues.get(storekey)));
							value=value.replace("{"+storekey+"}",DataFormatter.formatDate(storeValues.get(storekey)));
							
							value=wildcards.replaceWildCards(value,storeValues);
							
							input.put("value", value);
							
						}
					}else if(inputValues.containsKey(storekey) && null==inputValues.get(storekey)) {
							inputValues.put(storekey, storeValues.get(storekey));
					}
				}
			}
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<stored values");
	}
	
	public static  String jsonReplace(String value,LinkedHashMap<String, Object> storeValues,Wildcards wildcards) {
		for (String storekey : storeValues.keySet()) {
			if (null != storeValues.get(storekey)){
				if(!(storeValues.get(storekey) instanceof String) ) {
						value=value.replace("\"<"+storekey+">\"",storeValues.get(storekey).toString());
						value=value.replace("\"{"+storekey+"}\"",storeValues.get(storekey).toString());
				}
			
			value=value.replace("<"+storekey+">",storeValues.get(storekey).toString());
			value=value.replace("{"+storekey+"}",storeValues.get(storekey).toString());
			}
		}
		value=wildcards.replaceWildCards(value,storeValues);
		return value;
	}

	public Wildcards getWildcards() {
		return wildcards;
	}

	public void setWildcards(Wildcards wildcards) {
		this.wildcards = wildcards;
	}
}