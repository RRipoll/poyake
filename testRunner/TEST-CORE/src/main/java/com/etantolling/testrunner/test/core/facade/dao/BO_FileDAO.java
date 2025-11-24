package com.etantolling.testrunner.test.core.facade.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

import javax.activation.MimetypesFileTypeMap;

import org.apache.commons.io.FileUtils;

import com.etantolling.testrunner.test.core.appcontext.NasFolder;
import com.etantolling.testrunner.test.core.storage.azure.AzureAccounts;
import com.etantolling.testrunner.test.core.storage.azure.AzureFileUploader;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;
import com.etantolling.testrunner.test.utils.db.Sequence;
import com.microsoft.azure.storage.StorageException;

public class BO_FileDAO {

	Integer InputUserId=0;
	Integer InputSourceCode=0;
	
	
public Integer allocateFiles(Connection conn, String formName, LinkedHashMap<File, String> files) throws InvalidKeyException, FileNotFoundException, SQLException, URISyntaxException, StorageException, IOException{
		
		return allocateFiles(conn,formName,files,InputUserId,InputSourceCode);
	}

	
	public Integer allocateFiles(Connection conn, String formName, LinkedHashMap<File, String> files,Integer inputUserId,Integer inputSourceCode)
			throws SQLException, InvalidKeyException, FileNotFoundException, URISyntaxException, StorageException, IOException {
		Integer fileGroupId = getFileGroupId(conn);
		Hashtable<File, String> azurefiles = AzureFileUploader.storeInAzure(formName, files);
		int i = 0;
		for (File file : azurefiles.keySet()) {
			String urlAzure = AzureAccounts.buildURL(azurefiles.get(file));
			insertRecord(conn, fileGroupId, i++, urlAzure, file.getName(), new MimetypesFileTypeMap().getContentType(file),inputUserId,inputSourceCode);
		}
		return fileGroupId;
	}
	
	public Integer allocateFile(Connection conn, String formName, File file,Integer inputUserId,Integer inputSourceCode) throws Exception {
		LinkedHashMap<File,String> files = new LinkedHashMap<File,String>();
		files.put(file, file.getName());
		return this.allocateFiles(conn, formName, files, inputUserId, inputSourceCode);
	}

	public void insertRecord(Connection conn, int fileGroupId, int order, String url, String fileName, String mimeType,Integer inputUserId,Integer inputSourceCode)
			throws SQLException {
		Integer fileId = Sequence.nextForTable(conn, "BO_FILE");

		String sql = "INSERT INTO BO_FILE (FILEID, FILEGROUPID,FILEORDER, URL, FILENAME,MIMETYPE, INPUTSOURCECODE, INPUTUSERID,CREATED) "
				+ "VALUES (:FILEID, :FILEGROUPID,:FILEORDER, :URL, :FILENAME,:MIMETYPE, :INPUTSOURCECODE, :INPUTUSERID,GETPOSTINGDATETIME())";
		NamedParameterStatement pst = new NamedParameterStatement(conn, sql);
		pst.setInt("FILEGROUPID", fileGroupId);
		pst.setInt("FILEORDER", order);

		pst.setString("URL", url);
		pst.setString("FILENAME", fileName);
		pst.setString("MIMETYPE", mimeType);
		pst.setInt("INPUTSOURCECODE", inputSourceCode);
		pst.setInt("INPUTUSERID", inputUserId);
		pst.setInt("FILEID", fileId);

		pst.execute();
		pst.close();
	}

	public Integer getFileGroupId(Connection conn) throws SQLException {
		Integer fileGroupId = Sequence.nextForTable(conn, "BO_FILEGROUP");

		String sql = "INSERT INTO BO_FILEGROUP (FILEGROUPID) VALUES ( :FILEGROUPID)";
		NamedParameterStatement pst = new NamedParameterStatement(conn, sql);
		pst.setInt("FILEGROUPID", fileGroupId);
		pst.execute();
		pst.close();

		return fileGroupId;
	}
	
	public List<File> getFiles(List<Integer> fileGroupIds) throws SQLException, IOException{
		
		List<File> files= new ArrayList<File>();
		for (Integer fileGroupId : fileGroupIds) {
			files.addAll(getFiles(fileGroupId));
		}
		return files;
	}
	
	public Vector<File> getFiles(Integer fileGroupId) throws SQLException, IOException{
		
		Vector<File> retValue= new Vector<File>();
		
		String sqlFileGroupId="SELECT FILENAME, URL, MIMETYPE FROM BO_FILE WHERE FILEGROUPID=" + fileGroupId;
		
		try(Connection conn=MainDb.getConnection()){
		Statement stFG= conn.createStatement();
		ResultSet rsFG=stFG.executeQuery(sqlFileGroupId);
		File tmpFolder = NasFolder.TMP.getEnvironmentFolder();	
		while(rsFG.next()){
				File file= new File(tmpFolder,rsFG.getString("FILENAME"));
				String urlDb=rsFG.getString("URL");
				URL url= new URL(urlDb);
				FileUtils.copyURLToFile(url, file);
				retValue.add(file);
			}
		}
	return retValue;
	}
	
}
