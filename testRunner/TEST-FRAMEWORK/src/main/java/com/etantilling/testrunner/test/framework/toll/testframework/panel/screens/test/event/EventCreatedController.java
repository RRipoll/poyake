package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.InputElement;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.mtenumerations.MTEnuEVENTTYPE;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.misc.MiscUtility;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.test.zkweb.EditorElement;
import com.etantolling.testrunner.test.zkweb.ParameterItem;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;

public class EventCreatedController extends MTEditScreenControler {

	LinkedHashMap<String, ParameterItem> paramenters = new LinkedHashMap<String, ParameterItem>();
	Combobox newParameterType = null;
	Textbox newlabelname = null;
	Component eventParameterArea = null;
	Component addParamenter;
	Component resetParamenters;
	Combobox eventType;

	Radiogroup httpMethod;
	Radio post;
	Radio put;
	Integer eventDefinitionId;
	Integer eventTypeId;
	Checkbox isInputParameter;
	Checkbox isOutputParameter;

	Integer eventDefId = null;

	public EventCreatedController(Combobox comboEventFolderId, Component parent, Integer eventDefinitionId)
			throws WrongValueException, SQLException {
		super(eventDefinitionId, MT.EVENTDEFINITION, "/zul/panel/test/event/eventtypeeditor.zul");
		this.eventDefinitionId = eventDefinitionId;
		buildForm(parent);
		newParameterType = (Combobox) getView().window.getFellow("newType");
		newlabelname = (Textbox) getView().window.getFellow("newlabelname");
		eventParameterArea =  getView().window.getFellow("EVENT_PARAMENTER_AREA");
		addParamenter = getView().window.getFellow("ADD_PAREMETERS");
		addParamenter.addEventListener(Events.ON_CLICK, this);

		resetParamenters = getView().window.getFellow("RESET_PAREMETERS");
		resetParamenters.addEventListener(Events.ON_CLICK, this);
		eventType = (Combobox) getView().window.getFellow("eventType");
		if (null != view.dr.get(MT.EVENTDEFINITION.EVENTTYPEID))
			eventType.setSelectedIndex((Integer) view.dr.get(MT.EVENTDEFINITION.EVENTTYPEID) - 1);

		if(null!=eventDefinitionId) {
			String xmldata = (String) view.dr.get(MT.EVENTDEFINITION.PARAMETERS);
			LinkedHashMap<String, Object> storedParams = (LinkedHashMap<String, Object>) new MiscUtility().getObjectFromString(xmldata);
			for (String key : storedParams.keySet()) {
				LinkedHashMap<String, Object> item = (LinkedHashMap<String, Object>) storedParams.get(key);
				boolean bIsInput = (boolean) item.get("isInput");
				boolean bIsOutput = (boolean) item.get("isOutput");
				boolean isVariable = (boolean) item.get("isVariable");
				Object value = item.get("value");
				String type = (String) item.get("type");
				String label = ((String) item.get("label")).trim();

				EditorElement editorElement = new EditorElement(getObjectFromString(type), true, false, bIsInput,
					bIsOutput,type);
				paramenters.put(key, new ParameterItem(editorElement, false, bIsInput, bIsOutput, type, value, label));
				editorElement.getLabel().setText(key);
			}
		}
		renderParamenters();

		httpMethod = (Radiogroup) getView().window.getFellow("httpMethod");
		httpMethod.addEventListener(Events.ON_CHANGE, this);

		post = (Radio) getView().window.getFellow("POST");
		post.addEventListener(Events.ON_CHECK, this);
		put = (Radio) getView().window.getFellow("PUT");
		put.addEventListener(Events.ON_CHECK, this);

		if (null != eventType.getSelectedItem() && (eventType.getSelectedItem().getValue() == MTEnuEVENTTYPE.Rest_Event
				|| eventType.getSelectedItem().getValue() == MTEnuEVENTTYPE.Rest_Job_Event)) {
			getView().window.getFellow("trhttpMethod").setVisible(true);
			((Radio) getView().window.getFellow((String) paramenters.get("HTTPMETHOD").getValue())).setChecked(true);
		}

		isInputParameter = (Checkbox) getView().window.getFellow("ISINPUTPARAMETER");
		isOutputParameter = (Checkbox) getView().window.getFellow("ISOUTPUTPARAMETER");

		eventType.addEventListener(Events.ON_CHANGE, this);
		fillParameterType(newParameterType);

		if(null!=comboEventFolderId) {
		Comboitem selectedItem = comboEventFolderId.getSelectedItem();
			((Textbox) getView().window.getFellow("folderlabel")).setValue(selectedItem.getLabel());
			((Intbox) getView().window.getFellow("folderid")).setValue(selectedItem.getValue());
		}else {
			((Intbox) getView().window.getFellow("folderid")).setValue((Integer) view.dr.get(MT.EVENTDEFINITION.FOLDERID));
		}

		doModal();

	}

