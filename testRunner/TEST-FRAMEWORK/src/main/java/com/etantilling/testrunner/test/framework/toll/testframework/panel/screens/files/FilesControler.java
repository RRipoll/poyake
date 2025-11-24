package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.files;

import java.sql.SQLException;

import org.zkoss.zk.ui.WrongValueException;

import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.FieldList;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.MTListScreenControler;

public class FilesControler 	extends MTListScreenControler{
	
	private static final long serialVersionUID = -5882815688800094692L;

	
	public FilesControler() throws SQLException{
		super(MT.FILEREF,false,null);
	}
	
	@SuppressWarnings("static-access")
	public void create() throws WrongValueException, SQLException {
		MTEditScreenControler editControler = new FileRefEditControler(null);
		FieldList fieldList = new FieldList(mtTable);
		fieldList.remove(MT.FILEREF.MIMETYPE);
		fieldList.remove(MT.FILEREF.AZUREURL);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(view);
		editControler.doModal();
	}
	
	
	
}
