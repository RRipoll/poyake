package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUTRANSACTIONTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField TRANSACTIONTYPEID = new MTField("transactionTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(TRANSACTIONTYPEID);
		{
			TRANSACTIONTYPEID.setDataType(MTDataTypes.INT);
			TRANSACTIONTYPEID.setNullable(true);
			TRANSACTIONTYPEID.setTransient(false);
			TRANSACTIONTYPEID.setSequence("acc.Seq_EnuTransactionType_transactionTypeId");
			TRANSACTIONTYPEID.setPrimaryKey(true);
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

	public MTTableENUTRANSACTIONTYPE(){
		init();
		this.tableName = "EnuTransactionType";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(TRANSACTIONTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuTransactionType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}