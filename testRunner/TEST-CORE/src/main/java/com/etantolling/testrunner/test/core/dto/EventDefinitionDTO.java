package com.etantolling.testrunner.test.core.dto;

import java.sql.Timestamp;

public class EventDefinitionDTO {
	private Timestamp created;
	private Integer creator;
	private Integer deleted;
	private String description;
	private Integer eventDefinitionId;
	private String eventName;
	private Integer eventTypeId;
	private Integer folderId;
	private String parameters;

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
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

	public Integer getEventDefinitionId() {
		return eventDefinitionId;
	}

	public void setEventDefinitionId(Integer eventDefinitionId) {
		this.eventDefinitionId = eventDefinitionId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Integer eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	@Override
	public String toString() {
		return "EventDefinitionDTO [created=" + created + ", creator=" + creator + ", deleted=" + deleted + ", description=" + description + ", eventDefinitionId="
				+ eventDefinitionId + ", eventName=" + eventName + ", eventTypeId=" + eventTypeId + ", folderId=" + folderId + "]";
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
