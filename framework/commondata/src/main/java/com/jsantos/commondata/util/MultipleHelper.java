package com.jsantos.commondata.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.registry.FieldRendererProvider;
import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.fieldrenderer.general.DefaultFieldRenderer;
import com.jsantos.custom.fieldrenderer.general.ForeignKeyFieldRenderer;
import com.jsantos.factory.DTOFactory;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.orm.mt.MTTable;
//@Slf4j
public class MultipleHelper {

	public static ListValues<IDetachedRecord> getDrsFromJson(MTTable RefTotable, Object value) {
		//MTTable RefTotable = field.getMultiRefTo();
		ListValues<LinkedHashMap<String, Object>> valueParsed;
		ObjectMapper mapper = new ObjectMapper();
		if(value instanceof String) {
			try {
				valueParsed = mapper.readValue(value.toString(),
					(new ListValues<LinkedHashMap<String, Object>>()).getClass());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new ApiException(ApiError.PARSING_ERROR, "Wrong Data in Db");
			}
		}else valueParsed=new ListValues<LinkedHashMap<String, Object>>().addAllValues((Collection<? extends LinkedHashMap<String, Object>>) value);
		ListValues<IDetachedRecord> drs = new ListValues<IDetachedRecord>();
		for (LinkedHashMap<String, Object> pdRecord : valueParsed) {
			IDetachedRecord ref=DTOFactory.get(RefTotable);
			ref.getOriginalValues().putAll(MTHelper.getValues(new MapValues<Object>().add(pdRecord), RefTotable.getTableName()));
			drs.add(ref);
		}
		return drs;
	}
	
	public static String getJsonFromDrs(MTField field, ListValues<IDetachedRecord> value) {
		
		if(null==value)return null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		String data = null;
		ListValues<MapValues<Object>> lv= new ListValues<MapValues<Object>>();
		for (IDetachedRecord mapValues : value) {
			lv.add(MTHelper.getValues(mapValues.getCopyValues()));
		}
		try {
			 data = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lv));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if(null!=data && data.equals("{}"))data=null;
        return data;
	}
	
	static List<String> getDescriptionList(ListValues<IDetachedRecord> drs, MTField field, Locale locale) {
		if (null == drs)
			return null;
		List<String> listRetValue = new ArrayList<String>();
		for (IDetachedRecord dRecord : drs) {
			List<String> description = new ArrayList<String>();
			description.add(getDescription( dRecord,  field,  locale));
			listRetValue.add(StringUtils.join(description, " , "));
		}
		return listRetValue;
	}

	
	public static String getDescription(IDetachedRecord dRecord, MTField mtField, Locale locale) {
		String description = "";
		MTTable table=dRecord.getTable();
		IMTFieldRenderer frp=FieldRendererProvider.getRenderer(table.getMainFk());
		if(null==frp)frp=new DefaultFieldRenderer();
		if(!(frp instanceof DefaultFieldRenderer))return frp.render(dRecord.get(table.getMainFk()), table.getMainFk(), dRecord, locale);
		
		List<MTField> fields= MTHelper.getDescriptionFields(dRecord.getTable());
		ListValues<String> descriptionValues= new ListValues<String>();
		
		if(description.isEmpty() && dRecord.getTable().isLinktable()) {
			MTField fieldOut=MultipleHelper.getLinkOut(mtField);
			IMTFieldRenderer rendered=FieldRendererProvider.getRenderer(fieldOut.getForeignKey().getMainFk());
			if(null!=rendered && !(rendered instanceof DefaultFieldRenderer))return rendered.render(dRecord.get(fieldOut), fieldOut.getForeignKey().getMainFk(), dRecord, locale);
			
			Object value=dRecord.get(fieldOut);
			description=new ForeignKeyFieldRenderer().render(value,fieldOut, dRecord, locale);
			
		}else {
			for (MTField field : fields) {
				if(null!=dRecord.get(field)) {
					if(null!=field.getForeignKey())
						descriptionValues.add(new ForeignKeyFieldRenderer().render(dRecord.get(field),field, dRecord, locale));
					else descriptionValues.add(dRecord.get(field).toString());
					}
				}
			description+=  StringUtils.join(descriptionValues," - ");
			}		
		
		if(description.isEmpty()) {
			description=dRecord.getString(dRecord.getTable().getMainFk());
		}
		
		return description;
	}
	
	public static String getDescription(ListValues<IDetachedRecord> drs, MTField field, Locale locale, Integer n) {
		if (null == drs)
			return null;
		List<String> list = getDescriptionList(drs, field, locale);
		String retValue = StringUtils.join(list.subList(0, list.size() < n ? list.size() : n), " , ");
		if (list.size() > n)
			retValue += " ....";
		return retValue;
	}

	public static String getDescription(ListValues<IDetachedRecord> drs, MTField field, Locale locale) {
		return StringUtils.join(getDescriptionList(drs, field, locale), " , ");
	}

	public static MTTable getLinkTable(MTField mtField) {

		return getLinkOut(mtField).getRealField().getForeignKey();
	}

	public static MTField getLinkIn(MTField mtField) {
		MTField retValue=null;
		MTField pko=getOrigen(mtField.getTable().getMainFk());
		MTTable multiRefertTo=mtField.getMultiRefTo();
		
		for (MTField fieldo : multiRefertTo.getFields()) {
			if(fieldo.getStereoTypes().contains("LINK")) {
				MTField rfo=getOrigen(fieldo);
				if(pko.equals(rfo)) {
					retValue=fieldo;
					break;
				}
			}
		}	
		return retValue;
	}

	public static MTField getOrigen(MTField mtfield) {
		MTField retValue=mtfield.getRealField();
		if(null!=retValue.getForeignKey())
			retValue=retValue.getForeignKey().getMainFk();
		if(retValue.equals(mtfield))return mtfield;
		return getOrigen(retValue);
	}
	
	public static MTField getLinkOut(MTField mtField) {
		
		MTField retValue=null;
		MTField pko=getOrigen(mtField.getTable().getMainFk());
		MTTable multiRefertTo=mtField.getMultiRefTo();
		
		for (MTField fieldo : multiRefertTo.getFields()) {
			if(fieldo.getStereoTypes().contains("LINK") || getOrigen(fieldo).getStereoTypes().contains("LINK")) {
				MTField rfo=getOrigen(fieldo);
				if(!pko.equals(rfo)) {
					retValue=fieldo;
					break;
				}
					
			}
		}	
		return retValue;
	}

	public static ListValues<IDetachedRecord> getLinkDetachedRecord(ListValues<IDetachedRecord> drs, MTField mtField) {
		ListValues<IDetachedRecord> retValues = new ListValues<IDetachedRecord>();
		MTTable linktable = getLinkTable(mtField);
        if(linktable.isPkTable())
        	linktable=linktable.getRealFKTOTable();
		for (IDetachedRecord detachedRecord : drs) {
			retValues.add(DTOFactory.get(linktable, detachedRecord.getInt(getLinkOut(mtField))));
		}
		return retValues;
	}

	public static ListValues<IDetachedRecord> getDrs(ResultSet rs, MTField field) throws SQLException {
		MTTable table= field.getMultiRefTo();
		MapValues<Object> parameters= new MapValues<Object>();
		MTField primaryKey=field.getTable().getPrimaryKey();
		parameters.add(getLinkIn(field).getName(), rs.getObject(primaryKey.getName()));
		DetachedQueryResult dqr= new DetachedQueryResult(table, parameters);
		return (ListValues<IDetachedRecord>) dqr.getPage(null).getRawData();
	}
}
