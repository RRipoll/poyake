package com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;

import com.etantolling.testrunner.test.core.metadata.FieldList;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.IPanel;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen.standardlistheader.StandardListHeader;

@SuppressWarnings("serial")
public class MTListScreenControler extends Div implements IPanel, EventListener<Event> {

	boolean allowCreate = true;
	boolean allowEdit = true;
	
	
	protected MTListView view;
	Date lastEvent;
	protected Component filterComponent;
	protected Component content;
	
	protected StandardListHeader header;
	protected MTTable mtTable;

	private String sql;
	private boolean showList=true;

	private boolean showDeleted=false;
	

	
	public MTListScreenControler(MTTable mtTable,boolean showDeleted,String sql) throws SQLException {
		super();
		this.mtTable = mtTable;
		this.showDeleted=showDeleted;
		this.sql=sql;
		this.getChildren().clear();
		if(showList){
			if(null==sql){
				FieldList fieldList = new FieldList(mtTable);
				fieldList.autoRemove(FieldList.MODE_LIST);
				fieldList.setShowDeleted(showDeleted);
				sql=fieldList.getListSql() ;
			}
			view = new MTListView(this,  sql,content, filterComponent);
			view.setParent(this);
		}
	}
	
	public void layout() throws SQLException {
			if (null == header) 
				{
					header = new StandardListHeader(this, (String)null);
					header.getComponent().setParent(content);
				}
			view.getDataGrid().setFilterComponent(filterComponent);
			view.getDataGrid().setParent(content);
			view.getDataGrid().setRefreshOnFilterChange(false);
			view.getDataGrid().init().setParent(view);
			render();
			view.getDataGrid().render();
	}


	public void render(){}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onEvent(Event event) throws Exception {
		if ("BUTTON_CREATE".equals(event.getTarget().getId())){
			if (allowCreate){
				create();
				view.getDataGrid().render();
			}
		}
		if ("BUTTON_DELETE".equals(event.getTarget().getId())){
			if (allowEdit){
				delete();
				view.getDataGrid().render();
			}
		}
		if ("BUTTON_COPY".equals(event.getTarget().getId())){
			if (allowEdit){
				copy();
				view.getDataGrid().render();
			}
		}
		if ("BUTTON_SWITCH".equals(event.getTarget().getId())){
			if (allowEdit){
				switchRegister(event);
				view.getDataGrid().render();
			}
		}
		
		else if (event.getName().equals("onDataGridCellClick")) {
			if (allowEdit){
				if (event.getData() instanceof BigDecimal)
					edit(((BigDecimal)event.getData()).intValueExact());
				else{
					LinkedHashMap<String, Object> row=(LinkedHashMap<String, Object>)event.getData();
					
					Integer key=null;
					if(null!=row.get(mtTable.getPrimaryKey().getName())){
						key=(Integer) row.get(mtTable.getPrimaryKey().getName());
					}else if(null!=row.get(mtTable.getIdField().getName())){
						key=(Integer) row.get(mtTable.getIdField().getName());
					}
					else key=(Integer) row.values().iterator().next();
					
					edit(key);
				
					view.getDataGrid().render();
				}
			}
		}
	}

	public void create() throws WrongValueException, SQLException{
		MTEditScreenControler editControler = new MTEditScreenControler(null, mtTable, null);
		FieldList fieldList = new FieldList(mtTable);
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(view);
		editControler.doModal();
	
	}
	
	@SuppressWarnings("unchecked")
	public void delete() throws WrongValueException, SQLException{
		
		if(Messagebox.OK!=Messagebox.show(" you are going to Delete a Item, do you agree? ", "Remove", Messagebox.OK, Messagebox.NONE))
			return;

		if(view.getDataGrid().getSelectionMan().getSelectionCount()>0){
			String ids="";
			for(Object row:view.getDataGrid().getSelectionMan().selectedSet){
				Integer id=(Integer)((LinkedHashMap<String, Object>)row).get(mtTable.getPrimaryKey().getName());
				if(ids.length()>0)ids+=",";
				ids+=id;
			}
			String sql="UPDATE "+mtTable.getTableName() +" SET DELETED=1 where "+mtTable.getPrimaryKey().getName() + " in ("+ids+")";
			Connection conn= MainDb.getConnection();
			try{
				Statement st= conn.createStatement();
				st.execute(sql);
			}
			finally{
				conn.close();
			}
		}
		view.getDataGrid().getSelectionMan().selectedSet.clear();
	}
	
