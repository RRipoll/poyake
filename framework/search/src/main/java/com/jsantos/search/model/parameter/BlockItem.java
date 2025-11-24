package com.jsantos.search.model.parameter;

import java.util.ArrayList;
import java.util.List;

public class BlockItem {

	public BlockItem() {
		super();
	}

	private List<WhereItem> parameters;
	private List<BlockItem> and;
	private List<BlockItem> or;
	
	public List<WhereItem> getParameters() {
		if(null==parameters)
			 parameters= new ArrayList<WhereItem>();
		return parameters;
	}
	
	public void setParameters(List<WhereItem> parameters) {
		this.parameters = parameters;
	}
	
	public List<BlockItem> getAnd() {
		if(null==and)
			and=new ArrayList<BlockItem>();
		return and;
	}
	
	public void setAnd(List<BlockItem> and) {
		this.and = and;
	}
	
	public List<BlockItem> getOr() {
		if(null==or)
			or=new ArrayList<BlockItem>();
		return or;
	}
	
	public void setOr(List<BlockItem> or) {
		this.or = or;
	}
}
