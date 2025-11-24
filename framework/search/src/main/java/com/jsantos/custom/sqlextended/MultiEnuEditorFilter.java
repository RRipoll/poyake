package com.jsantos.custom.sqlextended;

import com.jsantos.common.model.SearchParameter.Operator;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.core.services.SqlFacade;
import com.jsantos.search.sqlextended.SqlExtended;

public  class MultiEnuEditorFilter extends SqlExtended implements ISqlExtended{

	@Override
	public String generateWhereClause(FilterConfiguration element,MapValues<Object> parameters) {
		element.setOperator(Operator.IN);
		
		ListValues<Object> values=new ListValues<Object>();
		
		MTField mtField= element.getMtField();
		MTField linkout=MultipleHelper.getLinkOut(mtField);
		MTField linkin=MultipleHelper.getLinkIn(mtField);
		
		for (Object object :  element.getValues()) {
			values.add(((IDetachedRecord)object).get(linkout));
		}
    
		if(values.isEmpty())return "";
		
		element.setValues(values);
		
		FilterConfiguration filterConfiguration= new FilterConfiguration();
		filterConfiguration.setValues(values);
		filterConfiguration.setMtField(linkout);
		filterConfiguration.setOperator(Operator.IN);
		filterConfiguration.setName(linkout.getName());
		String where = SqlFacade.createWhereItems(filterConfiguration, parameters);
		where= linkin.getName() +" in (select "+linkin.getName()+" from "+mtField.getMultiRefTo().getFullTableName()+" where "+where+" )";	
		return (null == where || where.isEmpty()) ? "" :  where;
		
		
	}

	@Override
	public MTDataType forModelType() {
		
		return MTDataTypes.MULTIPLEENUM;
	}
	
	

}
