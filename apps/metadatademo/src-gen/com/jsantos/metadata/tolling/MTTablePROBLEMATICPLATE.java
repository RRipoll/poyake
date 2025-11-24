package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTablePROBLEMATICPLATE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PROBLEMATICPLATEID = new MTField("problematicPlateId");
	public static final MTField LICENSEPLATEID = new MTField("licensePlateId");
	public static final MTField PROBLEMATICPLATEREASONID = new MTField("problematicPlateReasonId");
	public static final MTField NOTES = new MTField("notes");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PROBLEMATICPLATEID);
		{
			PROBLEMATICPLATEID.setDataType(MTDataTypes.INT);
			PROBLEMATICPLATEID.setNullable(false);
			PROBLEMATICPLATEID.setTransient(false);
			PROBLEMATICPLATEID.setSequence("tolling.Seq_ProblematicPlate_problematicPlateId");
			PROBLEMATICPLATEID.setPrimaryKey(true);
		}
		fields.add(LICENSEPLATEID);
		{
			LICENSEPLATEID.setDataType(MTDataTypes.INT);
			LICENSEPLATEID.setNullable(false);
			LICENSEPLATEID.setTransient(false);
		}
		fields.add(PROBLEMATICPLATEREASONID);
		{
			PROBLEMATICPLATEREASONID.setDataType(MTDataTypes.INT);
			PROBLEMATICPLATEREASONID.setNullable(false);
			PROBLEMATICPLATEREASONID.setTransient(false);
		}
		fields.add(NOTES);
		{
			NOTES.setDataType(MTDataTypes.VARCHAR);
			NOTES.setLength(512);
			NOTES.setNullable(true);
			NOTES.setTransient(false);
		}
	}

	public MTTablePROBLEMATICPLATE(){
		init();
		this.tableName = "ProblematicPlate";
		this.schema = "tolling";
		this.entityType = "TABLE";
		this.primaryKeys.add(PROBLEMATICPLATEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}