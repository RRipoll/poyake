package com.jsantos.custom.fieldrenderer.general;

import java.util.Locale;

import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class DefaultFieldRenderer implements IMTFieldRenderer{
	
	public DefaultFieldRenderer() {
	}
	
	@Override
	public String render(Object value,MTField mtField, IDetachedRecord values,Locale locale) {
		if (value == DBValueMapper.NULL) return "";
		if (null == value) return "";
		
		if ((null != mtField.getForeignKey()  && !mtField.isEnumeration()) ) {
			if(mtField.isPrimaryKey() )
				return value.toString();
			return  new ForeignKeyFieldRenderer().render(value, mtField, values, locale);
		}
		if (mtField.isEnumeration())
			return new EnumerationRenderer(mtField.getForeignKey()).render(value, mtField, values, locale);
		
		return value.toString();
	}

     boolean tableHasDescription(MTTable table) {

    	 for (MTField field:table.getFields())
			if (field.getStereoTypes().contains("DESCRIPTION"))
				return true;
		return false;
	}
}
