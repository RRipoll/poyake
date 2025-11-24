package com.jsantos.custom.customfield;

import java.util.List;

import org.zkoss.zk.ui.WrongValueException;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.extendeddto.FileGroupExtDTO;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.metadata.MTFileData;
import com.jsantos.metadata.common.StorageFileDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;

public class FilesContainer extends FileGroupContainer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public MTField forField() {
	
		return null;// MTtestRunnerData.TESTEVENT.FILES;
	}

	@Override
	public void setDetachedRecord(IDetachedRecord  dRecord) {
		if(null!=dRecord && null!=dRecord.get(mtField)) {
			Object value=dRecord.get(mtField);
			FileGroupExtDTO fgDto= new FileGroupExtDTO();
			ListValues<StorageFileDTO> stValues= new ListValues<StorageFileDTO>();
			//for (Object element : ((ArrayList<Object>)value)) {
			ListValues<IDetachedRecord> mValues=MTHelper.convertMapToDetachRecord((List<Object>) value, MTFileData.STORAGEFILE);
			//}
			for (IDetachedRecord detachedRecord : mValues) {
				StorageFileDTO sdt=(StorageFileDTO) detachedRecord;
				stValues.add(sdt);
			}
			fgDto.setStorageFiles(stValues);
			fileGroupHandler.setFileGroupExtDTO((FileGroupExtDTO) fgDto);
		}else fileGroupHandler.setFileGroupExtDTO(new FileGroupExtDTO());
	}
	
	@Override
	public Object getValue()  {
		try {
			fileGroupHandler.allocateFiles(mtField.getName(), DesktopHelper.getInputUserId(), DesktopHelper.getInputSourceId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new WrongValueException(this, ErrorsConstants.FILE_ERROR);
		};
		if(null==fileGroupHandler.getFileGroupExtDTO().getStorageFiles()) return null;
		return fileGroupHandler.getFileGroupExtDTO().getStorageFiles();
	}

	@Override
	public MTDataType forModelType() {
		return null;
	}
}
