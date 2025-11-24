package com.jsantos.gui.objectselector.foldertree;

import java.util.ArrayList;

import org.zkoss.zul.DefaultTreeNode;

import com.jsantos.orm.dbstatement.IDetachedRecord;

public class FolderTreeNode extends DefaultTreeNode<IDetachedRecord> {
	private static final long serialVersionUID = -7012663776755277499L;

	private boolean open = false;

	public FolderTreeNode(IDetachedRecord data, ArrayList<FolderTreeNode> arrayList) {
		super(data, arrayList);
	}

	public FolderTreeNode(IDetachedRecord data, DefaultTreeNode<IDetachedRecord>[] children, boolean open) {
		super(data, children);
		setOpen(open);
	}

	public FolderTreeNode(IDetachedRecord data) {
		super(data);

	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

}
