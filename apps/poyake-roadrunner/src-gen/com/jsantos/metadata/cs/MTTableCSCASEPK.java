package com.jsantos.metadata.cs;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableCSCASEPK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField CSCASEID = new MTField("csCaseId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(CSCASEID);
		{
			CSCASEID.setDataType(MTDataTypes.INT);
			CSCASEID.setNullable(true);
			CSCASEID.setTransient(false);
			CSCASEID.setSequence("cs.Seq_CSCasePK_csCaseId");
			CSCASEID.setPrimaryKey(true);
		}
	}

	public MTTableCSCASEPK(){
		init();
		this.tableName = "CSCasePK";
		this.schema = "cs";
		this.entityType = "TABLE";
		this.primaryKeys.add(CSCASEID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}