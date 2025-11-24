package com.etantolling.testrunner.test.zkweb.datagrid3.filter.items;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Bandpopup;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;
import com.etantolling.testrunner.test.zkweb.IPanel;


public class BandboxFilter implements Composer<Component>,EventListener<Event>,IPanel,IFilter {

	
	
	private Bandbox bandbox;
	private Bandpopup bandpopup;
	private Listbox listbox;
	public Vector<Checkbox> vectorCheckBox = new Vector<Checkbox>();
	private Hashtable<String, Object> initialParameters;
	private String sql;
	private Object selectedValue;
	private Map<String,String> dataVector;
	private boolean showValue=true;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		
		this.bandbox=(Bandbox) comp;
		this.initialParameters=(Hashtable<String, Object>) comp.getAttribute("initialParameters");
		this.sql=(String) comp.getAttribute("enumerationsql");
		this.selectedValue=comp.getAttribute("selectedValue");
		init();
			
	}
	
	public void init(){
		
		bandbox.setAttribute("controller", this);
		bandbox.getChildren().clear();
			
		bandpopup= new Bandpopup();
		bandpopup.setStyle("overflow:hiden");
		bandpopup.setHflex("min");
		bandpopup.setVflex("min");
		
		bandpopup.setParent(bandbox);
		
		listbox = new Listbox();
		listbox.setHflex("min");
		listbox.setVflex("min");
		
		listbox.setParent(bandpopup);
		
		
		
	}
	
	
	
	public BandboxFilter(Component bandbox, String sql, Object selectedValue,
				Hashtable<String, Object> initialParameters) throws SQLException {
		
	this.bandbox=(Bandbox) bandbox;
	this.initialParameters=initialParameters;
	this.sql=sql;
	this.selectedValue=selectedValue;
	
	init();
	
	layout();	
	
	}
	
	public BandboxFilter(Component bandbox, Map<String,String> dataVector, Object selectedValue,
			Hashtable<String, Object> initialParameters) throws SQLException {

		this.bandbox=(Bandbox) bandbox;
		this.initialParameters=initialParameters;
		this.selectedValue=selectedValue;
		this.dataVector=dataVector;
		
		bandbox.setAttribute("controller", this);
		bandbox.getChildren().clear();
		
		bandpopup= new Bandpopup();
		bandpopup.setParent(bandbox);
		bandpopup.setStyle("overflow:hiden");
		bandpopup.setHflex("min");
		bandpopup.setVflex("min");
		
		listbox = new Listbox();
		listbox.setParent(bandpopup);
		listbox.setHflex("min");
		listbox.setVflex("min");

		layout();

}

	@Override
	public void onEvent(Event event) throws Exception {
		
		Checkbox chk = (Checkbox) event.getTarget();
		String code =  chk.getAttribute("code").toString();
		String valueShown="";
		
		for (Checkbox item : vectorCheckBox) {
			if (item.isChecked()) {
				if (valueShown.length() > 0)
					valueShown += ",";
				valueShown += item.getAttribute("code");
			}
		}
		bandbox.setValue(valueShown);
		System.out.print(code);
		
		Events.postEvent(new Event(Events.ON_CHANGE, bandbox, vectorCheckBox));
	}

	public Object getSelectedItem() {
		return vectorCheckBox.stream().filter(checkbox -> {
			return checkbox.isChecked();
		});
	}

	@Override
	public Component getPanel() {
		return bandbox;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void layout() throws SQLException {
		listbox.getChildren().clear();
		if(null!=sql){
			try(Connection conn=MainDb.getConnection()){
				NamedParameterStatement st=new NamedParameterStatement(conn, sql);
				if(null!=initialParameters && initialParameters.size()>0)st.setParameters(initialParameters);
				ResultSet rs= st.executeQuery();
			    
				while (rs.next()){
					
					Listitem listitem = new Listitem();
				
					listitem.setParent(listbox);
					Listcell listcell = new Listcell();
					listcell.setParent(listitem);
					Checkbox checkbox = new Checkbox();
					if(null!=bandbox.getAttribute("disable") && bandbox.getAttribute("disable").toString().equals("true")){
						checkbox.setDisabled(true);
					}
					checkbox.setParent(listcell);
					if(showValue)
						checkbox.setAttribute("code", rs.getObject("value"));
					else checkbox.setAttribute("code", rs.getObject("label"));
					//checkbox.setAttribute("short", rs.getString("label"));Account Statements
					checkbox.setAttribute("label", rs.getObject("label"));
					checkbox.setAttribute("owner", bandbox);
					checkbox.addEventListener("onCheck", this);
					checkbox.setValue(rs.getObject("value"));
					vectorCheckBox.add(checkbox);
					Label label = new Label(rs.getString("label"));
					label.setParent(listcell);
				
					if(null!=selectedValue && ((Vector<Object>)selectedValue).size()>0){
						for (Object value : (Vector<Object>)selectedValue) {
							if(null!=value && value instanceof Integer  && rs.getInt("value")==((Integer)value).intValue())
								checkbox.setChecked(true);
							else if(null!=value && value instanceof String  && rs.getString("value").equals(value.toString()))
								checkbox.setChecked(true);
							}
						}
					}	
				st.close();
				}
			
		}else if (null!=dataVector)	{
			
			for (String key : dataVector.keySet()) {
				Listitem listitem = new Listitem();
				listitem.setParent(listbox);
				Listcell listcell = new Listcell();
				listcell.setParent(listitem);
				Checkbox checkbox = new Checkbox();
				checkbox.setParent(listcell);
				
				checkbox.setAttribute("code", dataVector.get(key));
				//checkbox.setAttribute("short", dataVector.get(key));
				checkbox.setAttribute("owner", bandbox);
				checkbox.setValue(key);
				checkbox.addEventListener("onCheck", this);

				vectorCheckBox.add(checkbox);
				Label label = new Label(dataVector.get(key));
				label.setParent(listcell);
				
				if(null!=selectedValue)
				for (Object value : (Vector<Object>)selectedValue) {
					if(null!=value && value instanceof String  && dataVector.get(key).equals(value.toString()))checkbox.setChecked(true);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setId(Object Id) {
		initialParameters=(Hashtable<String, Object>) Id;
		
	}

	public Hashtable<String, Object> getInitialParameters() {
		return initialParameters;
	}

	public void setInitialParameters(Hashtable<String, Object> initialParameters) {
		this.initialParameters = initialParameters;
	}

	public Object getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(Object selectedValue) {
		this.selectedValue = selectedValue;
	}

	@Override
	public String buildWhereClause(String componentId,Hashtable <String,Object> parameters ) {
		
		String retValue="";
		String stInt="";
		int cb =0;
		for (Checkbox checkbox : vectorCheckBox) {
			if(checkbox.isChecked()){
			
				if(stInt.length()!=0){
					stInt+=" or  ";
				}
				
                String bandId=componentId+cb++;						
				stInt+=" "+getPanel().getAttribute("field")+" =:"+bandId;
				parameters.put(bandId,checkbox.getValue() );	
			
			}
		}
		if(stInt.length()!=0){
			retValue+=" and ( "+  stInt+ " ) ";
		}
		else if(!bandbox.isReadonly() && null!=bandbox.getText() && bandbox.getText().length()>0){
			 String bandId=componentId+cb++;
			stInt+=" "+getPanel().getAttribute("field")+" =:"+bandId;
			retValue+=" and ( "+  stInt+ " ) ";
			parameters.put(bandId, bandbox.getText());
		}
		return retValue;
	}

	public boolean isShowValue() {
		return showValue;
	}

	public void setShowValue(boolean showValue) {
		this.showValue = showValue;
	}

	
}
