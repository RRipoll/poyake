package com.jsantos.metadata.multi;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.multi.MTTableROOMLINK;
import com.jsantos.metadata.multi.MTTableENUROOMTYPE;

public class MTTableVROOMLINK extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField ROOMLINKID;
	public static MTField ROOMTYPEID;
	public static MTField HOMEID;
	public static MTField CREATED;
	public static MTField INPUTUSERID;
	public static MTField INPUTSOURCEID;
	public static MTField SHORTCODE;
	public static MTField DESCRIPTION;

	public static void init(){
		fields = new ArrayList<>();
		ROOMLINKID = new MTField(MTTableROOMLINK.ROOMLINKID,"roomLinkId");
		fields.add(ROOMLINKID);
		{
			ROOMLINKID.setDataType(MTDataTypes.INT);
			ROOMLINKID.setNullable(true);
			ROOMLINKID.setTransient(false);
			ROOMLINKID.setSequence("multi.Seq_VroomLink_roomLinkId");
			ROOMLINKID.setPrimaryKey(true);
		}
		ROOMTYPEID = new MTField(MTTableROOMLINK.ROOMTYPEID,"roomTypeId");
		fields.add(ROOMTYPEID);
		{
			ROOMTYPEID.setDataType(MTDataTypes.INT);
			ROOMTYPEID.setNullable(true);
			ROOMTYPEID.setTransient(false);
		}
		HOMEID = new MTField(MTTableROOMLINK.HOMEID,"homeId");
		fields.add(HOMEID);
		{
			HOMEID.setDataType(MTDataTypes.INT);
			HOMEID.setNullable(true);
			HOMEID.setTransient(false);
		}
		CREATED = new MTField(MTTableROOMLINK.CREATED,"created");
		fields.add(CREATED);
		{
			CREATED.setDataType(MTDataTypes.DATETIME);
			CREATED.setNullable(true);
			CREATED.setTransient(false);
		}
		INPUTUSERID = new MTField(MTTableROOMLINK.INPUTUSERID,"inputUserId");
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(true);
			INPUTUSERID.setTransient(false);
		}
		INPUTSOURCEID = new MTField(MTTableROOMLINK.INPUTSOURCEID,"inputSourceId");
		fields.add(INPUTSOURCEID);
		{
			INPUTSOURCEID.setDataType(MTDataTypes.INT);
			INPUTSOURCEID.setNullable(true);
			INPUTSOURCEID.setTransient(false);
		}
		SHORTCODE = new MTField(MTTableENUROOMTYPE.SHORTCODE,"shortCode");
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(16);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		DESCRIPTION = new MTField(MTTableENUROOMTYPE.DESCRIPTION,"description");
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(32);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
		}
	}

	public MTTableVROOMLINK(){
		init();
		this.tableName = "VroomLink";
		this.schema = "multi";
		this.entityType = "VIEW";
		this.primaryKeys.add(ROOMLINKID);
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}