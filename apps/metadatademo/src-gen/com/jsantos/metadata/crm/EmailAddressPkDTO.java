package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class EmailAddressPkDTO extends DetachedRecord{

	public EmailAddressPkDTO(){
		super(MTBase.getTable("EMAILADDRESSPK"));
	}

	public EmailAddressPkDTO(ResultSet rs){
		super(MTBase.getTable("EMAILADDRESSPK"), rs);
	}

	public EmailAddressPkDTO(Integer pk) {
		super(MTBase.getTable("EMAILADDRESSPK"), pk);
	}

	public EmailAddressPkDTO(String whereClause) {
		super(MTBase.getTable("EMAILADDRESSPK"), whereClause);
	}

	public java.lang.Integer getEmailAddressId(){ 
		return (java.lang.Integer) get(MTTableEMAILADDRESSPK.EMAILADDRESSID);
	}

	public void setEmailAddressId(java.lang.Integer emailAddressId){ 
		set(MTTableEMAILADDRESSPK.EMAILADDRESSID, emailAddressId);
	} 

	public void update() {
		super.update();
	}

	public EmailAddressPkDTO insert() {
		return (EmailAddressPkDTO) super.insert();
	}

	public static EmailAddressPkDTO find(String whereExpression) {
		try {
			return new EmailAddressPkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}