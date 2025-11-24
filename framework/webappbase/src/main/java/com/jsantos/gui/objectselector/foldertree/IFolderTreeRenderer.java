package com.jsantos.gui.objectselector.foldertree;

import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

import com.jsantos.orm.dbstatement.IDetachedRecord;

public interface IFolderTreeRenderer<T> extends TreeitemRenderer<T>{

	void render(Treeitem treeItem, T treeNode, int index) throws Exception;

	Treecell renderFolder(IDetachedRecord folder, Treeitem treeItem, Treerow dataRow);

	Treecell renderItem(IDetachedRecord folder, Treeitem treeItem, Treerow dataRow);

	boolean isFolder(IDetachedRecord folder);

}