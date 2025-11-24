package com.jsantos.metadata.recorder;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableRECORDERMASTER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField RECORDERMASTERID = new MTField("recorderMasterId");
	public static final MTField POSTINGDATE = new MTField("postingDate");
	public static final MTField SESSION = new MTField("session");
	public static final MTField DELETED = new MTField("deleted");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(RECORDERMASTERID);
		{
			RECORDERMASTERID.setDataType(MTDataTypes.INT);
			RECORDERMASTERID.setNullable(true);
			RECORDERMASTERID.setTransient(false);
			RECORDERMASTERID.setSequence("recorder.Seq_RecorderMaster_recorderMasterId");
			RECORDERMASTERID.setPrimaryKey(true);
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setDataType(MTDataTypes.DATETIME);
			POSTINGDATE.setNullable(false);
			POSTINGDATE.setTransient(false);
			POSTINGDATE.getStereoTypes().add("NOGUIINPUT");
			POSTINGDATE.setDefaultValue("getPostingDate()");
		}
		fields.add(SESSION);
		{
			SESSION.setDataType(MTDataTypes.VARCHAR);
			SESSION.setLength(255);
			SESSION.setNullable(false);
			SESSION.setTransient(false);
			SESSION.getStereoTypes().add("DESCRIPTION");
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

	public MTTableRECORDERMASTER(){
		init();
		this.tableName = "RecorderMaster";
		this.schema = "recorder";
		this.entityType = "TABLE";
		this.primaryKeys.add(RECORDERMASTERID);
		this.stereotypes.add("RECORDER");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}