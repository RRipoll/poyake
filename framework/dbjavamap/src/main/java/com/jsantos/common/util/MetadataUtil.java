package com.jsantos.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;

import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class MetadataUtil {

	public static File getMDD(MTTable table,String fileName) throws IOException, SQLException{
		
		MTTable mtTable=table;
		if(table.isView())mtTable=table.getPrimaryKey().getTable();
		
		Files.deleteIfExists(new File(fileName).toPath());
		
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		
		 DetachedQueryResult dgQuery = new DetachedQueryResult(mtTable);
	
		 ListValues<IDetachedRecord> page = dgQuery.getPage(null).getRawData();
		 int i=1;	
		 for (IDetachedRecord row : page) {
			 createItem( out, row, i++);
			}
			out.close(); 
			
		return new File(fileName);
	}
	
	public static void createItem(BufferedWriter out,IDetachedRecord row,Integer i) throws IOException {
		String retValue="";
		String line=line(row.getCopyValuesToDB(),",","'",";",i);
		line=line.replace("\\\"", "\\\\\"");
	    out.write(line);
		out.newLine();
	}
	
	
	public static String line(MTMapValues<Object> values, String separator, String quotechar, String lineEnd,int pk) {
		String retValue="";
		
		for (Entry<MTField, Object> value : values.entrySet()) {
			Object sValue= value.getValue();
			if(!retValue.isEmpty())
				retValue+=separator;
			if(!value.getKey().isPrimaryKey() && value.getKey().isNoGuiInput())
				retValue+="DEFAULT";
			else {
				if(null==value || null==value.getValue()) {
					sValue="NULL";
					retValue+=sValue;
				}
				else {
					retValue+=quotechar;
					sValue=value.getValue().toString();
					retValue+=sValue;
					retValue+=quotechar;
				}
			}
		}
		retValue+=lineEnd;
		return retValue;
	}
	/*
	public static <T> T parseObjectFromString(String s, Class<T> clazz) throws Exception {
	    return clazz.getConstructor(new Class[] {String.class }).newInstance(s);
	}
	*/
}
