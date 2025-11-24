package com.jsantos.metadata.recorder;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableRECORDERDATA extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField RECORDERDATAID = new MTField("recorderDataId");
	public static final MTField RECORDERTYPEID = new MTField("recorderTypeId");
	public static final MTField POSTINGDATE = new MTField("postingDate");
	public static final MTField TABLENAME = new MTField("tableName");
	public static final MTField DATA = new MTField("data");
	public static final MTField DELETED = new MTField("deleted");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(RECORDERDATAID);
		{
			RECORDERDATAID.setDataType(MTDataTypes.INT);
			RECORDERDATAID.setNullable(true);
			RECORDERDATAID.setTransient(false);
			RECORDERDATAID.setSequence("recorder.Seq_RecorderData_recorderDataId");
			RECORDERDATAID.setPrimaryKey(true);
		}
		fields.add(RECORDERTYPEID);
		{
			RECORDERTYPEID.setDataType(MTDataTypes.INT);
			RECORDERTYPEID.setNullable(true);
			RECORDERTYPEID.setTransient(false);
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATETIME);
			POSTINGDATE.setNullable(false);
			POSTINGDATE.setTransient(false);
			POSTINGDATE.getStereoTypes().add("NOGUIINPUT");
			POSTINGDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(TABLENAME);
		{
			TABLENAME.setDataType(MTDataTypes.VARCHAR);
			TABLENAME.setLength(256);
			TABLENAME.setNullable(false);
			TABLENAME.setTransient(false);
			TABLENAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(DATA);
		{
			DATA.setDataType(MTDataTypes.JSON);
			DATA.setLength(-1);
			DATA.setNullable(false);
			DATA.setTransient(false);
		}
		fields.add(DELETED);
		{
			DELETED.setDataType(MTDataTypes.INT);
			DELETED.setNullable(false);
			DELETED.setTransient(false);
			DELETED.getStereoTypes().add("NOGUIINPUT");
			DELETED.setDefaultValue("0");
		}
	}

	public MTTableRECORDERDATA(){
		init();
		this.tableName = "RecorderData";
		this.schema = "recorder";
		this.entityType = "TABLE";
		this.primaryKeys.add(RECORDERDATAID);
		this.stereotypes.add("RECORDER");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}