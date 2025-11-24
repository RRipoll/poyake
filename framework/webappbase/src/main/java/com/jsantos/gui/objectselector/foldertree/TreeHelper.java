package com.jsantos.gui.objectselector.foldertree;

import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class TreeHelper {

	public static MTField getParentFolderField(MTTable mtTable) {
		
		for (MTField field : mtTable.getFields()) {
			if (field.getStereoTypes().contains("PARENTFOLDER")) {
				return field;
			}
		}
		return null;
		
	}
	
public static MTField getFolderField(MTTable mtTable) {
		
		for (MTField field : mtTable.getFields()) {
			
			if (field.getStereoTypes().contains("FOLDER")) {
				return field;
			}
			
		}
		return null;
		
	}

public static MTField getItemField(MTTable mtTable) {
	
	for (MTField field : mtTable.getFields()) {
		
		if (field.getStereoTypes().contains("ITEM")) {
			return field;
		}
		
	}
	return null;
	
}

public static MTField getDescriptionField(MTTable mtTable) {
	
	for (MTField field : mtTable.getFields()) {
		
		if (field.getStereoTypes().contains("DESCRIPTION")) {
			return field;
		}
		
	}
	return null;
	
}
	
	
}
