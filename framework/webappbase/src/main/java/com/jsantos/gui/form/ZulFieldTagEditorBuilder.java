package com.jsantos.gui.form;

import java.util.Vector;

import org.zkoss.zk.ui.Component;

import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.zkcomponent.MTCheckBox;
import com.jsantos.gui.zkcomponent.MTDatebox;
import com.jsantos.gui.zkcomponent.MTDecimalbox;
import com.jsantos.gui.zkcomponent.MTIntbox;
import com.jsantos.gui.zkcomponent.MTSelectbox;
import com.jsantos.gui.zkcomponent.MTTextbox;
import com.jsantos.gui.zkutil.ComponentTreeTransverser;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.search.AttributeConstants;

public class ZulFieldTagEditorBuilder {

	public static void buildFields(Component parent){
		Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeName(parent, AttributeConstants.EDITORFORFIELD);
		for(Component comp:components){
			String fullyQualifiedFieldName = (String)comp.getAttribute(AttributeConstants.EDITORFORFIELD);
			if (null != fullyQualifiedFieldName){
				if (!fullyQualifiedFieldName.contains("."))
					throw new RuntimeException("Field Names need to be fully qualified in editorForField");
				String tableName = fullyQualifiedFieldName.substring(0, fullyQualifiedFieldName.indexOf("."));
				String fieldName = fullyQualifiedFieldName.substring(fullyQualifiedFieldName.indexOf(".") + 1, fullyQualifiedFieldName.length());

				MTTable mtTable = MTBase.getTable(tableName);
				if (null == mtTable)
					throw new RuntimeException("Table name not found for editorForField tag ");
				MTField mtField = mtTable.getField(fieldName);
				if (null == mtField)
					throw new RuntimeException("Field name not found for editorForField tag ");

				IMTComponent newEditor = buildEditorForField(mtField);
				newEditor.setMTField(mtField);

				newEditor.setParent(comp);
				newEditor.setAttribute(AttributeConstants.FIELD, mtField.getName());
			}
		}
	}

	public static IMTComponent buildEditorForField(MTField mtField){
		IMTComponent comp;
		if (null != mtField.getForeignKey() && mtField.getForeignKey().getIsEnumeration()) {
			MTSelectbox mtSelectbox = new MTSelectbox();
			//SelectboxObjectSelectorHelper.buildObjectList(mtSelectbox, mtField.getForeignKey());
			comp= mtSelectbox;
		}
		else{
			switch (mtField.getDataType().getSqlNativeType()){
			case "CHAR":
			case "NCHAR":
			case "NVARCHAR":
			case "VARCHAR":
			case "VARCHAR2":
				comp= new MTTextbox();
				break;
			case "BIT":
				comp= new MTCheckBox();
				break;
			case "BOOLEAN":
				comp= new MTCheckBox();
				break;	
			case "BIGINT":
			case "INT":
			case "INTEGER":
				comp= new MTIntbox();
				break;
			case "DATE":
			case "TIMESTAMP":
			case "DATETIME":
			 comp=new MTDatebox();
			 break;
			case "NUMBER":
			case "NUMERIC":
				if (0 == mtField.getScale())
					comp= new MTIntbox();
				else 
					comp= new MTDecimalbox();
				break;
			case "MONEY":
				comp= new MTDecimalbox();
				break;
			default:
				throw new RuntimeException("DataType: " + mtField.getDataType().getName() + " with sqlType: " + mtField.getDataType().getSqlNativeType() + " not handled yet");
					}
		}
		
		return comp;
	}
}


