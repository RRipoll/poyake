package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.permission.MTTableROLPERMISSION;
import com.jsantos.metadata.permission.MTTableROL;

public class MTTableVROLLINK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField ROLPERMISSIONID;
	public static MTField ROLID;
	public static MTField PERMISSIONID;
	public static MTField SHORTCODE;
	public static MTField DESCRIPTION;
	public static final MTField USERGROUPS = new MTField("userGroups");

	public static void init(){
		fields = new ArrayList<>();
		ROLPERMISSIONID = new MTField(MTTableROLPERMISSION.ROLPERMISSIONID,"rolPermissionId");
		fields.add(ROLPERMISSIONID);
		{
			ROLPERMISSIONID.setDataType(MTDataTypes.INT);
			ROLPERMISSIONID.setNullable(true);
			ROLPERMISSIONID.setTransient(false);
		}
		ROLID = new MTField(MTTableROLPERMISSION.ROLID,"rolId");
		fields.add(ROLID);
		{
			ROLID.setDataType(MTDataTypes.INT);
			ROLID.setNullable(true);
			ROLID.setTransient(false);
			ROLID.setSequence("permission.Seq_VRolLink_rolId");
			ROLID.setPrimaryKey(true);
		}
		PERMISSIONID = new MTField(MTTableROLPERMISSION.PERMISSIONID,"permissionId");
		fields.add(PERMISSIONID);
		{
			PERMISSIONID.setDataType(MTDataTypes.INT);
			PERMISSIONID.setNullable(true);
			PERMISSIONID.setTransient(false);
		}
		SHORTCODE = new MTField(MTTableROL.SHORTCODE,"shortCode");
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		DESCRIPTION = new MTField(MTTableROL.DESCRIPTION,"description");
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(USERGROUPS);
		{
			USERGROUPS.setDataType(MTDataTypes.MULTIPLEOBJECT);
			USERGROUPS.setLength(8000);
			USERGROUPS.setNullable(false);
			USERGROUPS.setTransient(false);
		}
	}

	public MTTableVROLLINK(){
		init();
		this.tableName = "VRolLink";
		this.schema = "permission";
		this.entityType = "VIEW";
		this.primaryKeys.add(ROLID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}