package com.jsantos.custom.details;

import java.text.NumberFormat;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.registry.FieldRendererProvider;
import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.fieldrenderer.general.DefaultFieldRenderer;
import com.jsantos.demo.screen.account.payment.PaymentScreen;
import com.jsantos.demo.screen.cscase.CreateCase;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.datagrid4.EntityGrid;
import com.jsantos.gui.filteredgrid.FilteredGrid;
import com.jsantos.gui.form.IFormSerializer;
import com.jsantos.gui.form.controller.MTDefaultDetailScreenController;
import com.jsantos.gui.form.controller.MTInsertScreenController;
import com.jsantos.ledger.LedgerInterface;
import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.metadata.acc.MTTableVTRANSACTIONHISTORY;
import com.jsantos.metadata.crm.HCustomerDTO;
import com.jsantos.metadata.crm.HEmailAddressDTO;
import com.jsantos.metadata.crm.HPersonOrCompanyDTO;
import com.jsantos.metadata.crm.HPhoneNumberDTO;
import com.jsantos.metadata.crm.HPostalAddressDTO;
import com.jsantos.metadata.crm.MTTableHPHONENUMBER;
import com.jsantos.metadata.crm.MTTableVDETAILPAGECASELIST;
import com.jsantos.metadata.crm.MTTableVDETAILPAGEVEHICLELIST;
import com.jsantos.metadata.inv.MTTableVDETAILPAGEINVOICELIST;
import com.jsantos.metadata.payment.MTTableVPAYMENTMETHODS;
import com.jsantos.metadata.tolling.CustomerVehicleDTO;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.orm.pattern.autohistory.AutohistoryHelper;

public class AccountDetails implements IDetailContainer {
	Component parent;
	MTTable mTTable = MTroadRunnerData.HCUSTOMER;
    boolean isCancelled=false;
	Component comp = null;
	HCustomerDTO customer;

	public AccountDetails() {
		super();
	}
		
	@Override
	public IDetailContainer buildAndShowComponent(EditMode mode) {
		Integer childrenCount=parent.getChildren().size();
		try {
			comp = Executions.createComponents("~./zul/poyake-roadrunner/screen/account/details.zul", parent, null);
		} catch (UiException e) {
			try {
				if(parent.getChildren().size()>childrenCount)
					parent.getChildren().remove(parent.getChildren().size()-1);
			} catch (Exception e2) {
			}
			return null;
		}
		setDetails(comp);
		((Window) comp).doModal();
		return this;
	}

	public void reload() {
		comp.detach();
		buildAndShowComponent(null);
	}

