package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.multi.MTTableHOMELINK;
import com.jsantos.metadata.multi.MTTableHOME;

public class MTTableVHOMELINK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField HOMELINKID;
	public static MTField STREETID;
	public static MTField HOMEID;
	public static MTField CREATED;
	public static MTField INPUTUSERID;
	public static MTField INPUTSOURCEID;
	public static MTField NAME;

	public static void init(){
		fields = new ArrayList<>();
		HOMELINKID = new MTField(MTTableHOMELINK.HOMELINKID,"homeLinkId");
		fields.add(HOMELINKID);
		{
			HOMELINKID.setDataType(MTDataTypes.INT);
			HOMELINKID.setNullable(true);
			HOMELINKID.setTransient(false);
			HOMELINKID.setSequence("multi.Seq_VHomeLink_homeLinkId");
			HOMELINKID.setPrimaryKey(true);
		}
		STREETID = new MTField(MTTableHOMELINK.STREETID,"streetId");
		fields.add(STREETID);
		{
			STREETID.setDataType(MTDataTypes.INT);
			STREETID.setNullable(true);
			STREETID.setTransient(false);
		}
		HOMEID = new MTField(MTTableHOMELINK.HOMEID,"homeId");
		fields.add(HOMEID);
		{
			HOMEID.setDataType(MTDataTypes.INT);
			HOMEID.setNullable(true);
			HOMEID.setTransient(false);
		}
		CREATED = new MTField(MTTableHOMELINK.CREATED,"created");
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(true);
			CREATED.setTransient(false);
		}
		INPUTUSERID = new MTField(MTTableHOMELINK.INPUTUSERID,"inputUserId");
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(true);
			INPUTUSERID.setTransient(false);
		}
		INPUTSOURCEID = new MTField(MTTableHOMELINK.INPUTSOURCEID,"inputSourceId");
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(true);
			INPUTSOURCEID.setTransient(false);
		}
		NAME = new MTField(MTTableHOME.NAME,"name");
		fields.add(NAME);
		{
			NAME.setDataType(MTDataTypes.VARCHAR);
			NAME.setLength(255);
			NAME.setNullable(true);
			NAME.setTransient(false);
		}
	}

	public MTTableVHOMELINK(){
		init();
		this.tableName = "VHomeLink";
		this.schema = "multi";
		this.entityType = "VIEW";
		this.primaryKeys.add(HOMELINKID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}