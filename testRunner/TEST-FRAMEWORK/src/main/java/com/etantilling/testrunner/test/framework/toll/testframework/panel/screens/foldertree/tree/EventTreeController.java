package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.tree;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.FolderList;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.EventFolder;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.event.EventCreatedController;
import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.db.DataGridQuery;
import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class EventTreeController implements EventListener<Event> {

private static final Logger log = LoggerFactory.getLogger(EventTreeController.class);

private Component window;
private Tree tree;
private AdvancedTreeModel folderTreeModel;
private Vector<Checkbox> checkboxVector= new Vector<Checkbox>();
private Component ebt_delete;
private Component ebt_addEvent;
private Component ebt_addFolder;


public  EventTreeController(Component comp) throws Exception {
	window= comp;
	
	tree=(Tree) comp.getFellow("eventtree");

	tree.getChildren().clear();
	
	ebt_delete=window.getFellow("ebt_delete");
	ebt_delete.addEventListener(Events.ON_CLICK, this);
	ebt_delete.setVisible(true);
	
	ebt_addFolder=window.getFellow("ebt_addfolder");
	ebt_addFolder.addEventListener(Events.ON_CLICK, this);
	ebt_addFolder.setVisible(true);

	ebt_addEvent=window.getFellow("ebt_addevent");
	ebt_addEvent.addEventListener(Events.ON_CLICK, this);
	ebt_addEvent.setVisible(true);
	
	render();
}

public void render() throws SQLException{
	tree.getChildren().clear();
	String versionDate=EnvironmentHelper.getVersionDate();
	String sql="SELECT * FROM(" + 
			"SELECT EVENTDEFINITIONID TESTID,CREATOR USERNAME, FOLDERPATH  FOLDER, t.eventname TESTNAME, T.DESCRIPTION,'' NOTES," + 
			"				 '' KEYWORDS,FP.EVENTDEFFOLDERID FOLDERID,FP.DESCRIPTION FOLDERNAME,FP.PARENTFOLDERID  " + 
			"				FROM EVENTDEFINITION T " + 
			"				LEFT JOIN INPUTUSER UN ON T.CREATOR=UN.INPUTUSERID AND UN.DELETED=0  and un.startdate<=:versionDate and un.enddate>=:versionDate" + 
			"				LEFT JOIN EVENTFOLDERPATHS FP ON FP.EVENTDEFFOLDERID=T.FOLDERID and FP.startdate<=:versionDate and FP.enddate>=:versionDate  " + 
			"				WHERE T.DELETED=0 and t.startdate<=:versionDate and t.enddate>=:versionDate" + 
			")P WHERE (1=1)";
	try(Connection conn= MainDb.getConnection()){
		
		String sqlfolder="SELECT  CASE WHEN PARENTFOLDERID IS NULL THEN 0 ELSE PARENTFOLDERID END PARENTFOLDERID ,EVENTDEFFOLDERID  FOLDERID,DESCRIPTION FOLDERNAME ,FOLDERPATH ,NULL TESTID,NULL TESTNAME " + 
				"			FROM EVENTFOLDERPATHS WHERE DELETED !=1"
				+ " and STARTDATE<="+versionDate+" and ENDDATE>="+versionDate+"";
		
		folderTreeModel = new AdvancedTreeModel(new FolderList(new DataGridQuery(conn, sql),sqlfolder).getRoot());
	}
	tree.setItemRenderer(new FolderTreeRenderer(this,checkboxVector));
	tree.setModel(folderTreeModel);
}

@SuppressWarnings({ "static-access", "unchecked" })
@Override
public void onEvent(Event event) throws Exception {
	
	if(event.getName().equals("onFilterChanged")){
		checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
		render();
	}
	
	else if(event.getTarget().equals(ebt_addEvent)){
		
		Checkbox box=checkboxVector.stream().filter(item -> item.isChecked()).findFirst().orElse(null);

		if(null==box){
			Messagebox.show("Please, Select a Parent Node");
			checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
			return;
		}
		
		Treeitem parentTreeItem= (Treeitem)box.getAttribute("treeItem");
		IFolder parentFolder=((IFolder)box.getAttribute("folder"));
		if(null!=parentFolder.getTestid()){
			Messagebox.show("Please, Select a Parent Node");
			checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
			return;
		}
		Integer parentFolderId=parentFolder.getFolderId();
		
		IFolder folder= new EventFolder(parentFolderId,null, null );
		
		Combobox comboparent= new Combobox();
		Comboitem itemb= new Comboitem(parentFolder.getFolderName());
		itemb.setParent(comboparent);
		itemb.setValue(parentFolder.getFolderId());
		comboparent.setSelectedItem(itemb);
		
		MTEditScreenControler editControler=new EventCreatedController(comboparent, window, null);
		
		if(null!=editControler && null!=editControler.getPk()){
			DetachedRecord dr= new DetachedRecord(MT.EVENTDEFINITION, editControler.getPk());
			folder.setTestid(editControler.getPk());
			((EventFolder)folder).setEventDefinitionId(editControler.getPk());
			folder.setTestName((String) dr.get(MT.EVENTDEFINITION.EVENTNAME));
			((EventFolder)folder).setEventName((String) dr.get(MT.EVENTDEFINITION.EVENTNAME));
			folder.setFolderId((Integer) dr.get(MT.EVENTDEFINITION.FOLDERID));
			folder.setParentfolderid((Integer) dr.get(MT.EVENTDEFINITION.FOLDERID));
			FolderTreeNode node=new FolderTreeNode(folder,new ArrayList<FolderTreeNode>());
			folderTreeModel.add((FolderTreeNode) parentTreeItem.getValue(),new DefaultTreeNode[] { node  });
		}
		
		checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
		
	}else if(event.getTarget().equals(ebt_delete)){
		Connection conn=MainDb.getConnection();
		try{
			checkboxVector.stream().filter(item -> item.isChecked()).forEach(item ->
			{
				try {
					((IFolder)item.getAttribute("folder")).delete(conn);
				} catch (Exception e) {
					log.error("ERROR STACKTRACE:",e);
				}
				folderTreeModel.remove(((Treeitem)item.getAttribute("treeItem")).getValue());
				item.setChecked(false);
			});
		}finally{conn.close();}
		checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
	}else if(event.getTarget().equals(ebt_addFolder)){

		Checkbox box=checkboxVector.stream().filter(item -> item.isChecked()).findFirst().orElse(null);

		if(null==box){
			Messagebox.show("Please, Select a Parent Node");
			checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
			return;
		}
		Treeitem parentTreeItem= (Treeitem)box.getAttribute("treeItem");
		IFolder parentFolder=((IFolder)box.getAttribute("folder"));
		if(null!=parentFolder.getTestid()){
			Messagebox.show("Please, Select a Parent Node");
			checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
			return;
		}
		Integer parentFolderId=parentFolder.getFolderId();
		
		IFolder folder= new EventFolder(null, null, parentFolderId);
		MTEditScreenControler editControler=folder.createFolder(window);
		((Combobox)ComponentTreeTransverser.findFieldEditorFor(editControler.getView().window, MT.EVENTDEFFOLDER.PARENTFOLDERID)).setDisabled(true);
		editControler.doModal();
		if(null!=editControler && null!=editControler.getPk()){
			DetachedRecord dr= new DetachedRecord(MT.EVENTDEFFOLDER, editControler.getPk());
			folder.setFolderId(editControler.getPk());
			folder.setFolderName((String) dr.get(MT.EVENTDEFFOLDER.DESCRIPTION));
		
			FolderTreeNode node=new FolderTreeNode(folder,new ArrayList<FolderTreeNode>());
			folderTreeModel.add((FolderTreeNode) parentTreeItem.getValue(),new DefaultTreeNode[] { node  });
			checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
		}
	
		checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
	}else if(event.getName().equals(Events.ON_CLICK)){
		
		FolderTreeNode clickedNodeValue = (FolderTreeNode) ((Treeitem) ((Treerow)event.getTarget().getAttribute("dataRow")).getParent()).getValue();
		
		if(null!=clickedNodeValue.getData().getTestid()){
			Integer testId=clickedNodeValue.getData().getTestid();
			
			new EventCreatedController(null, window, testId);

			DetachedRecord dr= new DetachedRecord(MT.EVENTDEFINITION, testId);
			((Label)event.getTarget()).setValue((String) dr.get(MT.EVENTDEFINITION.DESCRIPTION));
			clickedNodeValue.getData().setTestName((String) dr.get(MT.EVENTDEFINITION.DESCRIPTION));
			
		}else{
			MTEditScreenControler editControler=clickedNodeValue.getData().edit(window);
			((Combobox)ComponentTreeTransverser.findFieldEditorFor(editControler.getView().window, MT.EVENTDEFFOLDER.PARENTFOLDERID)).setDisabled(true);
			editControler.doModal();
			DetachedRecord dr= new DetachedRecord(MT.EVENTDEFFOLDER, clickedNodeValue.getData().getFolderId());
			((Label)event.getTarget()).setValue((String) dr.get(MT.EVENTDEFFOLDER.DESCRIPTION));
		
			clickedNodeValue.getData().setFolderName((String) dr.get(MT.EVENTDEFFOLDER.DESCRIPTION));
		}
	}
	
	else if(event.getName().equals(Events.ON_DROP)){
		
		Treeitem draggedItem = (Treeitem) ((DropEvent) event).getDragged().getParent();
		FolderTreeNode draggedValue = (FolderTreeNode) draggedItem.getValue();
		
		Treeitem treeItem = (Treeitem) event.getTarget().getParent();
		
		Treeitem parentItem = treeItem.getParentItem();
        Connection conn=MainDb.getConnection();
        try{
        	draggedValue.getData().move(conn,((FolderTreeNode)treeItem.getValue()).getData().getFolderId());
        }finally{conn.close();}
		folderTreeModel.remove(draggedValue);
		if (FolderTreeRenderer.isFolder((IFolder) ((FolderTreeNode) treeItem.getValue()).getData())) {
			folderTreeModel.add((FolderTreeNode) treeItem.getValue(),new DefaultTreeNode[] { draggedValue });
		} else {
			int index = parentItem.getTreechildren().getChildren().indexOf(treeItem);
			if(parentItem.getValue() instanceof FolderTreeNode) {
				folderTreeModel.insert((FolderTreeNode)parentItem.getValue(), index, index,	new DefaultTreeNode[] { draggedValue });
			}
		}
	}
}
}