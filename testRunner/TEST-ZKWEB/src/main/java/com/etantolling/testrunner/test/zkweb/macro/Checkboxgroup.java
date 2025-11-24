package com.etantolling.testrunner.test.zkweb.macro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.zkoss.zk.ui.HtmlMacroComponent;
import org.zkoss.zul.Checkbox;

public class Checkboxgroup extends HtmlMacroComponent{
	private static final long serialVersionUID = -6743349041912245958L;
    private List<Checkbox> items = null;
	 
	public Checkboxgroup() {
	   compose();
	   items = new ArrayList<Checkbox>();
	}

	public void addItem(Checkbox item){
		getItems().add(item);
	}

	public List<Checkbox> getItems(){
		return items;
	}

	public List<Checkbox> getSelectedItems(){
		return  getItems().stream().filter(item ->item.isChecked()).collect(Collectors.toList());       		
	}
	 
}
