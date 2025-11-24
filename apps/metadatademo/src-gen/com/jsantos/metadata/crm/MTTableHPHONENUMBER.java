package com.jsantos.metadata.crm;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableHPHONENUMBER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField PHONENUMBERID = new MTField("phoneNumberId");
	public static final MTField PHONETYPEID = new MTField("phoneTypeId");
	public static final MTField NUMBER = new MTField("number");
	public static final MTField EXTENSION = new MTField("extension");
	public static final MTField REVISIONID = new MTField("revisionId");
	public static final MTField STARTDATE = new MTField("startDate");
	public static final MTField ENDDATE = new MTField("endDate");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(PHONENUMBERID);
		{
			PHONENUMBERID.setDataType(MTDataTypes.INT);
			PHONENUMBERID.setNullable(true);
			PHONENUMBERID.setTransient(false);
			PHONENUMBERID.getStereoTypes().add("AUTOHISTORYMAINFK");
		}
		fields.add(PHONETYPEID);
		{
			PHONETYPEID.setDataType(MTDataTypes.INT);
			PHONETYPEID.setNullable(false);
			PHONETYPEID.setTransient(false);
			PHONETYPEID.getLabels().add(new Label("SHORTLABEL","en_EN","Type"));
			PHONETYPEID.getLabels().add(new Label("SHORTLABEL","es_ES","Tipo"));
			PHONETYPEID.setDefaultValue("1");
		}
		fields.add(NUMBER);
		{
			NUMBER.setDataType(MTDataTypes.VARCHAR);
			NUMBER.setLength(14);
			NUMBER.setNullable(true);
			NUMBER.setTransient(false);
			NUMBER.getLabels().add(new Label("SHORTLABEL","es_ES","N??mero Tlfn"));
			NUMBER.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(EXTENSION);
		{
			EXTENSION.setDataType(MTDataTypes.VARCHAR);
			EXTENSION.setLength(10);
			EXTENSION.setNullable(true);
			EXTENSION.setTransient(false);
			EXTENSION.getLabels().add(new Label("SHORTLABEL","es_ES","Extensi??n"));
			EXTENSION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(REVISIONID);
		{
			REVISIONID.setDataType(MTDataTypes.INT);
			REVISIONID.setNullable(true);
			REVISIONID.setTransient(false);
			REVISIONID.setSequence("crm.Seq_HPhoneNumber_revisionId");
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

	public MTTableHPHONENUMBER(){
		init();
		this.tableName = "HPhoneNumber";
		this.schema = "crm";
		this.entityType = "TABLE";
		this.primaryKeys.add(REVISIONID);
		this.patterns.add("AutoHistory");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}