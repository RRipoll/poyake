package com.etantolling.testrunner.test.zkweb.forms;

import java.sql.SQLException;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.sys.ComponentCtrl;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.zkweb.forms.mtfieldeditor.objectselector.ObjectSelectorHelper;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.MTAnnotation;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class ZulEnumerationWirer {
	
	private static final Logger log = LoggerFactory.getLogger(ZulEnumerationWirer.class);

	public static void initializeEnumerationValues(Component rootComponent) {
		Vector<Component> components = ComponentTreeTransverser.getMetadataAnotatedComponents(rootComponent);
		for (Component comp: components){
			try {
				if(!ZulDataWirerSql.fillFilter(comp)){
					MTField mtField = MTAnnotation.getMTField((ComponentCtrl)comp);
					if (null != mtField) {
					// object selector 
						if (null != mtField.getForeignKey()){ 
							ObjectSelectorHelper.setField(comp, mtField);
						}
					}
				}
			} catch (SQLException e) {
				log.error("ERROR STACKTRACE: ", e);
			}
		}
	}
}
