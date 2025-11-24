package com.jsantos.auditimmo.screen.login;

import com.jsantos.gui.DesktopHelper;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.audit.MTTableINPUTUSER;
import com.jsantos.orm.dbstatement.DetachedRecord;

public class LoginScreen {
	
	public boolean checkLogin(String loginName, String pass) {
		try {
			String where = "loginName='" + loginName + "' and passwd='" + pass + "'";
			DetachedRecord dr = new DetachedRecord(MT.INPUTUSER, where);
			DesktopHelper.setInputUserId(dr.getInt(MTTableINPUTUSER.INPUTUSERID));
			DesktopHelper.setInputUser(dr);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
