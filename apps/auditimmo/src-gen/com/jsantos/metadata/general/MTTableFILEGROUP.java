package com.jsantos.metadata.general;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;

public class MTTableFILEGROUP extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField FILEGROUPID = new MTField("fileGroupId");
	public static final MTField POSTINGDATE = new MTField("postingDate");

	 public static void init(){
		fields.add(FILEGROUPID);
		{
			FILEGROUPID.setModelType("INT");
			FILEGROUPID.setNativeTypeName("INT");
			FILEGROUPID.setNullable(true);
			FILEGROUPID.setSequence("general.Seq_FileGroup_fileGroupId");
			FILEGROUPID.setPrimaryKey(true);
		}
		fields.add(POSTINGDATE);
		{
			POSTINGDATE.setModelType("DATETIME");
			POSTINGDATE.setNativeTypeName("DATETIME");
			POSTINGDATE.setNullable(false);
			POSTINGDATE.setDefaultValue("getDate()");
		}
	}

	public MTTableFILEGROUP(){
		init();
		this.tableName = "FileGroup";
		this.schema = "general";
		this.entityType = "TABLE";
		this.primaryKeys.add(FILEGROUPID);
		new Label("","","");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}