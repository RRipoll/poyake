package com.etantolling.testrunner.test.core.dto;

import java.util.Date;

public class EventDTO {
	protected String automaticDescription;
	protected Integer deleted;
	protected Integer eventDefinitionId;
	protected Integer eventId;
	protected Integer eventOrder;
	protected String manualDescription;
	protected Date postingDate;
	protected Integer testId;
	protected String parameters;
	
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

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "EventDTO [automaticDescription=" + automaticDescription + ", deleted=" + deleted + ", eventDefinitionId=" + eventDefinitionId + ", eventId="
				+ eventId + ", eventOrder=" + eventOrder + ", manualDescription=" + manualDescription + ", postingDate=" + postingDate + ", testId=" + testId + "]";
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