	private void fillParameterType(Combobox newParameterType) {

		newParameterType.getChildren().clear();

		new Comboitem("Int").setParent(newParameterType);
		new Comboitem("Text").setParent(newParameterType);
		new Comboitem("BigDecimal").setParent(newParameterType);
		new Comboitem("Date").setParent(newParameterType);
		new Comboitem("JSON").setParent(newParameterType);
		new Comboitem("Conditional-Null").setParent(newParameterType);
		new Comboitem("Conditional-Not-Null").setParent(newParameterType);
		new Comboitem("Conditional-Equal").setParent(newParameterType);

	}

	@Override
	public void onEvent(Event event) throws Exception {
		super.onEvent(event);

		if (event.getTarget().equals(addParamenter)) {

			String key = newlabelname.getValue();
			if (null == key || key.trim().length() == 0)
				throw new WrongValueException(newlabelname, "mandatory");
			key = key.trim();
			String type = newParameterType.getSelectedItem().getLabel();
			if (null == type || type.trim().length() == 0)
				throw new WrongValueException(newParameterType, "mandatory");

			boolean bIsInput = isInputParameter.isChecked();
			boolean bIsOutput = isOutputParameter.isChecked();
			if (!(bIsInput || bIsOutput))
				throw new WrongValueException(isInputParameter, "Input or Output must be checked");

			if (null != key && null != type) {
				String label = key;
				EditorElement editorElement = new EditorElement(getObjectFromString(type), true, false, bIsInput,
						bIsOutput,type);
				paramenters.put(key, new ParameterItem(editorElement, false, bIsInput, bIsOutput, type, null, label));
				editorElement.getLabel().setText(key);
				renderParamenters();
				newlabelname.setValue(null);
				newParameterType.setValue(null);
				isInputParameter.setChecked(false);
				isInputParameter.setChecked(false);
			}
		}

		if (event.getTarget().equals(resetParamenters)) {

			paramenters.clear();
			renderParamenters();
		}
		if (event.getTarget().equals(post) || event.getTarget().equals(put)) {
			paramenters.clear();
			paramenters.put("URL",
					new ParameterItem(new EditorElement(getObjectFromString("Text"), true, true, true, false,"Text"), false,
							true, false, "Text", null, "URL"));
			if (!paramenters.containsKey("JSON")) {
				paramenters.put("JSON",
						new ParameterItem(new EditorElement(getObjectFromString("JSON"), true, true, true, false,"JSON"),
								false, true, false, "JSON", null, null));
			}
			renderParamenters();
		}
		if (event.getTarget().equals(eventType) && (eventType.getSelectedItem().getValue() == MTEnuEVENTTYPE.Rest_Event
				|| eventType.getSelectedItem().getValue() == MTEnuEVENTTYPE.Rest_Job_Event)) {
			paramenters.clear();
			paramenters.put("URL",
					new ParameterItem(new EditorElement(getObjectFromString("Text"), true, true, true, false,"Text"), false,
							true, false, "Text", null, "URL"));

			renderParamenters();
			getView().window.getFellow("trhttpMethod").setVisible(true);
		}
		if (event.getTarget().equals(eventType) && eventType.getSelectedItem().getValue() == MTEnuEVENTTYPE.Job_Event) {
			paramenters.clear();
			paramenters.put("URL",
					new ParameterItem(new EditorElement(getObjectFromString("Text"), true, true, true, false,"Text"), false,
							true, false, "Text", "/api/joblaunches", "URL"));
			paramenters.put("HTTPMETHOD",
					new ParameterItem(new EditorElement(getObjectFromString("Text"), true, true, true, false,"Text"), false,
							true, false, "Text", "PUT", "HTTPMETHOD"));

			paramenters.put("jobName",
					new ParameterItem(new EditorElement(getObjectFromString("Text"), true, true, true, false,"Text"), false,
							true, false, "Text", null, "jobName"));
			paramenters.put("maxTime-sec",
					new ParameterItem(new EditorElement(getObjectFromString("Int"), true, true, true, false,"Int"), false,
							true, false, "Int", 60, "maxTime-sec"));
			paramenters
					.put("JSON",
							new ParameterItem(new EditorElement(getObjectFromString("JSON"), true, true, true, false,"JSON"),
									false, true, false, "JSON",
									"{\n" + "  \"jobName\": \"<jobName>\",\n" + "  \"jobParameters\": {\n"
											+ "    \"parameters\": {\n" + "     \n" + "    }\n" + "  }\n" + "}",
									"JSON"));

			renderParamenters();
		}
		if (event.getTarget().equals(eventType)
				&& eventType.getSelectedItem().getValue() == MTEnuEVENTTYPE.File_Event) {
			paramenters.clear();
			paramenters.put("URL",
					new ParameterItem(new EditorElement(getObjectFromString("Text"), true, true, true, false,"Text"), false,
							true, false, "Text", "/api/job-execution/interop-file-load", "URL"));
			paramenters.put("HTTPMETHOD",
					new ParameterItem(new EditorElement(getObjectFromString("Text"), true, true, true, false,"Text"), false,
							true, false, "Text", "PUT", "HTTPMETHOD"));
			paramenters.put("JSON",
					new ParameterItem(new EditorElement(getObjectFromString("JSON"), true, true, true, false,"JSON"), false,
							true, false, "JSON", "{}", "JSON"));
			renderParamenters();
		}
	
	if(null!=event.getTarget().getAttribute("JSON")) {
		System.out.println("hola caracola");
	}
	}

