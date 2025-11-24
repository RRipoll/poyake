package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.mysql;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.AbstractCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class MySqlCreateStatementProvider   extends AbstractCreateStatementProvider{
	@Override
	protected Vendor getVendor() {
		return Vendor.MYSQL;
	}

}
