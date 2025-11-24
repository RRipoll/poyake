package com.etantolling.testrunner.test.zkweb.forms;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import org.zkoss.zhtml.Td;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import com.etantolling.testrunner.test.core.db.DataGridQuery;
import com.etantolling.testrunner.test.core.db.DetachedRow;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.MTEnumeration;
import com.etantolling.testrunner.test.core.utils.DataFormatter;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.test.zkweb.IPanel;
import com.etantolling.testrunner.test.zkweb.datagrid3.filter.items.BandboxFilter;
import com.etantolling.testrunner.test.zkweb.datagrid3.filter.items.IFilter;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.comboobjectselector.ComboboxObjectSelectorHelper;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class ZulDataWirerSql {
	
	//private static Logger log = Logger.getLogger(ZulDataWirerSql.class);

	   public static Vector<LinkedHashMap<String, Object>> initializeFieldValues (String sql, Component parent, String attributeName,String attributeValue,String dataGridQueryID) throws WrongValueException, SQLException{
			
			Connection conn= MainDb.getConnection();
			DataGridQuery query=null;
			try{
				 query= new DataGridQuery(conn, sql,null,DesktopHelper.getMetaDataSql(DataGridQuery.getMetaName(dataGridQueryID,sql)));
				 DesktopHelper.setMetaDataSql(DataGridQuery.getMetaName(dataGridQueryID,sql), query.getInitialMetaData());
				 
				 Vector<LinkedHashMap<String, Object>>rows=initializeFieldValues (conn,query,parent,attributeName,attributeValue);
				 return rows;
			}
			finally{
				conn.close();
			}
	   }
	   
	   public static Vector<LinkedHashMap<String, Object>> initializeFieldValues (String sql, Component parent, String attributeName,String attributeValue) throws WrongValueException, SQLException{
		   return initializeFieldValues (sql, parent, attributeName,attributeValue,null);
			
	  }
		
		public static Vector<LinkedHashMap<String, Object>> initializeFieldValues (Connection conn,DataGridQuery query, Component parent, String attributeName,String attributeValue) throws WrongValueException, SQLException{
			if(null==query || null==parent)return null;
			
			if(null==attributeName)attributeName="field";
			Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(parent, attributeName, attributeValue);
			Vector<LinkedHashMap<String, Object>> rows=query.getPage(conn, 0);
			LinkedHashMap<String, Object> row=null;
			if(rows.size()>0){
				initializeFieldValues(rows.get(0), components, "field");
				row=rows.get(0);
			}else{ 
				for (Component comp : components) {
					fillFilter(comp);
				}
				
			}
			hideHtmlNullValues(parent,components,row);
			return rows;
		}
			
		private static void hideHtmlNullValues(Component parent, Vector<Component> components, LinkedHashMap<String, Object>row) {
			
			Vector<Component> placeHolders = ComponentTreeTransverser.getComponentsByAttributeValue(parent, "placeHolder",null);
			if(null!=parent.getAttribute("placeHolder")) placeHolders.add(parent);
			if(placeHolders.size()>0){
				for (Component ph:placeHolders){
					String phNameField=(String) ph.getAttribute("placeHolder");
					if(null!=phNameField){
						for (Component comp:components){
							String nameField=(String) comp.getAttribute("field");
							if((phNameField.equals(nameField) && null==comp.getAttribute("rawValue") && null!=row && row.containsKey(phNameField)) || null==row){
								ph.setVisible(false);
								break;
							}else if(phNameField.equals(nameField) && null!=row && row.containsKey(phNameField))
								ph.setVisible(true);
							}
						}		
					}
				}
			}

		public static void initializeFieldValues(LinkedHashMap<String, Object> row,Vector<Component> components, String attributeName) throws SQLException {
			for (Component comp:components){
				if(null!=comp.getAttribute(attributeName)){
					if(row.containsKey(comp.getAttribute(attributeName))){
						Object rowValue=row.get(comp.getAttribute(attributeName));
						setValue(comp,rowValue);
						comp.setAttribute("rawValue",rowValue);
						}
					}
				}
			}

		public static void initializeFieldValues(LinkedHashMap<String, Object> row,Component component) throws SQLException {
			Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(component, "field", null);
			
			initializeFieldValues(row,components, "field");
		}
		
		
		public static void initializeFieldValues(LinkedHashMap<String, Object> row,Vector<Component> components) throws SQLException {
			initializeFieldValues(row,components, "field");
		}

		public static void readFormFieldValues(DetachedRow detachedRow, Component parent){
			Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(parent, "field", null);
			readFormFieldValues(detachedRow, components);
		}
		
		static void readFormFieldValues(DetachedRow detachedRow, Vector<Component> components){
			for (Component comp:components){
				String field = (String) comp.getAttribute("field");
				if (null != field){
					readValue(comp, detachedRow, field);
				}
			}
		}
		
		private static void readValue(Component comp, DetachedRow dRecord, String field){
			if (comp instanceof Combobox){
				if(null!=((Combobox)comp).getSelectedItem()){
					dRecord.set(field, ((Combobox)comp).getSelectedItem().getValue());
				}else if(null!=((Combobox) comp).getValue() && ((Combobox) comp).getValue().trim().length()>0)
					dRecord.set(field, ((Combobox) comp).getValue());
			}
			else if (comp instanceof Textbox){
				dRecord.set(field, ((Textbox)comp).getValue());
			}
			else if (comp instanceof Checkbox){
					Integer value = (((Checkbox)comp).isChecked()?1:0);
					dRecord.set(field, value);
			}
			else if (comp instanceof Radiogroup)
				dRecord.set(field, (((Radiogroup)comp).getSelectedItem().getValue()));
			else if (comp instanceof Intbox)
				dRecord.set(field, ((Intbox)comp).getValue());
			else if (comp instanceof Decimalbox)
				dRecord.set(field, ((Decimalbox)comp).getValue());
			else if (comp instanceof Datebox)
				dRecord.set(field,  ((Datebox)comp).getValue());
				
			/*
			else if (comp instanceof CKeditor){
				dRecord.set(mtField, ((CKeditor)comp).getValue());
			}
			*/
			
		}
		
		
		
		public static boolean fillFilter(Component panel,String attributeName, String attributeValue ) throws SQLException {
			if(null==panel)return false;
	    	Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(panel, attributeName,attributeValue);
				boolean retValue=false;
				for (Component comp : components) {
					comp.setAttribute("initialParameters",panel.getAttribute("initialParameters") );
					retValue= fillFilter( comp) || retValue;
				}
				return retValue;
			
		}
		
		@SuppressWarnings("unchecked")
		public static boolean fillFilter(Component comp) throws SQLException  {
			if(null!=comp.getAttribute("enumerationsql") || null!=comp.getAttribute("enumeration") || null!=comp.getAttribute("values")){
				
				Connection conn=null;
				try {
					conn = MainDb.getConnection();
				} catch (Exception e) {
					;
				}
				
				try{
					if(null!=comp.getAttribute("enumerationsql")){
						Hashtable<String,Object> initialParameters=null;
						if(null!=comp.getAttribute("initialParameters")){
							initialParameters=(Hashtable<String, Object>) comp.getAttribute("initialParameters");
						}
						fillEnumerationBySql(conn,comp,(String)comp.getAttribute("enumerationsql"),comp.getAttribute("selectedValues"),initialParameters);
					}
					else if(null!=comp.getAttribute("enumeration")){
						fillEnumeration((Combobox) comp,(String)comp.getAttribute("enumeration"),comp.getAttribute("selectedValues"));
					}
					else if(null!=comp.getAttribute("values")){
						Hashtable<String,Object> initialParameters=null;
						if(null!=comp.getAttribute("initialParameters")){
							initialParameters=(Hashtable<String, Object>) comp.getAttribute("initialParameters");
						}
						Map<String, String> values=null;
						if(comp.getAttribute("values") instanceof Map )
							values=(Map<String, String>) comp.getAttribute("values");
						else {
							values=(Map<String, String>) DesktopHelper.getAttribute((String)comp.getAttribute("values"));
						}
							fillEnumerationHash(conn,comp,values,comp.getAttribute("selectedValues"),initialParameters);
					}
				}finally{if(null!=conn)conn.close();}
				return true;
			}
			return false;
		}
		
	    static public Object fillEnumerationBySql(Connection conn,Component com,String sql,Object selectedValue,Hashtable<String,Object> initialParameters) throws SQLException{
	    	
	    	Object selectedItem = null;
	    	
	    	if(com instanceof IPanel){
	    		((IFilter)com).setSelectedValue(selectedValue);
	    		((IPanel)com).layout();
	    	}
	    	else if(com instanceof Combobox){
	    		NamedParameterStatement st=new NamedParameterStatement(conn, sql);
				if(null!=initialParameters && initialParameters.size()>0)st.setParameters(initialParameters);
				try{
					ResultSet rs= st.executeQuery();
					com.getChildren().clear();
					Comboitem item = new Comboitem("");
					item.setValue("");
					item.setParent(com);

					while (rs.next()){
						item = new Comboitem(rs.getString("label"));
						if (rs.getObject("value") instanceof BigDecimal)
							item.setValue(rs.getInt("value"));
						else
							item.setValue(rs.getObject("value"));
						if(null!=selectedValue && selectedValue instanceof Integer  && rs.getInt("value")==((Integer)selectedValue).intValue())selectedItem=item;
						if(null!=selectedValue && selectedValue instanceof String  && rs.getString("value").equals(selectedValue.toString()))selectedItem=item;
						item.setParent(com);
					}
					((Combobox)com).setSelectedItem((Comboitem) selectedItem);
					st.close();
				}
				catch(SQLException e){
					//log.error("SQL Exception while running query: " + sql);
					throw e;
				}
	    	}
	    	else if(com instanceof Bandbox){
	    		BandboxFilter bandboxFilter=new BandboxFilter(com,sql,selectedValue,initialParameters);
	    		selectedItem=bandboxFilter.getSelectedItem();
	    	}
	    	
	    	return selectedItem;
	    }
		
	static public Object fillEnumerationHash(Connection conn,Component com,Map<String,String>vector,Object selectedValue,Hashtable<String,Object> initialParameters) throws SQLException{
	    	
	    	Object selectedItem = null;
	    	if(null==vector)return null;
			
	    	if(com instanceof Combobox){
	    		com.getChildren().clear();
				for ( String key : vector.keySet()) {
					Comboitem item = new Comboitem(vector.get(key));
					item.setValue(key);
					if(null!=selectedValue && selectedValue instanceof String  && key.equals(selectedValue.toString()))selectedItem=item;
					item.setParent(com);
				}
	    	}
	    	if(com instanceof Bandbox){
	    		BandboxFilter bandboxFilter=new BandboxFilter(com,vector,selectedValue,initialParameters);
	    		selectedItem=bandboxFilter.getSelectedItem();
	    	}
	    	return selectedItem;
	    }
	    
	    
	    
	    static public Comboitem fillEnumeration(Combobox com,String enumName,Object selectedValue) throws SQLException{
	    	Comboitem selectedItem=null;
				MTEnumeration enu= MT.getEnum(enumName);
				if(null!=enu)
					for (Integer key : enu.getKeys()) {
						Comboitem item = new Comboitem(enu.getValue(key));
						if(key instanceof Integer)
							item.setValue((Integer)key);
						else item.setValue(key.toString());
					
						if(null!=selectedValue){
							if(null!=selectedValue && selectedValue instanceof Integer	&& ((Integer)key).intValue()==((Integer)selectedValue).intValue())selectedItem=item;
							if(null!=selectedValue && selectedValue instanceof String && key.toString().equals(selectedValue.toString()))selectedItem=item;
						}
						item.setParent(com);
					}
				com.setSelectedItem(selectedItem);
				return selectedItem;
	    }
	    
		
		
		
		@SuppressWarnings("unchecked")
		private static void setValue(Component comp, Object rowValue) throws SQLException {
			if(null==rowValue)return;
			String value=DataFormatter.formatValue(rowValue,(String)comp.getAttribute("format"));
			if(comp instanceof Combobox){
				if(null!=comp.getAttribute("enumerationsql")){
					try(Connection conn=MainDb.getConnection()){
						fillEnumerationBySql(conn,(Combobox) comp,(String)comp.getAttribute("enumerationsql"),rowValue,(Hashtable<String, Object>) comp.getAttribute("initialParameters"));
					}
				}else if(null!=comp.getAttribute("enumeration")){
					fillEnumeration((Combobox) comp,(String)comp.getAttribute("enumeration"),rowValue);
				}else if(null!=rowValue) {
					if(rowValue instanceof Integer)ComboboxObjectSelectorHelper.setPk((Combobox)comp, (Integer)rowValue);
					if(rowValue instanceof String)ComboboxObjectSelectorHelper.setPk((Combobox)comp, (String)rowValue);
				}
			}else if (comp instanceof Textbox){
				((Textbox)comp).setValue(value);
			}
			else if (comp instanceof Label){
				((Label)comp).setValue(value);
			}
			else if (comp instanceof Div){
				new Html(value).setParent(comp);
			}
			else if (comp instanceof Td){
				comp.getChildren().clear();
					new Html(value).setParent(comp);
			}
			else if (comp instanceof Intbox)
				((Intbox)comp).setValue(new Integer(value) );
			else if (comp instanceof Decimalbox)
				((Decimalbox)comp).setValue((new BigDecimal(value)));
			else if (comp instanceof Datebox){
				//Date date=new Date(value);
				((Datebox)comp).setValue((Date)rowValue);
			}
		}
		
		
		
	}