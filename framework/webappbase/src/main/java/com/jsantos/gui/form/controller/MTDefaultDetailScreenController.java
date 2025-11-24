package com.jsantos.gui.form.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.filteredgrid.CustomFilteredGrid;
import com.jsantos.gui.filteredgrid.FilteredHelp;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.form.IMTForm;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.zKpermission.Permission;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.orm.DBTransaction;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.mt.MTBase;

/**
 * @author raul ripoll
 */

public class MTDefaultDetailScreenController   implements IMTForm{
	protected MTForm mtForm;
	Popup menuPopup;
	CustomFilteredGrid customFilteredGrid;
	Integer permissionValue;
	IDetachedRecord dr;
	Component parent;
	EditMode mode = EditMode.AUTO;
	String URI = "~./common/zul/standardeditscreen/defaultdetailscreen.zul";
	String searchName;
	boolean isCancelled=false;
	
	
	public MTDefaultDetailScreenController(IDetachedRecord dr, Component parent, EditMode mode,String searchName) {
		this.dr = dr;
		this.parent = parent;
		this.mode = mode;
		this.searchName=searchName;
		permissionValue = Permission.getPermissionByShortCode(dr.getTable().getFullTableName());
		if(this.mode == EditMode.AUTO) {
			if (null == dr.getPk()) {
				this.mode = EditMode.INSERT;
			}else if( PermissionFactory.getProvider().canWrite(permissionValue))
				this.mode=EditMode.UPDATE;
			else this.mode=EditMode.SHOW;
			}
		}

	public MTDefaultDetailScreenController init() {
		if(null==searchName)searchName= dr.getTable().getTableName();
		customFilteredGrid = new CustomFilteredGrid(parent, searchName);
		parent.addEventListener(CustomEvents.ON_CHANGINGCONF, this::refresh);
		
		FormZulBuilder zulBuilder = new FormZulBuilder();

		zulBuilder.addFieldsToZul(FilteredHelp.getMTFields(mode,customFilteredGrid.getSettingDTO()), mode);
		zulBuilder.setZulURI(URI);
		zulBuilder.setSearchName(searchName);
		mtForm = new MTForm(zulBuilder.buildForm(parent), mode, null);
		mtForm.setSearchName(searchName);
		mtForm.init();
		mtForm.setHeaderLabel(null == Zklabel.getLabel(dr.getTable().getTableName()) ? dr.getTable().getTableName()
				: Zklabel.getLabel(dr.getTable().getTableName()));

		mtForm.addDetachedRecord(dr);
		if (null != mtForm.getCancelButton())
			mtForm.getCancelButton().addEventListener(Events.ON_CLICK, this::cancelWindow);
		if (null != mtForm.getEditButton()) {
			if (PermissionFactory.getProvider().canWrite(permissionValue)) {
				mtForm.getEditButton().addEventListener(Events.ON_CLICK, this::editWindow);
			}
		}
		if (DesktopHelper.isConfEditable()) {
			mtForm.getFormComponent().getFellow("DROPDOWN_MENU").addEventListener(Events.ON_CLICK, this::popupMenu);
			mtForm.getFormComponent().getFellow("CONF_DETAIL_BUTTON").addEventListener(Events.ON_CLICK,
					this::customDetail);
			mtForm.getFormComponent().getFellow("CONF_EDIT_BUTTON").addEventListener(Events.ON_CLICK, this::customEdit);
			mtForm.getFormComponent().getFellow("JSON_CONF_BUTTON").addEventListener(Events.ON_CLICK, this::jsonEdit);
			mtForm.getFormComponent().getFellow("LABELS_BUTTON").addEventListener(Events.ON_CLICK, this::labelEdit);
			menuPopup = (Popup) mtForm.getFormComponent().getFellow("DROPDOWN_MENU_POPUP");
		}
		if (null != mtForm.getSaveButton())
			mtForm.getSaveButton().addEventListener(Events.ON_CLICK, this::customSave);
		if (PermissionFactory.getProvider().canWrite(permissionValue)) {
			mtForm.getEditButton().setVisible(mode == EditMode.SHOW);
			mtForm.getSaveButton().setVisible(mode != EditMode.SHOW);
		} else {
			mtForm.getEditButton().setVisible(false);
			mtForm.getSaveButton().setVisible(false);
		}
		mtForm.getFormComponent().addEventListener(CustomEvents.ON_CUSTOMFIELD_UPDATE, this::customFieldUpdate);
    return this;
	}

