package com.jsantos.search.model.parameter;

import com.jsantos.common.model.SearchParameter.Operator;
import com.jsantos.common.util.ListValues;

public class WhereItem {

		public WhereItem() {
		super();
	}
		private String fieldName;
		private Operator operator;
		private ListValues<Object> values;
		
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public Operator getOperator() {
			return operator;
		}
		public void setOperator(Operator operator) {
			this.operator = operator;
		}
		public ListValues<Object> getValues() {
			return values;
		}
		public void setValues(ListValues<Object> values) {
			this.values = values;
		}
}
