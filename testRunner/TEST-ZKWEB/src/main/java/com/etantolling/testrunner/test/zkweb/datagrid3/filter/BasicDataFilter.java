package com.etantolling.testrunner.test.zkweb.datagrid3.filter;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

public class BasicDataFilter extends DataGridFilter implements EventListener {

	private static final long serialVersionUID = 1749665492091784345L;
	private long key;

	public BasicDataFilter(String cssClass) {
		super(cssClass);
	}


	public long getKey() {
		return key;
	}

	public void onEvent(Event event) throws Exception {
		super.onEvent(event); // let the superclass handle the usual events.
	}

	public void setKey(long key) {
		this.key = key;
	}

	@Override
	public String buildWhereClause() {
		return "";
	}
	@Override
	public void reset() {
		;
	}
}