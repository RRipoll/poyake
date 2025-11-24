package com.jsantos.metadata;

import com.jsantos.orm.mt.MTDataType;

public class MTDataTypes { 
	public static final MTDataType VARCHAR= new MTDataType("VARCHAR","VARCHAR","java.lang.String",null,false,true);
	public static final MTDataType INT= new MTDataType("INT","INT","java.lang.Integer",null,false,false);
	public static final MTDataType URL= new MTDataType("URL","VARCHAR","java.lang.String",VARCHAR,true,false);
	public static final MTDataType NUMBER= new MTDataType("NUMBER","NUMBER","java.math.BigDecimal",null,true,false);
	public static final MTDataType DATE= new MTDataType("DATE","DATE","java.sql.Date",null,false,false);
	public static final MTDataType DATETIME= new MTDataType("DATETIME","DATETIME","java.sql.Timestamp",null,false,false);
} 

