package com.jsantos.metadata.plugin.ui.grapheditor.operations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.jsantos.metadata.plugin.ui.grapheditor.GraphEditorPart;

public class Document implements Serializable{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Operation> operations = new ArrayList<>();
	GraphEditorPart editor;
	boolean dirty = false;

	public Document(GraphEditorPart editor) {
		this.editor = editor;
	}

	public void addOperation(Operation operation) {
		operations.add(operation);
		dirty = true;

	}

	public boolean isDirty() {
		return dirty;
	}

	public void deserialize(InputStream in) throws IOException ,ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream( in);
		operations  = (ArrayList<Operation>)ois.readObject();
		ois.close();
	}

	public InputStream serialize( ) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream( baos );
		oos.writeObject(operations);
		oos.close();
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	public String toString() {
		return operations.toString();
	}
}
