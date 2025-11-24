package com.jsantos.metadata;

import com.jsantos.orm.mt.MTBase; 
import com.jsantos.metadata.recorder.*;

public class MTrecorder extends MTBase{ 
	static boolean initialized = false;

	public static MTTableENURECORDERTYPE ENURECORDERTYPE;
	public static MTTableRECORDERDATA RECORDERDATA;
	public static MTTableRECORDERMASTER RECORDERMASTER;

	public static void init(){
		if (initialized) return;
		initialized = true;

		MTrecorder.init();
		MTCommonData.init();
		ENURECORDERTYPE = new MTTableENURECORDERTYPE();
		RECORDERDATA = new MTTableRECORDERDATA();
		RECORDERMASTER = new MTTableRECORDERMASTER();

		tables.put("ENURECORDERTYPE", ENURECORDERTYPE);
		tables.put("RECORDERDATA", RECORDERDATA);
		tables.put("RECORDERMASTER", RECORDERMASTER);

		MTTableRECORDERDATA.RECORDERTYPEID.setForeignKey(ENURECORDERTYPE);

	}
} 

