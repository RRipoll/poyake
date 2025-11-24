package com.jsantos.metadata.audit;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.audit.MTTableINPUTUSER;

public class MTTableVINPUTUSERMULTI extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField INPUTUSERID;
	public static MTField LOGINNAME;
	public static MTField PASSWD;
	public static MTField FULLNAME;
	public static MTField CREATED;
	public static MTField INPUTSOURCEID;
	public static final MTField USERGROUPS = new MTField("usergroups");

	public static void init(){
		fields = new ArrayList<>();
		INPUTUSERID = new MTField(MTTableINPUTUSER.INPUTUSERID,"inputUserId");
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(true);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.setSequence("audit.Seq_VinputUserMulti_inputUserId");
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
			INPUTUSERID.setPrimaryKey(true);
		}
		LOGINNAME = new MTField(MTTableINPUTUSER.LOGINNAME,"loginName");
			LOGINNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Login Name "));
			LOGINNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Login"));
		fields.add(LOGINNAME);
		{
			LOGINNAME.setDataType(MTDataTypes.VARCHAR);
			LOGINNAME.setLength(64);
			LOGINNAME.setNullable(true);
			LOGINNAME.setTransient(false);
			LOGINNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Login Name "));
			LOGINNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Login"));
		}
		PASSWD = new MTField(MTTableINPUTUSER.PASSWD,"passwd");
			PASSWD.getLabels().add(new Label("SHORTLABEL","en_EN","Passwd"));
			PASSWD.getLabels().add(new Label("SHORTLABEL","es_ES","Passwd"));
		fields.add(PASSWD);
		{
			PASSWD.setDataType(MTDataTypes.PASSWORD);
			PASSWD.setLength(256);
			PASSWD.setNullable(true);
			PASSWD.setTransient(false);
			PASSWD.getLabels().add(new Label("SHORTLABEL","en_EN","Passwd"));
			PASSWD.getLabels().add(new Label("SHORTLABEL","es_ES","Passwd"));
		}
		FULLNAME = new MTField(MTTableINPUTUSER.FULLNAME,"fullName");
			FULLNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Full Name"));
			FULLNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre Completo"));
		fields.add(FULLNAME);
		{
			FULLNAME.setDataType(MTDataTypes.VARCHAR);
			FULLNAME.setLength(128);
			FULLNAME.setNullable(true);
			FULLNAME.setTransient(false);
			FULLNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Full Name"));
			FULLNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre Completo"));
			FULLNAME.getStereoTypes().add("DESCRIPTION");
		}
		CREATED = new MTField(MTTableINPUTUSER.CREATED,"created");
			CREATED.getLabels().add(new Label("SHORTLABEL","en_EN","Created By"));
			CREATED.getLabels().add(new Label("SHORTLABEL","es_ES","Creado por"));
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(true);
			CREATED.setTransient(false);
			CREATED.getLabels().add(new Label("SHORTLABEL","en_EN","Created By"));
			CREATED.getLabels().add(new Label("SHORTLABEL","es_ES","Creado por"));
			CREATED.getStereoTypes().add("NOGUIINPUT");
		}
		INPUTSOURCEID = new MTField(MTTableINPUTUSER.INPUTSOURCEID,"inputSourceId");
			INPUTSOURCEID.getLabels().add(new Label("SHORTLABEL","en_EN","Source #"));
			INPUTSOURCEID.getLabels().add(new Label("SHORTLABEL","es_ES","# Origen"));
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(true);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
		}
		fields.add(USERGROUPS);
		{
			USERGROUPS.setDataType(MTDataTypes.MULTIPLEOBJECT);
			USERGROUPS.setLength(8000);
			USERGROUPS.setNullable(true);
			USERGROUPS.setTransient(false);
		}
	}

	public MTTableVINPUTUSERMULTI(){
		init();
		this.tableName = "VinputUserMulti";
		this.schema = "audit";
		this.entityType = "VIEW";
		this.primaryKeys.add(INPUTUSERID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}