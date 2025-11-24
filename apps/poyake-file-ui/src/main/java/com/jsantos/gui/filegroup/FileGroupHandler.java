package com.jsantos.gui.filegroup;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.activation.MimetypesFileTypeMap;

import org.apache.commons.io.IOUtils;
import org.zkoss.util.media.Media;
import org.zkoss.zhtml.Div;
import org.zkoss.zhtml.I;
import org.zkoss.zhtml.P;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.FileGroupExtDTO;
import com.jsantos.factory.appinfo.AppInfoFactory;
import com.jsantos.factory.appinfo.NasFolder;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.factory.file.FileFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.detail.DetailContainerProvider;
import com.jsantos.gui.form.DoNothingFormSerializer;
import com.jsantos.metadata.common.StorageFileDTO;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.search.AttributeConstants;

public class FileGroupHandler {

	Component uploadButton;
	Component uploadedFileList;

	LinkedHashMap<File, StorageFileDTO> newFiles = new LinkedHashMap<File, StorageFileDTO>();
	LinkedHashMap<File, Image> newImages = new LinkedHashMap<File, Image>();
	HashMap<File, String> mimeTypes = new HashMap<File, String>();

	File temporaryFolder;

	FileGroupExtDTO fileGroupExtDTO;
	private boolean readOnly;

	String searchName = "StorageFileTmp";
	private boolean isUpdated;

	public FileGroupHandler(Component uploadButton, Component uploadedFileList) throws Exception {
		initialize(uploadButton, uploadedFileList);
	}

	void initialize(Component uploadButton, Component uploadedFileList) throws Exception {
		this.uploadButton = uploadButton;
		this.uploadedFileList = uploadedFileList;
		uploadButton.addEventListener(Events.ON_UPLOAD, this::onUpload);

		temporaryFolder = new File(AppInfoFactory.getProvider().get(NasFolder.TMP,DesktopHelper.getInputUserGroupId()
						).toString()
						);
	}

