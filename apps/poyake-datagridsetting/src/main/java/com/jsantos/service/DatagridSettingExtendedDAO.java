package com.jsantos.service;

import java.util.List;
import java.util.Locale;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.DetailConfiguration;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.model.conf.OrderByConfiguration;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.extendeddto.DatagridSettingExtDTO;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.factory.dataSetting.IDataSettingProvider;
import com.jsantos.metadata.config.DatagridSettingDTO;
import com.jsantos.metadata.config.MTTableDATAGRIDSETTING;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DQResults;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTTable;
//@Slf4j
/**
 * @author raul ripoll
 */


public class DatagridSettingExtendedDAO implements IDataSettingProvider  {
	
	  List<DatagridSettingExtDTO> findAll(String searchName, Integer inputUserGroupId,Locale locale) {
		
		String sql = "select distinct * from ( 				" + 
				" select 1 orderby, * 	from config.DatagridSetting " + 
				" where searchName=:searchName and inputUserGroupId=:inputUserGroupId   				 " + 
				" union all 				 " + 
				" select 2 orderby, * 	from config.DatagridSetting " + 
				" where searchName=:searchName and inputUserGroupId=1 " + 
				")p  order by orderBy asc, dataGridSettingId Desc		" ;
		
		DetachedQueryResult dqr= new DetachedQueryResult(MTBase.getTable("DATAGRIDSETTING"));
		dqr.setCustomSql(sql);
		
		MapValues<Object> namedParameters = new MapValues<Object>().add("searchName", searchName).add("inputUserGroupId", inputUserGroupId);
		dqr.setParameters(namedParameters);
		
		DQResults<DatagridSettingExtDTO> result=dqr.getPage(null,DatagridSettingExtDTO.class);
		
		System.out.println(searchName+"  "+inputUserGroupId);
		System.out.println("DatagridSettingExtendedDAO results= "+ result.getRawData().size());
		
		return result.getRawData();
	}
	
	 DatagridSettingExtDTO getDatagridSettingDTO(String searchName, String contextName, Integer onlyUser,Integer inputUserGroupId,Locale locale){
		DatagridSettingExtDTO retValue=null;
		List<DatagridSettingExtDTO> dataGridSettingDTOs= findAll(searchName,inputUserGroupId,locale);
		if (null != dataGridSettingDTOs && !dataGridSettingDTOs.isEmpty()) {
			retValue= dataGridSettingDTOs.get(0);
		}
		return retValue;
	}
	
	@Override
	public List<String> findAllSearchName() {
		String sql = " select distinct searchName from   config.DatagridSetting ";
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
		return jdbcTemplate.queryForList(sql, new MapSqlParameterSource(), String.class);
	}

	@Override
	public  SettingDTO getSetting(String searchName, Integer inputUserGroupId,Locale locale) throws ApiException {
		return (SettingDTO) getDGSettingEx(searchName,  inputUserGroupId, locale).getData();
	}
	
	@Override
	public  DatagridSettingExtDTO getDGSettingEx(String searchName,  Integer inputUserGroupId,Locale locale) throws ApiException {
		
		DatagridSettingExtDTO dGSdto;
		List<DatagridSettingExtDTO> dataGridSettingDTOs = findAll(searchName, inputUserGroupId,locale);
		if (!dataGridSettingDTOs.isEmpty()) {
			dGSdto=dataGridSettingDTOs.get(0);
		}else {
				MTTable mTTable= MTBase.getTable(searchName);
				dGSdto=new DatagridSettingExtDTO();
				dGSdto.setInputUserGroupId(inputUserGroupId);
				dGSdto.setSearchName(searchName);
				dGSdto.setData(DataSettingFactory.createDefaultSettingDTO(mTTable,locale));
		}
		return dGSdto;
	}
	
	
	
	 
	
	
	  String getSearchNameAndContextName(String searchName, String contextName) {
		if (null == contextName || contextName.length() == 0)
			return searchName;
		else
			return searchName + "[" + contextName.toUpperCase() + "]";
	}
	
	
	public  SettingDTO getSetting(DatagridSettingDTO dto,Integer inputUserGroupId){
		SettingDTO settingDTO = (SettingDTO) dto.getData();

		if (null != dto) {
			
			if (dto.getInputUserGroupId() != inputUserGroupId) {
				dto.setDataGridSettingId(null);
			    dto.setInputUserGroupId(inputUserGroupId);
			}
			
			settingDTO.setaSName(dto.getSearchName());
			MTTable table=MTBase.getTable(settingDTO.getDataTableName());
			settingDTO.setMtTable(table);
			
			setMTFieldToSetting( settingDTO);
		
		}
		return settingDTO;
	}
	
	
	
	public static SettingDTO setMTFieldToSetting(SettingDTO settingDTO) {
		for (GridColumnConfiguration config : settingDTO.getColumnConfigurations()) {
					config.setMtField(settingDTO.getMtTable().getField(config.getName()));}
		for (OrderByConfiguration config : settingDTO.getOrderByConfigurations()) {
					config.setMtField(settingDTO.getMtTable().getField(config.getName()));}
		for (FilterConfiguration config : settingDTO.getFilterConfigurations()) {
					config.setMtField(settingDTO.getMtTable().getField(config.getName()));}
		for (DetailConfiguration config : settingDTO.getDetailScreenConfigurations()) {
					config.setMtField(settingDTO.getMtTable().getField(config.getName()));}
		for (DetailConfiguration config : settingDTO.getEditConfigurations()) {
					config.setMtField(settingDTO.getMtTable().getField(config.getName()));}
		return settingDTO;
	}

	

	@Override
	public SettingDTO getSetting(IDetachedRecord dto, Integer inputUserGroupId) {
		return getSetting((DatagridSettingDTO) dto, inputUserGroupId);
	}

	@Override
	public IDetachedRecord setSetting(SettingDTO settingDTO, IDetachedRecord dto, Integer inputUserGroupId) {
		if(null==dto) {
			DatagridSettingDTO dg= new DatagridSettingDTO();
			dg.setInputUserGroupId(inputUserGroupId);
			dg.setSearchName(settingDTO.getaSName());
			dto=dg;
		}
		if(null==((DatagridSettingDTO)dto).getSearchName())((DatagridSettingDTO)dto).setSearchName(settingDTO.getaSName());
		((DatagridSettingDTO)dto).setInputUserGroupId(inputUserGroupId);
		((DatagridSettingDTO)dto).set(MTTableDATAGRIDSETTING.DATA, settingDTO);
		
		return dto;
	}

	@Override
	public IDetachedRecord insertSetting(SettingDTO settingDTO, IDetachedRecord dto, Integer inputUserGroupId)
			throws ApiException {
		dto=setSetting( settingDTO,  dto,  inputUserGroupId);
		if(null!=((DatagridSettingExtDTO)dto).getDataGridSettingId())
			dto.update();
		else dto.insert();
			
	return dto;
		
	}

	@Override
	public boolean isImplemented() {
		return true;
	}
}