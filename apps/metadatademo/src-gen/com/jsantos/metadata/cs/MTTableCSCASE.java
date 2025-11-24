package com.jsantos.metadata.cs;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCSCASE extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CSCASEID = new MTField("csCaseId");
	public static final MTField SUBJECT = new MTField("subject");
	public static final MTField CASETYPEID = new MTField("caseTypeId");
	public static final MTField CASESTATUSID = new MTField("caseStatusId");
	public static final MTField CASEPRIORITYID = new MTField("casePriorityId");
	public static final MTField MANUALREVIEWREQUIRED = new MTField("manualReviewRequired");
	public static final MTField EXPECTEDSTATUSTRANSITIONDATE = new MTField("expectedStatusTransitionDate");
	public static final MTField DOCUMENTATION = new MTField("documentation");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CSCASEID);
		{
			CSCASEID.setDataType(MTDataTypes.INT);
			CSCASEID.setNullable(false);
			CSCASEID.setTransient(false);
			CSCASEID.getLabels().add(new Label("SHORTLABEL","en_EN","Case #"));
			CSCASEID.getLabels().add(new Label("SHORTLABEL","es_ES","# Caso"));
			CSCASEID.getStereoTypes().add("AUTOHISTORYMAINFK");
			CSCASEID.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(SUBJECT);
		{
			SUBJECT.setDataType(MTDataTypes.VARCHAR);
			SUBJECT.setLength(1024);
			SUBJECT.setNullable(false);
			SUBJECT.setTransient(false);
			SUBJECT.getLabels().add(new Label("SHORTLABEL","en_EN","Subject"));
			SUBJECT.getLabels().add(new Label("SHORTLABEL","es_ES","Asunto"));
			SUBJECT.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(CASETYPEID);
		{
			CASETYPEID.setDataType(MTDataTypes.INT);
			CASETYPEID.setNullable(false);
			CASETYPEID.setTransient(false);
			CASETYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Case Type"));
			CASETYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo"));
			CASETYPEID.setDefaultValue("1");
		}
		fields.add(CASESTATUSID);
		{
			CASESTATUSID.setDataType(MTDataTypes.INT);
			CASESTATUSID.setNullable(false);
			CASESTATUSID.setTransient(false);
			CASESTATUSID.getLabels().add(new Label("SHORTLABEL","en_EN","Status"));
			CASESTATUSID.getLabels().add(new Label("SHORTLABEL","es_ES","Estatus"));
			CASESTATUSID.setDefaultValue("0");
		}
		fields.add(CASEPRIORITYID);
		{
			CASEPRIORITYID.setDataType(MTDataTypes.INT);
			CASEPRIORITYID.setNullable(false);
			CASEPRIORITYID.setTransient(false);
			CASEPRIORITYID.getLabels().add(new Label("SHORTLABEL","en_EN","Priority"));
			CASEPRIORITYID.getLabels().add(new Label("SHORTLABEL","es_ES","Prioridad"));
			CASEPRIORITYID.setDefaultValue("1");
		}
		fields.add(MANUALREVIEWREQUIRED);
		{
			MANUALREVIEWREQUIRED.setDataType(MTDataTypes.BIT);
			MANUALREVIEWREQUIRED.setNullable(false);
			MANUALREVIEWREQUIRED.setTransient(false);
			MANUALREVIEWREQUIRED.getLabels().add(new Label("SHORTLABEL","en_EN","Needs manual review"));
			MANUALREVIEWREQUIRED.getLabels().add(new Label("SHORTLABEL","es_ES","Necesita revisi??n"));
			MANUALREVIEWREQUIRED.setDefaultValue("1");
		}
		fields.add(EXPECTEDSTATUSTRANSITIONDATE);
		{
			EXPECTEDSTATUSTRANSITIONDATE.setDataType(MTDataTypes.DATE);
			EXPECTEDSTATUSTRANSITIONDATE.setNullable(true);
			EXPECTEDSTATUSTRANSITIONDATE.setTransient(false);
		}
		fields.add(DOCUMENTATION);
		{
			DOCUMENTATION.setDataType(MTDataTypes.FILE_GROUP);
			DOCUMENTATION.setNullable(true);
			DOCUMENTATION.setTransient(false);
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("cs.Seq_CSCase_revisionId");
			REVISIONID.getStereoTypes().add("NOGUIINPUT");
			REVISIONID.setPrimaryKey(true);
		}
		fields.add(STARTDATE);
		{
			STARTDATE.setDataType(MTDataTypes.DATETIME);
			STARTDATE.setNullable(false);
			STARTDATE.setTransient(false);
			STARTDATE.getStereoTypes().add("NOGUIINPUT");
			STARTDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(ENDDATE);
		{
			ENDDATE.setDataType(MTDataTypes.DATETIME);
			ENDDATE.setNullable(false);
			ENDDATE.setTransient(false);
			ENDDATE.getStereoTypes().add("NOGUIINPUT");
			ENDDATE.setDefaultValue("'2099-01-01'");
		}
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(false);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getStereoTypes().add("NOGUIINPUT");
			INPUTUSERID.setDefaultValue("1");
		}
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(false);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
			INPUTSOURCEID.setDefaultValue("1");
		}
	}

	public MTTableCSCASE(){
		init();
		this.tableName = "CSCase";
		this.schema = "cs";
		this.entityType = "TABLE";
		this.primaryKeys.add(REVISIONID);
		this.patterns.add("AutoHistory");
		this.getLabels().add(new Label("SHORTLABEL","en_EN","Case"));
		this.getLabels().add(new Label("SHORTLABEL","es_ES","Caso"));
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}