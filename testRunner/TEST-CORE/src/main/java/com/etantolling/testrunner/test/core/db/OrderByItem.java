package com.etantolling.testrunner.test.core.db;


public class OrderByItem{
	String fieldName = null;
	String stringAsc=null;
	String stringDesc=null;
	Boolean asc = true;
	
	OrderByItem(String fieldName, Boolean asc){
		this.fieldName = fieldName;
		this.asc = asc;
	}

	public OrderByItem(String fieldName, String stringAsc,String stringDesc,Boolean asc){
		this.fieldName = fieldName;
		this.stringAsc=stringAsc;
		this.stringDesc=stringDesc;
		this.asc = asc;
	}

	String getOrder(){
		
		if(asc && null!=stringAsc) return stringAsc;
		if(!asc && null!=stringDesc) return stringDesc;
		return fieldName + " " + (asc ? " asc ": " desc ");
	}

}



