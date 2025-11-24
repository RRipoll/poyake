package com.jsantos.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

import javax.activation.MimetypesFileTypeMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Treerow;

import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.common.util.MetadataUtil;
import com.jsantos.custom.menu.IMenuProvider;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.gui.objectselector.foldertree.TreeController;
import com.jsantos.gui.objectselector.foldertree.TreeHelper;
import com.jsantos.gui.zkutil.ButtonCssClass;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.metadata.testrunner.FolderDTO;
import com.jsantos.metadata.testrunner.TestDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.runningTest.TestRunnerController;
/**
 * @author raul ripoll
 */
public class TestRunnerProvider implements IMenuProvider {

	Component mainArea;
	Component parent;
	String uri = "~./zul/poyake-testrunner/menu.zul";
	TreeController eventTree;

	@Override
	public Component getMenu(Component parent, Component mainArea, MapValues<Object> data) {
		this.parent = parent;
		this.mainArea = mainArea;
		mainArea.addEventListener(CustomEvents.ON_IMGCLICK, this::createTestFile);
		Component mainScreen = Executions.createComponents(uri, parent, data);
		mainScreen.getFellow("TESTTREE").addEventListener(Events.ON_CLICK, this::findTestTree);
		mainScreen.getFellow("EVENTDEFTREE").addEventListener(Events.ON_CLICK, this::findEventDefTree);
		mainScreen.getFellow("TEST").addEventListener(Events.ON_CLICK, this::findTest);

		return mainScreen;
	}

	@Override
	public boolean isImplemented() {
		return true;
	}

	void copyTestTree(Event evt) throws Exception {
		ListValues<IDetachedRecord> tests = (ListValues<IDetachedRecord>) evt.getData();
		if (null != tests)
			for (IDetachedRecord testTreeDTO : tests) {
				IDetachedRecord copyFolder = copyTest(testTreeDTO);
				eventTree.getFolderList().createTreeNode(copyFolder);
			}
	}

	void createTestFile(Event evt) throws Exception {
		
		IDetachedRecord folder=(IDetachedRecord)   ((Treerow)evt.getData()).getAttribute("folder");
		IDetachedRecord item=(IDetachedRecord)   ((Treerow)evt.getData()).getAttribute("item");
		
	
		String fileName = item.getTable().getTableName() + "_" + item.getPk() + ".metadata";
		
		Files.deleteIfExists(new File(fileName).toPath());

		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		int i = 1;
		out.write("METADATA FOR "+item.getTable().getFullTableName()+"{");		out.newLine();	out.newLine();
		MetadataUtil.createItem(out, item, 1);
		out.write("}");									out.newLine();	out.newLine();
		out.write("METADATA FOR "+folder.getTable().getFullTableName()+"{");	out.newLine();	out.newLine();
		MetadataUtil.createItem(out, folder, 1);
		out.write("}");									out.newLine();	out.newLine();
		
		out.close();
		File file = new File(fileName);
		Filedownload.save(new File(fileName), new MimetypesFileTypeMap().getContentType(file));
			
	}

	public IDetachedRecord copyTest(IDetachedRecord folder) {

		IDetachedRecord copyfolder = MTHelper.getNewCopy(folder);
		IDetachedRecord testTreeDTO = new TestDTO().findByPk(folder.get(TreeHelper.getItemField(folder.getTable())));

		IDetachedRecord copy = MTHelper.getNewCopy(testTreeDTO);
		((TestDTO) copy).setTestname(((TestDTO) testTreeDTO).getTestname() + "(Copy)");
		copy.insert();
		((FolderDTO) copyfolder).setTestUuid(copy.getPk().toString());
		copyfolder.insert();

		return copyfolder;
	}

	void runTest(Event evt) throws Exception {
		ListValues<IDetachedRecord> tests = (ListValues<IDetachedRecord>) evt.getData();
		if (null != tests)
			for (IDetachedRecord test : tests) {
				TestDTO item;
				if (test instanceof TestDTO)
					item = (TestDTO) test;
				else
					item = (TestDTO) new TestDTO().findByPk(((FolderDTO) test).getTestUuid());
				new TestRunnerController((TestDTO) MTHelper.getTableFromView(item));
			}
	}

	void findTest(Event evt) throws Exception {
		mainArea.getChildren().clear();

		CrudScreen crud = new CrudScreen();
		crud.init(MTtestRunnerData.TESTTREE, mainArea);
		crud.getFilteredGrid().addHeaderButton("CRUDSCREEN_RUN",Zklabel.getLabel("Run"), ButtonCssClass.COLOR_SECONDARY)
				.addEventListener(CustomEvents.ON_HEADERBUTTON_CLICK, this::runTest);
		crud.build();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU, parent, null);
	}

	void findTestTree(Event evt) throws Exception {
		mainArea.getChildren().clear();
		eventTree = new TreeController(MTtestRunnerData.FOLDER, mainArea, null);
		mainArea.addEventListener(CustomEvents.ON_IMGCLICK, this::createTestFile);
		eventTree.addHeaderButton(Zklabel.getLabel("copy"), ButtonCssClass.COLOR_PRIMARY)
				.addEventListener(CustomEvents.ON_HEADERBUTTON_CLICK, this::copyTestTree);
		eventTree.addHeaderButton(Zklabel.getLabel("run"), ButtonCssClass.COLOR_SECONDARY)
				.addEventListener(CustomEvents.ON_HEADERBUTTON_CLICK, this::runTest);

		eventTree.render();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU, parent, null);
	}

	void findEventDefTree(Event evt) throws Exception {
		mainArea.getChildren().clear();
		
		eventTree = new TreeController(MTtestRunnerData.EVENTDEFFOLDER, mainArea, null);
		eventTree.render();
		Events.sendEvent(CustomEvents.ON_COLAPSEMENU, parent, null);
	}

	@Override
	public String getProviderName() {
		return "poyake-testrunner";
	}
}
