package com.jsantos.metadata.plugin.querymanager.resolver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.accessors.ModelCollector;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Configuration;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.querymanager.jdbcresolver.JDBCResolver;
import com.jsantos.metadata.plugin.querymanager.jdbcresolver.JDBCResolverColumn;
import com.jsantos.metadata.plugin.querymanager.parser.Asterisk;
import com.jsantos.metadata.plugin.querymanager.parser.Column;
import com.jsantos.metadata.plugin.querymanager.parser.Expression;
import com.jsantos.metadata.plugin.querymanager.parser.SQLParser;
import com.jsantos.metadata.plugin.querymanager.parser.Table;
import com.jsantos.metadata.plugin.querymanager.parser.TableColumn;

public class Resolver {
	SQLParser parser;
	List<Entity> entities;
	Configuration configuration;
	ArrayList<ResolverColumn> resolverColumns = new ArrayList<>();
	JDBCResolver jdbcResolver = null;
	
	public Resolver(SQLParser parser, IProject project) throws CoreException{
		this.parser = parser;
		ModelCollector modelCollector = new ModelCollector(project.getName());
		this.entities = modelCollector.getEntities();
		this.configuration = modelCollector.getConfiguration();
	}
	
	public boolean isFullyResolved() {
		for (ResolverColumn column:resolverColumns)
			if (column.getStatus() == ResolverColumnStatus.ATTRIBUTE_NOT_FOUND || column.getStatus() == ResolverColumnStatus.EXPRESSION)
				return false;
		return true;
	}
	
	public void setJDBCResolver(JDBCResolver jdbcResolver) {
		this.jdbcResolver=  jdbcResolver;
	}
	
	public List<ResolverColumn> getResolverColumns() {
		return resolverColumns;
	}
	
	public void resolveAll() throws SQLException {
		for (Column column:parser.getColumns()) {
			if (column instanceof TableColumn)
				resolverColumns.add(resolveTableColumn((TableColumn)column));
			if (column instanceof Expression)
				resolverColumns.add(resolveExpression((Expression)column));
			if (column instanceof Asterisk)
				for (ResolverColumn resolverColumn:resolveAsterisk((Asterisk)column))
					resolverColumns.add(resolverColumn);
		}
		if (null != jdbcResolver) {
			logInfo();
			checkAgainstJDBCResolver();
		}
	}
	
	
	public void checkAgainstJDBCResolver() throws SQLException {
		if (jdbcResolver.getColumns().size() != resolverColumns.size()) {
			System.out.println(parser.parseTreeToPrettyString());
			throw new SQLException("jdbc resolver column size: " + jdbcResolver.getColumns().size() + " is different from offline resolver column size: " + resolverColumns.size());
		}
		for (ResolverColumn resolverColumn:resolverColumns) {
			JDBCResolverColumn jdbcResolverColumn = jdbcResolver.getColumns().get(resolverColumns.indexOf(resolverColumn));
			System.out.println("Checking column: " + resolverColumn.getAttributeName());
			if (!StringUtils.isEmpty(jdbcResolverColumn.getName()) && !resolverColumn.getAttributeName().equalsIgnoreCase(jdbcResolverColumn.getName()))
				throw new SQLException(" jdbc resolver column name: " + jdbcResolverColumn.getName() + " is different from offline resolver column name: " + resolverColumn.getAttributeName());
			if (resolverColumn.status == ResolverColumnStatus.EXPRESSION)
				resolverColumn.setDataTypeFromJDBC(jdbcResolverColumn.renderType(configuration));
		}
	}
	
