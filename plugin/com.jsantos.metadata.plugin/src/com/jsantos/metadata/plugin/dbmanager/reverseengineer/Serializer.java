package com.jsantos.metadata.plugin.dbmanager.reverseengineer;


import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.DataTypeDetails;
import com.jsantos.metadata.plugin.metaDsl.Entity;

public class Serializer {
	public String serialize(Entity entity) {
		StringBuffer out = new StringBuffer();
		out.append(entity.getEntityType() + " ENTITY " + entity.getName() + "{\r\n");
		for (Attribute attribute:entity.getAttributes()) {
			out.append("\t");
			if (attribute.isUnique())
				out.append("UQ ");
			if (attribute.isPk())
				out.append("PK ");
			out.append(attribute.getName());
			out.append(" " + serializeDataType(attribute));
			if (attribute.isNotNullable())
				out.append(" NOTNULL ");
			if (null != attribute.getFkto())
				out.append(" FKTO " + attribute.getFkto().getName());
			if (null != attribute.getDefault())
				out.append(" DEFAULT \"" + attribute.getDefault() + "\"") ;
			out.append("\r\n");
		}
		out.append("}\r\n");
		return out.toString();
	}
	
	public String serializeDataType(Attribute attribute) {
		String retValue =  attribute.getType().getName();
		DataTypeDetails details = (DataTypeDetails)attribute.getType().getDetails();
		if (details.isWithLength())
			retValue += "(" + attribute.getLength() + ")";
		if (details.isWithPrecissionAndScale())
			retValue += "(" + attribute.getLength() + "," + attribute.getScale() + ")";
		return retValue;
	}
}
