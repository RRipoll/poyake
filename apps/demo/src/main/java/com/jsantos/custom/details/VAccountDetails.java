package com.jsantos.custom.details;

import com.jsantos.metadata.MT;
import com.jsantos.orm.mt.MTTable;

public class VAccountDetails extends AccountDetails{

	@Override
	public MTTable getmTTable() {
		return MT.VCUSTOMERSEARCH;
	}
	
}