	ResolverColumn resolveTableColumn(TableColumn tableColumn) {
		ResolverColumn resolverColumn = new ResolverColumn(tableColumn.getOutputName()); 
		for (Entity entity:entities) {
			if (null !=tableColumn.getTableName() && entity.getName().equalsIgnoreCase(tableColumn.getTableRef().getFullTableName())) {
				for (Attribute attribute:entity.getAttributes()) {
					if (attribute.getName().equalsIgnoreCase(tableColumn.getColumnName())) {
						resolverColumn.setStatus(ResolverColumnStatus.SOLVED);
						resolverColumn.setSameAsAttribute(attribute);
					}
				}
			}
		}

		if (null == tableColumn.getTableName() && !resolverColumn.getStatus().equals(ResolverColumnStatus.SOLVED)) {
			int count = 0;
			Attribute lastMatchedAttribute = null;
			for (Entity entity:entities) {
				for (Table table:parser.getTables()) {
					if (table.getFullTableName().equalsIgnoreCase(entity.getName())) {
						for (Attribute attribute:entity.getAttributes()) {
							if (attribute.getName().equalsIgnoreCase(tableColumn.getColumnName())) {
								count ++;
								lastMatchedAttribute=attribute;
							}
						}
					}
				}
			}
			if (1==count) {
				resolverColumn.setStatus(ResolverColumnStatus.SOLVED);
				resolverColumn.setSameAsAttribute(lastMatchedAttribute);
			}
		}
		return resolverColumn;
	}
	
	List<ResolverColumn> resolveAsterisk(Asterisk asterisk){
		ArrayList<ResolverColumn> toBeAdded = new ArrayList<>();
		if (null != asterisk.getTableRef()) {
			for (Entity entity:entities) {
				if (entity.getName().equalsIgnoreCase(asterisk.getTableRef().getFullTableName())) {
					for (Attribute attribute:entity.getAttributes()) {
						ResolverColumn resolverColumn = new ResolverColumn(attribute.getName());
						resolverColumn.setStatus(ResolverColumnStatus.EXPANDED);
						resolverColumn.setSameAsAttribute(attribute);
						toBeAdded.add(resolverColumn);
					}
				}
			}
		}
		if (null == asterisk.getTableName() && null == asterisk.getTableRef()) {
			for (Table table:parser.getTables()) {
				for (Entity entity:entities) {
					if (entity.getName().equalsIgnoreCase(table.getTableName())) {
						for (Attribute attribute:entity.getAttributes()) {
							ResolverColumn resolverColumn = new ResolverColumn(attribute.getName());
							resolverColumn.setStatus(ResolverColumnStatus.EXPANDED);
							resolverColumn.setSameAsAttribute(attribute);
							toBeAdded.add(resolverColumn);
						}
						
					}
				}
			}
		}
		return toBeAdded;
	}
	
	ResolverColumn resolveExpression(Expression expression) {
		ResolverColumn resolverColumn = new ResolverColumn("expression" + parser.getColumns().indexOf(expression));
		resolverColumn.setStatus(ResolverColumnStatus.EXPRESSION);
		if (null != expression.getAlias())
			resolverColumn.setAttributeName(expression.getAlias());
		return resolverColumn;
	}
	
	List<Entity> buildEntityList(ResourceSet rs){
		System.out.println("Number of resources in resourceSet: " + rs.getResources().size());
		
		ArrayList<Entity> retValue = new ArrayList<>();
		Iterators.<Entity>filter(rs.getAllContents(), Entity.class).forEachRemaining(entity->{retValue.add(entity);});		
		return retValue;
	}
	
	public String logInfo() {
		StringBuffer out = new StringBuffer();
		out.append("Entity List:\r\n");
		out.append("\t");
		for (Entity entity:entities) {
			if (entities.indexOf(entity) >0) out.append(" ,");
			out.append(entity.getName());
		}
		
		out.append("Columns:\r\n");
		System.out.println("resolverColumns: ");
		for (ResolverColumn column:resolverColumns) {
			out.append("\t" + column.getStatus() + " " + column.getAttributeName() + " -> ");
			if (null != column.getSameAsAttribute()) {
				Entity entity = ((Entity)column.getSameAsAttribute().eContainer());
				out.append(entity.getName() + "." + column.getSameAsAttribute().getName());
			}
			out.append("\r\n");
		}
		return out.toString();
	}
}
