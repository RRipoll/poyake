package com.jsantos.metadata;

import com.jsantos.orm.mt.MTBase; 

public class MTCommonData extends MTBase{ 
	static boolean initialized = false;


	public static void init(){
		if (initialized) return;
		initialized = true;

		MTCommonData.init();



	}
} 

