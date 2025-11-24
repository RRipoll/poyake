package com.jsantos.demo.screen.cscase;

import com.jsantos.gui.form.DefaultFormSerializer;
import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public class SaveCaseSerializer extends DefaultFormSerializer{

	@Override
	public boolean shouldBeInserted(IDetachedRecord dr) {
		if(dr.getTable().equals(MT.CUSTOMERCASE))
			return null!=dr.get(MT.CUSTOMERCASE.CUSTOMERID);
		return true;
	}
}
