package com.jsantos.gui.objectselector.radiogroupobjectselector;

import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;

import com.jsantos.orm.mt.MTTable;

public class RadioGroupObjectSelectorHelper {

	public static Integer getPk(Radiogroup radiogroup){
		if (null != radiogroup.getSelectedItem())
			return radiogroup.getSelectedItem().getValue();
		return null;
		
	}
	
	public static void setPk(Radiogroup radiogroup, Integer pk){
		 
		if (null != pk){
			for (Radio item:radiogroup.getItems()){
				if (pk.equals(item.getValue()))
					radiogroup.setSelectedItem(item);
			}
		}
	}
	
	public static void buildObjectList(Radiogroup radiogroup, MTTable mtTable){
		radiogroup.getItems().stream().forEach(item -> item.detach());
		for (Integer key:mtTable.getEnumeration().getKeys()){
			Radio item = new Radio();
			item.setLabel(mtTable.getEnumeration().getValue(key));
			item.setValue(key);
			item.setParent(radiogroup);
		}
		if(radiogroup.getItems().size() > 0)
			  radiogroup.getItems().get(0).setSelected(true);


	}
	
}
