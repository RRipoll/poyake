package com.jsantos.commondata.util;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.jsantos.common.util.ListValues;
import com.jsantos.custom.fieldrenderer.general.ForeignKeyFieldRenderer;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;

public class DefaultRecordDescription {

	public static String getDescription(IDetachedRecord dr,Locale locale){
		String description="";
		
		List<MTField> fields= MTHelper.getDescriptionFields(dr.getTable());
		ListValues<String> descriptionValues= new ListValues<String>();
		for (MTField field : fields) {
			if(null!=dr.get(field)) {
				if(null!=field.getForeignKey() && !field.getForeignKey().isPkTable()) {
					descriptionValues.add(new ForeignKeyFieldRenderer().render(dr.get(field), field, dr, locale));
				}
				else
					descriptionValues.add(dr.get(field).toString());
			}
		}
		description+=  StringUtils.join(descriptionValues," - ");
		if(description.isEmpty()) {
			Object value=dr.get(dr.getTable().getMainFk());
			if(null!=value)
			description=value.toString();
		}
		return description;    
	}
	
	
}
