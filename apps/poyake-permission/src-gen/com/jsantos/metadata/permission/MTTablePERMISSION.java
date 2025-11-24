package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePERMISSION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PERMISSIONID = new MTField("permissionId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField PERMISSIONTYPEID = new MTField("permissionTypeId");
	public static final MTField PERMISSIONVALUEID = new MTField("permissionValueId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PERMISSIONID);
		{
			PERMISSIONID.setDataType(MTDataTypes.INT);
			PERMISSIONID.setNullable(false);
			PERMISSIONID.setTransient(false);
			PERMISSIONID.setSequence("permission.Seq_Permission_permissionId");
			PERMISSIONID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(255);
			SHORTCODE.setNullable(false);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(false);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(PERMISSIONTYPEID);
		{
			PERMISSIONTYPEID.setDataType(MTDataTypes.INT);
			PERMISSIONTYPEID.setNullable(false);
			PERMISSIONTYPEID.setTransient(false);
			PERMISSIONTYPEID.setDefaultValue("1");
		}
		fields.add(PERMISSIONVALUEID);
		{
			PERMISSIONVALUEID.setDataType(MTDataTypes.INT);
			PERMISSIONVALUEID.setNullable(false);
			PERMISSIONVALUEID.setTransient(false);
			PERMISSIONVALUEID.setDefaultValue("2");
		}
	}

	public MTTablePERMISSION(){
		init();
		this.tableName = "Permission";
		this.schema = "permission";
		this.entityType = "TABLE";
		this.primaryKeys.add(PERMISSIONID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}