	private void renderParamenters() {

		eventParameterArea.getChildren().clear();

		
		
		for (String key : paramenters.keySet()) {
			if (!key.equals("HTTPMETHOD")) {
				Tr tr = new Tr();
				tr.setParent(eventParameterArea);
				Td box = new Td();
				box.setParent(tr);
				new Label(key).setParent(box);
				new Space().setParent(box);
				paramenters.get(key).editElement.setParent(box);
			}
		}

	}

	public static InputElement getObjectFromString(String type) {

		if (type.equalsIgnoreCase("Int")) {
			Intbox object = new Intbox();
			return object;
		} else if (type.equalsIgnoreCase("Text")) {
			Textbox object = new Textbox();
			object.setWidth("400px");
			return object;
		} else if (type.equalsIgnoreCase("BigDecimal")) {
			return new Decimalbox();
		} else if (type.equalsIgnoreCase("Date")) {
			return new Datebox();
		} else if (type.equalsIgnoreCase("JSON")) {
			Textbox tb = new Textbox("");
			tb.setWidth("400px");
			tb.setCols(10);
			tb.setHeight("200px");
			tb.setMultiline(true);
			return tb;
		} else if (type.equalsIgnoreCase("Conditional-Null") || type.equalsIgnoreCase("Conditional-Not-Null") || type.equalsIgnoreCase("Conditional-Equal")) {
			Textbox object = new Textbox();
			object.setWidth("400px");
			return object;
		} else
			return null;

	}

	@Override
	public void save() throws SQLException {
		Connection conn = MainDb.getConnection();
		try {
			conn.setAutoCommit(false);
			wireFields();
			view.dr.set(MT.EVENTDEFINITION.EVENTDEFINITIONID, eventDefinitionId);
			view.dr.set(MT.EVENTDEFINITION.EVENTTYPEID,
					(null != eventType.getSelectedItem()) ? eventType.getSelectedItem().getValue() : 0);
			view.dr.set(MT.EVENTDEFINITION.CREATOR, DesktopHelper.getInputUserId());
			
			LinkedHashMap<String, LinkedHashMap<String, Object>> saveParam = new LinkedHashMap<String, LinkedHashMap<String, Object>>();

			for (String key : paramenters.keySet()) {
				ParameterItem item = paramenters.get(key);
				LinkedHashMap<String, Object> aItem = new LinkedHashMap<String, Object>();
				aItem.put("type", item.getType());
				aItem.put("value", item.getEditElement().getElement().getRawValue());
				aItem.put("isInput", item.getEditElement().getIsInput().isChecked());
				aItem.put("isOutput", item.getEditElement().getIsOutput().isChecked());
				aItem.put("label", StringUtils.isEmpty((String) item.getEditElement().getLabel().getRawValue()) ? key
						: item.getEditElement().getLabel().getRawValue());
				aItem.put("isVariable", item.getEditElement().getByReference().isChecked());
				saveParam.put(key, aItem);
			}
			if (null != eventType.getSelectedItem()
					&& (eventType.getSelectedItem().getValue() == MTEnuEVENTTYPE.Rest_Event
							|| eventType.getSelectedItem().getValue() == MTEnuEVENTTYPE.Rest_Job_Event)
					&& null != httpMethod.getSelectedItem()) {
				LinkedHashMap<String, Object> aItem = new LinkedHashMap<String, Object>();
				aItem.put("type", "Text");
				aItem.put("value", httpMethod.getSelectedItem().getId());
				aItem.put("isInput", true);
				aItem.put("isOutput", false);
				aItem.put("isVariable", false);
				aItem.put("label", "HTTPMETHOD");
				saveParam.put("HTTPMETHOD", aItem);
			}

			view.dr.set(MT.EVENTDEFINITION.PARAMETERS, new MiscUtility().getStringFromObject(saveParam));

			view.dr.save(conn);

			conn.commit();
			setPk(view.dr.getPk());

		} catch (Exception e) {
			conn.rollback();
			throw new RuntimeException(e);
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
		view.window.detach();
	}

}
