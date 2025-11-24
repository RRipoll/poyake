package com.jsantos.metadata.common;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableSTORAGEFILEPK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField STORAGEFILEID = new MTField("storageFileId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(STORAGEFILEID);
		{
			STORAGEFILEID.setDataType(MTDataTypes.INT);
			STORAGEFILEID.setNullable(true);
			STORAGEFILEID.setTransient(false);
			STORAGEFILEID.setSequence("common.Seq_StorageFilePk_storageFileId");
			STORAGEFILEID.setPrimaryKey(true);
		}
	}

	public MTTableSTORAGEFILEPK(){
		init();
		this.tableName = "StorageFilePk";
		this.schema = "common";
		this.entityType = "TABLE";
		this.primaryKeys.add(STORAGEFILEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}