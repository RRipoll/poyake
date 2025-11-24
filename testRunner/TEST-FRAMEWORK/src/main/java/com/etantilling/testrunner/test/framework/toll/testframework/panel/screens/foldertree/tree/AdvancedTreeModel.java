package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;

import com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.foldertree.data.pojo.IFolder;



public class AdvancedTreeModel extends DefaultTreeModel<IFolder> {
	private static final long serialVersionUID = -5513180500300189445L;
	
	private static final Logger logger = LoggerFactory.getLogger(AdvancedTreeModel.class);
	
	DefaultTreeNode<IFolder> _root;

	public AdvancedTreeModel(FolderTreeNode folderTreeNode) {
		super(folderTreeNode);
		_root = folderTreeNode;
	}

	/**
	 * remove the nodes which parent is <code>parent</code> with indexes
	 * <code>indexes</code>
	 * 
	 * @param parent
	 *            The parent of nodes are removed
	 * @param indexFrom
	 *            the lower index of the change range
	 * @param indexTo
	 *            the upper index of the change range
	 * @throws IndexOutOfBoundsException
	 *             - indexFrom < 0 or indexTo > number of parent's children
	 */
	public void remove(DefaultTreeNode<IFolder> parent, int indexFrom, int indexTo) throws IndexOutOfBoundsException {
		DefaultTreeNode<IFolder> stn = parent;
		for (int i = indexTo; i >= indexFrom; i--)
			try {
				stn.getChildren().remove(i);
			} catch (Exception exp) {
				logger.error("ERROR STACKTRACE:",exp);
			}
	}

	public void remove(DefaultTreeNode<IFolder> target) throws IndexOutOfBoundsException {
		int index = 0;
		DefaultTreeNode<IFolder> parent = null;
		// find the parent and index of target
		parent = dfSearchParent(_root, target);
		for (index = 0; index < parent.getChildCount(); index++) {
			if (parent.getChildAt(index).equals(target)) {
				break;
			}
		}
		remove(parent, index, index);
	}

	/**
	 * insert new nodes which parent is <code>parent</code> with indexes
	 * <code>indexes</code> by new nodes <code>newNodes</code>
	 * 
	 * @param parent
	 *            The parent of nodes are inserted
	 * @param indexFrom
	 *            the lower index of the change range
	 * @param indexTo
	 *            the upper index of the change range
	 * @param newNodes
	 *            New nodes which are inserted
	 * @throws IndexOutOfBoundsException
	 *             - indexFrom < 0 or indexTo > number of parent's children
	 */
	public void insert(DefaultTreeNode<IFolder> parent, int indexFrom, int indexTo, DefaultTreeNode<IFolder>[] newNodes)
			throws IndexOutOfBoundsException {
		DefaultTreeNode<IFolder> stn = parent;
		for (int i = indexFrom; i <= indexTo; i++) {
			try {
				stn.getChildren().add(i, newNodes[i - indexFrom]);
			} catch (Exception exp) {
				throw new IndexOutOfBoundsException("Out of bound: " + i + " while size=" + stn.getChildren().size());
			}
		}
	}

	/**
	 * append new nodes which parent is <code>parent</code> by new nodes
	 * <code>newNodes</code>
	 * 
	 * @param parent
	 *            The parent of nodes are appended
	 * @param newNodes
	 *            New nodes which are appended
	 */
	public void add(DefaultTreeNode<IFolder> parent, DefaultTreeNode<IFolder>[] newNodes) {
		DefaultTreeNode<IFolder> stn = (DefaultTreeNode<IFolder>) parent;

		for (int i = 0; i < newNodes.length; i++)
			stn.getChildren().add(newNodes[i]);

	}

	private DefaultTreeNode<IFolder> dfSearchParent(DefaultTreeNode<IFolder> node, DefaultTreeNode<IFolder> target) {
		if (node.getChildren() != null && node.getChildren().contains(target)) {
			return node;
		} else {
			int size = getChildCount(node);
			for (int i = 0; i < size; i++) {
				DefaultTreeNode<IFolder> parent = dfSearchParent((DefaultTreeNode<IFolder>) getChild(node, i), target);
				if (parent != null) {
					return parent;
				}
			}
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

	
/*
	String getEventFolderPath(java.sql.Connection con, Integer currentNodeId) throws Exception {     
		if( null==currentNodeId ) return null;
		     String buff = "";
		     java.sql.ResultSet rs = con.createStatement().executeQuery(" SELECT description,parentfolderid  FROM eventdeffolder WHERE DELETED=0 AND startdate<current_date() and ENDDATE>current_time() and   eventdeffolderid = " + currentNodeId); 
		     if(rs.next()){  
		    	 String parent=getEventFolderPath(con,rs.getInt("parentfolderid"));  
		    	 buff=    (null==parent?"":parent+"") +       (null==rs.getString("description")?"":rs.getString("description"));
		    	 }return buff;
		    	 }
		     }
	}

	
	String getFolderPath(java.sql.Connection con, Integer currentNodeId) throws Exception {        
		if( null==currentNodeId || currentNodeId==0) return null;
			String buff = "";
			java.sql.ResultSet rs = con.createStatement().executeQuery(" SELECT description,parentfolderid  FROM folder WHERE folderid = " + currentNodeId); 
			if(rs.next()){                  
				String parent=getFolderPath(con,rs.getInt("parentfolderid"));  
				buff=    (null==parent?"":parent+"/") +       (null==rs.getString("description")?"":rs.getString("description"));
				}return buff;}       
			}
	}
*/
	
	
}
