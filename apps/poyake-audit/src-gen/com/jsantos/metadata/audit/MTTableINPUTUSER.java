package com.jsantos.metadata.audit;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableINPUTUSER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField LOGINNAME = new MTField("loginName");
	public static final MTField PASSWD = new MTField("passwd");
	public static final MTField FULLNAME = new MTField("fullName");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");
	public static final MTField EMAIL = new MTField("email");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(true);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.setSequence("audit.Seq_InputUser_inputUserId");
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
			INPUTUSERID.setPrimaryKey(true);
		}
		fields.add(LOGINNAME);
		{
			LOGINNAME.setDataType(MTDataTypes.VARCHAR);
			LOGINNAME.setLength(64);
			LOGINNAME.setNullable(false);
			LOGINNAME.setTransient(false);
			LOGINNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Login Name "));
			LOGINNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Login"));
			LOGINNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(PASSWD);
		{
			PASSWD.setDataType(MTDataTypes.PASSWORD);
			PASSWD.setLength(256);
			PASSWD.setNullable(true);
			PASSWD.setTransient(false);
			PASSWD.getLabels().add(new Label("SHORTLABEL","en_EN","Passwd"));
			PASSWD.getLabels().add(new Label("SHORTLABEL","es_ES","Passwd"));
		}
		fields.add(FULLNAME);
		{
			FULLNAME.setDataType(MTDataTypes.VARCHAR);
			FULLNAME.setLength(128);
			FULLNAME.setNullable(true);
			FULLNAME.setTransient(false);
			FULLNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Full Name"));
			FULLNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre Completo"));
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.getLabels().add(new Label("SHORTLABEL","en_EN","Created By"));
			CREATED.getLabels().add(new Label("SHORTLABEL","es_ES","Creado por"));
			CREATED.getStereoTypes().add("NOGUIINPUT");
			CREATED.setDefaultValue("getPostingDate()");
		}
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(false);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getLabels().add(new Label("SHORTLABEL","en_EN","Source #"));
			INPUTSOURCEID.getLabels().add(new Label("SHORTLABEL","es_ES","# Origen"));
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
			INPUTSOURCEID.setDefaultValue("1");
		}
		fields.add(EMAIL);
		{
			EMAIL.setDataType(MTDataTypes.EMAIL);
			EMAIL.setLength(64);
			EMAIL.setNullable(true);
			EMAIL.setTransient(false);
		}
	}

	public MTTableINPUTUSER(){
		init();
		this.tableName = "InputUser";
		this.schema = "audit";
		this.entityType = "TABLE";
		this.primaryKeys.add(INPUTUSERID);
		this.patterns.add("Audited");
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}