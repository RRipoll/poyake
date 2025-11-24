package com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.comboobjectselector;

import java.util.LinkedHashMap;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.ObjectSelectorHelper;

public class ComboboxObjectSelectorHelper {
	
	public static Integer getPk(Combobox combobox){
		if (null != combobox.getSelectedItem())
			return combobox.getSelectedItem().getValue();
		return null;
		
	}
	
	public static void setPk(Combobox combobox, Integer pk){
		combobox.setSelectedIndex(-1);
		if (null != pk){
			for (Comboitem item:combobox.getItems()){
				if (item.getValue() != null && pk.intValue() == ((Integer) item.getValue()).intValue()) {
					combobox.setSelectedItem(item);
					item.setValue(pk);
				}
			}
		}
	}
	public static void setPk(Combobox combobox, String pk){
		combobox.setSelectedIndex(-1);
		if (null != pk){
			for (Comboitem item:combobox.getItems()){
				if (pk.equals(item.getValue())){
					combobox.setSelectedItem(item);
					item.setValue(pk);
				}
			}
		}
	}
	
	public static void buildObjectList(Combobox combobox, MTTable mtTable){
		LinkedHashMap<Integer, String> values = ObjectSelectorHelper.buildObjectList(mtTable);
		combobox.getChildren().clear();
		
		for (Integer key:values.keySet()){
			Comboitem item = new Comboitem();
			
			if(null!=values.get(key))item.setLabel(values.get(key));
			else item.setLabel(key.toString());
			item.setValue(key);
			item.setParent(combobox);
		}
		
		/*
		String sql = ObjectSelectorHelper.buildObjectListSql(table);
		try{
			combobox.getChildren().clear();
			Connection conn = MainDb.getConnection();
			try{
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					Comboitem item = new Comboitem();
					item.setLabel(rs.getString(2));
					item.setValue(rs.getInt(1));
					item.setParent(combobox);
				}
			}
			finally{
				conn.close();
			}
		}
		catch (SQLException e){
			throw new RuntimeException(e.toString() + " while running sql " + sql);
		}
		*/
	}

	public static void setBlankItem(Combobox comp, MTField field) {
		if(field.isNullable()){
			Comboitem item= new Comboitem();
			//item.setHeight("15px");
			//item.setLabel(" ");
			comp.insertBefore(item, comp.getItemAtIndex(0));
			if(null==comp.getSelectedItem()){
				comp.setSelectedItem(item);
			}
			comp.invalidate();
		}
	}
}
