package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.DBUtils;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;
import com.etantolling.testrunner.test.utils.db.Sequence;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.MTListScreenControler;

public class TestDuplicator {
	
	private static final Logger log = LoggerFactory.getLogger(TestDuplicator.class);
	
	public static Integer duplicateTest(Integer testId) throws SQLException {
		Connection conn = MainDb.getConnection();
		conn.setAutoCommit(false);
		Integer testIdCopy=null;
		try{

			testIdCopy= duplicateTest(conn, testId);

			duplicateEvents(conn,testId,testIdCopy);
			conn.commit();	
		} catch (SQLException | IOException e) {
			conn.rollback();
			log.error("ERROR STACKTRACE:",e);
		}
		finally{
			conn.commit();
			conn.close();
		}
		return testIdCopy;
	}

	public static Integer copyEvent(Integer eventId, Integer targetTestId) throws SQLException, IOException{
		String sql = "SELECT testId FROM EVENT e join eventdefinition ed "
				+ "on e.startdate<="+EnvironmentHelper.getVersionDate()+" and e.enddate>="+EnvironmentHelper.getVersionDate()+" and ed.startdate<="+EnvironmentHelper.getVersionDate()+" and ed.enddate>="+EnvironmentHelper.getVersionDate()+" and e.eventdefinitionid=ed.eventdefinitionid and ed.deleted=0 WHERE e.DELETED=0 and eventId=:eventId";

		try(Connection conn = MainDb.getConnection();NamedParameterStatement nps = new NamedParameterStatement(conn, sql);){
			nps.setInt("eventId", eventId);
			ResultSet rs = nps.executeQuery();
			if (rs.next()){
				return duplicateEvent(conn, eventId, rs.getInt("testId"), targetTestId,true);
			}
		}
		return null;
	}
	
	static Integer duplicateTest(Connection conn, Integer testId) throws SQLException{

		conn.setAutoCommit(false);
		Integer testIdCopy = Sequence.nextForTable(conn, MT.TEST.toString());

		String sqlTest=" INSERT INTO TEST "
				+ " (TESTID,OWNER,FOLDERID,TESTNAME,DESCRIPTION,NOTES,CREATED,DELETED,STARTDATE,ENDDATE,REGRESSIONTEST,RUNNIGHTLYSCRIPTS,KEYWORDS) "
				+ " SELECT "
				+ "		:TESTIDCOPY,OWNER,FOLDERID,TESTNAME  "+DBUtils.getStringUnion(conn)+" '(COPY FROM "+testId+")',DESCRIPTION,NOTES,CREATED,DELETED,STARTDATE,ENDDATE,REGRESSIONTEST,RUNNIGHTLYSCRIPTS,KEYWORDS "
				+ " FROM TEST "
				+ " WHERE  startdate<="+EnvironmentHelper.getVersionDate()+" and enddate>="+EnvironmentHelper.getVersionDate()+" and TESTID=:TESTID ";

		NamedParameterStatement npst= new NamedParameterStatement(conn, sqlTest);
		npst.setInt("TESTIDCOPY", testIdCopy);
		npst.setInt("TESTID", testId);
		npst.execute();
		npst.close();
		return testIdCopy;
	}


	static void duplicateEvents(Connection conn, Integer testId, Integer testIdCopy) throws SQLException, IOException{

		String sqlEventN=" SELECT eventid"
				+" FROM EVENT e "
				+" WHERE e.startdate<="+EnvironmentHelper.getVersionDate()+" and e.enddate>="+EnvironmentHelper.getVersionDate()+" and e.DELETED=0 AND  TESTID=:TESTID order by e.eventorder";

		NamedParameterStatement npste= new NamedParameterStatement(conn, sqlEventN);
		npste.setInt("TESTID", testId);
		ResultSet rse= npste.executeQuery();
		while (rse.next()){
			Integer eventId=rse.getInt("EVENTID");
			duplicateEvent(conn, eventId, testId, testIdCopy,false);
		}
		npste.close();
	}

