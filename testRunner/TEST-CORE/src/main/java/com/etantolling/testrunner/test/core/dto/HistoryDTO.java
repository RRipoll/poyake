package com.etantolling.testrunner.test.core.dto;

import java.util.Date;

public class HistoryDTO {

	Integer historyId;
	Integer testId;
	Integer lastEventId;
	Integer statusId;
	Date postingDate;
	String enviroment;
	public Integer getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	
	
	public Date getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}
	public String getEnviroment() {
		return enviroment;
	}
	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}
	public Integer getLastEventId() {
		return lastEventId;
	}
	public void setLastEventId(Integer lastEventId) {
		this.lastEventId = lastEventId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	
}
