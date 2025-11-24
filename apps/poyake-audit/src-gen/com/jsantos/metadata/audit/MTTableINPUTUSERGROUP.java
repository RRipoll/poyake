package com.jsantos.metadata.audit;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableINPUTUSERGROUP extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField INPUTUSERGROUPID = new MTField("inputUserGroupId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(true);
			INPUTUSERGROUPID.setTransient(false);
			INPUTUSERGROUPID.setSequence("audit.Seq_InputUserGroup_inputUserGroupId");
			INPUTUSERGROUPID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableINPUTUSERGROUP(){
		init();
		this.tableName = "InputUserGroup";
		this.schema = "audit";
		this.entityType = "TABLE";
		this.primaryKeys.add(INPUTUSERGROUPID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}