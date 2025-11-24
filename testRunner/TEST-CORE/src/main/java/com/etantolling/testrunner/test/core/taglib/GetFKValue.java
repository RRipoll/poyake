package com.etantolling.testrunner.test.core.taglib;

import java.sql.SQLException;

import com.etantolling.testrunner.test.core.db.ForeignKeyHelper;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.MTField;

public class GetFKValue {
	
	public static Object getFKvalue(java.lang.String fullyQualifiedFieldName, Integer pk) throws SQLException{
		if (null == pk) return null;
		MTField mtField = MT.getField(fullyQualifiedFieldName);
		if (null == mtField)
			throw new RuntimeException("No metadata found for fieldName " + fullyQualifiedFieldName + " in getFkValue taglib function");
		if (null == mtField.getForeignKey())
			throw new RuntimeException("field " + mtField.getName() + " is not a foreign key");
		
		return ForeignKeyHelper.getForeignKeyValue(mtField, pk);
	}
}
