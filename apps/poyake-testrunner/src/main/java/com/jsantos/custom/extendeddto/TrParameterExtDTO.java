package com.jsantos.custom.extendeddto;

import com.jsantos.metadata.testrunner.TrParameterDTO;

public class TrParameterExtDTO extends TrParameterDTO{

	@Override
	public void update() {
		System.out.println();;
	}

	@Override
	public TrParameterDTO insert() {
		return this;
	}

	@Override
	public void insertOrUpdate() {
		System.out.println();;;
	}

}
