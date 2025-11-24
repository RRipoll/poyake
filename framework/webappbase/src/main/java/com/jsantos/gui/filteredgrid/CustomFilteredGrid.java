package com.jsantos.gui.filteredgrid;

import java.util.Collections;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.model.EditMode;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.DetailConfiguration;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.model.conf.OrderByConfiguration;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.form.controller.MTDefaultDetailScreenController;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.search.AttributeConstants;

/**
 * @author raul ripoll
 */

public class CustomFilteredGrid {

	Component parent;
	Component comp = null;
	
	JsonEditor jsonEditor;
	IDetachedRecord dtSettingDTO;
	SettingDTO settingDTO;
    
	int inputUserGroupSA=2;
	
	public CustomFilteredGrid(Component parent, String searchName) {
		super();
		this.parent = parent;
		
		dtSettingDTO=DesktopHelper.getDGSettingEx(searchName, DesktopHelper.getInputUserGroupId(), LocaleFactory.getProvider().getLocale());
		if(null==dtSettingDTO)
			settingDTO=DataSettingFactory.getProvider().getSetting(searchName, DesktopHelper.getInputUserGroupId(), LocaleFactory.getProvider().getLocale());
		else settingDTO = DataSettingFactory.getProvider().getSetting(dtSettingDTO, DesktopHelper.getInputUserGroupId());
		
	}

	public void buildAndShowFilter() throws Exception {
		comp = Executions.createComponents("~./common/zul/component/filteredGrid/customFilter.zul",
				DesktopHelper.getRootComponent(), null);
		setFilterItems(comp);
		comp.getFellow("CUSTOM_SAVE_BUTTON").addEventListener(Events.ON_CLICK, this::saveWindow);
		comp.getFellow("CUSTOM_CANCEL_BUTTON").addEventListener(Events.ON_CLICK, this::cancelWindow);

		((Window) comp).setLeft("50%");
		((Window) comp).setSizable(true);
		((Window) comp).doOverlapped();
	}

	public void buildAndShowColumns() throws Exception {
		comp = Executions.createComponents("~./common/zul/component/filteredGrid/customSelect.zul",
				DesktopHelper.getRootComponent(), null);

		setSelectItems(comp);
		comp.getFellow("CUSTOM_SAVE_BUTTON").addEventListener(Events.ON_CLICK, this::saveWindow);
		comp.getFellow("CUSTOM_CANCEL_BUTTON").addEventListener(Events.ON_CLICK, this::cancelWindow);

		((Window) comp).setSizable(true);
		((Window) comp).setLeft("50%");
		((Window) comp).doOverlapped();
	}

	public void buildAndShowOrderBy() throws Exception {
		comp = Executions.createComponents("~./common/zul/component/filteredGrid/customOrderBy.zul",
				DesktopHelper.getRootComponent(), null);
		setOrderByItems(comp);
		comp.getFellow("CUSTOM_SAVE_BUTTON").addEventListener(Events.ON_CLICK, this::saveWindow);
		comp.getFellow("CUSTOM_CANCEL_BUTTON").addEventListener(Events.ON_CLICK, this::cancelWindow);

		((Window) comp).setSizable(true);
		((Window) comp).setLeft("50%");
		((Window) comp).doOverlapped();
	}

	public void buildAndDetail() throws Exception {
		comp = Executions.createComponents("~./common/zul/component/filteredGrid/customDetails.zul",
				DesktopHelper.getRootComponent(), null);
		setDetailItems(comp);
		comp.getFellow("CUSTOM_SAVE_BUTTON").addEventListener(Events.ON_CLICK, this::saveWindow);
		comp.getFellow("CUSTOM_CANCEL_BUTTON").addEventListener(Events.ON_CLICK, this::cancelWindow);

		((Window) comp).setLeft("50%");
		((Window) comp).setSizable(true);
		((Window) comp).doOverlapped();
	}

	public void buildAndShowEdit() throws Exception {
		comp = Executions.createComponents("~./common/zul/component/filteredGrid/customEdit.zul",
				DesktopHelper.getRootComponent(), null);
		setEditItems(comp);
		comp.getFellow("CUSTOM_SAVE_BUTTON").addEventListener(Events.ON_CLICK, this::saveWindow);
		comp.getFellow("CUSTOM_CANCEL_BUTTON").addEventListener(Events.ON_CLICK, this::cancelWindow);

		((Window) comp).setLeft("50%");
		((Window) comp).setSizable(true);
		((Window) comp).doOverlapped();
	}

