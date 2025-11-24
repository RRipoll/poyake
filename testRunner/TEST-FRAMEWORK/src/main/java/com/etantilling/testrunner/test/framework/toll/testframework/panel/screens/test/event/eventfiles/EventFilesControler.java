package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event.eventfiles;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Space;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.storage.azure.AzureAccounts;
import com.etantolling.testrunner.test.core.storage.azure.AzureFileUploader;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.microsoft.azure.storage.StorageException;


public class EventFilesControler implements EventListener<Event>{
	EventFilesView view;
	Vector<File> newFiles = new Vector<File>();
	Integer eventId;
	
	public EventFilesControler(Integer eventId) throws SQLException{
		this.eventId = eventId;
		view = new EventFilesView();
		view.uploadButton.addEventListener(Events.ON_UPLOAD, this);
		loadExistingImages();
	}

	@SuppressWarnings("static-access")
	public void saveNewImages(Connection conn, Integer eventId, Integer testId) throws IOException, SQLException, InvalidKeyException, URISyntaxException, StorageException{
		
		Hashtable<File, String> azureFiles=AzureFileUploader.storeInAzure("TESTRUNNER", newFiles);
		
		for (File file:azureFiles.keySet()){
			//File finalFilePath = new File("/nasshare/tests/test_" + testId + "/event_" + eventId + "/" + file.getName());
			DetachedRecord drFileRef = new DetachedRecord(MT.FILEREF);
			drFileRef.set(MT.FILEREF.FOLDERID, 1); //root folder for now
			drFileRef.set(MT.FILEREF.NAME, file.getName());
			
			//AzureFileUploader.storeInAzure("TESTRUNNER", file);
			
			
			drFileRef.set(MT.FILEREF.AZUREURL, AzureAccounts.buildURL(azureFiles.get(file)));
			drFileRef.set(MT.FILEREF.DELETED, 0);
			drFileRef.set(MT.FILEREF.FILETYPEID, 0); // unknown
			drFileRef.save(conn);
			DetachedRecord drEventFile = new DetachedRecord(MT.EVENTFILE);
			drEventFile.set(MT.EVENTFILE.FILEREFID, drFileRef.getPk());
			drEventFile.set(MT.EVENTFILE.EVENTID, eventId);
			drEventFile.save(conn);
			
//			finalFilePath.getParentFile().mkdirs();
	//		file.renameTo(finalFilePath);
		}
	}
	
	public EventFilesView getView() {
		return view;
	}

	public void loadExistingImages() throws SQLException{
		Connection conn = MainDb.getConnection();
		try{
			String versionDate=EnvironmentHelper.getVersionDate();
			Statement st = conn.createStatement();
			String sql = "select ef.filerefid, name, azureurl, eventfileid from fileref fr join eventfile ef on ef.startdate<="+versionDate+" and ef.enddate>="+versionDate+" and fr.filerefid=ef.filerefid and eventid=" + eventId;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
		        Div newFileDiv = new Div();
		        newFileDiv.setParent(view.existingFileListDiv);
		        Button deleteFileButton = new Button();
		        deleteFileButton.setAttribute("FILEREFID", rs.getInt("filerefid"));
		        deleteFileButton.setAttribute("NAME", rs.getString("name"));
		        deleteFileButton.setAttribute("AZUREURL", rs.getString("azureurl"));
		        deleteFileButton.setAttribute("EVENTFILEID", rs.getInt("eventfileid"));
		        deleteFileButton.addEventListener(Events.ON_CLICK, this);
		        deleteFileButton.setLabel("X");
		        new Space().setParent(newFileDiv);
		        deleteFileButton.setParent(newFileDiv);
		        Label newFileLabel = new Label();
		        newFileLabel.setValue(rs.getString("name"));
		        newFileLabel.setParent(newFileDiv);				
			}
			rs.close();
			st.close();
		}
		finally{
			conn.close();
		}
	}
	
	
	
	
	
	
	@Override
	public void onEvent(Event event) throws Exception {
		if (null != event.getTarget().getAttribute("FILEREFID")){
			File file = new File ((String)event.getTarget().getAttribute("AZUREURL"));
			//mkFileBackupCopy(file);
			file.delete();
			event.getTarget().getParent().detach();
			deleteFileRef((Integer)event.getTarget().getAttribute("FILEREFID"), (Integer)event.getTarget().getAttribute("EVENTFILEID"));
		}
		if (null != event.getTarget().getAttribute("FILE")){
			File file = (File)event.getTarget().getAttribute("FILE");
			//mkFileBackupCopy(file);
			file.delete();
			newFiles.remove(file);
			event.getTarget().getParent().detach();
		}
		if (view.uploadButton == event.getTarget() ){
			Media media = ((UploadEvent)event).getMedia();
			
			File folder = new File("/nasshare/tests/tmp");
			folder.mkdirs();
			File file = new File(folder, media.getName());
			InputStream inputStream;
			try{
	        	 inputStream= media.getStreamData();
			}catch (Exception e){
				inputStream=new ByteArrayInputStream(media.getStringData().getBytes("UTF-8"));
			}
	        OutputStream out=new FileOutputStream(file);
	        IOUtils.copy(inputStream, out);
	        inputStream.close();
	        out.close();
	        newFiles.add(file);
	        
	        Div newFileDiv = new Div();
	        newFileDiv.setParent(view.newFileListDiv);
	        Button deleteFileButton = new Button();
	        deleteFileButton.setAttribute("FILE", file);
	        deleteFileButton.addEventListener(Events.ON_CLICK, this);
	        deleteFileButton.setLabel("X");
	        new Space().setParent(newFileDiv);
	        deleteFileButton.setParent(newFileDiv);
	        Label newFileLabel = new Label();
	        newFileLabel.setValue(media.getName());
	        newFileLabel.setParent(newFileDiv);
		}
	}
	
	static void mkFileBackupCopy(File file) throws IOException{
		String sDate = new SimpleDateFormat("ddddMMMyyyy_HHmmss").format(new Date());
		File fileBackup = new File(file.getParentFile(), file.getName() + ".backup" + sDate);
		FileUtils.copyFile(file, fileBackup);
		
	}
	
	public void deleteFileRef(Integer fileRefId, Integer eventFileId) throws SQLException{
		Connection conn = MainDb.getConnection();
		try{
			Statement st = conn.createStatement();
			st.executeUpdate("update eventfile set enddate="+EnvironmentHelper.getVersionDate()+" where eventFileId=" + eventFileId);
			//st.executeUpdate("delete from eventfile where eventFileId=" + eventFileId);
			//st.executeUpdate("delete from fileref where filerefid=" + fileRefId);
		}
		finally{
			conn.close();
		}
	}
}
