package com.jsantos.factory.dataSetting;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.constraint.ConstraintsComponentProvider;
import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.model.EditMode;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.ActionConstraints;
import com.jsantos.common.model.conf.DetailConfiguration;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.model.conf.OrderByConfiguration;
import com.jsantos.common.registry.AppClassRegistry;
import com.jsantos.common.util.ListValues;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class DataSettingFactory {


	private static String GUI_PACKAGE = "com.jsantos.service";
	private static String className = "com.jsantos.factory.dataSetting.IDataSettingProvider";
	private static  IDataSettingProvider dataSettingProvider = null;
	
	
	public static void init()  {
		if(null==dataSettingProvider){
			Class<?> iclass=AppClassRegistry.getClasses(GUI_PACKAGE, className);
			if(null!=iclass)
				try {
					dataSettingProvider=(IDataSettingProvider) iclass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			else dataSettingProvider=new DataSettingProviderDefault();
			dataSettingProvider.inicialice();
			}
	}
	public static IDataSettingProvider getProvider() {
		if(null==dataSettingProvider) init();
		return dataSettingProvider;
	}
	
	
	public static  DetailConfiguration getDetailConfiguration(SettingDTO settingDTO,MTField mTfield,EditMode mode) {
		if(null==mTfield) {
			System.out.println("Setting for "+ settingDTO.getaSName()+ " are obsolete ");
			return null;
		}
		List<DetailConfiguration> confs;
		if(mode==EditMode.SHOW)
			confs=settingDTO.getDetailScreenConfigurations();
		else confs=settingDTO.getEditConfigurations();
		for (DetailConfiguration detail :confs ) {
			if(detail.getMtField().equals(mTfield))
				return detail;
		}
		return null;
	}

	
	public static SettingDTO createDefaultSettingDTO(MTTable mtTable,Locale locale) {
		
		SettingDTO settingDTO= new SettingDTO();
		settingDTO.setMtTable(mtTable);
		settingDTO.setaSName(mtTable.getTableName());
		{		
		List<FilterConfiguration> filterConfigurations = new ArrayList<FilterConfiguration>();
			for (MTField mtField:mtTable.getFields()) {
				FilterConfiguration filter=new FilterConfiguration(mtField.getName());
				filter.setMtField(mtField);
				if(mtField.isNoGuiInput())filter.setHidden(true);
				//filter.setCompareType(CompareType.Default);
				//filter.setFormatters(new ListValues<SearchParameter.Formatter>().addValue(Formatter.Default));
				filterConfigurations.add(filter);
			}
			settingDTO.setFilterConfigurations(filterConfigurations);
		}
		
		{
		List<GridColumnConfiguration> columnConfigurations = new ArrayList<GridColumnConfiguration>();
			for (MTField mtField:mtTable.getFields()) { 
				GridColumnConfiguration gridConf=new GridColumnConfiguration(mtField.getName());
				gridConf.setMtField(mtField);
				if(mtField.isNoGuiInput())gridConf.setHidden(true);
				columnConfigurations.add(gridConf);
			}
		settingDTO.setColumnConfigurations(columnConfigurations);
		}

		{
		List<OrderByConfiguration>	orderByConfigurations = new ArrayList<OrderByConfiguration>();
			for (MTField mtField:mtTable.getFields()) { 
				OrderByConfiguration gridConf=new OrderByConfiguration(mtField.getName(), LabelFactory.getProvider().get(mtField,locale),false,false);
				gridConf.setMtField(mtField);
				orderByConfigurations.add(gridConf);
			}
		settingDTO.setOrderByConfigurations(orderByConfigurations);
		}
		
		{		
			List<DetailConfiguration> detailConfigurations = new ArrayList<DetailConfiguration>();
				for (MTField mtField:mtTable.getFields()) {
					DetailConfiguration detail=new DetailConfiguration(mtField.getName());
					detail.setMtField(mtField);
					if(mtField.isNoGuiInput())detail.setHidden(true);
					detailConfigurations.add(detail);
				}
				settingDTO.setDetailScreenConfigurations(detailConfigurations);
			}
		{		
			List<DetailConfiguration> editConfigurations = new ArrayList<DetailConfiguration>();
				for (MTField mtField:mtTable.getFields()) {
					DetailConfiguration detail=new DetailConfiguration(mtField.getName());
					detail.setMtField(mtField);
					if(!mtField.isNullable() && null==mtField.getDefaultValue())
						detail.setRequired(true);
					if(mtField.isNoGuiInput())detail.setHidden(true);
					if(mtField.isPrimaryKey()) 
						detail.setHidden(true);
					if(mtField.isMainFK()) 
						detail.setHidden(true);
					if(mtField.isGuiInput()) 
						detail.setHidden(false);
					detail.setConstraints(createDefaultConstraints(mtField));
					ListValues<ActionConstraints> actions=new ListValues<ActionConstraints>();
					actions.add(new ActionConstraints());
					detail.setActions(actions);
					editConfigurations.add(detail);
				    
				}
				settingDTO.setEditConfigurations(editConfigurations);
			}
		
		settingDTO.setaSName(mtTable.getFullTableName());
		settingDTO.setDataTableName(mtTable.getFullTableName());
		
		return settingDTO;
	}
	
	 static ListValues<String> createDefaultConstraints(MTField mtField) {
			ListValues<String>constraints= new ListValues<String>();
			 
				for (IConstraintsBuilder constraint : ConstraintsComponentProvider.getConstraintsComponent(mtField)) {
					constraints.add(constraint.getClass().getName());
				}
			    if(constraints.isEmpty() && (!mtField.isNullable() || null!=mtField.getLength())) constraints.add("com.jsantos.custom.constraints.DefaultMTConstraint");
			    return constraints;
		}
	 
	 
	 public static String setData(SettingDTO settingDTO) {
				ObjectMapper mapper = new ObjectMapper();
				try {
					mapper.setSerializationInclusion(Include.NON_NULL);
				
				String data = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(settingDTO));
				return data;
	 } catch (Exception e) {
			throw new ApiException(ApiError.DATA_ERROR, "Error parsing Java Object to Json ");
		}
		}
	 
	 
	 public static SettingDTO setData(String data) {
		 
		 ObjectMapper mapper = new ObjectMapper();
			try {
				SettingDTO settingDTO = mapper.readValue(data, SettingDTO.class);
				return settingDTO;
			} catch (Exception e) {
				throw new ApiException(ApiError.JSON_ERROR, "Error parsing json to Java Object");
			}
		 
	 }
	 
	 
	 
	 
}
