package com.etantolling.testrunner.test.core.testrun;

import com.etantolling.testrunner.test.core.dto.HistoryDTO;

public class TestRun {

	private String ipAddress;
	private Integer testId;
	private Integer lastEventId;
	private boolean finished;
	private HistoryDTO historyDto=new HistoryDTO();
	
	public Integer getLastEventId() {
		return lastEventId;
	}
	public void setLastEventId(Integer lastEventId) {
		this.lastEventId = lastEventId;
		historyDto.setLastEventId(lastEventId);
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
		historyDto.setTestId(testId);
	}
	
	public synchronized boolean isFinished() {
		return finished;
	}
	public synchronized void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	@Override
	public String toString() {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		return "TestId: " + this.getTestId() + 
				" -- TO eventId: " + this.lastEventId; 
	}
	
	public HistoryDTO getHistoryDto() {
		return historyDto;
	}
	public void setHistoryDto(HistoryDTO historyDto) {
		this.historyDto = historyDto;
	}
}
