package com.jsantos.metadata.plugin.querymanager.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public interface IVendorParserDetails {
	public Lexer instantiateLexer(CharStream in);
	public Parser instantiateParser(Lexer lexer);
	public RuleContext getRuleContext(Parser p);
	public String getSelectStatement();
	public String getTables();
	public String getTableName();
	public String getTableAlias();
	public String getViewName();
	public String getColumns();
	public String getColumn();
	public String getColumnTable();
	public String getColumnName();
	public String getColumnAlias();
	public String getAsterisk();
	public String getAsteriskTable();
	public String getExpression();
	public String getExpressionText();
	public String getExpressionAlias();
	public String getFunctionCalls();
	
	public Column buildColumn(ParseTree match, Parser p);
	
}
