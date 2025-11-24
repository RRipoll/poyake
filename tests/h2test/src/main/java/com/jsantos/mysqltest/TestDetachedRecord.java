package com.jsantos.mysqltest;

import java.sql.SQLException;

import com.jsantos.metadata.ComentarioDTO;
import com.jsantos.metadata.ComentariosDTO;
import com.jsantos.metadata.MT;
//import com.jsantos.metadata.OtraTablaNuevaDTO;
import com.jsantos.metadata.PersonaDTO;
import com.jsantos.orm.MainDb;

public class TestDetachedRecord {
	public static void main(String[] args) throws SQLException {
		MainDb.setMainDataSource(DataSourceProvider.MySqlDataSource());
		MT.init();
		new TestDetachedRecord().testDetachedRecord();
	}
	
	void testDetachedRecord() throws SQLException {
		
	//creo tabla
	 PersonaDTO pdto = new PersonaDTO();
	 pdto.setNombre("manolin");
	 pdto.setNif("07688886k");
	 
 	 System.out.println("Test finished [OK]");
	}

}
