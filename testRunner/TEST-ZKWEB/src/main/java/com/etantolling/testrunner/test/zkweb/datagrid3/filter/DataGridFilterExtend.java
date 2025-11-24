
package com.etantolling.testrunner.test.zkweb.datagrid3.filter;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.zkweb.datagrid3.filter.items.IFilter;
import com.etantolling.testrunner.test.zkweb.forms.ZulDataWirerSql;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;



public class DataGridFilterExtend extends DataGridFilter {
	
	private static final Logger log = LoggerFactory.getLogger(DataGridFilterExtend.class);
	private static final long serialVersionUID = -3986027941495878877L;
	public Component panel;

	public DataGridFilterExtend(Component panel, String cssClass) throws SQLException {
		super( cssClass);
		this.panel=panel;
		ZulDataWirerSql.fillFilter(panel, "type","FILTER");
	}
	
	@Override 
	public void onEvent(Event event) throws Exception {
			Events.postEvent(new Event("onFilterChanged", this, null));
	}

	@Override
	public String buildWhereClause()   {
		parameters= new Hashtable <String,Object>();
			parameters.put("versionDate", EnvironmentHelper.getVersionTimeStamp());
		HashMap<String,String> groupWhere= new HashMap<String,String>(); 
		if(null==panel)return "";
		Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(panel, "type","FILTER");
		String retValue="  ";
		int i=0;
		for (Component component : components) {
			
			String whereClause=null;
			String field=null;
			String where=null;
			String componentId=component.getId();
			
			if(component.hasAttribute("whereclause"))whereClause=  StringEscapeUtils.unescapeHtml4(component.getAttribute("whereclause").toString());
			if(component.hasAttribute("field"))field=(String)component.getAttribute("field");
			if(null==component.getId() || 0==component.getId().length())componentId=field+i++;
			if(component.hasAttribute("where")){
				where=component.getAttribute("where").toString().trim();
				if(where.equals("e"))where ="=";
				else if (where.equals("ge"))where =">=";
				else if (where.equals("le"))where ="<=";
				else if (where.equals("lt"))where ="<";
				else if (where.equals("gt"))where =">";
				else where=  StringEscapeUtils.unescapeHtml4(component.getAttribute("where").toString().trim().toUpperCase()); //sensitive Case
			}
			
			if(component instanceof IFilter ){
				retValue+=getWhereIFilter((IFilter)component, componentId, parameters,field,where, whereClause);
			
			}else if(null!=component.getAttribute("controller") && component.getAttribute("controller") instanceof IFilter ){
				retValue+=getWhereIFilter((IFilter)component.getAttribute("controller"), componentId, parameters,field,where, whereClause);

			}else if(component instanceof Combobox){
				retValue+=getWhereCombobox(component, componentId, parameters,field,where, whereClause);
			
			}else if(component instanceof Textbox  || (null!=component.getAttribute("cast") && component.getAttribute("cast").equals("string") )){
				retValue+=getWhereTextbox(component, componentId, parameters, field, where, whereClause);

			}else if(component instanceof Intbox && null!=((Intbox)component).getValue()){
				retValue+=getWhereIntbox(component, componentId, parameters,field,where, whereClause);

			}else if(component instanceof Decimalbox && null!=((Decimalbox)component).getValue()){
				retValue+=getWhereDecimalbox(component, componentId, parameters,field,where, whereClause);

			}else if(component instanceof Datebox && null!=((Datebox)component).getValue()){
				retValue+=getWhereDatebox(component, componentId, parameters,field,where, whereClause);

			}else if(component instanceof Checkbox && ((Checkbox)component).isChecked() ){
				retValue+=getWhereCheckbox(groupWhere,component, componentId, parameters,field, whereClause);
			}		
		}
		for(String groupId:groupWhere.keySet()){
			retValue+=" and ( "+groupWhere.get(groupId)+" ) ";
		}
		return retValue;
	}
	
