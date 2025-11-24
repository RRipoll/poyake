package com.jsantos.metadata.plugin.dbmanager;

import java.sql.Connection;

public interface IDBStatementProvider extends IStatementProvider{
	public void setConnection(Connection conn);
}
