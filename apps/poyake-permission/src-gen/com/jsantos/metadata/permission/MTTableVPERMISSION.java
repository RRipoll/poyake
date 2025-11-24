package com.jsantos.metadata.permission;

import java.util.ArrayList;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.label.Label;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.audit.MTTableUSERGROUP;
import com.jsantos.metadata.audit.MTTableINPUTUSERGROUP;
import com.jsantos.metadata.permission.MTTableUSERGROUPROL;
import com.jsantos.metadata.permission.MTTablePERMISSION;

public class MTTableVPERMISSION extends com.jsantos.orm.mt.MTTable{
	private static ArrayList<MTField> fields = new ArrayList<>();

	public static MTField INPUTUSERID;
	public static MTField INPUTUSERGROUPID;
	public static MTField ROLID;
	public static MTField PERMISSIONTYPEID;
	public static MTField PERMISSIONVALUEID;
	public static MTField SHORTCODE;
	public static MTField DESCRIPTION;
	public static MTField PERMISSIONID;

	public static void init(){
		fields = new ArrayList<>();
		INPUTUSERID = new MTField(MTTableUSERGROUP.INPUTUSERID,"inputuserId");
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","en_EN","User #"));
			INPUTUSERID.getLabels().add(new Label("SHORTLABEL","es_ES","# Usuario"));
		fields.add(INPUTUSERID);
		{
			INPUTUSERID.setDataType(MTDataTypes.INT);
			INPUTUSERID.setNullable(true);
			INPUTUSERID.setTransient(false);
		}
		INPUTUSERGROUPID = new MTField(MTTableINPUTUSERGROUP.INPUTUSERGROUPID,"inputUserGroupId");
		fields.add(INPUTUSERGROUPID);
		{
			INPUTUSERGROUPID.setDataType(MTDataTypes.INT);
			INPUTUSERGROUPID.setNullable(true);
			INPUTUSERGROUPID.setTransient(false);
		}
		ROLID = new MTField(MTTableUSERGROUPROL.ROLID,"rolId");
		fields.add(ROLID);
		{
			ROLID.setDataType(MTDataTypes.INT);
			ROLID.setNullable(true);
			ROLID.setTransient(false);
		}
		PERMISSIONTYPEID = new MTField(MTTablePERMISSION.PERMISSIONTYPEID,"permissionTypeId");
		fields.add(PERMISSIONTYPEID);
		{
			PERMISSIONTYPEID.setDataType(MTDataTypes.INT);
			PERMISSIONTYPEID.setNullable(true);
			PERMISSIONTYPEID.setTransient(false);
		}
		PERMISSIONVALUEID = new MTField(MTTablePERMISSION.PERMISSIONVALUEID,"permissionValueId");
		fields.add(PERMISSIONVALUEID);
		{
			PERMISSIONVALUEID.setDataType(MTDataTypes.INT);
			PERMISSIONVALUEID.setNullable(true);
			PERMISSIONVALUEID.setTransient(false);
		}
		SHORTCODE = new MTField(MTTablePERMISSION.SHORTCODE,"shortCode");
		fields.add(SHORTCODE);
		{
			SHORTCODE.setDataType(MTDataTypes.VARCHAR);
			SHORTCODE.setLength(255);
			SHORTCODE.setNullable(true);
			SHORTCODE.setTransient(false);
		}
		DESCRIPTION = new MTField(MTTablePERMISSION.DESCRIPTION,"description");
		fields.add(DESCRIPTION);
		{
			DESCRIPTION.setDataType(MTDataTypes.VARCHAR);
			DESCRIPTION.setLength(255);
			DESCRIPTION.setNullable(true);
			DESCRIPTION.setTransient(false);
			DESCRIPTION.getStereoTypes().add("DESCRIPTION");
		}
		PERMISSIONID = new MTField(MTTablePERMISSION.PERMISSIONID,"permissionId");
		fields.add(PERMISSIONID);
		{
			PERMISSIONID.setDataType(MTDataTypes.INT);
			PERMISSIONID.setNullable(true);
			PERMISSIONID.setTransient(false);
			PERMISSIONID.setSequence("permission.Seq_Vpermission_permissionId");
			PERMISSIONID.setPrimaryKey(true);
		}
	}

	public MTTableVPERMISSION(){
		init();
		this.tableName = "Vpermission";
		this.schema = "permission";
		this.entityType = "VIEW";
		this.primaryKeys.add(PERMISSIONID);
		this.stereotypes.add("CONFIG");
		for (MTField field:fields) field.setTable(this);
	}

	@Override
	public ArrayList<MTField> getFields() {
		return fields;
	}
}