	public void setFilterItems(Component comp) throws Exception {
		Component FILTER_LIST = comp.getFellow("FILTER_LIST");
		FILTER_LIST.getChildren().clear();
		Grid filterBox = new Grid();
		filterBox.setParent(FILTER_LIST);
		Rows rows = new Rows();
		rows.setParent(filterBox);
		for (FilterConfiguration configuration : settingDTO.getFilterConfigurations()) {
			if(!configuration.isActive())continue;
			if(!configuration.isAvailable())continue;
			Row div = new Row();
			div.setParent(rows);
			div.setDraggable("true");
			div.setDroppable("true");
			div.addEventListener(Events.ON_DROP, this::moveFilter);
			div.setAttribute(AttributeConstants.CONFIGURATION, configuration);
			Checkbox checkbox = new Checkbox(LabelFactory.getProvider().get(configuration.getMtField(), LocaleFactory.getProvider().getLocale()));
			checkbox.setParent(div);
			checkbox.addEventListener(Events.ON_CHECK, this::checkFilterItem);
			checkbox.setAttribute(AttributeConstants.CONFIGURATION, configuration);
			if (!configuration.isHidden())
				checkbox.setChecked(true);
			
		}
	}

	public void setOrderByItems(Component comp) throws Exception {
		Component ORDER_LIST = comp.getFellow("ORDER_LIST");
		ORDER_LIST.getChildren().clear();
		Grid orderByBox = new Grid();
		orderByBox.setParent(ORDER_LIST);
		Rows rows = new Rows();
		rows.setParent(orderByBox);
		for (OrderByConfiguration configuration : settingDTO.getOrderByConfigurations()) {
			if(configuration.isHidden())continue;
			Row div = new Row();
			div.setParent(rows);
			div.setDraggable("true");
			div.setDroppable("true");
			div.addEventListener(Events.ON_DROP, this::moveOrderBy);
			div.setAttribute(AttributeConstants.CONFIGURATION, configuration);
			{
				Checkbox checkbox = new Checkbox(LabelFactory.getProvider().get(configuration.getMtField(), LocaleFactory.getProvider().getLocale()));
				checkbox.setParent(div);
				checkbox.addEventListener(Events.ON_CHECK, this::checkOrderItem);
				//checkbox.addEventListener(Events.ON_CHANGE, this::checkOrderItem);
				checkbox.setAttribute(AttributeConstants.CONFIGURATION, configuration);
				if (configuration.isActive())
					checkbox.setChecked(true);
			}
			{
				Checkbox checkbox = new Checkbox("Asc");
				checkbox.setParent(div);
				checkbox.addEventListener(Events.ON_CHECK, this::checkOrderAscending);
				checkbox.setAttribute(AttributeConstants.CONFIGURATION, configuration);
				if ((configuration).isAsc())
					checkbox.setChecked(true);
				if (((OrderByConfiguration) configuration).isAsc())
					checkbox.setChecked(true);
			}
		}
	}

	public void setSelectItems(Component comp) throws Exception {

		Component SELECT_LIST = comp.getFellow("SELECT_LIST");
		SELECT_LIST.getChildren().clear();
		Grid selectBox = new Grid();
		selectBox.setParent(SELECT_LIST);
		Rows rows = new Rows();
		rows.setParent(selectBox);
		{
			for (GridColumnConfiguration configuration : settingDTO.getColumnConfigurations()) {
				if(!configuration.isActive())continue;
				if(!configuration.isAvailable())continue;
				Row div = new Row();
				div.setParent(rows);
				div.setDraggable("true");
				div.setDroppable("true");
				div.addEventListener(Events.ON_DROP, this::moveSelect);
				div.setAttribute(AttributeConstants.CONFIGURATION, configuration);
				Checkbox checkbox = new Checkbox(LabelFactory.getProvider().get(configuration.getMtField(), LocaleFactory.getProvider().getLocale()));
				checkbox.setParent(div);
				checkbox.addEventListener(Events.ON_CHECK, this::checkSelectItem);
				checkbox.setAttribute(AttributeConstants.CONFIGURATION, configuration);
				if (!configuration.isHidden())
					checkbox.setChecked(true);
				
			}
		}
	}

	public void setDetailItems(Component comp) throws Exception {
		Component FILTER_LIST = comp.getFellow("FILTER_LIST");
		FILTER_LIST.getChildren().clear();
		Grid detailBox = new Grid();
		detailBox.setParent(FILTER_LIST);
		Rows rows = new Rows();
		rows.setParent(detailBox);
		for (DetailConfiguration configuration : settingDTO.getDetailScreenConfigurations()) {
			if(!configuration.isActive())continue;
			if(!configuration.isAvailable())continue;
			Row div = new Row();
			div.setParent(rows);
			div.setDraggable("true");
			div.setDroppable("true");
			div.addEventListener(Events.ON_DROP, this::moveDetail);
			div.setAttribute(AttributeConstants.CONFIGURATION, configuration);
			Checkbox checkbox = new Checkbox(LabelFactory.getProvider().get(configuration.getMtField(), LocaleFactory.getProvider().getLocale()));
			checkbox.setParent(div);
			checkbox.addEventListener(Events.ON_CHECK, this::checkDetailItem);
			checkbox.setAttribute(AttributeConstants.CONFIGURATION, configuration);
			if (!configuration.isHidden())
				checkbox.setChecked(true);
			
		}
	}

