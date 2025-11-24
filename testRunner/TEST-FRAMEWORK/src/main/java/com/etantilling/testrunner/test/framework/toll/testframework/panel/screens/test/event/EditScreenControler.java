package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.db.DetachedRow;
import com.etantolling.testrunner.test.utils.misc.MiscUtility;
import com.etantolling.testrunner.test.zkweb.EditorElement;
import com.etantolling.testrunner.test.zkweb.ParameterItem;
import com.etantolling.testrunner.test.zkweb.forms.ZulDataWirerSql;

public class EditScreenControler implements EventListener<Event>{

	DetachedRow drr=null;
	Component window= null;
	Integer eventDefinitionId=null;
	Integer pk=null;
	LinkedHashMap<String, ParameterItem> parameters= new LinkedHashMap<String, ParameterItem>();
	LinkedHashMap<String, Object> storedParams;
	AddParameter addParameter;
	Rows rows;
	
	public EditScreenControler(LinkedHashMap<String, Object> storedParams) {
		super();
		this.storedParams=storedParams;
		LinkedHashMap<String, Object> row=getRowFromParams(storedParams);
		this.drr = new DetachedRow(row);
	}

	private LinkedHashMap<String, Object> getRowFromParams(LinkedHashMap<String, Object> params) {
	
		LinkedHashMap<String, Object> row= new LinkedHashMap<String, Object>();
		for (String key : params.keySet()) {
			
			boolean isInput=(boolean)((LinkedHashMap<String, Object>)params.get(key)).get("isInput");
			boolean isOutput=(boolean)((LinkedHashMap<String, Object>)params.get(key)).get("isOutput");
			boolean isVariable=(boolean)((LinkedHashMap<String, Object>)params.get(key)).get("isVariable");
			String type=(String)((LinkedHashMap<String, Object>)params.get(key)).get("type");
			String label=(String)((LinkedHashMap<String, Object>)params.get(key)).get("label");
			boolean hideReference=false;
			if(key.equals("JSON") || key.equals("URL")) {
				hideReference=true;
			}
			
			EditorElement editorElement = new EditorElement(EventCreatedController.getObjectFromString((String) ((LinkedHashMap<String, Object>)params.get(key)).get("type"))
					,!isVariable,hideReference,isInput,isOutput,(String) ((LinkedHashMap<String, Object>)params.get(key)).get("type"));
			ParameterItem item= new ParameterItem(editorElement,isVariable,isInput,isOutput,type,
					((LinkedHashMap<String, Object>)params.get(key)).get("value"),label);
			row.put(key, item.getValue());
			parameters.put(key, item);
		}
		return row;
	}

	public void buildForm(Component parent) throws SQLException {

		String zul = "/common/zul/standardeditscreen/editscreen.zul";
		window = (Window) Executions.createComponents(zul,parent, null);
		Grid div= new Grid();
		div.setParent(window);
		rows= new Rows(); 
		rows.setParent(div);
		addParameter= new AddParameter(window,parameters,this);
		
		render();
	}
	
	public void  render() {
		rows.getChildren().clear();
		ArrayList<String> deleteItems=new ArrayList<String>();
		for (String key : parameters.keySet()) {
			Component newEditor = ((ParameterItem)parameters.get(key)).getEditElement();
			if(parameters.get(key).editElement.isDeleted()) {
			    continue;
			}
			Row box= new Row();
			box.setParent(rows);
			if(key.equals("AUTHORIZATION") ||key.equals("HTTPMETHOD") )box.setVisible(false);
			new Label(key).setParent(box);
			newEditor.setParent(box);
			if(!newEditor.isListenerAvailable("onDataDeleted",true))
				newEditor.addEventListener("onDataDeleted", this);
		}
	}
	
	
	public String getParam() throws SQLException {
		
		wireFields();
		
		for (String key : parameters.keySet()) {
			EditorElement parKey=((ParameterItem) parameters.get(key)).getEditElement();
			LinkedHashMap<String, Object> storedKey=((LinkedHashMap<String, Object>)storedParams.get(key));
			if(parKey.isDeleted()) {
				storedParams.remove(key);continue;
			}if(null==storedKey) {
				storedKey= new LinkedHashMap<String, Object>();
				storedParams.put(key, storedKey);
			}
			storedKey.put("value",parKey.getElement().getRawValue());
			storedKey.put("type",((ParameterItem) parameters.get(key)).getType());
			storedKey.put("label",StringUtils.isEmpty((String) parKey.getLabel().getRawValue())?key.trim():((String)parKey.getLabel().getRawValue()).trim());
			storedKey.put("isInput",parKey.getIsInput().isChecked());
			storedKey.put("isOutput",parKey.getIsOutput().isChecked());
			storedKey.put("isVariable",parKey.getByReference().isChecked());
		}
		
		return new MiscUtility().getStringFromObject(storedParams);
	}

	protected void wireFields() throws SQLException{
		ZulDataWirerSql.readFormFieldValues(drr, window);
	}
	
	public Object getPk() {
		return pk;
	}

	public Integer getEventDefinitionId() {
		return eventDefinitionId;
	}

	public void setEventDefinitionId(Integer eventDefinitionId) {
		this.eventDefinitionId = eventDefinitionId;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	@Override
	public void onEvent(Event event) throws Exception {
	System.out.println(event.toString());
	render();	
	}
}