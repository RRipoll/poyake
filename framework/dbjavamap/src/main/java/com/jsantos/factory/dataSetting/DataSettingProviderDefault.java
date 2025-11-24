package com.jsantos.factory.dataSetting;

import java.util.List;
import java.util.Locale;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTBase;

public class DataSettingProviderDefault implements IDataSettingProvider {

	@Override
	public List<String> findAllSearchName() {
		return null;
	}

	@Override
	public SettingDTO getSetting(String searchName, Integer inputUserGroupId, Locale locale) throws ApiException {
		return DataSettingFactory.createDefaultSettingDTO(MTBase.getTable(searchName), locale);
	}

	@Override
	public DetachedRecord getDGSettingEx(String searchName, Integer inputUserGroupId, Locale locale) throws ApiException {
		return null;
	}

	
	@Override
	public SettingDTO getSetting(IDetachedRecord dto, Integer inputUserGroupId) {
		return null;
	}

	@Override
	public DetachedRecord setSetting(SettingDTO settingDTO, IDetachedRecord dto, Integer inputUserGroupId) {
		return null;
	}

	@Override
	public DetachedRecord insertSetting(SettingDTO settingDTO, IDetachedRecord dto, Integer inputUserGroupId)
			throws ApiException {
		return null;
	}

	@Override
	public boolean isImplemented() {
		return false;
	}

}
