package com.etantolling.testrunner.test.core.dto;



public class EventViewDTO {
	

	public Integer getEventFileId() {
		return eventFileId;
	}

	public void setEventFileId(Integer eventFileId) {
		this.eventFileId = eventFileId;
	}

	private String eventType;
	private String description;
	protected String automaticDescription;
	protected Integer deleted;
	protected Integer eventDefinitionId;
	protected Integer eventId;
	protected Integer eventOrder;
	protected String manualDescription;
	protected Integer testId;
	protected Integer stepId;
	protected Integer eventTypeId;
	protected Integer eventFileId;
	protected String parameters;

	
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getAutomaticDescription() {
		return automaticDescription;
	}

	public void setAutomaticDescription(String automaticDescription) {
		this.automaticDescription = automaticDescription;
	}

	

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getEventDefinitionId() {
		return eventDefinitionId;
	}

	public void setEventDefinitionId(Integer eventDefinitionId) {
		this.eventDefinitionId = eventDefinitionId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getEventOrder() {
		return eventOrder;
	}

	public void setEventOrder(Integer eventOrder) {
		this.eventOrder = eventOrder;
	}

	public String getManualDescription() {
		return manualDescription;
	}

	public void setManualDescription(String manualDescription) {
		this.manualDescription = manualDescription;
	}
/*
	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
*/
	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "EventViewDTO [eventType=" + eventType + ", description=" + description + ", parameters=" + parameters + ", automaticDescription="
				+ automaticDescription + ", deleted=" + deleted + ", eventDefinitionId=" + eventDefinitionId + ", eventId="
				+ eventId + ", eventOrder=" + eventOrder + ", manualDescription=" + manualDescription + ", testId=" + testId
				+ "]";
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}
	public Integer getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Integer eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
