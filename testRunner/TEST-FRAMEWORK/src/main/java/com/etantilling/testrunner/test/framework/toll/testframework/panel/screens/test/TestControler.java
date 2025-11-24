package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.tree.EventTreeController;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.tree.FolderTreeControler;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event.EventListControler;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.core.metadata.FieldList;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTable;
import com.etantolling.testrunner.test.zkweb.forms.ZulDataWirerSql;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.MTListScreenControler;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.standardlistheader.StandardListHeader;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class TestControler 	extends MTListScreenControler {
		
	private static final long serialVersionUID = -3587543784588917580L;
	
	public Component window;
	Component treebutton;
	Component eventtreebutton;
	Component listbutton;
	Component filter;
	Component listtab;
	Component treetab;
	Component eventtab;
	
	FolderTreeControler folderTreeControler;
	EventTreeController eventTreeController;
	
	
	public TestControler(Component comp) throws SQLException {
			
		super(MT.TEST,false,"select * from(SELECT TESTID,USERNAME, FOLDERPATH  FOLDER, TESTNAME, T.DESCRIPTION, NOTES,"
				+ " KEYWORDS,FP.FOLDERID,FP.DESCRIPTION FOLDERNAME,FP.PARENTFOLDERID "
				+ "FROM TEST T "
				+ "LEFT JOIN INPUTUSER UN ON T.OWNER=UN.INPUTUSERID AND UN.DELETED=0    "
				+ "LEFT JOIN FOLDERPATHS FP ON FP.FOLDERID=T.FOLDERID "
				+ "WHERE T.DELETED=0 and t.startdate<=:versionDate and t.enddate>=:versionDate and un.startdate<=:versionDate and un.enddate>=:versionDate  )p where (1=1)"
				);
		view.getDataGrid().setSelector(DataTable.SELECTOR_CHECKBOX);
		view.getDataGrid().setPageSize(10);
		window=comp;
		treebutton= window.getFellow("treebutton");
		eventtreebutton= window.getFellow("eventtreebutton");
		listbutton= window.getFellow("listbutton");
		filter= window.getFellow("filter");
		listtab= window.getFellow("listtab");
		listtab.addEventListener(Events.ON_CLICK, this);
		treetab= window.getFellow("treetab");
		treetab.addEventListener(Events.ON_CLICK, this);
		eventtab= window.getFellow("eventtab");
		eventtab.addEventListener(Events.ON_CLICK, this);
	}
		
	@Override
	public void layout() throws SQLException {
		setHeader(new StandardListHeader(this, getFilterComponent()));
		super.layout();
	}
		
	@SuppressWarnings("static-access")
	static public MTEditScreenControler createTest(Component parent) throws WrongValueException, SQLException{
		MTEditScreenControler editControler = new MTEditScreenControler(null, MT.TEST, "/zul/panel/test/testeditor.zul");
		FieldList fieldList = new FieldList(MT.TEST);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(parent);
		Combobox folder = (Combobox)ComponentTreeTransverser.findFieldEditorFor(editControler.getView().window, MT.TEST.FOLDERID);
		folder.getChildren().clear();
		folder.setAutocomplete(true);
		folder.setAutodrop(true);
		Connection conn= MainDb.getConnection();
		try{
			folder.setSelectedItem((Comboitem) ZulDataWirerSql.fillEnumerationBySql(conn, folder, "select folderid value,folderpath label from folderpaths where deleted=0 order by folderpath asc ",null,null));
		}finally{conn.close();}
		return editControler;
	}
		
	@Override
	public void create() throws WrongValueException, SQLException {
		createTest(view).doModal();
	}
		
	@SuppressWarnings("static-access")
	static public MTEditScreenControler editTest(Integer pk, Component parent) throws WrongValueException, SQLException {
		MTEditScreenControler editControler = new MTEditScreenControler(pk, MT.TEST, "/zul/panel/test/testeditor.zul");

		FieldList fieldList = new FieldList(MT.TEST);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(parent);
			
		EventListControler eventControler = new EventListControler(pk);
		((MTListScreenControler) eventControler).getHeader().getComponent().setParent(editControler.getView().window.getFellow("HEADER_LIST"));
		eventControler.setContent(editControler.getView().window.getFellow("EVENTS_LIST"));
		eventControler.layout();
		eventControler.setParent(editControler.getView().window.getFellow("EVENTS_LIST"));
		//eventControler.getView().setParent(editControler.getView().window);
		Combobox folder = (Combobox)ComponentTreeTransverser.findFieldEditorFor(editControler.getView().window, MT.TEST.FOLDERID);
		folder.setAutocomplete(true);
		folder.setAutodrop(true);
		Integer selectedValue=null;
		if(null!=folder.getSelectedItem())selectedValue=folder.getSelectedItem().getValue();
		folder.getChildren().clear();
		Connection conn= MainDb.getConnection();
		try{
			folder.setSelectedItem((Comboitem) ZulDataWirerSql.fillEnumerationBySql(conn, folder, "select folderid value,folderpath label from folderpaths where deleted=0 order by folderpath asc ",selectedValue,null));
		}finally{conn.close();}
		return editControler;
	}
		
	@Override
	public void edit(Integer pk) throws WrongValueException, SQLException {
		editTest(pk,view).doModal();;
	}

	@Override
	public Integer copy(Integer testId) throws WrongValueException, SQLException{
		
		

			return TestDuplicator.duplicateTest(testId);
		}
		
		@Override
		public void onEvent(Event event) throws Exception {
			
			if(event.getTarget().equals(listtab)){
				    filter.setVisible(true);
					treebutton.setVisible(false);
					eventtreebutton.setVisible(false);
					listbutton.setVisible(true);
					window.getFellow("content").setVisible(true);
					window.getFellow("tree").setVisible(false);
					window.getFellow("eventtree").setVisible(false);
					
			}else if(event.getTarget().equals(treetab)){
					filter.setVisible(true);	
					treebutton.setVisible(true);
					listbutton.setVisible(false);
					eventtreebutton.setVisible(false);
					window.getFellow("tree").setVisible(true);
					window.getFellow("eventtree").setVisible(false);
					window.getFellow("content").setVisible(false);
					if(null==folderTreeControler)folderTreeControler=new FolderTreeControler(window,view.getDataGrid());
					else folderTreeControler.render();
			
			}else if(event.getTarget().equals(eventtab)){
				filter.setVisible(false);
				eventtreebutton.setVisible(true);
				treebutton.setVisible(false);
				listbutton.setVisible(false);
				window.getFellow("tree").setVisible(false);
				window.getFellow("eventtree").setVisible(true);
				window.getFellow("content").setVisible(false);
				if(null==eventTreeController)eventTreeController=new EventTreeController(window);
				else eventTreeController.render();
		}
			
			super.onEvent(event);
		}
}
