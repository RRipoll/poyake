package com.jsantos.common.model.conf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsantos.orm.mt.MTField;

/**
 * @author raul ripoll
 */

public class GridColumnConfiguration implements IConfiguration {

	@JsonIgnore
	MTField mtField;

	String name = null;
	private boolean Active = true;
	private boolean Available = true;
	private boolean hidden;

	public GridColumnConfiguration() {
	}

	public GridColumnConfiguration(String name) {
		this.name = name;
		
	}


	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean available) {
		Available = available;
	}

	
	

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/*
	 * public static GridColumnConfiguration get(List<GridColumnConfiguration>
	 * list,String name ) { for (GridColumnConfiguration gridColumnConfiguration :
	 * list) { if (gridColumnConfiguration.getName().equals(name)) return
	 * gridColumnConfiguration; } return null; }
	 */
	public static GridColumnConfiguration get(List<GridColumnConfiguration> list, MTField mtField) {

		for (GridColumnConfiguration configuration : list) {
			if (configuration.getMtField().equals(mtField))
				return configuration;
		}

		return null;

	}

	/*
	
	*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public MTField getMtField() {
		return mtField;
	}

	public void setMtField(MTField mtField) {
		this.mtField = mtField;
	}

	public boolean equal(GridColumnConfiguration sample) {
		if(isActive()==sample.isActive())
			if(isAvailable()==sample.isAvailable())
				if(isHidden()==sample.isHidden())
					return true;
		return false;
		
	}
	
}
