package com.jsantos.gui.zkcomponent;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zhtml.Label;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.Datebox;

import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class MTDatebox extends Datebox implements IMTComponent {

	private static final long serialVersionUID = 1L;
	String label;
	String field;
	MTField mtField;
	Label labelTag;
	IMTConstraint constraint = new EmptyConstraint();
	private boolean isUpdated;

	public MTDatebox() {
		super();
		setCols(11);
		addEventListener(Events.ON_FOCUS, new BootstrapFocusEventListener());
		addEventListener(Events.ON_BLUR, new BootstrapFocusEventListener());
		addEventListener(Events.ON_CHANGE, new BootstrapFocusEventListener());
	}

	@Override
	public void setValue(Object value) throws WrongValueException {
		super.setValue((Date) value);
		try {
			Events.sendEvent(Events.ON_CHANGE, this, null);
		} catch (Exception e) {
			;
		}
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
		if (null == labelTag) {
			labelTag = new Label();
			labelTag.setSclass("form-label");
			labelTag.setDynamicProperty("onClick", "$(this).parent().find('input').focus()");
			labelTag.setDynamicProperty("for", getUuid());
			labelTag.setParent(getParent());
		}
		labelTag.getChildren().clear();
		Text text = new Text(label);
		text.setParent(labelTag);
	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public void setField(String field) {
		this.field = field;
		mtField = MTBase.getMTField(field);
		if (StringUtils.isEmpty(label))
			setLabel(Zklabel.getLabel(mtField.getFullyQualifiedName(), LocaleFactory.getProvider().getLocale()));
	}

	@Override
	public void setMTField(MTField mtField) {
		this.field = mtField.getFullyQualifiedName();
		this.mtField = mtField;
	}

	@Override
	protected void renderProperties(ContentRenderer renderer) throws IOException {
		super.renderProperties(renderer);
		renderer.render("label", getLabel());
	}

	@Override
	public void setReadonly(boolean readonly) {
		super.setDisabled(readonly);
	}

	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible, this);
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		setValue(dRecord.get(mtField));
	}

	@Override
	public IMTConstraint getConstraints() {
		return constraint;
	}

	@Override
	public void setConstraint(IMTConstraint constraint) {
		this.constraint = constraint;
	}

	@Override
	public Component initialize() {
		this.setInplace(true);
		return this;
	}

	@Override
	public boolean isUpdated() {
		return isUpdated;
	}

	@Override
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
		if (isUpdated)
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, getValue());
	}

	public void setUpdated(Event isUpdated) {
		setUpdated(true);
	}
}
