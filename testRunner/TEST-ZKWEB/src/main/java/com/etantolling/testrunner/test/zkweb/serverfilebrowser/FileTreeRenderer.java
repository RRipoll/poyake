package com.etantolling.testrunner.test.zkweb.serverfilebrowser;

import java.io.File;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

public  class FileTreeRenderer implements TreeitemRenderer<FileTreeNode>,EventListener<Event> {
	
	boolean showOnlyFile=false;
	
	public FileTreeRenderer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileTreeRenderer(boolean showOnlyFile) {
		super();
		this.showOnlyFile=showOnlyFile;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(final Treeitem treeItem, FileTreeNode treeNode, int index) throws Exception {
		FileTreeNode ctn = treeNode;
		File file = (File) ctn.getData();
		Treerow dataRow = new Treerow();
		dataRow.setParent(treeItem);
		treeItem.setValue(ctn);
		treeItem.setOpen(ctn.isOpen());

		
		treeItem.setOpen(true);
		
		
		if (!file.isDirectory()) { 
			Hlayout hl = new Hlayout();
			A a = new A();
			a.setLabel(file.getName());
			a.setAttribute("file", file);
			a.addEventListener(Events.ON_CLICK, this);
			hl.appendChild(a);
			hl.setSclass("h-inline-block");
			Treecell treeCell = new Treecell();
			treeCell.appendChild(hl);
			
			dataRow.setDraggable("true");
			dataRow.appendChild(treeCell);
		} 
		else { 
			
			dataRow.appendChild(new Treecell(file.getName()));
		}
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if(null!=event.getTarget().getAttribute("file")){
				
			File file= (File) event.getTarget().getAttribute("file");
			Filedownload.save(file, "application/file");
			
		}
	}

	public boolean isShowOnlyFile() {
		return showOnlyFile;
	}

	public void setShowOnlyFile(boolean showOnlyFile) {
		this.showOnlyFile = showOnlyFile;
	}
}