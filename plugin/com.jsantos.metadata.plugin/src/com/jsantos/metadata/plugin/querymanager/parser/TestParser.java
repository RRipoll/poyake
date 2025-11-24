package com.jsantos.metadata.plugin.querymanager.parser;

import java.io.IOException;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class TestParser {
	public static void main(String[] args) throws IOException {
		
		testSql("select * from xact.EnuTransactionType");
		testSql("select EnuTransactionType.* from xact.EnuTransactionType");
		testSql("select tt.* from xact.EnuTransactionType tt");
		testSql("create or alter view crm.v_estoeslapolla as SELECT l.transactionId as Manolito, 'PEPOTE' as pepote, tt.* FROM xact.Ledger l join xact.EnuTransactionType tt on tt.transactionTypeId=l.transactionTypeId");
		testSql("create or alter view crm.v_estoeslapolla as SELECT l.transactionId as Manolito, tt.description FROM xact.Ledger l join xact.EnuTransactionType tt on tt.transactionTypeId=l.transactionTypeId");
		testSql("SELECT l.transactionId as Manolito, tt.description FROM xact.Ledger l join xact.EnuTransactionType tt on tt.transactionTypeId=l.transactionTypeId");
		testSql("SELECT transactionId as Manolito, tt.description FROM xact.Ledger l join xact.EnuTransactionType tt on tt.transactionTypeId=l.transactionTypeId");
		testSql("SELECT Ledger.transactionId as Manolito, EnuTransactionType.description FROM xact.Ledger join xact.EnuTransactionType on Ledger.transactionTypeId=EnuTransactionType.transactionTypeId");
	}

	static void testSql(String sql) {
		System.out.println("=====================================");
		SQLParser parser = new SQLParser();
		parser.parseSql(sql, Vendor.SQLSERVER);
		System.out.println(parser.parseTreeToPrettyString());
        
	}
	
	
	
}



