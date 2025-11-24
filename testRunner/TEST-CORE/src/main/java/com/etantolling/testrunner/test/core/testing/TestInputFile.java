package com.etantolling.testrunner.test.core.testing;

import java.net.MalformedURLException;
import java.net.URL;

public class TestInputFile {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	private URL url;
	
	public TestInputFile(String arg0) throws MalformedURLException {
		url= new URL(arg0);
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

}
