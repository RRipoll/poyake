package com.jsantos.metadata.plugin.validation.helpers;

import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.Metadata;

public class EntityValidator {
	
	public static String calculatePatternPkName(Entity entity) {
		String entityName = EntityHelper.getSimpleName(entity);
		if (entity.getStereotypes().toString().contains("ENUM")) {
			if (entityName.length()<4)
				return null;
			else
				return entityName.substring(3,4).toLowerCase() +  entityName.substring(4, entityName.length())+ "Id";
		}
		else
			return entityName.substring(0,1).toLowerCase() + entityName.substring(1, entityName.length()) + "Id";
	}

	public static Entity getEntityforMetadata(Metadata metadata) {
		if (metadata.eContainer() instanceof Entity)
			return (Entity)metadata.eContainer();
		if (null != metadata.getEntity())
			return metadata.getEntity();
		return null;
	}
}
