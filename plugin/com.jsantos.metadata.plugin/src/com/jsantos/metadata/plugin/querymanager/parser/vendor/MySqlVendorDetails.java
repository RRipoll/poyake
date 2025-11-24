package com.jsantos.metadata.plugin.querymanager.parser.vendor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import com.jsantos.metadata.plugin.querymanager.parser.Column;
import com.jsantos.metadata.plugin.querymanager.parser.IVendorParserDetails;
import com.jsantos.metadataplugin.parser.mysql.MySqlLexer;
import com.jsantos.metadataplugin.parser.mysql.MySqlParser;

public class MySqlVendorDetails implements IVendorParserDetails{
	
	@Override
	public Column buildColumn(ParseTree match, Parser p) {
		System.out.println("Match: " + match.getText());
		//String matchText = match.getText();
		//String tableName = null;
		//String fieldName = null;
		//String fieldAlias = SQLParser.findFirstMatchText(match, p, getColumnAlias());
		//if (matchText.contains("."))
		//	tableName = matchText.split("\\.")[0];
		return null;
	}
	

	@Override
	public Lexer instantiateLexer(CharStream in) {
		return new MySqlLexer(in);
	}

	@Override
	public Parser instantiateParser(Lexer lexer) {
		return new MySqlParser(new CommonTokenStream(lexer));
	}

	@Override
	public RuleContext getRuleContext(Parser p) {
		return ((MySqlParser)p).root();
	}

	@Override
	public String getSelectStatement() {
		return "//selectStatement";
	}

	@Override
	public String getTables() {
		return "//tableSourceItem";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "/tableSourceItem/tableName/fullId/uid/simpleId";
	}

	@Override
	public String getTableAlias() {
		return "/tableSourceItem/tableName/uid/simpleId";
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnAlias() {
		return "/selectElement/selectElementAlias";
	}

	@Override
	public String getColumns() {
		// TODO Auto-generated method stub
		return "/selectStatement/querySpecification/selectElements/selectElement";
	}

	@Override
	public String getAsterisk() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsteriskTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExpression() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExpressionText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExpressionAlias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFunctionCalls() {
		// TODO Auto-generated method stub
		return null;
	}


}
