package com.jsantos.custom.extendeddto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsantos.common.util.MapValues;
import com.jsantos.metadata.MTFileData;
import com.jsantos.metadata.common.FileGroupDTO;
import com.jsantos.metadata.common.StorageFileDTO;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.mt.MTField;

public class FileGroupExtDTO extends FileGroupDTO{

	List<StorageFileDTO> storageFiles;
	
	public FileGroupExtDTO(Integer pk) {
		super(pk);
		if (null != getPk()) {
			DetachedQueryResult drr = new DetachedQueryResult(MTFileData.STORAGEFILE,
					new MapValues<Object>().add(MTFileData.STORAGEFILE.FILEGROUPID.getName(), getPk()));
			storageFiles = drr.getPage(null, StorageFileDTO.class).getRawData();
			}
		}

	public FileGroupExtDTO() {
		super();
	}

	public List<StorageFileDTO> getStorageFiles() {
		return storageFiles;
	}

	public void setStorageFiles(List<StorageFileDTO> storageFiles) {
		this.storageFiles = storageFiles;
	}
	
    @JsonIgnore
	public FileGroupExtDTO getACopy() {
		
		FileGroupExtDTO copy= new FileGroupExtDTO();
		copy.originalValues=originalValues;
		for (MTField field : getFields()) {
			copy.set(field, get(field));
		}
		copy.setStorageFiles(storageFiles);
		return copy;
		
	}



}
