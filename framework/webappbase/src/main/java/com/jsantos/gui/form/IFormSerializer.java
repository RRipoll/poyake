package com.jsantos.gui.form;

import com.jsantos.orm.dbstatement.IDetachedRecord;

public interface IFormSerializer {
	public boolean serialize(MTForm form);

	 default boolean shouldBeInserted(IDetachedRecord dr) {return true;};
}
