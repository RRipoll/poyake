package com.jsantos.auditimmo.screen.evaluation;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.jsantos.gui.datagrid4.cell.general.PrimaryKeyGridCellBuilder;
import com.jsantos.metadata.eva.MTTableVFOLDERSEARCH;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.mt.MTField;

public class EvaluationPkFieldComponent extends PrimaryKeyGridCellBuilder{

	public EvaluationPkFieldComponent() {
		super(MTTableVFOLDERSEARCH.FOLDERID);
	}
	
	

	@Override
	public Component buildGridComponent(MTField mtField, Object value, DetachedRecord values) {
		Component comp = super.buildGridComponent(mtField, value, values);
		comp.addEventListener(Events.ON_CLICK, new CellEventListener(comp, value));
		return comp;
	}



	public class CellEventListener implements EventListener<Event>{
		Component comp;
		Integer pk;
		
		public CellEventListener(Component comp, Object value) {
			this.comp = comp;
			this.pk=(Integer) value;
			
		}
		
		public void onEvent(Event event) throws Exception {
			try {
				new EvaluationDetails(pk, comp.getParent()).buildAndShowComponent();
			}
			catch (Throwable e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	
}
