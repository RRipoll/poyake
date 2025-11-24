package com.jsantos.custom.trigger;

import com.jsantos.common.fieldMapper.FieldMapperComponentProvider;
import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTrigger;

public class MultipleJsonTrigger  extends MTTrigger {

	@Override
	public void afterInsert(IDetachedRecord dr) {
		for (MTField field : dr.getFields()) {
			if(field.getDataType().equals(MTDataTypes.MULTIPLEENUM)
					||
			   field.getDataType().equals(MTDataTypes.MULTIPLEOBJECT)
					) {
				IFieldMapper fmc=FieldMapperComponentProvider.getMapper(field);
				if(null!=fmc)
					fmc.insertOrUpdate(field, dr);
			}
		}
	}

	@Override
	public void afterUpdate(IDetachedRecord dr) {
		afterInsert( dr);
	}
}
