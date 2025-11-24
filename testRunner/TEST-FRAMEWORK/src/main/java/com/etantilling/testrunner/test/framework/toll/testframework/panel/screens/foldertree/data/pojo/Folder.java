package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.TestControler;
import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.FieldList;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class Folder implements IFolder {
	 
	 String folderName;
	 Integer folderId;
	 Integer parentfolderid;
	 Integer testid;
	 String testName;
	
	public Folder(Integer folderId, Integer testid, String testName) {
		super();
		this.folderId = folderId;
		this.parentfolderid = folderId;
		this.testid = testid;
		this.testName = testName;
	}

	public Folder(String folderName, Integer folderId, Integer parentfolderid) {
		super();
		this.folderName = folderName;
		this.folderId = folderId;
		this.parentfolderid = parentfolderid;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#getFolderName()
	 */
	@Override
	public String getFolderName() {
		return folderName;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#setFolderName(java.lang.String)
	 */
	@Override
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#getFolderId()
	 */
	@Override
	public Integer getFolderId() {
		return folderId;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#setFolderId(java.lang.Integer)
	 */
	@Override
	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#getParentfolderid()
	 */
	@Override
	public Integer getParentfolderid() {
		return parentfolderid;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#setParentfolderid(java.lang.Integer)
	 */
	@Override
	public void setParentfolderid(Integer parentfolderid) {
		this.parentfolderid = parentfolderid;
	}
	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#getTestid()
	 */
	@Override
	public Integer getTestid() {
		return testid;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#setTestid(java.lang.Integer)
	 */
	@Override
	public void setTestid(Integer testid) {
		this.testid = testid;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#getTestName()
	 */
	@Override
	public String getTestName() {
		return testName;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#setTestName(java.lang.String)
	 */
	@Override
	public void setTestName(String testName) {
		this.testName = testName;
	}

	

	
	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#edit(org.zkoss.zk.ui.Component)
	 */
	@Override
	public MTEditScreenControler edit(Component parent) throws WrongValueException, SQLException{
		
		MTEditScreenControler editControler = new MTEditScreenControler(getFolderId(), MT.FOLDER, "/zul/panel/folder/foldereditor.zul");
		FieldList fieldList = new FieldList(MT.FOLDER);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(parent);
		return editControler;

	}
	
	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#createFolder(org.zkoss.zk.ui.Component)
	 */
	@Override
	@SuppressWarnings("static-access")
	public MTEditScreenControler createFolder(Component parent) throws WrongValueException, SQLException{
		
		MTEditScreenControler editControler = new MTEditScreenControler(null, MT.FOLDER, "/zul/panel/folder/foldereditor.zul");
		FieldList fieldList = new FieldList(MT.FOLDER);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(parent);
		Combobox parentFolder = (Combobox)ComponentTreeTransverser.findFieldEditorFor(parent, MT.FOLDER.PARENTFOLDERID);
		Comboitem selectedItem=parentFolder.getItems().stream().filter(item -> null!=item.getValue() && item.getValue().toString().equals(getParentfolderid().toString())).findFirst().orElse(null);
		parentFolder.setSelectedItem(selectedItem);
		return editControler;
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#createTest(org.zkoss.zk.ui.Component)
	 */
	@Override
	@SuppressWarnings("static-access")
	public MTEditScreenControler createTest(Component parent) throws WrongValueException, SQLException{
		
		MTEditScreenControler editControler=TestControler.createTest(parent);
		Combobox parentFolder = (Combobox)ComponentTreeTransverser.findFieldEditorFor(parent, MT.TEST.FOLDERID);
		Comboitem selectedItem=parentFolder.getItems().stream().filter(item -> item.getValue().toString().equals(getParentfolderid().toString())).findFirst().orElse(null);
		parentFolder.setSelectedItem(selectedItem);
		return editControler;
	}
	
	
	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#delete(java.sql.Connection)
	 */
	@Override
	@SuppressWarnings("static-access")
	public void delete(Connection conn) throws SQLException {
		
			if(null==getTestid()){
				if(Messagebox.OK==Messagebox.show("forder "+folderName +" and its children will be removed, do you agree? ", "Remove", Messagebox.OK, Messagebox.NONE)){
					
					String sql="update test set deleted=1, enddate="+EnvironmentHelper.getVersionDate()+" where enddate>"+EnvironmentHelper.getVersionDate()+"and  folderid="+ folderId;
					Statement st= conn.createStatement();
					st.executeUpdate(sql);
					st.close();
					DetachedRecord dr= new DetachedRecord(MT.FOLDER, getFolderId());
					dr.set(MT.FOLDER.DELETED, 1);
					dr.save(conn);
				}
			}else{
				DetachedRecord dr= new DetachedRecord(MT.TEST, getTestid());
				dr.set(MT.TEST.DELETED, 1);
				dr.save(conn);
			}
	}

	/* (non-Javadoc)
	 * @see com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder#move(java.sql.Connection, java.lang.Integer)
	 */
	@Override
	@SuppressWarnings("static-access")
	public void move(Connection conn,Integer parentfolderid) throws SQLException {
	    if(null==testid){
			DetachedRecord dr= new DetachedRecord(MT.FOLDER, getFolderId());
			dr.set(MT.FOLDER.PARENTFOLDERID,parentfolderid);
			dr.save(conn);
	    }else{
	    	DetachedRecord dr= new DetachedRecord(MT.TEST, getTestid());
			dr.set(MT.TEST.FOLDERID,parentfolderid);
			dr.save(conn);
	    	
	    }
	}
}

