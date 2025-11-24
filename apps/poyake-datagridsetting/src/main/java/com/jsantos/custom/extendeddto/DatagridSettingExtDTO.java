package com.jsantos.custom.extendeddto;

import com.jsantos.common.util.MapValues;
import com.jsantos.metadata.MTDataGridSettingData;
import com.jsantos.metadata.config.DatagridSettingDTO;
import com.jsantos.metadata.config.MTTableDATAGRIDSETTING;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public class DatagridSettingExtDTO extends DatagridSettingDTO{

	
	@Override
	public void update() {
		
		DatagridSettingExtDTO dgsex=new DatagridSettingExtDTO();
		
		MapValues<Object> params=		new MapValues<Object>()
				.add(MTTableDATAGRIDSETTING.INPUTUSERGROUPID.getName(), getInputUserGroupId())
				.add(MTTableDATAGRIDSETTING.SEARCHNAME.getName(), getSearchName())
				;
		IDetachedRecord oldConf=null;
		try {
			 oldConf=(DatagridSettingExtDTO) dgsex.find(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null!=oldConf) {
			setDataGridSettingId(oldConf.getString(MTTableDATAGRIDSETTING.DATAGRIDSETTINGID));
			super.update();
		}else {
			
			updates.put(MTDataGridSettingData.DATAGRIDSETTING.DATAGRIDSETTINGID, null);
			originalValues.put(MTDataGridSettingData.DATAGRIDSETTING.DATAGRIDSETTINGID, DBValueMapper.NULL);
			updates.put(MTDataGridSettingData.DATAGRIDSETTING.DATA,getData() );
			updates.put(MTDataGridSettingData.DATAGRIDSETTING.SEARCHNAME, getSearchName());
			updates.put(MTDataGridSettingData.DATAGRIDSETTING.INPUTUSERGROUPID, getInputUserGroupId());
			
			super.insert();
		}
	}

	@Override
	public void insertOrUpdate() {
		
		update();
	}

	
	@Override
	public DatagridSettingDTO insert() {
		update();
		return this;
	}

	
	
	
	
}
