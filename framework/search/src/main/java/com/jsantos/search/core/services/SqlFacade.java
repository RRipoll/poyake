package com.jsantos.search.core.services;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.jsantos.common.model.SearchParameter;
import com.jsantos.common.model.SearchParameter.Operator;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.sqlextended.ISqlExtended;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.DBUtil.OrderByItem;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.search.model.ParameterDTO;
import com.jsantos.search.model.parameter.BlockItem;
import com.jsantos.search.model.parameter.WhereItem;
import com.jsantos.search.registry.SqlExtendedProvider;

//@Slf4j


/**
 * @author raul ripoll
 */

public class SqlFacade {

	public static String createSelectItems(List<GridColumnConfiguration> columnConfigurations, ParameterDTO parameterDto,
			MapValues<Object> parameters) {
		StringBuilder retValue = new StringBuilder().append("");

		for (GridColumnConfiguration element : columnConfigurations) {
			if (element.isActive()) {
				if (retValue.length() > 0)
					retValue.append(", ");
				retValue.append(element.getMtField().getName());
			}
		}
		return retValue.toString();
	}
	
	public static String createWhereClause(List<FilterConfiguration> filterConfigurations, ParameterDTO parameterDto,
			MapValues<Object> parameters) throws ApiException {

		ListValues<String> retValue =  new ListValues<>();
		ListValues<String> retConfParam = new ListValues<>();

		for (FilterConfiguration paramItem : filterConfigurations) {
			if (null != paramItem.getValues() && null != paramItem.getOperator()) {
				
				ISqlExtended sqlExtended=SqlExtendedProvider.getRenderer(paramItem.getMtField());
				retConfParam.add(sqlExtended.generateWhereClause(paramItem, parameters));
			}
		}
		if (null != parameterDto && null != parameterDto.getAnd())
			for (BlockItem element : parameterDto.getAnd()) {
				retValue.add(createBlock(filterConfigurations, element, parameters, " and "));
			}
		return (retConfParam.size()> 0 ? "and (" + String.join(" and ", retConfParam) + ")" : "")
				+ ((retValue.size() > 0) ? "and (" + String.join(" and ", retValue) + ")" : "");
	}
	
	
	public static String createOrderByClause(SettingDTO settingDTO) throws ApiException {

		StringBuilder orderByString = new StringBuilder().append("");

		if (null != settingDTO && null != settingDTO.getOrderByConfigurations())

			for (OrderByItem orderItem : settingDTO.getOrderByConfigurations()) {
				if (orderByString.length() > 0)
					orderByString.append(", ");
				orderByString.append(orderItem.getOrder());
			}
		return orderByString.toString();
	}

	

	private static String createBlock(List<FilterConfiguration> filterConfigurations, BlockItem block, MapValues<Object> parameters,
			String operator) throws ApiException {

		ListValues<String> array = new ListValues<>();

		boolean isEmpty = true;

		if (null != block.getAnd())
			for (BlockItem element : block.getAnd()) {
				isEmpty = false;
				array.add(createBlock(filterConfigurations, element, parameters, " and "));
			}
		if (null != block.getOr())
			for (BlockItem element : block.getOr()) {
				isEmpty = false;
				array.add(createBlock(filterConfigurations, element, parameters, " or "));
			}
		if (null != block.getParameters()) {
			for (WhereItem element : block.getParameters()) {
				isEmpty = false;
				if(null==element.getValues() || element.getValues().size()==0 || element.getValues().get(0).toString().isEmpty()) continue;
				FilterConfiguration paramItem= new FilterConfiguration();
				FilterConfiguration conf = FilterConfiguration.get(filterConfigurations,
						element.getFieldName());
				BeanUtils.copyProperties(conf, paramItem);
				BeanUtils.copyProperties(element, paramItem);
				
				ISqlExtended sqlExtended=SqlExtendedProvider.getRenderer(paramItem.getMtField());
				array.add(sqlExtended.generateWhereClause(paramItem, parameters));
			}
		}
		if (isEmpty)
			return "(1=1)";
		return "(" + String.join(operator, array) + ")";
	}

