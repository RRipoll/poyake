package com.jsantos.metadata;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableBOOK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField BOOKID = new MTField("bookId");
	public static final MTField TITLE = new MTField("title");
	public static final MTField AUTHORID = new MTField("authorId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(BOOKID);
		{
			BOOKID.setDataType(MTDataTypes.INT);
			BOOKID.setNullable(true);
			BOOKID.setTransient(false);
			BOOKID.setPrimaryKey(true);
		}
		fields.add(TITLE);
		{
			TITLE.setDataType(MTDataTypes.VARCHAR);
			TITLE.setLength(64);
			TITLE.setNullable(true);
			TITLE.setTransient(false);
			TITLE.getLabels().add(new Label("SHORTLABEL","es_ES","Titulo"));
			TITLE.getLabels().add(new Label("SHORTLABEL","en_EN","Title"));
		}
		fields.add(AUTHORID);
		{
			AUTHORID.setDataType(MTDataTypes.INT);
			AUTHORID.setNullable(true);
			AUTHORID.setTransient(false);
		}
	}

	public MTTableBOOK(){
		init();
		this.tableName = "Book";
		this.entityType = "TABLE";
		this.primaryKeys.add(BOOKID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}