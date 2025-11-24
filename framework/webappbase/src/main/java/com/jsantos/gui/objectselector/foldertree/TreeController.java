package com.jsantos.gui.objectselector.foldertree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Label;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treeitem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsantos.common.util.FileLoader;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MetadataUtil;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.datagrid4.GridSelectorType;
import com.jsantos.gui.filteredgrid.CustomFilteredGrid;
import com.jsantos.gui.zKpermission.Permission;
import com.jsantos.gui.zkutil.ButtonCssClass;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTTable;
/**
 * @author raul ripoll
 */
public class TreeController {

	private Component window;
	private Tree tree;
	private AdvancedTreeModel folderTreeModel;
	Popup menuPopup;

	private Component parent;
	private Component topParent;
	private MTTable mtTable;
	private FolderList folderList;
	private Integer permissionValue;
	private TreeSelectionMan selectionMan;
	private String sHeaderLabel;
	private Div headerDiv;
	private Label headerLabel;
	DetachedQueryResult dqr;
	ITreeeventListener eventListener= new DefaultTreeEventListener(this);
	
	public TreeController(MTTable mtTable, Component topParent, TreeSelectionMan selectionMant) throws Exception {
		this.topParent = topParent;
		this.parent = topParent;
		this.mtTable = mtTable;

		if (null != selectionMant)
			this.selectionMan = selectionMant;
		else
			this.selectionMan = new TreeSelectionMan(GridSelectorType.RADIO);

		if (this.selectionMan.getSelectedtype() == GridSelectorType.RADIO) {
			Radiogroup radiogroup = new Radiogroup();
			radiogroup.setParent(topParent);
			parent = radiogroup;
		}

		String URI = "~./common/zul/standardeditscreen/folder_tree.zul";

		window = Executions.createComponents(URI, parent, null);

		tree = (Tree) window.getFellow("tree");

		tree.getChildren().clear();
		
		permissionValue = Permission.getPermissionByShortCode(mtTable.getFullTableName());
		
		if (PermissionFactory.getProvider().canWrite(permissionValue)) {
			addHeaderButton(Zklabel.getLabel("delete"), ButtonCssClass.COLOR_DANGER).addEventListener(Events.ON_CLICK,
					eventListener::onDelete);
			addHeaderButton(Zklabel.getLabel("add "+TreeHelper.getItemField(mtTable).getForeignKey().getTableName()), ButtonCssClass.COLOR_PRIMARY).addEventListener(Events.ON_CLICK,
					eventListener::onAddItem);
			addHeaderButton(Zklabel.getLabel("add Folder"), ButtonCssClass.COLOR_PRIMARY).addEventListener(Events.ON_CLICK,
					eventListener::onAddFolder);
			addHeaderButton(Zklabel.getLabel("edit"), ButtonCssClass.COLOR_PRIMARY).addEventListener(Events.ON_CLICK,
					eventListener::onEdit);
		}

		window.getFellow("DROPDOWN_MENU").addEventListener(Events.ON_CLICK, this::popupMenu);
		menuPopup = (Popup) window.getFellow("DROPDOWN_MENU_POPUP");
		sHeaderLabel = Zklabel.getLabel(mtTable.getTableName(), LocaleFactory.getProvider().getLocale());
		headerDiv = (Div) window.getFellow("HEADER_DIV");
		headerLabel = ((Label) window.getFellowIfAny("HEADER_LABEL"));
		if (DesktopHelper.isConfEditable()) {
			window.getFellow("CONF_EDITABLE").setVisible(true);
			window.getFellow("CONF_FOLDER_BUTTON").addEventListener(Events.ON_CLICK, this::customFolder);
			window.getFellow("CONF_ITEM_BUTTON").addEventListener(Events.ON_CLICK, this::customItem);
		} else
			window.getFellow("CONF_EDITABLE").setVisible(false);
		if (mtTable.getStereotypes().contains("CONFIG")) {
			window.getFellow("METADATA").setVisible(true);
			window.getFellow("METADATA_BUTTON").addEventListener(Events.ON_CLICK, this::getMetadataData);
			;
		} else
			window.getFellow("METADATA").setVisible(false);
	
		 dqr = new DetachedQueryResult(mtTable);
	
	}

	void popupMenu(Event evt) {
		menuPopup.setParent(evt.getTarget());
		menuPopup.open(evt.getTarget(), "overlap");
	}

