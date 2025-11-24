package com.jsantos.common.model.conf;

public interface IConfiguration {
	
	public String getName();
	public boolean isActive();
	public void setActive(boolean active) ;
	public boolean isHidden() ;
	public void setHidden(boolean hidden) ;
	
	
}
