package com.jsantos.metadata.plugin.generator.templates.resourceset;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IFileSystemAccess;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionPreferences;
import com.jsantos.metadata.plugin.dbmanager.dbresetter.EclipseConnectionManager;
import com.jsantos.metadata.plugin.dbmanager.dbresetter.PluginConnectionManager;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.IModelStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.h2.H2CreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.mysql.MySqlCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.oracle.OracleCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.postgres.PostgresCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.sqlserver.SqlServerCreateStatementProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.vendor.sqlstandard.SqlStandardCreateStatementProvider;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.Metadata;
import com.jsantos.metadata.plugin.metaDsl.Sequence;
import com.jsantos.metadata.plugin.metaDsl.SqlNative;
import com.jsantos.metadata.plugin.util.Logger;

public class DBCreationScriptGenerator {

	public void generate(ResourceSet rs, IFileSystemAccess fsa, ConnectionPreferences connectionPreferences) {
		
		Vendor vendor = Vendor.DEFAULT;
		try {
			if (connectionPreferences != null) {
				if (connectionPreferences.isUseEclipse())
					vendor = new EclipseConnectionManager(connectionPreferences.getEclipseConnectionProfile()).getVendor();
				else if (null != connectionPreferences.getUrl() && connectionPreferences.getUrl().length()>0){
					PluginConnectionManager pcm = new PluginConnectionManager(connectionPreferences);
					vendor = pcm.getVendor();
				}
			}
		}
		catch (Exception e) {
			Logger.error("DBCreationScriptGenerator error getting vendor: ", e);
		}
		
		LinkedHashMap<String, Entity> entities = new LinkedHashMap<String, Entity>();
		Iterators.<Entity>filter(rs.getAllContents(), Entity.class).forEachRemaining(
			entity -> {
				if (!entities.containsKey(entity.getName()))
					entities.put(entity.getName(), entity);
			}
		);
		ArrayList<Sequence> sequences = new ArrayList<>();
		Iterators.<Sequence>filter(rs.getAllContents(), Sequence.class).forEachRemaining(sequence -> {sequences.add(sequence);});
		
		ArrayList<SqlNative> sqlNativeBlocks = new ArrayList<>();
		Iterators.<SqlNative>filter(rs.getAllContents(), SqlNative.class).forEachRemaining(sqlNativeBlock -> {sqlNativeBlocks.add(sqlNativeBlock);});
		
		ArrayList<Metadata> metadatas = new ArrayList<>();
		Iterators.<Metadata>filter(rs.getAllContents(), Metadata.class).forEachRemaining(metadata -> {metadatas.add(metadata);});
		
		
		IModelStatementProvider statementProvider = null;
		switch(vendor) {
		case SQLSERVER:
			statementProvider = new SqlServerCreateStatementProvider();
			break;
		case MYSQL:
			statementProvider = new MySqlCreateStatementProvider();
			break;
		case POSTGRESQL:
			statementProvider = new PostgresCreateStatementProvider();
			break;
		case ORACLE:
			statementProvider = new OracleCreateStatementProvider();
			break;
		case H2:
			statementProvider = new H2CreateStatementProvider();
			break;
		default:
			statementProvider = new SqlStandardCreateStatementProvider();
		}
		statementProvider.setModel(new ArrayList<>(entities.values()), sequences, sqlNativeBlocks, metadatas);
		List<String> createStatements = statementProvider.buildStatements(); 
		StringBuffer out = new StringBuffer("-- Generated Script file for " + vendor + " !!!\r\n");
		out.append("-- Generated at " + new Date() + " \r\n");
		for (String statement:createStatements) {
			out.append(statement);
			out.append("\r\n; -- Generated Statement \r\n\r\n");
		}
			
		fsa.generateFile("sql/DB_Creation_Script.sql" , out.toString());
		
	}


}
