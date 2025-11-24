package com.jsantos.search.core.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.metadata.MTDataTypes;

public class JsonNodeRowMapper {

	private List<Map<String, Object>> mapper;
	private SettingDTO settingDTO;
	private Integer total;

	public JsonNodeRowMapper(List<Map<String, Object>> mapper, SettingDTO settingDTO) {
		this.mapper = mapper;
		this.settingDTO = settingDTO;
		init();
	}

	public JsonNodeRowMapper(List<Map<String, Object>> mapper) {
		this.mapper = mapper;
		init();
	}

	public void init() {

		for (Map<String, Object> map : mapper) {

			for (Entry<String, Object> entry : map.entrySet()) {
				if (entry.getKey().equals("querytotalcount")) {
					total = (Integer) entry.getValue();
					map.remove(entry.getKey());
				} else {
					Entry<String, Object> retEntry = putObjectNodeSettings(entry);
					map.put(retEntry.getKey(), retEntry.getValue());
				}
			}
		}
	}

	private Entry<String, Object> putObjectNodeSettings(Entry<String, Object> entry) {
		if (null != settingDTO && null != settingDTO.getColumnConfigurations() && !settingDTO.getColumnConfigurations().isEmpty())
			for (GridColumnConfiguration item : settingDTO.getColumnConfigurations()) {
				if (item.getName().equals(entry.getKey())) {
					if (item.getMtField().getDataType().equals(MTDataTypes.JSON) && null != entry.getValue()) {
						try {
							ObjectMapper objectMapper = new ObjectMapper();
							JsonNode json = objectMapper.readTree(entry.getValue().toString());
							entry.setValue(json);
						} catch (Exception e) {
						}
					}
					return entry;
				}
			}
		return entry;
	}

	public Integer getTotal() {
		return total;
	}

	public List<Map<String, Object>> getMapper() {
		return mapper;
	}

	public void setMapper(List<Map<String, Object>> mapper) {
		this.mapper = mapper;
	}

	public SettingDTO getSettingDTO() {
		return settingDTO;
	}

	public void setSettingDTO(SettingDTO settingDTO) {
		this.settingDTO = settingDTO;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}