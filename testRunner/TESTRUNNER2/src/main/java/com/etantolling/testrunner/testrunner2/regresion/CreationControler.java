package com.etantolling.testrunner.testrunner2.regresion;

import java.io.File;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.core.dblog.ApplicationLog;
import com.etantolling.testrunner.test.core.testingws.TestRunner;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTable;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTableCompressed;
import com.etantolling.testrunner.test.zkweb.serverfilebrowser.FileBrowser;
import com.etantolling.testrunner.testevents.TestEventFactory;

public class CreationControler implements EventListener<Event> {
	
	private static final Logger log = LoggerFactory.getLogger(CreationControler.class);

	Component panel;
	DataTableCompressed dtc;
	String testServerUrl=DesktopHelper.getTestLibraryURL();
	String appServerUrl=DesktopHelper.getAppBaseUrl();
	String appJobUrl=DesktopHelper.getAppJobUrl();
	
	Vector<LinkedHashMap<String, Object>> executedRows = new Vector<LinkedHashMap<String, Object>>();

	public CreationControler(Component panel) {
		super();
		this.panel = panel;

		init();
	}

	
	private void init() {

		panel.getFellow("regresion_run").addEventListener(Events.ON_CLICK, this);
		panel.getFellow("regresion_run").addEventListener("onLater", this);

		String sql = "SELECT * FROM(" + "	SELECT TESTID," + "(SELECT USERNAME FROM TESTREPOSITORY.INPUTUSER WHERE INPUTUSERID = TEST.OWNER ) OWNER,"
				+ "(SELECT FOLDERPATH FROM TESTREPOSITORY.FOLDERPATHS WHERE FOLDERID = TEST.FOLDERID)FOLDERID," + "TESTNAME," + "DESCRIPTION," + "'...' STATUS  ,"
				+ "'...' TESTRUNNERID  ," + "'...' FILES " + "FROM TESTREPOSITORY.TEST " + " WHERE DELETED=0 " + "AND REGRESSIONTEST=1" + ") WHERE (0=0) ";
		try {
			panel.getFellow("TEST_LIST").getChildren().clear();
			dtc = new DataTableCompressed(sql, panel.getFellow("TEST_FILTER"), panel.getFellow("TEST_LIST"), this);
			dtc.setSelector(DataTable.SELECTOR_CHECKBOX);
			dtc.setOrderByField("TESTID", false);
			dtc.setRefreshOnFilterChange(true);
			dtc.init();
			dtc.render();
			panel.invalidate();
		}
		catch (SQLException e) {
			ApplicationLog.reportException(null, null, null, e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onEvent(Event event) throws Exception {
		if (event.getTarget().equals(panel.getFellow("regresion_run"))) {
			((Button) panel.getFellow("regresion_run")).setVisible(false);
			if (event.getName().equals(Events.ON_CLICK)) {
				if (dtc.getSelectionMan().selectedSet.size() == 0) {
					Messagebox.show("Please, select same test ");
					((Button) panel.getFellow("regresion_run")).setVisible(true);
				}
				else {
					setStringInCell(getRowFromSelectionMan(false), "...Processing...", "STATUS");
					Events.echoEvent("onLater", panel.getFellow("regresion_run"), null);
				}
			}
			else if ("onLater".equals(event.getName())) {
				LinkedHashMap<String, Object> row = (LinkedHashMap<String, Object>) getRowFromSelectionMan(false);
				if (null == row) {
					((Button) panel.getFellow("regresion_run")).setVisible(true);
					return;
				} 
				Integer testId = (Integer) row.get("TESTID");
				try {
						
					TestRunner trc = new TestRunner(testId, new TestEventFactory(),testServerUrl,appServerUrl,appJobUrl);
					trc.setDefaultAuthorization(DesktopHelper.getDefaultTokken());
					Integer testRunnerId = trc.createNewTestRunnerId(DesktopHelper.getInputUserId());
					setStringInCell(getRowFromSelectionMan(false), testRunnerId + "", "TESTRUNNERID");
					trc.deleteFiles(testRunnerId);

					String results = "done";
					if (trc.bTestSuccess)
						results = "OK";
					else
						results = "NOK";

					setStringInCell(getRowFromSelectionMan(false), results, "STATUS");

					Button button = new Button("File");
					button.setAttribute("testRunnerId", testRunnerId);
					button.addEventListener(Events.ON_CLICK, this);

					setComponentInCell(getRowFromSelectionMan(true), button, "FILES");

				}
				catch (Exception e) {
					log.error("ERROR STACKTRACE:",e);
					setStringInCell(getRowFromSelectionMan(true), "Error: " + e.toString(), "STATUS");

				}
				setStringInCell(getRowFromSelectionMan(false), "...Processing...", "STATUS");
				dtc.getDataTable().invalidate();
				Events.echoEvent("onLater", panel.getFellow("regresion_run"), null);
			}
		}
		else if (event.getTarget() instanceof Button && event.getTarget().hasAttribute("testRunnerId")) {

			Integer testRunnerId = (Integer) event.getTarget().getAttribute("testRunnerId");
			FileBrowser fileBrower = new FileBrowser(new File("/nasshare/test/test" + testRunnerId), null);
			Window win = new Window("Files", null, true);
			fileBrower.setParent(win);
			win.setParent(panel);
			win.setWidth("70%");
			win.setHeight("70%");
			win.doModal();
		}
	}

	@SuppressWarnings("unchecked")
	private void setStringInCell(Object row, String results, String fieldName) {
		if (null == row)
			return;
		Component div = dtc.getCellDiv((LinkedHashMap<String, Object>) row, fieldName);
		div.getChildren().clear();
		new Label(results).setParent(div);
	}

	@SuppressWarnings("unchecked")
	private void setComponentInCell(Object row, Component component, String fieldName) {
		if (null == row)
			return;
		Component div = dtc.getCellDiv((LinkedHashMap<String, Object>) row, fieldName);
		div.getChildren().clear();
		component.setParent(div);
	}

	@SuppressWarnings("unchecked")
	private Object getRowFromSelectionMan(boolean takeInAccount) {
		LinkedHashMap<String, Object> row = null;
		for (Object entry : dtc.getSelectionMan().selectedSet) {
			if (!executedRows.contains(entry)) {
				if (takeInAccount)
					executedRows.add((LinkedHashMap<String, Object>) entry);
				return entry;
			}
		}
		return row;
	}
}
