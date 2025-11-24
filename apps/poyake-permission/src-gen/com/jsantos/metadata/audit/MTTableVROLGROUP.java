package com.jsantos.metadata.audit;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.permission.MTTableROL;

public class MTTableVROLGROUP extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField ROLID;
	public static MTField SHORTCODE;
	public static MTField DESCRIPTION;
	public static final MTField USERGROUPS = new MTField("userGroups");

	public static void init(){
		fields = new ArrayList<>();
		ROLID = new MTField(MTTableROL.ROLID,"rolId");
		fields.add(ROLID);
		{
			ROLID.setDataType(MTDataTypes.INT);
			ROLID.setNullable(true);
			ROLID.setTransient(false);
			ROLID.setSequence("audit.Seq_VrolGroup_rolId");
			ROLID.setPrimaryKey(true);
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
			USERGROUPS.setNullable(true);
			USERGROUPS.setTransient(false);
		}
	}

	public MTTableVROLGROUP(){
		init();
		this.tableName = "VrolGroup";
		this.schema = "audit";
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