package com.jsantos.demo.screen;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
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

import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.DefaultRecordDescription;
import com.jsantos.custom.menu.IMenuProvider;
import com.jsantos.custom.menu.MenuProvider;
import com.jsantos.demo.screen.dashboard.Dashboard;
import com.jsantos.factory.audit.AuditFactory;
import com.jsantos.factory.audit.AuditUIFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;

/**
 * @author javier santos
 * @author raul ripoll
 */

public class IndexController extends GenericForwardComposer<Component> {
	private static final long serialVersionUID = 1L;
	Component rootComponent;
	Component mainScreen;
	Component loginScreen;
	Component mainArea;
	Textbox searchAccountTextbox;
	Popup langPopupMenu;
	Image selectedLang;
		
	void loadMainScreen() {
		rootComponent.getChildren().clear();
		mainScreen = Executions.createComponents("~./screen/mainscreen.zul", rootComponent, null);
		try {
			this.mainArea = mainScreen.getFellowIfAny("MAIN_AREA");
			DesktopHelper.setMainHeader(mainScreen.getFellowIfAny("MAIN_HEADER"));
			mainScreen.getFellow("DASHBOARD").addEventListener(				Events.ON_CLICK, this::dashboard);
			mainScreen.getFellow("LOG_OUT_BUTTON").addEventListener(		Events.ON_CLICK, this::logOut);
			mainScreen.getFellow("leftmenutrigger").addEventListener(		Events.ON_CLICK, this::showMenu);
			mainScreen.getFellow("LANG_EN").addEventListener(				Events.ON_CLICK, this::langEN);
			mainScreen.getFellow("LANG_ES").addEventListener(				Events.ON_CLICK, this::langES);
			langPopupMenu = (Popup)mainScreen.getFellow("DROPDOWN_LANG_MENU_POPUP"); 
			selectedLang = (Image)mainScreen.getFellow("SELECTED_LANG");
			mainScreen.getFellow("DROPDOWN_LANG_MENU").addEventListener(	Events.ON_CLICK, this::popupMenu);
			mainScreen.getFellow("side-nav").addEventListener(				CustomEvents.ON_COLAPSEMENU, this::collapseMenu);
			
			List<IMenuProvider> list=MenuProvider.getList().stream().sorted(
					(i1, i2) -> i2.getProviderName().compareTo(i1.getProviderName())).collect(Collectors.toList());
			
			for (IMenuProvider element : list) {
				element.getMenu(mainScreen.getFellow("side-nav"), mainArea, null);
			}
				
			String userInfo=DefaultRecordDescription.getDescription(DesktopHelper.getVUserGroup(),LocaleFactory.getProvider().getLocale() ) ;
			((Label)mainScreen.getFellowIfAny("USER_NAME")).setValue(userInfo);
			
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

	@Override
	public void doAfterCompose(Component comp) throws Exception{
		this.rootComponent=comp;
		DesktopHelper.setRootComponent(comp);
		if(AuditUIFactory.getProvider().isImplemented())
			loadLoginScreen();
		else goAhead(null);
	}
	
	void loadLoginScreen() {
		loginScreen = Executions.createComponents("~./zul/poyake-audit/login.zul", rootComponent, null);
		loginScreen.getFellow("OK_BUTTON").addEventListener(Events.ON_CLICK, this::login);
	}
	
	void collapseMenu(Event evn) {
		org.zkoss.zhtml.Div navbarText=((org.zkoss.zhtml.Div)mainScreen.getFellow("navbarText"));
		String sclass=navbarText.getSclass();
		if(!sclass.contains(" collapse "))
			((org.zkoss.zhtml.Div)mainScreen.getFellow("navbarText")).setSclass(sclass.replace(" collapse show ",""));
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
	
	void popupMenu(Event evt) {
		langPopupMenu.setParent(evt.getTarget());
		langPopupMenu.open(evt.getTarget(), "overlap");
		collapseMenu(null);
	}
	
	void langEN(Event evt) throws IOException {
		selectedLang.setSrc("/img/us-flag.png");
		langPopupMenu.detach();
		Locale locale = new Locale("en", "US");
        Executions.getCurrent().getSession().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, locale);
        Executions.getCurrent().getSession().setAttribute("Demo_Locale", locale);
        Clients.reloadMessages(locale);
        Locales.setThreadLocal(locale);
		collapseMenu(null);
        loadMainScreen();
        Executions.getCurrent().sendRedirect("");	
	}
	
	void langES(Event evt) throws IOException {
		selectedLang.setSrc("/img/spanish-flag.jpg");
		langPopupMenu.detach();
		Locale locale = new Locale("es", "ES");
        Executions.getCurrent().getSession().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, locale);
        Executions.getCurrent().getSession().setAttribute("Demo_Locale", locale);
        Clients.reloadMessages(locale);
        Locales.setThreadLocal(locale);
		collapseMenu(null);
        loadMainScreen();
        Executions.getCurrent().sendRedirect("");	
	}
	
	void logOut(Event evt) {
		if (Messagebox.YES == Messagebox.show("Confirm Log Out", "Log Out", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION))
			Executions.getCurrent().sendRedirect("");		
	}
	
	void dashboard(Event evt) {
		new Dashboard().buildScreen(mainArea);
		collapseMenu(null);
	}
	
	void designLayout(Event evt) {
		mainArea.getChildren().clear();
		Executions.createComponents("/screen/design/layout.zul", mainArea, null);
		collapseMenu(null);
	}

	void searchUser(Event evt)  throws Exception{
		AuditUIFactory.getProvider().UserSearchScreen(mainArea);
		collapseMenu(null);
	}

	void createUser(Event evt)  throws Exception{
		AuditUIFactory.getProvider().CreateOrUpdateUserScreen(mainArea);
		collapseMenu(null);
	}	
	
	void setMainAreaZul(String zul) {
		mainArea.getChildren().clear();
		Executions.createComponents(zul, mainArea, null).setParent(mainArea);
	}

	void login(Event event) throws SQLException {
		login(loginScreen);
	}
	
	void login(Component loginScreen) throws SQLException {
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
			else if(vUsergroups.size()==1){	
				goAhead(vUsergroups.get(0));
			}
		}else {
			Clients.showNotification(Zklabel.getLabel("Wrong_Value"), Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
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

