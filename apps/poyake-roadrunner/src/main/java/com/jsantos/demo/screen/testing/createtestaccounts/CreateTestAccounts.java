package com.jsantos.demo.screen.testing.createtestaccounts;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.RandomStringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.PhoneNumber;
import com.jsantos.demo.screen.testing.createtesttrips.CreateTestTrips;
import com.jsantos.gui.zkcomponent.MTIntbox;
import com.jsantos.ledger.LedgerInterface;
import com.jsantos.metadata.crm.CustomerPaymentMethodDTO;
import com.jsantos.metadata.crm.HCustomerDTO;
import com.jsantos.metadata.crm.HEmailAddressDTO;
import com.jsantos.metadata.crm.HPersonOrCompanyDTO;
import com.jsantos.metadata.crm.HPhoneNumberDTO;
import com.jsantos.metadata.crm.HPostalAddressDTO;
import com.jsantos.metadata.payment.EnuPaymentType;
import com.jsantos.metadata.payment.PaymentDTO;
import com.jsantos.metadata.payment.PaymentMethodDTO;
import com.jsantos.metadata.tolling.CustomerVehicleDTO;
import com.jsantos.metadata.tolling.EnuLicensePlateJurisdiction;
import com.jsantos.metadata.tolling.EnuLicensePlateType;
import com.jsantos.metadata.tolling.EnuVehicleClass;
import com.jsantos.metadata.tolling.LicensePlateDTO;
import com.jsantos.metadata.tolling.VehicleInfoDTO;
import com.jsantos.orm.DBTransaction;

public class CreateTestAccounts implements EventListener<Event> {
	MTIntbox numberOfAccounts;
	
	public void buildScreen(Component parent) {
		parent.getChildren().clear();
		Component mainDiv = Executions.createComponents("~./zul/poyake-roadrunner/screen/test/create_test_accounts.zul", parent, null);
		mainDiv.getFellowIfAny("SAVE_BUTTON").addEventListener(Events.ON_CLICK, this::create);
		numberOfAccounts = (MTIntbox)mainDiv.getFellowIfAny("NUMBER_OF_ACCOUNTS");
		numberOfAccounts.setValue(numberOfAccounts.getValue());
	}
	
	public void create(Event evt) {
		try {
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
			for (int i=0; i<=numberOfAccounts.getValue();i++) {
				executor.submit(() -> {
					createSingleAccount();
				    return null;
				});
			}
			Messagebox.show("Done");
		}
		catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void createSingleAccount() {
		
		new DBTransaction() {
			@Override
			protected void exec() {
				Faker faker = new Faker();
				
				HPersonOrCompanyDTO person = new HPersonOrCompanyDTO();
				HCustomerDTO customer = new HCustomerDTO();
				HPostalAddressDTO address = new HPostalAddressDTO();
				HPhoneNumberDTO phone = new HPhoneNumberDTO();
				HEmailAddressDTO email = new HEmailAddressDTO();
		
				PhoneNumber fPhone = faker.phoneNumber();
				phone.setNumber(fPhone.cellPhone());
				person.setPhoneNumberId(phone.insert().getPhoneNumberId());
				
				Name fName =faker.name();
				String firstName = fName.firstName();
				String lastName = fName.lastName();
				
				String emailAddress = firstName.toLowerCase().substring(0,1) + "." + lastName.toLowerCase() + "@gmail.com";
				email.setAddress(emailAddress);
				person.setEmailAddressId(email.insert().getEmailAddressId());
				 
				person.setFirstName(firstName);
				person.setLastNameOrCompanyName(lastName);
				person.setDesignation(fName.title());
				person.insert();
				
				Address fAddress = faker.address();
				address.setAddress1(fAddress.streetAddress());
				address.setCity(fAddress.city());
				address.setStateProvinceId(0);
				address.setPostalCode(fAddress.zipCode());
				address.insert();
				
				customer.setMainContactPersonOrCompanyId(person.getPersonOrCompanyId());
				customer.setMailingPostalAddressId(address.getPostalAddressId());
				customer.setShippingPostalAddressId(address.getPostalAddressId());
				customer.insert();
				
				
				PaymentMethodDTO paymentMethod = new PaymentMethodDTO();
				paymentMethod.setPaymentTypeId(EnuPaymentType.VISA);
				paymentMethod.setCcNumber("***" + String.format("%04d", new Random().nextInt(10000)));
				paymentMethod.insert();
				
				CustomerPaymentMethodDTO customerPaymentMethod = new CustomerPaymentMethodDTO();
				customerPaymentMethod.setCustomerId(customer.getCustomerId());
				customerPaymentMethod.setPaymentMethodId(paymentMethod.getPaymentMethodId());
				customerPaymentMethod.insert();
				
		
				LicensePlateDTO lp = new LicensePlateDTO();
				lp.setLicencePlateJurisdictionId(EnuLicensePlateJurisdiction.NY);
				lp.setLicensePlatetypeId(EnuLicensePlateType.PASS);
				lp.setLpnumber(RandomStringUtils.randomAlphabetic(3).toUpperCase() + new Random().nextInt(9999));
				lp.insert();
				
				VehicleInfoDTO vehicle = new VehicleInfoDTO();
				vehicle.setLicensePlateId(lp.getLicensePlateId());
				vehicle.setAxles(2);
				vehicle.setColor("Red");
				vehicle.setMake("Ford");
				vehicle.setModel("Focus");
				vehicle.setModelYear(2002);
				vehicle.setVehicleClassId(EnuVehicleClass.CARXPORTER_591);
				vehicle.insert();
				
				CustomerVehicleDTO cv = new CustomerVehicleDTO();
				cv.setCustomerId(customer.getCustomerId());
				cv.setVehicleId(vehicle.getVehicleId());
				cv.insert();
				
				
				
				PaymentDTO payment = new PaymentDTO();
				payment.setAmount(new BigDecimal(32));
				payment.setPaymentTypeId(EnuPaymentType.VISA);
				LedgerInterface.insertPayment(customer.getCustomerId(), payment);
				
				CreateTestTrips.createTrips(new Random().nextInt(20), lp.getLicensePlateId(), customer.getCustomerId());
			}
		}.exec();
	}
}
