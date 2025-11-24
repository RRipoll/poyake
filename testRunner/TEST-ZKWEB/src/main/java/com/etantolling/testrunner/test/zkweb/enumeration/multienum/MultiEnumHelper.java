package com.etantolling.testrunner.test.zkweb.enumeration.multienum;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.MTEnumeration;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.MTAnnotation;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class MultiEnumHelper {
	
	public static Hashtable<MTTable, LinkedHashMap<Integer,String>> enumerationCache = new Hashtable<MTTable, LinkedHashMap<Integer,String>>(); 
	
	public static Integer retrieveValueFromZul(Component parent, String fieldName){
		int retValue = 0;
		Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeName(parent, "field");
		for (Component comp:components){
			if (fieldName.equalsIgnoreCase((String)comp.getAttribute("field"))){
				if (comp instanceof Checkbox){
					Checkbox checkbox = (Checkbox)comp;
					if (checkbox.isChecked()){
						Integer checkBoxValue = checkbox.getValue();
						retValue += Math.pow(2, (double)checkBoxValue-1);
					}
				}
				else if (comp instanceof Radio){
					Radio radio = (Radio)comp;
					if (radio.isChecked()){
						Integer checkBoxValue = radio.getValue();
						retValue += Math.pow(2, (double)checkBoxValue-1);
					}
				}
			}
		}
		if(0==retValue)return null;
		return retValue;
	}
	
	
	
	
	public static void FillCheckBoxesComponent(Component parent, String type,EventListener<Event> eventListener){
		MTField tmpfield = null;
		if(null!=((AbstractComponent) parent).getAnnotation("info", "MT")){
			  tmpfield=MTAnnotation.getMTField((ComponentCtrl) parent);
		}else{
			if(null!=parent.getAttribute("table") && null!=parent.getAttribute("field")){
				tmpfield=MT.getTable((String)parent.getAttribute("table")).getField((String)parent.getAttribute("field"));
				}
			}
		final MTField field=tmpfield;
		if(null!=field){
			
			String foreighKeyTable=null;
			if(null!=field.getForeignKey() && null!=field.getForeignKey().getTableName())
				foreighKeyTable=field.getForeignKey().getTableName();
			else if(null!=parent.getAttribute("FOREIGNKEY"))
				foreighKeyTable=(String) parent.getAttribute("FOREIGNKEY");
			else return;	
			
			if(type.equals("Radio"))
				fillEnumRadio(parent,foreighKeyTable,field.getName(),field.getTable().getTableName(),type,eventListener);	
			else fillEnum(parent,foreighKeyTable,field.getName(),field.getTable().getTableName(),type,eventListener);
		}
	}
	
	public static void fillEnum(Component parent,String foreighKeyTable,String fieldName, String tableName,String type,EventListener<Event> eventListener){
		
		parent.getChildren().clear();
		
		Vector<Checkbox> checkboxes= new Vector<Checkbox>(); 
		
		MTEnumeration tableEnum=MT.getEnum(foreighKeyTable);
		
		((MTEnumeration) tableEnum).getKeys().stream().forEach(entry ->{
			
			Integer key=(Integer)entry;
			Checkbox cb= new Checkbox();
			cb.setValue(key);
			cb.setLabel(tableEnum.getValue(key));
			cb.setParent(parent);
			cb.setAttribute("field", fieldName);
			cb.setAttribute("table", tableName);
			if(parent.hasAttribute("operator"))
				cb.setAttribute("operator", parent.getAttribute("operator"));
			if(parent.hasAttribute("groupid"))
				cb.setAttribute("groupid", parent.getAttribute("groupid"));
			if(null!=type)cb.setAttribute("type", type);
			checkboxes.add(cb);
			if(null!=eventListener)
				cb.addEventListener(Events.ON_CHECK, eventListener);
		} );
		parent.setAttribute("checkboxes", checkboxes);
	}
	
	public static void fillEnumRadio(Component parent,String foreighKeyTable,String fieldName, String tableName,String type,EventListener<Event> eventListener){
		
		parent.getChildren().clear();
		
		Radiogroup radioGroup= new Radiogroup();

		radioGroup.setParent(parent);
		
		MTEnumeration tableEnum=MT.getEnum(foreighKeyTable);
		
		((MTEnumeration) tableEnum).getKeys().stream().forEach(entry ->{
			
			Integer key=(Integer)entry;
			Radio cb= new Radio();
			cb.setValue(key);
			cb.setLabel(tableEnum.getValue(key));
			cb.setRadiogroup(radioGroup);
			cb.setAttribute("field", fieldName);
			cb.setAttribute("table", tableName);
			if(parent.hasAttribute("operator"))
				cb.setAttribute("operator", parent.getAttribute("operator"));
			if(parent.hasAttribute("groupid"))
				cb.setAttribute("groupid", parent.getAttribute("groupid"));
			if(null!=type)cb.setAttribute("type", type);
			cb.setParent(parent);
			if(null!=eventListener)
				cb.addEventListener(Events.ON_CHECK, eventListener);
		} );
		//parent.setAttribute("checkboxes", checkboxes);
	}
}