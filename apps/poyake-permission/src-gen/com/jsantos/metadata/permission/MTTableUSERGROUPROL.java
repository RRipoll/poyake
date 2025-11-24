package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableUSERGROUPROL extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField USERGROUPROLID = new MTField("userGroupRolId");
	public static final MTField ROLID = new MTField("rolId");
	public static final MTField INPUTUSERGROUPID = new MTField("inputUserGroupId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(USERGROUPROLID);
		{
			USERGROUPROLID.setDataType(MTDataTypes.INT);
			USERGROUPROLID.setNullable(false);
			USERGROUPROLID.setTransient(false);
			USERGROUPROLID.setSequence("permission.Seq_UserGroupRol_userGroupRolId");
			USERGROUPROLID.setPrimaryKey(true);
		}
		fields.add(ROLID);
		{
			ROLID.setDataType(MTDataTypes.INT);
			ROLID.setNullable(false);
			ROLID.setTransient(false);
			ROLID.getStereoTypes().add("LINK");
		}
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(false);
			INPUTUSERGROUPID.setTransient(false);
			INPUTUSERGROUPID.getStereoTypes().add("LINK");
		}
	}

	public MTTableUSERGROUPROL(){
		init();
		this.tableName = "UserGroupRol";
		this.schema = "permission";
		this.entityType = "TABLE";
		this.primaryKeys.add(USERGROUPROLID);
		this.stereotypes.add("LINKTABLE");
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}