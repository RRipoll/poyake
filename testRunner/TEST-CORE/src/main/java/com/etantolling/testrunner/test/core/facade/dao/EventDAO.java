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
import com.etantolling.testrunner.test.core.dto.EventDTO;
import com.etantolling.testrunner.test.core.dto.EventViewDTO;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;
import com.etantolling.testrunner.test.utils.db.Sequence;

public class EventDAO {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<EventViewDTO> search(Integer testId) throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			String versionDate=EnvironmentHelper.getVersionDate();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT E.automaticDescription, E.deleted, E.eventDefinitionId, E.eventId, E.eventOrder, E.testId,");
			sql.append( " ED.EVENTNAME EVENTTYPE, MANUALDESCRIPTION DESCRIPTION,"
					+ " MANUALDESCRIPTION, e.PARAMETERS, "
					+ " stepid,"
					+ "ed.eventtypeid,E.eventId eventFileId");
			sql.append(" FROM EVENT E JOIN EVENTDEFINITION ED ON ED.EVENTDEFINITIONID=E.EVENTDEFINITIONID and E.DELETED = 0 ");
			sql.append(" join eventdeffolder edf on edf.eventdeffolderid=ed.folderid ");
			sql.append(" WHERE  e.TESTID = ? and e.startdate<"+versionDate+" and e.enddate>="+versionDate+"");
			sql.append( " and ed.startdate<"+versionDate+" and ed.enddate>="+versionDate+"");
			sql.append( " and edf.startdate<"+versionDate+" and edf.enddate>="+versionDate);
			sql.append(" ORDER BY E.EVENTORDER,");
			sql.append("E.EVENTID ");
			List<EventViewDTO> list = new QueryRunner().query(conn, sql.toString(),
					new BeanListHandler<EventViewDTO>(EventViewDTO.class), testId);
			return list;
		} finally {
			DbUtils.close(conn);
		}
	}
	
	
	public List<EventViewDTO> get(Integer eventId) throws SQLException {
		Connection conn = MainDb.getTestConnection();
		try {
			String versionDate=EnvironmentHelper.getVersionDate();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT E.automaticDescription, E.deleted, E.eventDefinitionId, E.eventId, E.eventOrder, E.testId,");
			sql.append( "ED.EVENTNAME EVENTTYPE, MANUALDESCRIPTION DESCRIPTION,"
					+ " MANUALDESCRIPTION, E.PARAMETERS, stepid,ed.eventtypeid,E.eventId eventFileId");
			sql.append(" FROM EVENT E JOIN EVENTDEFINITION ED ON ED.EVENTDEFINITIONID=E.EVENTDEFINITIONID ");
			sql.append(" join eventdeffolder edf on edf.eventdeffolderid=ed.folderid ");
			sql.append(" WHERE E.DELETED = 0 AND e.eventid = ? and e.startdate<"+versionDate+" and e.enddate>="+versionDate+"");
			sql.append( " and ed.startdate<"+versionDate+" and ed.enddate>="+versionDate+"");
			sql.append( " and edf.startdate<"+versionDate+" and edf.enddate>="+versionDate);
			sql.append(" ORDER BY ");
			sql.append("E.EVENTID");
			List<EventViewDTO> list = new QueryRunner().query(conn, sql.toString(),
					new BeanListHandler<EventViewDTO>(EventViewDTO.class), eventId);
			return list;
		} finally {
			DbUtils.close(conn);
		}
	}
	

	public Integer createNewEvent(Connection conn, EventDTO eventDTO) throws SQLException {
		eventDTO.setEventId(Sequence.nextForTable(conn, "event"));
		String sql = "insert into event (eventId, eventDefinitionId, testId, EVENTORDER"
				+ "manualDescription,parameters) "
				            + " values (:eventId, :eventDefinitionId, :testId,:EVENTORDER "
				            + ":manualDescription,:parameters)";
		try (NamedParameterStatement npst = new NamedParameterStatement(conn, sql);) {
			npst.setInt("eventId", eventDTO.getEventId());
			npst.setInt("eventDefinitionId", eventDTO.getEventDefinitionId());
			npst.setInt("testId", eventDTO.getTestId());
			npst.setInt("EVENTORDER", eventDTO.getEventOrder());
			npst.setString("manualDescription", eventDTO.getManualDescription());
			npst.setString("parameters", eventDTO.getParameters());
			
			npst.executeUpdate();
		}

		return eventDTO.getEventId();
	}

}
