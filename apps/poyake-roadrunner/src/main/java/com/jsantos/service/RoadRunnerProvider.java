package com.jsantos.service;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.details.AccountDetails;
import com.jsantos.custom.menu.IMenuProvider;
import com.jsantos.demo.jobs.Escalation;
import com.jsantos.demo.pp.CreateProblematicPlate;
import com.jsantos.demo.screen.account.AccountSearch;
import com.jsantos.demo.screen.account.AccountSearchCrud;
import com.jsantos.demo.screen.account.CreateAccount;
import com.jsantos.demo.screen.cscase.CreateCase;
import com.jsantos.demo.screen.dashboard.DashboardRoadRunner;
import com.jsantos.demo.screen.promo.CreatePromo;
import com.jsantos.demo.screen.testing.createtestaccounts.CreateTestAccounts;
import com.jsantos.demo.screen.testing.createtesttrips.CreateTestTrips;
import com.jsantos.factory.audit.AuditUIFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.orm.dbstatement.DetachedRecord;

/**
 * @author raul ripoll
 */
public class RoadRunnerProvider implements IMenuProvider {

	
	
	
	Component mainArea;
	Component parent;
	String uri="~./zul/poyake-roadrunner/menu.zul";
	Component mainScreen;
	Component headerDiv;
	@Override
	public Component getMenu(Component parent,Component mainArea,MapValues<Object>data) {
		   this.parent=parent;
		   this.mainArea=mainArea;
	
		    mainScreen=Executions.createComponents(uri, parent, data);
	
		try {
		/*
			searchAccountTextbox = (Textbox)mainScreen.getFellowIfAny("SEARCH_ACCOUNT");
			*/
			headerDiv=Executions.createComponents("~./zul/poyake-roadrunner/header_search_button.zul", DesktopHelper.getMainHeader(), null);
			headerDiv.getFellowIfAny("SEARCH_ACCOUNT").addEventListener(	Events.ON_CHANGE, this::searchAccount);
			
			mainScreen.getFellow("ROADDASHBOARD").addEventListener(				Events.ON_CLICK, this::dashboard);
			mainScreen.getFellow("FIND_VEHICLE").addEventListener(			Events.ON_CLICK, this::findVehicle);
			mainScreen.getFellow("FIND_CASE").addEventListener(				Events.ON_CLICK, this::findCase);
			mainScreen.getFellow("FIND_ACCOUNTCRUD").addEventListener(		Events.ON_CLICK, this::findAccoundCrud);
			mainScreen.getFellow("FIND_TRIP").addEventListener(				Events.ON_CLICK, this::findTrip);
			
			mainScreen.getFellow("FIND_ACCOUNT").addEventListener(			Events.ON_CLICK, this::findAccound);
			mainScreen.getFellow("CREATE_ACCOUNT").addEventListener(		Events.ON_CLICK, this::createAccount);
			mainScreen.getFellow("CREATE_CASE").addEventListener(			Events.ON_CLICK, this::createCase);
			mainScreen.getFellow("DESIGN1").addEventListener(				Events.ON_CLICK, this::design);
			mainScreen.getFellow("DESIGN2").addEventListener(				Events.ON_CLICK, this::design);
			mainScreen.getFellow("DESIGN3").addEventListener(				Events.ON_CLICK, this::design);
			mainScreen.getFellow("DESIGN_LAYOUT").addEventListener(			Events.ON_CLICK, this::designLayout);
			mainScreen.getFellow("DESIGN5").addEventListener(				Events.ON_CLICK, this::design);
			mainScreen.getFellow("DESIGN_TYPOGRAPHY").addEventListener(		Events.ON_CLICK, this::design);
			//mainScreen.getFellow("COLLAPSE_BUTTON").addEventListener(		Events.ON_CLICK, this::collapseNavBar);
			mainScreen.getFellow("GENERATE_TEST_ACCOUNTS").addEventListener(Events.ON_CLICK, this::createTestAccounts);
			mainScreen.getFellow("GENERATE_TEST_TRIPS").addEventListener(	Events.ON_CLICK, this::createTestTrips);
			mainScreen.getFellow("RUN_ESCALATION").addEventListener(		Events.ON_CLICK, this::runEscalation);
			mainScreen.getFellow("CREATE_PROMO").addEventListener(			Events.ON_CLICK, this::createPromo);
			mainScreen.getFellow("SEARCH_PROMO").addEventListener(			Events.ON_CLICK, this::searchPromo);
			mainScreen.getFellow("SEARCH_PP").addEventListener(				Events.ON_CLICK, this::searchProblematicPlate);
			mainScreen.getFellow("CREATE_PP").addEventListener(				Events.ON_CLICK, this::createProblematicPlate);
			}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		dashboard(null);
		return mainScreen;
	}
	
