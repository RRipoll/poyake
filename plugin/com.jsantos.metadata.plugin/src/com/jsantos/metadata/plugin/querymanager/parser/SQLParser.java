package com.jsantos.metadata.plugin.querymanager.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.apache.commons.lang3.StringUtils;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;
import com.jsantos.metadata.plugin.querymanager.parser.vendor.TsqlVendorDetails;

public class SQLParser {
	List<Table> tables = null;
	List<Column> columns = null;
	ArrayList<String> functionDependencies;
	Parser p = null;
	RuleContext tree = null;
	String viewName = null;
	String selectStatement = null;
	Lexer lexer;
	CaseChangingCharStream in;
	IVendorParserDetails vendorDetails = null;
	
	public void parseSql(String sql , Vendor vendor){
		System.out.println("Query: \r\n" + sql + "\r\n");
		
		switch(vendor) {
		//case MYSQL:
		//	vendorDetails = new MySqlVendorDetails();
		//	break;
		default:
			vendorDetails = new TsqlVendorDetails();
		}
		
		
		in = new CaseChangingCharStream(CharStreams.fromString(sql), true);
		
		lexer = vendorDetails.instantiateLexer(in);
		p = vendorDetails.instantiateParser(lexer);
        p.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
            }
        });
        SQLParserListener parseListener = new SQLParserListener(); 
        p.addParseListener(parseListener);
        p.setBuildParseTree(true);

        tree = vendorDetails.getRuleContext(p);
        
        System.out.println(parseTreeToPrettyString());
        ParseTree selectParseTree = findSelectStatement(tree, p);
        tables = findTables(tree, p);
        columns = findColumns(selectParseTree, p);
        viewName = findViewName(tree, p);
        selectStatement = parseListener.getSqlStatement();
        functionDependencies = findFunctionCalls(tree, p);
        
        link(tables);
        
	}
	
	public String getFullyQualifiedViewName() {
		return viewName;
	}
	
	public String getViewName() {
		if (!StringUtils.isEmpty(viewName)) {
			if (2==viewName.split("\\.").length)
				return viewName.split("\\.")[1];
			else
				return viewName;
		}
		else
			return null;
	}

	public String getSchemaName() {
		if (!StringUtils.isEmpty(viewName)) {
			if (2==viewName.split("\\.").length)
				return viewName.split("\\.")[0];
			else
				return "dbo";
		}
		else
			return "dbo";
	}
	
	
	public String getSelectStatement() {
		return selectStatement;
	}

	public List<Table> getTables(){
		return tables;
	}

	public List<Column> getColumns(){
		return columns;
	}
	
	public void link(List<Table> tables){
		for (Column column:columns) {
			if (column instanceof TableColumn) {
				TableColumn tableColumn = (TableColumn)column;
				for(Table table:tables) {
					if (null != table.getTableAlias() && table.getTableAlias().equalsIgnoreCase(tableColumn.getTableName()))
						tableColumn.setTableRef(table);
					if (table.getTableName().equalsIgnoreCase(tableColumn.getTableName()))
						tableColumn.setTableRef(table);
				}
			}
			if (column instanceof Asterisk) {
				Asterisk asterisk = (Asterisk)column;
				if (null == asterisk.getTableName() && tables.size()==1)
					asterisk.setTableRef(tables.get(0));
				else {
					if (null!=asterisk.getTableName()) {
						for (Table table:tables) {
							if (null != table.getTableAlias() && table.getTableAlias().equals(asterisk.getTableName()))
								asterisk.setTableRef(table);
							if (table.getTableName().equals(asterisk.getTableName()))
								asterisk.setTableRef(table);
							
						}
					}
				}
			}
		}
	}
	
	ArrayList<String> findFunctionCalls(RuleContext tree, Parser p){
		ArrayList<String> calls = new ArrayList<>();
		Collection<ParseTree> matches = XPath.findAll(tree, "//func_proc_name_schema", p);
		for(ParseTree match:matches) {
			String functionName = match.getText();
			if (functionName.contains(".") && functionName.length() > functionName.indexOf('.'))
				functionName = functionName.split("\\.")[1];
			calls.add(functionName);
		}
		return calls;
	}
	
	ParseTree findSelectStatement(RuleContext tree, Parser p) {
		return findFirstMatch(tree, p, vendorDetails.getSelectStatement());
	}
	
	List<Column> findColumns(ParseTree tree, Parser p){
		logTree(tree);
		ArrayList<Column> columns = new ArrayList<>();
		Collection<ParseTree> matches = XPath.findAll(tree, vendorDetails.getColumns(), p);
		for(ParseTree match:matches) {
			columns.add(vendorDetails.buildColumn(match, p));
		}
		return columns;
	}
	
	List<Table> findTables(ParseTree tree, Parser p){
		logTree(tree);
		ArrayList<Table> tables = new ArrayList<>();
    	Collection<ParseTree> matches = XPath.findAll(tree, vendorDetails.getTables(), p);
    	for(ParseTree match:matches) {
        	Table table = new Table();
        	table.setFullTableName(findFirstMatchText(match, p, vendorDetails.getTableName()));
        	table.setTableAlias(findFirstMatchText(match, p, vendorDetails.getTableAlias()));
        	tables.add(table);
        }
        return tables;
	}
	
	String findViewName(RuleContext tree, Parser p) {
		return findFirstMatchText(tree, p, vendorDetails.getViewName());
	}
	
	
	public String parseTreeToPrettyString() {
        return TreeUtils.toPrettyTree(tree, Arrays.asList(p.getRuleNames()));
	}
	
	public static String findFirstMatchText(ParseTree tree, Parser p, String xPathExpression) {
		Collection<ParseTree> matches = XPath.findAll(tree, xPathExpression, p);
		for(ParseTree match:matches)
			return match.getText();
		return null;
	}

	public static ParseTree findFirstMatch(ParseTree tree, Parser p, String xPathExpression) {
		Collection<ParseTree> matches = XPath.findAll(tree, xPathExpression, p);
		for(ParseTree match:matches)
			return match;
		return null;
	}

	private void logTree(ParseTree tree) {
		System.out.println(TreeUtils.toPrettyTree(tree, Arrays.asList(p.getRuleNames())));
	}
	
	public String logParserResults() {
		MyStringBuffer out = new MyStringBuffer();
		
        out.println("Results:");
        out.println("VIEW FULL NAME: " + getFullyQualifiedViewName() + "  \r\nVIEW NAME: " + getViewName() + " \r\nVIEW SCHEMA: " + getSchemaName());
        out.println("");
        out.println("Tables:");
        for (Table table:getTables()) {
        	out.print("\tTABLE: " + table.fullTableName);
        	if (null !=table.getTableAlias())
        		out.print(" Alias: " + table.getTableAlias());
        	out.println("");
        }
        out.println("Output:");
        for (Column column:columns) {
	        if(column instanceof TableColumn) {
				TableColumn tableColumn = (TableColumn)column;
	        	out.print("\tCOLUMN: " + tableColumn.getOutputName() + " -> ");
	        	if (null !=tableColumn.getTableRef()) 
	        		out.println(tableColumn.getTableRef().getFullTableName() + "." + tableColumn.getColumnName());
	        	else
	        		out.println("NOT FOUND");
	        }
	        if (column instanceof Asterisk) {
				Asterisk asterisk = (Asterisk)column;
	        	out.print("\t");
	        	if (null != asterisk.getTableName()) out.print(asterisk.getTableName() + ".");
	        	out.print("* -> ");
	        	if (null != asterisk.getTableRef())
	        		out.print(asterisk.getTableRef().fullTableName);
	        	else
	        		out.print("NOT FOUND");
	        	out.println("");
	        }
	
	        if (column instanceof Expression) {
	        	Expression expression = (Expression)column;
	        	out.print("\tEXPRESSION: ");
	        	if (null != expression.getAlias()) out.print(expression.getAlias() + " -> ");
	        	if (null != expression.getExpresionText()) out.print(expression.getExpresionText());
	        	out.println("");
	        }
        }		
		return out.toString();
	}
	
	public class MyStringBuffer{
		StringBuffer out = new StringBuffer();
		
		public void println(String s) {
			out.append(s);
			out.append("\r\n");
		}

		public void print(String s) {
			out.append(s);
		}
		
		public String toString() {
			return out.toString();
		}
	}

	public ArrayList<String> getFunctionDependencies() {
		return functionDependencies;
	}
	
	
}
