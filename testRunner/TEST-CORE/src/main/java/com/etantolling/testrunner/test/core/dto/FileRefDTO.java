package com.etantolling.testrunner.test.core.dto;

public class FileRefDTO {
	private String azureUrl;
	private Integer deleted;
	private String description;
	private Integer filerefid;
	private Integer filetypeid;
	private Integer folderid;
	private String mimeType;
	private String name;

	public String getAzureUrl() {
		return azureUrl;
	}

	public void setAzureUrl(String azureUrl) {
		this.azureUrl = azureUrl;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFilerefid() {
		return filerefid;
	}

	public void setFilerefid(Integer filerefid) {
		this.filerefid = filerefid;
	}

	public Integer getFiletypeid() {
		return filetypeid;
	}

	public void setFiletypeid(Integer filetypeid) {
		this.filetypeid = filetypeid;
	}

	public Integer getFolderid() {
		return folderid;
	}

	public void setFolderid(Integer folderid) {
		this.folderid = folderid;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FileRefDTO [azureUrl=" + azureUrl + ", deleted=" + deleted + ", description=" + description + ", filerefid=" + filerefid + ", filetypeid=" + filetypeid + ", folderid=" + folderid
				+ ", mimeType=" + mimeType + ", name=" + name + "]";
	}
}
