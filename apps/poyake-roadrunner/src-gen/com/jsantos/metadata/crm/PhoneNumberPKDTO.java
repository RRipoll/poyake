package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PhoneNumberPKDTO extends DetachedRecord{

	public PhoneNumberPKDTO(){
		super(MTBase.getTable("PHONENUMBERPK"));
	}

	public PhoneNumberPKDTO(ResultSet rs){
		super(MTBase.getTable("PHONENUMBERPK"), rs);
	}

	public PhoneNumberPKDTO(Integer pk) {
		super(MTBase.getTable("PHONENUMBERPK"), pk);
	}

	public PhoneNumberPKDTO(String whereClause) {
		super(MTBase.getTable("PHONENUMBERPK"), whereClause);
	}

	public java.lang.Integer getPhoneNumberId(){ 
		return (java.lang.Integer) get(MTTablePHONENUMBERPK.PHONENUMBERID);
	}

	public void setPhoneNumberId(java.lang.Integer phoneNumberId){ 
		set(MTTablePHONENUMBERPK.PHONENUMBERID, phoneNumberId);
	} 

	public void update() {
		super.update();
	}

	public PhoneNumberPKDTO insert() {
		return (PhoneNumberPKDTO) super.insert();
	}

	public static PhoneNumberPKDTO find(String whereExpression) {
		try {
			return new PhoneNumberPKDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}