	public void setDetails(Component comp) {
		
		Integer customerId=customer.getCustomerId();
		HPersonOrCompanyDTO person = new HPersonOrCompanyDTO(true, customer.getMainContactPersonOrCompanyId());
		((Label) comp.getFellow("FIRST_NAME")).setValue(person.getFirstName());
		((Label) comp.getFellow("LAST_NAME")).setValue(person.getLastNameOrCompanyName());
		((Label) comp.getFellow("CUSTOMER_NUMBER_LABEL")).setValue(" " + customerId + " - "
				+ person.getFirstName() + " " + person.getLastNameOrCompanyName());

		comp.getFellow("MODIFY_ADDRESS").addEventListener(Events.ON_CLICK, this::modifyAddress);
		comp.getFellow("MODIFY_PHONE_NUMBER").addEventListener(Events.ON_CLICK, this::modifyPhone);
		comp.getFellow("MODIFY_EMAIL_ADDRESS").addEventListener(Events.ON_CLICK, this::modifyEmail);
		
		Integer mailingPostalAddressId=customer.getMailingPostalAddressId();
		
		if (null != mailingPostalAddressId) {
			HPostalAddressDTO address = new HPostalAddressDTO(true, mailingPostalAddressId);
			((Label) comp.getFellow("ADDRESS_LINE1")).setValue(address.getAddress1());
			((Label) comp.getFellow("ADDRESS_LINE2")).setValue(address.getAddress2());
			((Label) comp.getFellow("ADDRESS_CITY")).setValue(address.getCity());
			((Label) comp.getFellow("ADDRESS_CP")).setValue(address.getPostalCode());
		}

		if (null != person.getPhoneNumberId()) {
			HPhoneNumberDTO phoneNumber = new HPhoneNumberDTO(true, person.getPhoneNumberId());
			IMTFieldRenderer renderer = FieldRendererProvider.getRenderer(MTTableHPHONENUMBER.PHONETYPEID);
			if(null==renderer)renderer=new DefaultFieldRenderer();
			
			((Label) comp.getFellow("PHONE_NUMBER_TYPE"))
					.setValue(renderer.render(phoneNumber.getPhoneTypeId(), MTTableHPHONENUMBER.PHONETYPEID, null, LocaleFactory.getProvider().getLocale()));
			((Label) comp.getFellow("PHONE_NUMBER")).setValue(phoneNumber.getNumber());
			((Label) comp.getFellow("PHONE_NUMBER_EXTENSION")).setValue(phoneNumber.getExtension());
		}
		if (null != person.getEmailAddressId()) {
			HEmailAddressDTO emailAddress = new HEmailAddressDTO(true, person.getEmailAddressId());
			((Label) comp.getFellow("EMAIL_ADDRESS")).setValue(emailAddress.getAddress());
		}

		comp.getFellow("ADD_VEHICLE").addEventListener(Events.ON_CLICK, this::addVehicle);
		EntityGrid vehicleGrid = new EntityGrid(
				new DetachedQueryResult(MTroadRunnerData.VDETAILPAGEVEHICLELIST, " and customerId=" + customerId), null).init();
		vehicleGrid.setPageSize(4);
		vehicleGrid.setShowPageSizeSelector(false);
		vehicleGrid.setShowPaging(false);
		GridColumnConfiguration
				.get(vehicleGrid.getSettingDTO().getColumnConfigurations(), MTTableVDETAILPAGEVEHICLELIST.CUSTOMERID)
				.setHidden(true);
		vehicleGrid.buildGrid().setParent(comp.getFellow("VEHICLE_LIST"));

		EntityGrid invoiceGrid = new EntityGrid(
				new DetachedQueryResult(MTroadRunnerData.VDETAILPAGEINVOICELIST, " and customerId=" + customerId), null).init();
		invoiceGrid.setPageSize(4);
		invoiceGrid.setShowPageSizeSelector(false);
		invoiceGrid.setShowPaging(false);
		GridColumnConfiguration
				.get(invoiceGrid.getSettingDTO().getColumnConfigurations(), MTTableVDETAILPAGEINVOICELIST.CUSTOMERID)
				.setHidden(true);
		invoiceGrid.buildGrid().setParent(comp.getFellow("INVOICE_LIST"));

		EntityGrid caseGrid = new EntityGrid(
				new DetachedQueryResult(MTroadRunnerData.VDETAILPAGECASELIST, " and customerId=" + customerId), null).init();
		caseGrid.setPageSize(4);
		caseGrid.setShowPageSizeSelector(false);
		caseGrid.setShowPaging(false);
		GridColumnConfiguration
				.get(caseGrid.getSettingDTO().getColumnConfigurations(), MTTableVDETAILPAGECASELIST.CUSTOMERID)
				.setHidden(true);
		caseGrid.buildGrid().setParent(comp.getFellow("CASE_LIST"));

		EntityGrid paymentMethodGrid = new EntityGrid(
				new DetachedQueryResult(MTroadRunnerData.VPAYMENTMETHODS, " and customerId=" + customerId), null).init();
		paymentMethodGrid.setPageSize(4);
		paymentMethodGrid.setShowPageSizeSelector(false);
		invoiceGrid.setShowPaging(false);
		GridColumnConfiguration
				.get(paymentMethodGrid.getSettingDTO().getColumnConfigurations(), MTTableVPAYMENTMETHODS.CUSTOMERID)
				.setHidden(true);
		paymentMethodGrid.buildGrid().setParent(comp.getFellow("PAYMENT_METHOD_LIST"));

		comp.getFellow("ADD_PAYMENT").addEventListener(Events.ON_CLICK, this::addPayment);

		Component historyGrid = comp.getFellow("HISTORY_GRID");
		FilteredGrid filteredGrid = new FilteredGrid(
				new DetachedQueryResult(MTroadRunnerData.VCUSTOMERHISTORY, " and customerId=" + customerId), historyGrid).init();
		filteredGrid.setEmbeddedStyle(true);
		filteredGrid.setHeaderLabel("History");
		filteredGrid.build();

		Component transactionHistoryGrid = comp.getFellow("TRANSACTION_HISTORY_GRID");
		DetachedQueryResult thDqr = new DetachedQueryResult(MTroadRunnerData.VTRANSACTIONHISTORY, " and customerId=" + customerId);
		FilteredGrid filteredGridTH = new FilteredGrid(thDqr, transactionHistoryGrid).init();
		GridColumnConfiguration.get(filteredGridTH.getEntityGrid().getSettingDTO().getColumnConfigurations(),
				MTTableVTRANSACTIONHISTORY.CUSTOMERID).setHidden(true);
		
		filteredGridTH.setEmbeddedStyle(true);
		filteredGridTH.setHeaderLabel("Transaction History");
		filteredGridTH.build();

		FilteredGrid casesGrid = new FilteredGrid(
				new DetachedQueryResult(MTroadRunnerData.VDETAILPAGECASELIST, " and customerId=" + customerId),
				comp.getFellow("CASES_GRID")).init();
		casesGrid.setEmbeddedStyle(true);
		casesGrid.setHeaderLabel("Cases");
		casesGrid.build();

		((Label) comp.getFellowIfAny("BALANCE"))
				.setValue(NumberFormat.getCurrencyInstance().format(LedgerInterface.getBalance(customerId)));

		comp.getFellow("DETAILS_BUTTON_CLOSE").addEventListener(Events.ON_CLICK, this::cancelWindow);
		comp.getFellow("CREATE_CASE").addEventListener(Events.ON_CLICK, this::createCase);
	}

