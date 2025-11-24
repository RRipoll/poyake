package com.jsantos.metadata.audit;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableUSERGROUP extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField USERGROUPID = new MTField("userGroupId");
	public static final MTField INPUTUSERGROUPID = new MTField("inputUserGroupId");
	public static final MTField USERID = new MTField("userId");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(USERGROUPID);
		{
			USERGROUPID.setDataType(MTDataTypes.INT);
			USERGROUPID.setNullable(false);
			USERGROUPID.setTransient(false);
			USERGROUPID.setSequence("audit.Seq_UserGroup_userGroupId");
			USERGROUPID.setPrimaryKey(true);
		}
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(false);
			INPUTUSERGROUPID.setTransient(false);
			INPUTUSERGROUPID.getStereoTypes().add("LINK");
		}
		fields.add(USERID);
		{
			USERID.setDataType(MTDataTypes.INT);
			USERID.setNullable(false);
			USERID.setTransient(false);
			USERID.getStereoTypes().add("LINK");
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
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(false);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
			INPUTUSERID.getStereoTypes().add("NOGUIINPUT");
			INPUTUSERID.setDefaultValue("1");
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
	}

	public MTTableUSERGROUP(){
		init();
		this.tableName = "UserGroup";
		this.schema = "audit";
		this.entityType = "TABLE";
		this.primaryKeys.add(USERGROUPID);
		this.patterns.add("Audited");
		this.stereotypes.add("LINKTABLE");
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}