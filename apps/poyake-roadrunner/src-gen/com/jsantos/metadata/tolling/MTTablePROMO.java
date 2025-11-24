package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePROMO extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PROMOID = new MTField("promoId");
	public static final MTField CUSTOMERID = new MTField("customerId");
	public static final MTField PROMOTYPEID = new MTField("promoTypeId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PROMOID);
		{
			PROMOID.setDataType(MTDataTypes.INT);
			PROMOID.setNullable(true);
			PROMOID.setTransient(false);
			PROMOID.setSequence("tolling.Seq_Promo_promoId");
			PROMOID.setPrimaryKey(true);
		}
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(false);
			CUSTOMERID.setTransient(false);
		}
		fields.add(PROMOTYPEID);
		{
			PROMOTYPEID.setDataType(MTDataTypes.INT);
			PROMOTYPEID.setNullable(false);
			PROMOTYPEID.setTransient(false);
			PROMOTYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Promo Type"));
		}
	}

	public MTTablePROMO(){
		init();
		this.tableName = "Promo";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(PROMOID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}