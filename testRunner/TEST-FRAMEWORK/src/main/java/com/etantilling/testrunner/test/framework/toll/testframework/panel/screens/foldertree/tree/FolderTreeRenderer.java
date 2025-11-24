package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.tree;

import java.util.Vector;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder;


public class FolderTreeRenderer implements TreeitemRenderer<FolderTreeNode> {
	
	EventListener<Event> eventListener;
	 Vector<Checkbox> checkboxVector;
	
	public FolderTreeRenderer(EventListener<Event> eventListener,Vector<Checkbox> checkboxVector) {
		this.eventListener=eventListener;
		this.checkboxVector=checkboxVector;
	}

	@Override
	public void render(final Treeitem treeItem, FolderTreeNode treeNode, int index) throws Exception {
		FolderTreeNode ctn = treeNode;
		IFolder folder = (IFolder) ctn.getData();
		Treerow dataRow = new Treerow();
		dataRow.setParent(treeItem);
		treeItem.setValue(ctn);
		treeItem.setOpen(ctn.isOpen());

		if (!isFolder(folder)) { // Test Row
			Treecell treeCell=createTestTreecell(folder,treeItem,checkboxVector,dataRow);
			dataRow.setDraggable("true");
			dataRow.appendChild(treeCell);
			//dataRow.addEventListener(Events.ON_CLICK, eventListener);
		} else { // Folder Row
			
			Treecell treeCell=createFolderTreecell(folder,treeItem,checkboxVector,dataRow);
			dataRow.appendChild(treeCell);
			dataRow.setDraggable("true");
			//dataRow.addEventListener(Events.ON_CLICK, eventListener);
		}
		// Both category row and Folder row can be item dropped
		dataRow.setDroppable("true");
		dataRow.addEventListener(Events.ON_DROP, eventListener); 
	}

	public  Treecell createFolderTreecell(IFolder folder,Treeitem treeItem,Vector<Checkbox> checkboxVector,Treerow dataRow){
	
		Hlayout hl = new Hlayout();
		Checkbox checkbox= new Checkbox();
		checkbox.setAttribute("folder",folder);
		checkbox.setAttribute("treeItem", treeItem);
		checkboxVector.add(checkbox);
		hl.appendChild(checkbox);
		Label label=new Label(folder.getFolderName());
		label.setAttribute("dataRow", dataRow);
		label.addEventListener(Events.ON_CLICK, eventListener);
		hl.appendChild(label);
		hl.setSclass("h-inline-block");
		Treecell treeCell = new Treecell();
		treeCell.appendChild(hl);
		treeItem.setAttribute("label", label);
		
		return treeCell;
	}
	
	public  Treecell createTestTreecell(IFolder folder,Treeitem treeItem,Vector<Checkbox> checkboxVector,Treerow dataRow){
		
		Hlayout hl = new Hlayout();
		Checkbox checkbox= new Checkbox();
		checkbox.setAttribute("folder",folder);
		checkbox.setAttribute("treeItem", treeItem);
		checkboxVector.add(checkbox);
		hl.appendChild(checkbox);
		hl.appendChild(new Image("../../img/importpige.gif"));
		Label labelId=new Label("("+folder.getTestid()+")");
		hl.appendChild(labelId);
		Label label=new Label(folder.getTestName());
		label.setAttribute("dataRow", dataRow);
		label.addEventListener(Events.ON_CLICK, eventListener);
		hl.appendChild(label);
		hl.setSclass("h-inline-block");
		Treecell treeCell = new Treecell();
		treeCell.appendChild(hl);
		treeItem.setAttribute("label", label);
		return treeCell;
	}
	
	static public boolean isFolder(IFolder folder) {
		return folder.getTestid() == null;
	}
}