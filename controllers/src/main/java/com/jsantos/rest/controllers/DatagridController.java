package com.jsantos.rest.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsantos.common.model.SearchParameter;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.search.core.services.DataGridEiFacade;
import com.jsantos.search.model.ParameterDTO;
import com.jsantos.search.model.search.AgGridDTO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/api/datagrid")
//@Slf4j

/**
 * @author raul ripoll
 */


public class DatagridController {

	Integer inputUserGroupId=1;
	//Locale locale=Locale.ENGLISH;
	
	@PostMapping("/conf/{searchName:.+}/set")
	public SettingDTO setSettings(@PathVariable String searchName,
			@RequestBody  SettingDTO setting) throws ApiException {
		////log.info("*** Set Settings {}", setting);
		if (null == searchName || searchName.contains(" "))
			throw new ApiException(ApiError.DB_BAD_METADATA, "wrong dataTableName");
		setting.setaSName(searchName);
		DataSettingFactory.getProvider().setSetting(setting, null, inputUserGroupId);
		return setting;
	}
	
	@ApiOperation(value = "Get setting for a dataGrid.", notes = "development purpose.")
	@GetMapping("/conf/{searchName:.+}/get")
	public SettingDTO getSettings(@PathVariable String searchName,@RequestParam(name = "contextName", required = false) String contextName) throws ApiException {
		////log.info("**** getSettings for  {}", searchName);
		//, @RequestParam(name = "defaultConf", defaultValue = "false") boolean defaultConf
		return DataSettingFactory.getProvider().getSetting(searchName,inputUserGroupId,Locale.getDefault());
	}
	
	
	@ApiOperation(value = "Create setting for a dataGrid.", notes = "development purpose.")
	@GetMapping("/view/{searchName:.+}/create")
	public SettingDTO createSettings(@PathVariable String searchName) throws ApiException {
		////log.info("*** createSettings for  {}", searchName);
		return DataSettingFactory.getProvider().getSetting(searchName, inputUserGroupId, Locale.getDefault());
	}

	/*
	@RequestMapping(value = "/view/create-setting-with-paramenters", method = RequestMethod.POST, produces = "application/json")
	////@ApiOperation(value = "Create setting for a dataGrid with parameters.", notes = "development purpose.")
	@GetMapping("/view/create_Setting_With_Paramenters")
	public SettingDTO createSettingsWithParamenters(@RequestParam String searchName, @RequestBody @Valid HashMap<String, Object> parameters) throws ApiException {
		log.info("*** createSettings for  {}", searchName);
		return dataGridiEFacade.createSetting(searchName,null,null,parameters);
	}	
	*/
	
	/*
//	//@ApiOperation(value = "getDefault sql insert for a dataGrid.", notes = "development purpose.")
	@RequestMapping(value = "/view/{searchName:.+}/getInsert", method = RequestMethod.GET, produces = "text/plain")
	public String getInsertSettings(@PathVariable String searchName, String contextName) throws ApiException {
	log.info("*** createSettings for  {}", searchName);
		return dataGridSettingFacade.getInsertSetting(searchName,contextName);

	}
	*/
	
	
	/*
//	//@ApiOperation(value = "get Default configuration sql insert from a view.", notes = "development purpose.")
	@RequestMapping(value = "/view/{sqlViewName}/searchName/{advancedSearchName}/create-set-getInsert", method = RequestMethod.GET, produces = "text/plain")
	public String getInsertFromSqlSettings(@PathVariable String sqlViewName, String advancedSearchName) throws ApiException {
	log.info("*** createSettings for  {}", sqlViewName);
		SettingDTO metadata= dataGridiEFacade.createSetting(sqlViewName,null,null,null);
		if (null == advancedSearchName || advancedSearchName.contains(" "))
			throw new ApiException(ApiError.DB_BAD_METADATA, "wrong advancedSearchName");
		dataGridiEFacade.insertSetting(advancedSearchName,null, metadata, null);
		return dataGridSettingFacade.getInsertSetting(advancedSearchName,null);
	}
	
	*/

	
	
