package com.jsantos.custom.trigger;

import com.jsantos.gui.DesktopHelper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTrigger;

public class AuditTrigger extends MTTrigger{

	@Override
	public void beforeInsert(IDetachedRecord dr) {
		MTField inputUserId = dr.findFieldByname("inputUserId");
		if (null != inputUserId && inputUserId.getStereoTypes().contains("NOGUIINPUT"))
			if (null != DesktopHelper.getInputUserId())
				dr.set(inputUserId, DesktopHelper.getInputUserId());
		MTField inputSourceId = dr.findFieldByname("inputSourceId");
		if (null != inputSourceId && inputSourceId.getStereoTypes().contains("NOGUIINPUT"))
			if (null != DesktopHelper.getInputSourceId())
				dr.set(inputSourceId, DesktopHelper.getInputSourceId());
	}

	@Override
	public void beforeUpdate(IDetachedRecord dr) {
		beforeInsert(dr);
	}
	
}
