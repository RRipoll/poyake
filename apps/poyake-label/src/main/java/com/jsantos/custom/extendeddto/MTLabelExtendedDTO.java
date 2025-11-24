package com.jsantos.custom.extendeddto;

import com.jsantos.metadata.label.MTlabelDTO;
import com.jsantos.service.LabelProvider;

public class MTLabelExtendedDTO extends MTlabelDTO{

	@Override
	public void update() {
		super.update();
		new LabelProvider().load(getShortCode());
	}

	@Override
	public MTlabelDTO insert() {
		super.insert();
		new LabelProvider().get(getShortCode());
		return this; 
	}

	
	
}
