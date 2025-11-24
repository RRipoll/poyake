package com.jsantos.custom.customfield;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.util.MapValues;
import com.jsantos.commondata.util.HelperControllers;
import com.jsantos.custom.cell.general.JsonBuilder;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.zkutil.ButtonCssClass;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.metadata.MTrestRunnerData;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
/**
 * @author raul ripoll
 */
public class TestEventJsonContainer extends JsonContainer{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public MTField forField() {
		return MTrestRunnerData.RESTEVENTDEFINITION.JSON;
	}

	@Override
	public MTDataType forModelType() {
		return null;
	}
	
	@Override
	public Component initialize() {

		try {

			this.setSclass("form-group form-float");
			Div div2 = new Div();
			div2.setSclass("form-line");
			div2.setParent(this);
			customComponent = new JsonBuilder();
			
			Component comp = customComponent.buildGridComponent(mtField, null, null, LocaleFactory.getProvider().getLocale());
			comp.setParent(div2);
		
			addHeaderButton(Zklabel.getLabel("Json Example"), ButtonCssClass.COLOR_INFO);
		
		} catch (Throwable e) {
			e.printStackTrace();
			throw new WrongValueException(this, ErrorsConstants.FILE_ERROR);
		}
		return this;

	}
	public Button addHeaderButton(String label, String colorClass) {
		
		Button button = new Button(label);
		button.setSclass("float-right btn " +colorClass);
		customComponent.getExtraButton().add(button);
		//new Text(label).setParent(button);
		//button.setStyle("margin:3px");
		button.addEventListener(Events.ON_CLICK, this::addingTablaExample);
		return button;
	}
	
	void getExampleTableName(Event event) {
		
		Textbox textbox=(Textbox)event.getTarget().getAttribute("TABLE_NAME");
		String tableName= (String) textbox.getValue();
		
		if(null!=tableName) {
			try {
				IDetachedRecord dr= DTOFactory.get(MTBase.getTable(tableName));
				
				MapValues<Object> data= HelperControllers.getJsonExampleValues(dr.getCopyValues());
				ObjectMapper mapper = new ObjectMapper();
				String stringData;
			
				stringData = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
				customComponent.setValue(stringData);
			} catch (JsonProcessingException e) {
				Clients.showNotification("Wrong table Name", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
				textbox.setValue(null);
			}catch (RuntimeException e) {
				Clients.showNotification("Wrong table Name", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
				textbox.setValue(null);
			};
		}
		((Window)event.getTarget().getAttribute("WINDOW")).detach();
	}
	
	void addingTablaExample(Event event) {
		
		String zul="~./zul/poyake-testrunner/jsonexample.zul";
		Window dialog=(Window) Executions.createComponents(zul,DesktopHelper.getRootComponent(), null);		
		Button button=(Button) dialog.getFellow("SAVE_BUTTON");
		button.setAttribute("TABLE_NAME",dialog.getFellow("TABLE_NAME") );
		button.setAttribute("WINDOW",dialog );
		dialog.getFellow("SAVE_BUTTON").addEventListener(Events.ON_CLICK, this::getExampleTableName);
		dialog.doModal();
		
			
	}
}
