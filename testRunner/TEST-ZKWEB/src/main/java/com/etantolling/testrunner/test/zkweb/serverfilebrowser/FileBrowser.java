package com.etantolling.testrunner.test.zkweb.serverfilebrowser;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Div;
import org.zkoss.zul.Tree;


public class FileBrowser extends Div implements EventListener<Event> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	File rootFolder;

	private AdvancedTreeModel fileTreeModel;
	private Tree tree;
	private FilenameFilter filter=null;
	
	public FileBrowser(File rootFolder,FilenameFilter filter) throws Exception {
		this.filter=filter;
		
		tree= new Tree();
		if(null==filter) filter= new defaultFilter();
		fileTreeModel = new AdvancedTreeModel(buildTreeRecursive(rootFolder,filter));
		
		tree.setItemRenderer(new FileTreeRenderer(true));
		tree.setModel(fileTreeModel);
		tree.setParent(this);
	}

	public static FileTreeNode buildTreeRecursive(File parent,FilenameFilter filter) {
		File[] children = parent.listFiles(filter);
		ArrayList<FileTreeNode> childrenNodes = new ArrayList<FileTreeNode>();
		if (null != children) {
			Arrays.sort(children);
			for (File file : children)
				childrenNodes.add(buildTreeRecursive(file,filter));
			return new FileTreeNode(parent, childrenNodes.toArray(new FileTreeNode[childrenNodes.size()]));
		} 
		else
			return new FileTreeNode(parent);
	}

	/**
	 * The structure of tree
	 * 
	 * <pre>
	 * &lt;treeitem>
	 *   &lt;treerow>
	 *     &lt;treecell>...&lt;/treecell>
	 *   &lt;/treerow>
	 *   &lt;treechildren>
	 *     &lt;treeitem>...&lt;/treeitem>
	 *   &lt;/treechildren>
	 * &lt;/treeitem>
	 * </pre>
	 */
	
	
	private class defaultFilter implements FilenameFilter {

		@Override
		public boolean accept(File arg0, String arg1) {
			return true;
		}
		
	}

	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public FilenameFilter getFilter() {
		return filter;
	}

	public void setFilter(FilenameFilter filter) {
		this.filter = filter;
	}
	
	
	
}