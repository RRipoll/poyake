package com.etantolling.testrunner.test.zkweb.datagrid3;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;
import org.zkoss.zul.Paging;

@SuppressWarnings("serial")
public class DataGridPagination extends Div{
	private Html countDisplay = null;
	public Paging pag = null;
	private PagingGoogle pagingGoogle;
	private int pagingType;

	private int pageSize;
	private Integer rowCount;
	private int activePage;


	public void setPageRowCount(Integer pageRowCount) {
		if (pagingType == DataTable.PAGING_GOOGLE ||pagingType == DataTable.PAGING_NOCOUNT){
			pagingGoogle.setPageRowCount(pageRowCount);
			pagingGoogle.layout();
		}
	}


	public PagingGoogle getPagingGoogle() {
		return pagingGoogle;
	}


	public void setPagingGoogle(PagingGoogle pagingGoogle) {
		this.pagingGoogle = pagingGoogle;
	}


	public int getPagingType() {
		return pagingType;
	}


	public void setPagingType(int pagingType) {
		this.pagingType = pagingType;
	}
	
	
	public DataGridPagination(int pagingType, EventListener<Event> eventListener, int pageSize, Integer rowCount){
		this.pagingType = pagingType;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.activePage = 0;
		this.setZclass("z-grid-paging-top");;
		
		
		if (pagingType == DataTable.PAGING_GOOGLE || pagingType == DataTable.PAGING_NOCOUNT){
			pagingGoogle = new PagingGoogle(activePage, pageSize, rowCount);
			pagingGoogle.addEventListener("onPaging", eventListener);
			pagingGoogle.setPageSize(pageSize);
			pagingGoogle.setTotalSize(rowCount);
			pagingGoogle.setParent(this);
			
		}
		else {
			

			pag = new Paging();
			pag.setPageSize(pageSize);
			
			pag.setParent(this);
			pag.addEventListener("onPaging", eventListener);
			pag.setStyle("float:left");
			//this.setWidth("300px");
			Div div=new Div();
			div.setStyle("float:right");
			div.setParent(this);

			if(null!=rowCount){pag.setTotalSize(rowCount);
				countDisplay = new Html("");
				countDisplay.setSclass("z-paging-info");
				//countDisplay.setStyle("font-size:11px;color:#333333");
				countDisplay.setParent(div);
			}
		}		
	}


	public void setPageSize(int pageSize){
		if (pagingType == DataTable.PAGING_GOOGLE ||pagingType == DataTable.PAGING_NOCOUNT ){
			pagingGoogle.setPageSize(pageSize);
			pagingGoogle.layout();
		}
		else{
			pag.setPageSize(pageSize);
		}
		this.pageSize = pageSize;
		displayRecordCount();
	}
	
	public void setRowCount(Integer rowCount){
		if (pagingType == DataTable.PAGING_GOOGLE ||pagingType == DataTable.PAGING_NOCOUNT){
			pagingGoogle.setTotalSize(rowCount);
			pagingGoogle.layout();
		}
		else{
			pag.setTotalSize(rowCount);
		}
		this.rowCount = rowCount;
		displayRecordCount();
	}
	
	public void setActivePage(int activePage){
		if (pagingType == DataTable.PAGING_GOOGLE ||pagingType == DataTable.PAGING_NOCOUNT){
			pagingGoogle.setActivePage(activePage);
			pagingGoogle.layout();
		}
		else{
			pag.setActivePage(activePage);
		}
		this.activePage=activePage;
		displayRecordCount();
	}
	
	private void displayRecordCount() {
		if (null!=rowCount && null != countDisplay)
			countDisplay.setContent("[" + ((activePage*pageSize)+new Integer(1)) + " - " + Math.min((activePage+1)*pageSize , rowCount) + " / " + rowCount+"]");
	}
}
