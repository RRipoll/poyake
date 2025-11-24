package com.etantolling.testrunner.test.core.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

public  static ThreadPoolExecutor pool = null;
	
	public static ThreadPoolExecutor getPool(){
		
		
		if(null==pool)
			pool= new ThreadPoolExecutor(2, 5, 30500, TimeUnit.MILLISECONDS,
					new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());

		
		return pool;
		
		
		
		
	}
	
	
	
}
