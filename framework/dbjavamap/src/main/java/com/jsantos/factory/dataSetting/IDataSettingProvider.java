package com.jsantos.factory.dataSetting;

import java.util.List;
import java.util.Locale;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.factory.appinfo.IProvider;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiException;

public interface IDataSettingProvider  extends IProvider{

	List<String> findAllSearchName();

	SettingDTO getSetting(String searchName, Integer inputUserGroupId, Locale locale) throws ApiException;

	IDetachedRecord getDGSettingEx(String searchName, Integer inputUserGroupId, Locale locale)
			throws ApiException;

	IDetachedRecord setSetting(SettingDTO settingDTO, IDetachedRecord dto, Integer inputUserGroupId);

	IDetachedRecord insertSetting(SettingDTO settingDTO, IDetachedRecord dto, Integer inputUserGroupId)
			throws ApiException;

	SettingDTO getSetting(IDetachedRecord dto, Integer inputUserGroupId);

	public boolean isImplemented();
}