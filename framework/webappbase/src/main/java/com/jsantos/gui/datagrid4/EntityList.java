package com.jsantos.gui.datagrid4;

import org.zkoss.util.resource.Labels;
import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.event.PagingEvent;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.zkcomponent.MTSelectbox;
import com.jsantos.orm.dbstatement.DQResults;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedResult;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;

public class EntityList {
	GridSelectorType selectorType = GridSelectorType.NONE;
	IDetachedResult dqr;
	int activePage = 0;
	boolean showPageSizeSelector = false;
	boolean showPaging = true;
	MTSelectbox pageSizeSelector = null;
	Div topComponent;
	SettingDTO settingDTO;
	DQResults<IDetachedRecord> results;
	private ISelectionMan selectionMan;

	EventListener<Event> eventListener;

	Listbox listBox;
	Auxhead auxhead;

	boolean autoSized = true;

	public EntityList(IDetachedResult dqr, SettingDTO settingDTO) {
		this.dqr = dqr;
		this.settingDTO = settingDTO;
		topComponent = new Div();
		topComponent.setSclass("h-100 v-100");
		topComponent.setStyle("position:relative;overflow:auto;");
	}

	public EntityList init() {
		if (null == settingDTO) {
			settingDTO = DesktopHelper.getSetting(dqr.getmTTable().getTableName(), DesktopHelper.getInputUserId(),
					LocaleFactory.getProvider().getLocale());
		}

		if (null != eventListener) {
			topComponent.addEventListener(CustomEvents.ON_DATAGRIDCELLCLICK, eventListener);
			topComponent.addEventListener(CustomEvents.ON_DATAGRIDCELLDOUBLECLICK, eventListener);
			topComponent.addEventListener(CustomEvents.ON_DATAGRIDROWCLICK, eventListener);
			topComponent.addEventListener(CustomEvents.ON_SELECTORCLICK, eventListener);
			topComponent.addEventListener(CustomEvents.ON_PAGING, eventListener);
			
		}

		selectionMan = new SelectionMan(selectorType);
		return this;
	}

