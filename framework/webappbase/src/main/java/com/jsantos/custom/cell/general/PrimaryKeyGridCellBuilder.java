package com.jsantos.custom.cell.general;

import java.util.Locale;

import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Label;

import com.jsantos.common.registry.FieldRendererProvider;
import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.custom.fieldrenderer.general.DefaultFieldRenderer;
import com.jsantos.custom.fieldrenderer.general.ForeignKeyFieldRenderer;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.zKpermission.Permission;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;


/**
 * @author javier santos 
 * @author raul ripoll
 */

public class PrimaryKeyGridCellBuilder extends Div  implements IGridCellBuilder{
	MTField field;
	
	Integer permissionValue;
	
	public MTField getField() {
		return field;
	}

	public void setField(MTField field) {
		this.field = field;
	}

	protected Component comp;
	
	public PrimaryKeyGridCellBuilder(MTField field) {
		this.field = field;
	}
	
	@Override
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values,Locale locale) {
		permissionValue=Permission.getPermissionByShortCode(field.getTable().getFullTableName());
		if(null!=mtField.getForeignKey())
			comp=new Label(new ForeignKeyFieldRenderer().render(value,mtField, values, LocaleFactory.getProvider().getLocale()));
		else {
			IMTFieldRenderer renderer = FieldRendererProvider.getRenderer(field);
			if(null==renderer)renderer=new DefaultFieldRenderer();
			comp=new Label(renderer.render(value,mtField, values, LocaleFactory.getProvider().getLocale()));
		}	
		if(PermissionFactory.getProvider().hasAnyPermission(permissionValue)) {
			
			this.setSclass("btn btn-link");
			this.setStyle("color:blue");
			
			}
		comp.setParent(this);
		return this;
	}

	@Override
	public MTField forField() {
		return field;
	}

	

}
