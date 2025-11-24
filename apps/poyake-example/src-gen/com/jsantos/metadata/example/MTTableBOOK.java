package com.jsantos.metadata.example;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableBOOK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField BOOKID = new MTField("bookId");
	public static final MTField TITLE = new MTField("title");
	public static final MTField AUTHORID = new MTField("authorId");
	public static final MTField DESCRIPTION = new MTField("description");
	public static final MTField DOC = new MTField("doc");
	public static final MTField GENREID = new MTField("genreId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(BOOKID);
		{
			BOOKID.setDataType(MTDataTypes.INT);
			BOOKID.setNullable(true);
			BOOKID.setTransient(false);
			BOOKID.setSequence("example.Seq_Book_bookId");
			BOOKID.getLabels().add(new Label("SHORTLABEL","en_EN","Book #"));
			BOOKID.getLabels().add(new Label("SHORTLABEL","es_ES","# Libro"));
			BOOKID.setPrimaryKey(true);
		}
		fields.add(TITLE);
		{
			TITLE.setDataType(MTDataTypes.VARCHAR);
			TITLE.setLength(256);
			TITLE.setNullable(false);
			TITLE.setTransient(false);
			TITLE.getLabels().add(new Label("SHORTLABEL","en_EN","Title"));
			TITLE.getLabels().add(new Label("SHORTLABEL","es_ES","Título"));
			TITLE.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(AUTHORID);
		{
			AUTHORID.setDataType(MTDataTypes.INT);
			AUTHORID.setNullable(false);
			AUTHORID.setTransient(false);
			AUTHORID.getLabels().add(new Label("SHORTLABEL","en_EN","Author #"));
			AUTHORID.getLabels().add(new Label("SHORTLABEL","es_ES","# Autor"));
		}
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.TEXTAREA);
			DESCRIPTION.setLength(300);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","en_EN","Description"));
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","es_ES","Descripción"));
		}
		fields.add(DOC);
		{
			DOC.setDataType(MTDataTypes.FILE_GROUP);
			DOC.setNullable(true);
			DOC.setTransient(false);
			DOC.getLabels().add(new Label("SHORTLABEL","en_EN","Doc"));
			DOC.getLabels().add(new Label("SHORTLABEL","es_ES","Doc"));
		}
		fields.add(GENREID);
		{
			GENREID.setDataType(MTDataTypes.INT);
			GENREID.setNullable(true);
			GENREID.setTransient(false);
		}
	}

	public MTTableBOOK(){
		init();
		this.tableName = "Book";
		this.schema = "example";
		this.entityType = "TABLE";
		this.primaryKeys.add(BOOKID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}