	public void onUpload(Event event) throws Exception {
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

			StorageFileDTO storageFile = new StorageFileDTO();
			storageFile.setFileName(file.getName());
			storageFile.setMimeType(new MimetypesFileTypeMap().getContentType(file));
			storageFile.setOriginalFileName(file.getName());
			newFiles.put(file, storageFile);
			
			if (media.getContentType().contains("image")) {

				Image img = new Image();
				img.setContent((org.zkoss.image.Image) media);
				newImages.put(file, img);
				System.out.println(img.getSrc());
			}
			refreshUploadedFileList();
			Events.sendEvent(CustomEvents.ON_UPLOAD_TMP, event.getTarget(), null);
			//setUpdated(true);
		}
	}

	public void allocateFiles(String formName, Integer inputUserId, Integer inputSourceCode) throws Exception {
/*
		File folder = FileFactory.getProvider()
				.getEnvironmentFolder(AppInfoFactory.getProvider().get(NasFolder.DOCEXAMPLE//,DesktopHelper.getInputUserGroupId()
						).toString()//,DesktopHelper.getInputUserGroupId()
						);
*/
		for (File file : newFiles.keySet()) {
			StorageFileDTO storageFile = newFiles.get(file);
			if (null == storageFile.getLocation()) {
 
				String location = FileFactory.getProvider().storeFile(formName, file,DesktopHelper.getInputUserGroupId()
						);
				System.out.println(location);
				String url = FileFactory.getProvider().getURL(location,DesktopHelper.getInputUserGroupId()
						);
				System.out.println(url);
				storageFile.setLocation(url);

				storageFile.setFileGroupId(fileGroupExtDTO.getFileGroupId());
				if (null == fileGroupExtDTO.getStorageFiles())
					fileGroupExtDTO.setStorageFiles(new ListValues<StorageFileDTO>());
				fileGroupExtDTO.getStorageFiles().add(storageFile);
				fileGroupExtDTO = fileGroupExtDTO.getACopy();
			}
		}
	}

	void refreshUploadedFileList() throws MalformedURLException {
		uploadedFileList.getChildren().clear();
		for (File file : newFiles.keySet()) {
			StorageFileDTO stf = newFiles.get(file);
			if (null != stf && null != stf.getEndDate() && stf.getEndDate().before(new Date()))
				continue;
			Div card = new Div();
			card.setSclass("card");
			card.setParent(uploadedFileList);

			Div card_body = new Div();
			card_body.setSclass("card-body");
			card_body.setParent(card);

			String mediaType = mimeTypes.get(file);
			if (null != mediaType && mediaType.contains("image")) {
				Image img = newImages.get(file);
				org.zkoss.image.AImage aimg;
				try {
					aimg = new org.zkoss.image.AImage(file.getPath());
					img.setContent(aimg);
				} catch (IOException e) {
					// e.printStackTrace();
				}

				img.setParent(card);
				img.setSclass("card-img-top");
				img.setAttribute(AttributeConstants.DATA, file);
				img.addEventListener(Events.ON_CLICK, this::showFile);
			} else {
				Label label = new Label(file.getName());
				label.setParent(card);
				label.setClass("btn btn-lg btn-bd-primary");
				label.setAttribute(AttributeConstants.DATA, file);
				label.addEventListener(Events.ON_CLICK, this::showFile);
			}
			if (!readOnly) {
				I remove = new I();
				remove.setParent(card_body);
				remove.setSclass("material-icons");
				new Text("delete").setParent(remove);
				remove.addEventListener(Events.ON_CLICK, this::removeFile);
				remove.setAttribute(AttributeConstants.DATA, file);
				remove.setStyle("cursor:pointer");
				I detail = new I();
				detail.setParent(card_body);
				detail.setSclass("material-icons");
				new Text("description").setParent(detail);
				detail.addEventListener(Events.ON_CLICK, this::detailFile);
				detail.setAttribute(AttributeConstants.DATA, file);
				detail.setStyle("cursor:pointer");
			}
			P p = new P();
			p.setSclass("card-text");
			p.setParent(card_body);
			new Text(stf.getFileName()).setParent(p);
			;
		}
	}

	void removeFile(Event event) throws MalformedURLException {
		File file = (File) event.getTarget().getAttribute(AttributeConstants.DATA);
		StorageFileDTO stf = newFiles.get(file);
		if (null != stf && null != stf.getPk()) {
			stf.setEndDate(new Date());
		} else
			newFiles.remove(file);
		fileGroupExtDTO = fileGroupExtDTO.getACopy();
		refreshUploadedFileList();
		setUpdated(true);
	}

	void detailFile(Event event) throws MalformedURLException {
		File file = (File) event.getTarget().getAttribute(AttributeConstants.DATA);
		StorageFileDTO stf = newFiles.get(file);

		IDetailContainer container = DetailContainerProvider.getDetailContainer(stf.getTable());
		if (null != stf && null != stf.getPk())
			container.setDetachedRecord(stf);
		else
			container.setInitialParameters(MTHelper.getValues(stf.getCopyValues()));
		if (DataSettingFactory.getProvider().isImplemented())
			container.setSearchName(searchName);
		else
			container.setSearchName("StorageFile");
		container.setParent(DesktopHelper.getRootComponent());
		container.setDetachedRecord(stf);
		container.setFormSerialize(new DoNothingFormSerializer());
		container.buildAndShowComponent(EditMode.AUTO);
		refreshUploadedFileList();
	}

	void showFile(Event event) throws Exception {
		FileUIUtil.ShowFile((File) event.getTarget().getAttribute(AttributeConstants.DATA));
	}

	public Component getUploadButton() {
		return uploadButton;
	}

	public void setReadonly(boolean readOnly) {
		this.readOnly = readOnly;
		if (readOnly) {
			uploadButton.setVisible(!readOnly);
		}
	}

	public FileGroupExtDTO getFileGroupExtDTO() {
		return fileGroupExtDTO;
	}

	public void setFileGroupExtDTO(FileGroupExtDTO fileGroupExtDTO) {
		this.fileGroupExtDTO = fileGroupExtDTO;
		if (null != fileGroupExtDTO.getStorageFiles())
			for (StorageFileDTO storage : fileGroupExtDTO.getStorageFiles()) {
				try {
					File file = new File(storage.getLocation());
					newFiles.put(file, storage);
					String mimeType = URLConnection.guessContentTypeFromName(file.getName());
					if (null != mimeType && mimeType.contains("image")) {
						newImages.put(file, new Image(storage.getLocation()));
					}
					mimeTypes.put(file, mimeType);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		if (null != uploadedFileList)
			try {
				refreshUploadedFileList();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	}

	public boolean isUpdated() {
		return isUpdated;
	}

	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
		if (isUpdated)
			Events.sendEvent(CustomEvents.ON_ISUPDATED, uploadedFileList, null);
	}

	public void setUpdated(Event isUpdated) {
		setUpdated(true);
	}
}
