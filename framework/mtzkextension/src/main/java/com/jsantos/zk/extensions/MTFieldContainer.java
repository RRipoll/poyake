package com.jsantos.zk.extensions;

import org.zkoss.zul.Div;

public class MTFieldContainer extends Div {
	String field;
	
	public MTFieldContainer() {
		super();
		this.setWidth("100px");
		this.setHeight("20px");
		this.setStyle("background:#eeeeee");
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
	
}
