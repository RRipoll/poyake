package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.permission.MTTablePERMISSION;

public class MTTableVPERMISSIONROL extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField PERMISSIONID;
	public static MTField SHORTCODE;
	public static MTField DESCRIPTION;
	public static MTField PERMISSIONTYPEID;
	public static MTField PERMISSIONVALUEID;
	public static final MTField ROLS = new MTField("rols");

	public static void init(){
		fields = new ArrayList<>();
		PERMISSIONID = new MTField(MTTablePERMISSION.PERMISSIONID,"permissionId");
		fields.add(PERMISSIONID);
		{
			PERMISSIONID.setDataType(MTDataTypes.INT);
			PERMISSIONID.setNullable(true);
			PERMISSIONID.setTransient(false);
			PERMISSIONID.setSequence("permission.Seq_VPermissionRol_permissionId");
			PERMISSIONID.setPrimaryKey(true);
		}
		SHORTCODE = new MTField(MTTablePERMISSION.SHORTCODE,"shortCode");
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(255);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		DESCRIPTION = new MTField(MTTablePERMISSION.DESCRIPTION,"description");
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		PERMISSIONTYPEID = new MTField(MTTablePERMISSION.PERMISSIONTYPEID,"permissionTypeId");
		fields.add(PERMISSIONTYPEID);
		{
			PERMISSIONTYPEID.setDataType(MTDataTypes.INT);
			PERMISSIONTYPEID.setNullable(true);
			PERMISSIONTYPEID.setTransient(false);
		}
		PERMISSIONVALUEID = new MTField(MTTablePERMISSION.PERMISSIONVALUEID,"permissionValueId");
		fields.add(PERMISSIONVALUEID);
		{
			PERMISSIONVALUEID.setDataType(MTDataTypes.INT);
			PERMISSIONVALUEID.setNullable(true);
			PERMISSIONVALUEID.setTransient(false);
		}
		fields.add(ROLS);
		{
			ROLS.setDataType(MTDataTypes.MULTIPLEOBJECT);
			ROLS.setLength(8000);
			ROLS.setNullable(false);
			ROLS.setTransient(false);
		}
	}

	public MTTableVPERMISSIONROL(){
		init();
		this.tableName = "VPermissionRol";
		this.schema = "permission";
		this.entityType = "VIEW";
		this.primaryKeys.add(PERMISSIONID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}