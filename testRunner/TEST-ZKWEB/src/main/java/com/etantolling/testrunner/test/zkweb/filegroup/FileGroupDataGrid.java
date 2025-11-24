package com.etantolling.testrunner.test.zkweb.filegroup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Executions;

import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataGridModel;
import com.etantolling.testrunner.test.zkweb.datagrid3.RenderedObjects.DataTableNH;

@SuppressWarnings("serial")
public class FileGroupDataGrid extends DataTableNH{
	
	private static final Logger log = LoggerFactory.getLogger(FileGroupDataGrid.class);
	
	public FileGroupDataGrid(Integer fileGroupId) throws SQLException{
		super(new DataGridModel("SELECT FILENAME, URL, MIMETYPE FROM BO_FILE WHERE FILEGROUPID=" + fileGroupId), null, new FileGroupDataGridRowAdapter(), null, null);
		initialize();
	}

	public FileGroupDataGrid(MTTable ownerTable, Integer pk) throws SQLException{
		super(new DataGridModel("SELECT FILENAME, URL FROM BO_FILE FR JOIN FILEGROUP FG ON FG.FILEGROUPID=FR.FILEGROUPID AND FG.OWNERTABLENAME='" + ownerTable.getTableName() + "' and fg.OwnerTablePk=" + pk), null, new FileGroupDataGridRowAdapter(), null, "showcaselist");
		initialize();
	}
	
	void initialize() throws SQLException{
		setSelectorType(DataTableNH.SELECTOR_NONE);
		getDgModel().dgQuery.setOrderByField("FILENAME", true);
		getDgModel().getHiddenColumns().clear();
		getDgModel().getHiddenColumns().add("URL");
		getDgModel().getHiddenColumns().add("MIMETYPE");
		render();
		
	}
	
	
	static public void showFileByComm(Integer communicationId) throws SQLException{
		
		String sqlFileGroupId="SELECT FILENAME, URL, MIMETYPE FROM BO_FILE WHERE FILEGROUPID in "
				+ " (select filegroupid from bo_letter where communicationId="+communicationId+" union all "
						+ "select filegroupid from bo_letter where communicationId="+communicationId+")" ; 
		
		try(Connection conn=MainDb.getConnection()){
		Statement stFG= conn.createStatement();
		ResultSet rsFG=stFG.executeQuery(sqlFileGroupId);
		if(rsFG.next()){
		
			String urlDb=rsFG.getString("URL");
			//String mimetype=rsFG.getString("MIMETYPE");
			
			//if(mimetype.toUpperCase().contains("PDF") || mimetype.toUpperCase().contains("IMAGE") || mimetype.toUpperCase().contains("TEXT"))
				Executions.getCurrent().sendRedirect(urlDb, "_blank");
				//Clients.evalJavaScript("window.open(\""+urlDb+"\",\"_blank\")");
			//else 
				//Executions.getCurrent().sendRedirect(urlDb);
		}
		}catch(Exception e){
			log.error("ERROR STACKTRACE: ", e);
			//ApplicationLog.reportException(null, null, null, e);
			throw e;
		}
	}
	
	static public void showFile(Integer fileGroupId) throws SQLException{
		
		
		try(Connection conn=MainDb.getConnection()){
			showFile(conn,fileGroupId);
		}catch(Exception e){
			log.error("ERROR STACKTRACE: ", e);
			//ApplicationLog.reportException(null, null, null, e);
			throw e;
		}
	}
	
	static public void showFile(Connection conn,Integer fileGroupId) throws SQLException{
		
		String sqlFileGroupId="SELECT FILENAME, URL, MIMETYPE FROM BO_FILE WHERE FILEGROUPID=" + fileGroupId;
		
		Statement stFG= conn.createStatement();
		ResultSet rsFG=stFG.executeQuery(sqlFileGroupId);
		if(rsFG.next()){
			String urlDb=rsFG.getString("URL");
			Executions.getCurrent().sendRedirect(urlDb, "_blank");
		}
	}
}