package com.poyake.tutorial.orm.simple;

import java.sql.SQLException;

import com.jsantos.metadata.AuthorDTO;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.MTTableAUTHOR;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.mt.MTField;

public class Main {
	public static void main(String[] args) throws SQLException {
		MainDb.setMainDataSource(DataSourceProvider.getDataSource());
		MT.init();
		new Main().testDetachedRecord();
	}
	
	void testDetachedRecord() throws SQLException {
		
	//creo tabla
	 AuthorDTO author = new AuthorDTO();
	 author.setAuthorId(1);
	 author.setFirstName("Pepito");
	 author.setLastName("Smith");
	 author.insert();
	 System.out.println(new AuthorDTO().find(1));

	 
	 System.out.println("Metadata: ");
	 for (MTField field:author.getTable().getFields()) {
		 System.out.println(field.getLabel());
		 System.out.println("   Default Value: " + field.getDefaultValue());
		 System.out.println("   Data type: " + field.getDataType());
		 System.out.println("   Is foreign key? " + (null !=field.getForeignKey()));
	 }
	 
	 System.out.println(MTTableAUTHOR.FIRSTNAME.getLabel());
	 System.out.println(MTTableAUTHOR.LASTNAME.getLabel());
	 System.out.println(MT.AUTHOR.getLabel());
	 
 	 System.out.println("Test finished [OK]");
	}

}
