package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.audit.MTTableINPUTUSERGROUP;

public class MTTableVGROUPROL extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField INPUTUSERGROUPID;
	public static MTField SHORTCODE;
	public static MTField DESCRIPTION;
	public static final MTField ROLS = new MTField("rols");

	public static void init(){
		fields = new ArrayList<>();
		INPUTUSERGROUPID = new MTField(MTTableINPUTUSERGROUP.INPUTUSERGROUPID,"inputUserGroupId");
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(true);
			INPUTUSERGROUPID.setTransient(false);
			INPUTUSERGROUPID.setSequence("permission.Seq_VgroupRol_inputUserGroupId");
			INPUTUSERGROUPID.setPrimaryKey(true);
		}
		SHORTCODE = new MTField(MTTableINPUTUSERGROUP.SHORTCODE,"shortCode");
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		DESCRIPTION = new MTField(MTTableINPUTUSERGROUP.DESCRIPTION,"description");
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(ROLS);
		{
			ROLS.setDataType(MTDataTypes.MULTIPLEOBJECT);
			ROLS.setLength(8000);
			ROLS.setNullable(true);
			ROLS.setTransient(false);
		}
	}

	public MTTableVGROUPROL(){
		init();
		this.tableName = "VgroupRol";
		this.schema = "permission";
		this.entityType = "VIEW";
		this.primaryKeys.add(INPUTUSERGROUPID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}