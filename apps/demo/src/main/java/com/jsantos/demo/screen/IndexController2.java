package com.jsantos.demo.screen;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import org.zkoss.util.Locales;
import org.zkoss.zhtml.Ul;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Textbox;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.details.AccountDetails;
import com.jsantos.demo.jobs.Escalation;
import com.jsantos.demo.pp.CreateProblematicPlate;
import com.jsantos.demo.screen.account.AccountSearch;
import com.jsantos.demo.screen.account.AccountSearchCrud;
import com.jsantos.demo.screen.account.CreateAccount;
import com.jsantos.demo.screen.cscase.CreateCase;
import com.jsantos.demo.screen.dashboard.Dashboard;
import com.jsantos.demo.screen.promo.CreatePromo;
import com.jsantos.demo.screen.testing.createtestaccounts.CreateTestAccounts;
import com.jsantos.demo.screen.testing.createtesttrips.CreateTestTrips;
import com.jsantos.factory.audit.AuditFactory;
import com.jsantos.factory.audit.AuditUIFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;


/**
 * @author javier santos
 * @author raul ripoll
 */


public class IndexController2 extends GenericForwardComposer<Component> {
	private static final long serialVersionUID = 1L;
	Component rootComponent;
	Component mainScreen;
	Component loginScreen;
	Component mainArea;
	Textbox searchAccountTextbox;
	Popup langPopupMenu;
	Image selectedLang;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception{
		this.rootComponent=comp;
		DesktopHelper.setRootComponent(comp);
		if(AuditFactory.getProvider().isImplemented())
			loadLoginScreen();
		else goAhead(null);
	}
	
