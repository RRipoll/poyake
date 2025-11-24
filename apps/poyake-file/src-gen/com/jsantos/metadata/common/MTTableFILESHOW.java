package com.jsantos.metadata.common;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.common.MTTableFILEGROUP;

public class MTTableFILESHOW extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField FILEGROUPID;

	public static void init(){
		fields = new ArrayList<>();
		FILEGROUPID = new MTField(MTTableFILEGROUP.FILEGROUPID,"fileGroupId");
		fields.add(FILEGROUPID);
		{
			FILEGROUPID.setDataType(MTDataTypes.FILE_GROUP);
			FILEGROUPID.setNullable(true);
			FILEGROUPID.setTransient(false);
			FILEGROUPID.setSequence("common.Seq_Fileshow_fileGroupId");
			FILEGROUPID.getStereoTypes().add("GUIINPUT");
			FILEGROUPID.setPrimaryKey(true);
		}
	}

	public MTTableFILESHOW(){
		init();
		this.tableName = "Fileshow";
		this.schema = "common";
		this.entityType = "VIEW";
		this.primaryKeys.add(FILEGROUPID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}