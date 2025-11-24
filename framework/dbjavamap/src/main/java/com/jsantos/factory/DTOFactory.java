package com.jsantos.factory;

import java.util.HashMap;

import com.jsantos.common.util.MapValues;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTTable;

public class DTOFactory {
	static final HashMap<String, Class> dtoRegistry = new HashMap<>();
	
	
	public static boolean exists(MTTable table) {
		if (null == table || null == dtoRegistry.get(table.getFullTableName()))
				return false;
		return true;
	}
	
	public static DetachedRecord get(MTTable table) {
		try {
			if(!exists(table)){
				logInfo();
				throw new RuntimeException("No DTO registered for table " + table);
			}
			DetachedRecord dr=(DetachedRecord) dtoRegistry.get(table.getFullTableName()).newInstance();
			return dr;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static DetachedRecord get(MTTable table, Object pk) {
		if(null==pk)
			return get(table);
		try {
			DetachedRecord dr=(DetachedRecord) dtoRegistry.get(table.getFullTableName()).newInstance();
			dr.set(dr.getTable().getMainFk(), pk);
			dr.setWhereExpression(dr.getTable().getMainFk() + " = :"+dr.getTable().getMainFk());
			dr.setParams(new MapValues<Object>().add(dr.getTable().getMainFk().toString(), pk));
			dr.load();
			if (null != table.getExtendsTable())
				dr.setExtendedDetachedRecord(new DetachedRecord(table.getExtendsTable(), pk));
		    return dr;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void logInfo() {
		System.out.println("DTOFactory: ==========================================");
		for (String tableName: dtoRegistry.keySet())
			System.out.println("\t" + dtoRegistry.get(tableName).getName() + " ---> "+ tableName );
		System.out.println("------------------------------------------------------");
		System.out.println("");
	}

	public static void put(MTTable table, Class<?> loadClass) {
		dtoRegistry.put(table.getFullTableName(), loadClass);
	}
}
