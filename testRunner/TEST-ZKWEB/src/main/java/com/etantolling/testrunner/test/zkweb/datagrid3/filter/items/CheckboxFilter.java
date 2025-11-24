package com.etantolling.testrunner.test.zkweb.datagrid3.filter.items;

import java.sql.SQLException;
import java.util.Hashtable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Checkbox;

import com.etantolling.testrunner.test.zkweb.IPanel;

public class CheckboxFilter extends Bandbox implements  IFilter,IPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BandboxFilter bandboxFilter;
	private Hashtable<String, Object> initialParameters;
	private String sql;
	private Object selectedValue;
	private String fieldName;
	//private String type;
	//private boolean showValue;
	
	@Override
	public String buildWhereClause(String componentId,Hashtable <String,Object> parameters ) {
		
		String retValue="";
		String stInt="";
		//int cb =0;
		for (Checkbox checkbox : bandboxFilter.vectorCheckBox) {
			if(checkbox.isChecked()){
				if(stInt.length()!=0){
					stInt+=" ,  ";
				}
                stInt+=" "+checkbox.getValue() ;	
			}
		}
		if(stInt.length()!=0){
			retValue+=" and "+fieldName+" in ("+stInt+")  "					;
		}
		return retValue;
	}

	@Override
	public Component getPanel() {
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void layout() throws SQLException {
		this.initialParameters=(Hashtable<String, Object>) this.getAttribute("initialParameters");
		this.sql=(String) this.getAttribute("enumerationsql");
		//this.selectedValue=this.getAttribute("selectedValue");
		this.fieldName=(String) this.getAttribute("field");
		//this.type=(String) this.getAttribute("type");
		if(null!=this.getAttribute("type"))
		//this.showValue=((String)this.getAttribute("type")).equals("true");
		bandboxFilter=new BandboxFilter(this,sql,selectedValue,initialParameters);
	}

	@Override
	public void setId(Object Id) {
		// TODO Auto-generated method stub
	}

	public BandboxFilter getBandboxFilter() {
		return bandboxFilter;
	}

	@Override
	public void setSelectedValue(Object selectedValue) {
		this.selectedValue=selectedValue;
	}
}