package com.jsantos.demo.screen.account;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;

import com.jsantos.common.model.EditMode;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.zkcomponent.MTSelectbox;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.metadata.crm.CustomerPaymentMethodDTO;
import com.jsantos.metadata.crm.HCustomerDTO;
import com.jsantos.metadata.crm.HEmailAddressDTO;
import com.jsantos.metadata.crm.HPersonOrCompanyDTO;
import com.jsantos.metadata.crm.HPhoneNumberDTO;
import com.jsantos.metadata.crm.HPostalAddressDTO;
import com.jsantos.metadata.payment.EnuPaymentType;
import com.jsantos.metadata.payment.PaymentMethodDTO;
import com.jsantos.orm.DBTransaction;
import com.jsantos.orm.exceptions.ConstraintsException;

public class CreateAccount implements EventListener<Event> {
	protected MTForm mtForm;
	MTSelectbox paymentTypeSelector;

	public Component buildEditorScreen(Component comp,boolean isModal) throws WrongValueException, SQLException {
		try {
			if(!isModal)
				comp.getChildren().clear();

			FormZulBuilder zulBuilder = new FormZulBuilder();
			zulBuilder.setZulURI("/screen/account/create.zul");

			mtForm = new MTForm(zulBuilder.buildForm(comp), EditMode.INSERT, null).init();
			
			mtForm.getSaveButton().addEventListener(Events.ON_CLICK, this);
			paymentTypeSelector = (MTSelectbox) mtForm.getFormComponent().getFellowIfAny("PAYMENT_TYPE_SELECTOR");
			paymentTypeSelector.addEventListener(Events.ON_SELECT, this::setPaymentType);

		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
		return mtForm.getFormComponent();
	}

	void setPaymentType(Event evt) {
		mtForm.getFormComponent().getFellowIfAny("CREDIT_CARD_NUMBER").setVisible(false);
		mtForm.getFormComponent().getFellowIfAny("ACCOUNT_NUMBER").setVisible(false);
		mtForm.getFormComponent().getFellowIfAny("CHECK_NUMBER").setVisible(false);

		Integer paymentTypeId = paymentTypeSelector.getPk();
		if (null != paymentTypeId) {
			if (paymentTypeSelector.getPk() == EnuPaymentType.VISA
					|| paymentTypeSelector.getPk() == EnuPaymentType.MCARD
					|| paymentTypeSelector.getPk() == EnuPaymentType.AMEX
					|| paymentTypeSelector.getPk() == EnuPaymentType.DISC) {
				mtForm.getFormComponent().getFellowIfAny("CREDIT_CARD_NUMBER").setVisible(true);
			}
			if (paymentTypeSelector.getPk() == EnuPaymentType.DIRECTDEBIT) {
				mtForm.getFormComponent().getFellowIfAny("ACCOUNT_NUMBER").setVisible(true);
			}
			if (paymentTypeSelector.getPk() == EnuPaymentType.CHECK) {
				mtForm.getFormComponent().getFellowIfAny("CHECK_NUMBER").setVisible(true);
			}
		}
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if (event.getTarget().equals(mtForm.getSaveButton())) {
			save();
		}
	}

	public void save() throws SQLException {
		try {
			new DBTransaction() {
			@Override
			protected void exec() {
				HPersonOrCompanyDTO person = new HPersonOrCompanyDTO();
				HCustomerDTO customer = new HCustomerDTO();
				HPostalAddressDTO address = new HPostalAddressDTO();
				HPhoneNumberDTO phone = new HPhoneNumberDTO();
				HEmailAddressDTO email = new HEmailAddressDTO();
				PaymentMethodDTO paymentMethod = new PaymentMethodDTO();

				ZulDataWirer.readFormFieldValues(person, mtForm.getFormComponent());
				ZulDataWirer.readFormFieldValues(customer, mtForm.getFormComponent());
				ZulDataWirer.readFormFieldValues(address, mtForm.getFormComponent());
				ZulDataWirer.readFormFieldValues(phone, mtForm.getFormComponent());
				ZulDataWirer.readFormFieldValues(email, mtForm.getFormComponent());
				ZulDataWirer.readFormFieldValues(paymentMethod, mtForm.getFormComponent());

				if (StringUtils.isNotBlank(email.getAddress()))
					person.setEmailAddressId(email.insert().getEmailAddressId());
				if (StringUtils.isNotBlank(phone.getNumber()))
					person.setPhoneNumberId(phone.insert().getPhoneNumberId());

				person.insert();
				address.insert();

				customer.setMainContactPersonOrCompanyId(person.getPersonOrCompanyId());
				customer.setMailingPostalAddressId(address.getPostalAddressId());
				customer.setShippingPostalAddressId(address.getPostalAddressId());
				customer.insert();

				if (paymentMethod.getPaymentTypeId() == EnuPaymentType.VISA
						&& StringUtils.isNotBlank(paymentMethod.getCcNumber()))
					paymentMethod.setCcNumber("***" + paymentMethod.getCcNumber()
							.substring(paymentMethod.getCcNumber().length() - 4, paymentMethod.getCcNumber().length()));
				paymentMethod.insert();

				CustomerPaymentMethodDTO customerPaymentMethod = new CustomerPaymentMethodDTO();
				customerPaymentMethod.setCustomerId(customer.getCustomerId());
				customerPaymentMethod.setPaymentMethodId(paymentMethod.getPaymentMethodId());
				customerPaymentMethod.insert();

				
			}
		}.run();
		Clients.showNotification("Account Created Success !!!", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
		//Messagebox.show("Account Created", "Success !!!", Messagebox.OK, Messagebox.INFORMATION);
		mtForm.getFormComponent().detach();
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
				//Messagebox.show("Account" + "Not Updated", " Error !!!",Messagebox.OK, Messagebox.ERROR);
		}
		
	}

}
