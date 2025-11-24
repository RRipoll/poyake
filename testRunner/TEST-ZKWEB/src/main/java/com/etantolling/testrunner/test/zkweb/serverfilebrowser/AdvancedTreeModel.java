package com.etantolling.testrunner.test.zkweb.serverfilebrowser;

import java.io.File;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;

public class AdvancedTreeModel extends DefaultTreeModel<File> {
    private static final long serialVersionUID = -5513180500300189445L;
     
    DefaultTreeNode<File> _root;
 
    public AdvancedTreeModel(FileTreeNode fileTreeNode) {
        super(fileTreeNode);
        _root = fileTreeNode;
    }
 
    public void remove(DefaultTreeNode<File> parent, int indexFrom, int indexTo) throws IndexOutOfBoundsException {
    }
 
    public void remove(DefaultTreeNode<File> target) throws IndexOutOfBoundsException {
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
    public void insert(DefaultTreeNode<File> parent, int indexFrom, int indexTo, DefaultTreeNode<File>[] newNodes) throws IndexOutOfBoundsException {
        DefaultTreeNode<File> stn = parent;
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
    public void add(DefaultTreeNode<File> parent, DefaultTreeNode<File>[] newNodes) {
        DefaultTreeNode<File> stn = (DefaultTreeNode<File>) parent;
 
        for (int i = 0; i < newNodes.length; i++)
            stn.getChildren().add(newNodes[i]);
 
    }
 
    @SuppressWarnings("unused")
	private DefaultTreeNode<File> dfSearchParent(DefaultTreeNode<File> node, DefaultTreeNode<File> target) {
        if (node.getChildren() != null && node.getChildren().contains(target)) {
            return node;
        } else {
            int size = getChildCount(node);
            for (int i = 0; i < size; i++) {
                DefaultTreeNode<File> parent = dfSearchParent((DefaultTreeNode<File>) getChild(node, i), target);
                if (parent != null) {
                    return parent;
                }
            }
        }
        return null;
    }
 
}