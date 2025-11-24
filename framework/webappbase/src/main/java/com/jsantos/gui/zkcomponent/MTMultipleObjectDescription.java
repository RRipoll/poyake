package com.jsantos.gui.zkcomponent;

import java.util.Map.Entry;

import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.factory.DTOFactory;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

/**
 * @author raul ripoll
 */
public class MTMultipleObjectDescription extends MTDivObjectDescription {

	public MTMultipleObjectDescription() {
		super();
		// setSclass("h-100");
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void acceptDetachedRecordFromObject(ListValues<IDetachedRecord> drsObject, MTField externalField) {
		ListValues<IDetachedRecord> newdrs = getValue(drsObject, externalField);
		super.acceptDetachedRecordFromObject(newdrs, externalField);
	}

	public ListValues<IDetachedRecord> getValue(ListValues<IDetachedRecord> drs, MTField externalField) {

		ListValues<IDetachedRecord> retvalues = new ListValues<IDetachedRecord>();
		MTField linkout = MultipleHelper.getLinkOut(externalField);

		MTMapValues<MTField> comomnFields = new MTMapValues<MTField>();
		if (!drs.isEmpty())
			for (MTField mtFieldObj : drs.get(0).getFields()) {
				for (MTField mtFieldRef : externalField.getMultiRefTo().getFields()) {
					MTField refAsSame = mtFieldRef.getRealField();
					MTField ObjAsSame = mtFieldObj.getRealField();
					if (refAsSame.equals(ObjAsSame))
						comomnFields.put(mtFieldRef, mtFieldObj);
				}
			}

		for (IDetachedRecord detachedR : drs) {

			DetachedRecord dt = DTOFactory.get(externalField.getMultiRefTo());
			dt.set(linkout, detachedR.get(detachedR.getTable().getField(linkout.getName())));
			retvalues.add(dt);

			for (Entry<MTField, MTField> entry : comomnFields.entrySet()) {
				dt.set(entry.getKey(), detachedR.get(entry.getValue()));

			}
		}
		return retvalues;
	}
}
