package com.jsantos.metadata;

import com.jsantos.orm.mt.MTBase; 
import com.jsantos.metadata.config.*;
import com.jsantos.metadata.label.*;

public class MTLabelData extends MTBase{ 
	static boolean initialized = false;

	public static MTTableENULOCALE ENULOCALE;
	public static MTTableMTLABEL MTLABEL;

	public static void init(){
		if (initialized) return;
		initialized = true;

		MTLabelData.init();
		ENULOCALE = new MTTableENULOCALE();
		MTLABEL = new MTTableMTLABEL();

		tables.put("ENULOCALE", ENULOCALE);
		tables.put("MTLABEL", MTLABEL);


	}
} 

