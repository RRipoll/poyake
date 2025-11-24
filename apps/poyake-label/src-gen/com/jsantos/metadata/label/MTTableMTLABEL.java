package com.jsantos.metadata.label;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableMTLABEL extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField MTLABELID = new MTField("mtLabelId");
	public static final MTField SHORTCODE = new MTField("shortCode");
	public static final MTField SCREEN = new MTField("screen");
	public static final MTField EN_US = new MTField("en_US");
	public static final MTField ES_ES = new MTField("es_ES");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(MTLABELID);
		{
			MTLABELID.setDataType(MTDataTypes.UUID);
			MTLABELID.setLength(130);
			MTLABELID.setNullable(true);
			MTLABELID.setTransient(false);
			MTLABELID.setSequence("label.Seq_MTlabel_mtLabelId");
			MTLABELID.setPrimaryKey(true);
		}
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(65);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		fields.add(SCREEN);
		{
			SCREEN.setDataType(MTDataTypes.VARCHAR);
			SCREEN.setLength(65);
			SCREEN.setNullable(true);
			SCREEN.setTransient(false);
		}
		fields.add(EN_US);
		{
			EN_US.setDataType(MTDataTypes.VARCHAR);
			EN_US.setLength(65);
			EN_US.setNullable(true);
			EN_US.setTransient(false);
			EN_US.getStereoTypes().add("DESCRIPTION");
		}
		fields.add(ES_ES);
		{
			ES_ES.setDataType(MTDataTypes.VARCHAR);
			ES_ES.setLength(65);
			ES_ES.setNullable(true);
			ES_ES.setTransient(false);
		}
	}

	public MTTableMTLABEL(){
		init();
		this.tableName = "MTlabel";
		this.schema = "label";
		this.entityType = "TABLE";
		this.primaryKeys.add(MTLABELID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}