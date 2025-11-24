package com.jsantos.demo.screen.cscase;

import com.jsantos.gui.form.DefaultFormSerializer;
import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public class SaveCaseSerializer extends DefaultFormSerializer{

	@Override
	public boolean shouldBeInserted(IDetachedRecord dr) {
		if(dr.getTable().equals(MTroadRunnerData.CUSTOMERCASE))
			return null!=dr.get(MTroadRunnerData.CUSTOMERCASE.CUSTOMERID);
		return true;
	}
}
