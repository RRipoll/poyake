package com.etantolling.testrunner.test.core.dto;

public class FolderDTO {
	private Integer folderId;
	protected String folderPath;
	public Integer getFolderId() {
		return folderId;
	}
	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}
	public String getFolderPath() {
		return folderPath;
	}
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
}
