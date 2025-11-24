package com.jsantos.search.model;

import java.util.List;

import com.jsantos.search.model.parameter.BlockItem;

/**
 * @author raul ripoll
 */


public class ParameterDTO {

	public ParameterDTO() {
		super();
	}

	private List<BlockItem> and;

	public List<BlockItem> getAnd() {
		return and;
	}

	public ParameterDTO setAnd(List<BlockItem> and) {
		this.and = and;
		return this;
	}
}
