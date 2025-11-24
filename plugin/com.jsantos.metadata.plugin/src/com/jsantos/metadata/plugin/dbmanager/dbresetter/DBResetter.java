package com.jsantos.metadata.plugin.dbmanager.dbresetter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.CoreException;

import com.jsantos.metadata.plugin.dbmanager.IDBStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.h2.H2DropStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.mysql.MySqlDropStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.oracle.OracleDropStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.postgres.PostgresDropStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.sqlserver.SqlServerDropStatementProvider;
import com.jsantos.metadata.plugin.util.EclipseFileUtil;
import com.jsantos.metadata.plugin.util.Logger;

public class DBResetter {
	public static final boolean debug = true;
	ConnectionManager connectionManager;
	Connection conn;
	ArrayList<Long> executedDependencies = new ArrayList<>();

	public DBResetter() throws CoreException {
	}


	public void resetDB(ConnectionPreferences connectionPreferences, String script) throws SQLException {
		connectionManager = new ConnectionManager(connectionPreferences);
		this.conn = connectionManager.getConnection();
		if (null == conn)
			throw new SQLException("Couldn't get a connection to database with connection prefs: " + connectionPreferences);
		dropDB();
		createDB(script);
	}

	


	private void createDB(String script) throws SQLException {
		if (!script.contains("-- Generated Script file for "))
			throw new SQLException("This is not a generated database creation script file or it has been modified.\r\nPlease open src-get/sql/DB_Generation_Script.sql and try again.");
		if (!script.contains("-- Generated Script file for " + connectionManager.getVendor() + " !!!"))
			throw new SQLException("This script file is not for " + connectionManager.getVendor() + " or it has been modified !!!");

		Logger.info("SQL Create Script: \r\n" +  script);
		String[] statements = script.split("; -- Generated Statement ");
		try(Statement st = conn.createStatement()){
			for(String createStatement:statements) {
				executeCreateStatement(st, createStatement.trim());
			}
		}
	}

	private void executeCreateStatement(Statement rs, String sql) throws SQLException {
		if (null == sql || StringUtils.isEmpty(sql) || "null".equalsIgnoreCase(sql.trim()))
			return;

		if (sql.contains("SQLFILEDEPENDENCY") )
			System.out.println("found");
		Pattern pattern = Pattern.compile("-- SQLFILEDEPENDENCY: (?<fileName>[\\w\\-. /\\\\:]+)");
		Matcher matcher = pattern.matcher(sql);

		while (matcher.find()) {
			String fileName = matcher.group("fileName");
			String fileContents =EclipseFileUtil.readProjectFile(fileName);
			Checksum crc32 = new CRC32();
			byte[] bytes = fileContents.getBytes();
		    crc32.update(bytes, 0, bytes.length);
		    Long checksum =  crc32.getValue();
			if (!executedDependencies.contains(checksum)) {
				executeCreateStatement(rs, fileContents);
				executedDependencies.add(checksum);
			}
		}
		
		try {
			if(debug)
				System.out.println("================= Executing statement =====================\r\n " + sql);
			Logger.info("Executing statement: " + sql);
			rs.executeUpdate(sql);
		}
		catch (SQLException e) {
			System.out.print("Error: " + e.toString() + " on statement: ");
			System.err.println(sql);
			throw new SQLException("Error: " + e.getMessage() + "\r\n\r\nOn SQL Statement:\r\n\r\n" + sql, e);
		}

	}

	private void dropDB() throws SQLException {
		Logger.info("drop DB");
		IDBStatementProvider statementProvider = null;
		switch(connectionManager.getVendor()) {
		case SQLSERVER:
			statementProvider = new SqlServerDropStatementProvider();
			break;
		case MYSQL:
			statementProvider = new MySqlDropStatementProvider();
			break;
		case POSTGRESQL:
			statementProvider = new PostgresDropStatementProvider();
			break;
		case ORACLE:
			statementProvider = new OracleDropStatementProvider();
			break;
		case H2:
			statementProvider = new H2DropStatementProvider();
			break;
		default:
			throw new SQLException("dropDB: Database type: " + connectionManager.getVendor() + " Not supported in resetDB");
		}
		statementProvider.setConnection(conn);
		Logger.info("Statement provider: " + statementProvider);
		try (Statement st = conn.createStatement()){
			List<String> dropStatements = statementProvider.buildStatements(); 
			Logger.info("Number of drop statements: " + dropStatements.size());
			for(String dropStatement:dropStatements) {
				executeDropStatement(st, dropStatement);
			}
		}
	}

	void executeDropStatement(Statement st, String sql) throws SQLException {
		if (null == sql || StringUtils.isEmpty(sql))
			return;
		try {
			
			Logger.info("Executing statement: " + sql);
			st.executeUpdate(sql);
		}
		catch (SQLException e) {
			if (
					!e.getMessage().contains("because it does not exist") 
					&& !e.getMessage().contains("is not a constraint")
					&& !e.getMessage().contains("doesn't exist")
					) {
				System.out.print("Error: " + e.toString() + " on statement: ");
				System.err.println(sql);
				throw new SQLException("Error: " + e.getMessage() + "\r\n\r\nOn SQL Statement:\r\n\r\n" + sql, e);
			}
		}

	}



}
