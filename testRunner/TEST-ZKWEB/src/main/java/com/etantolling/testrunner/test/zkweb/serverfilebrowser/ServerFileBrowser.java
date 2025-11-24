package com.etantolling.testrunner.test.zkweb.serverfilebrowser;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.A;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;


public class ServerFileBrowser extends SelectorComposer<Component> {
	private static final long serialVersionUID = 3814570327995355261L;
	File rootFolder;

	@Wire
	private Window demoWindow;
	@Wire
	private Tree tree;

	private AdvancedTreeModel fileTreeModel;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		rootFolder = new File(EnvironmentHelper.getNasshareFileSystemPath() + "/specs");
		fileTreeModel = new AdvancedTreeModel(buildTreeRecursive(rootFolder));
		tree.setItemRenderer(new FileTreeRenderer());
		tree.setModel(fileTreeModel);
	}

	FileTreeNode buildTreeRecursive(File parent) {
		File[] children = parent.listFiles(new FilenameFilter() {
			public boolean accept(File directory, String fileName) {
				return !fileName.endsWith(".svn");
			}
		});
		ArrayList<FileTreeNode> childrenNodes = new ArrayList<FileTreeNode>();
		if (null != children) {
			Arrays.sort(children);
			for (File file : children)
				childrenNodes.add(buildTreeRecursive(file));
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
	private final class FileTreeRenderer implements TreeitemRenderer<FileTreeNode> {
		@Override
		public void render(final Treeitem treeItem, FileTreeNode treeNode, int index) throws Exception {
			FileTreeNode ctn = treeNode;
			File file = (File) ctn.getData();
			Treerow dataRow = new Treerow();
			dataRow.setParent(treeItem);
			treeItem.setValue(ctn);
			treeItem.setOpen(ctn.isOpen());

			if (!file.isDirectory()) { 
				Hlayout hl = new Hlayout();
				A a = new A();
				a.setLabel(file.getName());

				String href = "/nasshare/specs/" + file.getCanonicalPath().substring(file.getCanonicalPath().indexOf("/specs/")  + "/specs/".length(), file.getCanonicalPath().length());
				a.setHref(href);
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

	}
}
