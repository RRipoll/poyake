package com.jsantos.metadata.tolling;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class TripDTO extends DetachedRecord{

	public TripDTO(){
		super(MTBase.getTable("TRIP"));
	}

	public TripDTO(ResultSet rs){
		super(MTBase.getTable("TRIP"), rs);
	}

	public TripDTO(Integer pk) {
		super(MTBase.getTable("TRIP"), pk);
	}

	public TripDTO(String whereClause) {
		super(MTBase.getTable("TRIP"), whereClause);
	}

	public java.lang.Integer getTripId(){ 
		return (java.lang.Integer) get(MTTableTRIP.TRIPID);
	}

	public void setTripId(java.lang.Integer tripId){ 
		set(MTTableTRIP.TRIPID, tripId);
	} 

	public java.lang.Integer getLedgerInfoId(){ 
		return (java.lang.Integer) get(MTTableTRIP.LEDGERINFOID);
	}

	public void setLedgerInfoId(java.lang.Integer ledgerInfoId){ 
		set(MTTableTRIP.LEDGERINFOID, ledgerInfoId);
	} 

	public java.lang.Integer getLedgerItemId(){ 
		return (java.lang.Integer) get(MTTableTRIP.LEDGERITEMID);
	}

	public void setLedgerItemId(java.lang.Integer ledgerItemId){ 
		set(MTTableTRIP.LEDGERITEMID, ledgerItemId);
	} 

	public void update() {
		super.update();
	}

	public TripDTO insert() {
		return (TripDTO) super.insert();
	}

	public static TripDTO find(String whereExpression) {
		try {
			return new TripDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}