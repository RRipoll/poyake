package com.jsantos.custom.sqlextended;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.core.services.SqlFacade;


public interface  ISqlExtended{

	public default MTDataType forModelType() {
		return null;
	};

	public default MTField forField() {
		return null;
	};

	void setWhereClause(String whereClause);

	public String getWhereClause();

	public default String generateWhereClause(FilterConfiguration element,MapValues<Object> parameters) {
		ListValues<Object> compValues = element.getValues();
		if (null == compValues || compValues.isEmpty() || compValues.get(0).toString().isEmpty())
			return "";
		if(null!=getWhereClause())return getWhereClause();
		String where = SqlFacade.createWhereItems(element, parameters);
		return (null == where || where.isEmpty()) ? "" :  where;
	};
	
	public String getSelectClause();
	void setSelectClause(String selectClause);
	
	public default String generateSelectClause(GridColumnConfiguration element,MapValues<Object> parameters) {
		
		return element.getMtField().getName();
	};
	

}


