package com.jsantos.custom.constraints;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.constraint.ValidationError;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.metadata.MTCommonData;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class DataGridJsonConstraint  implements IConstraintsBuilder {

	@Override
	public <T> ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		ListValues<IValidationError> errors= new ListValues<IValidationError>();
		if(null==value) {
			IMTComponent searchName= (IMTComponent) values.get(MTBase.getMTField("DATAGRIDSETTING.SEARCHNAME"));
			MTTable table= MTCommonData.getTable((String) searchName.getValue());
			value=DataSettingFactory.createDefaultSettingDTO(table, LocaleFactory.getProvider().getLocale());
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			try {
				String data = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value));
			    ((IMTComponent)values.get(mtField)).setValue(data);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			ValidationError ve= new ValidationError();
			ve.setMessageCode(ErrorsConstants.DATAGRID_WAS_NULL);
			ve.getParameters().add(mtField.getLabel());
			errors.add(ve);
		}
		return errors;
	}

	@Override
	public MTField forField() {
		return null;
		//return MTBase.getMTField("DATAGRIDSETTING.DATA");
	}
	
	

}
