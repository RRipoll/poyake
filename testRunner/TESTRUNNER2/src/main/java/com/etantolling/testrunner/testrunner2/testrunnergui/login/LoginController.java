package com.etantolling.testrunner.testrunner2.testrunnergui.login;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Textbox;

import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.core.utils.MatrixLogging;
import com.etantolling.testrunner.test.utils.webservice.ClientWS;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		/*
		if (null != Executions.getCurrent().getParameter("usedefaultuser") && !"prod".equalsIgnoreCase(EnvironmentHelper.getDatabaseRole())){
			userTextbox.setValue("sa");
			passwordTextbox.setValue("idcmdx");
		}
		*/
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
					
					String appPath=((Combobox)comp.getFellow("APPPATH_TEXTBOX")).getSelectedItem().getValue();
					String bosUrl;
					String jobUrl;
					if(appPath.contains("|")) {
						bosUrl=appPath.substring(0, appPath.indexOf("|"));
						jobUrl=appPath.substring(appPath.indexOf("|")+1,appPath.length());
					}else {
						bosUrl=appPath;
						jobUrl=appPath.substring(0,appPath.length()-2)+"81";
					}
					DesktopHelper.setAppBaseUrl(bosUrl);
					DesktopHelper.setAppJobUrl(jobUrl);
					
					
					String url=((Combobox) comp.getFellow("TESTSERVERPATH_TEXTBOX")).getSelectedItem().getValue();
					String urldemo=url+"/TESTSERVER-RS";
					try {
						ClientWS.call(urldemo+"/rest/events/1280" , EventViewDTO.class, HttpMethod.GET, null);
						DesktopHelper.setTestLibraryURL(urldemo);
					} catch (Exception e) {
						DesktopHelper.setTestLibraryURL(url+"/tr-testserver-rs");
					}
					
							
					ResponseEntity<String> response=ClientWS.call(DesktopHelper.getAppBaseUrl()+"/api/sandbox/token/sa" , Map.class, HttpMethod.GET, null);
					ObjectMapper mapper = new ObjectMapper();
					Map<String,String> jsonResponse = mapper.readValue(response.getBody().toString(), Map.class);
					String token="Bearer "+jsonResponse.get("token");
					DesktopHelper.setDefaultTokken(token);
					
					
					Executions.createComponents("/zul/testgui2/mainscreen.zul", comp.getParent(), null);
					login_box.setVisible(false);
					login_box.detach();
					
					MatrixLogging.setCurrentLevelError();
					/*
					LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
					Logger rootLogger = loggerContext.getLogger("org.springframework.web.client.RestTemplate");rootLogger.setLevel(Level.ERROR);
					rootLogger = loggerContext.getLogger("org.springframework.web.servlet.DispatcherServlet");rootLogger.setLevel(Level.ERROR);
					rootLogger = loggerContext.getLogger("org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor");rootLogger.setLevel(Level.ERROR);
					rootLogger = loggerContext.getLogger("org");rootLogger.setLevel(Level.ERROR);
					rootLogger = loggerContext.getLogger("com");rootLogger.setLevel(Level.ERROR);
					*/
					/*
					HashMap parameters=new HashMap<String, Object>();
					parameters.put("AUTENTICATION", storeValues.get("AUTORIZATION"));
					ResponseEntity response=ClientWS.call(appBaseUrl+"/api/test/tennantname" , Map.class, HttpMethod.GET, parameters );
					String tennantName = response.getBody().toString();
					storeValues.put("tennantName", tennantName);
					*/
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
		
			if("etanfolder".equals(userTextbox.getValue()) && "etan".equals(passwordTextbox.getValue())){
				DesktopHelper.setInputUserId(1);
				return true;
			}
		return false;
	}
}