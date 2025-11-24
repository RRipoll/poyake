package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.multi.MTTableHOME;

public class MTTableVHOME2 extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField HOMEID;
	public static MTField POSTINGDATE;
	public static MTField CUSTOMERID;
	public static final MTField ROOM2S = new MTField("room2s");

	public static void init(){
		fields = new ArrayList<>();
		HOMEID = new MTField(MTTableHOME.HOMEID,"homeId");
		fields.add(HOMEID);
		{
			HOMEID.setDataType(MTDataTypes.INT);
			HOMEID.setNullable(true);
			HOMEID.setTransient(false);
			HOMEID.setSequence("multi.Seq_Vhome2_homeId");
			HOMEID.setPrimaryKey(true);
		}
		POSTINGDATE = new MTField(MTTableHOME.POSTINGDATE,"postingDate");
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATE);
			POSTINGDATE.setNullable(true);
			POSTINGDATE.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableHOME.CUSTOMERID,"customerId");
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
		fields.add(ROOM2S);
		{
			ROOM2S.setDataType(MTDataTypes.MULTIPLEENUM);
			ROOM2S.setLength(8000);
			ROOM2S.setNullable(false);
			ROOM2S.setTransient(false);
		}
	}

	public MTTableVHOME2(){
		init();
		this.tableName = "Vhome2";
		this.schema = "multi";
		this.entityType = "VIEW";
		this.primaryKeys.add(HOMEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}