package com.etantolling.testrunner.test.utils.misc;

import java.beans.PersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class MiscUtility {

	public String getStringFromObject( Object data){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			XMLEncoder xmlEncoder = new XMLEncoder(bos);
			PersistenceDelegate pd = xmlEncoder.getPersistenceDelegate(Integer.class); 
			xmlEncoder.setPersistenceDelegate(BigDecimal.class, pd);
			xmlEncoder.writeObject(data);
			xmlEncoder.flush();
			xmlEncoder.close();
			return bos.toString().replace("\n", "");
		} catch (RuntimeException e) {
			;
		}
		 return null;
	}
	
	@SuppressWarnings("unchecked")
	public Object getObjectFromString(String data){
		
		 XMLDecoder xmlDecoder = new XMLDecoder(new ByteArrayInputStream(data.getBytes()));
		 Object parsedMap = xmlDecoder.readObject();
		 xmlDecoder.close();
		return parsedMap;
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	    return map.entrySet()
	              .stream()
	              .sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}
}
