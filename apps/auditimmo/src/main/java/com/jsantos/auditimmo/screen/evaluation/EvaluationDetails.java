package com.jsantos.auditimmo.screen.evaluation;

import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Window;

import com.jsantos.auditimmo.screen.evaluation.detail.EvaluationSections;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.metadata.crm.ContactDTO;
import com.jsantos.metadata.eva.BuildingDTO;
import com.jsantos.metadata.eva.EnuEvaluationSectionType;
import com.jsantos.metadata.eva.EvaluationDTO;
import com.jsantos.metadata.eva.FolderDTO;

public class EvaluationDetails implements EventListener<Event>{
	int pk;
	Component parent;
	Component comp = null;
	
	public EvaluationDetails(int pk, Component parent) {
		this.pk=pk;
		this.parent = parent;
	}
	
	public void buildAndShowComponent() throws Exception {
		comp = Executions.createComponents("/screen/evaluation/details.zul", parent, null);
		setDetails(comp);
		((Window)comp).doModal();
	}
	
	public void reload() throws Exception {
		comp.detach();
		buildAndShowComponent();
	}
	
	public void setDetails(Component comp) throws Exception {
		
		comp.getFellow("DETAILS_BUTTON_CLOSE").addEventListener(Events.ON_CLICK, this::closeWindow);
		EvaluationSections habitabilitySections = new EvaluationSections(pk, EnuEvaluationSectionType.HABITABILITY);
		habitabilitySections.buildComponent(comp.getFellow("DIV_CHABITABILITY"));
		
		EvaluationDTO evaluationDTO = new EvaluationDTO(pk);
		FolderDTO folderDTO = new FolderDTO(evaluationDTO.getFolderId());
		BuildingDTO buildingDTO = new BuildingDTO(folderDTO.getBuildingId());
		ContactDTO applicantDTO = new ContactDTO(evaluationDTO.getApplicantId());
		ContactDTO evaluatorDTO = new ContactDTO(evaluationDTO.getEvaluatorId());
		
		ZulDataWirer.initializeFieldValues(evaluationDTO, comp);
		ZulDataWirer.initializeFieldValues(buildingDTO, comp);
		ZulDataWirer.initializeFieldValues(folderDTO, comp);
		ZulDataWirer.initializeFieldValues(applicantDTO, comp.getFellow("APPLICANT_DETAILS"));
		ZulDataWirer.initializeFieldValues(evaluatorDTO, comp.getFellow("EVALUATOR_DETAILS"));
//		EvaluationSections sanitarySections = new EvaluationSections(pk, EnuEvaluationSectionType.SANITARY);
//		sanitarySections.buildComponent(comp.getFellow("DIV_CSANITARY"));
		
		EvaluationResult result = new EvaluationResult(pk, EnuEvaluationSectionType.HABITABILITY);
		result.calculate();
		result.renderTable(comp.getFellow("HABITABILITY_TABLE"));
		((Div)comp.getFellow("HABITABILITY_RESULT")).setStyle("background-color: " + result.getResultColor());
		result = new EvaluationResult(pk, EnuEvaluationSectionType.SANITARY);
		result.calculate();
		result.renderTable(comp.getFellow("SANITARY_TABLE"));
		((Div)comp.getFellow("SANITARY_RESULT")).setStyle("background-color: " + result.getResultColor());
	}

	@Override
	public void onEvent(Event event) throws Exception {

	}
	
	void closeWindow(Event event) {
		comp.detach();
	}
}
