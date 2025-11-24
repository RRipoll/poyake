package com.jsantos.auditimmo.screen.folder;

import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;

import com.jsantos.gui.form.EditMode;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.form.MTForm;
import com.jsantos.gui.zkcomponent.MTSelectbox;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.metadata.crm.PostalAddressDTO;
import com.jsantos.metadata.eva.BuildingDTO;
import com.jsantos.metadata.eva.FolderDTO;
import com.jsantos.orm.DBTransaction;

public class CreateFolder implements EventListener<Event>{
	protected MTForm mtForm;
	MTSelectbox paymentTypeSelector;
	
	public void buildEditorScreen(Component parent){
		try {
			parent.getChildren().clear();

			FormZulBuilder zulBuilder = new FormZulBuilder();
			zulBuilder.setZulURI("/screen/folder/create_folder.zul");
			
			mtForm = new MTForm(zulBuilder.buildForm(parent), EditMode.INSERT,null);
			mtForm.getSaveButton().addEventListener(Events.ON_CLICK, this);
			mtForm.getCancelButton().addEventListener(Events.ON_CLICK, this::onCancelButton);
			
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	void onCancelButton(Event evt) {
		mtForm.getFormComponent().detach();
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		if(event.getTarget().equals(mtForm.getSaveButton())){
			save();
		}
	}
	
	public void save() throws SQLException{
		new DBTransaction() {
			@Override
			protected void exec() {
				BuildingDTO building = new BuildingDTO();
				FolderDTO folder = new FolderDTO();
				PostalAddressDTO postalAddress = new PostalAddressDTO();
				
				ZulDataWirer.readFormFieldValues(postalAddress, mtForm.getFormComponent());
				ZulDataWirer.readFormFieldValues(folder, mtForm.getFormComponent());
				ZulDataWirer.readFormFieldValues(building, mtForm.getFormComponent());
				
				postalAddress.insert();
				building.insert();
				folder.setBuildingId(building.getBuildingId());
				folder.setPostalAddressId(postalAddress.getPostalAddressId());
				folder.insert();
	
			}
		}.run();
		
		Messagebox.show("Folder Created","Success !!!",Messagebox.OK, Messagebox.INFORMATION);
		mtForm.getFormComponent().detach();
	}

}
