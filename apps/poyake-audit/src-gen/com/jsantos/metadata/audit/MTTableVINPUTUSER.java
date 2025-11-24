package com.jsantos.metadata.audit;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.audit.MTTableINPUTUSER;
import com.jsantos.metadata.audit.MTTableUSERGROUP;

public class MTTableVINPUTUSER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField INPUTUSERID;
	public static MTField LOGINNAME;
	public static MTField PASSWD;
	public static MTField CREATED;
	public static MTField FULLNAME;
	public static MTField INPUTUSERGROUPID;

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
			INPUTUSERID.setSequence("audit.Seq_VinputUser_inputUserId");
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
		CREATED = new MTField(MTTableINPUTUSER.CREATED,"created");
			CREATED.getLabels().add(new Label("SHORTLABEL","en_EN","Created By"));
			CREATED.getLabels().add(new Label("SHORTLABEL","es_ES","Creado por"));
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATE);
			CREATED.setNullable(true);
			CREATED.setTransient(false);
			CREATED.getLabels().add(new Label("SHORTLABEL","en_EN","Created By"));
			CREATED.getLabels().add(new Label("SHORTLABEL","es_ES","Creado por"));
			CREATED.getStereoTypes().add("NOGUIINPUT");
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
		INPUTUSERGROUPID = new MTField(MTTableUSERGROUP.INPUTUSERGROUPID,"inputUserGroupId");
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(true);
			INPUTUSERGROUPID.setTransient(false);
		}
	}

	public MTTableVINPUTUSER(){
		init();
		this.tableName = "VinputUser";
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