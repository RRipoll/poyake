package com.jsantos.metadata.example;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.example.MTTableBOOK;

public class MTTableVBOOK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField BOOKID;
	public static MTField TITLE;
	public static MTField AUTHORID;
	public static MTField DESCRIPTION;
	public static MTField DOC;
	public static final MTField OTHERAUTHOR = new MTField("otherAuthor");

	public static void init(){
		fields = new ArrayList<>();
		BOOKID = new MTField(MTTableBOOK.BOOKID,"bookId");
			BOOKID.getLabels().add(new Label("SHORTLABEL","en_EN","Book #"));
			BOOKID.getLabels().add(new Label("SHORTLABEL","es_ES","# Libro"));
		fields.add(BOOKID);
		{
			BOOKID.setDataType(MTDataTypes.INT);
			BOOKID.setNullable(true);
			BOOKID.setTransient(false);
			BOOKID.setSequence("example.Seq_VBook_bookId");
			BOOKID.getLabels().add(new Label("SHORTLABEL","en_EN","Book #"));
			BOOKID.getLabels().add(new Label("SHORTLABEL","es_ES","# Libro"));
			BOOKID.setPrimaryKey(true);
		}
		TITLE = new MTField(MTTableBOOK.TITLE,"title");
			TITLE.getLabels().add(new Label("SHORTLABEL","en_EN","Title"));
			TITLE.getLabels().add(new Label("SHORTLABEL","es_ES","Título"));
		fields.add(TITLE);
		{
			TITLE.setDataType(MTDataTypes.VARCHAR);
			TITLE.setLength(256);
			TITLE.setNullable(true);
			TITLE.setTransient(false);
			TITLE.getLabels().add(new Label("SHORTLABEL","en_EN","Title"));
			TITLE.getLabels().add(new Label("SHORTLABEL","es_ES","Título"));
			TITLE.getStereoTypes().add("DESCRIPTION");
		}
		AUTHORID = new MTField(MTTableBOOK.AUTHORID,"authorId");
			AUTHORID.getLabels().add(new Label("SHORTLABEL","en_EN","Author #"));
			AUTHORID.getLabels().add(new Label("SHORTLABEL","es_ES","# Autor"));
		fields.add(AUTHORID);
		{
			AUTHORID.setDataType(MTDataTypes.INT);
			AUTHORID.setNullable(true);
			AUTHORID.setTransient(false);
			AUTHORID.getLabels().add(new Label("SHORTLABEL","en_EN","Author #"));
			AUTHORID.getLabels().add(new Label("SHORTLABEL","es_ES","# Autor"));
		}
		DESCRIPTION = new MTField(MTTableBOOK.DESCRIPTION,"description");
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","en_EN","Description"));
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","es_ES","Descripción"));
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.TEXTAREA);
			DESCRIPTION.setLength(300);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","en_EN","Description"));
			DESCRIPTION.getLabels().add(new Label("SHORTLABEL","es_ES","Descripción"));
		}
		DOC = new MTField(MTTableBOOK.DOC,"doc");
			DOC.getLabels().add(new Label("SHORTLABEL","en_EN","Doc"));
			DOC.getLabels().add(new Label("SHORTLABEL","es_ES","Doc"));
		fields.add(DOC);
		{
			DOC.setDataType(MTDataTypes.FILE_GROUP);
			DOC.setNullable(true);
			DOC.setTransient(false);
			DOC.getLabels().add(new Label("SHORTLABEL","en_EN","Doc"));
			DOC.getLabels().add(new Label("SHORTLABEL","es_ES","Doc"));
		}
		fields.add(OTHERAUTHOR);
		{
			OTHERAUTHOR.setDataType(MTDataTypes.MULTIPLEOBJECT);
			OTHERAUTHOR.setLength(8000);
			OTHERAUTHOR.setNullable(true);
			OTHERAUTHOR.setTransient(false);
			OTHERAUTHOR.getLabels().add(new Label("SHORTLABEL","en_EN","Other Authors"));
			OTHERAUTHOR.getLabels().add(new Label("SHORTLABEL","es_ES","Otros Autores"));
		}
	}

	public MTTableVBOOK(){
		init();
		this.tableName = "VBook";
		this.schema = "example";
		this.entityType = "VIEW";
		this.primaryKeys.add(BOOKID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}