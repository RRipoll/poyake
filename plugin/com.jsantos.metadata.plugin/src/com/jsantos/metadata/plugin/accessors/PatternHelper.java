package com.jsantos.metadata.plugin.accessors;

import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.Pattern;

public class PatternHelper {
	public static boolean matchAttribute(Attribute patternAttribute, Entity entity) {
		for (Attribute attribute:entity.getAttributes()) {
			if (attribute.getName().equalsIgnoreCase(patternAttribute.getName()))
				return true;
		}
		return false;
	}
	
	public static boolean entityImplementsPattern(Entity entity, String sPattern) {
		if (null !=entity.getPatterns()) {
			for (Pattern pattern:entity.getPatterns())
				if (pattern.getName().equalsIgnoreCase(sPattern))
					return true;
		}
		return false;
	}
}
