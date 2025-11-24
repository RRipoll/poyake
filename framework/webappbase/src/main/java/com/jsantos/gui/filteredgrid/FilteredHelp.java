package com.jsantos.gui.filteredgrid;

import java.util.ArrayList;
import java.util.List;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.DetailConfiguration;
import com.jsantos.orm.mt.MTField;

public class FilteredHelp {

	
	
	 public static List<MTField> getMTFields(EditMode type,SettingDTO settingDTO) {
		if (type.equals(EditMode.SHOW)) {
			return getMTFieldsToShown( settingDTO);
		} else if (type.equals(EditMode.UPDATE)) {
			return getMTFieldsToEdit( settingDTO);
		} else if (type.equals(EditMode.INSERT)) {
			return getMTFieldsToInsert( settingDTO);

		}
		return null;

	}

	public static List<MTField> getMTFieldsToShown(SettingDTO settingDTO) {

		List<MTField> retValues = new ArrayList<>();

		for (DetailConfiguration field : settingDTO.getDetailScreenConfigurations()) {
			if (field.isActive()&&!field.isHidden())
				retValues.add(field.getMtField());
		}

		return retValues;
	}

	public static List<MTField> getMTFieldsToEdit(SettingDTO settingDTO) {

		List<MTField> retValues = new ArrayList<>();

		for (DetailConfiguration field : settingDTO.getEditConfigurations()) {
			if (field.isActive()&&!field.isHidden())
				retValues.add(field.getMtField());
		}
		return retValues;
	}

	public static List<MTField> getMTFieldsToInsert(SettingDTO settingDTO) {

		List<MTField> retValues = new ArrayList<>();

		for (DetailConfiguration field : settingDTO.getEditConfigurations()) {
			if (field.isActive() &&!field.isHidden() && !field.getMtField().isPrimaryKey())
				retValues.add(field.getMtField());
		}
		return retValues;
	}
}
