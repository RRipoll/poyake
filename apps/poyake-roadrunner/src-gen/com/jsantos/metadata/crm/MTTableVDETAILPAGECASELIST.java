package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.cs.MTTableCSCASE;
import com.jsantos.metadata.crm.MTTableHCUSTOMER;

public class MTTableVDETAILPAGECASELIST extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField CSCASEID;
	public static MTField SUBJECT;
	public static MTField CASETYPEID;
	public static MTField CASESTATUSID;
	public static MTField CASEPRIORITYID;
	public static MTField MANUALREVIEWREQUIRED;
	public static MTField CUSTOMERID;

	public static void init(){
		fields = new ArrayList<>();
		CSCASEID = new MTField(MTTableCSCASE.CSCASEID,"csCaseId");
			CSCASEID.getLabels().add(new Label("SHORTLABEL","en_EN","Case #"));
			CSCASEID.getLabels().add(new Label("SHORTLABEL","es_ES","# Caso"));
		fields.add(CSCASEID);
		{
			CSCASEID.setDataType(MTDataTypes.INT);
			CSCASEID.setNullable(true);
			CSCASEID.setTransient(false);
			CSCASEID.setSequence("crm.Seq_VDetailPageCaseList_csCaseId");
			CSCASEID.setPrimaryKey(true);
		}
		SUBJECT = new MTField(MTTableCSCASE.SUBJECT,"subject");
			SUBJECT.getLabels().add(new Label("SHORTLABEL","en_EN","Subject"));
			SUBJECT.getLabels().add(new Label("SHORTLABEL","es_ES","Asunto"));
		fields.add(SUBJECT);
		{
			SUBJECT.setDataType(MTDataTypes.VARCHAR);
			SUBJECT.setLength(1024);
			SUBJECT.setNullable(true);
			SUBJECT.setTransient(false);
		}
		CASETYPEID = new MTField(MTTableCSCASE.CASETYPEID,"caseTypeId");
			CASETYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Case Type"));
			CASETYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo"));
		fields.add(CASETYPEID);
		{
			CASETYPEID.setDataType(MTDataTypes.INT);
			CASETYPEID.setNullable(true);
			CASETYPEID.setTransient(false);
		}
		CASESTATUSID = new MTField(MTTableCSCASE.CASESTATUSID,"caseStatusId");
			CASESTATUSID.getLabels().add(new Label("SHORTLABEL","en_EN","Status"));
			CASESTATUSID.getLabels().add(new Label("SHORTLABEL","es_ES","Estatus"));
		fields.add(CASESTATUSID);
		{
			CASESTATUSID.setDataType(MTDataTypes.INT);
			CASESTATUSID.setNullable(true);
			CASESTATUSID.setTransient(false);
		}
		CASEPRIORITYID = new MTField(MTTableCSCASE.CASEPRIORITYID,"casePriorityId");
			CASEPRIORITYID.getLabels().add(new Label("SHORTLABEL","en_EN","Priority"));
			CASEPRIORITYID.getLabels().add(new Label("SHORTLABEL","es_ES","Prioridad"));
		fields.add(CASEPRIORITYID);
		{
			CASEPRIORITYID.setDataType(MTDataTypes.INT);
			CASEPRIORITYID.setNullable(true);
			CASEPRIORITYID.setTransient(false);
		}
		MANUALREVIEWREQUIRED = new MTField(MTTableCSCASE.MANUALREVIEWREQUIRED,"manualReviewRequired");
			MANUALREVIEWREQUIRED.getLabels().add(new Label("SHORTLABEL","en_EN","Needs manual review"));
			MANUALREVIEWREQUIRED.getLabels().add(new Label("SHORTLABEL","es_ES","Necesita revisi??n"));
		fields.add(MANUALREVIEWREQUIRED);
		{
			MANUALREVIEWREQUIRED.setDataType(MTDataTypes.BIT);
			MANUALREVIEWREQUIRED.setNullable(true);
			MANUALREVIEWREQUIRED.setTransient(false);
		}
		CUSTOMERID = new MTField(MTTableHCUSTOMER.CUSTOMERID,"customerId");
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","en_EN","Customer #"));
			CUSTOMERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Cuenta"));
		fields.add(CUSTOMERID);
		{
			CUSTOMERID.setDataType(MTDataTypes.INT);
			CUSTOMERID.setNullable(true);
			CUSTOMERID.setTransient(false);
		}
	}

	public MTTableVDETAILPAGECASELIST(){
		init();
		this.tableName = "VDetailPageCaseList";
		this.schema = "crm";
		this.entityType = "VIEW";
		this.primaryKeys.add(CSCASEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}