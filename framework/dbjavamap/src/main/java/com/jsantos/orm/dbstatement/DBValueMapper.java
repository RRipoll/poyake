package com.jsantos.orm.dbstatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.jsantos.common.fieldMapper.FieldMapperComponentProvider;
import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class DBValueMapper {
	public static final Null NULL = new Null();

	public static Object loadValue(ResultSet rs, MTField field) throws SQLException {
		return loadValueByJdbcDefault(rs,field);
	}

	private static Object loadValueByJdbcDefault(ResultSet rs, MTField field) throws SQLException {
		//System.out.println(field.getName());
		//System.out.println(field.getTable().getTableName());
		if (null == rs.getObject(field.getName())){
			return NULL;
		}
		IFieldMapper fmc=FieldMapperComponentProvider.getMapper(field);
		if(null!=fmc)
			return fmc.loadValue(rs, field);
		return rs.getObject(field.getName());
	}

	public static Object unloadValue(MTField field,IDetachedRecord detachedRecord) {
		IFieldMapper fmc=FieldMapperComponentProvider.getMapper(field);
		if(null!=fmc)
			return fmc.unloadValue(field,detachedRecord);
		return detachedRecord.get(field);
	}

	public static Object loadValue(IDetachedRecord dr, MTField field){
		if (null == dr.get(field)){
			return NULL;
		}
		IFieldMapper fmc=FieldMapperComponentProvider.getMapper(field);
		if(null!=fmc)
			return fmc.loadValue(dr, field);
		return dr.get(field);
	}
	
	public static Object loadValue(Object value , MTField field) {
		IFieldMapper fmc=FieldMapperComponentProvider.getMapper(field);
		if(null!=fmc)
			return fmc.loadRawValue(value, field);
		if(value instanceof String)
			return getValueFromString(field, value.toString());
	    if(field.getDataType().getJavaType().equals("java.util.Date") && value instanceof Integer || value instanceof Long)
	    	return new Date(Long.parseLong(value.toString()));
	    return value;
	}
	
    public static class Null{
        Null() {
            super();
        }
 
    public String toString() {
        	return "";
        }
    }
    
    public static Object getValueFromString(MTField field,String value) {
			
			MTDataType dataType=field.getDataType();
			String javaType=dataType.getJavaType();
			
			try {
				if(javaType.equals("java.util.Date")) {
					if((value.equals("getPostingDate()")|| value.equals("CURRENT_TIMESTAMP")))
						return new java.util.Date();
					else 
						return DateUtils.parseDate(value.replaceAll("'", ""), 
					            new String[] {
					            		"yyyy/MM/dd'T'HH:mm:ss",
					            		"yyyy/MM/dd",
					            		"yyyy-MM-dd"
						});
				}
				Class jclass=Class.forName(javaType);
				return jclass.getConstructor(new Class[] {String.class }).newInstance(value);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(field.getFullyQualifiedName()+" Can't parser " +value + " to "+ javaType);
			}
		return DBValueMapper.NULL;
	}
     
    public static Object getDefaultValue(MTField field) {
		if(null!=field.getDefaultValue()) {
			return getValueFromString(field, field.getDefaultValue());
		}
		return DBValueMapper.NULL;
	}
 }
