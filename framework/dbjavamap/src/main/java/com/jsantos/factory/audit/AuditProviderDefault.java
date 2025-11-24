package com.jsantos.factory.audit;

import com.jsantos.common.util.ListValues;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public class AuditProviderDefault implements IAuditProvider {

	
	
	@Override
	public DetachedRecord getInputUser(String loginName, String pass) {
		return null;
	}

	@Override
	public Integer getInputUserId(IDetachedRecord inputUser) {
		
		return 0;
	}

	@Override
	public Integer getInputSourceCode(IDetachedRecord inputUser) {
		return 0;
	}

	
	@Override
	public Integer getInputUserGroupId(IDetachedRecord vUserGroup) {
		return 2;
	}

	@Override
	public ListValues<IDetachedRecord> getVUserGroup(IDetachedRecord inputUser) {
		return new ListValues<IDetachedRecord>();
	}

	@Override
	public boolean isImplemented() {
		return false;
	}

	@Override
	public String getInputUserName(IDetachedRecord inputUser) {
		return null;
	}

	@Override
	public String getInputUserLoginName(IDetachedRecord inputUser) {
		
		return null;
	}

	@Override
	public Object getGroupDescription(IDetachedRecord dtRecord) {
		return null;
	}

	

	

}
