package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;

public class MTTableROOMLINK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static final MTField ROOMLINKID = new MTField("roomLinkId");
	public static final MTField ROOMTYPEID = new MTField("roomTypeId");
	public static final MTField HOMEID = new MTField("homeId");
	public static final MTField CREATED = new MTField("created");
	public static final MTField INPUTUSERID = new MTField("inputUserId");
	public static final MTField INPUTSOURCEID = new MTField("inputSourceId");

	public static void init(){
		fields = new ArrayList<>();
		fields.add(ROOMLINKID);
		{
			ROOMLINKID.setDataType(MTDataTypes.INT);
			ROOMLINKID.setNullable(false);
			ROOMLINKID.setTransient(false);
			ROOMLINKID.setSequence("multi.Seq_RoomLink_roomLinkId");
			ROOMLINKID.setPrimaryKey(true);
		}
		fields.add(ROOMTYPEID);
		{
			ROOMTYPEID.setDataType(MTDataTypes.INT);
			ROOMTYPEID.setNullable(false);
			ROOMTYPEID.setTransient(false);
			ROOMTYPEID.getStereoTypes().add("LINK");
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

	public MTTableROOMLINK(){
		init();
		this.tableName = "RoomLink";
		this.schema = "multi";
		this.entityType = "TABLE";
		this.primaryKeys.add(ROOMLINKID);
		this.patterns.add("Audited");
		this.stereotypes.add("LINKTABLE");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}