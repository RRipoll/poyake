package com.testrunner.test.framework.toll.testframework.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Textbox;

import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.jsantos.core.EnvironmentHelper;
import com.jsantos.metadata.MT;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.NamedParameterStatement;

@SuppressWarnings("rawtypes")
public class LoginController implements Composer, EventListener<Event> {
	Component okButton = null;
	Textbox userTextbox = null;
	Textbox passwordTextbox = null;
	Checkbox rememberLoginName = null;
	Component comp;
    Div testMessage;
    Component login_box;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
        this.comp=comp;
		okButton = comp.getFellow("OK_BUTTON");
		okButton.addEventListener("onClick", this);
		userTextbox = (Textbox) comp.getFellow("USER_TEXTBOX");
		userTextbox.addEventListener(Events.ON_OK, this);
		userTextbox.addEventListener(Events.ON_CHANGE, this);
		passwordTextbox = (Textbox) comp.getFellow("PASSWORD_TEXTBOX");
		passwordTextbox.addEventListener(Events.ON_OK, this);
		passwordTextbox.addEventListener(Events.ON_CHANGE, this);
		testMessage=(Div) comp.getFellow("DIV_ERRORMESSAGE");
		login_box=comp.getFellow("login_box");
		
		userTextbox.setValue("sa");
		passwordTextbox.setValue("idc");
			
		if (0 == userTextbox.getValue().length())
			userTextbox.focus();
		else
			passwordTextbox.focus();
	
		comp.addEventListener(Events.ON_CLIENT_INFO, this);
	}

	@Override
	public void onEvent(Event event) throws Exception {

		if(Events.ON_CLIENT_INFO.equals(event.getName())){
			
			 int height = ((ClientInfoEvent) event).getDesktopHeight();
	         int width = ((ClientInfoEvent) event).getDesktopWidth();
			
			DesktopHelper.setAttribute("ClientHeight", height);
			DesktopHelper.setAttribute("ClientWidth", width);
		}
		
		if (Events.ON_CHANGE.equals(event.getName())) {
			Textbox tb = (Textbox) event.getTarget();
			tb.setValue(tb.getValue().trim());
		}

		if (event.getTarget() == okButton) {
				if (checkLogin()) { 
					
					Executions.createComponents("/zul/panel/mainscreen.zul", comp.getParent(), null);
					login_box.setVisible(false);
					login_box.detach();
					
				} else
					testMessage.setVisible(true);
		}

		if (Events.ON_OK.equals(event.getName()) && userTextbox.equals(event.getTarget()) && userTextbox.getValue().length() > 0) {
			passwordTextbox.focus();
			passwordTextbox.setValue("");
		}

		if (Events.ON_OK.equals(event.getName()) && passwordTextbox.equals(event.getTarget()) && userTextbox.getValue().length() > 0 && passwordTextbox.getValue().length() > 0)
			Events.sendEvent(Events.ON_CLICK, okButton, null);
	}

	boolean checkLogin() throws SQLException  {
		
		Connection conn = null;
		boolean retValue=false;
		try {
			conn=MainDb.getConnection();
			String sql="SELECT INPUTUSERID FROM pub.INPUTUSER WHERE startdate<="+EnvironmentHelper.getVersionDate()+" and enddate>="+EnvironmentHelper.getVersionDate()+" and   USERNAME= :LOGINNAME AND PASSWORD=  :PASSWORD ";
			NamedParameterStatement npst= new NamedParameterStatement(conn,sql);
			
			//System.out.println(userTextbox.getValue().trim());
			//System.out.println(MD5.digest(passwordTextbox.getValue()));
			
			npst.setString("LOGINNAME", userTextbox.getValue().trim());
			npst.setString("PASSWORD", passwordTextbox.getValue().trim());
			//npst.setString("PASSWORD", MD5.digest(passwordTextbox.getValue()));
			ResultSet rs=npst.executeQuery();
			if(rs.next()){
				DesktopHelper.setInputUserId(rs.getInt(1));
				DesktopHelper.setInputUser(new DetachedRecord(MT.INPUTUSER, DesktopHelper.getInputUserId()));
				retValue= true;
			}
			npst.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
				conn.close();
		}
		return retValue;
	}
}