package com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.listboxobjectselector;

import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.ObjectSelectorHelper;

public class ListboxObjectSelectorHelper {
	
	public static Integer getPk(Listbox listbox){
		if (null != listbox.getSelectedItem())
			return listbox.getSelectedItem().getValue();
		return null;
		
	}
	
	public static void setPk(Listbox listbox, Integer pk){
		listbox.setSelectedIndex(-1);
		if (null != pk){
			for (Listitem item:listbox.getItems()){
				if (pk.equals(item.getValue()))
					listbox.setSelectedItem(item);
			}
		}
	}

	public static Vector<Integer> getPks(Listbox listbox){
		Vector<Integer> pks = new Vector<Integer>();
		for (Listitem listitem:listbox.getSelectedItems())
			pks.add((Integer)listitem.getValue());
		return pks;
	}

	public static void setPks(Listbox listbox, Vector<Integer> pks){
		listbox.clearSelection();
		for (Component comp:listbox.getChildren()){
			if (comp instanceof Listitem){
				Listitem listitem = (Listitem) comp;
				for (Integer pk:pks){
					if (pk.equals(listitem.getValue()))
						listitem.setSelected(true);
				}
			}
		}
	}

	
	public static void buildObjectList(Listbox listbox, MTTable mtTable){
		LinkedHashMap<Integer, String> values = ObjectSelectorHelper.buildObjectList(mtTable);
		listbox.getChildren().clear();
		for (Integer key:values.keySet()){
			Listitem item = new Listitem();
			item.setLabel(values.get(key));
			item.setValue(key);
			item.setParent(listbox);
			
		}
		
		/*
		String sql = ObjectSelectorHelper.buildObjectListSql(table);
		try{
			listbox.getChildren().clear();
			Connection conn = MainDb.getConnection();
			try{
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					Listitem item = new Listitem();
					item.setLabel(rs.getString(2));
					item.setValue(rs.getInt(1));
					item.setParent(listbox);
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
}
