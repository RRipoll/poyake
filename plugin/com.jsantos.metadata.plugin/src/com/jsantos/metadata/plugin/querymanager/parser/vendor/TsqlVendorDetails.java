package com.jsantos.metadata.plugin.querymanager.parser.vendor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import com.jsantos.metadata.plugin.querymanager.parser.Asterisk;
import com.jsantos.metadata.plugin.querymanager.parser.Column;
import com.jsantos.metadata.plugin.querymanager.parser.Expression;
import com.jsantos.metadata.plugin.querymanager.parser.IVendorParserDetails;
import com.jsantos.metadata.plugin.querymanager.parser.SQLParser;
import com.jsantos.metadata.plugin.querymanager.parser.TableColumn;
import com.jsantos.metadataplugin.parser.sqlserver.TSqlLexer;
import com.jsantos.metadataplugin.parser.sqlserver.TSqlParser;

public class TsqlVendorDetails implements IVendorParserDetails{

	@Override
	public Column buildColumn(ParseTree match, Parser p) {
		TableColumn tableColumn = findTableColumn(match, p);
		Asterisk asterisk = findAsterisk(match, p);
		Expression expression = findExpression(match, p);
		if (null != tableColumn) return tableColumn;
		if (null != asterisk) return asterisk;
		if (null != expression) return expression;
		return null;
	}
	
	TableColumn findTableColumn(ParseTree tree, Parser p){
		ParseTree subTree = SQLParser.findFirstMatch(tree, p, getColumn());
		if (null == subTree) return null;
    	TableColumn tableColumn = new TableColumn();
    	tableColumn.setTableName(SQLParser.findFirstMatchText(subTree, p, getColumnTable()));
    	tableColumn.setColumnName(SQLParser.findFirstMatchText(subTree, p, getColumnName()));
    	tableColumn.setAlias(SQLParser.findFirstMatchText(subTree, p, getColumnAlias()));
		return tableColumn;
	}

	
	Asterisk findAsterisk(ParseTree tree, Parser p){
		ParseTree subTree = SQLParser.findFirstMatch(tree, p, getAsterisk());
		if (null == subTree) return null;
		Asterisk asterisk = new Asterisk();
		asterisk.setTableName(SQLParser.findFirstMatchText(subTree, p, getAsteriskTable()));
		return asterisk;
	}

	Expression findExpression(ParseTree tree, Parser p){
		ParseTree subTree = SQLParser.findFirstMatch(tree, p, getExpression());
		if (null == subTree) return null;
		Expression expression = new Expression();
		expression.setExpresionText(SQLParser.findFirstMatchText(subTree, p, getExpressionText()));
		expression.setAlias(SQLParser.findFirstMatchText(subTree, p, getExpressionAlias()));
		return expression;
	}
	
	@Override
	public Lexer instantiateLexer(CharStream in) {
		return new TSqlLexer(in);
	}

	@Override
	public Parser instantiateParser(Lexer lexer) {
		return new TSqlParser(new CommonTokenStream(lexer));
	}

	@Override
	public RuleContext getRuleContext(Parser p) {
		return ((TSqlParser)p).tsql_file();
	}

	@Override
	public String getSelectStatement() {
		return "//select_statement";
	}

	@Override
	public String getTables() {
		return "//table_source_item";
	}

	@Override
	public String getTableName() {
		return "//table_name_with_hint/table_name";
	}

	@Override
	public String getTableAlias() {
		return "//as_table_alias/table_alias";
	}

	@Override
	public String getViewName() {
		return "//create_view/simple_name";
	}

	@Override
	public String getColumns() {
		return "/select_statement/query_expression/query_specification/select_list/select_list_elem";
	}
	
	@Override
	public String getColumn() {
		return "/select_list_elem/column_elem";
	}

	@Override
	public String getColumnTable() {
		return "/column_elem/table_name";
	}

	@Override
	public String getColumnName() {
		return "/column_elem/id";
	}

	@Override
	public String getColumnAlias() {
		return "/column_elem/as_column_alias/column_alias";
	}

	@Override
	public String getAsterisk() {
		return "/select_list_elem/asterisk";
	}

	@Override
	public String getAsteriskTable() {
		return "/asterisk/table_name";
	}

	@Override
	public String getExpression() {
		return "/select_list_elem/expression_elem";
	}

	@Override
	public String getExpressionText() {
		return "/expression_elem/expression";
	}

	@Override
	public String getExpressionAlias() {
		return "/expression_elem/as_column_alias/column_alias";
	}

	@Override
	public String getFunctionCalls() {
		return "//func_proc_name_schema";
	}



}
