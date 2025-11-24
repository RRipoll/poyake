package com.jsantos.framework.configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.dao.RecoverableDataAccessException;

import com.jsantos.metadata.MT;
import com.jsantos.metadata.cfg.ConfigKeyDTO;
import com.jsantos.metadata.cfg.EnuConfigKeyType;
import com.jsantos.metadata.cfg.MTTableCONFIGKEY;
import com.jsantos.metadata.cfg.MTTableCONFIGLISTVALUE;
import com.jsantos.metadata.cfg.MTTableCONFIGVALUE;
import com.jsantos.metadata.cfg.MTTableVCURRENTCONFIGVALUES;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class Config {
	
	public String get(String fullPath) throws SQLException{
		DetachedRecord drConfigKey = new DetachedRecord(MT.CONFIGKEY, " fullPath ='" + fullPath + "'");
		DetachedRecord drV = new DetachedRecord(MT.VCURRENTCONFIGVALUES, " configKeyId =" + drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYID)); 
		return drV.getString(MTTableVCURRENTCONFIGVALUES.VALUE);
	}
	
	public String get(int configKeyId) throws SQLException{
		DetachedRecord drConfigKey = new DetachedRecord(MT.CONFIGKEY, " configKeyId =" + configKeyId );
		DetachedRecord drV = new DetachedRecord(MT.VCURRENTCONFIGVALUES, " configKeyId =" + drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYID)); 
		return drV.getString(MTTableVCURRENTCONFIGVALUES.VALUE);
	}

	public List<String> getListValues(int configKeyId) throws SQLException{
		ArrayList<String> retValues = new ArrayList<>();
		DetachedRecord drConfigKey = new DetachedRecord(MT.CONFIGKEY, " configKeyId =" + configKeyId );
		DetachedQueryResult dqr = new DetachedQueryResult(MT.CONFIGLISTVALUE, " configKeyId =" + drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYID));
		for (LinkedHashMap<String, Object> row:dqr.getPage(0)) {
			retValues.add((String)row.get(MTTableCONFIGLISTVALUE.VALUE.toString()));
		}
		return retValues;
	}

	public ConfigKeyDTO getKeyDefinition(String fullPath) throws SQLException {
		DetachedRecord dr = new DetachedRecord(MT.CONFIGKEY, " where fullPath ='" + fullPath + "'");
		return new ConfigKeyDTO(dr.getPk());
	}

	public ConfigKeyDTO getKeyDefinition(int configKeyId) throws SQLException{
		return new ConfigKeyDTO(configKeyId);
	}

	public void set(String fullPath, String value){
		DetachedRecord drConfigKey = new DetachedRecord(MT.CONFIGKEY, " where fullPath ='" + fullPath + "'");
		if (drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYTYPEID).equals(EnuConfigKeyType.SINGLEVALUE)) {
			DetachedRecord dr = new AutoHistoryDetachedRecord(MT.CONFIGVALUE, true, drConfigKey.getPk());
			dr.set(MTTableCONFIGVALUE.VALUE, value);
			dr.update();
		}
		if (drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYTYPEID).equals(EnuConfigKeyType.VALUEWITHTIME)) {
			DetachedRecord dr = new DetachedRecord(MT.CONFIGVALUE);
			dr.set(MTTableCONFIGVALUE.CONFIGKEYID, drConfigKey.getPk());
			dr.set(MTTableCONFIGVALUE.VALUE, value);
			dr.insert();
		}
	}

	public void set(int configKeyId, String value){
		DetachedRecord drConfigKey = new DetachedRecord(MT.CONFIGKEY, configKeyId);
		if (drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYTYPEID).equals(EnuConfigKeyType.SINGLEVALUE)) {
			DetachedRecord dr = new AutoHistoryDetachedRecord(MT.CONFIGVALUE, true, drConfigKey.getPk());
			dr.set(MTTableCONFIGVALUE.VALUE, value);
			dr.update();
		}
		if (drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYTYPEID).equals(EnuConfigKeyType.VALUEWITHTIME)) {
			DetachedRecord dr = new DetachedRecord(MT.CONFIGVALUE);
			dr.set(MTTableCONFIGVALUE.CONFIGKEYID, drConfigKey.getPk());
			dr.set(MTTableCONFIGVALUE.VALUE, value);
			dr.insert();
		}
	}

	public void setInFuture(int configKeyId, String value, Date startDate, Date endDate){
		DetachedRecord drConfigKey = new DetachedRecord(MT.CONFIGKEY, configKeyId);
		if (!drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYTYPEID).equals(EnuConfigKeyType.VALUEWITHTIME))
			throw new RecoverableDataAccessException("Only can set effectiveStartDate and effectiveEndDate for keys of type VALUEWITHTIME");
		DetachedRecord dr = new DetachedRecord(MT.CONFIGVALUE);
		dr.set(MTTableCONFIGVALUE.CONFIGKEYID, drConfigKey.getPk());
		dr.set(MTTableCONFIGVALUE.STARTDATE, startDate);
		dr.set(MTTableCONFIGVALUE.ENDDATE, endDate);
		dr.set(MTTableCONFIGVALUE.VALUE, value);
		dr.insert();
	}

	public void addToList(int configKeyId, String value){
		DetachedRecord drConfigKey = new DetachedRecord(MT.CONFIGKEY, configKeyId);
		if (!drConfigKey.get(MTTableCONFIGKEY.CONFIGKEYTYPEID).equals(EnuConfigKeyType.LIST))
			throw new RecoverableDataAccessException("This is not a Set configuration key");
		DetachedRecord dr = new DetachedRecord(MT.CONFIGLISTVALUE);
		dr.set(MTTableCONFIGLISTVALUE.CONFIGKEYID, drConfigKey.getPk());
		dr.set(MTTableCONFIGLISTVALUE.VALUE, value);
		dr.insert();
	}

}
