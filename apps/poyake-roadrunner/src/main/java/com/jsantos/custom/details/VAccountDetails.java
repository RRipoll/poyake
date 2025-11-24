package com.jsantos.custom.details;

import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.orm.mt.MTTable;

public class VAccountDetails extends AccountDetails{

	@Override
	public MTTable getmTTable() {
		return MTroadRunnerData.VCUSTOMERSEARCH;
	}
	
}
