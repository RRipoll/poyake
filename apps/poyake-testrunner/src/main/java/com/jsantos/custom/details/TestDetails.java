package com.jsantos.custom.details;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.detail.DefaultDetailContainer;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.gui.zkutil.ButtonCssClass;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.metadata.testrunner.TestDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.runningTest.TestRunnerController;

public class TestDetails implements IDetailContainer{

	IDetailContainer detailContainer= new DefaultDetailContainer();
	MTTable mTTable= MTtestRunnerData.TEST;
	IDetachedRecord dr;
	EditMode mode;
	
	@Override
	public IDetailContainer setParent(Component parent) {
		
		return detailContainer.setParent(parent);
	}

	@Override
	public MTTable getmTTable() {
		
		return this.mTTable;
	}

	@Override
	public IDetailContainer setInitialParameters(MapValues<Object> initialParameter) {
		
		return detailContainer.setInitialParameters(initialParameter);
	}

	@Override
	public IDetailContainer setSearchName(String searchName) {
		
		return detailContainer.setSearchName(searchName);
	}

	@Override
	public IDetachedRecord getDetachedRecord() {
		
		return detailContainer.getDetachedRecord();
	}

	@Override
	public Component getFormComponent() {
		return detailContainer.getFormComponent();
	}

	public Button addHeaderButton(String label, String colorClass) {
		
		
		Button button = new Button(label);
		button.setSclass("float-right btn " +colorClass);
		button.setParent(getFormComponent().getFellow("HEADER_DIV"));
		//new Text(label).setParent(button);
		button.setStyle("margin:3px");
		button.addEventListener(Events.ON_CLICK, this::addingDataToButton);
		return button;
	}
	void addingDataToButton(Event event) {
		Events.sendEvent(new Event(CustomEvents.ON_HEADERBUTTON_CLICK, event.getTarget(),getDetachedRecord() ));
	}
	
	

	@Override
	public IDetailContainer setmTTable(MTTable table) {
		this.mTTable=table;
		return this;
	}
	@Override
	public IDetailContainer buildComponent(EditMode mode) {
		detailContainer.setmTTable(this.mTTable);
		detailContainer.buildComponent(mode);
		Component formComponent=detailContainer.getFormComponent();
		addHeaderButton(Zklabel.getLabel("Run"), ButtonCssClass.COLOR_SECONDARY).addEventListener(CustomEvents.ON_HEADERBUTTON_CLICK, this::runTest);
		return this;
	}

	@Override
	public IDetailContainer showComponent() {
		return detailContainer.showComponent();
		
	}

	@Override
	public IDetailContainer buildAndShowComponent(EditMode mode) {
		this.mode=mode;
		buildComponent( mode);
		return showComponent();
	}
	void runTest(Event evt) throws Exception{
        IDetachedRecord test=  (IDetachedRecord) evt.getData();
		if(null!=test) {
			TestRunnerController testRunnerController=new TestRunnerController((TestDTO) MTHelper.getTableFromView(test));	
			if(testRunnerController.isUpdated())
				buildAndShowComponent(mode);
			}
		}

	@Override
	public boolean isCancelled() {
		return detailContainer.isCancelled();
	}

	@Override
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) {
		this.dr=dr;
		if(null!=detailContainer)detailContainer.setDetachedRecord(dr);
		return this;
	}

	@Override
	public IDetailContainer setFormSerialize(IFormSerializer serializer) {
		
		return this;
	}

	
}
