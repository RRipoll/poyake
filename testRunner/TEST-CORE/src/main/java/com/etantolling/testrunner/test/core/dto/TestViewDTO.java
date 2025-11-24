package com.etantolling.testrunner.test.core.dto;

public class TestViewDTO {
	private Integer testId;
	protected String owner;
	// folderId is a String got from calculated fields
	protected Integer folderId;
	protected String folder;
	protected String testName;
	private String description;
	protected String notes;
	//protected String startDate;
	//protected String endDate;
	protected String keywords;
	protected Integer runnightlyScripts;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	
/*
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
*/
	public Integer getRunnightlyScripts() {
		return runnightlyScripts;
	}

	public void setRunnightlyScripts(Integer runnightlyScripts) {
		this.runnightlyScripts = runnightlyScripts;
	}

	

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "TestViewDTO [testId=" + testId + ", owner=" + owner + ", folderId=" + folderId + ", testName=" + testName + ", description=" + description
				+ ", notes=" + notes + ", "
						//+ "startDate=" + startDate + ", endDate=" + endDate + ", "
								+ "keywords=" + keywords + ", runnightlyScripts="
				+ runnightlyScripts + "]";
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public Integer getFolderId() {
		return folderId;
	}
}
