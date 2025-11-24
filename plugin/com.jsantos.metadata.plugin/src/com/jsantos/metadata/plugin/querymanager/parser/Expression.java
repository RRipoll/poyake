package com.jsantos.metadata.plugin.querymanager.parser;

public class Expression extends Column{
	String alias;
	String expresionText;
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getExpresionText() {
		return expresionText;
	}
	public void setExpresionText(String expresionText) {
		this.expresionText = expresionText;
	}
	
	
}
