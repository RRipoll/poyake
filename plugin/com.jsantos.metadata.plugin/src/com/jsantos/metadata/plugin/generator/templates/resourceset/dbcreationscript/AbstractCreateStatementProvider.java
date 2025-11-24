package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators.DependencySqlGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators.EnuMetadataInsertSqlGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators.IdGeneratorSQLGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators.SchemaSQLGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators.TableCreateSQLGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators.TableForeignKeysSQLGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators.TableMetadataInsertSQLGenerator;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators.ViewSQLGenerator;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.Metadata;
import com.jsantos.metadata.plugin.metaDsl.Sequence;
import com.jsantos.metadata.plugin.metaDsl.SqlNative;
import com.jsantos.metadata.plugin.metaDsl.SqlNativeBlock;

public abstract class AbstractCreateStatementProvider implements IModelStatementProvider {
	List<Entity> entities;
	List<Sequence> sequences;
	List<SqlNative> sqlNativeBlocks;
	List<Metadata> metadatas;
	
	@Override
	public List<String> buildStatements(){
		try {
			DependencySqlGenerator dependencySqlGenerator = new DependencySqlGenerator();
			ArrayList<String> all = new ArrayList<>();
			all.addAll(buildSchemaStatements());
			all.addAll(buildSqlNativeBlocksForFileStart());
			all.addAll(buildSequenceStatements(getVendor()));
			all.addAll(buildTableStatements(dependencySqlGenerator));
			all.addAll(buildMetadataStatements());
			all.addAll(buildConstraintStatements());
			all.addAll(buildViewStatements(dependencySqlGenerator));
			return all;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<String> buildSqlNativeBlocksForFileStart() {
		ArrayList<String> statements = new ArrayList<>();
		System.out.println("Building sqlnative for " + getVendor().toString());
		for (SqlNative sqlNative:sqlNativeBlocks) {
			boolean blockFound = false;
			for  (SqlNativeBlock sqlNativeBlock:sqlNative.getSqlNativeBlocks()) {
				if ("FILESTART".equalsIgnoreCase(sqlNative.getSqlPosition())) {
					if (!blockFound) {
						if (sqlNativeBlock.getDbType().equalsIgnoreCase(Vendor.DEFAULT.toString()) || sqlNativeBlock.getDbType().equalsIgnoreCase(getVendor().toString()))
							statements.add(sqlNativeBlock.getSqlBlock().replace("<SQLNATIVESTART>", "").replace("</SQLNATIVEEND>", ""));
					}
				}
			}
		}
		return statements;
	}
	
	public List<String> buildConstraintStatements()  {
		
		ArrayList<String> statements = new ArrayList<>();
		for (Entity entity:entities) 
			for (String createForeignKeyStatement:TableForeignKeysSQLGenerator.render(entity))
				statements.add(createForeignKeyStatement);
		return statements;
	}

	public List<String> buildSequenceStatements(Vendor vendor)  {
		
		ArrayList<String> statements = new ArrayList<>();
		for (Entity entity:entities)
			if (null != IdGeneratorSQLGenerator.renderCreate(entity, vendor))
				statements.add(IdGeneratorSQLGenerator.renderCreate(entity, vendor));
		for (Sequence sequence:sequences) {
			statements.add(IdGeneratorSQLGenerator.renderCreate(sequence, vendor));
		}
		return statements;
	}

	public List<String> buildSchemaStatements()  {
		
		ArrayList<String> statements = new ArrayList<>();

		Vector<String> schemas = new Vector<>();
		for (Entity entity:entities) {
			if (null != EntityHelper.getSchema(entity)) {
				if (!schemas.contains(EntityHelper.getSchema(entity)))
					schemas.add(EntityHelper.getSchema(entity));
			}
		}

		for (String schema:schemas)
			statements.add(SchemaSQLGenerator.renderCreate(schema));
		
		
		return statements;
	}

	public List<String> buildViewStatements(DependencySqlGenerator dependencySqlGenerator) throws URISyntaxException  {
		
		ArrayList<String> statements = new ArrayList<>();
		for (Entity entity:entities) 
			if ("VIEW".equals(entity.getEntityType()))
				statements.add(ViewSQLGenerator.renderCreate(entity, dependencySqlGenerator));
		return statements;
	}

	public List<String> buildTableStatements(DependencySqlGenerator dependencySqlGenerator)  {
		
		ArrayList<String> statements = new ArrayList<>();
		for (Entity entity:entities) 
			if (EntityHelper.isTable(entity))
				statements.add(TableCreateSQLGenerator.renderCreate(entity, getVendor(), dependencySqlGenerator));
		return statements;
	}

	public List<String> buildMetadataStatements()  {
		
		ArrayList<String> statements = new ArrayList<>();
		for (Entity entity:entities) {
			if (null != entity.getMetadata() && entity.getMetadata().getMetadataRows().size()>0)
				statements.add(TableMetadataInsertSQLGenerator.render(entity.getMetadata(), getVendor()));
			if (null != entity.getEnuMetadata() && entity.getEnuMetadata().getEnuMetadataRows().size()>0)
				statements.add(EnuMetadataInsertSqlGenerator.render(entity.getEnuMetadata(), getVendor()));
		}
		
		for (Metadata metadata:metadatas) {
			if (null != metadata.getEntity()) {
				if (metadata.getMetadataRows().size()>0) {
					statements.add(TableMetadataInsertSQLGenerator.render(metadata, getVendor()));
				}
			}
		}
		return statements;
	}
	

	@Override
	public void setModel(List<Entity> entities, List<Sequence> sequences, List<SqlNative> sqlNativeBlocks, List<Metadata> metadatas) {
		this.entities = entities;
		this.sequences = sequences;
		this.sqlNativeBlocks = sqlNativeBlocks;
		this.metadatas = metadatas;
	}

	protected abstract Vendor getVendor();
	
}
