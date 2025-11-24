package com.jsantos.metadata.plugin.querymanager.parser;

import org.antlr.v4.runtime.misc.Interval;

import com.jsantos.metadataplugin.parser.sqlserver.TSqlParser.Select_statementContext;
import com.jsantos.metadataplugin.parser.sqlserver.TSqlParserBaseListener;

public class SQLParserListener extends TSqlParserBaseListener{
	private String sqlStatement = null;
	
	
	@Override
	public void exitSelect_statement(Select_statementContext ctx) {
		sqlStatement = ctx.start.getInputStream().getText(new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));
		super.exitSelect_statement(ctx);
	}


	public String getSqlStatement() {
		return sqlStatement;
	}


	public void setSqlStatement(String sqlStatement) {
		this.sqlStatement = sqlStatement;
	}
	
}