	 String getWhereCheckbox(HashMap<String,String> groupWhere,Component component, String componentId, Hashtable<String, Object> parameters,String field, String whereClause) {
		
		String retValue="";
		 String tmpValue="";
		String operator=" ";
		String where=null;
		if(component.hasAttribute("where"))where=StringEscapeUtils.unescapeHtml4(component.getAttribute("where").toString().trim());
		
		 if(component.hasAttribute("operator")){
			if(component.hasAttribute("groupid")){
				if(null!=groupWhere.get((String)component.getAttribute("groupid")))
					operator=" "+component.getAttribute("operator")+" ";
			}else operator=" "+component.getAttribute("operator")+" ";
		}else operator=" and ";
		if(null!=where)
			tmpValue+= field+" "+where;
		else {
			tmpValue+= field+" = "+((Checkbox)component).getValue();
		}
		if(null!=whereClause) tmpValue+= "  "+whereClause+ " ";

		tmpValue=operator+ " ("+tmpValue+")";
		
		if(component.hasAttribute("groupid")){
			if(groupWhere.containsKey((String)component.getAttribute("groupid"))){
				groupWhere.put((String)component.getAttribute("groupid"),groupWhere.get((String)component.getAttribute("groupid"))+" "+ tmpValue+" "); 
			}else{
				groupWhere.put((String)component.getAttribute("groupid")," "+ tmpValue+" ");
			}
		}else{ 
			retValue+=tmpValue;
		}
		parameters.put(componentId, new Integer(1));
		
		return retValue;
	}

	 private String getWhereTextbox(Component component, String componentId, Hashtable<String, Object> parameters,String field, String where, String whereClause) {
		 
		  	String value=null;
		  	
			if(component instanceof Textbox){	
				value=((Textbox)component).getValue();
				if(null!=value && value.trim().length()>0)
					value=((Textbox)component).getValue().trim().toUpperCase();//sensitive Case
			}else if(component instanceof Intbox){	
				if(null!=((Intbox)component).getValue())
					value=((Intbox)component).getValue().toString().trim();
			}else if(component instanceof Decimalbox){
				if(null!=((Decimalbox)component).getValue())
					value=((Decimalbox)component).getValue().toString().trim();
			}else{return "";}
			
			if(null==value || value.length()==0)  return "";
			
			if(component.hasAttribute("format") && component.getAttribute("format").toString().equals("phone")){
				try {
					value+="*";
					//value= MiscUtility.formatPhoneNumberToDb((String) value);
				} catch (Exception e) {					log.error("ERROR STACKTRACE: ", e);				}
			}
		 
			String retValue=" and ";
			
			String operator="=";
			
			if(null==where  || where.equals("like".toUpperCase())) {
				if(value.contains("*")){
					operator=" like "+ wildCard(value,componentId);
					parameters.put(componentId, value.replace("*", ""));
					retValue+= " upper("+field+") "+operator;
				}else{
					retValue+= " upper("+field+") like :"+componentId;
					parameters.put(componentId, "%"+value+"%");
				}
			}else { 
				retValue+= where;
				retValue =  retValue.replace("###VALUE###", ":"+componentId);
				if(where.contains("###LIKEVALUE###")){
					String likevalue=(value.contains("*")?" like ":" = ")+wildCard(value,componentId);
					retValue =  retValue.replace("###LIKEVALUE###", likevalue);
				}
				parameters.put(componentId, value.replace("*", ""));
			}
			if(null!=whereClause) retValue+= "  "+whereClause + "  ";
	 return retValue;
	 }

	private String wildCard(String value,String componentId) {
		String retValue=":"+componentId;
		if(value.startsWith("*"))retValue=" '%' ||"+retValue ;
		if(value.endsWith("*"))retValue=retValue+"||'%'";
		return retValue;
	}

	private String getWhereDatebox(Component component, String componentId, Hashtable<String, Object> parameters,String field, String where, String whereClause) {
		
		String retValue=" and ";
		
		if(null==field && null!=where)
			retValue+=  where.replace("###VALUE###", ":"+componentId);
		else{
			if(component.hasAttribute("time") || component.hasAttribute("datetime")){
				retValue+= field+" "+(null==where?"=":where)+" :"+componentId+" ";
			}else{
				retValue+= " trunc("+field+") "+(null==where?"=":where)+" trunc(:"+componentId+")";
			}
		}
		parameters.put(componentId, ((Datebox)component).getValue());
		if(null!=whereClause) retValue+= "  "+whereClause + "  ";
		return retValue;
	}

