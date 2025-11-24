package com.etantolling.testrunner.test.core.metadata;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public abstract class MTEnumeration {
	public abstract LinkedHashMap<Integer, String> getHashmap();
	public String getValue(Integer key){return getHashmap().get(key);}
	public Set<Integer> getKeys(){return getHashmap().keySet();}
	public Collection<String> getValues(){return getHashmap().values();}
	public Integer getKeyForValue(String value){
		for (Integer o:getHashmap().keySet())
			if (getHashmap().get(o).equals(value))
				return o;
		return null;
	}
	
}
