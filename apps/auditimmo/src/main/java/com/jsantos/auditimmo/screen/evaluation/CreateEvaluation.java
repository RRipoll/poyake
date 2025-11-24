package com.jsantos.auditimmo.screen.evaluation;

import java.sql.SQLException;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import com.jsantos.auditimmo.screen.evaluation.detail.EvaluationSections;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.form.EditMode;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.objectselector.popup.ObjectSelectorPopup;
import com.jsantos.gui.zkcomponent.MTSelectbox;
import com.jsantos.gui.zkcomponent.MTSpanObjectDescription;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.eva.EnuEvaluationSectionType;
import com.jsantos.metadata.eva.EvaluationDTO;
import com.jsantos.orm.DBTransaction;

public class CreateEvaluation implements EventListener<Event>{
	Window window = new Window();
	protected MTForm mtForm;
	MTSelectbox paymentTypeSelector;
	EvaluationDTO evaluationDTO = null;
	
	public void buildAndShow(){
		try {
			window.setWidth("1500px");
			
			FormZulBuilder zulBuilder = new FormZulBuilder();
			zulBuilder.setZulURI("/screen/evaluation/create_evaluation.zul");
			
			mtForm = new MTForm(zulBuilder.buildForm(window), EditMode.INSERT,null);
			mtForm.getSaveButton().addEventListener(Events.ON_CLICK, this);
			mtForm.getCancelButton().addEventListener(Events.ON_CLICK, this::onCancelButton);
			mtForm.getFormComponent().getFellow("SEARCH_FOLDER").addEventListener(Events.ON_CLICK, this::searchFolder);
			mtForm.getFormComponent().getFellow("SEARCH_EVALUATOR").addEventListener(Events.ON_CLICK, this::searchEvaluator);
			mtForm.getFormComponent().getFellow("SEARCH_APPLICANT").addEventListener(Events.ON_CLICK, this::searchApplicant);
			mtForm.getFormComponent().getFellow("CREATE_APPLICANT").addEventListener(Events.ON_CLICK, this::createApplicant);
			mtForm.getFormComponent().getFellow("GO_TO_SANITARY").addEventListener(Events.ON_CLICK, this::goToSanitary);
			mtForm.getFormComponent().getFellow("GO_TO_HABITABILITY").addEventListener(Events.ON_CLICK, this::goToHabitability);
			
			window.setParent(DesktopHelper.getRootComponent());
			window.doModal();
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	void goToSanitary(Event evt){
		save();
		new EvaluationSections(evaluationDTO.getEvaluationId(), EnuEvaluationSectionType.SANITARY).buildAndShowComponent();
	}
	
	void goToHabitability(Event evt) {
		save();
		new EvaluationSections(evaluationDTO.getEvaluationId(), EnuEvaluationSectionType.HABITABILITY).buildAndShowComponent();
	}
	
	void searchFolder(Event evt) {
		MTSpanObjectDescription folderSpan = (MTSpanObjectDescription)mtForm.getFormComponent().getFellow("FOLDER_NAME");
		new ObjectSelectorPopup(MT.VFOLDERSEARCH, folderSpan).doModal();		
	}
	
	void searchEvaluator(Event evt) {
		MTSpanObjectDescription evaluatorSpan = (MTSpanObjectDescription)mtForm.getFormComponent().getFellow("EVALUATOR_NAME");
		new ObjectSelectorPopup(MT.VINTERVENANTSEARCH, evaluatorSpan).doModal();		
	}

	void searchApplicant(Event evt) {
		MTSpanObjectDescription applicantSpan = (MTSpanObjectDescription)mtForm.getFormComponent().getFellow("APPLICANT_NAME");
		new ObjectSelectorPopup(MT.VINTERVENANTSEARCH, applicantSpan).doModal();		
	}
	
	void createApplicant(Event evt) {
		
	}
	
	void onCancelButton(Event evt) {
		window.detach();
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		if(event.getTarget().equals(mtForm.getSaveButton())){
			save();
		}
	}
	
	public void save(){
		new DBTransaction() {
			
			@Override
			protected void exec() {
				evaluationDTO = new EvaluationDTO();
				
				ZulDataWirer.readFormFieldValues(evaluationDTO, mtForm.getFormComponent());
				
				evaluationDTO.insert();
	
			}
		}.run();
		Messagebox.show("Evaluation Created","Success !!!",Messagebox.OK, Messagebox.INFORMATION);
		window.detach();
	}

}