	@SuppressWarnings("unchecked")
	public void copy() throws WrongValueException, SQLException{
		if(view.getDataGrid().getSelectionMan().getSelectionCount()>0){
			for(Object row:view.getDataGrid().getSelectionMan().selectedSet){
				Integer id=(Integer)((LinkedHashMap<String, Object>)row).get(mtTable.getPrimaryKey().getName());
				edit(copy(id));
			}
		}
		view.getDataGrid().getSelectionMan().selectedSet.clear();
	}
	
	
	@SuppressWarnings("unchecked")
	public void switchRegister(Event event) throws WrongValueException, SQLException{
		if(view.getDataGrid().getSelectionMan().getSelectionCount()>0){
			if(view.getDataGrid().getSelectionMan().selectedSet.size()!=2)
				throw new WrongValueException(event.getTarget(),"Two register must be selected");
			
			Vector<Object> st=view.getDataGrid().getSelectionMan().selectedSet;
			
			changeOrder((Integer)((LinkedHashMap<String, Object>)st.get(0)).get("EVENTID"),(Integer)((LinkedHashMap<String, Object>)st.get(1)).get("EVENTORDER"));
			changeOrder((Integer)((LinkedHashMap<String, Object>)st.get(1)).get("EVENTID"),(Integer)((LinkedHashMap<String, Object>)st.get(0)).get("EVENTORDER"));
			
			
		}

		view.getDataGrid().getSelectionMan().selectedSet.clear();
	}
	
	
	public static void changeOrder(Integer eventId1,Integer newOrder1) throws WrongValueException, SQLException{
		
			try(Connection conn= MainDb.getConnection()){
				
				String sql="update event set eventorder= "+newOrder1+
						" where EVENTID="+eventId1    ;
				conn.createStatement().executeUpdate(sql);
			}
		

		
	}
	
	public void edit(Integer pk) throws WrongValueException, SQLException{
		MTEditScreenControler editControler = new MTEditScreenControler(pk, mtTable, null);
		FieldList fieldList = new FieldList(mtTable);
		
		fieldList.autoRemove(FieldList.MODE_EDIT);
		editControler.setFields(fieldList);
		editControler.buildForm(view);
		editControler.doModal();
	}
	

	public MTListView getView() {
		return view;
	}

	public boolean isAllowCreate() {
		return allowCreate;
	}

	public void setAllowCreate(boolean allowCreate) {
		this.allowCreate = allowCreate;
	}

	public boolean isAllowEdit() {
		return allowEdit;
	}

	public void setAllowEdit(boolean allowEdit) {
		this.allowEdit = allowEdit;
	}
	

	public void setHeader(StandardListHeader header) {
		this.header = header;
	}
	public void setHeader(StandardListHeader header, Component parent) {
		this.header = header;
		header.getComponent().setParent(parent);
	}

	@Override
	public Component getPanel() {
		
		return view;
	}

	public boolean isShowList() {
		return showList;
	}

	public void setShowList(boolean showList) {
		this.showList = showList;
	}

	public Component getFilterComponent() {
		return filterComponent;
	}

	public void setFilterComponent(Component filterComponent) {
		this.filterComponent = filterComponent;
	}


	public String getSql() {
		return sql;
	}


	public void setSql(String sql) {
		this.sql = sql;
	}


	public Component getContent() {
		return content;
	}


	public void setContent(Component content) {
		this.content = content;
	}

	public boolean isShowDeleted() {
		return showDeleted;
	}

	public void setShowDeleted(boolean showDeleted) {
		this.showDeleted = showDeleted;
	}

	public StandardListHeader getHeader() {
		return header;
	}

	public  Integer copy(Integer testId) throws WrongValueException,
			SQLException{return null;}

	@Override
	public void setId(Object Id) {
		sql=(String)Id;
		
	} 
	
}
