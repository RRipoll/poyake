package com.etantolling.testrunner.test.zkweb.filegroup;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedHashMap;

import org.apache.commons.io.IOUtils;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Vbox;

import com.etantolling.testrunner.test.core.appcontext.NasFolder;
import com.etantolling.testrunner.test.core.facade.dao.BO_FileDAO;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.microsoft.azure.storage.StorageException;

public class FileGroupHandler implements EventListener<Event> {
	Button uploadButton;
	Div uploadedFileList;
	LinkedHashMap<File, String> newFiles = new LinkedHashMap<File, String>();
	LinkedHashMap<File, String> previousFiles = new LinkedHashMap<File, String>();
	Hashtable<File, String> mimeTypes = new Hashtable<File, String>();
	File temporaryFolder;

	public FileGroupHandler(Button uploadButton, Div uploadedFileList) {
		initialize(uploadButton, uploadedFileList);
	}

	void initialize(Button uploadButton, Div uploadedFileList) {
		this.uploadButton = uploadButton;
		this.uploadedFileList = uploadedFileList;
		uploadButton.addEventListener(Events.ON_UPLOAD, this);
		// uploadButton.addEventListener(Events.ON_CLICK, this);
		temporaryFolder =  NasFolder.TMP.getEnvironmentFolder();//NasFolder.TMP.getFolder();
		temporaryFolder.mkdirs();
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if (uploadButton == event.getTarget()) {
			Media media = ((UploadEvent) event).getMedia();

			File file = new File(temporaryFolder, media.getName());
			if (null != media.getContentType())
				mimeTypes.put(file, media.getContentType());
			InputStream inputStream;
			try {
				inputStream = media.getStreamData();

			} catch (Exception e) {
				inputStream = new ByteArrayInputStream(media.getStringData().getBytes("UTF-8"));
			}
			OutputStream out = new FileOutputStream(file);
			IOUtils.copy(inputStream, out);
			inputStream.close();
			out.close();

			newFiles.put(file, media.getName());
			refreshUploadedFileList();
			Events.sendEvent("onUploadTmp", event.getTarget(), null);
		}
	}

	public Integer save(Connection conn, MTTable ownerTable)
			throws InvalidKeyException, FileNotFoundException, URISyntaxException, StorageException, IOException, SQLException {

		return save(conn, newFiles, ownerTable);

	}

	public static Integer save(Connection conn, LinkedHashMap<File, String> files, MTTable ownerTable)
			throws InvalidKeyException, FileNotFoundException, URISyntaxException, StorageException, IOException, SQLException {
		if (0 == files.size())
			return null;
		return new BO_FileDAO().allocateFiles(conn, ownerTable.getTableName().toLowerCase(), files);
	}

	void refreshUploadedFileList() {
		uploadedFileList.getChildren().clear();
		Vbox vbox = new Vbox();
		vbox.setParent(uploadedFileList);
		for (File file : newFiles.keySet()) {
			Label label = new Label(newFiles.get(file));
			label.setParent(vbox);
			label.setClass("uploadedfile");
		}

	}

}
