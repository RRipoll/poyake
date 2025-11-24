package com.etantolling.testrunner.test.zkweb.metadatadrivenscreens;

import java.util.Hashtable;
import java.util.Map;

import org.zkoss.zk.ui.metainfo.Annotation;
import org.zkoss.zk.ui.sys.ComponentCtrl;

import com.etantolling.testrunner.test.core.metadata.FullyQualifiedFieldName;
import com.etantolling.testrunner.test.core.metadata.MTBase;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;

public class MTAnnotation {
	
	public static MTField getMTField(ComponentCtrl comp){
		MTField mtField = null;
		Annotation ann = comp.getAnnotation("info", "MT");
		if (null != ann){
			String sField = ann.getAttribute("field");
			if (null != sField){
				mtField = FullyQualifiedFieldName.getMTField(sField);
			}
			if (null == mtField)
				System.out.println("No field found for annotation: " + ann.toString());
		}
		return mtField;
	}

	public static MTTable getMTTable(ComponentCtrl comp){
		MTTable mtTable = null;
		Annotation ann = comp.getAnnotation("info", "MT");
		if (null != ann){
			String sTable = ann.getAttribute("table");
			if (null != sTable){
				mtTable = MTBase.getTable(sTable);
			}
		}
		return mtTable;
	}
	
	
	public static void setMTField(ComponentCtrl comp, MTField mtField){
		String[] fieldAttribute = {FullyQualifiedFieldName.get(mtField)};
		Map<String, String[]> attributes = null;
		Annotation ann = comp.getAnnotation("info", "MT");
		if (null != ann)
			attributes = ann.getAttributes();
		else
			attributes = new Hashtable<String, String[]>();
		attributes.put("field", fieldAttribute);
		comp.addAnnotation("info", "MT", attributes);
	}
}
