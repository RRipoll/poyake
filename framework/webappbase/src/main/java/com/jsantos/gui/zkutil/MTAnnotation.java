package com.jsantos.gui.zkutil;

import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zk.ui.metainfo.Annotation;
import org.zkoss.zk.ui.sys.ComponentCtrl;

import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.search.AttributeConstants;


public class MTAnnotation {
	
	public static MTField getMTField(ComponentCtrl comp){
		MTField mtField = null;
		Annotation ann = comp.getAnnotation("info", "MT");
		if (null != ann){
			String sField = ann.getAttribute(AttributeConstants.FIELD);
			if (null != sField){
				mtField = MTBase.getMTField(sField);
			}
			if (null == mtField)
				System.out.println("No field found for annotation: " + ann.toString());
		}
		if (null == mtField && comp instanceof IMTComponent) {
			IMTComponent mtComponent = (IMTComponent)comp;
			if (StringUtils.isNotBlank(mtComponent.getField()))
				mtField = MTBase.getMTField(mtComponent.getField());
		}
		return mtField;
	}

	public static MTTable getMTTable(ComponentCtrl comp){
		MTTable mtTable = null;
		Annotation ann = comp.getAnnotation("info", "MT");
		if (null != ann){
			String sTable = ann.getAttribute(AttributeConstants.TABLE);
			if (null != sTable){
				mtTable = MTBase.getTable(sTable);
			}
		}
		if (null == mtTable && comp instanceof IMTComponent) {
			IMTComponent mtComponent = (IMTComponent)comp;
			if (StringUtils.isNotBlank(mtComponent.getField()))
				mtTable = MTBase.getMTField(mtComponent.getField()).getTable();
		}
		return mtTable;
	}
	
	
	public static void setMTField(ComponentCtrl comp, MTField mtField){
		String[] fieldAttribute = {mtField.getTable().getTableName() + "." + mtField.getName()};
		Map<String, String[]> attributes = null;
		Annotation ann = comp.getAnnotation("info", "MT");
		if (null != ann)
			attributes = ann.getAttributes();
		else
			attributes = new Hashtable<String, String[]>();
		attributes.put(AttributeConstants.FIELD, fieldAttribute);
		comp.addAnnotation("info", "MT", attributes);
	}
}
