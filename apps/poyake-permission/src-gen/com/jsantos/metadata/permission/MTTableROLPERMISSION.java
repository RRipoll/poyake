package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableROLPERMISSION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ROLPERMISSIONID = new MTField("rolPermissionId");
	public static final MTField ROLID = new MTField("rolId");
	public static final MTField PERMISSIONID = new MTField("permissionId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ROLPERMISSIONID);
		{
			ROLPERMISSIONID.setDataType(MTDataTypes.INT);
			ROLPERMISSIONID.setNullable(false);
			ROLPERMISSIONID.setTransient(false);
			ROLPERMISSIONID.setSequence("permission.Seq_RolPermission_rolPermissionId");
			ROLPERMISSIONID.setPrimaryKey(true);
		}
		fields.add(ROLID);
		{
			ROLID.setDataType(MTDataTypes.INT);
			ROLID.setNullable(false);
			ROLID.setTransient(false);
			ROLID.getStereoTypes().add("LINK");
			ROLID.setDefaultValue("2");
		}
		fields.add(PERMISSIONID);
		{
			PERMISSIONID.setDataType(MTDataTypes.INT);
			PERMISSIONID.setNullable(false);
			PERMISSIONID.setTransient(false);
			PERMISSIONID.getStereoTypes().add("LINK");
		}
	}

	public MTTableROLPERMISSION(){
		init();
		this.tableName = "RolPermission";
		this.schema = "permission";
		this.entityType = "TABLE";
		this.primaryKeys.add(ROLPERMISSIONID);
		this.stereotypes.add("LINKTABLE");
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}