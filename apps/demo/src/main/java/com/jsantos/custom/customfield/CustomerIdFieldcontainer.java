package com.jsantos.custom.customfield;

import com.jsantos.metadata.MT;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class CustomerIdFieldcontainer extends PkFieldContainer{

	private static final long serialVersionUID = -1782080429084741389L;

	public CustomerIdFieldcontainer() {
		super();
		mtTable=MTBase.getTable("VCustomerSearchEditor");
	}
	
	@Override
	public MTTable forPKTable() {
		return MT.CUSTOMERPK;
	}

}
