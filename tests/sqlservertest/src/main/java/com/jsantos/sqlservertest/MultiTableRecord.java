package com.jsantos.sqlservertest;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTTable;

public class MultiTableRecord {
	ArrayList<MTTable> tables = new ArrayList<MTTable>();
	
	public void addTable(MTTable table) {
		tables.add(table);
	}
	
	public void load(int pkForMainTable) throws SQLException {
		for (MTTable table:tables) {
			DetachedRecord dr = new DetachedRecord(tables.get(0), pkForMainTable);
			
		}
	}
}
