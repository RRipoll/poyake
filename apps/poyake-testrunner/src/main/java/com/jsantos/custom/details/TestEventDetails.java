package com.jsantos.custom.details;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.form.DoNothingFormSerializer;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.gui.objectselector.foldertree.ITreeeventListener;
import com.jsantos.gui.objectselector.foldertree.TreeController;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.metadata.testrunner.EventDefinitionDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.runningTest.TestEventTypeFactory;
import com.jsantos.service.ITestEventRunner;
/**
 * @author raul ripoll
 */
public class TestEventDetails implements IDetailContainer{

	IDetailContainer detailContainer;
	MTTable mTTable= MTtestRunnerData.EVENTPARAMETER;
	Component parent;
	Window eventTypeSelector;
	MapValues<Object> initialParameter= new MapValues<Object>();
	Object value;
	String searchName;
	boolean isCancelled=false;
	TreeController eventTree;
	IDetachedRecord dr;
	IFormSerializer serializer=new DoNothingFormSerializer();
	
	@Override
	public IDetailContainer setmTTable(MTTable table) {
		this.mTTable=table;
		return this;
	}
	
	@Override
	public IDetailContainer buildAndShowComponent(EditMode mode) {
		buildComponent( mode);
		return showComponent();
	}
	
	@Override
	public IDetailContainer setParent(Component parent) {
		 this.parent=parent;
		 return this;
	}
	
	@Override
	public MTTable getmTTable() {
		return this.mTTable;
	}
	
	@Override
	public IDetailContainer buildComponent(EditMode mode) {
		
		if(mode.equals(EditMode.INSERT)) {
			eventTypeSelector= new Window();
			eventTypeSelector.setTitle("Select Definition Event");
			eventTypeSelector.setClosable(true);
			eventTypeSelector.setParent(parent);
			try {
				eventTree=new TreeController(MTtestRunnerData.EVENTDEFFOLDER, eventTypeSelector,null);
				ITreeeventListener eventlistener= new EventDefinitionTreeEventListener(eventTree);
				eventTree.setTreeeventListener(eventlistener);
				eventTree.getTopParent().addEventListener(CustomEvents.ON_ROWCLICK, this::clicked);
//				eventTree.addHeaderButton(Zklabel.getLabel("OK"), 	ButtonCssClass.COLOR_PRIMARY).addEventListener(CustomEvents.ON_HEADERBUTTON_CLICK, this::clicked);
				eventTree.render();
			} catch (Exception e) {
				e.printStackTrace();
			}
			eventTypeSelector.doModal();
		
		}else {
			ITestEventRunner testEvenrunner= TestEventTypeFactory.getProvider((String) dr.get(dr.getTable().getField("eventTypeId")));
			detailContainer=testEvenrunner.getDetailContainer();
			
			//IDetachedRecord eventdef= (IDetachedRecord) dr.get(dr.findFieldByname("eventDefinition"));
					   
			detailContainer.setDetachedRecord(dr);
			
			this.mTTable=testEvenrunner.getMTTable();
		}
			if(null==detailContainer )return null;
			detailContainer.setParent(parent);
			detailContainer.setmTTable(this.mTTable);
			if(null!=searchName)detailContainer.setSearchName(searchName);
			detailContainer.setInitialParameters(initialParameter);
			
			detailContainer.setFormSerialize(serializer);
			detailContainer.buildAndShowComponent(EditMode.UPDATE);
		

		return detailContainer;
	}
	
	void clicked(Event event) {
		
				IDetachedRecord eventDefFolderDTO=(IDetachedRecord) event.getData();
				IDetachedRecord eventDefinition=  new EventDefinitionDTO().findByPk(eventDefFolderDTO.get(eventDefFolderDTO.getTable().getField("eventDefinitionUuid")));
				String shortCode=eventDefinition.get(eventDefinition.getTable().getField("eventTypeId")).toString();
			    
				ITestEventRunner testEvenrunner=TestEventTypeFactory.getProvider(shortCode);
			    detailContainer=testEvenrunner.getDetailContainer();
			    MTTable table= testEvenrunner.getMTTable();
			    if(null==detailContainer )return ;
			    setmTTable( testEvenrunner.getMTTable());
			    detailContainer.setmTTable(this.mTTable);
			    IDetachedRecord eventdef= (IDetachedRecord) eventDefinition.get(eventDefinition.findFieldByname("eventDefinition"));//IDetachedRecord record=MTHelper.copyDetachedRecord(eventDefinition,testEvenrunner.getMTTable());
			    detailContainer.setDetachedRecord(eventdef);
				eventTypeSelector.detach();
				detailContainer.setParent(parent);
				
				try {
					eventTree.render();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
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
		this.searchName=searchName;
		return this;
	}

	@Override
	public IDetachedRecord getDetachedRecord() {
		return detailContainer.getDetachedRecord();
	}

	@Override
	public Component getFormComponent() {
		return detailContainer.getFormComponent();
	}

	@Override
	public boolean isCancelled() {
		if(null!=detailContainer)
			return detailContainer.isCancelled();
		return true;	
	}

	@Override
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) {
		this.dr=dr;
		if(null!=detailContainer) detailContainer.setDetachedRecord(dr);
		return this;
	}

	@Override
	public IDetailContainer setFormSerialize(IFormSerializer serializer) {
		this.serializer=serializer;
		return this;
	}
}
