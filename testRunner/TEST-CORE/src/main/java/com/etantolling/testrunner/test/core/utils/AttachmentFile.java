package com.etantolling.testrunner.test.core.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class AttachmentFile
{
	
	private static final Logger log = LoggerFactory.getLogger(AttachmentFile.class);
	
	String url;
	String fileName;
	String mimeType;
	


	public AttachmentFile(ResultSet rs) throws SQLException {
		url=rs.getString("URL");
		fileName=rs.getString("FileName");
		mimeType=rs.getString("mimeType");

	}



	static public Vector<AttachmentFile> getFiles(Integer fileGroupID) throws SQLException{
		
		if(null==fileGroupID)return null;
		
		Vector<AttachmentFile> retValue= new Vector<AttachmentFile>();
		
		String sql="select * from BO_File where FileGroupID="+fileGroupID;
		try (Connection conn = MainDb.getConnection()){
			Statement st=conn.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while (rs.next()){
				AttachmentFile attachmentFile= new AttachmentFile(rs);
				retValue.add(attachmentFile);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("ERROR STACKTRACE: ", e);
		}
		if(retValue.size()==0)return null;		
		return retValue;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getMimeType() {
		return mimeType;
	}



	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
}
