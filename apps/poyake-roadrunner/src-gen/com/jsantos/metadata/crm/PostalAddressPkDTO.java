package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;

public class PostalAddressPkDTO extends DetachedRecord{

	public PostalAddressPkDTO(){
		super(MTBase.getTable("POSTALADDRESSPK"));
	}

	public PostalAddressPkDTO(ResultSet rs){
		super(MTBase.getTable("POSTALADDRESSPK"), rs);
	}

	public PostalAddressPkDTO(Integer pk) {
		super(MTBase.getTable("POSTALADDRESSPK"), pk);
	}

	public PostalAddressPkDTO(String whereClause) {
		super(MTBase.getTable("POSTALADDRESSPK"), whereClause);
	}

	public java.lang.Integer getPostalAddressId(){ 
		return (java.lang.Integer) get(MTTablePOSTALADDRESSPK.POSTALADDRESSID);
	}

	public void setPostalAddressId(java.lang.Integer postalAddressId){ 
		set(MTTablePOSTALADDRESSPK.POSTALADDRESSID, postalAddressId);
	} 

	public void update() {
		super.update();
	}

	public PostalAddressPkDTO insert() {
		return (PostalAddressPkDTO) super.insert();
	}

	public static PostalAddressPkDTO find(String whereExpression) {
		try {
			return new PostalAddressPkDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}