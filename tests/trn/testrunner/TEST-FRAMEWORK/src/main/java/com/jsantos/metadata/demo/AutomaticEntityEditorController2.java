package com.jsantos.metadata.demo;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.etantolling.testrunner.test.zkweb.experimental.EntityGrid;
import com.jsantos.metadata.MT;
import com.jsantos.orm.label.LabelSelector;
import com.jsantos.orm.mt.MTTable;

public class AutomaticEntityEditorController2 extends GenericForwardComposer<Component> {
	private static final long serialVersionUID = 1L;
	public Component comp;
	Combobox entitiesCombo;
	Combobox langsCombo;
	MTTable mtTable;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception{
		this.comp=comp;

		System.out.println(MT.ADM_APP_INFO);
			entitiesCombo = (Combobox)comp.getFellow("ENTITIES_COMBO");
			for (MTTable table: MT.getTables().values()) {
				entitiesCombo.appendChild(new Comboitem(table.getTableName()));
			}
			entitiesCombo.addEventListener(Events.ON_SELECT, this);
			langsCombo = (Combobox)comp.getFellow("LANG_COMBO");
			langsCombo.addEventListener(Events.ON_SELECT, this);
		
	}

	@Override
	public void onEvent(Event evt) throws Exception {
		if (null != langsCombo.getSelectedItem())
			LabelSelector.inst().setDefaultLang(langsCombo.getSelectedItem().getLabel());
		if (null !=entitiesCombo.getSelectedItem().getLabel()) {
			mtTable = MT.getTable(entitiesCombo.getSelectedItem().getLabel());
			if (null != mtTable) {
				EntityGrid entityGrid = new EntityGrid(mtTable);
				comp.getFellow("GRID").getChildren().clear();
				comp.getFellow("GRID").appendChild(entityGrid.buildGrid());
			}
		}
		super.onEvent(evt);
	}

	
	
}
