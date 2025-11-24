package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableHOME extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField HOMEID = new MTField("homeId");
	public static final MTField POSTINGDATE = new MTField("postingDate");
	public static final MTField CUSTOMERID = new MTField("customerId");
	public static final MTField NAME = new MTField("name");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(HOMEID);
		{
			HOMEID.setDataType(MTDataTypes.INT);
			HOMEID.setNullable(true);
			HOMEID.setTransient(false);
			HOMEID.setSequence("multi.Seq_Home_homeId");
			HOMEID.setPrimaryKey(true);
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATE);
			POSTINGDATE.setNullable(false);
			POSTINGDATE.setTransient(false);
			POSTINGDATE.getStereoTypes().add("NOGUIINPUT");
			POSTINGDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
		}
		fields.add(NAME);
		{
			NAME.setDataType(MTDataTypes.VARCHAR);
			NAME.setLength(255);
			NAME.setNullable(true);
			NAME.setTransient(false);
			NAME.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableHOME(){
		init();
		this.tableName = "Home";
		this.schema = "multi";
		this.entityType = "TABLE";
		this.primaryKeys.add(HOMEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}