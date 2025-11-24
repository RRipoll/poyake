package com.etantolling.testrunner.test.utils.db;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SQLLoader {
	
	private static final Logger log = LoggerFactory.getLogger(SQLLoader.class);
	
	public static String loadSql(String resourcePath, Class classLoadedByClassLoader) throws SQLException{
		try{
			//ClassLoader comp=classLoadedByClassLoader.getClassLoader();
			final InputStream stream = classLoadedByClassLoader.getClassLoader().getResourceAsStream(resourcePath);
			if (null == stream)
				throw new SQLException("sql: " + resourcePath + " not found");
			return IOUtils.toString(stream, "UTF-8");
		}
		catch (IOException e){
			throw new SQLException(e);
		}
	}
	
	public static String loadFile(String resourcePath, Class classLoadedByClassLoader) throws IOException {
		try{
			final InputStream stream = classLoadedByClassLoader.getClassLoader().getResourceAsStream(resourcePath);
			return IOUtils.toString(stream, "UTF-8");
		}
		catch (Exception e){
			System.out.println("Exception: " + e + " trying to recover file: " + resourcePath + " from resources ");
			throw e;
		}
	}
/*	
	public static File loadFile(String resourcePath) throws IOException {
			
			Resource resource=ResourceFactory.newClassPathResource(resourcePath);
			File targetFile = new File(new File(resourcePath).getName());
			 copyInputStreamToFile(resource.getInputStream(),targetFile);
			return targetFile;
	}
*/
	private static void copyInputStreamToFile( InputStream in, File file ) {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	    } catch (Exception e) {
	        log.error("ERROR STACKTRACE: ", e);
	    }
	}
}
