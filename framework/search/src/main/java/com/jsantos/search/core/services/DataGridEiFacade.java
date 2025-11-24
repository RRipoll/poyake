package com.jsantos.search.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.commons.lang3.text.WordUtils;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.orm.dbstatement.DQResults;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.search.model.ParameterDTO;
import com.jsantos.search.model.search.AgGridDTO;
import com.jsantos.search.model.search.ColumnDTO;

/**
 * @author raul ripoll
 */


public class DataGridEiFacade  {
	
	public static  AgGridDTO getDataFromViewAgGrid(String searchName, String contextName, ParameterDTO parameterDto, MapValues<Object> urlParams,Integer inputUserGroupId,Locale locale) throws ApiException {

		AgGridDTO agGridDto = new AgGridDTO();
		
		SettingDTO settingDto = DataSettingFactory.getProvider().getSetting(searchName,inputUserGroupId,locale);
		
		agGridDto.setColumnDef(DataGridEiFacade.getAgGridColumnDef(settingDto,locale));

		MapValues<Object> parameters = new MapValues<Object>();
		
		String whereSection=SqlFacade.createWhereClause(settingDto.getFilterConfigurations(), parameterDto, parameters);
		String selectItems=SqlFacade.createSelectItems(settingDto.getColumnConfigurations(), parameterDto, parameters);
		
		
		DetachedQueryResult Queryresult=new DetachedQueryResult(settingDto.getMtTable());
		Queryresult.setWhereSection(whereSection);
		Queryresult.setParameters(parameters);
		Queryresult.setSelectCustomItems(selectItems);
		Queryresult.setOrderByVector(settingDto.getOrderByConfigurations().stream().filter(c -> c.active==true).collect(Collectors.toList()));
		Queryresult.setPageSize(Integer.parseInt( urlParams.get("size").toString()));
		
		DQResults<IDetachedRecord> result=Queryresult.getPage(Integer.parseInt(urlParams.get("page").toString()));
			
		agGridDto.setRawData(MTHelper.getValuesDR(result.getRawData()));
		agGridDto.setTotal(result.getTotal());
		agGridDto.setPage(result.getPage());
		agGridDto.setSize(result.getSize());
		
		return agGridDto;
	}
	
	public static List<ColumnDTO> getAgGridColumnDef(SettingDTO settingDto,Locale locale) {

		List<ColumnDTO> retValue = new ArrayList<>();

		for (GridColumnConfiguration showItem : settingDto.getColumnConfigurations()) {
			if (showItem.isActive()) {
				ColumnDTO columnItem = new ColumnDTO();
				columnItem.setField(showItem.getName());
				String description = LabelFactory.getProvider().get(showItem.getName(), locale);
				if (null == description)
					columnItem.setHeaderName(WordUtils.capitalize(columnItem.getHeaderName()));
				else
					columnItem.setHeaderName(description);
				columnItem.setType(showItem.getMtField().getDataType().getName());
				columnItem.setGroup(null);
				columnItem.setCellRendererFramework(null);
				retValue.add(columnItem);
			}
		}
		return retValue;
	}
}