package com.etantolling.testrunner.test.core.metadata;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import com.etantolling.testrunner.test.core.cli.CliContextInitializer;

public class MTTableDependencies {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		CliContextInitializer.initialize();
		Vector<MTTable> tables = (new MTTableDependencies()).findDependencyOrder();
		for (MTTable table:tables)
			System.out.println(table);
	}
	
	public Vector<MTTable> findDependencyOrder(){
		Vector<MTTable> tables = new Vector<MTTable>();
		for (MTTable table:MTBase.getTables().values()) tables.add(table);
		Collections.sort(tables, new MTTableDependencyComparator());
		return tables;
	}
	
	class MTTableDependencyComparator implements Comparator<MTTable>{
		@Override
		public int compare(MTTable t1, MTTable t2) {
			for (MTField field:t1.getFields().values()){
				if (field.getForeignKey() == t2)
					return 1;
			}
			for (MTField field:t2.getFields().values()){
				if (field.getForeignKey() == t1)
					return -1;
			}
			return 0;
		}
		
	}
}