	void loadLoginScreen() {
		loginScreen = Executions.createComponents("/login.zul", rootComponent, null);
		loginScreen.getFellow("OK_BUTTON").addEventListener(Events.ON_CLICK, this::login);
	}
	
	
	void collapseMenu() {
		org.zkoss.zhtml.Div navbarText=((org.zkoss.zhtml.Div)mainScreen.getFellow("navbarText"));
		String sclass=navbarText.getSclass();
		if(!sclass.contains(" collapse "))
			((org.zkoss.zhtml.Div)mainScreen.getFellow("navbarText")).setSclass(sclass.replace(" collapse show ",""));
		
	}
	
	
	void loadMainScreen() {
		rootComponent.getChildren().clear();
		mainScreen = Executions.createComponents("/mainscreenzk95.zul", rootComponent, null);
		try {
			this.mainArea = mainScreen.getFellow("MAIN_AREA");
			
			DesktopHelper.setContentArea(mainArea);
			
			searchAccountTextbox = (Textbox)mainScreen.getFellowIfAny("SEARCH_ACCOUNT");
			
			mainScreen.getFellow("SEARCH_ACCOUNT_BUTTON").addEventListener(	Events.ON_CLICK, this::searchAccount);
			mainScreen.getFellow("LOG_OUT_BUTTON").addEventListener(		Events.ON_CLICK, this::logOut);
			
			mainScreen.getFellow("DASHBOARD").addEventListener(				Events.ON_CLICK, this::dashboard);
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
			if(AuditFactory.getProvider().isImplemented()) { 
				mainScreen.getFellow("USERMULTIGROUP").addEventListener(		Events.ON_CLICK, this::findUserMultiGroup);
				mainScreen.getFellow("USER").addEventListener(					Events.ON_CLICK, this::findUser);
				mainScreen.getFellow("USERGROUP").addEventListener(				Events.ON_CLICK, this::findUserGroup);
				mainScreen.getFellow("MULTIUSERGROUP").addEventListener(		Events.ON_CLICK, this::findMultiUserGroup);
				mainScreen.getFellow("MULTIUSERGROUP2").addEventListener(		Events.ON_CLICK, this::findMultiUserGroup2);
				mainScreen.getFellow("CONFIGURATION").addEventListener(			Events.ON_CLICK, this::findConfiguration);
				
			}else {
				mainScreen.getFellow("USERMULTIGROUP").setVisible(false);
				mainScreen.getFellow("USERGROUP").setVisible(false);
				mainScreen.getFellow("CONFIGURATION").setVisible(false);
				mainScreen.getFellow("MULTIUSERGROUP").setVisible(false);
				mainScreen.getFellow("MULTIUSERGROUP2").setVisible(false);
				mainScreen.getFellow("CONFIGURATION").setVisible(false);
			
			}
			mainScreen.getFellow("MULTIOBJECT").addEventListener(			Events.ON_CLICK, this::findMultiObject);
			if(DesktopHelper.isPermissionEditable()) {
				mainScreen.getFellow("PERMISSION").addEventListener(			Events.ON_CLICK, this::permissions);
				mainScreen.getFellow("ROL").addEventListener(					Events.ON_CLICK, this::rols);
				mainScreen.getFellow("ROLLINK").addEventListener(				Events.ON_CLICK, this::rolslink);
			}else{
				mainScreen.getFellow("PERMISSION").setVisible(false);
				mainScreen.getFellow("ROL").setVisible(false);
				mainScreen.getFellow("ROLLINK").setVisible(false);
			}
			if(DesktopHelper.isLabelEditable())
				mainScreen.getFellow("LABEL").addEventListener(					Events.ON_CLICK, this::labels);
			else mainScreen.getFellow("LABEL").setVisible(false);
			
			mainScreen.getFellow("SEARCH_PP").addEventListener(				Events.ON_CLICK, this::searchProblematicPlate);
			mainScreen.getFellow("CREATE_PP").addEventListener(				Events.ON_CLICK, this::createProblematicPlate);
			mainScreen.getFellow("LANG_EN").addEventListener(				Events.ON_CLICK, this::langEN);
			mainScreen.getFellow("LANG_ES").addEventListener(				Events.ON_CLICK, this::langES);
			
	
			
			
			
			mainScreen.getFellow("leftmenutrigger").addEventListener(Events.ON_CLICK, this::showMenu);

			
			/*
			Component menuPermission=mainScreen.getFellow("MENU_PERMISSION");
			if(DesktopHelper.isConfEditable()) {
				menuPermission.setVisible(true);
				menuPermission.addEventListener(Events.ON_CLICK, this::menuPermission);
			}
			*/
			langPopupMenu = (Popup)mainScreen.getFellow("DROPDOWN_LANG_MENU_POPUP"); 
			selectedLang = (Image)mainScreen.getFellow("SELECTED_LANG");
			mainScreen.getFellow("DROPDOWN_LANG_MENU").addEventListener(Events.ON_CLICK, this::popupMenu);
		
			((Label)mainScreen.getFellowIfAny("USER_NAME")).setValue(DesktopHelper.getLoginName());
			
			Locale locale = (Locale)Executions.getCurrent().getSession().getAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE);
			if(null==locale) {
				locale = Locales.getCurrent();
				Executions.getCurrent().getSession().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE,locale);
			}
			if (null != locale && locale.getCountry().contains("EN"))
				selectedLang.setSrc("/img/us-flag.png");
			if (null != locale && locale.getCountry().contains("ES"))
				selectedLang.setSrc("/img/spanish-flag.jpg");
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		dashboard(null);
	}
	
	public void showMenu(Event evn) {
		
		Ul sidenav=(Ul) mainScreen.getFellow("side-nav");
		org.zkoss.zhtml.Div mainarea= (org.zkoss.zhtml.Div) mainScreen.getFellow("MAIN_AREA");
		
		if(sidenav.getSclass().contains("open")) {
			sidenav.setSclass("navbar-nav animate side-nav");
			mainarea.setSclass("mt-main-container open mt-main-container-collapsed");
		}else { 
			sidenav.setSclass("navbar-nav animate side-nav open");
			mainarea.setSclass("mt-main-container open mt-main-container-open");
		}
	}
	
	
	
	
	
	void findConfiguration(Event evt) throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.getTable("DATAGRIDSETTING"),mainArea).build();
		collapseMenu();
	}
	
	void searchProblematicPlate(Event evt) throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.PROBLEMATICPLATE,mainArea).build();
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
	
	void popupMenu(Event evt) {
		langPopupMenu.setParent(evt.getTarget());
		langPopupMenu.open(evt.getTarget(), "overlap");
		collapseMenu();
	}
	
	void langEN(Event evt) throws IOException {
		selectedLang.setSrc("/img/us-flag.png");
		langPopupMenu.detach();
		Locale locale = new Locale("en", "US");
        Executions.getCurrent().getSession().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, locale);
        Executions.getCurrent().getSession().setAttribute("Demo_Locale", locale);
        Clients.reloadMessages(locale);
        Locales.setThreadLocal(locale);
		collapseMenu();
        loadMainScreen();
	}
	
	void langES(Event evt) throws IOException {
		selectedLang.setSrc("/img/spanish-flag.jpg");
		langPopupMenu.detach();
		Locale locale = new Locale("es", "ES");
        Executions.getCurrent().getSession().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, locale);
        Executions.getCurrent().getSession().setAttribute("Demo_Locale", locale);
        Clients.reloadMessages(locale);
        Locales.setThreadLocal(locale);
		collapseMenu();
        loadMainScreen();
	}
	
	void logOut(Event evt) {
		if (Messagebox.YES == Messagebox.show("Confirm Log Out", "Log Out", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION))
			Executions.getCurrent().sendRedirect("");		
	}
	
	void dashboard(Event evt) {
		new Dashboard().buildScreen(mainArea);
		collapseMenu();
	}

	void searchAccount(Event evt) throws Exception {
		DetachedRecord dr = new DetachedRecord(MT.HCUSTOMER ,new MapValues<Object>().add("customerId", searchAccountTextbox.getValue()) );
		if (null != dr)
			new AccountDetails(dr.getPk(), rootComponent).buildAndShowComponent(EditMode.SHOW);
		collapseMenu();
	}
	
	void runEscalation(Event evt) {
		new Escalation().runEscalation();
		collapseMenu();
	}
	
	void designLayout(Event evt) {
		mainArea.getChildren().clear();
		Executions.createComponents("/screen/design/layout.zul", mainArea, null);
		collapseMenu();
	}
	
	void createPromo(Event evt) {
		new CreatePromo().buildEditorScreen(mainArea);
		collapseMenu();
	}
	void permissions(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTBase.getTable("VPERMISSIONROL"),mainArea).build();
		collapseMenu();
	}
	
	void rols(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTBase.getTable("VROLGROUP"),mainArea).build();
		collapseMenu();
	}
	
	void rolslink(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTBase.getTable("VROLLINK"),mainArea).build();
		collapseMenu();
	}
	
	void labels(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTBase.getTable("MTLABEL"),mainArea).build();
		collapseMenu();
	}
	
	void findUser(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.VINPUTUSER,mainArea).build();
		collapseMenu();
	}
	void findUserMultiGroup(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.VUSERMULTIGROUP,mainArea).build();
		collapseMenu();
	}
	
	void findUserGroup(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTBase.getTable("MT.VGROUPROL"),mainArea).build();
		collapseMenu();
	}
	
	void findMultiUserGroup(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.VHOME,mainArea).build();
		collapseMenu();
	}
	
	void findMultiUserGroup2(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.VHOME2,mainArea).build();
		collapseMenu();
	}
	
	void findMultiObject(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.VSTREET,mainArea).build();
		collapseMenu();
	}
	
	void searchPromo(Event evt) throws Exception {
		mainArea.getChildren().clear();new CrudScreen().init(MT.PROMO,mainArea).build();
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
		mainArea.getChildren().clear();new AccountSearchCrud().init(MT.VCUSTOMERSEARCH,mainArea).build();
		collapseMenu();
	}
	
	void createAccount(Event evt) throws Exception {
		new CreateAccount().buildEditorScreen(mainArea,false);	
		collapseMenu();
	}
	void findVehicle(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.VFINDVEHICLE,mainArea).build();
		collapseMenu();
	}
	void findCase(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.VCASESEARCH,mainArea).build();
		collapseMenu();
	}
	void findTrip(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MT.VTRIPSEARCH,mainArea).build();
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
				setMainAreaZul("/screen/design/design1.zul");
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN2"))) 
				setMainAreaZul("/screen/design/basic-form-elements.zul");
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN3"))) 
				setMainAreaZul("/screen/design/profile.zul");
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN5"))) 
				setMainAreaZul("/screen/design/icons.zul");
			if (evt.getTarget().equals(mainScreen.getFellow("DESIGN_TYPOGRAPHY"))) 
				setMainAreaZul("/screen/design/typography.zul");
			collapseMenu();
		}
		
	}
	
	void setMainAreaZul(String zul) {
		mainArea.getChildren().clear();
		Executions.createComponents(zul, mainArea, null).setParent(mainArea);
	}
	
	void login(Event event) throws Exception {
		String userLogin = ((Textbox)loginScreen.getFellow("USER_LOGIN")).getValue();
		String passwd = ((Textbox)loginScreen.getFellow("PASSWORD")).getValue();
		DetachedRecord user=  AuditFactory.getProvider().getInputUser(userLogin, passwd);
		if(null!=user) {
			DesktopHelper.setInputUser(user);
			ListValues<IDetachedRecord> vUsergroups=AuditFactory.getProvider().getVUserGroup(user);
			if(vUsergroups.size()>1) {
				Popup popup= new Popup();
					popup.setStyle("overflow:hiden");
					popup.setHflex("min");
					popup.setVflex("min");
					popup.setParent(loginScreen.getFellow("USER_LOGIN").getParent());
					Listbox listbox = new Listbox();
					listbox.setHflex("min");
					listbox.setVflex("min");
					listbox.setParent(popup);
				
					for (IDetachedRecord dtRecord : vUsergroups) {
						Listitem item= new Listitem(AuditFactory.getProvider().getGroupDescription(dtRecord).toString(), dtRecord);
						item.setParent(listbox);
					}
					popup.open(loginScreen.getFellow("USER_LOGIN"));
				
					listbox.addEventListener(Events.ON_SELECT, this::usergroupSelected);
			}
			else{	
				
				goAhead(vUsergroups.get(0));
			}
		}
	}
	
	void usergroupSelected(Event event) throws SQLException {
		DetachedRecord dtr=((Listbox)event.getTarget()).getSelectedItem().getValue();
		goAhead(dtr);
	}
	void goAhead(IDetachedRecord dtr) throws SQLException {
		DesktopHelper.setVUserGroup(dtr);
		DesktopHelper.setPermission(PermissionFactory.getProvider().getPermissions(DesktopHelper.getInputUserGroupId()));
		loginScreen=null;
		loadMainScreen();
	}
	
	
	
}