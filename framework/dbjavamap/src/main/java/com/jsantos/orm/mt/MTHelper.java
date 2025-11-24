package com.jsantos.orm.mt;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.common.util.PostingDate;
import com.jsantos.factory.DTOFactory;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;


public class MTHelper {

	public static List<MTField> getDescriptionFields(MTTable table){
		List<MTField> retValue= new ArrayList<MTField>();
		for (MTField field:table.getFields()) {
			if (field.getStereoTypes().contains("DESCRIPTION")) {
				//if(null==field.getForeignKey() || field.getForeignKey().isPkTable())
				    retValue.add(field);
				//else {
				//	MTTable realTable=field.getForeignKey().getRealFKTOTable();
				//	retValue.addAll(getDescriptionFields(realTable));
				//}
			}
		}
		return retValue;
	}
	
	public static List<MTTable> getTables(List<MTField> fields){
		List<MTTable> tables= new ArrayList<MTTable>();
		for (MTField mtField : fields) {
			tables.add(mtField.getTable());
		}
		return tables;
	}
	
	public static List<MapValues<Object>> getValues(List<MTMapValues<Object>> values) {
		List<MapValues<Object>> retValues= new ArrayList<MapValues<Object>>();
		values.forEach((key)-> retValues.add(getValues(key)));
		return retValues;
	}
	
	public static List<MapValues<Object>> getValuesDR(List<IDetachedRecord> values) {
		List<MapValues<Object>> retValues= new ArrayList<MapValues<Object>>();
		values.forEach((key)-> retValues.add(getValues(key.getCopyValues())));
		return retValues;
	}
	
	public static MapValues<Object> getValues(MTMapValues<Object> values) {
		
		MapValues<Object> retValue= new MapValues<Object>();
		
		for (Entry<MTField, Object> item : values.entrySet()) {
			retValue.put(item.getKey().getName(), item.getValue());
		}
		return retValue;
	}
	
    public static boolean containField(ArrayList<MTField> list,MTField  mTField) {
    	for (MTField element : list) {
			if(element.getFullyQualifiedName().equals(((MTField)mTField).getFullyQualifiedName()))
				return true;
		}
    	return false;
    }
	
	public static List<MTMapValues<Object>> getValues(List<MapValues<Object>> values, String tableName) {
		List<MTMapValues<Object>> retValues= new ArrayList<MTMapValues<Object>>();
		values.forEach((key)-> retValues.add(getValues(key,tableName)));
		return retValues;
	}
	
	public static MTMapValues<Object> getValues(MapValues<Object> values, String tableName) {
		
		MTMapValues<Object> retValue= new MTMapValues<Object>();
		MTTable mTTable = MTBase.getTable(tableName);
		
		for (Entry<String, Object> item : values.entrySet()) {
			if(null!=mTTable.getField(item.getKey())) {
				
				retValue.put(mTTable.getField(item.getKey()), DBValueMapper.loadValue(item.getValue(),mTTable.getField(item.getKey())));
			}
		}
		return retValue;
	}
	
	public static Date getDefaultDate(MTField field) {
		if(null==field.getDefaultValue())return null;
		String defaultValue=field.getDefaultValue();
		if(defaultValue.equals("getPostingDate()"))
		  return PostingDate.get();
		if(defaultValue.equals("'01-Jan-2099'"))
			return new Date(2099,1,1);
		return null;
	}
	
	public static IDetachedRecord getTableFromView(IDetachedRecord view) {
		if(!view.getTable().isView()) return view;
		if(null==view.getTable().getPrimaryKey())
		return view;
		
		if(!view.getTable().getPrimaryKey().getRealField().getTable().equals(view.getTable()))
			return getTableFromView(view, view.getTable().getPrimaryKey().getRealField().getTable());
	
		return view;
	}
	
	public static IDetachedRecord getNewCopy(IDetachedRecord view) {
		IDetachedRecord copy=getCopy(view);
		copy.getUpdates().putAll(view.getOriginalValues());
		copy.getOriginalValues().set(copy.getTable().getPrimaryKey(),null);
		copy.getUpdates().remove(copy.getTable().getPrimaryKey());
		return copy;
	}
	
	public static IDetachedRecord getCopy(IDetachedRecord view) {
			
		IDetachedRecord copy= DTOFactory.get(view.getTable());
		copy.getOriginalValues().putAll(view.getOriginalValues());
		copy.getUpdates().putAll(view.getUpdates());
		return copy;
	}
	
	/*
	public static IDetachedRecord getTableFromView(IDetachedRecord view,MTTable table) {

		IDetachedRecord dto=DTOFactory.get(table);
		for (MTField viewfield : view.getFields()) {
			Object originalValue=view.getOriginalValues().get(viewfield);
		    Object value= view.get(viewfield);
		    MTField field=viewfield.getSameAs();
		   if(null!=field) {
			   MTField fielddto=dto.getTable().getField(field.getName());
			   if(null!=fielddto) {
				   dto.getOriginalValues().set(field, originalValue);
				   dto.getUpdates().set(field, value);
			   }
			 }
		}
		return dto;	
	}
*/
	public static IDetachedRecord getTableFromView(IDetachedRecord view,MTTable table) {

		IDetachedRecord dto=DTOFactory.get(table);
		for (MTField viewfield : view.getFields()) {
			Object originalValue=view.getOriginalValues().get(viewfield);
		    Object updatevalue= view.getUpdates().get(viewfield);
		    MTField field=viewfield.getSameAs();
		   if(null!=field) {
			   MTField fielddto=dto.getTable().getField(field.getName());
			   if(null!=fielddto) {
				   if(null!=originalValue)
					   dto.getOriginalValues().set(field, originalValue);
				   if(null!=updatevalue)
				   dto.getUpdates().set(field, updatevalue);
			   }
			 }
		}
		return dto;	
	}
	
	
	
	public static IDetachedRecord copyDetachedRecord(IDetachedRecord view,MTTable table) {
		IDetachedRecord dto=DTOFactory.get(table);
		for (MTField viewfield : view.getFields()) {
			Object originalValue=view.getOriginalValues().get(viewfield);
		    Object value= view.get(viewfield);
		   for (MTField element : table.getFields()) {
			   if(element.getName().equals(viewfield.getName())) {
				   dto.getOriginalValues().set(element, originalValue);
				   dto.getUpdates().set(element, value);
			   }
		   }
		}
		return dto;	
	}
	
	
     public static  ListValues<IDetachedRecord> convertMapToDetachRecord(List<Object> values,MTTable table){
		
    	 ListValues<IDetachedRecord> retValue=new ListValues<IDetachedRecord>();
			for (Object sf : values) {
				if(sf instanceof DetachedRecord) retValue.add((DetachedRecord) sf);
				else{
					MTMapValues<Object> mtm=MTHelper.getValues(new MapValues<Object>().add((LinkedHashMap)sf),table.getTableName());
					retValue.add( DTOFactory.get(table).setValues(mtm));
					}
				}
    	 return retValue;
     }
}