	public static String createWhereItems(FilterConfiguration element, MapValues<Object> parameters)
			throws ApiException {
		StringBuilder retValue = new StringBuilder().append("");

		int i = 1;

		String name = element.getName();

		while (parameters.containsKey(name))
			name = element.getName() + i++;

		if (null != element.getOperator() && (element.getOperator().equals(Operator.IN)
				|| element.getOperator().equals(SearchParameter.Operator.NOT_IN))) {
			retValue.append(getWhereIn(parameters, element, name));

		} else if (null != element.getOperator() && element.getOperator().equals(Operator.BETWEEN)) {
			retValue.append(getWhereBETWEEN(parameters, element, name));

		} else if (element.getMtField().getDataType().equals(MTDataTypes.VARCHAR)) {
			retValue.append(getWhereString(parameters, element, name));

		} else
			retValue.append(getWhereData(element, name, parameters));

		return retValue.toString();
	}

	private static String getWhereBETWEEN(MapValues<Object> parameters, FilterConfiguration element, String name)
			throws ApiException {
		StringBuilder retValue = new StringBuilder().append("");
		String sValue = "";
		//
		if (null == element.getValues().get(0) && null == element.getValues().get(1)) return sValue;
		//
		if (null == element.getValues() || element.getValues().isEmpty()) {
			sValue = " is null ";
			parameters.put("oneParameter", "anyValue");
		} else if (null == element.getValues().get(0) && null != element.getValues().get(1)) {
			element.setOperator(Operator.LE);
			Object value = element.getValues().get(1);
			element.getValues().clear();
			element.getValues().add(value);
			return getWhereData(element, name, parameters);

		} else if (null != element.getValues().get(0) && null == element.getValues().get(1)) {
			element.setOperator(Operator.GE);
			Object value = element.getValues().get(0);
			element.getValues().clear();
			element.getValues().add(value);
			return getWhereData(element, name, parameters);

		} else {
			if (element.getValues().size() != 2 || null == element.getValues().get(0)
					|| null == element.getValues().get(1))
				throw new ApiException(ApiError.DB_BAD_METADATA, "Wrong Data");
			Object value0 = element.getValues().get(0);
			Object value1 = element.getValues().get(1);
			String name0 = "b_" + name;
			String name1 = "a_" + name;

			sValue = (" " + SearchParameter.getSqlOperator(element.getOperator()) + " :" + name0 + " and " + " :"
					+ name1 + " ");
			parameters.put(name0,value0);
			parameters.put(name1,value1);
	
		}
		retValue.append(element.getName() + sValue);

		return retValue.toString();
	}

	private static String getWhereData(FilterConfiguration element, String name, MapValues<Object> parameters)
			throws ApiException {
		StringBuilder retValue = new StringBuilder().append("");
		Object value;
		String operator;
		String sValue = "";
		if (null == element.getValues() || element.getValues().isEmpty() || null == element.getValues().get(0))return sValue;
		if (null == element.getValues() || element.getValues().isEmpty() || null == element.getValues().get(0)) {
			if (element.getOperator().equals(Operator.NOT_EQUAL) || element.getOperator().equals(Operator.NOT_IN))
				sValue = " is not null ";
			else
				sValue = " is null ";
			parameters.put("oneParameter", "anyValue");
		} else {
			value = element.getValues().get(0);
			operator = SearchParameter.getSqlOperator(
					(null == element.getOperator() ? SearchParameter.Operator.EQUAL : element.getOperator()));
			sValue = (" " + operator + " :" + name + " ");
			parameters.put(name, value);
		}
		retValue.append(element.getName() + " " + sValue);
		return retValue.toString();
	}

