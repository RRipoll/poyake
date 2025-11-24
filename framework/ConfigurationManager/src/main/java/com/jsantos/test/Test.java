package com.jsantos.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;

import com.jsantos.framework.configuration.Config;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.cfg.ConfigValueDTO;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.PostingDate;

public class Test {
	public static void main(String[] args) throws SQLException {
		MainDb.setMainDataSource(DataSourceProvider.sqlServerDataSource());
		
		DetachedQueryResult dqr = new DetachedQueryResult(MT.VCURRENTCONFIGVALUES);
		for (LinkedHashMap<String, Object> row:dqr.getPage(0)) {
			System.out.println(row);
		}
		
		ConfigValueDTO dto = new ConfigValueDTO();
		dto.setConfigKeyId(3);
		dto.setValue("MySql");
		dto.insert();
		
		dto.setValue("Otro");
		dto.update();

		System.out.println("After update");
		dqr = new DetachedQueryResult(MT.VCURRENTCONFIGVALUES);
		for (LinkedHashMap<String, Object> row:dqr.getPage(0)) {
			System.out.println(row);
		}
		
		Config  config = new Config();
		config.set(3, "patatin");
//		config.set(4, "20");
		config.setInFuture(4, "25", new Date(PostingDate.get().getTime() + 2000), new Date(PostingDate.get().getTime() + 5000));
		
		for (int i=1; i<10; i++) {
			System.out.println("Now: " + new Date());
			System.out.println("Toilet paper price: " + config.get(4));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		config.addToList(5, "Mimosin");
		config.addToList(5, "Scottex");
		
		System.out.println(config.getListValues(5));
		
		System.out.println("OK");
	}
}
