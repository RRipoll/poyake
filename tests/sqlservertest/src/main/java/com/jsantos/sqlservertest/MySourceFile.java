package com.jsantos.sqlservertest;

import java.sql.SQLException;

import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTField;

public class MySourceFile {
	DetachedRecord dr = new DetachedRecord(MT.SOURCEFILE);
	
	public void setName(String value) {
		dr.set(MT.SOURCEFILE.FILENAME, "http://" + value);
	}
	
	public void set(MTField field, Object value) throws SQLException {
		if (field == MT.SOURCEFILE.FILENAME)
			throw new SQLException("use setName");
		dr.set(field, value);
	}
	
	public DetachedRecord getDetachedRecord() {
		return dr;
	}
}
