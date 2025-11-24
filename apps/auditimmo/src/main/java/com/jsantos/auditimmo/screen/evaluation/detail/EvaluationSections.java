package com.jsantos.auditimmo.screen.evaluation.detail;

import java.util.ArrayList;
import java.util.Vector;

import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Window;

import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.zkutil.CSSClassList;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.eva.EnuEvaluationSectionDTO;
import com.jsantos.metadata.eva.EnuEvaluationSubsectionDTO;
import com.jsantos.metadata.eva.EvaluationSubsectionDetailDTO;
import com.jsantos.orm.dbstatement.DetachedQueryResult;

public class EvaluationSections{
	int evaluationId;
	Window window = null;
	Component sectionsContainer;
	Component subSectionContainer;
	Integer evaluationSectiontypeId;
	ArrayList<Div> subsectionDivList = new ArrayList<>();
	Component selectedDiv;
	Detail currentDetail = null;
	Component buttonNext;
	Component buttonPrior;
	
	
	public EvaluationSections(Integer evaluationId, Integer evaluationSectiontypeId) {
		this.evaluationSectiontypeId = evaluationSectiontypeId;
		this.evaluationId = evaluationId;
	}

	public Component buildComponent(Component parent) {
		Component comp = Executions.createComponents("/screen/evaluation/evaluation_sections.zul", parent, null);
		sectionsContainer = comp.getFellow("EVALUATION_SECTIONS");
		subSectionContainer = comp.getFellow("SUBSECTION_CONTAINER");
		comp.getFellow("BUTTON_SECTIONS_CLOSE").addEventListener(Events.ON_CLICK, this::onCloseButton);
		comp.getFellow("SUBSECTION_BUTTON_PRIOR").addEventListener(Events.ON_CLICK, this::onButtonPrior);
		comp.getFellow("SUBSECTION_BUTTON_NEXT").addEventListener(Events.ON_CLICK, this::onButtonNext);
		initSectionsContainer();
		showSubSection(subsectionDivList.get(0));
		return comp;
	}
	
	public void buildAndShowComponent() {
		window = new Window();
		window.setWidth("90%");
		window.setHeight("100%");
		window.setParent(DesktopHelper.getRootComponent());
		buildComponent(window);
		((Window)window).doModal();
	}
	
	void onButtonPrior(Event evt) {
		if (0==subsectionDivList.indexOf(selectedDiv))
			return;
		showSubSection(subsectionDivList.get(subsectionDivList.indexOf(selectedDiv) - 1));
	}
	
	void onButtonNext(Event evt) {
		if (subsectionDivList.indexOf(selectedDiv) >=subsectionDivList.size()-1)
			return;
		showSubSection(subsectionDivList.get(subsectionDivList.indexOf(selectedDiv) + 1));
	}
	
	void onCloseButton(Event evt) {
		window.detach();
	}
	
	void initSectionsContainer() {
		DetachedQueryResult dqrSubSection = new DetachedQueryResult(MT.ENUEVALUATIONSUBSECTION);
		dqrSubSection.setPageSize(1000);
		ArrayList<EnuEvaluationSubsectionDTO> subsections = dqrSubSection.getPage(0, EnuEvaluationSubsectionDTO.class);
		
		DetachedQueryResult dqrSection = new DetachedQueryResult(MT.ENUEVALUATIONSECTION, " and evaluationSectionTypeId=" + evaluationSectiontypeId);
		dqrSection.setPageSize(1000);
		ArrayList<EnuEvaluationSectionDTO> sections = dqrSection.getPage(0, EnuEvaluationSectionDTO.class);
		
		for (EnuEvaluationSectionDTO section:sections) {
			Div divSection = new Div();
			divSection.setParent(sectionsContainer);
			Div divSectionHeader = new Div();
			divSectionHeader.setSclass("mt-evaluation-section");
			new Text(section.getDescription()).setParent(divSectionHeader);
			divSectionHeader.setParent(divSection);
			Div divSubSections = new Div();
			divSubSections.setParent(divSection);
			for (EnuEvaluationSubsectionDTO subsection:subsections) {
				if (subsection.getEvaluationSectionId() == section.getEvaluationSectionId()) {
					Div divSubSection = new Div();
					divSubSection.setSclass("mt-evaluation-subsection row");
					subsectionDivList.add(divSubSection);
					Div divSubSectionLabel = new Div();
					divSubSectionLabel.setParent(divSubSection);
					divSubSectionLabel.setSclass("mt-evaluation-subsection-label col-10");
					new Text(subsection.getDescription()).setParent(divSubSectionLabel);
					divSubSection.setParent(divSubSections);
					divSubSection.addEventListener(Events.ON_CLICK, this::onSubsectionClicked);
					Div divStatus = new Div();
					divStatus.setSclass("mt-evaluation-subsection-status col-2");
					divStatus.setParent(divSubSection);
					EvaluationSubsectionDetailDTO detail = loadOrCreateEvaluationSubsectionDetailDTO(subsection.getEvaluationSubsectionId());
					new Text(MT.ENUSUBSECTIONSTATUS.getEnumeration().getShortCode(detail.getSubSectionStatus())).setParent(divStatus);
					divSubSection.setAttribute("SUBSECTION_DETAIL", detail);
					divSubSection.setAttribute("SUBSECTION_STATUS", divStatus);
				}
			}
			
		}
	}
	
	EvaluationSubsectionDetailDTO loadOrCreateEvaluationSubsectionDetailDTO(Integer evaluationSubsectionId) {
		EvaluationSubsectionDetailDTO detail = EvaluationSubsectionDetailDTO.find(" evaluationId=" + evaluationId + " and evaluationSubSectionId=" + evaluationSubsectionId);
		if (null == detail) {
			detail = new EvaluationSubsectionDetailDTO();
			detail.setEvaluationId(evaluationId);
			detail.setEvaluationSubsectionId(evaluationSubsectionId);
		}
		return detail;
	}
	
	void onSubsectionClicked(Event evt) {
		showSubSection(evt.getTarget());
	}
	
	void showSubSection(Component divSubSection) {
		for (Div d:subsectionDivList)
			CSSClassList.remove(d, "mt-subsection_selected");
		CSSClassList.add(divSubSection, "mt-subsection_selected");
		EvaluationSubsectionDetailDTO detail = (EvaluationSubsectionDetailDTO)divSubSection.getAttribute("SUBSECTION_DETAIL");
		if (null != currentDetail) {
			currentDetail.save();
		}
		currentDetail = new Detail();
		currentDetail.build(detail, subSectionContainer, (Div)divSubSection.getAttribute("SUBSECTION_STATUS"));
		selectedDiv = divSubSection;
		
	}	
	
}




