package com.jsantos.gui.form;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Label;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.factory.DTOFactory;
import com.jsantos.gui.zkutil.ComponentTreeTransverser;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

/**
 * @author javier santos
 * @author raul ripoll
 */

public class MTForm {

	private Component formComponent;
	private Component saveButton;
	private Component cancelButton;
	private Component editButton;

	private MTMapValues<Component> editors = new MTMapValues<Component>();
	private LinkedHashMap<MTTable, IDetachedRecord> drs = new LinkedHashMap<>();
	private EditMode mode;
	private boolean saved = false;
	IFormSerializer serializer = new DefaultFormSerializer();
	private String searchName;
	MTTable[] tables;
	
	public MTForm(Component formComponent, EditMode mode, MTTable[] tables) {
		this.formComponent = formComponent;
		this.mode = mode;
		this.tables=tables;
		}
	
	public MTForm init() {	
		saveButton = formComponent.getFellowIfAny("SAVE_BUTTON");
		cancelButton = formComponent.getFellowIfAny("CANCEL_BUTTON");
		if (null != cancelButton)
			cancelButton.addEventListener(Events.ON_CLICK, this::closeWindow);
		editButton = formComponent.getFellowIfAny("EDIT_BUTTON");

		refresh();
		
		return this;
	}
	
	
	public MTForm refresh() {
		
		buildEditorList();
		if (mode == EditMode.INSERT) {
			autoBuildDetachedRecords(tables);
			try {
				ZulDataWirer.initializeFieldConstraints(formComponent,searchName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ZulDataWirer.initializeFieldLabels(formComponent);
			//ZulDataWirer.initializeFieldDefaults(formComponent);
			formComponent.invalidate();

		}
		if (mode == EditMode.SHOW) {
			ZulDataWirer.setReadOnlyEditor(formComponent, true);
		}
		if (mode == EditMode.UPDATE) {
			autoBuildDetachedRecords(tables);
			ZulDataWirer.setReadOnlyEditor(formComponent, false);
			try {
				ZulDataWirer.initializeFieldConstraints(formComponent,searchName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	

	public void addDetachedRecord(IDetachedRecord dr) {
		drs.put(dr.getTable(), dr);
		ZulDataWirer.initializeFieldValues(dr, formComponent);
	}

	void autoBuildDetachedRecords(MTTable[] tables) {
		if (null != tables) {
			for (MTTable mtTable : tables) {
				drs.put(mtTable, DTOFactory.get(mtTable));
			}
		} else {
			for (MTField field : editors.keySet())
				if (!drs.containsKey(field.getTable()))
					drs.put(field.getTable(), DTOFactory.get(field.getTable()));
		}
		for (IDetachedRecord dr : drs.values())
			ZulDataWirer.initializeFieldValues(dr, formComponent);
	}

	void buildEditorList() {
		for (Entry<MTField, Component> element : ComponentTreeTransverser.getMetadataAnotatedComponents(formComponent)
				.entrySet()) {
			MTField mtField = element.getKey();
			Component comp = element.getValue();
			if (null != mtField)
				editors.put(mtField, comp);
		}
	}

	public boolean save() {
		saved =serializer.serialize(this);
		return saved;
	}

	public void setSerializer(IFormSerializer serializer) {
		this.serializer = serializer;
	}

	public Component getSaveButton() {
		return saveButton;
	}

	public Component getCancelButton() {
		return cancelButton;
	}

	public boolean isSaved() {
		return saved;
	}

	public Component getFormComponent() {
		return formComponent;
	}

	public LinkedHashMap<MTTable, IDetachedRecord> getDrs() {
		return drs;
	}

	public EditMode getMode() {
		return mode;
	}

	public void setHeaderLabel(String sLabel) {
		Label label = (Label) formComponent.getFellowIfAny("HEADER_LABEL");
		if (null != label)
			label.setValue(sLabel);
	}

	public Component getEditButton() {
		return editButton;
	}

	public void setEditButton(Component editButton) {
		this.editButton = editButton;
	}

	public void setMode(EditMode mode) {
		this.mode = mode;
	}

	public void closeWindow(Event event) {
		getFormComponent().detach();
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public MTTable[] getTables() {
		return tables;
	}

	public void setTables(MTTable[] tables) {
		this.tables = tables;
	}

	public IFormSerializer getSerializer() {
		return serializer;
	}

	public void setFormComponent(Component formComponent) {
		this.formComponent = formComponent;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}
}