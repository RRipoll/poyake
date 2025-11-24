package com.jsantos.metadata.audit;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.audit.MTTableUSERGROUP;
import com.jsantos.metadata.audit.MTTableINPUTUSER;
import com.jsantos.metadata.audit.MTTableINPUTUSERGROUP;

public class MTTableVUSERGROUP extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField USERGROUPID;
	public static MTField INPUTUSERGROUPID;
	public static MTField USERID;
	public static MTField CREATED;
	public static MTField INPUTUSERID;
	public static MTField INPUTSOURCEID;
	public static MTField LOGINNAME;
	public static MTField FULLNAME;
	public static MTField GROUPNAME;
	public static MTField GROUPDESCRIPTION;

	public static void init(){
		fields = new ArrayList<>();
		USERGROUPID = new MTField(MTTableUSERGROUP.USERGROUPID,"userGroupId");
		fields.add(USERGROUPID);
		{
			USERGROUPID.setDataType(MTDataTypes.INT);
			USERGROUPID.setNullable(true);
			USERGROUPID.setTransient(false);
			USERGROUPID.setSequence("audit.Seq_VuserGroup_userGroupId");
			USERGROUPID.setPrimaryKey(true);
		}
		INPUTUSERGROUPID = new MTField(MTTableUSERGROUP.INPUTUSERGROUPID,"inputUserGroupId");
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(true);
			INPUTUSERGROUPID.setTransient(false);
		}
		USERID = new MTField(MTTableUSERGROUP.USERID,"userId");
		fields.add(USERID);
		{
			USERID.setDataType(MTDataTypes.INT);
			USERID.setNullable(true);
			USERID.setTransient(false);
		}
		CREATED = new MTField(MTTableUSERGROUP.CREATED,"created");
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
		INPUTUSERID = new MTField(MTTableUSERGROUP.INPUTUSERID,"inputUserId");
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(true);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
			INPUTUSERID.getStereoTypes().add("NOGUIINPUT");
		}
		INPUTSOURCEID = new MTField(MTTableUSERGROUP.INPUTSOURCEID,"inputSourceId");
			INPUTSOURCEID.getLabels().add(new Label("SHORTLABEL","en_EN","Source #"));
			INPUTSOURCEID.getLabels().add(new Label("SHORTLABEL","es_ES","# Origen"));
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(true);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
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
			LOGINNAME.getStereoTypes().add("DESCRIPTION");
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
		}
		GROUPNAME = new MTField(MTTableINPUTUSERGROUP.SHORTCODE,"groupName");
		fields.add(GROUPNAME);
		{
			GROUPNAME.setDataType(MTDataTypes.VARCHAR);
			GROUPNAME.setLength(16);
			GROUPNAME.setNullable(true);
			GROUPNAME.setTransient(false);
		}
		GROUPDESCRIPTION = new MTField(MTTableINPUTUSERGROUP.DESCRIPTION,"groupDescription");
		fields.add(GROUPDESCRIPTION);
		{
			GROUPDESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			GROUPDESCRIPTION.setLength(32);
			GROUPDESCRIPTION.setNullable(true);
			GROUPDESCRIPTION.setTransient(false);
			GROUPDESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableVUSERGROUP(){
		init();
		this.tableName = "VuserGroup";
		this.schema = "audit";
		this.entityType = "VIEW";
		this.primaryKeys.add(USERGROUPID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}