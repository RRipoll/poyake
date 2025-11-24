package com.etantolling.testrunner.test.zkweb.serverfilebrowser;

import java.io.File;

import org.zkoss.zul.DefaultTreeNode;

public class FileTreeNode extends DefaultTreeNode<File> {
    private static final long serialVersionUID = -7012663776755277499L;
     
    private boolean open = false;
 
    public FileTreeNode(File data, DefaultTreeNode<File>[] children) {
        super(data, children);
    }
 
    public FileTreeNode(File data, DefaultTreeNode<File>[] children, boolean open) {
        super(data, children);
        setOpen(open);
    }
 
    public FileTreeNode(File data) {
        super(data);
 
    }
 
    public boolean isOpen() {
        return open;
    }
 
    public void setOpen(boolean open) {
        this.open = open;
    }
 
}