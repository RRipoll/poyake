package com.jsantos.custom.customfield;

import com.jsantos.metadata.MTrecorderTRData;
import com.jsantos.orm.mt.MTField;

public class RecorderFiles extends FilesContainer {

	@Override
	public MTField forField() {
		return   MTrecorderTRData.RECORDERDEFINITION.FILES;
	}
	
}
