package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.sqlserver;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.AbstractCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class SqlServerCreateStatementProvider extends AbstractCreateStatementProvider{

	@Override
	protected Vendor getVendor() {
		return Vendor.SQLSERVER;
	}
}
