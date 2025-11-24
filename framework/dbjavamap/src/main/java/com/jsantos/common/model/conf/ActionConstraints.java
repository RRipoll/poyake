package com.jsantos.common.model.conf;

import java.util.List;

import com.jsantos.common.util.ListValues;

public class ActionConstraints {

	public enum actions {
		visibility, hiding
	};

	actions action = actions.visibility;// "hiding"
	ListValues<String> objetives = new ListValues<String>();
	ListValues<Object> values = new ListValues<Object>();

	public ActionConstraints() {
		super();

	}

	public ActionConstraints(ListValues<String> objetives, ListValues<Object> values) {
		super();

		this.objetives = objetives;
		this.values = values;

	}

	public actions getAction() {
		return action;
	}

	public void setAction(actions action) {
		this.action = action;
	}

	public List<String> getObjetives() {
		return objetives;
	}

	public void setObjetives(ListValues<String> objetives) {
		this.objetives = objetives;
	}

	public ListValues<Object> getValues() {
		return values;
	}

	public void setValues(ListValues<Object> values) {
		this.values = values;
	}

}
