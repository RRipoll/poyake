package com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Radiogroup;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.comboobjectselector.ComboboxObjectSelectorHelper;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.listboxobjectselector.ListboxObjectSelectorHelper;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.radiogroupobjectselector.RadioGroupObjectSelectorHelper;

public class ObjectSelectorHelper {
	
	public static boolean isMulti(Component comp){
		if (comp instanceof Listbox)
			return ((Listbox)comp).isMultiple();
		return false;
	}
	
	public static void setPk(Component comp, Integer pk){
		if (comp instanceof IObjectSelector)
			((IObjectSelector)comp).setPk(pk);
		else if (comp instanceof Combobox)
			ComboboxObjectSelectorHelper.setPk((Combobox)comp, pk);
		else if (comp instanceof Listbox)
			ListboxObjectSelectorHelper.setPk((Listbox)comp, pk);
		else if (comp instanceof Radiogroup)
			RadioGroupObjectSelectorHelper.setPk((Radiogroup)comp, pk);
		else if (comp instanceof Intbox)
			((Intbox)comp).setValue(pk);
		else
			throw new RuntimeException("Object of type: " + comp.getClass().getName() + " not handled by Object selector helper");
	}

	public static Integer getPk(Component comp){
		if (comp instanceof IObjectSelector)
			return ((IObjectSelector)comp).getPk();
		else if (comp instanceof Combobox)
			return ComboboxObjectSelectorHelper.getPk((Combobox)comp);
		else if (comp instanceof Listbox)
			return ListboxObjectSelectorHelper.getPk((Listbox)comp);
		else if (comp instanceof Radiogroup)
			return RadioGroupObjectSelectorHelper.getPk((Radiogroup)comp);
		else if (comp instanceof Intbox)
			return ((Intbox)comp).getValue();
		else
			throw new RuntimeException("Object of type: " + comp.getClass().getName() + " not handled by Object selector helper");
	}

	public static Vector<Integer> getPks(Component comp){
		Vector<Integer> pks = new Vector<Integer>();
		if (isMulti(comp)){
			if (comp instanceof Listbox)
				return ListboxObjectSelectorHelper.getPks((Listbox)comp);
		}
		else{
			Integer pk = getPk(comp);
			if (null != pk)
				pks.add(pk);
		}
		return pks;
	}

	public static Vector<Integer> setPks(Component comp, Vector<Integer> pks){
		if (isMulti(comp)){
			if (comp instanceof Listbox)
				ListboxObjectSelectorHelper.setPks((Listbox)comp, pks);
		}
		return pks;
	}
	
	public static void setField(Component comp, MTField field){
		if (comp instanceof IObjectSelector)
			((IObjectSelector)comp).setField(field);
		else if (comp instanceof Combobox){
			ComboboxObjectSelectorHelper.buildObjectList((Combobox)comp, field.getForeignKey());
			ComboboxObjectSelectorHelper.setBlankItem((Combobox)comp,field); 
		}else if (comp instanceof Listbox){
			ListboxObjectSelectorHelper.buildObjectList((Listbox)comp, field.getForeignKey());
		}else if (comp instanceof Radiogroup){
			RadioGroupObjectSelectorHelper.buildObjectList((Radiogroup)comp, field.getForeignKey());
		}else if (comp instanceof Intbox){
			return;
		}
		else
			throw new RuntimeException("Object of type: " + comp.getClass().getName() + " not handled by Object selector helper");
	}
	
	public static void setTable(Component comp, MTTable table){
		if (comp instanceof IObjectSelector)
			((IObjectSelector)comp).setTable(table);
		else if (comp instanceof Combobox)
			ComboboxObjectSelectorHelper.buildObjectList((Combobox)comp, table);
		else if (comp instanceof Listbox)
			ListboxObjectSelectorHelper.buildObjectList((Listbox)comp, table);
		else if (comp instanceof Radiogroup)
			RadioGroupObjectSelectorHelper.buildObjectList((Radiogroup)comp, table);
		else
			throw new RuntimeException("Object of type: " + comp.getClass().getName() + " not handled by Object selector helper");
	}
	
	public static String buildObjectListSql(MTTable table){
		String sql = "select ";
		sql += table.getPrimaryKey();
		sql += ",";
		if (null == table.getIdField())
			throw new RuntimeException("Can't find id field for table: " + table);
		sql += table.getIdField().getName();
		sql += " from " + table.getTableName();
		sql += " where (1=1)";
		
		return sql;
	}
	
	public static LinkedHashMap<Integer, String> buildObjectList(MTTable mtTable){
		if (mtTable.getIsEnumeration())
			return mtTable.getEnumeration().getHashmap();
		else{
			LinkedHashMap<Integer, String> values = new LinkedHashMap<Integer, String>();
			String sql = buildObjectListSql(mtTable);
			try{
				Connection conn = MainDb.getConnection();
				try{
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()){
						values.put(rs.getInt(1), rs.getString(2));
					}
					rs.close();
					conn.close();
				}
				finally{
					conn.close();
				}
			}
			catch (SQLException e){
				throw new RuntimeException(e.toString() + " while running sql " + sql);
			}
			return values;
		}
			
	}
	
}