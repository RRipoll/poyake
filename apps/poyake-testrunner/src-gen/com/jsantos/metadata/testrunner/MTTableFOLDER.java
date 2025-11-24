package com.jsantos.metadata.testrunner;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableFOLDER extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField FOLDERUUID = new MTField("folderUuid");
	public static final MTField PARENTFOLDERUUID = new MTField("parentfolderUuid");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField TESTUUID = new MTField("testUuid");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(FOLDERUUID);
		{
			FOLDERUUID.setDataType(MTDataTypes.UUID);
			FOLDERUUID.setLength(130);
			FOLDERUUID.setNullable(false);
			FOLDERUUID.setTransient(false);
			FOLDERUUID.setSequence("testrunner.Seq_Folder_folderUuid");
			FOLDERUUID.getStereoTypes().add("FOLDER");
			FOLDERUUID.setPrimaryKey(true);
		}
		fields.add(PARENTFOLDERUUID);
		{
			PARENTFOLDERUUID.setDataType(MTDataTypes.UUID);
			PARENTFOLDERUUID.setLength(130);
			PARENTFOLDERUUID.setNullable(true);
			PARENTFOLDERUUID.setTransient(false);
			PARENTFOLDERUUID.getStereoTypes().add("PARENTFOLDER");
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(TESTUUID);
		{
			TESTUUID.setDataType(MTDataTypes.UUID);
			TESTUUID.setLength(130);
			TESTUUID.setNullable(true);
			TESTUUID.setTransient(false);
			TESTUUID.getStereoTypes().add("ITEM");
		}
	}

	public MTTableFOLDER(){
		init();
		this.tableName = "Folder";
		this.schema = "testrunner";
		this.entityType = "TABLE";
		this.primaryKeys.add(FOLDERUUID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}