package com.jsantos.custom.filter;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;
import com.jsantos.search.core.services.SqlFacade;
import com.jsantos.search.model.parameter.BlockItem;

public interface IFilterComponent {
	
	public default MTDataType forModelType() {
		return null;
	};

	public default MTField forField() {
		return null;
	};

	public Component buildFilterComponent();

	default void setEditorAtributes(Component comp, IFilterComponent filterBuilder) {
		comp.setAttribute(AttributeConstants.EDITOR, this);
		comp.setAttribute(AttributeConstants.TYPE, AttributeConstants.FILTER);
	};
	
	public ListValues<Object> getValues();

	public FilterConfiguration getConfiguration();

	public void setConfiguration(FilterConfiguration conf);

	void setInitialValues(ListValues<Object> initialValues);

	ListValues<Object> getInitialValues();



	public default String getDescription() {
		String description = LabelFactory.getProvider().get(getConfiguration().getMtField(),LocaleFactory.getProvider().getLocale());
		
		return description;
	}

	public default BlockItem generateBlockItem() {
		return SqlFacade.generateBlockItem(getConfiguration().getName(), getValues(), getConfiguration().getOperator());
	};
}
