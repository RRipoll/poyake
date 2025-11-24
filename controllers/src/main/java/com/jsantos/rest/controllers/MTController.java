package com.jsantos.rest.controllers;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsantos.common.util.MTMapValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.DTOFactory;
import com.jsantos.orm.DBTransaction;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.search.core.services.DataGridEiFacade;
import com.jsantos.search.model.ParameterDTO;
import com.jsantos.search.model.search.AgGridDTO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/api")
//@Slf4j
public class MTController {

	Integer inputUserGroupId=1;
	
	@ApiOperation(value = "Get ", notes = "Get Id.")
	@GetMapping("/mt/table/{tableName}/get/{pK}")
	public MapValues<Object> get(@PathVariable Integer pK, @PathVariable String tableName) throws ApiException {
		////log.info("*** getAdministrativeHearingCaseTypeDTO {}", tableName);
		MTTable mTTable=MTBase.getTable(tableName);
		try {
			IDetachedRecord dr=  DTOFactory.get(mTTable,pK);
			return MTHelper.getValues(dr.getCopyValues());	
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_ERROR, e.getMessage());
		}
	}
	
	@ApiOperation(value = "Put ", notes = "Put ")
	@PutMapping("/mt/table/{tableName}/put/{pK}")
	public MapValues<Object> update(@PathVariable Integer pK,@PathVariable String tableName, @RequestBody MapValues<Object> values) throws ApiException {
		////log.info("*** update {}", tableName);
		MTTable mTTable=MTBase.getTable(tableName);
		final IDetachedRecord dr=  DTOFactory.get(mTTable,pK);
		MTMapValues<Object> mtValues=MTHelper.getValues(values, tableName);
		for (Entry<MTField, Object> item : mtValues.entrySet()) {
			dr.set(item.getKey(), item.getValue());
		}
		new DBTransaction() {
			@Override
			protected void exec() {
				dr.update();
			}
		}.run();
		return MTHelper.getValues(dr.getCopyValues());
	}

	@ApiOperation(value = "Delete", notes = "Delete")
	@DeleteMapping("/table/{tableName}/delete/{pK}")
	public boolean delete(@PathVariable Integer pK,@PathVariable String tableName) throws ApiException {
		////log.info("*** delete {}", tableName);
		MTTable mTTable=MTBase.getTable(tableName);
		final IDetachedRecord dr=  DTOFactory.get(mTTable,pK);
		
		new DBTransaction() {
			@Override
			protected void exec() {
				dr.delete();
			}
		}.run();
		return true;
	}
	
	@ApiOperation(value = "Create", notes = "Create")
	@PostMapping("/table/{tableName}/insert")
	public MapValues<Object> create(@PathVariable String tableName,@RequestBody  MapValues<Object> values)throws ApiException{
		////log.info("*** create {}", tableName);
		
		try {
			MTTable mTTable=MTBase.getTable(tableName);
			final IDetachedRecord dr=  DTOFactory.get(mTTable);
			MTMapValues<Object> mTValues=MTHelper.getValues(values, tableName);
			dr.setValues(mTValues);
			
				new DBTransaction() {
					@Override
					protected void exec() {
						dr.insert();
					}
				}.run();
			
			
			return MTHelper.getValues(dr.getCopyValues());
		} catch (Exception e) {
			ApiException api= new ApiException(ApiError.DATA_ERROR,e.getMessage());
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			api.setBody(sw.toString());
			throw api;
		}
		
	}
	
	@PostMapping(value = "/search/table/{tableName}")
	@ApiOperation(value = "Get data from a view/table for ag-Grid.", notes = "Get data from a view/table for ag-Grid.")
	public AgGridDTO getViewDataAgGrid(@PathVariable String tableName
			//, @RequestParam(name = "contextName", required = false) String contextName
			, @RequestBody ParameterDTO parametersDTO
			//, @RequestParam(name = "orderBy", required = false) String orderBy
			, @RequestParam(name = "page", required = false) String page
			//, @RequestParam(name = "asOfDate", required = false) String asOfDate
			, @RequestParam(name = "size", required = false) String size
			)
			throws ApiException {
		MapValues<Object> urlParameters= new MapValues<Object>();
		//urlParameters.put("orderBy", orderBy);
		urlParameters.put("page", page);
		//urlParameters.put("asOfDate", asOfDate);
		urlParameters.put("size", size);
		return DataGridEiFacade.getDataFromViewAgGrid(tableName,null, parametersDTO,urlParameters,inputUserGroupId,Locale.US);

	}
		
}
