package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.custom.extendeddto.FileGroupExtDTO;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.filegroup.FileGroupHandler;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
/**
 * @author raul ripoll
 */
public class FileGroupContainer extends Div implements IMTComponent {

	private static final long serialVersionUID = 5839605580182059377L;

	FileGroupHandler fileGroupHandler;
	MTField mtField;
	String field;
	String label;

	private boolean isUpdated;

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public Component initialize() {
		try {

			FormZulBuilder zulBuilder = new FormZulBuilder();
			zulBuilder.setZulURI("~./common/zul/customcomponents/file_group.zul");
			Component form = zulBuilder.buildForm(this);
			Component uploadedfileList = form.getFellow("UPLOADED_FILE_LIST");
			uploadedfileList.addEventListener(CustomEvents.ON_ISUPDATED, this::setUpdated);
			fileGroupHandler = new FileGroupHandler((Component) form.getFellow("UPLOAD_BUTTON"), uploadedfileList);
			((Button) form.getFellow("UPLOAD_BUTTON")).setLabel(
					LabelFactory.getProvider().get("file_attach_document", LocaleFactory.getProvider().getLocale()));
		} catch (Throwable e) {
			e.printStackTrace();
			throw new WrongValueException(this, ErrorsConstants.FILE_ERROR);
		}
		return this;
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		if (null != dRecord && null != dRecord.get(mtField)) {
			Object value = dRecord.get(mtField);
			if (value instanceof Integer)
				value = new FileGroupExtDTO((Integer) value);
			fileGroupHandler.setFileGroupExtDTO((FileGroupExtDTO) value);
		} else
			fileGroupHandler.setFileGroupExtDTO(new FileGroupExtDTO());

	}

	@Override
	public Object getValue() {

		try {
			fileGroupHandler.allocateFiles(mtField.getName(), DesktopHelper.getInputUserId(),
					DesktopHelper.getInputSourceId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new WrongValueException(this, ErrorsConstants.FILE_ERROR);
		}
		;
		if (null == fileGroupHandler.getFileGroupExtDTO().getStorageFiles())
			return null;
		return fileGroupHandler.getFileGroupExtDTO();
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.FILE_GROUP;
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
	}

	@Override
	public void setReadonly(boolean readOnly) {
		fileGroupHandler.setReadonly(readOnly);
	}

	@Override
	public void setValue(Object value) {
		fileGroupHandler.setFileGroupExtDTO(new FileGroupExtDTO((Integer) value));
	}

	public void setCustomComponent(IMTComponent customComponent) {
	}

	public IMTComponent getCustomComponent() {
		return null;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;

	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setField(String field) {
		this.field = field;
		setMTField(MTBase.getMTField(field));
		initialize();
	}

	@Override
	public String getField() {

		return field;
	}

	@Override
	public IMTConstraint getConstraints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConstraint(IMTConstraint constraint) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUpdated() {
		return isUpdated;
	}

	@Override
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
		if (isUpdated)
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, null);
	}

	public void setUpdated(Event isUpdated) {
		setUpdated(true);
	}

}
