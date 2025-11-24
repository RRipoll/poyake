package com.jsantos.metadata.crm;


import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTBase;
import java.sql.ResultSet;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class HPostalAddressDTO extends AutoHistoryDetachedRecord{

	public HPostalAddressDTO(){
		super(MTBase.getTable("HPOSTALADDRESS"));
	}

	public HPostalAddressDTO(ResultSet rs){
		super(MTBase.getTable("HPOSTALADDRESS"), rs);
	}

	public HPostalAddressDTO(Integer pk) {
		super(MTBase.getTable("HPOSTALADDRESS"), pk);
	}

	public HPostalAddressDTO(String whereClause) {
		super(MTBase.getTable("HPOSTALADDRESS"), whereClause);
	}

	public HPostalAddressDTO(Boolean isMainFk, Integer pk) {
		super(MTBase.getTable("HPOSTALADDRESS"),isMainFk, pk);
	}

	public java.lang.Integer getPostalAddressId(){ 
		return (java.lang.Integer) get(MTTableHPOSTALADDRESS.POSTALADDRESSID);
	}

	public void setPostalAddressId(java.lang.Integer postalAddressId){ 
		set(MTTableHPOSTALADDRESS.POSTALADDRESSID, postalAddressId);
	} 

	public java.lang.String getAddress1(){ 
		return (java.lang.String) get(MTTableHPOSTALADDRESS.ADDRESS1);
	}

	public void setAddress1(java.lang.String address1){ 
		set(MTTableHPOSTALADDRESS.ADDRESS1, address1);
	} 

	public java.lang.String getAddress2(){ 
		return (java.lang.String) get(MTTableHPOSTALADDRESS.ADDRESS2);
	}

	public void setAddress2(java.lang.String address2){ 
		set(MTTableHPOSTALADDRESS.ADDRESS2, address2);
	} 

	public java.lang.String getCity(){ 
		return (java.lang.String) get(MTTableHPOSTALADDRESS.CITY);
	}

	public void setCity(java.lang.String city){ 
		set(MTTableHPOSTALADDRESS.CITY, city);
	} 

	public java.lang.Integer getStateProvinceId(){ 
		return (java.lang.Integer) get(MTTableHPOSTALADDRESS.STATEPROVINCEID);
	}

	public void setStateProvinceId(java.lang.Integer stateProvinceId){ 
		set(MTTableHPOSTALADDRESS.STATEPROVINCEID, stateProvinceId);
	} 

	public java.lang.String getPostalCode(){ 
		return (java.lang.String) get(MTTableHPOSTALADDRESS.POSTALCODE);
	}

	public void setPostalCode(java.lang.String postalCode){ 
		set(MTTableHPOSTALADDRESS.POSTALCODE, postalCode);
	} 

	public java.lang.String getBarcode(){ 
		return (java.lang.String) get(MTTableHPOSTALADDRESS.BARCODE);
	}

	public void setBarcode(java.lang.String barcode){ 
		set(MTTableHPOSTALADDRESS.BARCODE, barcode);
	} 

	public java.lang.String getCoordinates(){ 
		return (java.lang.String) get(MTTableHPOSTALADDRESS.COORDINATES);
	}

	public void setCoordinates(java.lang.String coordinates){ 
		set(MTTableHPOSTALADDRESS.COORDINATES, coordinates);
	} 

	public java.lang.Integer getRevisionId(){ 
		return (java.lang.Integer) get(MTTableHPOSTALADDRESS.REVISIONID);
	}

	public void setRevisionId(java.lang.Integer revisionId){ 
		set(MTTableHPOSTALADDRESS.REVISIONID, revisionId);
	} 

	public java.util.Date getStartDate(){ 
		return (java.util.Date) get(MTTableHPOSTALADDRESS.STARTDATE);
	}

	public void setStartDate(java.util.Date startDate){ 
		set(MTTableHPOSTALADDRESS.STARTDATE, startDate);
	} 

	public java.util.Date getEndDate(){ 
		return (java.util.Date) get(MTTableHPOSTALADDRESS.ENDDATE);
	}

	public void setEndDate(java.util.Date endDate){ 
		set(MTTableHPOSTALADDRESS.ENDDATE, endDate);
	} 

	public java.lang.Integer getInputUserId(){ 
		return (java.lang.Integer) get(MTTableHPOSTALADDRESS.INPUTUSERID);
	}

	public void setInputUserId(java.lang.Integer inputUserId){ 
		set(MTTableHPOSTALADDRESS.INPUTUSERID, inputUserId);
	} 

	public java.lang.Integer getInputSourceId(){ 
		return (java.lang.Integer) get(MTTableHPOSTALADDRESS.INPUTSOURCEID);
	}

	public void setInputSourceId(java.lang.Integer inputSourceId){ 
		set(MTTableHPOSTALADDRESS.INPUTSOURCEID, inputSourceId);
	} 

	public void update() {
		super.update();
	}

	public HPostalAddressDTO insert() {
		return (HPostalAddressDTO) super.insert();
	}

	public static HPostalAddressDTO find(String whereExpression) {
		try {
			return new HPostalAddressDTO(whereExpression);
		}
		catch (Exception e) {
			if (e.getMessage().contains("No records found"))
				return null;
			else
				throw e;
		}
	}
}