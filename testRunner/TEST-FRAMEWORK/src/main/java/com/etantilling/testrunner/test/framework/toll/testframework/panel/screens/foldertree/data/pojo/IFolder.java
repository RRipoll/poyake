package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo;

import java.sql.Connection;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;

import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;

public interface IFolder {

	String getFolderName();

	void setFolderName(String folderName);

	Integer getFolderId();

	void setFolderId(Integer folderId);

	Integer getParentfolderid();

	void setParentfolderid(Integer parentfolderid);

	Integer getTestid();

	void setTestid(Integer testid);

	String getTestName();

	void setTestName(String testName);

	MTEditScreenControler edit(Component parent) throws WrongValueException, SQLException;

	MTEditScreenControler createFolder(Component parent) throws WrongValueException, SQLException;

	MTEditScreenControler createTest(Component parent) throws WrongValueException, SQLException;

	void delete(Connection conn) throws SQLException;

	void move(Connection conn, Integer parentfolderid) throws SQLException;

}