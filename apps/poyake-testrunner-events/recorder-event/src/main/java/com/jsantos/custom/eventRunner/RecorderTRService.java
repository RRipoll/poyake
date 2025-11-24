package com.jsantos.custom.eventRunner;

import java.io.File;
import java.util.List;

import com.jsantos.common.util.FileDownload;
import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.RecordProcess;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.StoreValuesTestExtDTO;
import com.jsantos.gui.detail.DefaultDetailContainer;
import com.jsantos.metadata.MTrecorderTRData;
import com.jsantos.metadata.common.FileGroupDTO;
import com.jsantos.metadata.common.StorageFileDTO;
import com.jsantos.metadata.testrunner.EventStatus;
import com.jsantos.metadata.testrunner.RecorderDefinitionDTO;
import com.jsantos.metadata.testrunner.StoreValuesEventDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.runningTest.SystemOut;
import com.jsantos.service.ITestEventRunner;

public class RecorderTRService implements ITestEventRunner {

	// private static final Logger logger =
	// LoggerFactory.getLogger(RecorderTRService.class);

	@Override
	public StoreValuesTestExtDTO runEvent(IDetachedRecord event, StoreValuesTestExtDTO storeValues) throws Exception {
		StoreValuesEventDTO svm = new StoreValuesEventDTO();
		svm.setEvent(event);
		svm.setEventName(((RecorderDefinitionDTO) event).getEventName());
		svm.setStatus(EventStatus.PROCESSING);
		File systemfile = SystemOut.setSystemOutToFile();
		if (null != systemfile)
			svm.setLog(systemfile.getAbsolutePath());

		storeValues.addStoreValuesEvent(svm);
		try {

			ListValues<StorageFileDTO> files = (ListValues<StorageFileDTO>) ((RecorderDefinitionDTO) event).getFiles();
			for (StorageFileDTO stFile : files) {

				String path = "http://localhost:8081/rest/api/file/" + stFile.getStorageFileId() + "/download";
				FileDownload.downloadUrl(path, "file");
				File file = new File("file");

				RecordProcess.process(file);

				try {
					showSummary(null, files, null, null, null);
				} catch (Exception ee) {
				}
			}

			showSummary(null, files, null, null, null);

		} catch (Exception e) {
			svm.setStatus(EventStatus.ERROR);
			e.printStackTrace();
			SystemOut.closeFileSystemLog(systemfile);
			throw new Exception(((RecorderDefinitionDTO) event).getEventName() + ": " + e.getMessage(), e);
		}

		SystemOut.closeFileSystemLog(systemfile);
		svm.setStatus(EventStatus.DONE);
		return storeValues;
	}

	@Override
	public void showStarting(String url, Object parameters, String json) {
		System.out
				.println("*** ------------------------------------------ --------------------------------------- ***");
		System.out.println("*** -------------------------- EVENT RECORD SERVICE START --------------- ***");
		System.out
				.println("*** ---------------------------------- ----------------------------------------------- ***");
		System.out.println("*** parameters " + parameters);
		System.out.println("*** JSON " + json);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Override
	public void showSummary(String url, Object parameters, String json, String responseCode, String responseBody) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("*** Response = " + responseBody);

		System.out
				.println("*** ---------------------------------------------------------------------------------- ***");
		System.out.println("*** -----------------------------EVENT RECORD SERVICE END -------------- ***");
		System.out
				.println("*** ---------------------------------------------------------------------------------- ***");
	}

	@Override
	public String forEventType() {
		return "RECORDER";
	}

	@Override
	public IDetailContainer getDetailContainer() {
		DefaultDetailContainer detail = new DefaultDetailContainer();
		// detail.setSearchName(forEventType());
		return detail;
	}

	@Override
	public MTTable getMTTable() {

		return MTrecorderTRData.RECORDERDEFINITION;
	}

	@Override
	public IDetachedRecord mapper(IDetachedRecord dr) {
		List<StorageFileDTO> files = (List<StorageFileDTO>) ((RecorderDefinitionDTO) dr).getFiles();
		Object fileGroupId = null;
		for (StorageFileDTO storageFileDTO : files) {
			if (null != storageFileDTO.getStorageFileId())
				continue;
			if (null == storageFileDTO.getFileGroupId()) {
				if (null == fileGroupId)
					fileGroupId = new FileGroupDTO().insert().getPk();
				storageFileDTO.setFileGroupId((Integer) fileGroupId);
			}
			storageFileDTO.insertOrUpdate();
		}
		return dr;
	}

}
