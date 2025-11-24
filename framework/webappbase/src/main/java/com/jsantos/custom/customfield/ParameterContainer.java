package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.datagrid4.EntityList;
import com.jsantos.gui.datagrid4.GridSelectorType;
import com.jsantos.gui.detail.DetailContainerProvider;
import com.jsantos.gui.filteredgrid.CustomFilteredGrid;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.gui.zKpermission.Permission;
import com.jsantos.gui.zkcomponent.BootstrapFocusEventListener;
import com.jsantos.gui.zkutil.ButtonCssClass;
import com.jsantos.gui.zkutil.ParametersResult;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.search.AttributeConstants;
/**
 * @author raul ripoll
 */
public class ParameterContainer extends Div implements IMTComponent {

	private static final long serialVersionUID = 1L;

	Component listScreenDiv;
	Component headerDiv;
	MTField mtField;
	String label;
	String field;
	boolean readOnly;
	IMTConstraint constraint = new EmptyConstraint();
	IDetachedRecord dRecord;
	ListValues<IDetachedRecord> value;
	EntityList list;
	CustomFilteredGrid customFilteredGrid;
	Label collapseButton;
	Popup menuPopup;
	MTTable mtTable;
	private Integer permissionValue;

	private boolean isUpdated;

	@Override
	public MTDataType forModelType() {

		return MTDataTypes.PARAMETER;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;

	}

	@Override
	public String getLabel() {

		return this.label;
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;

	}

	@Override
	public MTField getMTField() {

		return this.mtField;
	}

	@Override
	public void setField(String field) {
		this.field = field;

	}

	@Override
	public String getField() {
		return this.field;
	}

	@Override
	public void setReadonly(boolean readOnly) {
		this.readOnly = readOnly;
		listScreenDiv.getFellow("HEADER_GREEN").setVisible(!readOnly);
		headerDiv.setVisible(!readOnly);
		if (readOnly)
			list.setSelectorType(GridSelectorType.NONE);
	}

	@Override
	public Object getValue() {
		// IDetachedResult result=list.getDqr();

		return this.value;
	}

	@Override
	public void setValue(Object value) {
		if (null == value || value.equals(DBValueMapper.NULL))
			return;
		this.value = ((ListValues<IDetachedRecord>) value).getCopy();
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		this.dRecord = dRecord;
		setValue(DBValueMapper.loadValue(dRecord, mtField));
		list.setDqr(new ParametersResult(mtField.getMultiRefTo(), value, null));
		list.buildGrid();
	}

	@Override
	public IMTConstraint getConstraints() {

		return this.constraint;
	}

	@Override
	public void setConstraint(IMTConstraint constraint) {
		this.constraint = constraint;

	}

	@Override
	public Component initialize() {

		if (null == mtTable)
			mtTable = mtField.getMultiRefTo();

		permissionValue = Permission.getPermissionByShortCode(mtTable.getFullTableName());

		this.getChildren().clear();
		customFilteredGrid = new CustomFilteredGrid(this, mtTable.getTableName());
		this.addEventListener(CustomEvents.ON_CHANGINGCONF, this::refresh);

		listScreenDiv = Executions.createComponents("~./common/zul/standardlistscreen/standardlistscreen.zul", this,
				null);
		((Label) listScreenDiv.getFellow("HEADER_LABEL")).setValue(mtField.getLabel());

		if (DesktopHelper.isConfEditable()) {
			listScreenDiv.getFellow("CONF_EDITABLE").setVisible(true);

			listScreenDiv.getFellow("CONF_COLUMNS_BUTTON").addEventListener(Events.ON_CLICK, this::customColumns);
			((Label) listScreenDiv.getFellow("CONF_COLUMNS_BUTTON"))
					.setValue(Zklabel.getLabel("filter_configure_columns"));
			listScreenDiv.getFellow("JSON_CONF_BUTTON").addEventListener(Events.ON_CLICK, this::jsonEdit);
			((Label) listScreenDiv.getFellow("JSON_CONF_BUTTON"))
					.setValue(Zklabel.getLabel("filter_configure_edit_json"));

		} else
			listScreenDiv.getFellow("CONF_EDITABLE").setVisible(false);

		listScreenDiv.getFellow("PERMISSIONS").setVisible(false);

		if (DesktopHelper.isLabelEditable()) {
			listScreenDiv.getFellow("LABELS").setVisible(true);
			listScreenDiv.getFellow("LABELS_BUTTON").addEventListener(Events.ON_CLICK, this::editLabels);
			;
			((Label) listScreenDiv.getFellow("LABELS_BUTTON")).setValue(Zklabel.getLabel("filter_configure_labels"));

		} else
			listScreenDiv.getFellow("LABELS").setVisible(false);

		listScreenDiv.getFellow("DROPDOWN_MENU").addEventListener(Events.ON_CLICK, this::popupMenu);
		menuPopup = (Popup) listScreenDiv.getFellow("DROPDOWN_MENU_POPUP");

		list = new EntityList(new ParametersResult(mtField.getMultiRefTo(), value, null), null);
		if (PermissionFactory.getProvider().canWrite(permissionValue)) 
			list.getTopComponent().addEventListener(CustomEvents.ON_DATAGRIDROWCLICK, this::rowEvent);

		headerDiv = (Div) listScreenDiv.getFellow("HEADER_DIV");
		if (!readOnly) {

			if (PermissionFactory.getProvider().canWrite(permissionValue)) {
				addHeaderButton(headerDiv, Zklabel.getLabel("delete"), ButtonCssClass.COLOR_DANGER)
						.addEventListener(Events.ON_CLICK, this::deleteItem);
				addHeaderButton(headerDiv, Zklabel.getLabel("new"), ButtonCssClass.COLOR_PRIMARY)
						.addEventListener(Events.ON_CLICK, this::newItem);
				addHeaderButton(headerDiv, Zklabel.getLabel("edit"), ButtonCssClass.COLOR_INFO)
						.addEventListener(Events.ON_CLICK, this::editItem);
			}
		}

		list.setSelectorType(GridSelectorType.RADIO);
		list.init();
		list.buildGrid().setParent(listScreenDiv.getFellow("GRID"));
		return this;
	}

