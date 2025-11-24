package com.etantolling.testrunner.test.core.dto;

import java.sql.Timestamp;

public class TestDTO {
	protected Integer testId;
	protected Integer owner;
	protected Integer folderId;
	protected String testName;
	protected String description;
	protected String notes;
	protected Timestamp startDate;
	protected Timestamp endDate;
	protected String keywords;
	protected Integer runnightlyScripts;
	protected Integer regressionTest;
	protected Timestamp created;
	protected Integer deleted;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
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

	public Timestamp getStartdate() {
		return startDate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startDate = startdate;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Integer getRunnightlyScripts() {
		return runnightlyScripts;
	}

	public void setRunnightlyScripts(Integer runnightlyScripts) {
		this.runnightlyScripts = runnightlyScripts;
	}

	public Integer getRegressionTest() {
		return regressionTest;
	}

	public void setRegressionTest(Integer regressionTest) {
		this.regressionTest = regressionTest;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "TestDTO [testId=" + testId + ", owner=" + owner + ", folderId=" + folderId + ", testName=" + testName + ", description=" + description + ", notes=" + notes + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", keywords=" + keywords + ", runnightlyScripts=" + runnightlyScripts + ", regressionTest=" + regressionTest + ", created=" + created + ", deleted="
				+ deleted + "]";
	}
}
