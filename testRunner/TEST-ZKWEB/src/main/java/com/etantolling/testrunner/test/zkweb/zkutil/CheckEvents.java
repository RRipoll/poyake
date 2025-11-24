package com.etantolling.testrunner.test.zkweb.zkutil;

import java.util.Date;
import java.util.Hashtable;

import org.zkoss.zk.ui.event.Event;

import com.etantolling.testrunner.test.zkweb.DesktopHelper;

public class CheckEvents {

	static  long diference=800;
	
	static public boolean isEventClosed(Event event){
		return isEventClosed(event,diference);
	}
	
	static public boolean isEventClosed(Event event, long diference){
		Long dateTime=new Date().getTime();
		
		String checkName=event.getTarget().getId()+"|"+event.getName();

		Hashtable<String,Long> checkdate= getEventTimeHash();
		if(null!=checkdate.get(checkName)){
			if(diference>dateTime - checkdate.get(checkName)) return true;
		} checkdate.put(checkName, dateTime);
		return false;
	}
	
	@SuppressWarnings("unchecked")
	static Hashtable<String,Long> getEventTimeHash(){
		
		Hashtable<String,Long> eventTimeHash= (Hashtable<String, Long>) DesktopHelper.getAttribute("EVENTTIMEHASH");
		if(null==eventTimeHash){
			eventTimeHash= new Hashtable<String,Long>(); 
			DesktopHelper.setAttribute("EVENTTIMEHASH",eventTimeHash);
		}	
		return eventTimeHash;
	}
	
	
}
	
	

