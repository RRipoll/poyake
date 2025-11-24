package com.jsantos.metadata.plugin.querymanager;

import com.jsantos.metadata.plugin.querymanager.parser.Asterisk;
import com.jsantos.metadata.plugin.querymanager.parser.Column;
import com.jsantos.metadata.plugin.querymanager.parser.Expression;
import com.jsantos.metadata.plugin.querymanager.parser.SQLParser;
import com.jsantos.metadata.plugin.querymanager.parser.Table;
import com.jsantos.metadata.plugin.querymanager.parser.TableColumn;

public class QueryManager {
	
	public void logParserOutput(SQLParser parser) {
        System.out.println("Results:");
        System.out.println("View Name: " + parser.getFullyQualifiedViewName());
        System.out.println("Tables:");
        for (Table table:parser.getTables()) {
        	System.out.print("\tTable: " + table.getFullTableName());
        	if (null !=table.getTableAlias())
        		System.out.print(" Alias: " + table.getTableAlias());
        	System.out.println("");
        }
        System.out.println("Output:");
        for (Column column:parser.getColumns()) {
			if (column instanceof TableColumn) {
				TableColumn tableColumn = (TableColumn)column;
	        	System.out.print("\tColumn: " + tableColumn.getOutputName() + " -> ");
	        	if (null !=tableColumn.getTableRef()) 
	        		System.out.println(tableColumn.getTableRef().getFullTableName() + "." + tableColumn.getColumnName());
	        	else
	        		System.out.println("NOT FOUND");
	        }
			if (column instanceof Asterisk) {
				Asterisk asterisk = (Asterisk)column;
	        	System.out.print("\t");
	        	if (null != asterisk.getTableName()) System.out.print(asterisk.getTableName() + ".");
	        	System.out.print("* -> ");
	        	if (null != asterisk.getTableRef())
	        		System.out.print(asterisk.getTableRef().getFullTableName());
	        	else
	        		System.out.print("NOT FOUND");
	        	System.out.println("");
	        }
	
	        if (column instanceof Expression) {
	        	Expression expression = (Expression)column;
	        	System.out.print("\tExpression: ");
	        	if (null != expression.getAlias()) System.out.print(expression.getAlias() + " -> ");
	        	if (null != expression.getExpresionText()) System.out.print(expression.getExpresionText());
	        	System.out.println("");
	        }
        }		
	}
}
