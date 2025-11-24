package com.jsantos.custom.details;

import java.util.Map.Entry;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.factory.DTOFactory;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.metadata.testrunner.EventDefinitionDTO;
import com.jsantos.metadata.testrunner.EventTypeDTO;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.runningTest.TestEventTypeFactory;
import com.jsantos.service.ITestEventRunner;

public class EventDefinitionDetails implements IDetailContainer {

	IDetailContainer detailContainer;
	MTTable mTTable = MTtestRunnerData.EVENTDEFINITION;
	Component parent;
	Window eventTypeSelector;
	MapValues<Object> initialParameter = new MapValues<Object>();
	//Object value;
	String searchName;
	boolean isCancelled = false;
	IDetachedRecord dr;
	private IFormSerializer serializer=new EventDefinitionSerializer();
	
	@Override
	public IDetailContainer setmTTable(MTTable table) {
		this.mTTable = table;
		return this;
	}

	@Override
	public IDetailContainer buildAndShowComponent(EditMode mode) {
		buildComponent(mode);
		
		return showComponent();
	}

	@Override
	public IDetailContainer setParent(Component parent) {

		this.parent = parent;
		return this;
	}

	@Override
	public MTTable getmTTable() {

		return this.mTTable;
	}

	@Override
	public IDetailContainer buildComponent(EditMode mode) {

		if (mode.equals(EditMode.INSERT)) {
			eventTypeSelector = new Window();
			eventTypeSelector.setTitle("Select Event Type");
			eventTypeSelector.setClosable(true);
			eventTypeSelector.setParent(parent);
			Listbox listBox = new Listbox();
			listBox.setParent(eventTypeSelector);
			listBox.addEventListener(Events.ON_CLICK, this::clicked);
			MapValues<EventTypeDTO> types = TestEventTypeFactory.getTypes();

			for (Entry<String, EventTypeDTO> type : types.entrySet()) {
				Listitem item = new Listitem(type.getValue().getDescription(), type.getKey());
				item.setParent(listBox);
			}
			eventTypeSelector.doModal();
		} else {
			//EventDefinitionDTO eventDefinitionDTO=new EventDefinitionDTO((Integer)value);
			ITestEventRunner testEvenrunner = TestEventTypeFactory.getProvider(dr.getString(MTtestRunnerData.EVENTDEFINITION.EVENTTYPEID));
			detailContainer = testEvenrunner.getDetailContainer();
			detailContainer.setDetachedRecord( (IDetachedRecord) dr.get(MTtestRunnerData.EVENTDEFINITION.EVENTDEFINITION));
			this.mTTable = testEvenrunner.getMTTable();
		}
		if (null == detailContainer)
			return null;
		detailContainer.setParent(parent);
		detailContainer.setmTTable(this.mTTable);
		if (null != searchName)
			detailContainer.setSearchName(searchName);
		detailContainer.setInitialParameters(initialParameter);
		//detailContainer.setDetachedRecord(dr);
		detailContainer.setFormSerialize(serializer);
		detailContainer.buildAndShowComponent(EditMode.INSERT);
		if(!detailContainer.isCancelled()) {
			 IDetachedRecord eventDefinition=  detailContainer.getDetachedRecord();
			 if(null==dr) dr= new EventDefinitionDTO();
			 ((EventDefinitionDTO)dr).setEventName(eventDefinition.getString(eventDefinition.findFieldByname(MTtestRunnerData.EVENTDEFINITION.EVENTNAME.getName())));
			 ((EventDefinitionDTO)dr).setEventTypeId(eventDefinition.getString(eventDefinition.findFieldByname(MTtestRunnerData.EVENTDEFINITION.EVENTTYPEID.getName())));
			 ((EventDefinitionDTO)dr).setDescription(eventDefinition.getString(eventDefinition.findFieldByname(MTtestRunnerData.EVENTDEFINITION.DESCRIPTION.getName())));
			 ((EventDefinitionDTO)dr).getUpdates().set(dr.findFieldByname(MTtestRunnerData.EVENTDEFINITION.EVENTDEFINITION.getName()), eventDefinition);    
		     dr.insertOrUpdate();
		}
		return detailContainer;
	}

	void clicked(Event event) {
		String shortcode = ((Listbox) event.getTarget()).getSelectedItem().getValue();
		ITestEventRunner testEvenrunner = TestEventTypeFactory.getProvider(shortcode);
		detailContainer = testEvenrunner.getDetailContainer();

		DetachedRecord testEvent = DTOFactory.get(testEvenrunner.getMTTable());

		initialParameter.add(MTtestRunnerData.EVENTDEFINITION.EVENTTYPEID.getName(), shortcode);
		this.mTTable = testEvenrunner.getMTTable();
		eventTypeSelector.detach();
	}

	@Override
	public IDetailContainer showComponent() {
		return this;
	}

	@Override
	public IDetailContainer setInitialParameters(MapValues<Object> initialParameter) {

		this.initialParameter.add(initialParameter);
		return this;
	}

	@Override
	public IDetailContainer setSearchName(String searchName) {
		this.searchName = searchName;
		return this;
	}

	@Override
	public IDetachedRecord getDetachedRecord() {
		return dr;
	}

	@Override
	public Component getFormComponent() {
		return detailContainer.getFormComponent();
	}

	@Override
	public boolean isCancelled() {
		if(null==detailContainer)return true;
		return detailContainer.isCancelled();
	}

	@Override
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) {
		this.dr=dr;
		return this;
	}

	@Override
	public IDetailContainer setFormSerialize(IFormSerializer serializer) {
		this.serializer=serializer;
		return this;
	}


}
