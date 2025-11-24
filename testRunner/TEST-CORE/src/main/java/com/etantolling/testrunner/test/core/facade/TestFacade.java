package com.etantolling.testrunner.test.core.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;

import com.etantolling.testrunner.test.core.dto.EventDTO;
import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.core.dto.FileRefDTO;
import com.etantolling.testrunner.test.core.dto.FolderDTO;
import com.etantolling.testrunner.test.core.dto.HistoryDTO;
import com.etantolling.testrunner.test.core.dto.TestViewDTO;
import com.etantolling.testrunner.test.core.facade.dao.EventDAO;
import com.etantolling.testrunner.test.core.facade.dao.EventDefinitionDAO;
import com.etantolling.testrunner.test.core.facade.dao.FileRefDAO;
import com.etantolling.testrunner.test.core.facade.dao.FolderDAO;
import com.etantolling.testrunner.test.core.facade.dao.TestDAO;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class TestFacade {
	//private static final Logger logger = LoggerFactory.getLogger(TestFacade.class);

	public List<EventViewDTO> searchEvents(Integer testId) throws SQLException {
		return new EventDAO().search(testId);
	}

	public List<EventViewDTO> searchEvent(Integer eventId) throws SQLException {
		return new EventDAO().get(eventId);
	}
	
	public List<TestViewDTO> findAllTests() throws SQLException {
		return new TestDAO().loadView();
	}

	public Integer createEvent(EventDTO eventDTO) throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			
			return new EventDAO().createNewEvent(conn, eventDTO);
		} finally {
			DbUtils.close(conn);
		}
	}

	public List<FileRefDTO> searchEventFiles(Integer eventId) throws SQLException {
		return new FileRefDAO().search(eventId);
	}

	public String findFileUrl(Integer fileRefId) throws SQLException {
		return new FileRefDAO().findUrl(fileRefId);
	}

	public Map<String, Object> getEventDef(String tableName, String dataRecordPk) throws SQLException {
		return new EventDefinitionDAO().getEventDef(tableName, dataRecordPk);
	}

	public TestViewDTO findTest(Integer testId) throws SQLException {
		return new TestDAO().findView(testId);
	}
	
	public List<FolderDTO> showFolder() throws SQLException {
		return new FolderDAO().showFolder();
	}

	public List<HistoryDTO> getHystory(Integer testId) throws SQLException {
		return new TestDAO().getHystory(testId);
	}

	public HistoryDTO createHistory(HistoryDTO historyDTO) throws SQLException {
		return new TestDAO().createHistory(historyDTO);
		
	}
	
}
