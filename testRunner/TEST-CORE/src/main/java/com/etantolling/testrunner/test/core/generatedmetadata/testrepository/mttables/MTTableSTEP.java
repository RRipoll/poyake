package com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mttables;

import java.util.LinkedHashMap;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEenuSTEP;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

public class MTTableSTEP  extends MTTable{

		private static LinkedHashMap<String, MTField> fields = new LinkedHashMap<String, MTField>();

		public static final MTField STEPID = new MTField("STEPID");
		public static final MTField DESCRIPTION = new MTField("DESCRIPTION");

		static{
			fields.put("STEPID",STEPID);
			fields.put("DESCRIPTION",DESCRIPTION);

			STEPID.setSqlType(3);
			STEPID.setColumnSize(10);
			STEPID.setNativeTypeName("NUMBER");
			STEPID.setDecimalDigits(0);
			STEPID.setNullable(0);
			
			DESCRIPTION.setSqlType(12);
			DESCRIPTION.setColumnSize(255);
			DESCRIPTION.setNativeTypeName("VARCHAR2");
			DESCRIPTION.setDecimalDigits(null);
			DESCRIPTION.setNullable(1);
			


			for (MTField field:fields.values()) field.setTable("STEP");

		}

		public MTTableSTEP(){
			this.tableName = "STEP";
			this.isEnumeration=true;
			this.enumeration = new MTEenuSTEP();
			this.idField="DESCRIPTION";
			this.primaryKeys.add(STEPID);
		}

		@Override
		public LinkedHashMap<String, MTField> getFields() {
			return fields;
		}
	}

	
	