	public void customFolder(Event event) {
		CustomFilteredGrid filterGrid = new CustomFilteredGrid(parent, mtTable.getTableName());
		try {
			filterGrid.jsonEditor();

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		menuPopup.detach();
	}

	public void customItem(Event event) {
		CustomFilteredGrid filterGrid = new CustomFilteredGrid(parent,
				TreeHelper.getItemField(mtTable).getForeignKey().getTableName());
		try {
			filterGrid.jsonEditor();

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		menuPopup.detach();
	}

	public void render() throws SQLException {
		tree.getChildren().clear();
		headerLabel.setValue(sHeaderLabel);
		

		folderList = new FolderList(dqr);
		render(folderList);
	}

	public void render(FolderList folderList) throws SQLException {

		tree.getChildren().clear();
		folderTreeModel = new AdvancedTreeModel(folderList.getRoot());

		tree.setItemRenderer(new FolderTreeRenderer(eventListener::onEvent, selectionMan, mtTable));
		tree.setModel(folderTreeModel);
	}

	

	

	public Button addHeaderButton(String label, String colorClass) {

		Button button = new Button(label);
		button.setSclass("float-right btn " + colorClass);
		button.setParent(window.getFellow("HEADER_DIV"));
		button.addEventListener(Events.ON_CLICK, this::addingDataToButton);
		button.setStyle("margin:3px");
		return button;
	}

	void addingDataToButton(Event event) {
		if (selectionMan.getSelectionCount() == 0) {
			Clients.showNotification("Please, Select a Parent Node", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
			return;
		}
		Treeitem treeitem = selectionMan.getSingleSelectedKey();

		FolderTreeNode folderTreeNonde = (FolderTreeNode) treeitem.getValue();
		IDetachedRecord folder = folderTreeNonde.getData();

		Events.sendEvent(new Event(CustomEvents.ON_HEADERBUTTON_CLICK, event.getTarget(),
				new ListValues<IDetachedRecord>().addValue(folder)));
		// entityGrid.buildGrid();
	}

	void getMetadataData(Event evt) {
		
		MTTable folderTable = mtTable;
		
		File folderFile = null;
		File itemFile = null;
		
		try {
			
			if (folderTable.isView())
				folderTable = folderTable.getPrimaryKey().getRealField().getTable();
			    folderFile=MetadataUtil.getMDD(folderTable, folderTable.getTableName() + ".txt");

			    MTTable itemTable = TreeHelper.getItemField(folderTable).getForeignKey();
			    itemTable = itemTable.getPrimaryKey().getRealField().getTable();
			    itemFile=MetadataUtil.getMDD(itemTable, itemTable.getTableName() + ".txt");
			    
			    File mergeFile= new File(itemFile.getName() +"_" +folderFile.getName() +".txt");
			    Files.deleteIfExists(mergeFile.toPath());
				FileLoader.mergeFiles(new ListValues<File>().addValue(itemFile).addValue(folderFile), mergeFile);
				Filedownload.save(mergeFile, "text/plain");
			    
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	public FolderList getFolderList() {
		return folderList;
	}

	public void setFolderList(FolderList folderList) {
		this.folderList = folderList;
	}

	public TreeSelectionMan getSelectionMan() {
		return selectionMan;
	}

	public void setSelectionMan(TreeSelectionMan selectionMan) {
		this.selectionMan = selectionMan;
	}

	public void setHeaderLabel(String headerLabel) {
		this.sHeaderLabel = headerLabel;
	}

	public Div getHeaderDiv() {
		return headerDiv;
	}

	public void setHeaderDiv(Div headerDiv) {
		this.headerDiv = headerDiv;
	}

	public DetachedQueryResult getDqr() {
		return dqr;
	}

	public void setDqr(DetachedQueryResult dqr) {
		this.dqr = dqr;
	}

	public Component getTopParent() {
		return topParent;
	}

	public Integer getPermissionValue() {
		return permissionValue;
	}

	public MTTable getMtTable() {
		return mtTable;
	}

	public Component getParent() {
		return parent;
	}

	public AdvancedTreeModel getFolderTreeModel() {
		return folderTreeModel;
	}

	public ITreeeventListener getTreeeventListener() {
		return eventListener;
	}

	public void setTreeeventListener(ITreeeventListener treeeventListener) {
		this.eventListener = treeeventListener;
	}
}