	public void setEditItems(Component comp) throws Exception {
		Component FILTER_LIST = comp.getFellow("FILTER_LIST");
		FILTER_LIST.getChildren().clear();
		Grid editbox = new Grid();
		editbox.setParent(FILTER_LIST);
		Rows rows = new Rows();
		rows.setParent(editbox);
		for (DetailConfiguration configuration : settingDTO.getEditConfigurations()) {
			if(!configuration.isActive())continue;
			if(!configuration.isAvailable())continue;
			Row div = new Row();
			div.setParent(rows);
			div.setDraggable("true");
			div.setDroppable("true");
			div.addEventListener(Events.ON_DROP, this::moveEdit);
			div.setAttribute(AttributeConstants.CONFIGURATION, configuration);
			Checkbox checkbox = new Checkbox(LabelFactory.getProvider().get(configuration.getMtField(), LocaleFactory.getProvider().getLocale()));
			checkbox.setParent(div);
			checkbox.addEventListener(Events.ON_CHECK, this::checkDetailItem);
			checkbox.setAttribute(AttributeConstants.CONFIGURATION, configuration);
			if (!configuration.isHidden())
				checkbox.setChecked(true);
			checkbox.setDisabled(configuration.isRequired());
			
		}
	}

	public void saveWindow(Event event) throws Exception {
		

		dtSettingDTO =DataSettingFactory.getProvider().setSetting(settingDTO, dtSettingDTO,
				DesktopHelper.getInputUserGroupId());

		if (DesktopHelper.getInputUserGroupId() == inputUserGroupSA) {
			MTDefaultDetailScreenController editScreen = new MTDefaultDetailScreenController(dtSettingDTO, parent,
					EditMode.UPDATE,null)
					.init();
			editScreen.doModal();
		} else
			dtSettingDTO = DataSettingFactory.getProvider().insertSetting(settingDTO, dtSettingDTO,
					DesktopHelper.getInputUserGroupId());

		DesktopHelper.putSetting(settingDTO.getaSName(), dtSettingDTO);
		comp.detach();
		Events.sendEvent(CustomEvents.ON_CHANGINGCONF, parent, null);
	}

	public void cancelWindow(Event event) throws Exception {

		comp.detach();
	}

	public void checkOrderItem(Event event) throws Exception {
		OrderByConfiguration target = (OrderByConfiguration) event.getTarget()
				.getAttribute(AttributeConstants.CONFIGURATION);
		target.setActive(((CheckEvent) event).isChecked());
	}

	public void checkSelectItem(Event event) throws Exception {
		GridColumnConfiguration target = (GridColumnConfiguration) event.getTarget()
				.getAttribute(AttributeConstants.CONFIGURATION);
		target.setHidden(!((CheckEvent) event).isChecked());

	}

	public void checkFilterItem(Event event) throws Exception {
		FilterConfiguration target = (FilterConfiguration) event.getTarget()
				.getAttribute(AttributeConstants.CONFIGURATION);
		target.setHidden(!((CheckEvent) event).isChecked());

	}

	public void checkDetailItem(Event event) throws Exception {
		DetailConfiguration target = (DetailConfiguration) event.getTarget()
				.getAttribute(AttributeConstants.CONFIGURATION);
		target.setHidden(!((CheckEvent) event).isChecked());

	}

	public void checkOrderAscending(Event event) throws Exception {
		OrderByConfiguration target = (OrderByConfiguration) event.getTarget()
				.getAttribute(AttributeConstants.CONFIGURATION);
		target.setAsc(((CheckEvent) event).isChecked());

	}

	public void moveSelect(Event event) throws Exception {
		moveColumns(event, settingDTO.getColumnConfigurations());

		setSelectItems(comp);

	}

	public void moveOrderBy(Event event) throws Exception {
		moveOrder(event, settingDTO.getOrderByConfigurations());
		setOrderByItems(comp);

	}

	public void moveFilter(Event event) throws Exception {
		moveFilter(event, settingDTO.getFilterConfigurations());

		setFilterItems(comp);

	}

	public void moveEdit(Event event) throws Exception {
		moveDetail(event, settingDTO.getEditConfigurations());

		setFilterItems(comp);

	}

	public void moveDetail(Event event) throws Exception {
		moveDetail(event, settingDTO.getDetailScreenConfigurations());

		setFilterItems(comp);

	}

	public SettingDTO getSettingDTO() {
		return settingDTO;
	}

