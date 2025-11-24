package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.postgres;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.AbstractCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class PostgresCreateStatementProvider extends AbstractCreateStatementProvider{

	@Override
	protected Vendor getVendor() {
		return Vendor.POSTGRESQL;
	}

}
