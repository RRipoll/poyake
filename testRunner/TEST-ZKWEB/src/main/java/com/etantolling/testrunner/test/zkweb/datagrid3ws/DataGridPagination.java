package com.etantolling.testrunner.test.zkweb.datagrid3ws;

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
	private int rowCount;
	private int activePage;
	
	
	public DataGridPagination(int pagingType, EventListener<Event> eventListener, int pageSize, int rowCount){
		this.pagingType = pagingType;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.activePage = 0;
		this.setZclass("z-grid-paging-top");;
		
		
		if (pagingType == DataTable.PAGING_GOOGLE){
			pagingGoogle = new PagingGoogle(activePage, pageSize, rowCount);
			pagingGoogle.addEventListener("onPaging", eventListener);
			pagingGoogle.setPageSize(pageSize);
			pagingGoogle.setTotalSize(rowCount);
			pagingGoogle.setParent(this);
			
		}
		else {
			

			pag = new Paging();
			pag.setPageSize(pageSize);
			pag.setTotalSize(rowCount);
			pag.setParent(this);
			pag.addEventListener("onPaging", eventListener);
			pag.setStyle("float:left");
			//this.setWidth("300px");
			Div div=new Div();
			div.setStyle("float:right");
			div.setParent(this);
			countDisplay = new Html("");
			
			countDisplay.setSclass("z-paging-info");
			//countDisplay.setStyle("font-size:11px;color:#333333");
			countDisplay.setParent(div);
		}		
	}


	public void setPageSize(int pageSize){
		if (pagingType == DataTable.PAGING_GOOGLE){
			pagingGoogle.setPageSize(pageSize);
			pagingGoogle.layout();
		}
		else{
			pag.setPageSize(pageSize);
		}
		this.pageSize = pageSize;
		displayRecordCount();
	}
	
	public void setRowCount(int rowCount){
		if (pagingType == DataTable.PAGING_GOOGLE){
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
		if (pagingType == DataTable.PAGING_GOOGLE){
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
		if (null != countDisplay)
			countDisplay.setContent("[" + ((activePage*pageSize)+new Integer(1)) + " - " + Math.min((activePage+1)*pageSize , rowCount) + " / " + rowCount+"]");
	}
}
