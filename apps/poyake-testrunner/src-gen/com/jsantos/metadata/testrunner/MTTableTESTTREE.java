package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.testrunner.MTTableTEST;

public class MTTableTESTTREE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField TESTUUID;
	public static final MTField TESTNAME = new MTField("testname");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField KEYWORDS = new MTField("keywords");
	public static final MTField EVENTS = new MTField("events");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");
	public static final MTField CREATED = new MTField("created");
	public static final MTField FOLDERPATH = new MTField("FOLDERPATH");

	public static void init(){
		fields = new ArrayList<>();
		TESTUUID = new MTField(MTTableTEST.TESTUUID,"testUuid");
		fields.add(TESTUUID);
		{
			TESTUUID.setDataType(MTDataTypes.UUID);
			TESTUUID.setLength(130);
			TESTUUID.setNullable(false);
			TESTUUID.setTransient(false);
			TESTUUID.setSequence("testrunner.Seq_TestTree_testUuid");
			TESTUUID.setPrimaryKey(true);
		}
		fields.add(TESTNAME);
		{
			TESTNAME.setDataType(MTDataTypes.VARCHAR);
			TESTNAME.setLength(64);
			TESTNAME.setNullable(false);
			TESTNAME.setTransient(false);
			TESTNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(KEYWORDS);
		{
			KEYWORDS.setDataType(MTDataTypes.VARCHAR);
			KEYWORDS.setLength(255);
			KEYWORDS.setNullable(true);
			KEYWORDS.setTransient(false);
			KEYWORDS.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(EVENTS);
		{
			EVENTS.setDataType(MTDataTypes.PARAMETER);
			EVENTS.setNullable(true);
			EVENTS.setTransient(false);
		}
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(false);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getStereoTypes().add("NOGUIINPUT");
			INPUTUSERID.setDefaultValue("1");
		}
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(false);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
			INPUTSOURCEID.setDefaultValue("1");
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.getStereoTypes().add("NOGUIINPUT");
			CREATED.setDefaultValue("getPostingDate()");
		}
		fields.add(FOLDERPATH);
		{
			FOLDERPATH.setDataType(MTDataTypes.VARCHAR);
			FOLDERPATH.setLength(255);
			FOLDERPATH.setNullable(true);
			FOLDERPATH.setTransient(false);
		}
	}

	public MTTableTESTTREE(){
		init();
		this.tableName = "TestTree";
		this.schema = "testrunner";
		this.entityType = "VIEW";
		this.primaryKeys.add(TESTUUID);
		this.patterns.add("Audited");
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}