	public void setSettingDTO(SettingDTO settingDTO) {
		this.settingDTO = settingDTO;
	}

	

	public static void moveColumns(Event event, List<GridColumnConfiguration> list) throws Exception {

		DropEvent dropEvent = (DropEvent) event;
		Object target = event.getTarget().getAttribute(AttributeConstants.CONFIGURATION);
		Object dragged = dropEvent.getDragged().getAttribute(AttributeConstants.CONFIGURATION);

		int targetIndex = list.indexOf(target);
		int draggedIndex = list.indexOf(dragged);

		if (targetIndex < draggedIndex) {
			for (int j = draggedIndex; j > targetIndex; j--) {
				Collections.swap(list, j, j - 1);
			}
		} else {
			for (int j = draggedIndex; j < targetIndex; j++) {
				Collections.swap(list, j + 1, j);
			}
		}
	}

	public static void moveOrder(Event event, List<OrderByConfiguration> list) throws Exception {

		DropEvent dropEvent = (DropEvent) event;
		Object target = event.getTarget().getAttribute(AttributeConstants.CONFIGURATION);
		Object dragged = dropEvent.getDragged().getAttribute(AttributeConstants.CONFIGURATION);

		int targetIndex = list.indexOf(target);
		int draggedIndex = list.indexOf(dragged);

		if (targetIndex < draggedIndex) {
			for (int j = draggedIndex; j > targetIndex; j--) {
				Collections.swap(list, j, j - 1);
			}
		} else {
			for (int j = draggedIndex; j < targetIndex; j++) {
				Collections.swap(list, j + 1, j);
			}
		}
	}

	public static void moveFilter(Event event, List<FilterConfiguration> list) throws Exception {

		DropEvent dropEvent = (DropEvent) event;
		Object target = event.getTarget().getAttribute(AttributeConstants.CONFIGURATION);
		Object dragged = dropEvent.getDragged().getAttribute(AttributeConstants.CONFIGURATION);

		int targetIndex = list.indexOf(target);
		int draggedIndex = list.indexOf(dragged);

		if (targetIndex < draggedIndex) {
			for (int j = draggedIndex; j > targetIndex; j--) {
				Collections.swap(list, j, j - 1);
			}
		} else {
			for (int j = draggedIndex; j < targetIndex; j++) {
				Collections.swap(list, j + 1, j);
			}
		}
	}

	public static void moveDetail(Event event, List<DetailConfiguration> list) throws Exception {

		DropEvent dropEvent = (DropEvent) event;
		Object target = event.getTarget().getAttribute(AttributeConstants.CONFIGURATION);
		Object dragged = dropEvent.getDragged().getAttribute(AttributeConstants.CONFIGURATION);

		int targetIndex = list.indexOf(target);
		int draggedIndex = list.indexOf(dragged);

		if (targetIndex < draggedIndex) {
			for (int j = draggedIndex; j > targetIndex; j--) {
				Collections.swap(list, j, j - 1);
			}
		} else {
			for (int j = draggedIndex; j < targetIndex; j++) {
				Collections.swap(list, j + 1, j);
			}
		}
	}

	public void jsonEditor() throws JsonProcessingException {

		jsonEditor = new JsonEditor();
		jsonEditor.getPanel().setParent(parent);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		String data = mapper.writeValueAsString(settingDTO);
		((Textbox) jsonEditor.getPanel().getFellow("label")).setValue(data);
		((Textbox) jsonEditor.getPanel().getFellow("label")).addEventListener(Events.ON_CHANGE, this::jsonOnChange);

		// Clients.evalJavaScript("editor.set("+Wildcards.addCommaToWildCard(data)+");editor.expandAll()");
		Clients.evalJavaScript("editor.set(" + data + ");editor.expandAll()");

		jsonEditor.getPanel().doModal();
	}

	public void jsonOnChange(Event event) throws Exception {
		Object previousdata = ((InputEvent) event).getPreviousValue();

		String data = previousdata.toString();

		try {
			
			settingDTO=DataSettingFactory.setData(data);
			
			dtSettingDTO=DataSettingFactory.getProvider().setSetting(settingDTO, dtSettingDTO, DesktopHelper.getInputUserGroupId());
			
			
			if (DesktopHelper.getInputUserGroupId() == inputUserGroupSA) {
				MTDefaultDetailScreenController editScreen = new MTDefaultDetailScreenController(dtSettingDTO, parent,
						EditMode.UPDATE,null)
						.init();
				editScreen.doModal();
			} 
			
			DesktopHelper.putSetting(settingDTO.getaSName(), dtSettingDTO);
			
			jsonEditor.getPanel().detach();
			Events.sendEvent(CustomEvents.ON_CHANGINGCONF, parent, null);
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_BAD_METADATA, "Wrong Data in Db");
		}
	}

}
