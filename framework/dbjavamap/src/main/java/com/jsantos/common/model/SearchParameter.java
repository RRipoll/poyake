package com.jsantos.common.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;

public class SearchParameter {
	
	public static enum Type{Integer,Long,Boolean,BigDecimal,Date,DateTime,Time,String,Json};
	public static enum Formatter{Default,Phone,Email,Currency,Enumeration,CreditCard,Editable};
	public static enum Operator{EQUAL,GE,LE,GT,LT,LIKE,ILIKE,IN,BETWEEN,NOT_IN,NOT_EQUAL};
	public static enum CompareType{Default,Select,MultiSelect,Check,MultiCheck,Radio,Range};

	public static String getSqlOperator(Operator operator) throws ApiException {
		switch (operator) {
		case BETWEEN:
			return "BETWEEN";
		case LT:
			return " < ";
		case LE:
			return "<=";
		case EQUAL:
			return " = ";
		case NOT_EQUAL:
			return " != ";
		case GE:
			return " >= ";
		case GT:
			return " > ";
		case IN:
			return " IN ";
		case NOT_IN:
			return " NOT IN ";
		case LIKE:
			return " LIKE ";
		case ILIKE:
			return " LIKE ";
		default:
			throw new ApiException(ApiError.VALIDATION_ERROR, "wrong search paramenter");
		}
	}
	
	public static Map<String, String[]> getSearchParameters() {

		Map<String, String[]> searchParameters;
		searchParameters = new HashMap<String, String[]>();
		searchParameters.put("Types", getNames(Type.class));
		searchParameters.put("formatters", getNames(Formatter.class));
		searchParameters.put("Operators", getNames(Operator.class));
		searchParameters.put("CompareTypes", getNames(CompareType.class));
		
		return searchParameters;
	}
	public static String[] getNames(Class<? extends Enum<?>> e) {
	    return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}
	
}