package com.jsantos.custom.extendedFieldMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;

public class MultipleObjectMapper implements IFieldMapper {

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.MULTIPLEOBJECT;
	}

	@Override
	public ListValues<IDetachedRecord> loadValue(ResultSet rs, MTField field) throws SQLException {
		String value = (String) rs.getObject(field.getName());
		if (null!= value && (value.isEmpty() || value.equals("AUTO") ))
			return MultipleHelper.getDrs(rs, field);
		return MultipleHelper.getDrsFromJson(field.getMultiRefTo(), value);
	}

	@Override
	public boolean insertOrUpdate(MTField mtField, IDetachedRecord detachedRecord) {
		boolean retValue = false;

		ListValues<IDetachedRecord> originals = null;
		if (DBValueMapper.NULL != detachedRecord.getOriginalValues().get(mtField)) {
			originals = MTHelper.convertMapToDetachRecord(
					(List<Object>) detachedRecord.getOriginalValues().get(mtField),mtField.getMultiRefTo());
		}
		ListValues<IDetachedRecord> values = null;
		if (DBValueMapper.NULL != detachedRecord.get(mtField)) {
			values = MTHelper.convertMapToDetachRecord(
					(List<Object>) detachedRecord.get(mtField), mtField.getMultiRefTo());
		}
		if (null != originals && DBValueMapper.NULL != detachedRecord.getOriginalValues()
				.get(detachedRecord.getTable().getPrimaryKey())) {

			for (IDetachedRecord originalItem : originals) {
				boolean found = false;
				for (IDetachedRecord valueItem : values) {
					if (null != valueItem.getPk()) {
						if (originalItem.getPk().toString().equals(valueItem.getPk().toString())) {
							found = true;
							break;
						}
					}
				}
				if (!found) 
					MTHelper.getTableFromView(originalItem).delete();
			}
		}

		if (null != values) {
			for (IDetachedRecord valueItem : values) {
				boolean found = true;
				if (null == valueItem.getPk())
					found = false;
				else {
					found = false;
					if (null != originals)
						for (IDetachedRecord originalItem : originals) {
							if (originalItem.getPk().toString().equals(valueItem.getPk().toString()))
								found = true;
							break;
						}
				}
				if (!found) {
					IDetachedRecord realTable = MTHelper.getTableFromView(valueItem);
					realTable.set(MultipleHelper.getLinkIn(mtField).getRealField(),
							detachedRecord.get(detachedRecord.getTable().getMainFk()));
					realTable.setValues(realTable.getCopyValues());
					realTable.insertOrUpdate();
					retValue = true;
				}
			}
		}
		return retValue;
	}
}
