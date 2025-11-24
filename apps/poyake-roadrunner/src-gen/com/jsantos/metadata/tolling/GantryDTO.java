package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class GantryDTO extends DetachedRecord{

	public GantryDTO(){
		super(MTBase.getTable("GANTRY"));
	}

	public GantryDTO(ResultSet rs){
		super(MTBase.getTable("GANTRY"), rs);
	}

	public GantryDTO(Integer pk) {
		super(MTBase.getTable("GANTRY"), pk);
	}

	public GantryDTO(String whereClause) {
		super(MTBase.getTable("GANTRY"), whereClause);
	}

	public java.lang.Integer getGantryId(){ 
		return (java.lang.Integer) get(MTTableGANTRY.GANTRYID);
	}

	public void setGantryId(java.lang.Integer gantryId){ 
		set(MTTableGANTRY.GANTRYID, gantryId);
	} 

	public java.lang.String getRoadsideGantryUniqueId(){ 
		return (java.lang.String) get(MTTableGANTRY.ROADSIDEGANTRYUNIQUEID);
	}

	public void setRoadsideGantryUniqueId(java.lang.String roadsideGantryUniqueId){ 
		set(MTTableGANTRY.ROADSIDEGANTRYUNIQUEID, roadsideGantryUniqueId);
	} 

	public java.lang.String getDescription(){ 
		return (java.lang.String) get(MTTableGANTRY.DESCRIPTION);
	}

	public void setDescription(java.lang.String description){ 
		set(MTTableGANTRY.DESCRIPTION, description);
	} 

	public void update() {
		super.update();
	}

	public GantryDTO insert() {
		return (GantryDTO) super.insert();
	}

	public static GantryDTO find(String whereExpression) {
		try {
			return new GantryDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}