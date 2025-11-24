package com.jsantos.metadata.example;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableAUTHOR extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField AUTHORID = new MTField("authorId");
	public static final MTField FULLNAME = new MTField("fullName");
	public static final MTField NOTE = new MTField("note");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(AUTHORID);
		{
			AUTHORID.setDataType(MTDataTypes.INT);
			AUTHORID.setNullable(true);
			AUTHORID.setTransient(false);
			AUTHORID.setSequence("example.Seq_Author_authorId");
			AUTHORID.getLabels().add(new Label("SHORTLABEL","en_EN","Author #"));
			AUTHORID.getLabels().add(new Label("SHORTLABEL","es_ES","# Autor"));
			AUTHORID.setPrimaryKey(true);
		}
		fields.add(FULLNAME);
		{
			FULLNAME.setDataType(MTDataTypes.VARCHAR);
			FULLNAME.setLength(256);
			FULLNAME.setNullable(false);
			FULLNAME.setTransient(false);
			FULLNAME.getLabels().add(new Label("SHORTLABEL","en_EN","Name"));
			FULLNAME.getLabels().add(new Label("SHORTLABEL","es_ES","Nombre"));
			FULLNAME.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(NOTE);
		{
			NOTE.setDataType(MTDataTypes.HTML);
			NOTE.setLength(8000);
			NOTE.setNullable(true);
			NOTE.setTransient(false);
			NOTE.getLabels().add(new Label("SHORTLABEL","en_EN","Note"));
			NOTE.getLabels().add(new Label("SHORTLABEL","es_ES","Nota"));
		}
	}

	public MTTableAUTHOR(){
		init();
		this.tableName = "Author";
		this.schema = "example";
		this.entityType = "TABLE";
		this.primaryKeys.add(AUTHORID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}