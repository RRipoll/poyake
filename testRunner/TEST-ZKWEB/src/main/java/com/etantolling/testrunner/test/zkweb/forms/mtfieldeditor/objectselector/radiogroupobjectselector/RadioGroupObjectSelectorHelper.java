package com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.radiogroupobjectselector;

import java.util.LinkedHashMap;

import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;

import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.ObjectSelectorHelper;

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
		LinkedHashMap<Integer, String> values = ObjectSelectorHelper.buildObjectList(mtTable);
		radiogroup.getItems().stream().forEach(item -> item.detach());
		for (Integer key:values.keySet()){
			Radio item = new Radio();
			item.setLabel(values.get(key));
			item.setValue(key);
			item.setParent(radiogroup);
		}
		if(radiogroup.getItems().size() > 0)
			  radiogroup.getItems().get(0).setSelected(true);

/*		
		String sql = ObjectSelectorHelper.buildObjectListSql(table);
		try{
			radiogroup.getItems().clear();
			Connection conn = MainDb.getConnection();
			try{
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					Radio item = new Radio();
					item.setLabel(rs.getString(2));
					item.setValue(rs.getInt(1));
					item.setParent(radiogroup);
				}
				if(radiogroup.getItems().size() > 0)
				  radiogroup.getItems().get(0).setSelected(true);
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
	
}