	public void createCase(Event evt) {
		new CreateCase(customer.getCustomerId()).buildModalScreen(comp);
	}

	public void addPayment(Event evt) {
		MTInsertScreenController screen = new PaymentScreen(parent, ((HCustomerDTO) getDetachedRecord()).getCustomerId());
		if (screen.doModal())
			reload();
	}

	public void modifyAddress(Event event) throws Exception {
		Integer mailingPostalAddressId=customer.getMailingPostalAddressId();

		MTDefaultDetailScreenController testController= new MTDefaultDetailScreenController(
				null==mailingPostalAddressId?new HPostalAddressDTO():new HPostalAddressDTO(mailingPostalAddressId)
				, parent
				,EditMode.UPDATE,null)
				.init();
		
		if (testController.doModal()) {
			if(null==mailingPostalAddressId) {
			customer.set(MTroadRunnerData.HCUSTOMER.MAILINGPOSTALADDRESSID, (Integer) testController.getMtForm().getDrs().get(MTroadRunnerData.HPOSTALADDRESS)
					.get(MTroadRunnerData.HPOSTALADDRESS.POSTALADDRESSID));
			customer.update();
			}
			reload();
		}
	}

	public void modifyPhone(Event event) throws Exception {
		
		HPersonOrCompanyDTO person = new HPersonOrCompanyDTO(true, customer.getMainContactPersonOrCompanyId());
		
		MTDefaultDetailScreenController testController= new MTDefaultDetailScreenController(
				null==person.getPhoneNumberId()?new HPhoneNumberDTO():new HPhoneNumberDTO(person.getPhoneNumberId())
				, parent,EditMode.UPDATE,null)
				.init();
		
		if (testController.doModal()) {
			if(null==person.getPhoneNumberId()) {
				person.setPhoneNumberId((Integer) testController.getMtForm().getDrs().get(MTroadRunnerData.HPHONENUMBER)
					.get(MTroadRunnerData.HPHONENUMBER.PHONENUMBERID));
				person.update();
			//customer.update();
			}
			reload();
		}
	}

	public void modifyEmail(Event event) throws Exception {
		
		HPersonOrCompanyDTO person = new HPersonOrCompanyDTO(true, customer.getMainContactPersonOrCompanyId());
		
		MTDefaultDetailScreenController testController= new MTDefaultDetailScreenController(
				null==person.getEmailAddressId()?new HEmailAddressDTO():new HEmailAddressDTO(person.getEmailAddressId())
				, parent,EditMode.UPDATE,null)
				.init();
		
		if (testController.doModal()) {
			if(null==person.getEmailAddressId()) {
				person.setEmailAddressId((Integer) testController.getMtForm().getDrs().get(MTroadRunnerData.HEMAILADDRESS)
					.get(MTroadRunnerData.HEMAILADDRESS.EMAILADDRESSID));
				person.update();
			}
			reload();
		}
	}

	public void addVehicle(Event event) throws Exception {
		
		Integer customerId=customer.getCustomerId();
		if (event.getTarget().getId().equals("ADD_VEHICLE")) {
			MTInsertScreenController screen = new MTInsertScreenController(parent, MTroadRunnerData.LICENSEPLATE, MTroadRunnerData.VEHICLEINFO,MTroadRunnerData.CUSTOMERVEHICLE);
			CustomerVehicleDTO customerVehicle = new CustomerVehicleDTO();
			customerVehicle.setCustomerId(customerId);
			screen.getMtForm().addDetachedRecord(customerVehicle);

			if (screen.doModal())
				reload();
		}
	}

	void closeWindow(Event event) {
		
		comp.detach();
	}
	void cancelWindow(Event event) {
		isCancelled=true;
		closeWindow(event);;
	}

	@Override
	public MTTable getmTTable() {
		return MTroadRunnerData.HCUSTOMER;
	}

	public Component getParent() {
		return parent;
	}

	@Override
	public IDetailContainer setParent(Component parent) {
		this.parent = parent;return this;
	}

	@Override
	public IDetailContainer setmTTable(MTTable table) {
		mTTable = table;return this;

	}

	@Override
	public IDetailContainer setInitialParameters(MapValues<Object> initialParameter) {
		return this;// TODO Auto-generated method stub

	}

	@Override
	public IDetailContainer setSearchName(String searchName) {
		return this;// TODO Auto-generated method stub
		
	}

	@Override
	public Component getFormComponent() {
		return comp;
	}

	@Override
	public IDetailContainer buildComponent(EditMode mode) {
		return this;
	}

	@Override
	public IDetailContainer showComponent() {
		return this;
	}

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public IDetailContainer setDetachedRecord(IDetachedRecord dr) {
		customer=(HCustomerDTO) AutohistoryHelper.getByMainFk(mTTable, dr.get(dr.findFieldByname(MTroadRunnerData.HCUSTOMER.CUSTOMERID.getName())   ));
		return this;
	}

	@Override
	public IDetailContainer setFormSerialize(IFormSerializer serializer) {
		return this;
	}

	@Override
	public IDetachedRecord getDetachedRecord() {
		return customer;
	}
}
