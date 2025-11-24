package com.jsantos.sqlservertest;

import java.sql.SQLException;
import java.util.Vector;

import com.jsantos.metadata.MT;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.FieldValues;
import com.jsantos.orm.label.LabelSelector;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.util.HeaderInfo;

public class TestDetachedQueryResult {
	
	public static void main(String[] args) throws SQLException {
		MainDb.setMainDataSource(DataSourceProvider.sqlServerDataSource());
		new TestDetachedQueryResult().test();
	}
	
	public void test() throws SQLException {
		DetachedQueryResult dqr = new DetachedQueryResult(MT.INPUTUSER);
		Vector<FieldValues> dqrr = dqr.getPage(0);
		for (FieldValues row:dqrr) 
			System.out.println(row);
		
		HeaderInfo.logLabels(MT.QFULLCUSTOMERINFO.getFields());
		LabelSelector.inst().setDefaultLang("es_ES");
		HeaderInfo.logLabels(MT.QFULLCUSTOMERINFO.getFields());

		
		dqr = new DetachedQueryResult(MT.QFULLCUSTOMERINFO);
		dqrr = dqr.getPage(0);
		for (FieldValues row:dqrr) {
			System.out.print("row: ");
			for (MTField key:row.keySet()) {
				System.out.print(" [" + row.get(key).getClass().getName() + " " + key + ": " + row.get(key) + "] ");
			}
			System.out.println("");
		}
		
		System.out.println("Finished [ok]");
	}
}
