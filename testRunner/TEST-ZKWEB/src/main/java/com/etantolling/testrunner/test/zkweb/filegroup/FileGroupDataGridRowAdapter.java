package com.etantolling.testrunner.test.zkweb.filegroup;

import java.sql.SQLException;

import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.A;

import com.etantolling.testrunner.test.zkweb.datagrid3.BasicRowAdapter;

public class FileGroupDataGridRowAdapter extends BasicRowAdapter{
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public void renderCell(HtmlBasedComponent div, String columnName, EventListener eventListener) throws SQLException {
		div.setSclass("fieldValue");
		A link = new A();
		link.setHref((String)row.get("URL"));
		link.setLabel((String)row.get("FILENAME"));
		link.setTarget("_blank");
		//if (null != row.get("MIMETYPE"))
			//if(((String)row.get("MIMETYPE")).toUpperCase().contains("PDF") || ((String)row.get("MIMETYPE")).toUpperCase().contains("IMAGE") || ((String)row.get("MIMETYPE")).toUpperCase().contains("TEXT") )
				//link.setTarget("_blank");
		link.setParent(div);
	}
}
