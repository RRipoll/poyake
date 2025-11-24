package com.etantolling.testrunner.test.core.db.dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Vector;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.cli.CliContextInitializer;
import com.etantolling.testrunner.test.core.cli.configfolder.ConfigFolderHelper;
import com.etantolling.testrunner.test.core.cli.connectionpool.CliConnectionPoolLoader;

public class DatabaseSchemaComparator {
	private static final Logger log = LoggerFactory.getLogger(DatabaseSchemaComparator.class);
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		CliContextInitializer.initialize();
		DataSource mdwDataSource = CliConnectionPoolLoader.initFromXml(ConfigFolderHelper.getConfigFile("connection_pool.xml").getCanonicalPath(), "jdbc/idc_mdw");
		DataSource mdtDataSource = CliConnectionPoolLoader.initFromXml(ConfigFolderHelper.getConfigFile("connection_pool.xml").getCanonicalPath(), "jdbc/prodCareful");
		
		new DatabaseSchemaComparator().compareTables(mdwDataSource.getConnection(), mdtDataSource.getConnection(), "idc_mdw", "idc_mdx");
	}	

	public void compareTables(Connection conn1, Connection conn2, String dbName1, String dbName2) throws SQLException{
		String sql = "SELECT t.name  FROM sys.tables AS t";
		
		Vector<String> tables1 = new Vector<String>();
		Vector<String> tables2 = new Vector<String>();
		Statement st1 = conn1.createStatement();
		Statement st2 = conn2.createStatement();
		ResultSet rs1 = st1.executeQuery(sql);
		ResultSet rs2 = st2.executeQuery(sql);
		while (rs1.next()) tables1.add(rs1.getString("name"));
		rs1.close();
		while (rs2.next()) tables2.add(rs2.getString("name"));
		rs2.close();

		log.info("Got results, start check");
		log.info("Number of tables. " + dbName1 + ": " + tables1.size() + " --- " + dbName2 + ": " + tables2.size());
		log.info("======================================");
		for (String tableName:tables1)
			if (!tables2.contains(tableName))
				log.info("Table [" + tableName + "] in " + dbName1 + " but not in " + dbName2);
			
		log.info("--------------------------------------");
		for (String tableName:tables2)
			if (!tables1.contains(tableName))
				log.info("Table [" + tableName + "] in " + dbName2 + " but not in " + dbName1);
		
		log.info("======================================");
		
		log.info("Comparing fieds...");
		
		
		for (String tableName:tables1){
			if (tables2.contains(tableName)){
				log.info("Table [" + tableName + "]");
				sql = "SELECT c.name 'Column Name', t.Name 'Data type', c.max_length 'Max Length', c.precision , c.scale , c.is_nullable, ISNULL(i.is_primary_key, 0) 'Primary Key' FROM    sys.columns c INNER JOIN   sys.types t ON c.user_type_id = t.user_type_id LEFT OUTER JOIN   sys.index_columns ic ON ic.object_id = c.object_id AND ic.column_id = c.column_id LEFT OUTER JOIN  sys.indexes i ON ic.object_id = i.object_id AND ic.index_id = i.index_id WHERE c.object_id = OBJECT_ID(?)";
				PreparedStatement pst1 = conn1.prepareStatement(sql);
				PreparedStatement pst2 = conn2.prepareStatement(sql);
				pst1.setString(1, tableName);
				pst2.setString(1, tableName);
				rs1 = pst1.executeQuery();
				rs2 = pst2.executeQuery();
				LinkedHashMap<String, FieldInfo> columns1 = new LinkedHashMap<String, FieldInfo>();
				LinkedHashMap<String, FieldInfo> columns2 = new LinkedHashMap<String, FieldInfo>();
				
				while (rs1.next()){
					FieldInfo fieldInfo = new FieldInfo();
					fieldInfo.columnName = rs1.getString("Column Name");
					fieldInfo.dataType = rs1.getString("Data type");
					fieldInfo.maxLength = rs1.getString("Max Length");
					fieldInfo.precision = rs1.getString("precision");
					fieldInfo.scale = rs1.getString("scale");
					fieldInfo.isNullable = rs1.getString("is_nullable");
					fieldInfo.isPrimaryKey = rs1.getString("Primary Key");
					columns1.put(fieldInfo.columnName, fieldInfo);
				}
				rs1.close();
				pst1.close();
				
				while (rs2.next()){
					FieldInfo fieldInfo = new FieldInfo();
					fieldInfo.columnName = rs2.getString("Column Name");
					fieldInfo.dataType = rs2.getString("Data type");
					fieldInfo.maxLength = rs2.getString("Max Length");
					fieldInfo.precision = rs2.getString("precision");
					fieldInfo.scale = rs2.getString("scale");
					fieldInfo.isNullable = rs2.getString("is_nullable");
					fieldInfo.isPrimaryKey = rs2.getString("Primary Key");
					columns2.put(fieldInfo.columnName, fieldInfo);
				}
				rs2.close();
				pst2.close();
				
				for (String columnName: columns1.keySet())
					if (!columns2.containsKey(columnName))
						log.info("Field " + tableName + "." + columnName + " found in " + dbName1 + " but not in " + dbName2);
				
				for (String columnName: columns2.keySet())
					if (!columns1.containsKey(columnName))
						log.info("Field " + tableName + "." + columnName + " found in " + dbName2 + " but not in " + dbName1);
				
			}
		}
		log.info("Finished [ok]");
	}
	
	class FieldInfo{
		String columnName;
		String dataType;
		String maxLength;
		String precision;
		String scale;
		String isNullable;
		String isPrimaryKey;
	}
}
