package com.jsantos.zk.extensions;

import java.io.IOException;

import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.Combobox;

public class MTCombobox extends Combobox implements IMTComponent{
	private static final long serialVersionUID = 1L;
	
	String label;
	String field;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	protected void renderProperties(ContentRenderer renderer) throws IOException {
		super.renderProperties(renderer);
		renderer.render("label", getLabel());
		renderer.render("field", getField());
	}

}
