package com.jsantos.gui;


import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.audit.AuditFactory;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.zKpermission.Permission;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.search.AttributeConstants;

/**
 * @author javier santos
 */

public class DesktopHelper {

	static Integer inputUserGroupSA=2;
	
	public static Component getRootComponent() {
		
		return (Component) Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.ROOT_COMPONENT);
	}
	
	public static Component getContentArea() {
		return (Component) Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.CONTENT_AREA);
	}
	
	public static void setContentArea(Component comp) {
		Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.CONTENT_AREA, comp);
	}

	public static void setRootComponent(Component comp) {
		Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.ROOT_COMPONENT, comp);
	}
	
	public  static String getDefaultTokken() {
		return (String) Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.DEFAULT_TOKEN);
	}

	public  static void setDefaultTokken(String tokken) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.DEFAULT_TOKEN, tokken);
	}
	
	public static boolean isUserLogged() {
		if (null == Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.USER_ID))
			return false;
		return true;
	}

	public static IDetachedRecord getInputUser() {
		try {
			if (null == Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.INPUTUSER))
				return null;
			return (IDetachedRecord) Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.INPUTUSER);
		} catch (Exception e) {
			return null;
		}
		
	}

	public static void setInputUser(DetachedRecord inputUser) {
		Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.INPUTUSER, inputUser);

	}

	public static Object getAttribute(String name) {
		return Executions.getCurrent().getDesktop().getAttribute(name);
	}

	public static void setAttribute(String name, Object value) {
		Executions.getCurrent().getDesktop().setAttribute(name, value);
	}

	public static Integer getClientHeightByN(Double n) {
		Integer retValue = null;
		if (null != n && null != DesktopHelper.getAttribute(AttributeConstants.CLIENTHEIGHT)) {
			float height = (Integer) DesktopHelper.getAttribute(AttributeConstants.CLIENTHEIGHT);
			retValue = (int) (height * n);
		}
		return retValue;
	}
	
	public static MapValues<IDetachedRecord> getSettings() {
		MapValues<IDetachedRecord> dataGridSetting= (MapValues<IDetachedRecord>) Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.DGSETTING);
		if(null==dataGridSetting) {
			dataGridSetting=new MapValues<IDetachedRecord>();
			Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.DGSETTING,dataGridSetting);
		}
		return dataGridSetting;
	}
	
	public static IDetachedRecord getSettingEx(String searchName) {
		IDetachedRecord dataGridSetting=getSettings().get(searchName);
		   return dataGridSetting;
	}
	
	public static void putSetting(String searchName,IDetachedRecord datagridEXSettingDTO) {
		getSettings().put(searchName, datagridEXSettingDTO);
		
	}
	
	public static void putSetting(String searchName,SettingDTO setting, Integer inputUserGroupId) {
		IDetachedRecord dto=DataSettingFactory.getProvider().getDGSettingEx(searchName, inputUserGroupId, LocaleFactory.getProvider().getLocale());
		
		getSettings().put(searchName, dto);
		
	}
	
	public static SettingDTO getSetting(String searchName, Integer inputUserGroupId,Locale locale) {
		IDetachedRecord dataGridSetting=getSettingEx(searchName);
		if(null==dataGridSetting) {
			dataGridSetting=DataSettingFactory.getProvider().getDGSettingEx(searchName,  inputUserGroupId, locale);
		    if(null==dataGridSetting)
		    	return DataSettingFactory.createDefaultSettingDTO(MTBase.getTable(searchName), locale);
			putSetting(searchName,dataGridSetting);
		}
		return DataSettingFactory.getProvider().getSetting(dataGridSetting, inputUserGroupId);
	}

	public static IDetachedRecord getDGSettingEx(String searchName, Integer inputUserGroupId,Locale locale) {
		IDetachedRecord settingEx=getSettingEx(searchName);
		if(null==settingEx) {
			settingEx=DataSettingFactory.getProvider().getDGSettingEx(searchName,  inputUserGroupId, locale);
		    putSetting(searchName,settingEx);
		}
		return settingEx;
	}
	
	
	public static IDetachedRecord getVUserGroup() {
		return  (IDetachedRecord) ( Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.USER_GROUP));
	}

	public static void setVUserGroup(IDetachedRecord dtr) {
		if (null == Executions.getCurrent() || null == Executions.getCurrent().getDesktop() )
			return;
		Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.USER_GROUP, dtr);
	}
	
	public static boolean isConfEditable() {
		return DataSettingFactory.getProvider().isImplemented() && Permission.getPermissionByShortCode("CONF_EDITABLE")>0;
	}
	
	public static Integer getInputUserGroupId() {
		if(null== getVUserGroup())return null;
		return AuditFactory.getProvider().getInputUserGroupId( getVUserGroup());
	}

	public static void setPermission(MapValues<Integer> permissionFromSession) {
		Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.PERMISSIONS, permissionFromSession);
		
	}

	public static MapValues<Integer> getPermissions() {
		//if(!PermissionFactory.getProvider().isImplemented())return null;
		return   (MapValues<Integer>) Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.PERMISSIONS);
	}

	public static boolean isPermissionEditable() {
		if(!PermissionFactory.getProvider().isImplemented())return false;
		return AuditFactory.getProvider().getInputUserGroupId( getVUserGroup()) == inputUserGroupSA;
		
	}

	public static boolean isLabelEditable() {
		if(!LabelFactory.getProvider().isImplemented())return false;
		return AuditFactory.getProvider().getInputUserGroupId( getVUserGroup()) == inputUserGroupSA;
	}

	public static Integer getInputUserId() {
		if(null==getInputUser()) return null;
		return AuditFactory.getProvider().getInputUserId(getInputUser());
	}

	public static Integer getInputSourceId() {
		if(null==getInputUser()) return null;
		return AuditFactory.getProvider().getInputSourceCode(getInputUser());
	}

	public static String getLoginName() {
		return AuditFactory.getProvider().getInputUserLoginName(getInputUser());
	}

	public static Component getMainHeader() {
		return (Component) Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.MAIN_HEADER);
	}
	
	public static void setMainHeader(Component comp) {
		Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.MAIN_HEADER, comp);
	}
	
	public  static Integer getRecorderUuid() {
		return (Integer) Executions.getCurrent().getDesktop().getAttribute(AttributeConstants.RECORDER_UUID);
	}

	public static void setRecorderUuid(Integer uuid) {
		Executions.getCurrent().getDesktop().setAttribute(AttributeConstants.RECORDER_UUID, uuid);
	}
	
	public static void deleteRecorderUuid() {
		Executions.getCurrent().getDesktop().removeAttribute(AttributeConstants.RECORDER_UUID);
	}
}

