package com.jsantos.auditimmo.screen;

import org.zkoss.zhtml.Button;
import org.zkoss.zhtml.Input;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.jsantos.auditimmo.screen.evaluation.CreateEvaluation;
import com.jsantos.auditimmo.screen.evaluation.EvaluationPkFieldComponent;
import com.jsantos.auditimmo.screen.folder.CreateFolder;
import com.jsantos.auditimmo.screen.folder.FolderPkFieldComponent;
import com.jsantos.auditimmo.screen.intervenant.CreateIntervenant;
import com.jsantos.auditimmo.screen.login.LoginScreen;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.filteredgrid.FilteredGrid;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.audit.MTTableINPUTUSER;
import com.jsantos.metadata.eva.MTTableVEVALUATIONSEARCH;
import com.jsantos.metadata.eva.MTTableVFOLDERSEARCH;


public class IndexController extends GenericForwardComposer<Component> {
	private static final long serialVersionUID = 1L;
	Component rootComponent;
	Component mainScreen;
	Component loginScreen;
	Component mainArea;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception{
		this.rootComponent=comp;
		DesktopHelper.setRootComponent(comp);
		loadLoginScreen();
	}
	
	void loadLoginScreen() {
		loginScreen = Executions.createComponents("/login.zul", rootComponent, null);
		loginScreen.getFellow("OK_BUTTON").addEventListener(Events.ON_CLICK, this::login);
		//((Textbox)loginScreen.getFellow("USER_LOGIN")).setConstraint(new MTSimpleConstraint(loginScreen.getFellow("USER_LOGIN"),"no empty"));
		
	}
	
	void loadMainScreen() {
		mainScreen = Executions.createComponents("/mainscreen.zul", rootComponent, null);

		try {
			this.mainArea = mainScreen.getFellow("MAIN_AREA");
			DesktopHelper.setContentArea(mainArea);
			
			
			((Label)mainScreen.getFellowIfAny("USER_NAME")).setValue(DesktopHelper.getInputUser().getString(MTTableINPUTUSER.LOGINNAME));
			mainScreen.getFellow("COLLAPSE_BUTTON").addEventListener(Events.ON_CLICK, this::collapseNavBar);
			mainScreen.getFellow("INTERVENANTS").addEventListener(Events.ON_CLICK, this::intervenantSearch);
			mainScreen.getFellow("EVALUATIONS").addEventListener(Events.ON_CLICK, this::evaluationSearch);
			mainScreen.getFellow("FOLDERS").addEventListener(Events.ON_CLICK, this::folderSearch);
			mainScreen.getFellow("VIDEO").addEventListener(Events.ON_CLICK, this::videotest);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	void videotest(Event evt) {
		Window form = (Window) Executions.createComponents("/common/zul/videotest.zul",mainScreen, null);
		
		
		
		form.doModal();
		
		
	}
	
	void checktest(Event ent) {
		System.out.println(ent.toString());
	}
	
	
	
	void intervenantSearch(Event evt) {
		mainArea.getChildren().clear();
		FilteredGrid filteredGrid = new FilteredGrid(MT.VINTERVENANTSEARCH, mainArea,null);
		filteredGrid.setHeaderLabel("Intervenants");
		filteredGrid.build();
		Button button = new Button();
		new Text("Create").setParent(button);
		button.addEventListener(Events.ON_CLICK, this::createIntervenant);
		button.setSclass("btn btn-primary");
		button.setParent(filteredGrid.getButtonArea());
	}

	void createIntervenant(Event evt) {
		new CreateIntervenant().buildEditorScreen(mainArea);
	}

	void evaluationSearch(Event evt) {
		mainArea.getChildren().clear();
		FilteredGrid filteredGrid = new FilteredGrid(MT.VEVALUATIONSEARCH, mainArea,null);
		filteredGrid.getEntityGrid().setCustomFieldComponent(MTTableVEVALUATIONSEARCH.EVALUATIONID, new EvaluationPkFieldComponent());
		filteredGrid.setHeaderLabel("Evaluations");
		filteredGrid.build();
		Button button = new Button();
		new Text("Create").setParent(button);
		button.addEventListener(Events.ON_CLICK, this::createEvaluation);
		button.setSclass("btn btn-primary");
		button.setParent(filteredGrid.getButtonArea());
	}

	void createEvaluation(Event evt) {
		new CreateEvaluation().buildAndShow();
	}
	
	
	void folderSearch(Event evt) {
		mainArea.getChildren().clear();
		FilteredGrid filteredGrid = new FilteredGrid(MT.VFOLDERSEARCH, mainArea,null);
		filteredGrid.getEntityGrid().setCustomFieldComponent(MTTableVFOLDERSEARCH.FOLDERID, new FolderPkFieldComponent());
		filteredGrid.setHeaderLabel("Folders");
		filteredGrid.build();
		Button button = new Button();
		new Text("Create").setParent(button);
		button.addEventListener(Events.ON_CLICK, this::createFolder);
		button.setSclass("btn btn-primary");
		button.setParent(filteredGrid.getButtonArea());
	}

	void createFolder(Event evt) {
		new CreateFolder().buildEditorScreen(mainArea);
		/*
		MTInsertScreenController controler = new MTInsertScreenController(mainScreen, "/screen/folder/create_folder.zul", MT.FOLDER);
		controler.getMtForm().getCancelButton().addEventListener(Events.ON_CLICK, controler::closeWindow);
		controler.doModal();
		*/
	}
	
	void logOut(Event evt) {
		if (Messagebox.YES == Messagebox.show("Confirm Log Out", "Log Out", Messagebox.YES|Messagebox.NO, Messagebox.QUESTION))
			Executions.getCurrent().sendRedirect("");		
	}
	
	void setMainAreaZul(String zul) {
		mainArea.getChildren().clear();
		Executions.createComponents(zul, mainArea, null).setParent(mainArea);
	}
	
	void login(Event evt) {
		String userLogin = ((Textbox)loginScreen.getFellow("USER_LOGIN")).getValue();
		String passwd = ((Textbox)loginScreen.getFellow("PASSWORD")).getValue();
		if (new LoginScreen().checkLogin(userLogin, passwd)) {
			rootComponent.getChildren().clear();
			loginScreen=null;
			loadMainScreen();
		}
	}
	
	void collapseNavBar(Event event) {
		Navbar navBar = ((Navbar)mainScreen.getFellow("NAVBAR")); 
		if (!navBar.isCollapsed()) {
			navBar.setCollapsed(true);
			navBar.setWidth(null);
			((Div)mainScreen.getFellow("COLLAPSE_BUTTON")).setClass("z-icon-toggle-right mt-collapse-button");
			((Div)mainScreen.getFellow("MAIN_AREA")).setClass("mt-main-container mt-main-container-collapsed");
			((Div)mainScreen.getFellow("APPHEADER")).setClass("mt-app-header pull-right mt-app-header-collapsed");
		}
		else {
			navBar.setCollapsed(false);
			navBar.setWidth("200px");
			((Div)mainScreen.getFellow("COLLAPSE_BUTTON")).setClass("z-icon-toggle-left mt-collapse-button");
			((Div)mainScreen.getFellow("MAIN_AREA")).setClass("mt-main-container");
			((Div)mainScreen.getFellow("APPHEADER")).setClass("mt-app-header pull-right");
		}
		
		
	}

}
