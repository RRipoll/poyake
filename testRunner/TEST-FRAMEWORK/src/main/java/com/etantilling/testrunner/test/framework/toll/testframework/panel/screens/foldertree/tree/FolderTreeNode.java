package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.tree;

import java.util.ArrayList;

import org.zkoss.zul.DefaultTreeNode;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder;




public class FolderTreeNode extends DefaultTreeNode<IFolder> {
	private static final long serialVersionUID = -7012663776755277499L;
	
	private boolean open = false;

	public FolderTreeNode(IFolder data, ArrayList<FolderTreeNode> arrayList) {
		super(data, arrayList);
	}

	public FolderTreeNode(IFolder data, DefaultTreeNode<IFolder>[] children, boolean open) {
		super(data, children);
		setOpen(open);
	}

	public FolderTreeNode(IFolder data) {
		super(data);

	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

}