	private String getWhereDecimalbox(Component component, String componentId, Hashtable<String, Object> parameters,String field, String where, String whereClause) {
		String retValue=" and ";
		if(null==field && null!=where)
			retValue+=  where.replace("###VALUE###", ":"+componentId);
		else
			retValue+= field+" "+(null==where?"=":where)+" :"+componentId;
		parameters.put(componentId, ((Decimalbox)component).getValue());
		if(null!=whereClause) retValue+= "  "+whereClause + "  ";// TODO Auto-generated method stub
		return retValue;
	}

	public String getWhereIFilter(IFilter component,String componentId,Hashtable <String,Object> parameters,String field,String where,String whereClause ){
		String retValue=component.buildWhereClause(componentId,parameters);
		if(null!=whereClause) retValue+= "  "+whereClause + "  ";
		return retValue;
	}

	public String getWhereIntbox(Component component,String componentId,Hashtable <String,Object> parameters,String field,String where, String whereClause ){
		String retValue=" and ";
		if(null!=where) where=where.replace("###VALUE###", ":"+componentId);
		if(null==field && null!=where){
			retValue+=  where;
		}else{
			retValue+= field+" "+(null==where?"=":where)+" :"+componentId;
		}
		parameters.put(componentId, ((Intbox)component).getValue());
		if(null!=whereClause) retValue+= "  "+whereClause + "  ";
		
		return retValue;
	}
	
	public String getWhereCombobox(Component component,String componentId,Hashtable <String,Object> parameters,String field,String where, String whereClause ){
		Object value=null;
		String retValue="";
		if(null!=((Combobox)component).getSelectedItem()) value=((Combobox)component).getSelectedItem().getValue();
		if(null!=value && value.toString().equals("NULL")) return "";
		
		if(null!=((Textbox)component).getValue() && ((Textbox)component).getValue().trim().length()>0){
			
			if(null==value  || (value instanceof String && ((String)value).length()==0)){
				value=((Textbox)component).getValue();
				if(null!=value)value=((String) value).trim().toUpperCase();//sensitive Case
			} 
			if(null!=value){
				retValue+=" and ";
				//String operator="=";
				if(null!=field){
					retValue+= " "+field+" =:"+componentId;
					parameters.put(componentId, value);
				}
				if(null!=where){
					value=value.toString();
					retValue+= where.replace("###VALUE###", ":"+componentId);
					parameters.put(componentId, value);
					}
				}
			if(null!=whereClause){ 
				retValue+= "  "+whereClause.replace("###VALUE###",  ":"+componentId);
				parameters.put(componentId, value.toString());
			}
		}
		return retValue;
	}
	
	static public void reset(Component com){
    	Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(com, "type","FILTER");
		for (Component component : components) {
			if(component instanceof Textbox)((Textbox) component).setValue(null);
			else if(component instanceof Intbox)((Intbox) component).setValue(null);
			else if(component instanceof Decimalbox)((Decimalbox) component).setValue((BigDecimal) null);
			else if(component instanceof Datebox)((Datebox) component).setValue(null);
			else if(component instanceof Checkbox)((Checkbox) component).setChecked(false);
		}
    }
	
    public void reset(){
    	Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(panel, "type","FILTER");
		for (Component component : components) {
			if(component instanceof Textbox)((Textbox) component).setValue(null);
			else if(component instanceof Intbox)((Intbox) component).setValue(null);
			else if(component instanceof Decimalbox)((Decimalbox) component).setValue((BigDecimal) null);
			else if(component instanceof Datebox)((Datebox) component).setValue(null);
			else if(component instanceof Checkbox)((Checkbox) component).setChecked(false);
		}
    }
    
    public Vector<LinkedHashMap<String, String>> buildHeaderXSL() throws SQLException {
		Vector<LinkedHashMap<String, String>> header= new Vector<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> rowString= new LinkedHashMap<String, String>();
		header.add(rowString);
		return header;
    }
 }