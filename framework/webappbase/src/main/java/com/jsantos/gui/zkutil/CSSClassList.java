package com.jsantos.gui.zkutil;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zhtml.impl.AbstractTag;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.impl.XulElement;

public class CSSClassList {
	public static void add(Component c, String sClass) {
		if (c instanceof XulElement) {
			String currentClass = ((XulElement)c).getSclass();
			if (StringUtils.isBlank(currentClass))
				currentClass = "";
			((XulElement)c).setSclass(currentClass + " " + sClass);
		}
		if (c instanceof AbstractTag) {
			String currentClass = ((AbstractTag)c).getSclass();
			if (StringUtils.isBlank(currentClass))
				currentClass = "";
			((AbstractTag)c).setSclass(currentClass + " " + sClass);
		}
	}
	
	public static boolean contains(Component c, String sClass) {
		sClass = sClass.trim();
		String currentClass = null;
		if (c instanceof XulElement)
			currentClass = ((XulElement)c).getSclass();
		if (c instanceof AbstractTag) 
			currentClass = ((AbstractTag)c).getSclass();
		
		if (StringUtils.isBlank(currentClass))
			return false;
		if (currentClass.trim().equalsIgnoreCase(sClass))
			return true;
		if (currentClass.trim().startsWith(sClass + " "))
			return true;
		if (currentClass.trim().endsWith(" " + sClass))
			return true;
		if (currentClass.contains(" " + sClass + " "))
			return true;
		return false;
	}
	
	public static void remove(Component c, String sClass) {
		if (c instanceof XulElement) {
			String currentClass = ((XulElement)c).getSclass();
			if (StringUtils.isBlank(currentClass))
				currentClass = "";
			((XulElement)c).setSclass(currentClass.replace(" " + sClass, ""));
		}
		if (c instanceof AbstractTag) {
			String currentClass = ((AbstractTag)c).getSclass();
			if (StringUtils.isBlank(currentClass))
				currentClass = "";
			((AbstractTag)c).setSclass(currentClass.replace(" " + sClass, ""));
		}
	}
	
}
