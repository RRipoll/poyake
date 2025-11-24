package com.jsantos.metadata.plugin.dbmanager.reverseengineer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.accessors.ModelCollector;
import com.jsantos.metadata.plugin.dbmanager.reverseengineer.vendor.H2CatalogInfoProvider;
import com.jsantos.metadata.plugin.dbmanager.reverseengineer.vendor.OracleCatalogInfoProvider;
import com.jsantos.metadata.plugin.dbmanager.reverseengineer.vendor.PostgresCatalogProvider;
import com.jsantos.metadata.plugin.dbmanager.reverseengineer.vendor.SqlServerCatalogInfoProvider;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Configuration;
import com.jsantos.metadata.plugin.metaDsl.DataType;
import com.jsantos.metadata.plugin.metaDsl.DataTypeDetails;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.MetaDslFactory;
import com.jsantos.metadata.plugin.util.Logger;

public class DatabaseJDBCSchemaLoader {
	ICatalogInfoQueryProvider sqlProvider = null;
	LinkedHashMap<String, Entity> entities = new LinkedHashMap<>();
	List<Entity> selectedEntities = new ArrayList<Entity>();
	LinkedHashMap<String, String> views = new LinkedHashMap<>();
	Configuration configuration;
	Connection conn;

	public DatabaseJDBCSchemaLoader(Connection conn, String project, Vendor vendor) throws SQLException, CoreException{
		this.conn = conn;
		switch (vendor) {
		case SQLSERVER:
			sqlProvider = new SqlServerCatalogInfoProvider();
			break;
		case ORACLE:
			sqlProvider = new OracleCatalogInfoProvider();
			break;
		case H2:
			sqlProvider = new H2CatalogInfoProvider();
			break;
		case POSTGRESQL:
			sqlProvider = new PostgresCatalogProvider();
			break;
		default:
			throw new SQLException("Reverse engineering for vendor " + vendor + " is not implemented");
		}

		configuration  = new ModelCollector(project).getConfiguration();
		
	}
	
	public void captureAllTables() throws SQLException {
		try(Statement st = conn.createStatement();ResultSet rs=st.executeQuery(sqlProvider.getTableListSql())){
			while(rs.next()) {
				Entity entity = MetaDslFactory.eINSTANCE.createEntity();
				entity.setEntityType("TABLE");
				entity.setName(rs.getString("fullTableName"));
				entities.put(rs.getString("fullTableName"), entity);
			}
		}
		
	}
	
	public void captureSchema() throws SQLException, CoreException {


		try(Statement st = conn.createStatement();ResultSet rs=st.executeQuery(sqlProvider.getFieldListSql())){
			while(rs.next()) {
				Entity entity = entities.get(rs.getString("fullTableName"));
				if (selectedEntities.contains(entity)) {
					Attribute attribute = MetaDslFactory.eINSTANCE.createAttribute();
					attribute.setName(rs.getString("columnName"));
					attribute.setNotNullable(!"1".equals(rs.getString("isColumnNullable")));
					attribute.setLength(rs.getString("columnLength"));
					attribute.setScale(rs.getString("columnScale"));
					attribute.setType(findDatatype(rs.getString("dataTypeName"), entity, attribute));
					entity.getAttributes().add(attribute);
				}
			}
		}
		
		try(Statement st = conn.createStatement();ResultSet rs=st.executeQuery(sqlProvider.getPrimaryKeyListSql())){
			while(rs.next()) {
				Entity entity = entities.get(rs.getString("fullTableName"));
				if (selectedEntities.contains(entity)) {
					for (Attribute attribute:entity.getAttributes()) {
						if (attribute.getName().equalsIgnoreCase(rs.getString("columnName")))
							attribute.setPk(true);
					}
				}
			}
		}

		try(Statement st = conn.createStatement();ResultSet rs=st.executeQuery(sqlProvider.getForeignKeyListSql())){
			while(rs.next()) {
				String fullTableNameFrom = rs.getString("fromTableName");
				
				Entity entity = entities.get(fullTableNameFrom);
				if (selectedEntities.contains(entity)) {
					for (Attribute attribute:entity.getAttributes()) {
						Entity toEntity = entities.get(rs.getString("toTableName"));
						if (EntityHelper.getPks(toEntity).size()==1) {
							if (attribute.getName().equalsIgnoreCase(rs.getString("fromColumn")))
								attribute.setFkto(entities.get(rs.getString("toTableName")));
						}
					}
				}
			}
		}

		try(Statement st = conn.createStatement();ResultSet rs=st.executeQuery(sqlProvider.getColumnDefaultListSql())){
			while(rs.next()) {

				Entity entity = entities.get(rs.getString("fullTableName"));
				if (selectedEntities.contains(entity)) {
					for (Attribute attribute:entity.getAttributes()) {
						if (attribute.getName().equalsIgnoreCase(rs.getString("columnName"))) {
							String defaultValue = rs.getString("defaultValue");
							if (defaultValue.startsWith("(") && defaultValue.endsWith(")"))
									defaultValue = defaultValue.substring(1,defaultValue.length()-1);
							if (defaultValue.startsWith("(") && defaultValue.endsWith(")"))
									defaultValue = defaultValue.substring(1,defaultValue.length()-1);
							defaultValue = defaultValue.trim();
							attribute.setDefault(defaultValue);
						}
					}
				}
			}
		}

		try(Statement st = conn.createStatement();ResultSet rs=st.executeQuery(sqlProvider.getUniqueColumnListSql())){
			while(rs.next()) {
				Entity entity = entities.get(rs.getString("fullTableName"));
				if (selectedEntities.contains(entity)) {
					for (Attribute attribute:entity.getAttributes()) {
						if (attribute.getName().equalsIgnoreCase(rs.getString("columnName")))
							attribute.setUnique(true);
					}
				}
			}
		}

		try(Statement st = conn.createStatement();ResultSet rs=st.executeQuery(sqlProvider.getViewsDDLSql())){
			while(rs.next()) {
				views.put(rs.getString("viewName"), rs.getString("viewDDL"));
			}
		}

		
	}
	
	public DataType findDatatype(String dbDataTypeName, Entity entity, Attribute attribute) throws SQLException {
		try {
			String typeName = dbDataTypeName;
			if (dbDataTypeName.contains("("))
				typeName = dbDataTypeName.substring(0, dbDataTypeName.indexOf("("));
			for (DataType dataType:configuration.getDataTypes()) {
				if (dataType.getDetails() instanceof DataTypeDetails) {
					DataTypeDetails details = (DataTypeDetails)dataType.getDetails();
					if (details.getDbNativeType().equalsIgnoreCase(typeName)) {
						return dataType;
					}
				}
			}
		}
		catch (Throwable e) {
			Logger.error("Error while mapping datatype: " + dbDataTypeName, e);
		}
		throw new SQLException("Native type : \"" + dbDataTypeName + "\" in " + entity.getName()+ "." + attribute.getName() + " Not found in configuration section, it can't be mapped !!!");
		
	}

	public LinkedHashMap<String, Entity> getEntities() {
		return entities;
	}

	public LinkedHashMap<String, String> getViews() {
		return views;
	}

	public List<Entity> getSelectedEntities() {
		return selectedEntities;
	}
	

}
