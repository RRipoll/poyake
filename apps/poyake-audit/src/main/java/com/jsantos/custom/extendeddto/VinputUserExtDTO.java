package com.jsantos.custom.extendeddto;

import com.jsantos.common.util.MapValues;
import com.jsantos.metadata.MTAuditData;
import com.jsantos.metadata.audit.UserGroupDTO;
import com.jsantos.metadata.audit.VinputUserDTO;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTHelper;

public class VinputUserExtDTO extends VinputUserDTO{
	
	@Override
	public void update() {
		System.out.println("updating a inputUser with the3 extended version");
		
		IDetachedRecord inputuserdto=MTHelper.getTableFromView(this);
		inputuserdto.update();
		
		IDetachedRecord usergroup;
		try {
			 usergroup= new DetachedRecord(MTAuditData.USERGROUP,new MapValues<Object>()
					.add(MTAuditData.USERGROUP.USERID.getName(), inputuserdto.getPk()));
		} catch (Exception e) {
			usergroup=new UserGroupDTO();// TODO: handle exception
			usergroup.set(MTAuditData.USERGROUP.USERID, inputuserdto.getPk());
		}
		usergroup.set(MTAuditData.USERGROUP.INPUTUSERGROUPID, get(MTAuditData.VINPUTUSER.INPUTUSERGROUPID));
		usergroup.insertOrUpdate();
	}
	
	@Override
	public VinputUserDTO insert() {
		System.out.println("INserting or updating a inputUser with the3 extended version");
		
		IDetachedRecord inputuserdto=MTHelper.getTableFromView(this);
		
		inputuserdto.insert();
		
		UserGroupDTO usergroup=new UserGroupDTO();// TODO: handle exception
		usergroup.set(MTAuditData.USERGROUP.USERID, inputuserdto.getPk());
		usergroup.set(MTAuditData.USERGROUP.INPUTUSERGROUPID, get(MTAuditData.VINPUTUSER.INPUTUSERGROUPID));
		usergroup.insert();
		
		return this;
	}
	
}
