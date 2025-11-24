package com.jsantos.demo.screen.testing.createtesttrips;

import java.math.BigDecimal;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;

import com.jsantos.gui.zkcomponent.MTIntbox;
import com.jsantos.ledger.LedgerInterface;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.acc.EnuTransactionType;
import com.jsantos.metadata.acc.LedgerDTO;
import com.jsantos.metadata.tolling.MTTableVFINDVEHICLE;
import com.jsantos.metadata.tolling.TripDTO;
import com.jsantos.metadata.tolling.TripInfoDTO;
import com.jsantos.orm.dbstatement.DetachedRecord;

public class CreateTestTrips implements EventListener<Event> {
	MTIntbox numberOfTrips;
	Integer customerId;
	Integer licensePlateId;
	Component mainDiv;
	
	public void buildScreen(Component parent) {
		parent.getChildren().clear();
		mainDiv = Executions.createComponents("/screen/test/create_test_trips.zul", parent, null);
		mainDiv.getFellowIfAny("SAVE_BUTTON").addEventListener(Events.ON_CLICK, this::create);
	}
	
	public void create(Event evt) {
		numberOfTrips = (MTIntbox)mainDiv.getFellowIfAny("NUMBER_OF_TRIPS");
		customerId = ((MTIntbox)mainDiv.getFellowIfAny("CUSTOMER_ID")).getValue();
		licensePlateId = new DetachedRecord(MT.VFINDVEHICLE, " customerId=" + customerId,null).getInt(MTTableVFINDVEHICLE.LICENSEPLATEID);
		
		createTrips(numberOfTrips.getValue(), licensePlateId, customerId);

		Messagebox.show("Done");
	}

	public static void createTrips(int nTrips, int licensePlateId, int customerId) {
			for(int nTrip=0; nTrip<nTrips; nTrip++) {
				LedgerDTO ledger = LedgerInterface.addDebit(customerId, EnuTransactionType.TRIP, randomFare());
				
				
				TripDTO trip = new TripDTO();
				trip.setLedgerInfoId(ledger.getLedgerInfoId());
				trip.setLedgerItemId(ledger.getLedgerItemId());
				trip.insert();
				
				TripInfoDTO tripInfo = new TripInfoDTO();
				tripInfo.setFareAmount(ledger.getAmount());
				tripInfo.setGantryId(1);
				tripInfo.setLaneEntryDate(new java.sql.Date(new Date().getTime()-60*60*24));
				tripInfo.setLaneExitDate(new java.sql.Date(new Date().getTime()-60*60*23));
				tripInfo.setLicensePlateId(licensePlateId);
				tripInfo.setTripId(trip.getTripId());
				tripInfo.insert();
			}			
	}
	
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	static BigDecimal randomFare() {
		return new BigDecimal(2.5);
	}
	
	Integer getLicensePlate() {
		return 1000;
	}
}
