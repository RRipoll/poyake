package com.jsantos.custom.extendedFieldMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.common.util.FieldValues;
import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;

public class MultipleEnumMapper implements IFieldMapper {

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.MULTIPLEENUM;
	}
	@Override
	public ListValues<IDetachedRecord> loadValue(ResultSet rs, MTField field) throws SQLException {
		String value=(String) rs.getObject(field.getName());
		if(value.isEmpty())
			return MultipleHelper.getDrs(rs,field);
		return MultipleHelper.getDrsFromJson(field.getMultiRefTo(), value);
	}
	

	@Override
	public boolean insertOrUpdate(MTField mtField, IDetachedRecord detachedRecord) {
        boolean retValue=false;
		FieldValues originalValues = detachedRecord.getOriginalValues();
		if (!(null == originalValues || null == originalValues.get(mtField)
				|| DBValueMapper.NULL == originalValues.get(mtField))) {
			for (IDetachedRecord dt : (ListValues<IDetachedRecord>) originalValues.get(mtField)) {
				MTHelper.getTableFromView(dt).delete();
			}
		}
		Object drValues=detachedRecord.get(mtField);
		if(!(drValues instanceof ListValues<?>)) {
			ListValues<Object> fields= new ListValues<Object>().addAllValues((Collection<? extends Object>) drValues);
			
		}
		
		ListValues<IDetachedRecord> values = (ListValues<IDetachedRecord>) detachedRecord.get(mtField);
		for (IDetachedRecord dt : values) {
			IDetachedRecord realTable=MTHelper.getTableFromView(dt);
			realTable.set(MultipleHelper.getLinkIn(mtField).getRealField(), detachedRecord.getPk());
			realTable.insert();
			retValue=true;
		}

		return retValue;
	}
}
