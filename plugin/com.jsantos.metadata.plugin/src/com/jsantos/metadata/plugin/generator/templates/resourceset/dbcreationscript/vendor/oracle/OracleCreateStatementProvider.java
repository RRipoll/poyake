package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.oracle;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.AbstractCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class OracleCreateStatementProvider extends AbstractCreateStatementProvider{

	@Override
	protected Vendor getVendor() {
		return Vendor.ORACLE;
	}

}
