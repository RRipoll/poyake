package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.files;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Button;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;

public class FileRefEditControler extends MTEditScreenControler{
	
	private static final Logger log = LoggerFactory.getLogger(FileRefEditControler.class);
	
	Button uploadButton = new Button();
	File uploadedFile = null;

	public FileRefEditControler(Integer pk) {
		super(pk, MT.FILEREF, null);
	}

	
	
	@Override
	public void buildForm(Component parent) throws WrongValueException, SQLException {
		super.buildForm(parent);
		uploadButton.setLabel("Upload File");
		uploadButton.setParent(this.view.window);
		uploadButton.addEventListener(Events.ON_UPLOAD, this);
		uploadButton.setUpload("true");
	}



	@SuppressWarnings("static-access")
	@Override
	public void save() throws SQLException {
		Connection conn=MainDb.getConnection();
		wireFields();
		try {
			view.dr.set(MT.FILEREF.AZUREURL, uploadedFile.getCanonicalPath());
		} catch (IOException e) {
			log.error("ERROR STACKTRACE:",e);
		}
		view.dr.save(conn);
		saveExtraObjects(conn);
		conn.close();
		view.window.detach();

	}



	@Override
	public void onEvent(Event event) throws Exception{
		super.onEvent(event);
		if (uploadButton == event.getTarget() ){
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
	        uploadedFile = file;
		}
	}

}
