package com.jsantos.gui.objectselector.foldertree;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.jsantos.common.util.ListValues;
import com.jsantos.orm.dbstatement.DQResults;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class FolderList {

	private FolderTreeNode root;
	private LinkedHashMap<String, FolderTreeNode> foldersTree = new LinkedHashMap<String, FolderTreeNode>();
	DetachedQueryResult dgq;
	
	MTField parentFolder = null;
	MTField folder = null;
	MTField item = null;
	MTField description=null;

	public FolderList(DetachedQueryResult dgq) throws SQLException {
		this.dgq = dgq;

		root = new FolderTreeNode(null, new ArrayList<FolderTreeNode>());
		foldersTree.put("0", root);

		DQResults<IDetachedRecord> rows = dgq.getPage(null);

		for (MTField field : dgq.getmTTable().getFields()) {
			if (field.getStereoTypes().contains("PARENTFOLDER")) {
				parentFolder = field;
			}
			if (field.getStereoTypes().contains("FOLDER")) {
				folder = field;
			}
			if (field.getStereoTypes().contains("ITEM")) {
				item = field;
			}
			if (field.getStereoTypes().contains("DESCRIPTION")) {
				description = field;
			}
		}
		fillTree(rows);
	}

	void fillTree(DQResults<IDetachedRecord> rows) {

		ListValues<IDetachedRecord> rowsOrderned= getOrder(rows.getRawData());
		
		for (IDetachedRecord row : rowsOrderned) {
			
			createTreeNode(row);
			
		}
	}

	public  void createTreeNode(IDetachedRecord row) {
		
		Object parentFolderId = row.get(parentFolder);
		if(null==parentFolderId)parentFolderId="0";
	
		Object folderId = row.get(folder);

		if (!foldersTree.containsKey(folderId)) {
			FolderTreeNode node = new FolderTreeNode(row, new ArrayList<FolderTreeNode>());
			FolderTreeNode parentnode = foldersTree.get(parentFolderId);
			parentnode.getChildren().add(node);
			foldersTree.put(folderId.toString(), node);
		} else {
			foldersTree.get(folderId).add(new FolderTreeNode(row));
		}
	}
	
	public  void deleteTreeNode(IDetachedRecord row) {
		
		foldersTree.remove(row.get(folder));
		
	}
	
	
	private ListValues<IDetachedRecord> getOrder(ListValues<IDetachedRecord> rawData) {
		
		ListValues<IDetachedRecord> retValues= new ListValues<>();
		ListValues<String> parentIndex=new ListValues<>();
		
		int i=0;
		while (i<rawData.size()) {
			IDetachedRecord dr= rawData.get(i);
			if(retValues.isEmpty()) {
				retValues.add(dr);
				parentIndex.add(dr.get(folder).toString());
			}else if(!retValues.contains(dr)) {
				if(parentIndex.contains(dr.get(parentFolder).toString())) {
					retValues.add(dr);
					parentIndex.add(dr.get(folder).toString());
				}else {
					rawData.add(dr);
				}
			}
			i++;
		}
		return retValues;
	}
	
	public FolderTreeNode getRoot() {
		return root;
	}
	
	public MTField getParentFolder() {
		return parentFolder;
	}

	public void setParentFolder(MTField parentFolder) {
		this.parentFolder = parentFolder;
	}

	public MTField getFolder() {
		return folder;
	}

	public void setFolder(MTField folder) {
		this.folder = folder;
	}

	public MTField getItem() {
		return item;
	}

	public void setItem(MTField item) {
		this.item = item;
	}

}
