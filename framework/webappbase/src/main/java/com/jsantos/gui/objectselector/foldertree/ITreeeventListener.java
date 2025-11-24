package com.jsantos.gui.objectselector.foldertree;

import org.zkoss.zk.ui.event.Event;

public interface ITreeeventListener {

	void onEvent(Event event) throws Exception;

	void onRowClick(Event event);

	void onDetail(Event event);

	void onDrop(Event event);

	void onImgClick(Event event);

	void onDelete(Event event);

	void onEdit(Event event);

	void onAddItem(Event event);

	void onAddFolder(Event event);

}