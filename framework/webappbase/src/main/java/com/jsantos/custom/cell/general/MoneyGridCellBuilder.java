package com.jsantos.custom.cell.general;

import java.math.BigDecimal;
import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Label;

import com.jsantos.common.registry.FieldRendererProvider;
import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.custom.fieldrenderer.general.DefaultFieldRenderer;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class MoneyGridCellBuilder implements IGridCellBuilder {

	@Override
	public Component buildGridComponent(MTField field, Object value, IDetachedRecord values,Locale locale) {
		IMTFieldRenderer renderer = FieldRendererProvider.getRenderer(field);
		if(null==renderer)renderer=new DefaultFieldRenderer();
		Label label = new Label(renderer.render(value,field, values,locale));
		BigDecimal bdValue = new BigDecimal(value.toString());
		if (bdValue.compareTo(BigDecimal.ZERO)<0)
			label.setStyle("color:red");
		return label;
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.MONEY;
	}

}
