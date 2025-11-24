package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableSTOREVALUESTEST extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField STOREVALUESTESTID = new MTField("storeValuestestId");
	public static final MTField TESTRUNNER_API_URL = new MTField("testRunner_Api_Url");
	public static final MTField APP_API_URL = new MTField("app_Api_Url");
	public static final MTField JOB_API_URL = new MTField("job_Api_Url");
	public static final MTField STOREVALUESEVENTS = new MTField("storeValuesEvents");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(STOREVALUESTESTID);
		{
			STOREVALUESTESTID.setDataType(MTDataTypes.INT);
			STOREVALUESTESTID.setNullable(true);
			STOREVALUESTESTID.setTransient(false);
			STOREVALUESTESTID.setSequence("testrunner.Seq_StoreValuesTest_storeValuestestId");
			STOREVALUESTESTID.setPrimaryKey(true);
		}
		fields.add(TESTRUNNER_API_URL);
		{
			TESTRUNNER_API_URL.setDataType(MTDataTypes.VARCHAR);
			TESTRUNNER_API_URL.setLength(256);
			TESTRUNNER_API_URL.setNullable(true);
			TESTRUNNER_API_URL.setTransient(false);
			TESTRUNNER_API_URL.setDefaultValue("Http://localHost:8081");
		}
		fields.add(APP_API_URL);
		{
			APP_API_URL.setDataType(MTDataTypes.VARCHAR);
			APP_API_URL.setLength(256);
			APP_API_URL.setNullable(true);
			APP_API_URL.setTransient(false);
			APP_API_URL.setDefaultValue("Http://localHost:8081");
		}
		fields.add(JOB_API_URL);
		{
			JOB_API_URL.setDataType(MTDataTypes.VARCHAR);
			JOB_API_URL.setLength(256);
			JOB_API_URL.setNullable(true);
			JOB_API_URL.setTransient(false);
			JOB_API_URL.setDefaultValue("Http://localHost:8081");
		}
		fields.add(STOREVALUESEVENTS);
		{
			STOREVALUESEVENTS.setDataType(MTDataTypes.PARAMETER);
			STOREVALUESEVENTS.setNullable(true);
			STOREVALUESEVENTS.setTransient(false);
		}
	}

	public MTTableSTOREVALUESTEST(){
		init();
		this.tableName = "StoreValuesTest";
		this.schema = "testrunner";
		this.entityType = "VIEW";
		this.primaryKeys.add(STOREVALUESTESTID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}