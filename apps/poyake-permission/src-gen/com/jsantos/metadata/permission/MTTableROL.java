package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableROL extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ROLID = new MTField("rolId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ROLID);
		{
			ROLID.setDataType(MTDataTypes.INT);
			ROLID.setNullable(true);
			ROLID.setTransient(false);
			ROLID.setSequence("permission.Seq_Rol_rolId");
			ROLID.setPrimaryKey(true);
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

	public MTTableROL(){
		init();
		this.tableName = "Rol";
		this.schema = "permission";
		this.entityType = "TABLE";
		this.primaryKeys.add(ROLID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}