	void findConfiguration(Event evt) throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTroadRunnerData.getTable("DATAGRIDSETTING"),mainArea).build();
		collapseMenu();
	}
	
	private void collapseMenu() {
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}

	void searchProblematicPlate(Event evt) throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTroadRunnerData.PROBLEMATICPLATE,mainArea).build();
		collapseMenu();
	}
	
	void createProblematicPlate(Event evt) {
		mainArea.getChildren().clear();new CreateProblematicPlate(mainArea).doModal();
		collapseMenu();
	}
	
	void menuPermission(Event evt) {
		Messagebox.show("it need to be Implemented");
		collapseMenu();
	}

	void dashboard(Event evt) {
		new DashboardRoadRunner().buildScreen(mainArea);
		collapseMenu();
	}

	void searchAccount(Event evt) throws Exception {
		Textbox searchAccount= (Textbox) headerDiv.getFellowIfAny("SEARCH_ACCOUNT");
		String valueText=searchAccount.getValue();
		if(null==valueText || valueText.isEmpty())return;
		Integer value=null;
		try {
			 value=Integer.valueOf(valueText);
			 DetachedRecord dr = new DetachedRecord(MTroadRunnerData.HCUSTOMER ,new MapValues<Object>().add("customerId", value ));
				if (null != dr)
				new  AccountDetails().setDetachedRecord(dr).setParent(mainArea).buildAndShowComponent(EditMode.SHOW);
				((Textbox)evt.getTarget()).setValue(null);
				collapseMenu();
		} catch (Exception e) {
			return;
		}
	}
	
	void runEscalation(Event evt) {
		new Escalation().runEscalation();
		collapseMenu();
	}
	
	void designLayout(Event evt) {
		mainArea.getChildren().clear();
		Executions.createComponents("~./zul/poyake-roadrunner/screen/design/layout.zul", mainArea, null);
		collapseMenu();
	}
	
	void createPromo(Event evt) {
		new CreatePromo().buildEditorScreen(mainArea);
		collapseMenu();
	}
	
	void searchPromo(Event evt) throws Exception {
		mainArea.getChildren().clear();new CrudScreen().init(MTroadRunnerData.PROMO,mainArea).build();
		collapseMenu();
	}
	
	void createCase(Event event) {
		new CreateCase(null).buildEditorScreen(mainArea);
		collapseMenu();
	}
	
	void createTestAccounts(Event evt) {
		new CreateTestAccounts().buildScreen(mainArea);
		collapseMenu();
	}

	void createTestTrips(Event evt) {
		new CreateTestTrips().buildScreen(mainArea);
		collapseMenu();
	}

	
	void findAccound(Event evt) throws Exception{
		new AccountSearch().buildGrid(mainArea);
		collapseMenu();
	}
	
	void findAccoundCrud(Event evt) throws Exception{
		mainArea.getChildren().clear();new AccountSearchCrud().init(MTroadRunnerData.VCUSTOMERSEARCH,mainArea).build();
		collapseMenu();
	}
	
	void createAccount(Event evt) throws Exception {
		new CreateAccount().buildEditorScreen(mainArea,false);	
		collapseMenu();
	}
	void findVehicle(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTroadRunnerData.VFINDVEHICLE,mainArea).build();
		collapseMenu();
	}
	void findCase(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTroadRunnerData.VCASESEARCH,mainArea).build();
		collapseMenu();
	}
	void findTrip(Event evt)  throws Exception{
		mainArea.getChildren().clear();CrudScreen findTrip=new CrudScreen().init(MTroadRunnerData.VTRIPSEARCH,mainArea);
		findTrip.getFilteredGrid().getHeaderDiv().getFellowIfAny("CRUDSCREEN_NEW").setVisible(false);
		findTrip.build();
		collapseMenu();
	}
	void searchUser(Event evt)  throws Exception{
		AuditUIFactory.getProvider().UserSearchScreen(mainArea);
		collapseMenu();
	}
	void createUser(Event evt)  throws Exception{
		AuditUIFactory.getProvider().CreateOrUpdateUserScreen(mainArea);
		collapseMenu();
	}	
	
	public void design(Event evt) throws Exception {
		if (null != mainScreen){
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN1"))) 
				setMainAreaZul("~./zul/poyake-roadrunner/screen/design/design1.zul");
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN2"))) 
				setMainAreaZul("~./zul/poyake-roadrunner/screen/design/basic-form-elements.zul");
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN3"))) 
				setMainAreaZul("~./zul/poyake-roadrunner/screen/design/profile.zul");
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN5"))) 
				setMainAreaZul("~./zul/poyake-roadrunner/screen/design/icons.zul");
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN_TYPOGRAPHY"))) 
				setMainAreaZul("~./zul/poyake-roadrunner/screen/design/typography.zul");
			collapseMenu();
		}
	}
	
	void setMainAreaZul(String zul) {
		mainArea.getChildren().clear();
		Executions.createComponents(zul, mainArea, null).setParent(mainArea);
	}
	
	@Override
	public boolean isImplemented() {
		return true;
	}
	
	@Override
	public String getProviderName() {
		return "z-poyake-roadrunner";
	}
}
