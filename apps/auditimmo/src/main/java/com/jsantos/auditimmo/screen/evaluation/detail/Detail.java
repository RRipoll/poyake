package com.jsantos.auditimmo.screen.evaluation.detail;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Text;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.zkutil.CSSClassList;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.eva.EnuEvaluationSectionDTO;
import com.jsantos.metadata.eva.EnuEvaluationSubsectionDTO;
import com.jsantos.metadata.eva.EnuSubSectionstatus;
import com.jsantos.metadata.eva.EvaluationSubsectionDetailDTO;

public class Detail {
	ArrayList<Td> levelTds = new ArrayList<>(); 
	Component subSectionArea;
	EvaluationSubsectionDetailDTO detail;
	Textbox measurementTextbox;
	Textbox observationTextbox;
	Div statusDiv;

	void build(EvaluationSubsectionDetailDTO detail, Component subSectionContainer, Div statusDiv) {
		this.detail = detail;
		this.statusDiv = statusDiv;
		subSectionContainer.getChildren().clear();
		subSectionArea = Executions.createComponents("/screen/evaluation/evaluation_subsection.zul", DesktopHelper.getRootComponent(), null);
		subSectionArea.setParent(subSectionContainer);
		Tr tr = (Tr)subSectionArea.getFellow("TR_LEVELS");
		levelTds = new ArrayList<>();
			
		if (null != detail) {
			for (int level=0; level<10; level++) {
				Td td = new Td();
				td.setParent(tr);
				if (null != detail.getLevel() && detail.getLevel()==level)
					CSSClassList.add(td, "mt-td-checked");
				td.addEventListener(Events.ON_CLICK, this::onTdClicked);
				levelTds.add(td);
			}
			EnuEvaluationSubsectionDTO enuSubSection = new EnuEvaluationSubsectionDTO(detail.getEvaluationSubsectionId());
			((Label)subSectionArea.getFellow("SUB_SECTION_LABEL")).setValue(enuSubSection.getDescription());
			EnuEvaluationSectionDTO enuSection = new EnuEvaluationSectionDTO(enuSubSection.getEvaluationSectionId());
			((Label)subSectionArea.getFellow("SECTION_LABEL")).setValue(enuSection.getDescription());
			
			
			measurementTextbox = ((Textbox)subSectionArea.getFellow("TEXTBOX_MEASUREMENT"));
			measurementTextbox.setText(detail.getMeasurements());
			observationTextbox = ((Textbox)subSectionArea.getFellow("TEXTBOX_OBSERVATIONS"));
			observationTextbox.setText(detail.getObservations());
		}
		
		
	}
	
	void onTdClicked(Event evt) {
		Td thisTd = (Td)evt.getTarget();
		boolean thisTdChecked = CSSClassList.contains(thisTd, "mt-td-checked");
		for (Td td:levelTds)
			CSSClassList.remove(td, "mt-td-checked");
		if (!thisTdChecked) 
			CSSClassList.add(thisTd, "mt-td-checked");
	}

	void save() {
		for (Td td:levelTds)
			if (CSSClassList.contains(td, "mt-td-checked"))
				detail.setLevel(levelTds.indexOf(td));
		
		detail.setMeasurements(measurementTextbox.getText());
		detail.setObservations(observationTextbox.getText());
		detail.setSubSectionStatus(calculateStatus());
		detail.insertOrUpdate();
		statusDiv.getChildren().clear();
		new Text(MT.ENUSUBSECTIONSTATUS.getEnumeration().getShortCode(detail.getSubSectionStatus())).setParent(statusDiv);
	}
	
	int calculateStatus() {
		if (null == detail.getLevel())
			return EnuSubSectionstatus.O;
		else if (0 == detail.getLevel())
			return EnuSubSectionstatus.NA;
		else if (StringUtils.isNotBlank(detail.getMeasurements()) && StringUtils.isNotBlank(detail.getObservations()))
			return EnuSubSectionstatus.Ev;
		else
			return EnuSubSectionstatus.Em;
	}
	
}
