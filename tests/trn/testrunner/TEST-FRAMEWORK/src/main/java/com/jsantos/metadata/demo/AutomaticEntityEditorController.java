package com.jsantos.metadata.demo;

import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;

import com.etantolling.testrunner.test.zkweb.datagrid3.DataTableCompressed;
import com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.editscreen.MTEditScreenControler;
import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.FieldValues;
import com.jsantos.orm.mt.MTTable;

public class AutomaticEntityEditorController extends GenericForwardComposer<Component> {
	private static final long serialVersionUID = 1L;
	public Component comp;
	Combobox entitiesCombo;
	MTTable mtTable;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception{
		this.comp=comp;

		System.out.println(MT.ADM_APP_INFO);
		try {
			entitiesCombo = (Combobox)comp.getFellow("ENTITIES_COMBO");
			for (MTTable table: MT.getTables().values()) {
				entitiesCombo.appendChild(new Comboitem(table.getTableName()));
			}
			entitiesCombo.addEventListener(Events.ON_SELECT, this);
		}
		catch (Exception e) {}
		
	}

	void rebuildScreens() {
		if (null != mtTable) {
			try {
				buildCreateScreen();
			}
			catch (Exception e) {}
			
			try {
				buildListScreen();
			}
			catch (Exception e) {}
		}
	}
	
	public void buildListScreen() throws SQLException {
		comp.getFellow("LIST_SCREEN").getChildren().clear();
		String sql = "SELECT * FROM " + mtTable.getSchema() + "." + mtTable.getTableName();
		try {
			Div div= new Div();
			div.setParent(comp.getFellow("LIST_SCREEN"));
			Component parent = comp.getFellow("LIST_SCREEN");
			parent.appendChild(new Label("The fucking list should be here"));
			
			DataTableCompressed dtc= new DataTableCompressed("LIST_SCREEN",mtTable,div,null,  this);
			try {
				dtc.setParent(div);
				dtc.init();
				dtc.render();
			} catch (SQLException e) {
				//log.error("ERROR STACKTRACE:",e);
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void buildCreateScreen() throws WrongValueException, SQLException{
		MTEditScreenControler editController = new MTEditScreenControler(null, mtTable, null);
		//FieldValues fieldList = new FieldValues(mtTable);
		
		//fieldList.autoRemove(FieldValues.MODE_EDIT);
		//editController.setFields(fieldList);
		comp.getFellow("FIELD_LIST").getChildren().clear();
		editController.buildForm(comp.getFellow("FIELD_LIST"));
	}

	@Override
	public void onEvent(Event evt) throws Exception {
		if (null !=entitiesCombo.getSelectedItem().getLabel()) {
			mtTable = MT.getTable(entitiesCombo.getSelectedItem().getLabel());
		}
		rebuildScreens();
		super.onEvent(evt);
	}

	
	
}
