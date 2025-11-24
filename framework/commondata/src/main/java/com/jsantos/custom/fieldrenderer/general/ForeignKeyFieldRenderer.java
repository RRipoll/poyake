package com.jsantos.custom.fieldrenderer.general;

import java.util.Locale;

import com.jsantos.common.registry.FieldRendererProvider;
import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.common.util.MapValues;
import com.jsantos.commondata.util.DefaultRecordDescription;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.factory.DTOFactory;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class ForeignKeyFieldRenderer implements IMTFieldRenderer{

	public ForeignKeyFieldRenderer() {
	}
	
	@Override
	public String render(Object value,MTField mtField, IDetachedRecord values,Locale locale) {
		if (value == DBValueMapper.NULL) return "";
		if (null == value) return "";
		MTTable fk=mtField.getForeignKey().getRealFKTOTable();
		
		IMTFieldRenderer frp=FieldRendererProvider.getRenderer(MultipleHelper.getOrigen(fk.getMainFk().getRealField()));
		if(null==frp)frp=new DefaultFieldRenderer();
		if(!(frp instanceof DefaultFieldRenderer))return frp.render(value, MultipleHelper.getOrigen(fk.getMainFk().getRealField()), values, locale);
		
		String targetField=mtField.getForeignKey().getPrimaryKey().getName();
		if(null==targetField && null!=fk.getField(mtField.getName()))
			targetField=mtField.getName();
		
		String description=null;
		if(fk.getDescriptionFields().size()>0) {
			IDetachedRecord dr= DTOFactory.get(fk).find(new MapValues<Object>().add(targetField, value));
			description=DefaultRecordDescription.getDescription(dr,locale);
		}
		if(null==description || description.isEmpty())description=value.toString();
		
		return description;
		
	}
}
