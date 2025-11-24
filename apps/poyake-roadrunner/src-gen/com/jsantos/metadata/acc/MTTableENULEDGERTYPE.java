package com.jsantos.metadata.acc;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENULEDGERTYPE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField LEDGERTYPEID = new MTField("ledgerTypeId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(LEDGERTYPEID);
		{
			LEDGERTYPEID.setDataType(MTDataTypes.INT);
			LEDGERTYPEID.setNullable(true);
			LEDGERTYPEID.setTransient(false);
			LEDGERTYPEID.setSequence("acc.Seq_EnuLedgerType_ledgerTypeId");
			LEDGERTYPEID.setPrimaryKey(true);
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
			DESCRIPTION.setLength(64);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableENULEDGERTYPE(){
		init();
		this.tableName = "EnuLedgerType";
		this.schema = "acc";
		this.entityType = "TABLE";
		this.primaryKeys.add(LEDGERTYPEID);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuLedgerType();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}