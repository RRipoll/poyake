package com.etantolling.testrunner.test.core.spring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

public class SpringEnvironmentUtils {

	private static final Logger log = LoggerFactory.getLogger(SpringEnvironmentUtils.class);
	
	public void logEnvironment(Environment env){
		log.info("Default spring profiles:");
		for (String defaultProfile:env.getDefaultProfiles())
			System.out.print(defaultProfile);
		log.info("\r\n");

		log.info("All Spring properties: ");
		HashMap<String,Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
		for(Iterator it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext(); ) {
			PropertySource propertySource = (PropertySource) it.next();
			Map<String, Object> propertySourceMap = new HashMap<String, Object>();
			map.put(propertySource.getName(), propertySourceMap);
			if (propertySource instanceof MapPropertySource) {
				propertySourceMap.putAll(((MapPropertySource) propertySource).getSource());
			}
		}

		for (String propertySource:map.keySet()){
			log.info("------------------------------------- Property source: {}", propertySource);
			for (String key:map.get(propertySource).keySet())
				log.info(key + ": " + map.get(propertySource).get(key));
			log.info("-------------------------------------");
		}
	}
}
