package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.sqlstandard;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.AbstractCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class SqlStandardCreateStatementProvider extends AbstractCreateStatementProvider{

	@Override
	protected Vendor getVendor() {
		return Vendor.DEFAULT;
	}
}