	@PostMapping(value = "/search/results/{searchName}")
	@ApiOperation(value = "Get data from a view/table for ag-Grid.", notes = "Get data from a view/table for ag-Grid.")
	public AgGridDTO getViewDataAgGrid(@PathVariable String searchName
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
		return DataGridEiFacade.getDataFromViewAgGrid(searchName,null, parametersDTO,urlParameters,inputUserGroupId,Locale.US);

	}
	
	
	
	
	/*
	@RequestMapping(value = "/search/results", method = RequestMethod.POST, produces = "application/json")
	////@ApiOperation(value = "Get data from a view/table for ag-Grid.", notes = "Get data from a view/table for ag-Grid.")
	public AgGridDTO getViewDataAgGrid(@RequestParam String searchName
			, @RequestParam(name = "contextName", required = false) String contextName
			, @RequestBody ParameterDTO parametersDTO
			, @RequestParam(name = "orderBy", required = false) String orderBy
			, @RequestParam(name = "page", required = false) String page
			, @RequestParam(name = "asOfDate", required = false) String asOfDate
			, @RequestParam(name = "size", required = false) String size
			)
			throws ApiException {
		MapValues urlParameters= new MapValues();
		urlParameters.put("orderBy", orderBy);
		urlParameters.put("page", page);
		urlParameters.put("asOfDate", asOfDate);
		urlParameters.put("size", size);
		return DataGridEiFacade.getDataFromViewAgGrid(searchName,null, null,urlParameters);

	}
*/
	
	/*
	@RequestMapping(value = "/sql", method = RequestMethod.POST, produces = "application/json")
	//@ApiOperation(value = "Get sql from a view/table for ag-Grid.", notes = "Get sql from a view/table for ag-Grid.")
	public String getViewsqlgGrid(@RequestParam String searchName, @RequestParam(name = "contextName", required = false) String contextName, @RequestBody @Valid ParameterDTO parametersDTO, @RequestParam(name = "orderBy", required = false) String orderBy,
			@RequestParam(name = "page", required = true) String page, @RequestParam(name = "asOfDate", required = false) String asOfDate, @RequestParam(name = "size", required = true) String size)
			throws ApiException {
		return dataGridiEFacade.getSqlFromViewAgGrid(searchName,contextName, parametersDTO,null);

	}
*/
	
	/*
	@RequestMapping(value = "/ag-Grid/sql-example", method = RequestMethod.POST, produces = "application/json")
	//@ApiOperation(value = "Get data from a sql for ag-Grid.", notes = "Get data from a sql for ag-Grid.")
	public AgGridDTO getViewDataFromSql(@RequestParam(name = "contextName", required = false) String contextName, @RequestBody @Valid ParameterDTO parametersDTO, @RequestParam(name = "orderBy", required = false) String orderBy,
			@RequestParam(name = "page", required = true) String page,
			@RequestParam(name = "asOfDate", required = false) String asOfDate,
			@RequestParam(name = "size", required = true) String size,
			@RequestParam(name = "inputSourceId", required = true) Integer inputSourceId
			)
			throws ApiException {
		HashMap<String, Object> parameters= new HashMap<>();

		parameters.put("inputSourceId", inputSourceId);
		
		return dataGridiEFacade.getDataFromViewAgGrid("SqlExample",contextName, parametersDTO , parameters);
	}
	*/
	
	@ApiOperation(value = "Get constants for  dataGrid process.", notes = "Get constants for  dataGrid process.")
	
	@GetMapping("/constants")
	public Map<String, String[]> getConstants() throws ApiException {
		////log.info("*** getConstants for  DataGrid");
		return SearchParameter.getSearchParameters();
	}
	
	
	
	
	

	@ApiOperation(value = "Get Advanced Search Names for  dataGrid process.", notes = "Get Advanced Search Names for  dataGrid process.")
	@GetMapping("/search-names")
	public List<String> getSearchNames() throws ApiException {
		////log.info("*** getSearchNames for  DataGrid");
		return DataSettingFactory.getProvider().findAllSearchName();

	}
	
	/*
	//@ApiOperation(value = "Run Advanced Search by Names for  dataGrid process.", notes = "Run Advanced Search  by Names for  dataGrid process.")
	@GetMapping("/run-by-names")
	public List<String> runBySearchNames() throws ApiException {
		log.info("*** getSearchNames for  DataGrid");
		List<String> names= dataGridiEFacade.getSearchNames();
		List<String> errors= new ArrayList<String>(); 	
		ParameterDTO paramenter=new ParameterDTO();
		paramenter.setAnd(null);
		for (String name : names) {
			String endpoint="";
			try {
				endpoint=" getSetting ";
				SettingDTO conf=dataGridiEFacade.getSetting(name,null,null);
				endpoint=" setSetting ";
				dataGridiEFacade.insertSetting(name,null, conf, null);
				endpoint=" getdata ";
				dataGridiEFacade.getDataFromViewAgGrid(name,null, paramenter);
			} catch (Exception e) {
				errors.add(name + endpoint+"  ----->  "+ e.getMessage()+ " <---- ");
			}
		}
		return errors;
	}
	*/
}
	