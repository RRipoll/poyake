package com.jsantos.gui.objectselector.foldertree;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Image;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.datagrid4.IEntity;
import com.jsantos.gui.datagrid4.ISelectionMan;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class FolderTreeRenderer implements IFolderTreeRenderer<FolderTreeNode>   {

	EventListener<Event> eventListener;
	
	MTField parentFolder;
	MTField folder;
	MTField item;
	MTField folderDescription;
	SettingDTO itemSetting;
	SettingDTO folderSetting;
	ISelectionMan<Treeitem> selectionMan;
	
	public FolderTreeRenderer(EventListener<Event> eventListener, TreeSelectionMan selectionMan, MTTable mtTable) {
		this.eventListener = eventListener;
		this.selectionMan = selectionMan;

		for (MTField field : mtTable.getFields()) {
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
				folderDescription = field;
			}
		}
	}

	@Override
	public void render(final Treeitem treeItem, FolderTreeNode treeNode, int index) throws Exception {
		
		if (null==itemSetting) 
			itemSetting=DesktopHelper.getSetting(item.getForeignKey().getTableName(),  DesktopHelper.getInputUserId(), LocaleFactory.getProvider().getLocale());
		if (null==folderSetting) 
			folderSetting=DesktopHelper.getSetting(item.getTableName(),  DesktopHelper.getInputUserId(), LocaleFactory.getProvider().getLocale());
		
		IDetachedRecord folder = (IDetachedRecord) treeNode.getData();
		Treerow dataRow = new Treerow();
		dataRow.setParent(treeItem);
		
		treeItem.setValue(treeNode);
		treeItem.setOpen(treeNode.isOpen());
		Treecell treeCell=null;
		if (!isFolder(folder)) { // Test Row
			 treeCell = renderItem(folder, treeItem, dataRow);
		} else { // Folder Row
			 treeCell = renderFolder(folder, treeItem, dataRow);
		}
		// Both category row and Folder row can be item dropped
		dataRow.setDraggable("true");
		dataRow.appendChild(treeCell);
		dataRow.addEventListener(CustomEvents.ON_ROWCLICK,eventListener);
		dataRow.addEventListener(Events.ON_CLICK, event -> Events.sendEvent(CustomEvents.ON_ROWCLICK, dataRow,dataRow));
		dataRow.setDroppable("true");
		dataRow.addEventListener(Events.ON_DROP, eventListener);
		dataRow.addEventListener(CustomEvents.ON_IMGCLICK, eventListener);
	}
	
	

	@Override
	public Treecell renderFolder(IDetachedRecord folder, Treeitem treeItem, Treerow dataRow) {
		
		Hlayout hl = new Hlayout();
		Checkbox checkbox=selectionMan.buildSelectorColumn(hl,treeItem,null);
		IEntity treeEntity=new TreeEntity(folderSetting);
		Component builder=new Div();
		treeEntity.build(builder, folder).setParent(hl);
		
		hl.setSclass("h-inline-block");
		Treecell treeCell = new Treecell();
		treeCell.appendChild(hl);
		dataRow.setAttribute("folder", folder);
		dataRow.setAttribute("treeItem", treeItem);
		dataRow.setAttribute("checkbox", checkbox);
		dataRow.setAttribute("item",null );
		dataRow.setAttribute("builder", builder);
		dataRow.setAttribute("rowEntity", treeEntity);
		return treeCell;
	}
	@Override
	public Treecell renderItem(IDetachedRecord folder, Treeitem treeItem,			Treerow dataRow) {
		Treecell treeCell = new Treecell();
		IDetachedRecord itemobject = new DetachedRecord(item.getForeignKey()).findByPk(folder.get(item));
		Hlayout hl = new Hlayout();
		Image img=new Image("~./common/img/importpige.gif");
		hl.appendChild(img);
		img.addEventListener(Events.ON_CLICK, event ->Events.sendEvent(CustomEvents.ON_IMGCLICK, dataRow,dataRow));
		
		Checkbox checkbox=selectionMan.buildSelectorColumn(hl,treeItem,null);
		
		IEntity treeEntity=new TreeEntity(itemSetting);
		Component builder=new Div();
		treeEntity.build(builder, itemobject).setParent(hl);
		hl.setSclass("h-inline-block");
		
		treeCell.appendChild(hl);
		dataRow.setAttribute("folder", folder);
		dataRow.setAttribute("item",itemobject );
		dataRow.setAttribute("treeItem", treeItem);
		dataRow.setAttribute("checkbox", checkbox);
		dataRow.setAttribute("builder", builder);
		dataRow.setAttribute("rowEntity", treeEntity);
		return treeCell;
	}
	@Override
	public boolean isFolder(IDetachedRecord folder) {
		return folder.get(item) == null;
	}

	public ISelectionMan<Treeitem> getSelectionMan() {
		return selectionMan;
	}

	public void setSelectionMan(ISelectionMan<Treeitem> selectionMan) {
		this.selectionMan = selectionMan;
	}

	public SettingDTO getItemSetting() {
		return itemSetting;
	}

	public void setItemSetting(SettingDTO itemSetting) {
		this.itemSetting = itemSetting;
	}

	public SettingDTO getFolderSetting() {
		return folderSetting;
	}

	public void setFolderSetting(SettingDTO folderSetting) {
		this.folderSetting = folderSetting;
	}
}