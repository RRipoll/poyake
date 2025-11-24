package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUPERMISSIONVALUE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PERMISSIONVALUEID = new MTField("permissionValueId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PERMISSIONVALUEID);
		{
			PERMISSIONVALUEID.setDataType(MTDataTypes.INT);
			PERMISSIONVALUEID.setNullable(false);
			PERMISSIONVALUEID.setTransient(false);
			PERMISSIONVALUEID.setSequence("permission.Seq_EnuPermissionValue_permissionValueId");
			PERMISSIONVALUEID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(false);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(false);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENUPERMISSIONVALUE(){
		init();
		this.tableName = "EnuPermissionValue";
		this.schema = "permission";
		this.entityType = "TABLE";
		this.primaryKeys.add(PERMISSIONVALUEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuPermissionValue();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}