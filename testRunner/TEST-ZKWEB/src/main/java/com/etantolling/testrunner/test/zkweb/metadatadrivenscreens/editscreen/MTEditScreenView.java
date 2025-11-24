package com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen;


import java.sql.SQLException;

import org.zkoss.zhtml.Table;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.db.DetachedRecord;
import com.etantolling.testrunner.test.core.metadata.FieldList;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.zkweb.forms.ZulDataWirer;
import com.etantolling.testrunner.test.zkweb.forms.ZulFieldEditorBuilder;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.MTAnnotation;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;


public class MTEditScreenView {

	public Component window;
	public Component save;
	public DetachedRecord dr = null;
	public String password;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MTEditScreenView(Integer pk, EventListener eventListener, String zul, MTTable table, FieldList fieldList, Component parent) throws WrongValueException, SQLException {
		if (null == zul) zul = "/common/zul/standardeditscreen/standardeditscreen.zul";
		window = (Window) Executions.createComponents(zul,parent, null);
		
		if (window instanceof Window){
			if (null == pk)
				((Window)window).setTitle("Create " + table.getTableName());
			else
				((Window)window).setTitle("Edit " + table.getTableName() + " ID:"+ pk);
		}
		
		if (null != fieldList) addFields(window, fieldList);
		if(null==pk){
			dr = new DetachedRecord(table);
		}else{
			dr = new DetachedRecord(table,pk);
		}
		ZulFieldEditorBuilder.buildFields(window);
		ZulDataWirer.initializeFieldValues(dr, window);
		save =  window.getFellow("SAVE_BUTTON");
		save.addEventListener(Events.ON_CLICK, eventListener);
	}
	
	public void addFields(Component parent, FieldList fieldList) throws SQLException{
		Component comp = parent.getFellow("FIELD_LIST");
		Table table = null;
		if (comp instanceof Div){
			Div div = (Div)comp;
			table = new Table();
			table.setParent(div);
		}
		else if (comp instanceof Table){
			table = (Table)comp;
		}
		
		for (MTField field:fieldList.getFields()){
			if (null == ComponentTreeTransverser.findFieldEditorFor(parent, field)){
				Tr tr = new Tr();
				tr.setParent(table);
				Td td = new Td();
				td.setParent(tr);
				new Label(field.getName()).setParent(td);
				td = new Td();
				td.setParent(tr);
				Component editor = ZulFieldEditorBuilder.buildEditorForField(field);
				editor.setParent(td);
				MTAnnotation.setMTField((ComponentCtrl)editor, field);
				//System.out.println(MTAnnotation.getMTField((ComponentCtrl)editor).getName());
				//editor.setAttribute("field", field.getName());
			}
		}
	}
	
	public Component getComponent(){
		return window;
	}
	
}