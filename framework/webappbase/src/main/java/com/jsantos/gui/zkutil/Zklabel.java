package com.jsantos.gui.zkutil;

import java.util.Locale;

import org.zkoss.util.Locales;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Executions;

import com.jsantos.common.util.MapValues;
import com.jsantos.factory.internationalization.LabelFactory;

public class Zklabel extends MapValues<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Zklabel(Locale language) {
		Executions.getCurrent().getSession().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE,language);
		
	}
	public Zklabel() {
		
		Locale locale = (Locale)Executions.getCurrent().getSession().getAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE);
		if(null==locale) {
			locale = Locales.getCurrent();
			Executions.getCurrent().getSession().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE,locale);
		}
	}
    
	
    public String get(Object arg0) {
    	if(null==arg0)return null;
    	String retValue;
    	if(LabelFactory.getProvider().isImplemented()) {
    		retValue= LabelFactory.getProvider().get(arg0.toString(),(Locale) Executions.getCurrent().getSession().getAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE));
    		if(retValue.equals(arg0.toString()))
				retValue= Labels.getLabel(arg0.toString());
    	}else retValue= Labels.getLabel(arg0.toString());
    	return null==retValue?arg0.toString():retValue;
	}
	
	static public String getLabel(Object arg0,Locale locale) {
    	if(null==arg0)return null;
    	String retValue;
		if(LabelFactory.getProvider().isImplemented()) {
			retValue= LabelFactory.getProvider().get(arg0.toString(),locale);
			if(retValue.equals(arg0.toString()))
				retValue= Labels.getLabel(arg0.toString());
		}else retValue= Labels.getLabel(arg0.toString());
    	return null==retValue?arg0.toString():retValue;
		
	}
	
	static public String getLabel(Object arg0) {
    	if(null==arg0)return null;
    	String retValue;
		if(LabelFactory.getProvider().isImplemented()) {
			retValue= LabelFactory.getProvider().get(arg0.toString(),(Locale) Executions.getCurrent().getSession().getAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE));
			if(retValue.equals(arg0.toString()))
				retValue= Labels.getLabel(arg0.toString());
		}
		else retValue= Labels.getLabel(arg0.toString());
    	return null==retValue?arg0.toString():retValue;
	}
	
	
}
