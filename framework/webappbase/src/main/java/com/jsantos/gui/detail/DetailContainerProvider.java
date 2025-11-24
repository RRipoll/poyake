package com.jsantos.gui.detail;

import java.util.LinkedHashMap;

import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.orm.mt.MTTable;

/**
 * @author raul ripoll
 */

public class DetailContainerProvider {

	static final LinkedHashMap<String, IDetailContainer> byTable = new LinkedHashMap<>();
		

	
	public static IDetailContainer getDetailContainer(MTTable table){
		try {
			IDetailContainer retValue;
		
			if (null!=table && byTable.containsKey(table.getTableName())) {
				retValue= byTable.get(table.getTableName()).getClass().newInstance();
			}
			else { 
				retValue= new DefaultDetailContainer();
				retValue.setmTTable(table);
			}
			return retValue;
			}
		catch (InstantiationException| IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	public static void logBindings() {
		System.out.println("Custom Detail Containers: ===============================================");
		for (String table:byTable.keySet())
			System.out.println("Custom Field Container Provider: " + table + " -> " + byTable.get(table).getClass().getSimpleName());
		
		
		
		System.out.println("-----------------------------------------------------");
		System.out.println("");
	}



	public static void putByTable(MTTable getmTTable, IDetailContainer container) {
		byTable.put(getmTTable.getTableName(), container);
		
	}

	
	
	
	
	
}
