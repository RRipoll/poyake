package com.jsantos.gui.form;

import java.util.ArrayList;
import java.util.List;

import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class FormFieldListManager{
	private ArrayList<MTField> fields = new ArrayList<>();
	private ArrayList<MTTable> tables = new ArrayList<>();
	
	public FormFieldListManager add(MTTable table) {
		for (MTField field:table.getFields()) {
			if (!field.getStereoTypes().contains("NOGUIINPUT") 
					&& !field.getStereoTypes().contains("AUTOHISTORYMAINFK")
					&& !field.isPrimaryKey()
					&& !tables.contains(field.getForeignKey())
					&& !checkPKofOthertable(field.getForeignKey())
					) {
				fields.add(field);
				tables.add(field.getTable());
			}
		}
		return this;
	}
	
	boolean checkPKofOthertable(MTTable tb) {
		if(null==tb)return false;
		for (MTTable table : tables) {
			MTTable rt= tb.getRealFKTOTable();
			if(table.equals(rt))
				return true;
		} 
		return false;
	}
	
	public FormFieldListManager add(IDetachedRecord dr){
		add(dr.getTable());
		return this;
	}

	public FormFieldListManager add(MTField field) {
		fields.add(field);
		return this;
	}

	public FormFieldListManager add(List<IDetachedRecord> drs){
		for (IDetachedRecord dr:drs)
			add(dr);
		return this;
	}

	public ArrayList<MTField> getFields() {
		return fields;
	}
	
	
}