	private static String getWhereString(MapValues<Object> parameters, FilterConfiguration element, String name)
			throws ApiException {

		StringBuilder retValue = new StringBuilder().append("");
		String value = null;
		String operator;
		String sValue = "";
		String fieldValue = element.getName();
		if (null == element.getValues() || element.getValues().isEmpty() || null == element.getValues().get(0)
				|| element.getValues().get(0).toString().isEmpty()	)return sValue;
		if (null == element.getValues() || element.getValues().isEmpty() || null == element.getValues().get(0)) {
			if (element.getOperator().equals(Operator.NOT_EQUAL))
				sValue = " is not null ";
			else
				sValue = " is null ";
			parameters.put("oneParameter", "anyValue");
		} else {
			value = element.getValues().get(0).toString();
			operator = SearchParameter.getSqlOperator(
					(null == element.getOperator() ? SearchParameter.Operator.EQUAL : element.getOperator()));

			if (null != element.getName()) {
				if(element.getOperator().equals(Operator.EQUAL) && !value.equals(wildCard(value, name)))
					element.setOperator(Operator.LIKE);
				if (element.getOperator().equals(Operator.LIKE) && !value.equals(wildCard(value, name))) {
					operator = SearchParameter.getSqlOperator(Operator.LIKE);
					sValue = " " + operator + " :" + name + " ";
					parameters.put(name, wildCard(value, name));
				} else if (element.getOperator().equals(Operator.ILIKE) && !value.equals(wildCard(value, name))) {
					operator = SearchParameter.getSqlOperator(Operator.ILIKE);
					sValue = " " + operator + " :" + name + " ";
					fieldValue = "UPPER(" + fieldValue + ")";
					parameters.put(name, wildCard(value, name).toUpperCase());
				} else {
					operator = SearchParameter.getSqlOperator(Operator.EQUAL);
					sValue = " " + operator + "cast( :" + name + " as varchar) ";
					parameters.put(name, value);
				}
			}
		}
		retValue.append(fieldValue + " " + sValue);

		return retValue.toString();
	}

	private static String getWhereIn(MapValues<Object> parameters, FilterConfiguration element, String name)
			throws ApiException {
		StringBuilder retValue = new StringBuilder().append("");
		StringBuilder values = new StringBuilder("");
		String sValue = "";
		if (null == element.getValues() || element.getValues().isEmpty() || null == element.getValues().get(0))return sValue;
		
		if (null == element.getValues() || element.getValues().isEmpty() || null == element.getValues().get(0)) {
			if (element.getOperator().equals(Operator.NOT_IN))
				sValue = " is not null ";
			else
				sValue = " is null ";
			parameters.put("oneParameter", "anyValue");
		} else {
			int i = 1;
			for (Object item : element.getValues()) {
				if (values.length() != 0)
					values.append(", ");
				String enuNameItem = element.getName() + i++;
				parameters.put(enuNameItem,	item);
				
				values.append(":" + enuNameItem);
			}
			sValue = " " + SearchParameter.getSqlOperator(element.getOperator()) + "  (" + values + ")";
		}
		if (values.length() > 0) {
			retValue.append(" " + element.getName() + sValue);
		}
		return retValue.toString();
	}

	

	private static String wildCard(String value, String name) {
		String retValue = value;
		retValue = retValue.replace("*", "%");
		retValue = retValue.replace("$", "_");
		return retValue;
	}

	public static BlockItem generateBlockItem(String name, ListValues<Object> values, Operator operator) {
		BlockItem blockItem = new BlockItem();
		WhereItem whereItem = new WhereItem();
		String field = name;

		if (	null == values || 
				values.isEmpty() || 
				(values.size()==1 && null==values.get(0)) ||
				(values.size()==1 && values.get(0).toString().isEmpty())
				
				)
			return null;
		whereItem.setFieldName(field);
		whereItem.setOperator(operator);
		whereItem.setValues(values);
		blockItem.getParameters().add(whereItem);
		return blockItem;
	}

	public static WhereItem generateWhereItem(String fieldName, Operator operator, ListValues<Object> values) {
		WhereItem whereItem = new WhereItem();

		whereItem.setFieldName(fieldName);
		whereItem.setOperator(operator);
		whereItem.setValues(values);

		return whereItem;
	}

}