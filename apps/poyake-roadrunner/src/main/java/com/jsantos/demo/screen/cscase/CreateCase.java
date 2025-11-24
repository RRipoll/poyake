package com.jsantos.demo.screen.cscase;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.form.controller.MTInsertScreenController;
import com.jsantos.metadata.MTroadRunnerData;
import com.jsantos.metadata.cs.CustomerCaseDTO;

public class CreateCase {

	Integer customerId;

	public CreateCase(Integer customerId) {
		super();
		this.customerId = customerId;
	}

	public void buildEditorScreen(Component comp) {

		comp.getChildren().clear();
		MTInsertScreenController controler = new MTInsertScreenController(comp, "~./zul/poyake-roadrunner/screen/case/create.zul", MTroadRunnerData.CSCASE,
				MTroadRunnerData.CUSTOMERCASE);

		CustomerCaseDTO customerCaseDTO = new CustomerCaseDTO();
		if (null != customerId)
			customerCaseDTO.setCustomerId(customerId);
		controler.getMtForm().addDetachedRecord(customerCaseDTO);
		controler.getMtForm().setSerializer(new SaveCaseSerializer());
		controler.getMtForm().getFormComponent().setParent(comp);

	}

	public void buildModalScreen(Component comp) {

		MTInsertScreenController controler = new MTInsertScreenController(comp, "~./zul/poyake-roadrunner/screen/case/create.zul", MTroadRunnerData.CSCASE,
				MTroadRunnerData.CUSTOMERCASE);
		CustomerCaseDTO customerCaseDTO = new CustomerCaseDTO();
		if (null != customerId)
			customerCaseDTO.setCustomerId(customerId);
		controler.getMtForm().addDetachedRecord(customerCaseDTO);
		controler.getMtForm().setSerializer(new SaveCaseSerializer());
		controler.doModal();
	}
}
