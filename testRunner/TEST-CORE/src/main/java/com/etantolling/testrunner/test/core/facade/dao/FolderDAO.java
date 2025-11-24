package com.etantolling.testrunner.test.core.facade.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.core.dto.FolderDTO;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class FolderDAO {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<FolderDTO> showFolder() throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			String versionDate=EnvironmentHelper.getVersionDate();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT FOLDERID, FOLDERPATH ");
			//sql.append(" FROM DBO.FOLDERPATHS WHERE DELETED = 0 ");
			sql.append(" FROM FOLDERPATHS WHERE DELETED = 0 ");
			sql.append(" ORDER BY folderpath desc");
			List<FolderDTO> list = new QueryRunner().query(conn, sql.toString(),
					new BeanListHandler<FolderDTO>(FolderDTO.class));
			return list;
		} finally {
			DbUtils.close(conn);
		}
	}
}
