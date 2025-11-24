package com.jsantos.sqlservertest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Vector;

import com.jsantos.metadata.MT;
import com.jsantos.metadata.acc.MTTableAUDITEDTABLE;
import com.jsantos.metadata.acc.MTTablePURCHASEORDER;
import com.jsantos.metadata.acc.PurchaseOrderDTO;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.FieldValues;

public class TestInheritance {
	public static void main(String[] args) throws SQLException, IOException {
		MainDb.setMainDataSource(DataSourceProvider.sqlServerDataSource());
		new TestInheritance().test();
	}

	
	public void test() throws SQLException {
		System.out.println(MT.PURCHASEORDER.getFields());

		DetachedQueryResult dqr = new DetachedQueryResult(MT.PURCHASEORDER);
		Vector<FieldValues> dqrr = dqr.getPage(0);
		for (FieldValues row:dqrr) 
			System.out.println(row);
		System.out.println(MT.PURCHASEORDER.getFields());
		
		DetachedRecord dr = new DetachedRecord(MT.PURCHASEORDER);
		dr.set(MTTablePURCHASEORDER.FIRSTNAME, "pepito");
		dr.set(MTTablePURCHASEORDER.LASTNAME, "perez");
		dr.set(MTTablePURCHASEORDER.VATNUMBER, "1212");
		dr.set(MTTableAUDITEDTABLE.INPUTUSERID, 1);
		dr.insert();
		
		dr.set(MT.PURCHASEORDER.LASTNAME, "Martinez");
		dr.update();
		dr.set(MT.AUDITEDTABLE.INPUTUSERID, 2);
		dr.set(MT.AUDITEDTABLE.CREATED, new Date());
		dr.update();
		
		PurchaseOrderDTO dto = new PurchaseOrderDTO();
		dto.setFirstName("juanito");
		dto.setLastName("gonzalez");
		dto.setVatNumber("dubidu");
		dto.setInputUserId(1);
		dto.insert();
	
		System.out.println("Finished [ok]");
	}
}
