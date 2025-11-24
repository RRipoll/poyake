package com.jsantos.metadata.plugin.dbmanager.tests;

import org.eclipse.datatools.modelbase.sql.schema.impl.DatabaseImpl;

public class MyDatabase extends DatabaseImpl{
	public MyDatabase() {
		super();
	}

	@Override
	public String getName() {
		return "testdb";
	}

}
