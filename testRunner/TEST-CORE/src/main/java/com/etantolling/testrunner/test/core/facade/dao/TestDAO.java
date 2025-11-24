package com.etantolling.testrunner.test.core.facade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.dto.HistoryDTO;
import com.etantolling.testrunner.test.core.dto.TestViewDTO;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;


public class TestDAO {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<TestViewDTO> loadView() throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			
			String versionDate=EnvironmentHelper.getVersionDate();
			StringBuilder sql = new StringBuilder();
//			sql.append(" select *");
//			sql.append(" from (");
			sql.append(" 	select TESTID,");
			sql.append("       (select USERNAME from INPUTUSER where INPUTUSERID = T.OWNER and startdate<="+versionDate+" and enddate>="+versionDate+") Owner,");
			sql.append("       fp.FOLDERPATH  FOLDER,");
			sql.append("       fp.FOLDERID,");
			sql.append("       TESTNAME, t.DESCRIPTION, NOTES, ");
			//		+ "to_char(StartDate, 'YYYY-MM-DD HH24:MI:SS') startDate, "
			sql.append("to_char(EndDate, 'YYYY-MM-DD HH24:MI:SS') endDate, KEYWORDS");
			//sql.append("convert(char,t.EndDate, 120) endDate, t.KEYWORDS");
			sql.append("    from test t "
					+ " left join FOLDERPATHS fp on fp.FOLDERID = T.FOLDERID");
			sql.append("    WHERE t.DELETED=0 and t.startdate<="+versionDate+" and t.enddate>="+versionDate+"");
//			sql.append(" ) where (0=0) ");
			List<TestViewDTO> list = new QueryRunner().query(conn, sql.toString(), new BeanListHandler<TestViewDTO>(TestViewDTO.class));
			return list;
		} finally {
			// Use this helper method so we don't have to check for null
			DbUtils.close(conn);
		}
	}
	
	public TestViewDTO findView(Integer testId) throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			String versionDate=EnvironmentHelper.getVersionDate();
			StringBuilder sql = new StringBuilder();
			sql.append(" select testid,"
					+ "	(select username from inputuser where inputuserid=t.owner and startdate<="+versionDate+" and enddate>="+versionDate+" ) owner, "
							+ " folderid, "
							+ " TestName, "
							+ " description, "
							//+ " to_char(StartTestDate, 'YYYY-MM-DD HH24:MI:SS') startDate, "
							//+ " to_char(EndtestDate, 'YYYY-MM-DD HH24:MI:SS') endDate, "
							//+ " RunNightlyScripts, "
							+ " Notes");
			sql.append(" from test t ");
			sql.append(" where testid = ? and startdate<="+versionDate+" and enddate>="+versionDate+"" );
			return new QueryRunner().query(conn, sql.toString(), new BeanHandler<TestViewDTO>(TestViewDTO.class), testId);
		} finally {
			// Use this helper method so we don't have to check for null
			DbUtils.close(conn);
		}
	}

	public List<HistoryDTO> getHystory(Integer testId) throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			
			String versionDate=EnvironmentHelper.getVersionDate();
			StringBuilder sql = new StringBuilder();
			sql.append(" 	select *");
			sql.append("    from history t ");
			sql.append("    WHERE testid="+testId +" order by postingdate desc ");
			List<HistoryDTO> list = new QueryRunner().query(conn, sql.toString(), new BeanListHandler<HistoryDTO>(HistoryDTO.class));
			return list;
		} finally {
			DbUtils.close(conn);
		}
	}

	public HistoryDTO createHistory(HistoryDTO historyDTO) throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			if(null== historyDTO.getHistoryId())
				{
				String sql="insert into history (testId,enviroment)   values ("+historyDTO.getTestId() +", '"+historyDTO.getEnviroment() +"')" ;
				PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.executeUpdate();
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					historyDTO.setHistoryId(generatedKeys.getInt(1));
				} 
			}else {
				String sql="update history set lasteventID="+historyDTO.getLastEventId() +", statusId="+historyDTO.getStatusId() +" where historyid="+historyDTO.getHistoryId() ;
				conn.createStatement().execute(sql);
			}
			
		return historyDTO;
		} finally {
			DbUtils.close(conn);
		}
	}
}
