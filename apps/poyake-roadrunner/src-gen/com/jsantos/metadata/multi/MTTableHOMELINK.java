package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableHOMELINK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField HOMELINKID = new MTField("homeLinkId");
	public static final MTField STREETID = new MTField("streetId");
	public static final MTField HOMEID = new MTField("homeId");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(HOMELINKID);
		{
			HOMELINKID.setDataType(MTDataTypes.INT);
			HOMELINKID.setNullable(false);
			HOMELINKID.setTransient(false);
			HOMELINKID.setSequence("multi.Seq_HomeLink_homeLinkId");
			HOMELINKID.setPrimaryKey(true);
		}
		fields.add(STREETID);
		{
			STREETID.setDataType(MTDataTypes.INT);
			STREETID.setNullable(false);
			STREETID.setTransient(false);
			STREETID.getStereoTypes().add("LINK");
		}
		fields.add(HOMEID);
		{
			HOMEID.setDataType(MTDataTypes.INT);
			HOMEID.setNullable(false);
			HOMEID.setTransient(false);
			HOMEID.getStereoTypes().add("LINK");
		}
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(false);
			CREATED.setTransient(false);
			CREATED.getStereoTypes().add("NOGUIINPUT");
			CREATED.setDefaultValue("getPostingDate()");
		}
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(false);
			INPUTUSERID.setTransient(false);
			INPUTUSERID.getStereoTypes().add("NOGUIINPUT");
			INPUTUSERID.setDefaultValue("1");
		}
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(false);
			INPUTSOURCEID.setTransient(false);
			INPUTSOURCEID.getStereoTypes().add("NOGUIINPUT");
			INPUTSOURCEID.setDefaultValue("1");
		}
	}

	public MTTableHOMELINK(){
		init();
		this.tableName = "HomeLink";
		this.schema = "multi";
		this.entityType = "TABLE";
		this.primaryKeys.add(HOMELINKID);
		this.patterns.add("Audited");
		this.stereotypes.add("LINKTABLE");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}