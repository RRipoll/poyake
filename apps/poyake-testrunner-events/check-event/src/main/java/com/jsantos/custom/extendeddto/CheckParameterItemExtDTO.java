package com.jsantos.custom.extendeddto;

import com.jsantos.metadata.testrunner.CheckParameterItemDTO;

public class CheckParameterItemExtDTO extends CheckParameterItemDTO{
	@Override
	public void update() {
		System.out.println();;
	}

	@Override
	public CheckParameterItemDTO insert() {
		return this;
	}

	@Override
	public void insertOrUpdate() {
		System.out.println();;;
	}

}
