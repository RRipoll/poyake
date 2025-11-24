package com.jsantos.custom.cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

import javax.activation.MimetypesFileTypeMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Label;

import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class LogBuilder extends Div implements IGridCellBuilder {

	Object value;
	IDetachedRecord detachedRecord;
	Locale locale;
	MTField mTField;
	
	@Override
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values, Locale locale) {
		this.mTField = mtField;
		this.value = value;
		this.detachedRecord = detachedRecord;
		this.locale = locale;

		
		
		this.setSclass("btn btn-link");
		this.setStyle("color:blue");
		Label label = new Label("Show Log");
		label.setStyle("cursor:pointer");
		label.setParent(this);
		
		this.addEventListener(Events.ON_CLICK, this::showLog);
		return this;

	}

	void showLog(Event evn) {
		
		File tempFile= new File(value.toString());
		try {
			Filedownload.save(tempFile, new MimetypesFileTypeMap().getContentType(tempFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public MTField forField() {
		
		return MTtestRunnerData.STOREVALUESEVENT.LOG;
	}
	
	
	
}