	public void rowEvent(Event event) throws Exception {
		if (event.getName().equals(CustomEvents.ON_DATAGRIDROWCLICK)) {
			Component row = (Component) event.getData();
			IDetachedRecord detachedRecord = (IDetachedRecord) row.getAttribute(AttributeConstants.DETACHED_RECORD);
			editItem(detachedRecord);
		}
	}

	public void refresh(Event event) throws Exception {
		list.buildGrid();

	}

	public void customColumns(Event event) throws Exception {
		customFilteredGrid.buildAndShowColumns();
		menuPopup.detach();

	}

	public void jsonEdit(Event event) throws Exception {
		customFilteredGrid.jsonEditor();
		menuPopup.detach();
	}

	public Button addHeaderButton(Component parent, String label, String colorClass) {

		Button button = new Button(label);
		button.setSclass("float-right btn " + colorClass);
		button.setParent(parent);
		// new Text(label).setParent(button);
		button.setStyle("margin:3px");

		return button;
	}

	void popupMenu(Event evt) {
		menuPopup.setParent(evt.getTarget());
		menuPopup.open(evt.getTarget(), "overlap");
	}

	void editLabels(Event evt) {

		try {
			CrudScreen screen = new CrudScreen().init(MTBase.getTable("MTLABEL"), this).setCollapsed(true);

			screen.getFilteredGrid().getDetachedQueryResult()
					.setCustomSql(LabelFactory.getProvider().getScreenSearchSql(mtField.getMultiRefTo()));
			screen.build().doModal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void deleteItem(Event evt) {
		if (list.getSelectionMan().getSelectionCount() > 0) {
			for (Object item : list.getSelectionMan().getSelectedSet()) {
				value.remove(item);
				dRecord.getUpdates().set(mtField, value.getCopy());
				setUpdated(true);
			}
			list.getSelectionMan().clear();
			list.buildGrid();
		} else

			Clients.showNotification("Nothing selected", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
	}

	void editItem(Event evt) {
		if (list.getSelectionMan().getSelectionCount() == 1) {
			editItem(((IDetachedRecord) list.getSelectionMan().getSingleSelectedKey()));
		} else
			Clients.showNotification("Nothing selected", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);

	}

	void editItem(IDetachedRecord dr) {

		try {
			IDetailContainer container = DetailContainerProvider.getDetailContainer(mtField.getMultiRefTo());
			container.setParent(this);
			container.setDetachedRecord(dr);
			container.buildAndShowComponent(EditMode.AUTO);
			if (null == container || container.isCancelled())
				return;
			IDetachedRecord ni = container.getDetachedRecord();
			if (ni.isUpdated()) {
				if (null == value)
					value = new ListValues<IDetachedRecord>();
				// value.add(ni);
				ParametersResult rlist = new ParametersResult(mtField.getMultiRefTo(), value, null);
				list.setDqr(rlist);
				list.buildGrid();
				dRecord.getUpdates().set(mtField, value.getCopy());
				setUpdated(true);
			}
			list.getSelectionMan().clear();

		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null,
						2000);
			else
				throw ex;
		}

	}

	protected void newItem(Event evt) {
		try {
			IDetailContainer container = DetailContainerProvider.getDetailContainer(mtField.getMultiRefTo());
			container.setParent(this);
			container.buildAndShowComponent(EditMode.INSERT);
			if (null == container || container.isCancelled())
				return;
			IDetachedRecord ni = container.getDetachedRecord();
			if (null != ni) {
				if (null == value)
					value = new ListValues<IDetachedRecord>();
				if (list.getSelectionMan().getSelectionCount() == 1) {
					insertRow(ni, (IDetachedRecord) list.getSelectionMan().getSingleSelectedKey());
				} else
					value.add(ni);
				ParametersResult rlist = new ParametersResult(mtField.getMultiRefTo(), value, null);
				list.setDqr(rlist);
				list.buildGrid();
				setUpdated(true);

			}
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null,
						2000);
			else {
				ex.printStackTrace();
				Messagebox.show(" Created", " Error !!!" + ex.getMessage(), Messagebox.OK, Messagebox.ERROR);

			}
		}
	}

	public ListValues<IDetachedRecord> insertRow(IDetachedRecord newItem, IDetachedRecord rowItem) throws Exception {
		ListValues<IDetachedRecord> data = value;
		Integer indexdropped = data.lastIndexOf(rowItem);
		if (null != rowItem)
			indexdropped = data.indexOf(rowItem) + 1;
		data.add(indexdropped, newItem);
		return data;
	}

	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible, this);
	}

	public MTTable getMtTable() {
		return mtTable;
	}

	public void setMtTable(MTTable mtTable) {
		this.mtTable = mtTable;
	}

	@Override
	public boolean isUpdated() {

		return isUpdated;
	}

	@Override
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
		if (isUpdated)
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, dRecord);
	}
}
