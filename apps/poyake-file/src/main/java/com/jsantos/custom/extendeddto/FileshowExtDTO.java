package com.jsantos.custom.extendeddto;

import com.jsantos.custom.extendedFieldMapper.FileMapper;
import com.jsantos.metadata.MTFileData;
import com.jsantos.metadata.common.FileshowDTO;

public class FileshowExtDTO extends FileshowDTO{

	@Override
	public void insertOrUpdate() {
		new FileMapper().unloadValue(MTFileData.FILESHOW.FILEGROUPID, this);
	}

	@Override
	public void update() {
		new FileMapper().unloadValue(MTFileData.FILESHOW.FILEGROUPID, this);
	}

	@Override
	public FileshowDTO insert() {
		new FileMapper().unloadValue(MTFileData.FILESHOW.FILEGROUPID, this);
		return this;
	}

	
	
}
