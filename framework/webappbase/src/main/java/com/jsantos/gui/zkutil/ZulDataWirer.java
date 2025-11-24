package com.jsantos.gui.zkutil;

import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.sys.ComponentCtrl;

import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.ActionConstraints;
import com.jsantos.common.model.conf.DetailConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.constraints.MTConstraint;
import com.jsantos.gui.constraints.MTSimpleConstraint;
import com.jsantos.gui.constraints.VisibilityBuilder;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

/**
 * @author javier santos
 * @author raul ripoll
 */
public class ZulDataWirer {
	
	public static void initializeFieldValues(IDetachedRecord detachedRecord, Component parent) {
		if (null == detachedRecord)
			return;
		initializeFieldValues(detachedRecord, ComponentTreeTransverser.getMetadataAnotatedComponents(parent));
	}

	public static void readFormFieldValues(IDetachedRecord detachedRecord, Component parent) {
		readFormFieldValues(detachedRecord, ComponentTreeTransverser.getMetadataAnotatedComponents(parent));
	}

	static void readFormFieldValues(IDetachedRecord detachedRecord, MTMapValues<Component> components) {
		ListValues<IValidationError> errors = new ListValues<IValidationError>();
		for (Entry<MTField, Component> element : components.entrySet()) {
			Component comp = element.getValue();
			if (comp instanceof IMTComponent) {
				IMTComponent imtComponent = ((IMTComponent) comp);
				MTField mtField = imtComponent.getMTField();
				if (null != mtField && mtField.getTable() == detachedRecord.getTable()) {
					try {
						boolean isUpdated=imtComponent.isUpdated();
						Object value=imtComponent.getValue();
						System.out.println(isUpdated +" <> "+mtField + " -> "+ isUpdated + " : "  +detachedRecord.get(mtField) + "  "+ value);
						if (null != imtComponent.getConstraints())
							imtComponent.getConstraints().validate(imtComponent, value);
						if(isUpdated) {
							detachedRecord.getUpdates().put(mtField, value);
						}else {
							detachedRecord.set(mtField, value);
							}
					} catch (ConstraintsException e) {
						errors.addAll(e.getErrors());
					}
				}
			} else {
				throw new WrongValueException(comp.toString() + " is not a IMTComponent");
			}
		}
		if (!errors.isEmpty())
			throw new ConstraintsException(ApiError.VALIDATION_ERROR, errors);
	}

	public static void initializeFieldLabels(Component parent) {
		for (Entry<MTField, Component> element : ComponentTreeTransverser.getMetadataAnotatedComponents(parent)
				.entrySet()) {
			MTField mtField = element.getKey();
			Component comp = element.getValue();
			if (comp instanceof IMTComponent) {
				IMTComponent mtComp = (IMTComponent) comp;
				if (null != mtField && null!=mtComp.getLabel() && StringUtils.isBlank(mtComp.getLabel())) {
					mtComp.setLabel(Zklabel.getLabel(mtField.getFullyQualifiedName(), LocaleFactory.getProvider().getLocale()));
				}
			} else {
				throw new WrongValueException(comp.toString() + " is not a IMTComponent");
			}
		}
	}

	static void initializeFieldValues(IDetachedRecord detachedRecord, MTMapValues<Component> components) {
		for (Entry<MTField, Component> element : components.entrySet()) {
			MTField mtField = element.getKey();
			Component comp = element.getValue();
			if (null == mtField)
				mtField = MTAnnotation.getMTField((ComponentCtrl) comp);
			if (null == mtField)
				continue;
			if (comp instanceof IMTComponent) {
				if (null == ((IMTComponent) comp).getMTField())
					((IMTComponent) comp).setMTField(mtField);
				if (mtField.getTable() == detachedRecord.getTable()
						&& ((IMTComponent) comp).getMTField().getTable() == detachedRecord.getTable()) {
					setValueNoPropagated((IMTComponent) comp, detachedRecord);
				}
			} else {
				throw new WrongValueException(" it is not a IMTComponent");
			}
		}
	}

	public static void initializeFieldConstraints(Component parent, String searchName) {

		MTMapValues<Component> components = ComponentTreeTransverser.getMetadataAnotatedComponents(parent);
		for (Entry<MTField, Component> element : components.entrySet()) {
			MTField mtField = element.getKey();
			String searchNameForField;
			if(null==searchName)searchNameForField=mtField.getTable().getTableName();else searchNameForField=searchName;
			IMTComponent comp = (IMTComponent) element.getValue();
			MTConstraint<Component> constraint = new MTConstraint<>(comp, mtField, components);
			comp.setConstraint(constraint);
			SettingDTO setting = DesktopHelper.getSetting(searchNameForField,  DesktopHelper.getInputUserId(), LocaleFactory.getProvider().getLocale())
					;
			for (DetailConfiguration conf : setting.getEditConfigurations()) {
				if (!conf.getConstraints().isEmpty() && conf.getMtField().equals(mtField)) {
					for (String consts : conf.getConstraints()) {
						Class<IConstraintsBuilder> constraintClass = null;
						try {
							constraintClass = (Class<IConstraintsBuilder>) Class.forName(consts);
						} catch (ClassNotFoundException e) {
							;
						}
						if (null != constraintClass)
							try {
								constraint.setConstraints(constraintClass.newInstance());
							} catch (Exception e) {
								e.printStackTrace();
							}
						else
							constraint.setConstraints(
									(IConstraintsBuilder) new MTSimpleConstraint(comp, consts));
					}

				}

				if (null != conf.getActions() && !conf.getActions().isEmpty() && conf.getMtField().equals(mtField)) {
					for (ActionConstraints action : conf.getActions()) {
						ListValues<Component> objetives = new ListValues<>();
						List<String> jObjetives = action.getObjetives();
						for (String objetive : jObjetives) {
							MTField mTfield = MTBase.getMTField(objetive);
							if (null != mTfield)
								objetives.add(components.get(mTfield));
							else
								objetives.add(parent.getFellow(objetive));
						}
                        if(!jObjetives.isEmpty()) {
    						VisibilityBuilder visibilityBuilder = new VisibilityBuilder(objetives,(ListValues<Object>) action.getValues());
    						constraint.setConstraints((IConstraintsBuilder) visibilityBuilder);
                        }
					}
				}
			}
		}
	}

	public static void setValueNoPropagated(IMTComponent comp, IDetachedRecord dRecord) {
		try {
			comp.setDetachedRecord(dRecord);
		} catch (WrongValueException | ConstraintsException e) {
			System.out.println(e.getMessage());
			;
		}
	}

	public static void setReadOnlyEditor(Component formComponent, boolean readOnly) {

		for (Entry<MTField, Component> element : ComponentTreeTransverser.getMetadataAnotatedComponents(formComponent)
				.entrySet()) {
			Component comp = element.getValue();
			if (comp instanceof IMTComponent) {
				((IMTComponent) comp).setReadonly(readOnly);
			} else {
				throw new WrongValueException(comp.toString() + " is not a IMTComponent");
			}
		}
	}
}
