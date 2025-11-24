package com.etantolling.testrunner.test.zkweb.datagrid3ws;


import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.event.PagingEvent;
import org.zkoss.zul.ext.Pageable;

public class PagingGoogle extends Div implements EventListener<Event> ,Pageable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7407357523581574445L;
	public Integer activePage=0;
	Integer pageCount=0;
	Integer pageSize=50;
	Integer totalSize=0;
	boolean showPageBox=false;
	boolean showSizePageBox=true;
	
	Intbox sizePageShow;
	Intbox pageShow;
	
	
	public boolean isShowSizePageBox() {
		return showSizePageBox;
	}

	public void setShowSizePageBox(boolean showSizePageBox) {
		this.showSizePageBox = showSizePageBox;
	}

	public PagingGoogle(Integer activePage, Integer pageSize, Integer totalSize) {
		super();
		this.activePage = activePage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		//this.pageCount=(int) Math.ceil(totalSize/pageSize);
		this.setStyle("float:right;	padding:5px;");
		this.setZclass("paginggoogle");
		this.setSclass("paginggoogle");
		this.setClass("paginggoogle");
		
		layout();
	}
	
	public PagingGoogle() {
		super();
		
		layout();
	}
	
		public boolean isShowPageBox() {
		return showPageBox;
	}

	public void setShowPageBox(boolean showPageBox) {
		this.showPageBox = showPageBox;
	}

		public void layout() {
			this.getChildren().clear();
			//org.zkoss.zul.Html pp=new org.zkoss.zul.Html(" | ");
			//pp.setParent(this);
			pageCount=(int) Math.ceil(new Double(totalSize)/new Double(pageSize));

			

			if(pageCount>1){
				if(showSizePageBox)setShowSizePageBox();
				if(showPageBox)setPageShow();
				setPrevious();
				setPagesNumbers();
				setNext();
			}
		}
		
		private void setShowSizePageBox() {
		
			Label pageShowLabel= new Label("Items per page:");
			pageShowLabel.setParent(this);
			pageShowLabel.setClass("pagingnext");
			pageShowLabel.setStyle("font-weight:normal");
			
			sizePageShow= new Intbox();
			sizePageShow.setValue(pageSize);
			sizePageShow.setParent(this);
			sizePageShow.addEventListener(Events.ON_OK, this);
			sizePageShow.setStyle("width:30px;text-align:center;cursor: text;");
			sizePageShow.setClass("pagingnext");
			
			Html html=new Html("&nbsp;&nbsp;&nbsp;&nbsp;");
			html.setParent(this);
		
		}

		
		private void setPageShow() {
			
			Label pageShowLabel= new Label("Page");
			pageShowLabel.setParent(this);
			pageShowLabel.setClass("pagingnext");
			pageShowLabel.setStyle("font-weight:normal");
			
			pageShow= new Intbox();
			pageShow.setValue(activePage+1);
			pageShow.setParent(this);
			pageShow.addEventListener(Events.ON_OK, this);
			pageShow.setStyle("width:30px;text-align:center;cursor: text;");
			pageShow.setClass("pagingnext");
			
			Html html=new Html("&nbsp;&nbsp;&nbsp;&nbsp;");
			html.setParent(this);
		}
		
	
	private void setNext() {
		if(activePage!=pageCount-1){
			
			org.zkoss.zul.Html next=new org.zkoss.zul.Html(" next ");
			next.setClass("pagingnext");
			next.addEventListener(Events.ON_CLICK, this);
			next.setAttribute("value","next");
			next.setParent(this);
		}
			
		}
	
	private void setPagesNumbers() {
			
		int start=(activePage-5 >0?activePage-5:0);
		int end=start+10;
		if(start+10>pageCount-1)end=pageCount;
		if(end-10<start)start=end -10;
		if(start<0)start=0;
		
		for (int i = start; i < end ; i++) {
			
			org.zkoss.zul.Html a=new org.zkoss.zul.Html("  "+(i+1)+"  ");
			a.setClass("pagingnumber");
			a.setParent(this);
			a.addEventListener(Events.ON_CLICK, this);
			a.setAttribute("value", i+"");
			if(i== activePage.intValue()){
				a.setClass("pagingactive");
				
			}
				
		}
			
		}
	
	private void setPrevious() {
			
		if(activePage!=0){
			
			org.zkoss.zul.Html previous=new org.zkoss.zul.Html(" previous ");
			previous.setClass("pagingnext");
			previous.addEventListener(Events.ON_CLICK, this);
			previous.setAttribute("value","previous");
			previous.setParent(this);
			//throw new Event(Events.ON_CLICK, eventListener, activePage);
		}
			
	}


	


	public int getActivePage() {
		return activePage;
	}


	public void setActivePage(Integer activePage) {
		this.activePage = activePage;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		pageCount=totalSize/pageSize;
	}


	public Integer getTotalSize() {
		return totalSize;
	}


	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
		pageCount=totalSize/pageSize;
	}


	public void onEvent(Event event) throws Exception {
		
		
		
		if(event.getName().equals(Events.ON_CLICK)){
			String value= (String) event.getTarget().getAttribute("value");
		
			switch (value) {
				case "next":
					activePage++;
					break;
				case "previous":
					activePage--;
					break;
				default:
					activePage=Integer.parseInt(value);
			}
			
		}
		if(event.getTarget().equals(pageShow)){
			if(null!=((Intbox)event.getTarget()).getValue()){
				activePage=((Intbox)event.getTarget()).getValue()-1;
			}
		}
		if(event.getTarget().equals(sizePageShow)){
			if(null!=((Intbox)event.getTarget()).getValue()){
				pageSize=((Intbox)event.getTarget()).getValue();
				layout();
				this.setAttribute("PAGESIZE", pageSize);
			}
		}
		layout();
		Events.postEvent(new PagingEvent("onPaging", this, activePage));
	}

	@Override
	public void setActivePage(int arg0) throws WrongValueException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageSize(int arg0) throws WrongValueException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
}