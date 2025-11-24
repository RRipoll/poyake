package com.jsantos.gui.datagrid4;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Label;

import com.jsantos.common.registry.FieldRendererProvider;
import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.custom.cell.GridCellComponentProvider;
import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.custom.cell.general.PKFieldComponentBuilder;
import com.jsantos.custom.fieldrenderer.general.DefaultFieldRenderer;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class CellEntity {

	
	public static Component getCellBuilder (MTField field, IDetachedRecord datarecord) {
		Object value=DBValueMapper.loadValue(datarecord, field);
		return getCellBuilder (field, (null!=datarecord && null!=datarecord.get(field))?value:null,  datarecord, LocaleFactory.getProvider().getLocale());
	}
	
	public static Component getCellBuilder (MTField field, Object value, IDetachedRecord datarecord, Locale locale) {
		Component builder = GridCellComponentProvider.buildAndInitializeGridComponent(field, value, datarecord,LocaleFactory.getProvider().getLocale());
		if(null== builder) {
				IGridCellBuilder cf=CellEntity.getPkLink(field);
				if(null!=cf)
					builder=cf.buildGridComponent(field, value, datarecord,locale);
		}
		if(null== builder) {
					IMTFieldRenderer renderer = FieldRendererProvider.getRenderer(field);
					if(null==renderer)renderer=new DefaultFieldRenderer();
					builder=new Label(renderer.render(value,field, datarecord, LocaleFactory.getProvider().getLocale()));
				}
		return builder;
		
	}
	
	public static IGridCellBuilder getPkLink(MTField field) {
		
		if(null!=field.getForeignKey() && !field.getForeignKey().getIsEnumeration()) {
			return  new PKFieldComponentBuilder(field);
		}else if(null!=field.getSameAs() && null!=field.getSameAs().getForeignKey() && !field.getSameAs().getForeignKey().getIsEnumeration()) {
			return new PKFieldComponentBuilder(field.getSameAs());
		}else if(null!=field.getSameAs() && null==field.getSameAs().getForeignKey() && field.getSameAs().isPrimaryKey()) {
			return new PKFieldComponentBuilder(field.getSameAs());
		}
		return null;
	}
}
