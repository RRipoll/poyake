package com.jsantos.metadata.eva;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.eva.MTTableEVALUATIONSUBSECTIONDETAIL;
import com.jsantos.metadata.eva.MTTableENUEVALUATIONSECTION;

public class MTTableVRESULTCALCULATION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField EVALUATIONID;
	public static MTField LEVEL;
	public static MTField EVALUATIONSECTIONTYPEID;

	 public static void init(){
		EVALUATIONID = new MTField(MTTableEVALUATIONSUBSECTIONDETAIL.EVALUATIONID,"evaluationId");
		fields.add(EVALUATIONID);
		{
			EVALUATIONID.setModelType("INT");
			EVALUATIONID.setNativeTypeName("INT");
			EVALUATIONID.setNullable(true);
		}
		LEVEL = new MTField(MTTableEVALUATIONSUBSECTIONDETAIL.LEVEL,"level");
		fields.add(LEVEL);
		{
			LEVEL.setModelType("INT");
			LEVEL.setNativeTypeName("INT");
			LEVEL.setNullable(true);
		}
		EVALUATIONSECTIONTYPEID = new MTField(MTTableENUEVALUATIONSECTION.EVALUATIONSECTIONTYPEID,"evaluationSectionTypeId");
		fields.add(EVALUATIONSECTIONTYPEID);
		{
			EVALUATIONSECTIONTYPEID.setModelType("INT");
			EVALUATIONSECTIONTYPEID.setNativeTypeName("INT");
			EVALUATIONSECTIONTYPEID.setNullable(true);
		}
	}

	public MTTableVRESULTCALCULATION(){
		init();
		this.tableName = "VResultCalculation";
		this.schema = "eva";
		this.entityType = "VIEW";
		new Label("","","");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}