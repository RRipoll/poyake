package com.etantolling.testrunner.test.core.facade.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.dto.FileRefDTO;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class FileRefDAO {
	

	/*
	 * 
	 * 	OLD IMPLEMENTATION
	 * 
	 */


	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<FileRefDTO> search(Integer eventId) throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			String versionDate=EnvironmentHelper.getVersionDate();
			StringBuilder sql = new StringBuilder();
			sql.append(" select fr.* from");
			sql.append(" fileref fr join eventfile ef on ef.filerefid = fr.filerefid and ef.EventId = ? and ef.startdate<="+versionDate+" and ef.enddate>="+versionDate+"");
			List<FileRefDTO> list = new QueryRunner().query(conn, sql.toString(), new BeanListHandler<FileRefDTO>(FileRefDTO.class), eventId);
			return list;
		} finally {
			// Use this helper method so we don't have to check for null
			DbUtils.close(conn);
		}
	}
	
	public String findUrl(Integer fileRefId) throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			String sql = "select azureUrl from fileref where filerefid = ?";
			return new QueryRunner().query(conn, sql, new ScalarHandler<String>(), fileRefId);
		} finally {
			// Use this helper method so we don't have to check for null
			DbUtils.close(conn);
		}
	}
	
}
