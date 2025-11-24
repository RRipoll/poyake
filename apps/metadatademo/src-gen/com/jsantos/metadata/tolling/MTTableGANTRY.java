package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableGANTRY extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField GANTRYID = new MTField("gantryId");
	public static final MTField ROADSIDEGANTRYUNIQUEID = new MTField("roadsideGantryUniqueId");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(GANTRYID);
		{
			GANTRYID.setDataType(MTDataTypes.INT);
			GANTRYID.setNullable(true);
			GANTRYID.setTransient(false);
			GANTRYID.setSequence("tolling.Seq_Gantry_gantryId");
			GANTRYID.setPrimaryKey(true);
		}
		fields.add(ROADSIDEGANTRYUNIQUEID);
		{
			ROADSIDEGANTRYUNIQUEID.setDataType(MTDataTypes.VARCHAR);
			ROADSIDEGANTRYUNIQUEID.setLength(128);
			ROADSIDEGANTRYUNIQUEID.setNullable(false);
			ROADSIDEGANTRYUNIQUEID.setTransient(false);
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

	public MTTableGANTRY(){
		init();
		this.tableName = "Gantry";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(GANTRYID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}