	public void customDetail(Event event) throws Exception {
		customFilteredGrid.buildAndDetail();
		menuPopup.close();;
	}

	public void customEdit(Event event) throws Exception {
		customFilteredGrid.buildAndShowEdit();
		menuPopup.close();
	}

	public void jsonEdit(Event event) throws Exception {
		customFilteredGrid.jsonEditor();
		menuPopup.close();
	}
	
	public void labelEdit(Event event) throws Exception {
		try {
			CrudScreen screen=new CrudScreen()
			.init(MTBase.getTable("MTLABEL"), parent)
			.setCollapsed(true);
			screen.getFilteredGrid().getDetachedQueryResult().setCustomSql(LabelFactory.getProvider().getScreenSearchSql(dr.getTable()));
			screen.build().doModal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		menuPopup.close();
	}
	
	
	void popupMenu(Event evt) {
		menuPopup.setParent(evt.getTarget());
		menuPopup.open(evt.getTarget(), "overlap");
	}

	public boolean doModal() {
		((Window) mtForm.getFormComponent()).doModal();
		return true;
	}

	public void closeWindow(Event event) {
		mtForm.getFormComponent().detach();
	}
	
	public void cancelWindow(Event event) throws Exception {
		mtForm.getFormComponent().detach();
		isCancelled=true;
	}
	
	public void customSave(Event event) {

		try {
			new DBTransaction() {
				@Override
				protected void exec() {
					mtForm.save();
				}
			}.run();
			Clients.showNotification(Zklabel.getLabel(dr.getTable().getTableName(), LocaleFactory.getProvider().getLocale()) + " Created Success !!!", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			closeWindow(event);
			
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
			else throw new RuntimeException(ex);
		}

	}

	public void editWindow(Event event) {
		mode = EditMode.UPDATE;
		FormZulBuilder zulBuilder = new FormZulBuilder();
		zulBuilder.addFieldsToZul(FilteredHelp.getMTFields(mode,customFilteredGrid.getSettingDTO()), mode);

		zulBuilder.setForm(mtForm.getFormComponent());
		zulBuilder.reloadFields();
		ZulDataWirer.initializeFieldValues(dr, mtForm.getFormComponent());
		try {
			ZulDataWirer.initializeFieldConstraints(mtForm.getFormComponent(),searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mtForm.getEditButton().setVisible(false);
		mtForm.getSaveButton().setVisible(true);
		mtForm.setMode(mode);
	}

	public void refresh(Event event) throws Exception {
		mtForm.refresh();
	}
	@Override
	public MTForm getMtForm() {
		return mtForm;
	}
	@Override
	public void setMtForm(MTForm mtForm) {
		this.mtForm = mtForm;
	}

	public Popup getMenuPopup() {
		return menuPopup;
	}

	public void setMenuPopup(Popup menuPopup) {
		this.menuPopup = menuPopup;
	}

	public CustomFilteredGrid getCustomFilteredGrid() {
		return customFilteredGrid;
	}

	public void setCustomFilteredGrid(CustomFilteredGrid customFilteredGrid) {
		this.customFilteredGrid = customFilteredGrid;
	}

	public IDetachedRecord getDr() {
		return dr;
	}

	public void setDr(DetachedRecord dr) {
		this.dr = dr;
	}

	public Component getParent() {
		return parent;
	}

	public void setParent(Component parent) {
		this.parent = parent;
	}

	public EditMode getMode() {
		return mode;
	}

	public void setMode(EditMode mode) {
		this.mode = mode;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public boolean isCancelled() {
		return isCancelled;
	}
	
public void customFieldUpdate(Event event) {
	    ((MapValues<Object>)event.getData()).add("Component", mtForm.getFormComponent());
		Events.sendEvent(
				new Event(CustomEvents.ON_CUSTOMFIELD_UPDATE, parent,	event.getData())
						);
		
	}
}
