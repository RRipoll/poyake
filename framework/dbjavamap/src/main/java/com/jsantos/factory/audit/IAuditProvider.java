package com.jsantos.factory.audit;

import com.jsantos.common.util.ListValues;
import com.jsantos.factory.appinfo.IProvider;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public interface IAuditProvider  extends IProvider{

	public Integer getInputUserId(IDetachedRecord inputUser);
	public Integer getInputSourceCode(IDetachedRecord inputUser);
	public DetachedRecord getInputUser(String loginName, String pass);
	public String getInputUserName(IDetachedRecord inputUser);
	//public DetachedRecord getInputUserGroupId(Integer inputUserId);
	public Integer getInputUserGroupId(IDetachedRecord vUserGroup);
	ListValues<IDetachedRecord> getVUserGroup(IDetachedRecord inputUser);
	public boolean isImplemented();
	public String getInputUserLoginName(IDetachedRecord inputUser);
	public Object getGroupDescription(IDetachedRecord dtRecord);
}
