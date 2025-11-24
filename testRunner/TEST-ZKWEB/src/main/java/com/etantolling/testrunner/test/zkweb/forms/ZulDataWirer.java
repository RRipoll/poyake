package com.etantolling.testrunner.test.zkweb.forms;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Textarea;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.SubTypes;
import com.etantolling.testrunner.test.core.utils.DataFormatter;
import com.etantolling.testrunner.test.zkweb.enumeration.multienum.MultiEnumHelper;
import com.etantolling.testrunner.test.zkweb.filegroup.FileGroupDataGrid;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.ObjectSelectorHelper;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.comboobjectselector.ComboboxObjectSelectorHelper;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.MTAnnotation;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class ZulDataWirer {
	private static final Logger log = LoggerFactory.getLogger(ZulDataWirer.class);
	
	public static void initializeFieldValues (DetachedRecord detachedRecord, Component parent) throws WrongValueException, SQLException{
		if(null==detachedRecord)return;
		Vector<Component> components = ComponentTreeTransverser.getMetadataAnotatedComponents(parent);
		initializeFieldValues(detachedRecord, components);
		
		
		/*
		Textbox textbox = (Textbox)ComponentTreeTransverser.findChildById(parent, "VERSION");
		ComponentCtrl compCtrl = (ComponentCtrl)textbox;
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(textbox.getId()).append(": ").append(compCtrl .getAnnotations(null)).append('\n');
		for (String prop: compCtrl.getAnnotatedProperties()) {
			sb.append(" with ").append(prop).append(": ").append(compCtrl .getAnnotations(prop)).append('\n');
		}				
		log.info("SB: " + sb.toString());
		Collection<Annotation> annotations = textbox.getAnnotations();
		for (Annotation annotation: annotations)
			log.info(annotation.getName() + " " + annotation.getAttributes());
		Annotation ann = textbox.getAnnotation("meta", "MT");
		if (null !=ann)
			log.info(ann.getAttribute("field"));
		*/
	}

	public static void readFormFieldValues(DetachedRecord detachedRecord, Component parent){
		Vector<Component> components = ComponentTreeTransverser.getMetadataAnotatedComponents(parent);
		readFormFieldValues(detachedRecord, components);
	}

	public static String buildWhereClause(Component parent){
		StringBuilder sb = new StringBuilder();
		for (Component comp: ComponentTreeTransverser.getMetadataAnotatedComponents(parent)){
			MTField mtField = MTAnnotation.getMTField((ComponentCtrl)comp);
			if (null != mtField) {
				// object selector 
				if (null != mtField.getForeignKey()){ 
					if (ObjectSelectorHelper.isMulti(comp)){
						Vector<Integer>pks = ObjectSelectorHelper.getPks(comp);
						if (0 < pks.size()){
							sb.append(" and " + mtField.getName() + " in (");
							for (Integer pk:pks){
								if (0 < pks.indexOf(pk)) sb.append(",");
								sb.append(pk);
							}
							sb.append(") ");
						}
					}
					else{
						if (null != ObjectSelectorHelper.getPk(comp))
							sb.append(" and " + mtField.getName() + "=" + ObjectSelectorHelper.getPk(comp) + " ");
					}
				}
				else if (comp instanceof Textbox){
					if (!StringUtils.isBlank(((Textbox)comp).getValue()))
						sb.append(" and " + mtField.getName() + "='" + ((Textbox)comp).getValue().trim() + "' ");
				}
			}
			
		}
		return sb.toString();
	}
	
	public static void wireFilterEvents(Component parent, EventListener<Event> eventListener){
		for (Component comp: ComponentTreeTransverser.getMetadataAnotatedComponents(parent)){
			if (comp instanceof Combobox)
				comp.addEventListener(Events.ON_SELECT, eventListener);
			if (comp instanceof Listbox)
				comp.addEventListener(Events.ON_SELECT, eventListener);
			if (comp instanceof Textbox){
				comp.addEventListener(Events.ON_BLUR, eventListener);
				comp.addEventListener(Events.ON_CHANGE, eventListener);
			}
		}
		
	}
	
	static void initializeFieldValues(DetachedRecord detachedRecord, Vector<Component> components) throws WrongValueException, SQLException{
		for (Component comp:components){
			MTField mtField = MTAnnotation.getMTField((ComponentCtrl)comp);
			if (null != mtField && mtField.getTable() == detachedRecord.getTable()){
				setValue(comp, detachedRecord, mtField);
			}
		}
	}

	static void readFormFieldValues(DetachedRecord detachedRecord, Vector<Component> components){
		for (Component comp:components){
			MTField mtField = MTAnnotation.getMTField((ComponentCtrl)comp);
			if (null != mtField && mtField.getTable() == detachedRecord.getTable()){
				readValue(comp, detachedRecord, mtField);
			}
		}
	}
	
	
	public static void setValue(Component comp, DetachedRecord dRecord, MTField mtField) throws WrongValueException, SQLException {
		if (null != mtField.getForeignKey()){ //so this is an object selector
			ObjectSelectorHelper.setField(comp, mtField);
			ObjectSelectorHelper.setPk(comp, (Integer)dRecord.getInteger(mtField));
		}
		else if (comp instanceof Textbox){
			((Textbox)comp).setValue(DataFormatter.formatAsString(mtField, dRecord.get(mtField)));
		}
		else if (comp instanceof Label){
			((Label)comp).setValue(DataFormatter.formatAsString(mtField, dRecord.get(mtField)));
		}
		else if (comp instanceof Div){
			if (SubTypes.FILE_GROUP.equals(mtField.getSubType()) || mtField.getName().contains("FileGroup") || mtField.getName().contains("FileGroupID")){
				if (null != dRecord.get(mtField)){
					FileGroupDataGrid dataGrid = new FileGroupDataGrid((Integer)dRecord.get(mtField));
					dataGrid.setParent(comp);
				}
			}
			else{
				if (null != dRecord.get(mtField))
					new Html(DataFormatter.formatAsHtml(mtField, dRecord.get(mtField))).setParent(comp);
			}
		}
		else if (comp instanceof Td){
			comp.getChildren().clear();
			if (null != dRecord.get(mtField))
				new Html(DataFormatter.formatAsHtml(mtField, dRecord.get(mtField))).setParent(comp);
		}
		else if (comp instanceof Intbox)
			((Intbox)comp).setValue(dRecord.getInteger(mtField));
		else if (comp instanceof Decimalbox)
			((Decimalbox)comp).setValue((BigDecimal)dRecord.get(mtField));
		else if (comp instanceof Datebox){
			((Datebox)comp).setValue((Date)dRecord.getDate(mtField));
		}else if (comp instanceof Radiogroup){
			((Radiogroup)comp).getItems().stream().forEach(entry ->{
				if(null!=entry.getValue() && null!=dRecord.get(mtField) && entry.getValue().toString().equals(dRecord.get(mtField).toString())) entry.setSelected(true);
			});
		}else if (comp instanceof Combobox){
			ComboboxObjectSelectorHelper.setPk((Combobox)comp, (Integer)dRecord.get(mtField));
		}
			
	}
	
	private static void readValue(Component comp, DetachedRecord dRecord, MTField mtField){
		if (null != mtField.getForeignKey()){ //so this is an object selector
			dRecord.set(mtField, ObjectSelectorHelper.getPk(comp));
		}
		else if (comp instanceof Combobox){
			if(null!=((Combobox)comp).getSelectedItem()){
				dRecord.set(mtField, ((Combobox)comp).getSelectedItem().getValue());
			}else if(null!=((Combobox) comp).getValue() && ((Combobox) comp).getValue().trim().length()>0)
				dRecord.set(mtField, ((Combobox) comp).getValue());
		}
		else if (comp instanceof Textbox){
			dRecord.set(mtField, ((Textbox)comp).getValue());
		}
		else if (comp instanceof Textarea){
			dRecord.set(mtField, ((Textarea)comp).getValue());
		}
		else if (comp instanceof Checkbox){
			if (SubTypes.ENUM_MULTI.equals(mtField.getSubType())){
				Integer value = MultiEnumHelper.retrieveValueFromZul((Component)comp.getSpaceOwner(), mtField.getName());
				dRecord.set(mtField, value);
			}
			else{
				Integer value = (((Checkbox)comp).isChecked()?1:0);
				dRecord.set(mtField, value);
			}
		}
		else if (comp instanceof Radiogroup)
			dRecord.set(mtField, (((Radiogroup)comp).getSelectedItem().getValue()));
		else if (comp instanceof Intbox)
			dRecord.set(mtField, ((Intbox)comp).getValue());
		else if (comp instanceof Decimalbox)
			dRecord.set(mtField, ((Decimalbox)comp).getValue());
		else if (comp instanceof Datebox)
			dRecord.set(mtField,  ((Datebox)comp).getValue());
			
		/*
		else if (comp instanceof CKeditor){
			dRecord.set(mtField, ((CKeditor)comp).getValue());
		}
		*/
		
	}
	
	
	public static Integer getIntegerValueForAnnotatedComponent(Component rootCmp, MTField mtField){
		Integer retValue = null;
		Component comp = ComponentTreeTransverser.findFieldEditorFor(rootCmp, mtField);
		if (null != comp){
			if (comp instanceof Combobox){
				Combobox combobox = (Combobox)comp;
				if (null != combobox.getSelectedItem()){
					if (combobox.getSelectedItem().getValue() instanceof Integer)
						retValue = (Integer)combobox.getSelectedItem().getValue();
					else if (combobox.getSelectedItem().getValue() instanceof BigDecimal)
						retValue = ((BigDecimal)combobox.getSelectedItem().getValue()).intValue();
					
				}
			}
			else if (comp instanceof Textbox){
				Textbox textbox = (Textbox)comp;
				if (!StringUtils.isEmpty(textbox.getValue()))
					retValue = Integer.parseInt(textbox.getValue());
			}
			else if (comp instanceof Intbox){
				Intbox intbox = (Intbox)comp;
				retValue = intbox.getValue();
			}
			else if (comp instanceof Radiogroup){
				Radiogroup radio = (Radiogroup)comp;
				if(radio.getSelectedItem() != null)
				   retValue = radio.getSelectedItem().getValue();
			}
			
		}
		else{
			log.info("Annotated component for " + mtField.getName() + " cant be found by getIntegerValueForAnnotatedComponent!!!");
		}
		return retValue;
	}
	
	public static List<Integer> getIntegerValueForAnnotatedComponents(Component rootCmp, MTField mtField){
		List<Integer> retValues = new ArrayList<Integer>();
		Vector<Component> comps = ComponentTreeTransverser.findFieldEditorsFor(rootCmp, mtField);
		for(Component comp:comps){
		
			if (null != comp){
				if (comp instanceof Combobox){
					Combobox combobox = (Combobox)comp;
					if (null != combobox.getSelectedItem())
						retValues.add((Integer)combobox.getSelectedItem().getValue());
				}
				else if (comp instanceof Textbox){
					Textbox textbox = (Textbox)comp;
					if (!StringUtils.isEmpty(textbox.getValue()))
					    retValues.add(Integer.parseInt(textbox.getValue()));
				}
				else if (comp instanceof Intbox){
					Intbox intbox = (Intbox)comp;
					retValues.add(intbox.getValue());
				}
				else if (comp instanceof Radiogroup){
					Radiogroup radio = (Radiogroup)comp;
					if(radio.getSelectedItem() != null)
					   retValues.add(radio.getSelectedItem().getValue());
				}
			}
			else{
				log.info("Annotated component for " + mtField.getName() + " cant be found by getIntegerValueForAnnotatedComponent!!!");
			}
		}
		return retValues;
	}
	
	public static String getStringValueForAnnotatedComponent(Component rootCmp, MTField mtField){
		String retValue = null;
		Component comp = ComponentTreeTransverser.findFieldEditorFor(rootCmp, mtField);
		if (null != comp){
			if (comp instanceof Textbox){
				Textbox textbox = (Textbox)comp;
				retValue = textbox.getValue();
			}
		}
		else{
			log.info("Annotated component for " + mtField.getName() + " cant be found by getStringValueForAnnotatedComponent!!!");
		}
		if (TextUtils.isEmpty(retValue))
			retValue = null;

		return retValue;
	}
	
	public static List<String> getStringValueForAnnotatedComponents(Component rootCmp, MTField mtField){
		List<String> retValues = new ArrayList<String>();
		Vector<Component> comps = ComponentTreeTransverser.findFieldEditorsFor(rootCmp, mtField);
		for(Component comp:comps){
			if (null != comp){
				if (comp instanceof Textbox){
					Textbox textbox = (Textbox)comp;
					retValues.add(textbox.getValue());
				}
			}
			else{
				log.info("Annotated component for " + mtField.getName() + " cant be found by getStringValueForAnnotatedComponent!!!");
			}
		}
		return retValues;
	}
	
	public static Map<Component, String> getStringValueMapForAnnotatedComponents(Component rootCmp, MTField mtField){
		Map<Component, String> retValues = new HashMap<Component,String>();
		Vector<Component> comps = ComponentTreeTransverser.findFieldEditorsFor(rootCmp, mtField);
		for(Component comp:comps){
			if (null != comp){
				if (comp instanceof Textbox){
					Textbox textbox = (Textbox)comp;
					retValues.put(comp, textbox.getValue());
				}
			}
			else{
				log.info("Annotated component for " + mtField.getName() + " cant be found by getStringValueForAnnotatedComponent!!!");
			}
		}
		return retValues;
	}
	
}