	public Div buildGrid() {
		topComponent.getChildren().clear();
		listBox = new Listbox();
		listBox.setSpan("true");
		listBox.setParent(topComponent);
		listBox.setStyle("position: absolute; inset: 0px 0px 60px; overflow: auto;");

		if (selectorType == GridSelectorType.RADIO) {
			Radiogroup radiogroup = new Radiogroup();
			radiogroup.setParent(topComponent);
			listBox.setParent(radiogroup);
		}

		if (!autoSized)
			listBox.setStyle("position:absolute;left:0px;top:0px;bottom:60px;right:0px;overflow-y:auto");
		Listhead listhead = new Listhead();
		listhead.setSizable(true);
		listhead.setParent(listBox);
		buildSelectorColumnHeader(listhead);

		for (GridColumnConfiguration config : settingDTO.getColumnConfigurations()) {
			MTField mtField = config.getMtField();
			if (null == mtField) {
				System.out.println(settingDTO.getaSName() + "DataGrid Configuration is obsolete " + config.getName()
						+ " don't exits");
				Clients.showNotification("DataGrid Configuration is obsolete ", Clients.NOTIFICATION_TYPE_ERROR, null,
						null, 2000);
				continue;
			}
			if (config.isActive()) {
				Listheader header = new Listheader(
						LabelFactory.getProvider().get(config.getMtField(), LocaleFactory.getProvider().getLocale()));

				if (null == mtField.getLength())
					header.setHflex("min");
				else
					header.setHflex("1");
				header.setVisible(!config.isHidden());

				header.setParent(listhead);
				header.setAttribute(AttributeConstants.COLUMN_CONFIGURATION, config);
				header.setHflex("min");
				try {
					header.setSort("auto");
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}

		results = dqr.getPage(activePage);

		ListItemEntity listItemEntity = new ListItemEntity(selectionMan, selectorType, topComponent, settingDTO);

		if (null == results.getRawData())
			return topComponent;
		for (IDetachedRecord datarecord : results.getRawData()) {
			Listitem listItem = new Listitem();
			listItem.setParent(listBox);
			listItem.setDraggable("true");
			listItem.setDroppable("true");
			listItem.addEventListener(Events.ON_DROP, this::moveRow);

			listItem.setAttribute(AttributeConstants.DETACHED_RECORD, datarecord);
			listItem.addEventListener(Events.ON_CLICK, this::rowEvent);
			listItemEntity.build(listItem, datarecord);
		}

		if (null != dqr.getMaxResults() && null != dqr.getPageSize() && dqr.getMaxResults() > dqr.getPageSize()) {

			Paging paging = new Paging();

			paging.setTotalSize(dqr.getMaxResults());
			paging.setPageSize(dqr.getPageSize());
			paging.setActivePage(activePage);

			paging.setSclass("mt-list-paging");
			paging.setMold("os");
			paging.addEventListener(CustomEvents.ON_PAGING, this::pagingEvent);

			paging.setVisible(showPaging);

			paging.setParent(topComponent);
		}

		if (showPageSizeSelector) {
			pageSizeSelector = new MTSelectbox();

			pageSizeSelector.add(10, Labels.getLabel("pagination.format", new java.lang.Object[] { 10 }), true);
			pageSizeSelector.add(15, Labels.getLabel("pagination.format", new java.lang.Object[] { 15 }), false);
			pageSizeSelector.add(20, Labels.getLabel("pagination.format", new java.lang.Object[] { 20 }), false);
			pageSizeSelector.add(30, Labels.getLabel("pagination.format", new java.lang.Object[] { 30 }), false);
			pageSizeSelector.add(100, Labels.getLabel("pagination.format", new java.lang.Object[] { 100 }), false);

			pageSizeSelector.setParent(topComponent);
			pageSizeSelector.setClass("mt-list-pagesize-selector");
			pageSizeSelector.setPk(dqr.getPageSize());
			pageSizeSelector.addEventListener(Events.ON_SELECT, this::pageSizeSelector);
		}

		return topComponent;
	}
	
	void rowEvent(Event event) throws Exception {
		Events.sendEvent(CustomEvents.ON_DATAGRIDROWCLICK, topComponent, event.getTarget());
	}
	
	void pageSizeSelector(Event evt) throws Exception {
		if (null != pageSizeSelector.getPk())
			setPageSize(pageSizeSelector.getPk());
		buildGrid();
	}

	void pagingEvent(Event evt) throws Exception {
		activePage = ((PagingEvent) evt).getActivePage();
		buildGrid();
	}

	public void setPageSize(int pageSize) {
		dqr.setPageSize(pageSize);
	}

	public GridSelectorType getSelectorType() {
		return selectorType;
	}

	public EntityList setSelectorType(GridSelectorType selectorType) {
		this.selectorType = selectorType;
		return this;
	}

	void buildSelectorColumnHeader(Listhead listHead) {
		if (GridSelectorType.CHECKBOX == selectorType) {
			Listheader header = new Listheader();
			header.setWidth("45px");
			header.setParent(listHead);
		}
		if (GridSelectorType.RADIO == selectorType) {
			Listheader header = new Listheader();
			header.setWidth("45px");
			header.setParent(listHead);
		}
	}

	/*
	 * public void sort(Event event) { SortEvent sortevent= (SortEvent)event;
	 * settingDTO.getOrderByConfigurations().stream().forEach(c->
	 * c.setActive(false)); OrderByConfiguration orderItem=
	 * ((OrderByConfiguration)sortevent.getTarget().getAttribute(AttributeConstants.
	 * ORDER_BY_CONFIGURATION)); orderItem.setActive(true);
	 * orderItem.setAsc(!orderItem.isAsc()); buildGrid(); event.stopPropagation(); }
	 */
	
	
	
	public void moveRow(Event event) throws Exception {
		DropEvent dropEvent = (DropEvent) event;

		Listitem draged = (Listitem) dropEvent.getDragged();
		Listitem dropped = (Listitem) dropEvent.getTarget();

		draged.getParent().insertBefore(draged, dropped);
	
		DetachedRecord dragedDetach=   (DetachedRecord) draged.getAttribute(AttributeConstants.DETACHED_RECORD);
		DetachedRecord droppedDetach=   (DetachedRecord) dropped.getAttribute(AttributeConstants.DETACHED_RECORD);
		ListValues<IDetachedRecord> data=results.getRawData();
		
		Integer indexdraged=data.indexOf(dragedDetach);
		Integer indexdropped=data.indexOf(droppedDetach);
		
		data.remove(dragedDetach);
		//data.remove(droppedDetach);
		
		data.add(indexdropped, dragedDetach);
		/*
		if(indexdraged<indexdropped) {
			data.add(indexdraged<data.size()?indexdraged:data.size(), droppedDetach);
			data.add(indexdropped<data.size()?indexdropped:data.size(), dragedDetach);
		}else {
			data.add(indexdropped<data.size()?indexdropped:data.size(), dragedDetach);
			data.add(indexdraged<data.size()?indexdraged:data.size(), droppedDetach);
		}
		*/
	}

	public IDetachedResult getDqr() {
		return dqr;
	}

	public EntityList setDqr(IDetachedResult dqr) {
		this.dqr = dqr;
		return this;
	}

	public int getActivePage() {
		return activePage;
	}

	public EntityList setActivePage(int activePage) {
		this.activePage = activePage;
		return this;
	}

	public Div getParent() {
		return topComponent;
	}

	public EntityList setParent(Div parent) {
		this.topComponent = parent;
		return this;
	}

	public boolean isShowPageSizeSelector() {
		return showPageSizeSelector;
	}

	public EntityList setShowPageSizeSelector(boolean showPageSizeSelector) {
		this.showPageSizeSelector = showPageSizeSelector;
		return this;
	}

	public boolean isAutoSized() {
		return autoSized;
	}

	public EntityList setAutoSized(boolean autoSized) {
		this.autoSized = autoSized;
		return this;
	}

	public SettingDTO getSettingDTO() {
		return settingDTO;
	}

	public EntityList setSettingDTO(SettingDTO settingDTO) {
		this.settingDTO = settingDTO;
		return this;
	}

	public Div getTopComponent() {
		return topComponent;
	}

	public boolean isShowPaging() {
		return showPaging;
	}

	public void setShowPaging(boolean showPaging) {
		this.showPaging = showPaging;
	}

	public ISelectionMan getSelectionMan() {
		return selectionMan;
	}

	public EventListener<Event> getEventListener() {
		return eventListener;
	}

	public EntityList setEventListener(EventListener<Event> eventListener) {
		this.eventListener = eventListener;
		return this;
	}
}
