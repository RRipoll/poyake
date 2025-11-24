package com.etantolling.testrunner.test.zkweb.datagrid3ws;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class KeySetUtils {
	@SuppressWarnings("rawtypes")
	public static String getExceptionKeysSelector(Vector keyset){
		StringBuffer buff = new StringBuffer("(");
		for (Object id:keyset){
			if (1<buff.length()) buff.append(",");
			buff.append(id);
		}
		buff.append(")");
		return buff.toString();
	}

	public static String getKeysRs(ResultSet rs) throws SQLException{
		StringBuffer buff = new StringBuffer("");
		while(rs.next()){
			if (1<buff.length()) buff.append(",");
			buff.append(rs.getString(1));
		}
		buff.append("");
		return buff.toString();
	}
	
}
