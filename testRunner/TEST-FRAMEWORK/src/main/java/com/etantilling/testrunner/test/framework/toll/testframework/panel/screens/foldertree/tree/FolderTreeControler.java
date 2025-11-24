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
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.FolderList;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.Folder;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.test.TestControler;
import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.generatedmetadata.testrepository.MT;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTableCompressed;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class FolderTreeControler implements EventListener<Event> {
	
	private static final Logger log = LoggerFactory.getLogger(FolderTreeControler.class);
	
	private Component window;
	private Tree tree;
	private AdvancedTreeModel folderTreeModel;
	private Vector<Checkbox> checkboxVector= new Vector<Checkbox>();
	private Component bt_delete;
	private Component bt_addFolder;
	private Component bt_addTest;
	DataTableCompressed dTC;
	
	public FolderTreeControler(Component comp,DataTableCompressed dTC) throws Exception {
		window= comp;
		
		this.dTC=dTC;
		tree=(Tree) comp.getFellow("tree");

		tree.getChildren().clear();
		
		bt_delete=window.getFellow("bt_delete");
		bt_delete.addEventListener(Events.ON_CLICK, this);
		bt_delete.setVisible(true);
		
		bt_addFolder=window.getFellow("bt_addfolder");
		bt_addFolder.addEventListener(Events.ON_CLICK, this);
		bt_addFolder.setVisible(true);

		bt_addTest=window.getFellow("bt_addtest");
		bt_addTest.addEventListener(Events.ON_CLICK, this);
		bt_addTest.setVisible(true);
		
		dTC.getFilter().addEventListener("onFilterChanged", this);
		
		render();
		
	}

	public void render() throws SQLException{
		tree.getChildren().clear();
		folderTreeModel = new AdvancedTreeModel(new FolderList(dTC.getDataTable().getDgModel().dgQuery).getRoot());
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
		
		else if(event.getTarget().equals(bt_addTest)){
			
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
			
			IFolder folder= new Folder(parentFolderId,null, null );
			
			MTEditScreenControler editControler=folder.createTest(window);
			
			((Combobox)ComponentTreeTransverser.findFieldEditorFor(editControler.getView().window, MT.TEST.FOLDERID)).setDisabled(true);
			
			editControler.doModal();
			
			if(null!=editControler && null!=editControler.getPk()){
				DetachedRecord dr= new DetachedRecord(MT.TEST, editControler.getPk());
				folder.setTestid(editControler.getPk());
				folder.setTestName((String) dr.get(MT.TEST.TESTNAME));
				folder.setFolderId((Integer) dr.get(MT.TEST.FOLDERID));
				folder.setParentfolderid((Integer) dr.get(MT.TEST.FOLDERID));
/*
				int index = parentTreeItem.getTreechildren().getChildren().indexOf(treeItem);
				if(parentTreeItem.getValue() instanceof FolderTreeNode) {
				folderTreeModel.insert((FolderTreeNode)parentTreeItem.getValue(), index, index,	new DefaultTreeNode[] { draggedValue });
*/	
				FolderTreeNode node=new FolderTreeNode(folder,new ArrayList<FolderTreeNode>());
				folderTreeModel.add((FolderTreeNode) parentTreeItem.getValue(),new DefaultTreeNode[] { node  });
				
				
			}

			
			checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
			
			
		}else if(event.getTarget().equals(bt_delete)){
			Connection conn=MainDb.getConnection();
			try{
				checkboxVector.stream().filter(item -> item.isChecked()).forEach(item ->
				{
					//Folder folder=((Folder)item.getAttribute("folder"));
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
		}else if(event.getTarget().equals(bt_addFolder)){

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
			
			Folder folder= new Folder(null, null, parentFolderId);
			MTEditScreenControler editControler=folder.createFolder(window);
			((Combobox)ComponentTreeTransverser.findFieldEditorFor(editControler.getView().window, MT.FOLDER.PARENTFOLDERID)).setDisabled(true);
			editControler.doModal();
			if(null!=editControler && null!=editControler.getPk()){
				DetachedRecord dr= new DetachedRecord(MT.FOLDER, editControler.getPk());
				folder.setFolderId(editControler.getPk());
				folder.setFolderName((String) dr.get(MT.FOLDER.DESCRIPTION));
			
				FolderTreeNode node=new FolderTreeNode(folder,new ArrayList<FolderTreeNode>());
				folderTreeModel.add((FolderTreeNode) parentTreeItem.getValue(),new DefaultTreeNode[] { node  });
				checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
			}
		
			checkboxVector.stream().filter(item -> item.isChecked()).forEach(item -> item.setChecked(false));
		}else if(event.getName().equals(Events.ON_CLICK)){
			
			FolderTreeNode clickedNodeValue = (FolderTreeNode) ((Treeitem) ((Treerow)event.getTarget().getAttribute("dataRow")).getParent()).getValue();
			
			if(null!=clickedNodeValue.getData().getTestid()){
				Integer testId=clickedNodeValue.getData().getTestid();
				MTEditScreenControler editControler= TestControler.editTest(testId, window);
				((Combobox)ComponentTreeTransverser.findFieldEditorFor(editControler.getView().window, MT.TEST.FOLDERID)).setDisabled(true);
				editControler.doModal();
				DetachedRecord dr= new DetachedRecord(MT.TEST, testId);
				((Label)event.getTarget()).setValue((String) dr.get(MT.TEST.TESTNAME));
				clickedNodeValue.getData().setTestName((String) dr.get(MT.TEST.TESTNAME));
				
			}else{
				MTEditScreenControler editControler=clickedNodeValue.getData().edit(window);
				((Combobox)ComponentTreeTransverser.findFieldEditorFor(editControler.getView().window, MT.FOLDER.PARENTFOLDERID)).setDisabled(true);
				editControler.doModal();
				DetachedRecord dr= new DetachedRecord(MT.FOLDER, clickedNodeValue.getData().getFolderId());
				((Label)event.getTarget()).setValue((String) dr.get(MT.FOLDER.DESCRIPTION));
			
				clickedNodeValue.getData().setFolderName((String) dr.get(MT.FOLDER.DESCRIPTION));
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