package com.jsantos.custom.extendeddto;

import com.jsantos.metadata.example.AuthorDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;

/**
 * @author javier santos
 * @author raul ripoll
 */

public class AuthorExtDTO extends AuthorDTO{

	@Override
	public void update() {
		System.out.println("We have the power");
		super.update();
	}

	@Override
	public AuthorDTO insert() {
		System.out.println("We have the power");
		return super.insert();
	}

	@Override
	public IDetachedRecord load() {
		System.out.println("We have the power");
		return super.load();
	}

}
