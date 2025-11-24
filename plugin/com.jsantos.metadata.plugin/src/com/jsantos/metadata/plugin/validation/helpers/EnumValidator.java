package com.jsantos.metadata.plugin.validation.helpers;

import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;

public class EnumValidator {

	public static boolean checkPkName(Entity entity) {
		return true;
	}
	
	public static boolean checkShortCode(Entity entity) {
		for (Attribute attribute:entity.getAttributes()) {
			if (attribute.getName().equals("shortCode")) {
				if ("VARCHAR".equals(attribute.getType().getName()))
						return true;
			}
		}
		return false;
	}

	public static boolean checkDescription(Entity entity) {
		for (Attribute attribute:entity.getAttributes()) {
			if (attribute.getName().equals("description")) {
				if ("VARCHAR".equals(attribute.getType().getName()))
						return true;
			}
		}
		return false;
	}
	

}
