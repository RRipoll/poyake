package com.jsantos.sqlservertest;

import java.io.IOException;
import java.sql.SQLException;

import com.jsantos.metadata.MT;
import com.jsantos.metadata.crm.MTTableCUSTOMER;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.label.LabelSelector;
import com.jsantos.orm.util.HeaderInfo;

public class TestDetachedRecord {
	public static void main(String[] args) throws SQLException, IOException {
		MainDb.setMainDataSource(DataSourceProvider.sqlServerDataSource());
		new TestDetachedRecord().testDetachedRecord();
	}
	
	void testDetachedRecord() throws SQLException, IOException {
		HeaderInfo.logLabels(MT.CUSTOMER.getFields());
		HeaderInfo.logLabels(MT.QFULLCUSTOMERINFO.getFields());
		LabelSelector.inst().setDefaultLang("es_ES");
		HeaderInfo.logLabels(MT.CUSTOMER.getFields());
		HeaderInfo.logLabels(MT.QFULLCUSTOMERINFO.getFields());

		DetachedRecord dt = new DetachedRecord(MT.CUSTOMER);
		dt.set(MTTableCUSTOMER.FIRSTNAME, "Tirion");
		dt.set(MTTableCUSTOMER.LASTNAME, "Lannister");
		dt.set(MTTableCUSTOMER.TAXCODE3, "XXXX");
		dt.insert();
		
		DetachedRecord dt2 = new DetachedRecord(MT.CUSTOMER,dt.getInt(MTTableCUSTOMER.CUSTOMERID));

		System.out.println(dt2.getOriginalValues());

		dt2.set(MTTableCUSTOMER.FIRSTNAME, "El Guapo");
		dt2.update();
		
		DetachedRecord dt3 = new DetachedRecord(MT.CUSTOMER,dt2.getInt(MTTableCUSTOMER.CUSTOMERID));
		System.out.println(dt3.getOriginalValues());
		
		System.out.println("Test finished [OK]");
	}
}
