package com.jsantos.gui.objectselector.foldertree;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Treeitem;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.datagrid4.IEntity;
import com.jsantos.gui.detail.DetailContainerProvider;
import com.jsantos.orm.DBTransaction;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class DefaultTreeEventListener implements EventListener<Event>, ITreeeventListener{

	protected TreeController tree;
	
	public DefaultTreeEventListener(TreeController treeController) {
		tree=treeController;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if (event.getName().equals(CustomEvents.ON_IMGCLICK)) {
			onImgClick(event);
		}

		else if (event.getName().equals(Events.ON_CLICK) ) {

			onDetail(event);
			
		} else if (event.getName().equals(Events.ON_DROP)) {
			onDrop(event);
		}else if( event.getName().equals(CustomEvents.ON_ROWCLICK)) {
			onRowClick(event);
		}
			
	}
	
	@Override
	public void onRowClick(Event event) {
		onDetail(event);
	}
	
	
	@Override
	public void onDetail(Event event) {
		if (!PermissionFactory.getProvider().hasAnyPermission(tree.getPermissionValue()))
			return;
		try {
			IDetachedRecord dr = (IDetachedRecord) event.getTarget().getAttribute("folder");
			MTField itemField = TreeHelper.getItemField(dr.getTable());
			MTTable tTable = tree.getMtTable();

			if (null != dr.get(itemField)) {
				tTable = itemField.getForeignKey();
				dr = DTOFactory.get(tTable).findByPk(dr.get(itemField));
			
				IDetailContainer container = DetailContainerProvider.getDetailContainer(tTable);
				container.setDetachedRecord(dr);
				container.setParent(tree.getParent());
				container.buildAndShowComponent(EditMode.AUTO);

				IEntity rowEntity = (IEntity) event.getTarget().getAttribute("rowEntity");
				Component builder = (Component) event.getTarget().getAttribute("builder");
				rowEntity.build(builder, container.getDetachedRecord());
				//builder.invalidate();
			
			}else {
				Treeitem treeItem=    (Treeitem) event.getTarget().getAttribute("treeItem");
				treeItem.setOpen(!treeItem.isOpen());
			}
			
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null,
						2000);
			else
				throw ex;
		}
		
	}
		
	
	
	@Override
	public void onDrop(Event event) {
		Treeitem draggedItem = (Treeitem) ((DropEvent) event).getDragged().getParent();
		FolderTreeNode draggedValue = (FolderTreeNode) draggedItem.getValue();
		IDetachedRecord draggedDR = draggedValue.getData();

		Treeitem dropItem = (Treeitem) event.getTarget().getParent();
		FolderTreeNode dropValue = (FolderTreeNode) dropItem.getValue();
		IDetachedRecord dropDR = dropValue.getData();

		draggedDR.set(TreeHelper.getParentFolderField(draggedDR.getTable()),
				dropDR.get(TreeHelper.getFolderField(dropDR.getTable())));
		draggedDR.update();

		tree.getFolderTreeModel().remove(draggedValue);
		int index = 0;
		tree.getFolderTreeModel().insert(dropValue, index, index, new DefaultTreeNode[] { draggedValue });

	
	}
	
	
	@Override
	public void onImgClick(Event event) {
		
		Events.sendEvent(CustomEvents.ON_IMGCLICK, tree.getTopParent(), event.getData());
		
	}
	
	@Override
	public void onDelete(Event event) {
		if (tree.getSelectionMan().getSelectionCount() == 0) {
			Clients.showNotification("Please, Select a Parent Node", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			return;
		}
		Treeitem treeitem = tree.getSelectionMan().getSingleSelectedKey();
		FolderTreeNode folderTreeNonde = (FolderTreeNode) treeitem.getValue();
		IDetachedRecord folder = folderTreeNonde.getData();
		MTField itemField = TreeHelper.getItemField(folder.getTable());
		new DBTransaction() {
			@Override
			protected void exec() {
				folder.delete();

				if (null != folder.get(itemField)) {
					IDetachedRecord item = DTOFactory.get(itemField.getForeignKey());
					item.set(item.getTable().getPrimaryKey(), folder.get(itemField));
					item.delete();
				}
				tree.getFolderList().deleteTreeNode(folder);
				tree.getFolderTreeModel().remove(folderTreeNonde);
			}
		}.run();

		tree.getSelectionMan().clear();
	}
	
	
	@Override
	public void onEdit(Event event) {
		if (tree.getSelectionMan().getSelectionCount() == 0) {
			Clients.showNotification("Please, Select a Parent Node", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			return;
		}
		Treeitem treeitem = tree.getSelectionMan().getSingleSelectedKey();
		FolderTreeNode folderTreeNonde = (FolderTreeNode) treeitem.getValue();
		IDetachedRecord folder = folderTreeNonde.getData();
		MTField itemField = TreeHelper.getItemField(folder.getTable());
		IDetailContainer container=null;
		if (null != folder.get(itemField)) {
			MTTable tTable = itemField.getForeignKey();
			IDetachedRecord   dr = DTOFactory.get(tTable).findByPk(folder.get(itemField));
		
			container = DetailContainerProvider.getDetailContainer(tTable);
			container.setDetachedRecord(dr);
			container.setParent(tree.getParent());
			container.buildAndShowComponent(EditMode.AUTO);
			if(!container.isCancelled()) {
				IDetachedRecord dr2=container.getDetachedRecord();
				if(!dr.getPk().toString().equals(dr2.getPk().toString()))
						tree.getFolderList().createTreeNode(dr2);
			}
		}else {
			MTTable tTable = folder.getTable();
			IDetachedRecord   dr = DTOFactory.get(tTable).findByPk(folder.getPk());
		
			container = DetailContainerProvider.getDetailContainer(tTable);
			container.setDetachedRecord(dr);
			container.setParent(tree.getParent());
			container.buildAndShowComponent(EditMode.AUTO);
		}
			IEntity rowEntity = (IEntity) event.getTarget().getAttribute("rowEntity");
			Component builder = (Component) event.getTarget().getAttribute("builder");
			if(null!=rowEntity)
				rowEntity.build(builder, container.getDetachedRecord());
		
			tree.getSelectionMan().clear();
	}

	@Override
	public void onAddItem(Event event) {
		if (tree.getSelectionMan().getSelectionCount() == 0) {
			Clients.showNotification("Please, Select a Parent Node", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			return;
		}
		Treeitem treeitem = tree.getSelectionMan().getSingleSelectedKey();
		FolderTreeNode folderTreeNonde = (FolderTreeNode) treeitem.getValue();
		IDetachedRecord folder = folderTreeNonde.getData();

		if (!PermissionFactory.getProvider().canWrite(tree.getPermissionValue()))
			return;
		IDetailContainer container = DetailContainerProvider
				.getDetailContainer(TreeHelper.getItemField(folder.getTable()).getForeignKey());
		container.setParent(tree.getParent());
		// container.setFormSerialize(new DoNothingFormSerializer());
		container.buildAndShowComponent(EditMode.INSERT);
		if (null == container || container.isCancelled())
			return;
		IDetachedRecord newItem = container.getDetachedRecord();

		IDetachedRecord newFolder = DTOFactory.get(folder.getTable());
		newFolder.set(TreeHelper.getParentFolderField(folder.getTable()), folder.getPk());
		newFolder.set(TreeHelper.getItemField(folder.getTable()), newItem.getPk());
		newFolder.insert();

		tree.getFolderList().createTreeNode(newFolder);
		tree.getSelectionMan().clear();
	}

	@Override
	public void onAddFolder(Event event) {
		if (tree.getSelectionMan().getSelectionCount() == 0) {
			Clients.showNotification("Please, Select a Parent Node", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			return;
		}
		Treeitem treeitem = tree.getSelectionMan().getSingleSelectedKey();
		FolderTreeNode folderTreeNonde = (FolderTreeNode) treeitem.getValue();
		IDetachedRecord folder = folderTreeNonde.getData();

		if (!PermissionFactory.getProvider().canWrite(tree.getPermissionValue()))
			return;
		IDetailContainer container = DetailContainerProvider.getDetailContainer(folder.getTable());
		container.setParent(tree.getParent());

		MapValues<Object> initialParameters = new MapValues<Object>()
				.add(TreeHelper.getParentFolderField(folder.getTable()).getName(), folder.getPk());

		container.setInitialParameters(initialParameters);
		container.buildAndShowComponent(EditMode.INSERT);
		if (null == container || container.isCancelled())
			return;

		tree.getFolderList().createTreeNode(container.getDetachedRecord());
		tree.getSelectionMan().clear();
	}
}
