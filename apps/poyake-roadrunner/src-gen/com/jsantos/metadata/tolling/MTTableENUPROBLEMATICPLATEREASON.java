package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableENUPROBLEMATICPLATEREASON extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PROBLEMATICPLATEREASON = new MTField("problematicPlateReason");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField DESCRIPTION = new MTField("description");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PROBLEMATICPLATEREASON);
		{
			PROBLEMATICPLATEREASON.setDataType(MTDataTypes.INT);
			PROBLEMATICPLATEREASON.setNullable(false);
			PROBLEMATICPLATEREASON.setTransient(false);
			PROBLEMATICPLATEREASON.setSequence("tolling.Seq_EnuProblematicPlateReason_problematicPlateReason");
			PROBLEMATICPLATEREASON.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(32);
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

	public MTTableENUPROBLEMATICPLATEREASON(){
		init();
		this.tableName = "EnuProblematicPlateReason";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(PROBLEMATICPLATEREASON);
		this.patterns.add("Enumeration");
		this.enumeration= new EnuProblematicPlateReason();
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}