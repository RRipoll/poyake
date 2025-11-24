package com.etantolling.testrunner.test.zkweb.forms;

import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;

import com.etantolling.testrunner.test.core.metadata.MTBase;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.ObjectSelectorFactory;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class ZulFieldEditorBuilder {

	public static void buildFields(Component parent) throws SQLException{
		Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeName(parent, "editorForField");
		for(Component comp:components){
			String fullyQualifiedFieldName = (String)comp.getAttribute("editorForField");
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

				Component newEditor = buildEditorForField(mtField);

				if (null != comp.getAttribute("width"))


					newEditor.setParent(comp);
				newEditor.setAttribute("field", mtField.getName());
			}
		}
	}

	public static Component buildEditorForField(MTField field) throws SQLException{
		if (null != field.getForeignKey())
			return ObjectSelectorFactory.buildObjectSelector(field.getForeignKey());
		else{
			switch (field.getSqlType()){
			case Types.CHAR:
			case Types.NCHAR:
			case Types.NVARCHAR:
			case Types.VARCHAR:
			case Types.CLOB:
				return new Textbox();
			case Types.BIGINT:
			case Types.BIT:
			case Types.INTEGER:
				return new Intbox();
			case Types.DATE:
				return new Datebox();
			default:
				switch (field.getNativeTypeName()){
				case "VARCHAR2":
					return new Textbox();
				case "NUMBER":
					if (0 == field.getDecimalDigits())
						return new Intbox();
					else 
						return new Decimalbox();
				case "DATE":
					return new Datebox();
				case "TIMESTAMP(6)":
					return new Datebox();
				default:
					throw new RuntimeException("DataType: " + field.getNativeTypeName() + " with sqlType: " + field.getSqlType() + " not handled yet");
				}
			}
		}
	}
}


