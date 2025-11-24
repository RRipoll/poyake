package com.jsantos.gui.objectselector.popup;

import com.jsantos.common.util.ListValues;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public interface IDetachedRecordAcceptor {
	public void acceptDetachedRecord(ListValues<IDetachedRecord> drs, MTField externalField); 
	public default void acceptDetachedRecordFromObject(ListValues<IDetachedRecord> drs, MTField externalField) {
			acceptDetachedRecord(drs,externalField);		
	};
	public ListValues<IDetachedRecord> getDrs();
}
