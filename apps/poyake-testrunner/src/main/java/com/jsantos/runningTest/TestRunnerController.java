package com.jsantos.runningTest;

import java.text.SimpleDateFormat;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.CustomConstraint;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.StoreValuesTestExtDTO;
import com.jsantos.factory.appinfo.AppInfoFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.detail.DetailContainerProvider;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.metadata.testrunner.CheckParamEventDefinitionDTO;
import com.jsantos.metadata.testrunner.CheckParameterItemDTO;
import com.jsantos.metadata.testrunner.StoreValuesEventDTO;
import com.jsantos.metadata.testrunner.TestDTO;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;
import com.jsantos.service.AppInfoProvider;

public class TestRunnerController {
	TestDTO test;
	TestRunner trc;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	boolean showlog = false;
	StoreValuesTestExtDTO storeValues = new StoreValuesTestExtDTO();
    boolean isUpdated=false;
	Wildcards wildcards = new Wildcards();

	public TestRunnerController(TestDTO test) {
		this.test = test;
		try {
			storeValues.setApp_Api_Url((String) AppInfoFactory.getProvider().get(AttributeConstants.APP_API_URL,DesktopHelper.getInputUserGroupId()));
			storeValues.setJob_Api_Url((String) AppInfoFactory.getProvider().get(AttributeConstants.JOB_API_URL,DesktopHelper.getInputUserGroupId()));
			storeValues.setTestRunner_Api_Url((String) AppInfoFactory.getProvider().get(AttributeConstants.TESTRUNNER_API_URL,DesktopHelper.getInputUserGroupId()));
			trc = new TestRunner(test, storeValues);
			trc.runTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		showTest(test, storeValues);
	}

	void showTest(TestDTO test, StoreValuesTestExtDTO storeValues) {

		try {
			IDetailContainer container = DetailContainerProvider.getDetailContainer(storeValues.getTable());
			container.setDetachedRecord(storeValues);
			container.setParent(DesktopHelper.getRootComponent());
			DesktopHelper.getRootComponent().addEventListener(CustomEvents.ON_CUSTOMFIELD_UPDATE,
					this::customFieldUpdate);
			container.buildAndShowComponent(EditMode.AUTO);
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null,
						2000);
			else {
				ex.printStackTrace();
				throw ex;
			}
		}
		
	}

	public TestRunnerController(TestDTO test, StoreValuesTestExtDTO storeValues) {
		this.test = test;
		this.storeValues = storeValues;
		try {
			trc = new TestRunner(test, storeValues);
			trc.runTest();
		} catch (Exception e) {
		}
		showTest(test, storeValues);
	}

	public void customFieldUpdate(Event event) {

		MapValues<Object> data = (MapValues<Object>) event.getData();
		if (null != data) {
			StoreValuesEventDTO item = (StoreValuesEventDTO) data.get("item");
			Object expresion=data.get("expresion");
			Object result=data.get("result");
			MTField MTField=(MTField) data.get("MTField");
			Component component=(Component) data.get("Component");
			Object itemEvent =  item.getEvent();
			ListValues<Object> events = (ListValues<Object>) test.getEvents();
			Integer index = events.indexOf(itemEvent);
		
			CheckParameterItemDTO checkParameterItem = new CheckParameterItemDTO();
				checkParameterItem.setOperator(14);
				checkParameterItem.setCheckValue( result.toString());
				checkParameterItem.setCheckValueTypeId(1);
				checkParameterItem.setValueName( expresion.toString());
		
			CheckParamEventDefinitionDTO checkParamEventDefinitionDTO= new CheckParamEventDefinitionDTO();
				checkParamEventDefinitionDTO.setEventName((String) expresion);
				//checkParamEventDefinitionDTO.setEventDefinitionUuid(null);
				//checkParamEventDefinitionDTO.setDescription(null);
				checkParamEventDefinitionDTO.setEventTypeId("CHECK_SERVICE");
				checkParamEventDefinitionDTO.setSelected(1);
				checkParamEventDefinitionDTO.setParameters(new ListValues<CheckParameterItemDTO>().addValue(checkParameterItem));;
				
			events.add(index+1, checkParamEventDefinitionDTO);	
			test.getUpdates().set(MTtestRunnerData.TEST.EVENTS, events);
			test.update();
			isUpdated=true;
			component.detach();
			Clients.showNotification("Check event has been added", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			
		}
	}

	public boolean isUpdated() {
		return isUpdated;
	}
}
