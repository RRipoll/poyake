package com.etantolling.testrunner.test.zkweb.datagrid3;

import java.util.LinkedHashMap;

import org.zkoss.zul.Messagebox;

import com.etantolling.testrunner.test.core.db.DetachedRow;

public interface IUpdateTable {

	public default boolean update(LinkedHashMap<LinkedHashMap<String, Object>, DetachedRow> detachedRowVector)throws Exception{
	
	Messagebox.show(getMessageUpdate(), "Confirm",
			Messagebox.YES | Messagebox.NO, Messagebox.QUESTION, onClickYesNoBtnEvent -> {
				if (onClickYesNoBtnEvent.getName().equals("onYes")) {
					saveData(detachedRowVector);
					Messagebox.show(getMessageSuccessfull(), "Success", Messagebox.OK, Messagebox.INFORMATION);
				}
		});
	return true;
	
	}
	
	public boolean saveData(LinkedHashMap<LinkedHashMap<String, Object>, DetachedRow> detachedRowVector)throws Exception;

	
	
	public default String getMessageUpdate(){
		return " Are you sure you want to update data?";
	};
	
	public default String getMessageSuccessfull(){
		return "Data has been updated";
	};
}
