package com.jsantos.metadata.plugin.dbmanager.tests;

import org.eclipse.datatools.connectivity.sqm.internal.core.RDBCorePlugin;
import org.eclipse.datatools.enablement.mysql.ddl.MySqlDdlBuilder;
import org.eclipse.datatools.modelbase.sql.schema.Catalog;
import org.eclipse.datatools.modelbase.sql.schema.Database;
import org.eclipse.datatools.modelbase.sql.schema.Schema;
import org.eclipse.datatools.modelbase.sql.tables.BaseTable;
import org.eclipse.datatools.modelbase.sql.tables.Column;

public class EclipseDataToolsModelCreator {
	public void test() {
		try {
			Database database = new MyDatabase();
			database.setVendor("MySql");
			database.setVersion("5.1");

			Catalog catalog = new MyCatalog();
			catalog.setDatabase(database);
			catalog.setName("catalog");

			Schema schema = new MySchema();
			schema.setName("crm");
			schema.setCatalog(catalog);
			schema.setDatabase(database);

			BaseTable creditCard = new MyTable();
			creditCard.setName("CreditCard");
			creditCard.setSchema(schema);
			
			Column creditCardId = new MyColumn();
			creditCardId.setName("creditCardId");
			creditCardId.setTable(creditCard);
			creditCardId.setDataType(RDBCorePlugin.getDefault().getDatabaseDefinitionRegistry().getDefinition("MySql", "5.1").getPredefinedDataType("INTEGER"));

			Column ccNumber = new MyColumn();
			ccNumber.setName("ccNumber");
			ccNumber.setTable(creditCard);
			ccNumber.setDataType(RDBCorePlugin.getDefault().getDatabaseDefinitionRegistry().getDefinition("MySql", "5.1").getPredefinedDataType("INTEGER"));
			
			Column customerId = new MyColumn();
			customerId.setName("customerId");
			customerId.setTable(creditCard);
			customerId.setDataType(RDBCorePlugin.getDefault().getDatabaseDefinitionRegistry().getDefinition("MySql", "5.1").getPredefinedDataType("INTEGER"));

			MyPrimaryKey pk = new MyPrimaryKey();
			pk.setBaseTable(creditCard);
			pk.getMembers().add(creditCardId);

			
			BaseTable customer = new MyTable();
			customer.setName("customer");
			customer.setSchema(schema);
			
			Column CustomerCustomerId = new MyColumn();
			CustomerCustomerId.setName("customerId");
			CustomerCustomerId.setTable(customer);
			CustomerCustomerId.setDataType(RDBCorePlugin.getDefault().getDatabaseDefinitionRegistry().getDefinition("MySql", "5.1").getPredefinedDataType("INTEGER"));

			pk = new MyPrimaryKey();
			pk.setBaseTable(customer);
			pk.getMembers().add(CustomerCustomerId);
			
			MyForeignKey fk = new MyForeignKey();
			fk.setName("FK_CreditCard_customerId");
			fk.setBaseTable(creditCard);
			fk.getMembers().add(customerId);
			fk.setReferencedTable(customer);
			fk.setUniqueConstraint(pk);
			
			MySqlDdlBuilder b = new MySqlDdlBuilder();
			System.out.println(b.createTable(creditCard, true, false, true));
			System.out.println(b.createTable(customer, true, false, true));
			System.out.println(b.addForeignKey(fk, false, false));
			//String[] out = new MySqlDdlGenerator().createSQLObjects(tables, false, false, null);
			//System.out.println(out[0]);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		//c.setDataType(JDBCD);
		
		
	}
}
