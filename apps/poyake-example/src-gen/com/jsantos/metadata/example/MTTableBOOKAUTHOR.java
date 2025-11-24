package com.jsantos.metadata.example;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableBOOKAUTHOR extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField BOOKAUTHORID = new MTField("bookAuthorId");
	public static final MTField BOOKID = new MTField("bookId");
	public static final MTField AUTHORID = new MTField("authorId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(BOOKAUTHORID);
		{
			BOOKAUTHORID.setDataType(MTDataTypes.INT);
			BOOKAUTHORID.setNullable(true);
			BOOKAUTHORID.setTransient(false);
			BOOKAUTHORID.setSequence("example.Seq_BookAuthor_bookAuthorId");
			BOOKAUTHORID.setPrimaryKey(true);
		}
		fields.add(BOOKID);
		{
			BOOKID.setDataType(MTDataTypes.INT);
			BOOKID.setNullable(false);
			BOOKID.setTransient(false);
			BOOKID.getLabels().add(new Label("SHORTLABEL","en_EN","Book #"));
			BOOKID.getLabels().add(new Label("SHORTLABEL","es_ES","# Libro"));
			BOOKID.getStereoTypes().add("LINK");
			BOOKID.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(AUTHORID);
		{
			AUTHORID.setDataType(MTDataTypes.INT);
			AUTHORID.setNullable(false);
			AUTHORID.setTransient(false);
			AUTHORID.getLabels().add(new Label("SHORTLABEL","en_EN","Author #"));
			AUTHORID.getLabels().add(new Label("SHORTLABEL","es_ES","# Autor"));
			AUTHORID.getStereoTypes().add("LINK");
			AUTHORID.getStereoTypes().add("DESCRIPTION");
		}
	}

	public MTTableBOOKAUTHOR(){
		init();
		this.tableName = "BookAuthor";
		this.schema = "example";
		this.entityType = "TABLE";
		this.primaryKeys.add(BOOKAUTHORID);
		this.stereotypes.add("LINKTABLE");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}