	static Integer duplicateEvent(Connection conn, Integer eventId, Integer testId, Integer testIdCopy,boolean setAtTheEnd) throws SQLException, IOException{
		Integer eventIdCopy=Sequence.nextForTable(conn, "EVENT");
		String sqlEvent= " INSERT INTO EVENT "
				+ " (EVENTID,EVENTDEFINITIONID,TESTID,POSTINGDATE,EVENTORDER,AUTOMATICDESCRIPTION,MANUALDESCRIPTION,DELETED,PARAMETERS) "
				+ " SELECT  "
				+ "		:COPYEVENTID,EVENTDEFINITIONID,:TESTIDCOPY,POSTINGDATE,:COPYEVENTID,AUTOMATICDESCRIPTION,MANUALDESCRIPTION,DELETED,PARAMETERS "
				+ " FROM EVENT "
				+ " WHERE startdate<="+EnvironmentHelper.getVersionDate()+" and enddate>="+EnvironmentHelper.getVersionDate()+" and EVENTID=:EVENTID and deleted=0 ";

		NamedParameterStatement npsti= new NamedParameterStatement(conn, sqlEvent);
		npsti.setInt("COPYEVENTID", eventIdCopy);
		npsti.setInt("TESTIDCOPY", testIdCopy);
		npsti.setInt("EVENTID", eventId);
		npsti.execute();
		npsti.close();
		if(setAtTheEnd)
			MTListScreenControler.changeOrder(eventIdCopy, eventIdCopy*100);
		
		duplicateFiles(conn, eventId, eventIdCopy, testId, testIdCopy);
		return eventIdCopy;
	}

	static void duplicateFiles(Connection conn, Integer eventId, Integer eventIdCopy,Integer testId, Integer testIdCopy) throws SQLException, IOException{

		String sqlEventFileN= " SELECT EVENTFILEID,EF.FILEREFID,AZUREURL "
				+ " FROM EVENTFILE EF JOIN FILEREF F ON F.FILEREFID=EF.FILEREFID and f.deleted=0"
				+ " WHERE  ef.startdate<="+EnvironmentHelper.getVersionDate()+" and ef.enddate>="+EnvironmentHelper.getVersionDate()+" and  EVENTID= :EVENTID ";

		NamedParameterStatement npstf= new NamedParameterStatement(conn, sqlEventFileN);
		npstf.setInt("EVENTID", eventId);
		ResultSet rsf= npstf.executeQuery();
        
		while (rsf.next()){
			Integer fileRefId= rsf.getInt("FILEREFID");
			String azureurl=rsf.getString("azureurl");
			/*
			String a1=azureurl.substring(0,azureurl.indexOf("test_") );
			String a2=azureurl.substring(azureurl.indexOf("event_"));
			String a3=a2.substring(a2.indexOf("/"));
*/
			//String newAzureurl= a1+"test_"+testIdCopy+"/event_"+eventIdCopy+a3;
/*
			try{
				File newFile=new File(newAzureurl);
				new File(newFile.getParent()).mkdirs();
				FileUtils.copyFile(new File(azureurl),newFile );
			}catch (Exception e) {
				log.error("ERROR STACKTRACE:",e);
				newAzureurl=azureurl;	
			}
*/
			Integer eventfileid= rsf.getInt("EVENTFILEID");
			Integer eventIdFileCopy=Sequence.nextForTable(conn, "EVENTFILE");

			String sqlEventFileRef=  " INSERT INTO FILEREF "
					+ " 		(FILETYPEID,FOLDERID,AZUREURL,NAME,DESCRIPTION,DELETED,MIMETYPE) "
					+ " SELECT  "
					+ "		FILETYPEID,FOLDERID,:NEWAZUREURL,NAME,DESCRIPTION,DELETED,MIMETYPE "
					+ " FROM FILEREF "
					+ " WHERE FILEREFID=:FILEREFID and deleted=0";
			
			NamedParameterStatement npstefR= new NamedParameterStatement(conn, sqlEventFileRef, Statement.RETURN_GENERATED_KEYS);
			//npstefR.setInt("FILEREFIDCOPY", fileRefIdCopy);
			npstefR.setInt("FILEREFID", fileRefId);
			npstefR.setString("NEWAZUREURL", azureurl);

			npstefR.execute();
			
			ResultSet rs = npstefR.getGeneratedKeys();
			rs.next();
			Integer fileRefIdCopy=rs.getInt(1);
			rs.close();
			
			npstefR.close();
			String sqlEventFile= " INSERT INTO EVENTFILE "
					+" 		(EVENTFILEID,EVENTID,FILEREFID) "
					+ " SELECT  "
					+ "		:COPYEVENTFILEID,:COPYEVENTID,:COPYFILEREFID "
					+ " FROM EVENTFILE "
					+ " WHERE startdate<="+EnvironmentHelper.getVersionDate()+" and enddate>="+EnvironmentHelper.getVersionDate()+" and  EVENTFILEID= :EVENTFILEID ";

			NamedParameterStatement npstef= new NamedParameterStatement(conn, sqlEventFile);
			npstef.setInt("COPYEVENTFILEID", eventIdFileCopy);
			npstef.setInt("COPYEVENTID", eventIdCopy);
			npstef.setInt("COPYFILEREFID", fileRefIdCopy);
			npstef.setInt("EVENTFILEID", eventfileid);

			npstef.execute();
			npstef.close();
		}
		npstf.close();
	}
}