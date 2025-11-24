package com.jsantos.orm.pattern.autohistory;

import com.jsantos.common.util.MapValues;
import com.jsantos.factory.DTOFactory;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class AutohistoryHelper {
	public static final String AUTOHISTORY = "Autohistory";
	public static final String AUTOHISTORYMAINFK = "AUTOHISTORYMAINFK";
	
	
	
	public static IDetachedRecord getByMainFk(MTTable table, Object mainFk) {
		String where = table.getMainFk().getName() + "=:" + table.getMainFk().getName() + " and startDate<getPostingDate() and endDate>getPostingDate()";
		return new DTOFactory().get(table).find(where, new MapValues<Object>().add(table.getMainFk().getName(), mainFk))  ;
	}
}
