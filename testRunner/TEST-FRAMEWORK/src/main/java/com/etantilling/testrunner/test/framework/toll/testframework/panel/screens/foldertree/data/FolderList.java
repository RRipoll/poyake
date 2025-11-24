package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.EventFolder;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.Folder;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder;
import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.tree.FolderTreeNode;
import com.etantolling.testrunner.test.core.db.DataGridQuery;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class FolderList {
	
	private FolderTreeNode root;
	private LinkedHashMap<String,FolderTreeNode > foldersTree= new LinkedHashMap<String,FolderTreeNode >();
	private Vector<IFolder>  folders= new Vector<IFolder>();
	DataGridQuery dgq;
	boolean isTestFolder=true;
	
	public FolderList(DataGridQuery dgq) throws SQLException {
		this.dgq=dgq;
		
		try(Connection conn= MainDb.getConnection();){
			
			String sql="SELECT  CASE WHEN PARENTFOLDERID IS NULL THEN 0 ELSE PARENTFOLDERID END PARENTFOLDERID ,FOLDERID ,DESCRIPTION FOLDERNAME ,FOLDERPATH ,NULL TESTID,NULL TESTNAME "
					+ "FROM FOLDERPATHS WHERE DELETED !=1  ";
			DataGridQuery dgqfolder= new DataGridQuery(conn, sql);
			dgqfolder.setOrderByField("FOLDERPATH", true);
			Vector<LinkedHashMap<String, Object>> rows=dgqfolder.getTotalResults(conn);
			root= new FolderTreeNode(null,new ArrayList<FolderTreeNode>());
			foldersTree.put("0", root );
			fillTree(rows);
			
			rows=dgq.getTotalResults(conn);
			fillTree(rows);
			
		}
	}
	
	public FolderList(DataGridQuery dgq,String sql) throws SQLException {
		this.dgq=dgq;
		isTestFolder=false;
		try(Connection conn= MainDb.getConnection();){
			DataGridQuery dgqfolder= new DataGridQuery(conn, sql);
			dgqfolder.setOrderByField("FOLDERPATH", true);
			Vector<LinkedHashMap<String, Object>> rows=dgqfolder.getTotalResults(conn);
			root= new FolderTreeNode(null,new ArrayList<FolderTreeNode>());
			foldersTree.put("0", root );
			fillTree(rows);
			rows=dgq.getTotalResults(conn);
			fillTree(rows);
		}
	}
	
	
	void fillTree(Vector<LinkedHashMap<String, Object>> rows){
		
		for (LinkedHashMap<String, Object> row:rows){
			
			if(null==row.get("PARENTFOLDERID"))continue;
			String parentFolderId=((Integer) row.get("PARENTFOLDERID")).toString();
			String folderId=((Integer)row.get("FOLDERID")).toString();
			
			if(!foldersTree.containsKey(folderId)){
			  IFolder parent;
			  if(isTestFolder)
				  parent= new Folder((String)row.get("FOLDERNAME"),(Integer)row.get("FOLDERID"),(Integer)row.get("PARENTFOLDERID"));
			  else 
				  parent= new EventFolder((String)row.get("FOLDERNAME"),(Integer)row.get("FOLDERID"),(Integer)row.get("PARENTFOLDERID"));

			  FolderTreeNode node=new FolderTreeNode(parent,new ArrayList<FolderTreeNode>());
			  if(((Integer) row.get("PARENTFOLDERID"))!=1)
				  node.setOpen(true);
			  else 
				  node.setOpen(false);
			  FolderTreeNode parentnode= foldersTree.get(parentFolderId.toString());
			  parentnode.getChildren().add( node);
			  foldersTree.put(folderId, node);
			}else{
				IFolder fol = null;
				if(isTestFolder)		
					fol =new Folder((Integer)row.get("FOLDERID"),(Integer)row.get("TESTID"),(String)row.get("TESTNAME"));
				else 
					fol =new EventFolder((Integer)row.get("FOLDERID"),(Integer)row.get("TESTID"),(String)row.get("TESTNAME"));
				folders.add(fol);
				foldersTree.get(folderId).add(new FolderTreeNode(fol));
				}
			}
	}
	
	
	public FolderTreeNode getRoot() {
		return root;
	}
}
