package com.jsantos.service;

import java.io.File;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.impl.LabelImageElement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.menu.IMenuProvider;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.rest.controllers.RecordController;
/**
 * @author raul ripoll
 */
public class RecorderProvider implements IMenuProvider {

	Component mainArea;
	Component parent;
	String uri="~./zul/poyake-recorder/menu.zul";
	Component mainScreen;
	String sClass;
	String buttonStyle;
	LabelImageElement recorder;
	
	@Override
	public boolean isImplemented() {
		return true;
	}

	@Override
	public Component getMenu(Component parent, Component mainArea, MapValues<Object> data) {
		this.parent=parent;
		   this.mainArea=mainArea;
			mainScreen=Executions.createComponents(uri, parent, data);
			recorder= (LabelImageElement) mainScreen.getFellow("BUTTONRECORDER");
			recorder.addEventListener(					Events.ON_CLICK, this::recorder);
		return mainScreen;
	}
	
	void recorder(Event event) {
		Integer recorderUuid=DesktopHelper.getRecorderUuid();
		if(null==recorderUuid) {
			
			sClass=recorder.getSclass();
			buttonStyle=recorder.getStyle();
			recorder.setStyle("background:red");
			recorder.setSclass(sClass+" flash");
			try {
				ObjectMapper mapper = new ObjectMapper();
				Map<String,Object> jsonResponse = new RecordController().set();
				Integer uuid=(Integer) jsonResponse.get("RecorderMasterId");
				DesktopHelper.setRecorderUuid(uuid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			DesktopHelper.deleteRecorderUuid();
			recorder.setStyle(buttonStyle);
			recorder.setSclass(sClass);
			ResponseEntity<String> response;
			try {
				Map<String, Object> jsonResponse = new RecordController().get(recorderUuid);
				String url=(String) jsonResponse.get("urlFile");
				if(null!=url) {
					File file= new File(url);
					System.out.println(file.exists());
					Filedownload.save(file, "application/file");
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getProviderName() {
		return "poyake-recorder";
	}
}
