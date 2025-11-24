package com.etantolling.testrunner.test.zkweb.datagrid3ws.filter;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.apache.commons.lang3.StringEscapeUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;

import com.etantolling.testrunner.test.zkweb.datagrid3.filter.items.IFilter;
import com.etantolling.testrunner.test.zkweb.forms.ZulDataWirerSql;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class DataGridFilterExtend extends DataGridFilter {
	
	//private static final Logger log = LoggerFactory.getLogger(DataGridFilterExtend.class);
	
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
		HashMap<String,String> groupWhere= new HashMap<String,String>(); 
		if(null==panel)return "";
		Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(panel, "type","FILTER");
		String retValue="  ";
		int i=0;
		for (Component component : components) {
			String whereClause=null;
			if(null!=component.getAttribute("whereclause"))whereClause=  StringEscapeUtils.unescapeHtml4(component.getAttribute("whereclause").toString());
			String componentId=component.getId();
			if(null==component.getId() || 0==component.getId().length())componentId=(String) component.getAttribute("field")+i++;
			
			if(component instanceof IFilter ){
				retValue+=((IFilter)component).buildWhereClause(componentId,parameters);
				if(component.hasAttribute("whereclause")) retValue+= "  "+whereClause + "  ";
			}
			
			else if(null!=component.getAttribute("controller") && component.getAttribute("controller") instanceof IFilter ){
				IFilter filterItem= (IFilter) component.getAttribute("controller");
				retValue+=filterItem.buildWhereClause(componentId,parameters);
				if(component.hasAttribute("whereclause")) retValue+= "  "+whereClause + "  ";


			}else if(component instanceof Combobox){
				Object value=null;
				if(null!=((Combobox)component).getSelectedItem()) value=((Combobox)component).getSelectedItem().getValue();
				if(null!=value && value.toString().equals("NULL")) continue;
				
				if(null!=((Textbox)component).getValue() && ((Textbox)component).getValue().trim().length()>0){
					if(null==value  || (value instanceof String && ((String)value).length()==0)){
						value=((Textbox)component).getValue();
						if(null!=value)value=((String) value).trim();
					} 
					if(null!=value){
						retValue+=" and ";
						//String operator="=";
						if(null!=component.getAttribute("field")){retValue+= " "+component.getAttribute("field")+" =:"+componentId;
						parameters.put(componentId, value);
						}
						if(null!=component.getAttribute("where"))retValue+= component.getAttribute("where").toString().replace("###VALUE###", value.toString());
						
						
						
						}
					if(component.hasAttribute("whereclause")) retValue+= "  "+whereClause.replace("###VALUE###",  value.toString());
				}
			}
			
			else if(
					(null!=component.getAttribute("cast") && component.getAttribute("cast").equals("string") ) 
					||   
					( component instanceof Textbox && null!=((Textbox)component).getValue() && ((Textbox)component).getValue().trim().length()>0)){
				
				String value=null;
				
				if(component instanceof Textbox){	
					value=((Textbox)component).getValue().trim();
				}else if(component instanceof Intbox){	
					if(null!=((Intbox)component).getValue())
						value=((Intbox)component).getValue().toString().trim();
				}else if(component instanceof Decimalbox){
					if(null!=((Decimalbox)component).getValue())
						value=((Decimalbox)component).getValue().toString().trim();
				}else{
					continue;
				}
				
				
				if(null==value || value.length()==0)  continue;
				retValue+=" and ";
				String operator="=";
				if(component.hasAttribute("where")) {
					if(((String) component.getAttribute("where")).trim().startsWith("like")){
						String whereAttribute=(String) component.getAttribute("where");
						if(whereAttribute.contains("###VALUE###")){
							operator=" like :"+componentId;
							parameters.put(componentId, whereAttribute.replace("###VALUE###", value.toUpperCase()));
							retValue+= " upper("+component.getAttribute("field")+") "+operator;
						}else{
							operator=" like :"+componentId;
							parameters.put(componentId, value.toUpperCase());
							retValue+= " upper("+component.getAttribute("field")+") "+operator;
						}
					}else { 
						retValue+=  (StringEscapeUtils.unescapeHtml4((String) component.getAttribute("where"))).replace("###VALUE###", value.toUpperCase());
						parameters.put(componentId, value.toUpperCase());}
				}else{ 
					retValue+= " upper("+component.getAttribute("field")+") =:"+componentId;
					parameters.put(componentId, value.toUpperCase());
				}
				if(component.hasAttribute("whereclause")) retValue+= "  "+whereClause + "  ";

			}else if(component instanceof Intbox && null!=((Intbox)component).getValue()){
				retValue+=" and ";
				String operator="=";
				if(component.hasAttribute("where")){
					String whereAttribute=(String) component.getAttribute("where");
					operator=whereAttribute.replace("ge",">=").replace("le", "<=").replace("lt", "<").replace("gt", ">");
				}
				retValue+= component.getAttribute("field")+" "+operator+" :"+componentId;
				parameters.put(componentId, ((Intbox)component).getValue());
				if(component.hasAttribute("whereclause")) retValue+= "  "+whereClause + "  ";

			}else if(component instanceof Decimalbox && null!=((Decimalbox)component).getValue()){
				retValue+=" and ";
				String operator="=";
				if(component.hasAttribute("where")){
					String whereAttribute=(String) component.getAttribute("where");
					operator=whereAttribute.replace("ge",">=").replace("le", "<=").replace("lt", "<").replace("gt", ">");
				}
				retValue+= component.getAttribute("field")+" "+operator+" :"+componentId;
				parameters.put(componentId, ((Decimalbox)component).getValue());
				if(component.hasAttribute("whereclause")) retValue+= "  "+whereClause + "  ";

			}else if(component instanceof Datebox && null!=((Datebox)component).getValue()){
				retValue+=" and ";
				String operator="=";
				if(component.hasAttribute("where")){
					String whereAttribute=(String) component.getAttribute("where");
					operator=whereAttribute.replace("ge",">=").replace("le", "<=").replace("lt", "<").replace("gt", ">");
				}
				retValue+= component.getAttribute("field")+" "+operator+" :"+componentId;
				parameters.put(componentId, ((Datebox)component).getValue());
				if(component.hasAttribute("whereclause")) retValue+= "  "+whereClause + "  ";

			}else if(component instanceof Checkbox && ((Checkbox)component).isChecked() ){
				String tmpValue="";
				if(component.hasAttribute("operator")){
					if(component.hasAttribute("groupid")){
						if(null!=groupWhere.get((String)component.getAttribute("groupid")))
							tmpValue+=" "+component.getAttribute("operator")+" ";
					}else tmpValue+=" "+component.getAttribute("operator")+" ";
				}else tmpValue+=" and ";
				if(component.hasAttribute("where"))
					tmpValue+= component.getAttribute("field")+" "+component.getAttribute("where");
				else {
					tmpValue+= component.getAttribute("field")+" = "+((Checkbox)component).getValue();
				}
				if(component.hasAttribute("whereclause")) tmpValue+= "  "+whereClause+ " ";

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
			}
				

		}
		for(String groupId:groupWhere.keySet()){
			retValue+=" and ( "+groupWhere.get(groupId)+" ) ";
		}
		
		
		return retValue;
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