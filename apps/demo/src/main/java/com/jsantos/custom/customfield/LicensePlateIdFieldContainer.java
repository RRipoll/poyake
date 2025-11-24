package com.jsantos.custom.customfield;

import com.jsantos.metadata.MT;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTTable;

public class LicensePlateIdFieldContainer extends PkFieldContainer{

	private static final long serialVersionUID = -8290112479166013589L;

	public LicensePlateIdFieldContainer() {
		super();
		mtTable=MTBase.getTable("VFindVehicle");
	}
	
	
	@Override
	public MTTable forPKTable() {
		return MT.LICENSEPLATE;
	}
}
