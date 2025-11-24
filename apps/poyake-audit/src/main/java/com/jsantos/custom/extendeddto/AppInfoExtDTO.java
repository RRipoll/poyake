package com.jsantos.custom.extendeddto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jsantos.common.util.MapValues;
import com.jsantos.metadata.MTAuditData;
import com.jsantos.metadata.config.AppInfoDTO;
import com.jsantos.metadata.config.AppInfoTreeDTO;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class AppInfoExtDTO extends AppInfoDTO{
	
	public static String sql(String sKey,Integer inputUserGroupId) {
		String sql=
				"select * from \n"
				+ "   (\n"
				+ "    select 1 orderby,* from config.appinfo where ";
				if( null!=sKey)sql+=" skey=:"+MTAuditData.APPINFO.SKEY.getName()+" and ";
				sql+= " inputusergroupId=:"+MTAuditData.APPINFO.INPUTUSERGROUPID.getName()+" \n"
				+ "    union\n"
				+ "    select 2 orderby,* from config.appinfo where";
				if( null!=sKey)sql+=" skey=:"+MTAuditData.APPINFO.SKEY.getName()+" and ";
				sql+= " inputusergroupId in \n"
				+ "           (\n"
				+ "            select inputusergroupId from audit.inputusergroup where shortcode='SA'\n"
				+ "            )\n"
				+ "    union \n"
				+ "    select 2 orderby,* from config.appinfo where";
				if( null!=sKey)sql+=" skey=:"+MTAuditData.APPINFO.SKEY.getName()+" and ";
				sql+=  " inputusergroupId=\n"
				+ "           (\n"
				+ "            select inputusergroupId from audit.inputusergroup where shortcode='SYSTEM'\n"
				+ "            )\n"
				+ ")p  order by orderBy asc,  APPINFOID Desc			";
		return sql;
	}

		
	public IDetachedRecord load(String skey,Integer inputUserGroupId) {
		
		final String sql = sql(skey,inputUserGroupId);
		recordsFound = 0;
		params= new MapValues<Object>().add(MTAuditData.APPINFO.SKEY.getName(), skey)
		.add(MTAuditData.APPINFO.INPUTUSERGROUPID.getName(), inputUserGroupId);
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
		jdbcTemplate.query(sql, new MapSqlParameterSource(params), new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				for (MTField field : fields) {
					try {
						if(null!=rs.getObject(field.getName())){
							originalValues.set(field, DBValueMapper.loadValue(rs, field));
							recordsFound++;
						}
					} catch (Exception e) {
						System.out.println("Exception " + e + " when getting value of field: " + field.getName()
								+ " from sql: " + sql);
						e.printStackTrace();
						throw e;
					}
				}
				setInputUserGroupId(inputUserGroupId);
			}
		});
		if (0 == recordsFound)
			throw new RecoverableDataAccessException("No records found when loading entity: " + table.getFullTableName()
					+ " with filter " + whereExpression);
	return this;
	}
	
	@Override
	public void insertOrUpdate() {
		params= new MapValues<Object>().add(MTAuditData.APPINFO.SKEY.getName(), getSKey())
		.add(MTAuditData.APPINFO.INPUTUSERGROUPID.getName(), getInputUserGroupId());
		AppInfoDTO info=null;
		try {
			info= (AppInfoDTO) new AppInfoDTO().find(params);
		} catch (Exception e) {	}
		
		if(null!=info) {
			info.setSValue(getSValue());
			info.setType(getType());
			info.update();
		}else {
			String appInfoId=getAppInfoId();
			setAppInfoId(null);
			insert();
			params= new MapValues<Object>().add(MTAuditData.APPINFOTREE.APPINFOID.getName(),appInfoId );
			try {
				AppInfoTreeDTO tree= (AppInfoTreeDTO) new AppInfoTreeDTO().find(params);
				tree.setAppInfoTreeId(null);
				tree.setAppInfoId(getAppInfoId());
				tree.insert();
			} catch (Exception e) {}
		}
	}

	@Override
	public AppInfoDTO insert() {
		return super.insert();
	}
}
