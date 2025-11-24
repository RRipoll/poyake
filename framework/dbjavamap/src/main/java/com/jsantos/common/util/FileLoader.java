package com.jsantos.common.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
//@Slf4j

public class FileLoader {
	
	
	public String loadFile(String resourcePath) throws IOException {
		try{
			ClassLoader classLoader = getClass().getClassLoader();
			 File file = new File(classLoader.getResource(resourcePath).getFile());
			 try(InputStream inputStream = new FileInputStream(file)){
				 return  inputStream.toString();
			 }
		}
		catch (Exception e){ 
			//log.info("Exception: " + e + " trying to recover file: " + resourcePath + " from resources ");
			throw e;
		}
	}
	
	public  File loadFile(String resourcePath, String path) throws IOException {
			
		try{
			ClassLoader classLoader = getClass().getClassLoader();
			 File file = new File(classLoader.getResource("fileName").getFile());
			 InputStream inputStream = new FileInputStream(file);
			 File targetFile = new File(new File(resourcePath).getName());
			 copyInputStreamToFile(inputStream,targetFile);
			 return targetFile;
			 
			
		}
		catch (Exception e){
			//log.info("Exception: " + e + " trying to recover file: " + resourcePath + " from resources ");
			throw e;
		}
		
	}

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
	    	e.printStackTrace();
	    	// log.error("ERROR STACKTRACE:",e);
	    }
	}
	
	public static void mergeFiles(ListValues<File> files, File mergedFile) {
		 
		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
 
		for (File f : files) {
			System.out.println("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
 
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	
	
}
