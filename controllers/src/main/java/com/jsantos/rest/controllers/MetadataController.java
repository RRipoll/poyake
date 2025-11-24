package com.jsantos.rest.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsantos.common.util.MapValues;
import com.jsantos.commondata.util.HelperControllers;
import com.jsantos.factory.DTOFactory;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

@RestController
@RequestMapping("/rest/api/mt")

public class MetadataController {
	
	 @GetMapping("/tables")
	    public LinkedHashMap<String, MTTable> mtTables() {
	       
	        return MTBase.getTables();
	    }
	    
	    @GetMapping("/table/{tableName}/fields")
	    public ArrayList<MTField> mtTablesFields(@PathVariable String tableName) {
	       
	        return MTBase.getTable(tableName).getFields();
	    }
	    
	    @GetMapping("/table/{tableName}")
	    public MTTable mtTables(@PathVariable String tableName) {
	       
	        return MTBase.getTable(tableName);
	    }
    
	    @GetMapping("/example/{tableName}")
	    public MapValues<Object> mtdto(@PathVariable String tableName) {
	       
	    	IDetachedRecord dr= DTOFactory.get(MTBase.getTable(tableName));
	    	
	        return HelperControllers.getJsonExampleValues(dr.getCopyValues());
	    }
}
