package com.etantolling.testrunner.test.zkweb.datagrid3;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zhtml.Table;
import org.zkoss.zhtml.Tbody;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Text;
import org.zkoss.zhtml.Thead;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.event.PagingEvent;

import com.etantolling.testrunner.test.core.db.DataGridQuery;
import com.etantolling.testrunner.test.core.utils.DataFormatter;
import com.etantolling.testrunner.test.zkweb.datagrid3.filter.BasicDataFilter;
import com.etantolling.testrunner.test.zkweb.datagrid3.filter.DataGridFilter;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class DataTable extends Div implements EventListener<Event> {

	private static final long serialVersionUID = 282683567502985352L;
	public static final int SELECTOR_NONE = 0;
	public static final int SELECTOR_CHECKBOX = 1;
	public static final int SELECTOR_RADIO = 2;
	public static final int PAGING_NONE = 0;
	public static final int PAGING = 1;
	public static final int PAGING_NOCOUNT = 3;
	public static final int PAGING_GOOGLE = 2;
	
	public static final int PAGINGPOSITION_TOP = 0;
	public static final int PAGINGPOSITION_BOTTOM = 1;
	public static final int PAGINGPOSITION_NONE = 2;

	protected int selectorType = SELECTOR_NONE;
	
	private int pagingPosition=PAGINGPOSITION_TOP;
	
	private int minNumberOfSearchParameters=0;
	
	
	public int getMinNumberOfSearchParameters() {
		return minNumberOfSearchParameters;
	}


	public void setMinNumberOfSearchParameters(int minNumberOfSearchParameters) {
		this.minNumberOfSearchParameters = minNumberOfSearchParameters;
	}



	public Vector<Checkbox> VectorCheckBox= new Vector<Checkbox>();
	
	public String cssClass = null;
	protected DataGridModel dgModel;
	
	protected Component mainComponent;
	protected Component parentComponent;
	public Component pagingComponent;
	public String mold=null;
	
	protected BasicRowAdapter rowAdapter = new BasicRowAdapter();

	public SelectionMan selectionMan = new SelectionMan(selectorType);
	protected Checkbox pageCheckbox = new Checkbox();
	public DataGridFilter filter;

	public DataGridPagination pagination;
	private int pagingType;
	
	


	protected int numberOfCicles=0;
	
	public boolean isOnlyPageCheckbox=true;
	
	public boolean isSortable=true;
	
	String extraHeaderZull;
	
	public boolean inverterCheckbox=false;
	
	protected LinkedHashMap<String, String>initialChecked;
	
	
	protected Vector<LinkedHashMap<String, Object>> page;
	
	
	
	public int getPagingType() {
		return pagingType;
	}


	public void setPagingType(int pagingType) {
		this.pagingType = pagingType;
	}

	
	
	public DataTable(DataGridModel dgModel) throws WrongValueException, SQLException{
		this.dgModel = dgModel;
		this.filter = new BasicDataFilter(cssClass);
		layout();
	}

	
	public DataTable(DataGridModel dgModel, DataGridFilter filter, BasicRowAdapter rowAdapter, EventListener<Event> eventListener, String cssClass) throws SQLException {

		init(dgModel,filter,rowAdapter,eventListener,DataTable.PAGING,cssClass);
	}
	
	public DataTable(DataGridModel dgModel, DataGridFilter filter, BasicRowAdapter rowAdapter, EventListener<Event> eventListener,Integer pagingType, String cssClass) throws SQLException {
		
		init(dgModel,filter,rowAdapter,eventListener,pagingType,cssClass);
	}

	public DataTable(DataGridModel dgModel, DataGridFilter filter, BasicRowAdapter rowAdapter, EventListener<Event> eventListener,Integer pagingType,Component pagingComponent, String cssClass) throws SQLException {
		this.pagingComponent=pagingComponent;
		init(dgModel,filter,rowAdapter,eventListener,pagingType,cssClass);
	}
	
	
	
	public void init(DataGridModel dgModel, DataGridFilter filter, BasicRowAdapter rowAdapter, EventListener<Event> eventListener,Integer pagingType, String cssClass) throws SQLException {

		this.cssClass = cssClass;
		this.dgModel = dgModel;
		
		this.pagingType = pagingType;
		
		if (null != filter){
			this.filter = filter;
			dgModel.getDgQuery().setFilterSection(filter.buildWhereClause(),filter.getParameters(),pagingType==3);
		}
		if (null != rowAdapter)
			this.rowAdapter = rowAdapter;
		if (null != cssClass)
			this.setZclass(cssClass);
		
		this.setVisible(false);
		layout();
		
		if (null != eventListener){
			this.addEventListener("onDataGridCellClick", eventListener);
			this.addEventListener("onDataGridCellDoubleClick", eventListener);
			this.addEventListener("onSelectorClick", eventListener);
			this.addEventListener("onPagingEvent", eventListener);
		}
	}

	public void layout() throws WrongValueException, SQLException {
		this.getChildren().clear();
		Vbox table = new Vbox();
		table.setHflex("1");
		if(null!=dgModel.getHeight()){
			//table.setHeight(dgModel.getHeight());
			table.setStyle("max-height:"+dgModel.getHeight());
		}
		table.setParent(this);
		
		if (null != filter) {
			filter.addEventListener("onFilterChanged", this);
			filter.setParent(table);
		}
		if ((null==pagingComponent || null==pagingComponent.getPage()  ) && DataTable.PAGING_NONE != pagingType && pagingPosition==DataTable.PAGINGPOSITION_TOP){
			pagingComponent= new Div();
			((Div)pagingComponent).setStyle("height:35px");
			((Div)pagingComponent).setZclass("z-paging");
			pagingComponent.setParent(table);
			if(pagingType!=3)
				pagination  = new DataGridPagination(pagingType, this, dgModel.getDgQuery().getPageSize(), dgModel.getDgQuery().getRowCount());
			else 
				pagination  = new DataGridPagination(pagingType, this, dgModel.getDgQuery().getPageSize(), (Integer) null);
			pagination.setParent(pagingComponent);
		}
	
		
		parentComponent = new Div();
		((Div)parentComponent).setWidth("100%");
		// ((Div)parentComponent).setHflex("1");
		parentComponent.setParent(table);
		
		
		if (null==pagingComponent && PAGING_NONE != pagingType && pagingPosition==DataTable.PAGINGPOSITION_BOTTOM){
			pagingComponent= new Div();
			((Div)pagingComponent).setStyle("height:35px");
			((Div)pagingComponent).setZclass("z-paging");
			pagingComponent.setParent(table);
			pagination  = new DataGridPagination(pagingType, this, dgModel.getDgQuery().getPageSize(), dgModel.getDgQuery().getRowCount());
			pagination.setParent(pagingComponent);
		}
		
	}

	public Vector<LinkedHashMap<String, Object>> render() throws SQLException {

		this.setVisible(true);
		
		if(isOnlyPageCheckbox){
			//selectionMan.selectedSet.clear();
			VectorCheckBox.clear();
			
		}
		
		dgModel.getDgQuery().getRowCount();
		
		if(null!=dgModel.getDgQuery().getMaxResults() && dgModel.getDgQuery().getMaxResults()<dgModel.getDgQuery().getRowCount())
				throw new WrongValueException(null,"Search returns more than "+dgModel.getDgQuery().getMaxResults()+" results, Please refine your search ");
		
		if (null != mainComponent)
			parentComponent.removeChild(mainComponent);

		Table table = new Table();
		
		table.setStyle("border-collapse:collapse;");
		Radiogroup group = null;
		if (SELECTOR_RADIO == getSelectorType()) {
			group = new Radiogroup();
			table.setParent(group);
		}

		table.setStyle("width:" + dgModel.getWidth());
		//table.setStyle("height:" + dgModel.getHeight());
		getRowAdapter().reset();
		renderHeaders(table);
		page=renderBody(table);

		if (SELECTOR_RADIO == getSelectorType())
			mainComponent = group;
		else
			mainComponent = table;

		mainComponent.setParent(parentComponent);

		
		if(null != pagination){
			pagination.setPageSize(dgModel.dgQuery.getPageSize());
			pagination.setRowCount(dgModel.getDgQuery().getRowCount());
		}
		
		return page;
	}

	public void renderHeaders(Component table) {
		Thead thead = new Thead();
		thead.setParent(table);
		Tr trHead = new Tr();
		trHead.setParent(thead);

		if (SELECTOR_CHECKBOX == selectorType) {
			Td td = new Td();
			td.setParent(trHead);
			//td.setSclass("headerTD");
			pageCheckbox.setParent(td);
			pageCheckbox.setAttribute("GLOBAL_CHECKBOX", "YES");
			pageCheckbox.addEventListener("onCheck", this);
		}
		if (SELECTOR_RADIO == selectorType) {
			Td td = new Td();
			td.setParent(trHead);
			//td.setSclass("headerTD");
		}

		DataGridQuery dgQuery = dgModel.getDgQuery();
		for (String headerName : dgQuery.getColumnNames()) {
			if (dgModel.getHiddenColumns().contains(headerName))
				continue;
			Td td = new Td();
			td.setParent(trHead);
			td.setAttribute("COLUMN_POSITION", new Integer(dgQuery.getColumnNames().indexOf(headerName)));
			td.setAttribute("COLUMN_ORDERBY_NAME", headerName);
			//td.setSclass("headerTD");
			if (null != dgModel.getColumnSize(headerName))
				td.setStyle(dgModel.getColumnSize(headerName)
						 );
			Text text = new Text();
			text.setParent(td);
			text.setValue(dgModel.getHeaderLabels().get(headerName));
			td.addEventListener(Events.ON_CLICK, this);
			if (dgQuery.getOrderByField().equals(headerName)) {
				if (!dgQuery.isAsc(headerName))
					new Image("/common/img/dfArrowUp.gif").setParent(td);
				else
					new Image("/common/img/dfArrowDown.gif").setParent(td);
			}
		}

	}

	public Vector<LinkedHashMap<String, Object>> renderBody(Component table) throws SQLException {
		boolean allChecked = true;
		
		Tbody tbody = new Tbody();
		if (SELECTOR_RADIO == selectorType) {
			Radiogroup group = new Radiogroup();
			group.setParent(table);
			tbody.setParent(group);
		} else {
			tbody.setParent(table);
		}
		Vector<LinkedHashMap<String, Object>> page = dgModel.getPage();
		for (LinkedHashMap<String, Object> row : page) {
			rowAdapter.setRow(dgModel, row);
			Tr tr = new Tr();
			tr.setAttribute("container", table);
			tr.setParent(tbody);
			//tr.setSclass((0 == page.indexOf(row) % 2 ? "trOdd" : "trEven"));
			if (SELECTOR_CHECKBOX == selectorType) {
				Td td = new Td();
				td.setParent(tr);
				td.setAttribute("container", tr);
				td.setSclass("fieldValue");
				Checkbox checkbox = new Checkbox();
				checkbox.setParent(td);
				checkbox.setAttribute("container", td);
				checkbox.addEventListener("onCheck", this);
				Object id = rowAdapter.getRow();
				if (null != id)
					checkbox.setAttribute("ROW_ID", id);

				checkbox.setChecked(selectionMan.isChecked(id));
				if (!checkbox.isChecked())
					allChecked = false;
				applyTrSelectionStyle(checkbox, selectionMan.isChecked(id));
				VectorCheckBox.add(checkbox);
			}
			if (SELECTOR_RADIO == selectorType) {
				Td td = new Td();
				td.setParent(tr);
				td.setSclass("fieldValue");
				Radio radio = new Radio();
				radio.setParent(td);
				radio.addEventListener("onCheck", this);
				radio.setAttribute("container", td);

				Object id = rowAdapter.getRow();
				if (null != id)
					radio.setAttribute("ROW_ID", id);
			}
			for (String columnName : dgModel.getDgQuery().getColumnNames()) {
				if (null == getDgModel().getHeaderLabels() || null != getDgModel().getHeaderLabels().get(columnName)) {
					if (dgModel.getHiddenColumns().contains(columnName))
						break;
					Td td = new Td();
					td.setParent(tr);
					Div div = new Div();
					td.setAttribute("container", tr);
					div.setAttribute("datamodel", dgModel);
					div.setParent(td);
					div.setAttribute("container", td);
					rowAdapter.renderCell(div, columnName, this);
				}
			}
		}
		pageCheckbox.setChecked(allChecked);
		
		return page;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		//System.out.println("Start Event Processing...");
		//System.out.println("event: " + event);
		//System.out.println("event target: " + event.getTarget());
		//System.out.println("event name:" + event.getName());

		if (event instanceof PagingEvent) {
			PagingEvent pe = (PagingEvent) event;
			int pageNo = pe.getActivePage();
			dgModel.setPage(pageNo);
			if(null!=event.getTarget().getAttribute("PAGESIZE")){
				dgModel.getDgQuery().setPageSize((Integer) event.getTarget().getAttribute("PAGESIZE"));
			}
			render();

			Events.sendEvent("onPagingEvent", (Component) this, event.getTarget().getAttribute("CELL_CLICK_INFO"));
		} 
		else if ("onFilterChanged".equals(event.getName())) {
			dgModel.setPage(0);
			VectorCheckBox.clear();
			dgModel.getDgQuery().setFilterSection(filter.buildWhereClause(),filter.getParameters(),pagingType==3);
			//dgModel.getDgQuery().forceRowCount();
			render();
			if(null!=pagination){
				pagination.setActivePage(dgModel.getPageNumber());
				pagination.setPageSize(dgModel.getDgQuery().getPageSize());
				pagination.setRowCount(dgModel.getDgQuery().getRowCount());
				
			}
		}
		if (null != event.getTarget().getAttribute("COLUMN_ORDERBY_NAME")) {
			//getCVS("cvsfile.cvs");
			String headerName = event.getTarget().getAttribute("COLUMN_ORDERBY_NAME").toString();
			
			dgModel.dgQuery.setOrderByField(headerName,!dgModel.getDgQuery().isAsc(headerName));
			
			//if (null!=dgModel.dgQuery.getOrderByItemActive() && headerName.equals(dgModel.getDgQuery().getOrderByField()))
				//dgModel.getDgQuery().setAsc(headerName, !dgModel.getDgQuery().isAsc(headerName));
			//else {
				//dgModel.getDgQuery().setOrderByField(headerName, true);
			//}
			render();
			dgModel.setPage(0);
			if (null != pagination){
				pagination.setActivePage(0);
				pagination.setPageSize(dgModel.getDgQuery().getPageSize());
				pagination.setRowCount(dgModel.getDgQuery().getRowCount());
			}
		} 
		else if (Events.ON_CLICK.equals(event.getName()) || Events.ON_CHANGE.equals(event.getName())) {
			//System.out.println("Sending onUser event. Data: " + event.getTarget().getAttribute("CELL_CLICK_INFO"));
			Events.sendEvent("onDataGridCellClick", (Component) this, event.getTarget().getAttribute("CELL_CLICK_INFO"));
		} 
		else if (Events.ON_DOUBLE_CLICK.equals(event.getName())) {
			
			//System.out.println("Sending onUser event. Data: " + event.getTarget().getAttribute("CELL_CLICK_INFO"));
			Events.sendEvent("onDataGridCellDoubleClick", (Component) this, event.getTarget().getAttribute("CELL_CLICK_INFO"));
		} 
		else if ("onCheck".equals(event.getName())) {
			//System.out.println("onCheck");
			if (event.getTarget() instanceof Checkbox) {
				if ("YES".equals(event.getTarget().getAttribute("GLOBAL_CHECKBOX"))) {
					
					setFullPageSelectionState(event.getTarget(), selectionMan);
					//Object id = event.getTarget().getAttribute("ROW_ID");
					event.stopPropagation();
					Events.sendEvent("onSelectorClick", (Component) this, event.getTarget());
				} else {
					//System.out.println("Checking ROW_ID");
					Object id = event.getTarget().getAttribute("ROW_ID");
					if (null != id) {
						System.out.println("ROW_ID is not null");
						if (event.getTarget() instanceof Radio)
							selectionMan.selectedSet.clear();
						selectionMan.set(id,inverterCheckbox ^ ((CheckEvent) event).isChecked());
						applyTrSelectionStyle(event.getTarget(), ((CheckEvent) event).isChecked());
						Events.sendEvent("onSelectorClick", (Component) this, event.getTarget());
					}
				}
			} else if (event.getTarget() instanceof Radio) {
				Object id = event.getTarget().getAttribute("ROW_ID");
				if (null != id)
					selectionMan.setSingleSelection(id);
			}

			//System.out.println("Selection size: " + selectionMan.selectedSet.size());
		}

		else{ //FIXME: Should this be there at all?
			if(null!=event.getTarget().getAttribute("CELL_CLICK_INFO"))
			Events.sendEvent("onDataGridCellClick", (Component) this, event.getTarget().getAttribute("CELL_CLICK_INFO"));
		}
		//System.out.println("Event Processing finished, returning control to zk");
	}

	public void setFullPageSelectionState(Component comp, SelectionMan selectionMan) {
		boolean isChecked = ((Checkbox) comp).isChecked();
		
		/*
		if(isOnlyPageCheckbox){
			selectionMan.selectedSet.clear();
		}
*/
		for (Checkbox checkbox : VectorCheckBox) {
			Object id = checkbox.getAttribute("ROW_ID");
			selectionMan.set(id, inverterCheckbox ^isChecked );
			checkbox.setChecked(isChecked);
			applyTrSelectionStyle(checkbox, isChecked);
		}
	}

	public void applyTrSelectionStyle(Component comp, boolean isChecked) {
		//Component tbody = comp.getParent().getParent().getParent();
		//Tr tr = (Tr) comp.getParent().getParent();
		if (isChecked){
			//tr.setSclass("trSelected");
		}else {
			//String newClass = (0 == tbody.getChildren().indexOf(tr) % 2 ? "trOdd" : "trEven");
			//tr.setSclass(newClass);
		}

	}

	public int getSelectorType() {
		return selectorType;
	}

	public SelectionMan getSelectionMan() {
		return selectionMan;
	}

	public BasicRowAdapter getRowAdapter() {
		return rowAdapter;
	}

	public void setRowAdapter(BasicRowAdapter rowAdapter) {
		this.rowAdapter = rowAdapter;
	}

	public DataGridModel getDgModel() {
		return dgModel;
	}

	public void setDgModel(DataGridModel dgModel) {
		this.dgModel = dgModel;
	}

	public void setSelectorType(int selectorType) {
		this.selectorType = selectorType;
	}

	public DataGridFilter getFilter() {
		return filter;
	}

	public void setFilter(DataGridFilter filter) throws WrongValueException, SQLException {
		this.filter = filter;
		layout();
	}
/*
	public File getCVS(String name) throws IOException, SQLException{
		return getCVS(name,null,null);
	}
	
	
	public File getXLS(String fileName,String sheetName,String sheetTitle, Map<String, CellStyle> styles) throws SQLException, IOException{
		
		CreateBook book= new CreateBook(styles);
		Sheet sheet= book.createSheet(sheetName,sheetTitle);
		book.createTable(sheet,this,null);
		return book.getFile(fileName);
	}
	
	public File getCVS(String name,List<String[]> textHeader,List<String[]> textFooter) throws IOException, SQLException{
		
		
		 BufferedWriter out = new BufferedWriter(new FileWriter(name));
		 CSVWriter writer = new CSVWriter(out);
		 DataGridQuery dgQuery = dgModel.getDgQuery();
		ArrayList<String> header= new ArrayList<String>();
		 
		if(null!=textHeader)
			writer.writeAll(textHeader);
		
		 for (String headerName : dgQuery.getColumnNames()) {
			
			 if (dgModel.getHiddenColumns().contains(headerName))
					continue;
			 if (null != getDgModel().getHeaderLabels().get(headerName))
				 header.add(dgModel.getHeaderLabels().get(headerName));
			}
		 
		 String[] sHeader= new String[header.size()];
		 for(int i=0; i<header.size();i++)sHeader[i]=header.get(i);
		 writer.writeNext(sHeader);
		 
		 
		 Vector<LinkedHashMap<String, Object>> page = dgModel.getTotalResults();
			for (LinkedHashMap<String, Object> row : page) {
				rowAdapter.setRow(dgModel, row);
				//System.out.println(row.toString());
				ArrayList<String> rowList= new ArrayList<String>();
				for (String columnName : dgModel.getDgQuery().getColumnNames()) {
					if (null == getDgModel().getHeaderLabels() || null != getDgModel().getHeaderLabels().get(columnName)) {
						if (dgModel.getHiddenColumns().contains(columnName))
							break;
						Div div=new Div();
						div.setAttribute("datamodel", dgModel);
						rowAdapter.renderCell(div, columnName, this);
						//String value="";
						for (Component child : div.getChildren()) {
							if(child instanceof  Label){
								rowList.add(((Label) child).getValue().trim());
								break;
							}
							else if(child instanceof  org.zkoss.zhtml.Text){
								rowList.add(((org.zkoss.zhtml.Text) child).getValue().trim());
								break;
							} else if(child instanceof  org.zkoss.zul.Textbox){
								rowList.add(((org.zkoss.zul.Textbox) child).getValue().trim());
								break;
							}  else if(child instanceof org.zkoss.zul.Html){
								rowList.add(((org.zkoss.zul.Html) child).getContent().trim());
								break;
							} if(child instanceof org.zkoss.zhtml.Html ){
								rowList.add(BasicRowAdapter.formatValue(row.get(columnName)).trim());
								break;
							}
						}
						if(child instanceof Decimalbox ){
								rowString.put(columnName,DataFormatter.formatValue(row.get(columnName),"currency").trim().replaceAll("\\<[^>]*>",""));
								break;
							} 
					}
					
				}
				 String[] sRowList= new String[rowList.size()];
				 for(int i=0; i<rowList.size();i++){sRowList[i]=rowList.get(i);}
				 writer.writeNext(sRowList);
			}
			
			if(null!=textFooter)
				writer.writeAll(textFooter);
			
			writer.close();
			out.close(); 
			
		return new File(name);
	}
	*/
	
	public HashMap<String, Vector<LinkedHashMap<String, String>>> renderToXlsTemplate(HashMap<String, Vector<LinkedHashMap<String, String>>> beans) throws SQLException, IOException,  InvalidFormatException {
		return renderToXlsTemplate(beans,true);
	}

	
	public HashMap<String, Vector<LinkedHashMap<String, String>>> renderToXlsTemplate(HashMap<String, Vector<LinkedHashMap<String, String>>> beans,boolean updateData) throws SQLException, IOException,  InvalidFormatException {

		
		if(null==beans) 
			beans = new HashMap<String , Vector<LinkedHashMap<String, String>>>();
		 //List list = new ArrayList();
		 
		Hashtable<String, Object> params=dgModel.dgQuery.totalParameters();
		
		LinkedHashMap<String,String>formatParams= new LinkedHashMap<String,String>(); 		
		
		for (String key : params.keySet()) {
			String value=DataFormatter.formatValue(params.get(key),null);
			formatParams.put(key,value);
		}
		
		Vector<LinkedHashMap<String, String>> v=new Vector<LinkedHashMap<String, String>>();
		v.addElement(formatParams);
		beans.put("params",v);
		
		 Vector<LinkedHashMap<String, String>> header= new Vector<LinkedHashMap<String, String>>(); 
		 header.add(getDgModel().getHeaderLabels());
		 
		 beans.put("headerrows", header);
		 Vector<LinkedHashMap<String, String>> rows= new Vector<LinkedHashMap<String, String>>();
		
		 
		 Vector<LinkedHashMap<String, Object>> data = page;
		 if(updateData)
			 data=	 dgModel.getTotalResults();
		 
		 for (LinkedHashMap<String, Object> row : data) {
		 
				LinkedHashMap<String, String> rowString= new LinkedHashMap<String, String>();
				
				rowAdapter.setRow(dgModel, row);

				
				for (String columnName : dgModel.getDgQuery().getColumnNames()) {
						Div div=new Div();
						div.setAttribute("datamodel", dgModel);
						rowAdapter.renderCell(div, columnName, this,false);
						//String value="";
						for (Component child : div.getChildren()) {
							if(child instanceof  Label){
								rowString.put(columnName, ((Label) child).getValue().trim().replaceAll("\\<[^>]*>",""));
								break;
							}
							else if(child instanceof  org.zkoss.zhtml.Text){
								rowString.put(columnName,((org.zkoss.zhtml.Text) child).getValue().trim().replaceAll("\\<[^>]*>",""));
								break;
							} else if(child instanceof  org.zkoss.zul.Textbox){
								rowString.put(columnName,((org.zkoss.zul.Textbox) child).getValue().trim().replaceAll("\\<[^>]*>",""));
								break;
							}  else if(child instanceof org.zkoss.zul.Html){
								rowString.put(columnName,((org.zkoss.zul.Html) child).getContent().trim().replaceAll("\\<[^>]*>",""));
								break;
							} if(child instanceof org.zkoss.zhtml.Html ){
								rowString.put(columnName,DataFormatter.formatValue(row.get(columnName),null).trim().replaceAll("\\<[^>]*>",""));
								break;
							} 
						}
					
				}
				rows.add(rowString);
			}
		beans.put("rows", rows);
		return beans;
}
	
	
	public LinkedHashMap<String, String> getInitialChecked() {
		if(null==initialChecked) initialChecked= new LinkedHashMap<String, String>();
		return initialChecked;
	}

	public void setInitialChecked(LinkedHashMap<String, String> initialChecked) {
		this.initialChecked = initialChecked;
	}



	public boolean isSortable() {
		return isSortable;
	}



	public void setSortable(boolean isSortable) {
		this.isSortable = isSortable;
	}
	
	public void checkInitialChecked(LinkedHashMap<String,Object> row) {
		if(numberOfCicles!=1)return;
		if((null!=initialChecked && initialChecked.size()>0)){
				for(String key:initialChecked.keySet()){
					if( row.get(initialChecked.get(key)).toString().equals(key)){
						selectionMan.selectedSet.add(row);
					}
				}
			}
		}



	public String getExtraHeaderZull() {
		return extraHeaderZull;
	}



	public void setExtraHeaderZull(String extraHeaderZull) {
		this.extraHeaderZull = extraHeaderZull;
	}
	
}
