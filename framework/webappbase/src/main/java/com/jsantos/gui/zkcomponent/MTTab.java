package com.jsantos.gui.zkcomponent;

import org.zkoss.zhtml.A;
import org.zkoss.zhtml.Li;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

public class MTTab extends Li {
	private static final long serialVersionUID = 1L;
	String contentPanelId;
	Div contentPanel;
	String selectedClass = "active";
	String label;
	boolean isSelected;

	public MTTab() {
		setSclass("mt-tab");
		addEventListener(Events.ON_CLICK, this::clicked);
	}

	public void clicked(Event evt) {
		deselectAll();
		setSclass((this.getSclass() == null ? "" : this.getSclass()) + " " + selectedClass);
		if (null != getContentPanel())
			getContentPanel().setVisible(true);
		isSelected = true;
	}

	void deselectAll() {
		for (Component c : getParent().getChildren()) {
			if (c instanceof MTTab) {
				MTTab sibling = (MTTab) c;
				String sClass = this.getSclass();
				if (null == sClass)
					sClass = "";
				sibling.setSclass(sClass.replace(" " + selectedClass, ""));
				sibling.getContentPanel().setVisible(false);
			}
		}
	}

	Div getContentPanel() {
		if (null != getFellowIfAny(contentPanelId)) {
			Component c = getFellowIfAny(contentPanelId);
			if (c instanceof Div)
				return (Div) c;
		}
		return null;
	}

	public String getContentPanelId() {
		return contentPanelId;
	}

	public void setContentPanelId(String contentPanelId) {
		this.contentPanelId = contentPanelId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
		A a = new A();
		a.setParent(this);
		new Text(label).setParent(a);
		a.addEventListener(Events.ON_CLICK, this::clicked);
	}

	@Override
	public void setParent(Component parent) {
		if (0 == ((MTTabs) parent).getChildren().size()) {
			isSelected = true;
			setSclass((this.getSclass() == null ? "" : this.getSclass()) + " " + selectedClass);
		}
		super.setParent(parent);
	}

}
