package com.jsantos.service;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.jsantos.common.util.MapValues;
import com.jsantos.custom.extendeddto.AppInfoExtDTO;
import com.jsantos.custom.menu.IMenuProvider;
import com.jsantos.factory.audit.AuditFactory;
import com.jsantos.factory.audit.IAuditUIProvider;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.datagrid4.GridSelectorType;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.gui.objectselector.foldertree.TreeController;
import com.jsantos.gui.objectselector.foldertree.TreeSelectionMan;
import com.jsantos.metadata.MTAuditData;
import com.jsantos.metadata.MTDataGridSettingData;
import com.jsantos.metadata.MTLabelData;
import com.jsantos.metadata.MTPermissionData;
import com.jsantos.screen.systemadmin.users.CreateOrUpdateUser;
import com.jsantos.screen.systemadmin.users.UserSearch;

/**
 * @author raul ripoll
 */
public class AuditUIProvider implements IAuditUIProvider,IMenuProvider{

	
	
	
	@Override
	public void UserSearchScreen(Object mainArea) {
		try {
			new UserSearch().buildGrid((Component) mainArea);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void CreateOrUpdateUserScreen(Object mainArea) {
		new CreateOrUpdateUser().buildEditorScreen((Component) mainArea);
		
	}


	@Override
	public boolean isImplemented() {
		
		return true;
	}


	Component mainArea;
	Component parent;
	String uri="~./zul/poyake-audit/menu.zul";


	@Override
	public Component getMenu(Component parent,Component mainArea,MapValues<Object>data) {
		   this.parent=parent;
		   this.mainArea=mainArea;
		   Component mainScreen=null;
		   try {
			    mainScreen=Executions.createComponents(uri, parent, data);
			} catch (UiException e) {
				return null;
			}
			
			
			if(AuditFactory.getProvider().isImplemented()) { 
				mainScreen.getFellow("USERMULTIGROUP").addEventListener(		Events.ON_CLICK, this::findUserMultiGroup);
				mainScreen.getFellow("PERMISSION").addEventListener(			Events.ON_CLICK, this::permissions);
				mainScreen.getFellow("USERGROUP").addEventListener(				Events.ON_CLICK, this::findUserGroup);
				mainScreen.getFellow("ROL").addEventListener(					Events.ON_CLICK, this::rols);
			}else {
				mainScreen.getFellow("USERMULTIGROUP").setVisible(false);
				mainScreen.getFellow("PERMISSION").setVisible(false);
				mainScreen.getFellow("USERGROUP").setVisible(false);
				mainScreen.getFellow("ROL").setVisible(false);
			}
			if(DataSettingFactory.getProvider().isImplemented()) {
				mainScreen.getFellow("CONFIGURATION").addEventListener(			Events.ON_CLICK, this::findConfiguration);
				mainScreen.getFellow("APPINFO").addEventListener(			Events.ON_CLICK, this::appInfoConfiguration);
			
			}else {
				mainScreen.getFellow("CONFIGURATION").setVisible(false);
				mainScreen.getFellow("APPINFO").setVisible(false);

			}
			
			if(DesktopHelper.isLabelEditable())
				mainScreen.getFellow("LABEL").addEventListener(					Events.ON_CLICK, this::labels);
			else mainScreen.getFellow("LABEL").setVisible(false);
			
		return mainScreen;
	}

	void findUser(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTAuditData.VINPUTUSER,mainArea).build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	void findUserMultiGroup(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTAuditData.VUSERMULTIGROUP,mainArea).build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	
	void appInfoConfiguration(Event evt) throws Exception{
		mainArea.getChildren().clear();
		TreeController tree=new TreeController(MTAuditData.APPINFOTREE,mainArea, new TreeSelectionMan(GridSelectorType.RADIO));
		//tree.getDqr().setCustomSql(AppInfoExtDTO.sqlInfoTree(DesktopHelper.getInputUserGroupId()));
		tree.getDqr().setOrderBySection(" (select sKey from config.appinfo c where c.appinfoId=baseTable.appinfoID) asc ");
		tree.render();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	
	
	void findConfiguration(Event evt) throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTDataGridSettingData.DATAGRIDSETTING,mainArea).build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	void permissions(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTPermissionData.VPERMISSIONROL,mainArea).build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	
	void rols(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTPermissionData.VROLGROUP,mainArea).build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	
	void rolslink(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTPermissionData.VROLLINK,mainArea).build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	
	void labels(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTLabelData.MTLABEL,mainArea).build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	
	
	
	void findUserGroup(Event evt)  throws Exception{
		mainArea.getChildren().clear();new CrudScreen().init(MTPermissionData.VGROUPROL,mainArea).build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU,parent,null);
	}
	
	
	
	

	@Override
	public String getProviderName() {
		
		return "poyake-audit-ui";
	}

}
