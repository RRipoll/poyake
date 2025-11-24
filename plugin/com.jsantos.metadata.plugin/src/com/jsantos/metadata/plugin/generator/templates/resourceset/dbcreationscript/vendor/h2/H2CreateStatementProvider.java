package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.h2;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.AbstractCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class H2CreateStatementProvider extends AbstractCreateStatementProvider{

	@Override
	protected Vendor getVendor() {
		return Vendor.H2;
	}

}
