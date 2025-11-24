package com.jsantos.service;

import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MD5;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.audit.IAuditProvider;
import com.jsantos.metadata.MTAuditData;
import com.jsantos.metadata.audit.InputUserDTO;
import com.jsantos.metadata.audit.MTTableINPUTUSER;
import com.jsantos.metadata.audit.MTTableVUSERGROUP;
import com.jsantos.metadata.audit.VuserGroupDTO;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public class AuditProvider implements IAuditProvider {

	

	@Override
	public DetachedRecord getInputUser(String loginName, String pass) {
		try {
			InputUserDTO dr = (InputUserDTO) new InputUserDTO().find(
					new MapValues<Object>()
							.add(MTTableINPUTUSER.LOGINNAME.getName(), loginName)
							.add(MTTableINPUTUSER.PASSWD.getName(), 
									MD5.digest(pass.trim())));
			
			return  dr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getInputUserId(IDetachedRecord inputUser) {
		return ((InputUserDTO)inputUser).getInputUserId();
	}

	@Override
	public Integer getInputSourceCode(IDetachedRecord inputUser) {
		return ((InputUserDTO)inputUser).getInputSourceId();
	}

	

	@Override
	public Integer getInputUserGroupId(IDetachedRecord vUserGroup) {
		return ((VuserGroupDTO)vUserGroup).getInputUserGroupId();
	}
	
	
	@Override
	public ListValues<IDetachedRecord> getVUserGroup(IDetachedRecord inputUser) {
		String where = " and " + MTTableVUSERGROUP.USERID + "=" + inputUser.getPk() ;
		DetachedQueryResult result = new DetachedQueryResult(MTAuditData.VUSERGROUP, where);
		return new ListValues<VuserGroupDTO>()
				.addAllValues(result.getPage(0, DTOFactory.get(MTAuditData.VUSERGROUP).getClass()).getRawData());
	}

	@Override
	public boolean isImplemented() {
		return true;
	}

	@Override
	public String getInputUserName(IDetachedRecord inputUser) {
		
		return ((InputUserDTO)inputUser).getFullName();
	}

	@Override
	public String getInputUserLoginName(IDetachedRecord inputUser) {
		if(null==inputUser) return null;
		return ((InputUserDTO)inputUser).getLoginName();
	}

	@Override
	public Object getGroupDescription(IDetachedRecord vUserGroup) {
		return ((VuserGroupDTO)vUserGroup).getGroupDescription();
	}
}
