package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.postgres;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jsantos.metadata.plugin.dbmanager.IDBStatementProvider;

public class PostgresDropStatementProvider implements IDBStatementProvider{

	Connection conn;
	
	@Override
	public List<String> buildStatements() {
		ArrayList<String> statements = new ArrayList<String>();
		statements.add("DROP OWNED BY CURRENT_USER CASCADE");
		return statements;
	}

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}


}
