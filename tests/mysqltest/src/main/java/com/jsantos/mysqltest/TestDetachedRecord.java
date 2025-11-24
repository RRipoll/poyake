package com.jsantos.mysqltest;

import java.sql.SQLException;

import com.jsantos.metadata.ComentarioDTO;
import com.jsantos.metadata.ComentariosDTO;
//import com.jsantos.metadata.OtraTablaNuevaDTO;
import com.jsantos.metadata.PersonaDTO;
import com.jsantos.orm.MainDb;

public class TestDetachedRecord {
	public static void main(String[] args) throws SQLException {
		MainDb.setMainDataSource(DataSourceProviderJavi.MySqlDataSource());
		new TestDetachedRecord().testDetachedRecord();
	}
	
	void testDetachedRecord() throws SQLException {
		
	//creo tabla
	 PersonaDTO pdto = new PersonaDTO();
	 pdto.setNombre("manolin");
	 pdto.setNif("07688886k");
	 ComentariosDTO comm = new ComentariosDTO();
	 comm.insert();
	 pdto.setComentariosId(comm.getComentariosId());
	 pdto.insert();
	 
		/*creo tabla
	 OtraTablaNuevaDTO otn = new OtraTablaNuevaDTO();
	 otn.setUnCampito("hola caracola");
	 comm = new ComentariosDTO();
	 comm.insert();
	 otn.setComentariosId(comm.getComentariosId());
	 otn.insert();
	 
	 
	 //creo comentario y añado a tabla
	 ComentarioDTO c = new ComentarioDTO();
	 c.setTexto("Comentario 1 para persona");
	 c.setTipo(1);
	 c.setComentariosId(pdto.getComentariosId());
	 c.insert();

	 
	 
	 c = new ComentarioDTO();
	 c.setTexto("Comentario 2 para persona");
	 c.setTipo(1);
	 c.setComentariosId(pdto.getComentariosId());
	 c.insert();

	 c = new ComentarioDTO();
	 c.setTexto("Comentario 2 para Otra tabla nueva");
	 c.setTipo(1);
	 c.setComentariosId(otn.getComentariosId());
	 c.insert();
	*/
	 
 	 System.out.println("Test finished [OK]");
	}

}
