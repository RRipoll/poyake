package com.etantolling.testrunner.testrunner2.testrunnergui;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;

import javax.activation.MimetypesFileTypeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class TestResultController implements EventListener<Event> {

	private static final Logger log = LoggerFactory.getLogger(TestResultController.class);

	private Window modal;
	File tempFile;

	private TestRunnerController trc;

	public TestResultController(TestRunnerController trc) throws IOException {
		this.trc = trc;
		setSystemOutToFile();
	}

	public void showDialog() throws Exception{

		modal = (Window) Executions.createComponents("testresult.zul", null, null);

		((Label)modal.getFellow("TEST_ID")).setValue(trc.testId.toString());
		((Label)modal.getFellow("TEST_STATUS")).setValue(trc.trc.bTestSuccess ? "SUCCESS" : "ERROR");
		if(trc.trc.errorMessage != null) {
			modal.getFellow("hboxError").setVisible(true);
			((Textbox)modal.getFellow("TEST_ERROR")).setValue(trc.trc.errorMessage);
		}

		if(trc.trc.warningExists){
			modal.getFellow("hboxWarning").setVisible(true);
			((Label)modal.getFellow("TEST_WARNING")).setValue(trc.trc.warningMessage.toString());
		}

		modal.getFellow("btnOk").addEventListener(Events.ON_CLICK, this);
		modal.getFellow("btnViewLog").setVisible(false);
		modal.getFellow("btnDownloadLog").addEventListener(Events.ON_CLICK, this);
		modal.getFellow("btnViewWarnings").setVisible(false);

		modal.doModal();

	}

	private void setSystemOutToFile() throws IOException 
	{
		String fileNameTmp = "log_"+UUID.randomUUID().toString()+".txt";
		String path="../temp/";
		File file=new File(path);
		if(!file.exists()) file.mkdirs();
		tempFile = new File(path+fileNameTmp);
		//boolean result;
		try {
			//result=
			tempFile.createNewFile();
		} catch (IOException e) {
			log.error("Couldnt create file: " + tempFile.getCanonicalPath());
			path="./temp/";
			File fPath=new File(path);
			if(!fPath.exists()) fPath.mkdirs();
			tempFile = new File(path+fileNameTmp);
			log.error("Trying to  create file: " + tempFile.getCanonicalPath());
			//result=
			tempFile.createNewFile();
		}
		if(tempFile.exists()) {
			PrintStream printStream = null;
			try {
				printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(tempFile)), true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.setOut(printStream);
			System.setErr(printStream);
		}
	}

	@Override
	public void onEvent(Event event) throws Exception {
		switch (event.getTarget().getId()) {
		case "btnOk":
			handleOk();
			break;
		case "btnDownloadLog":
			handleDownloadLog();
			break;
		default:
			break;
		}
	}

	private void handleOk() {
		modal.detach();
	}
	private void handleDownloadLog() throws Exception {


		System.out.flush();
		System.err.flush();

		Filedownload.save(tempFile, new MimetypesFileTypeMap().getContentType(tempFile));
	}
	public File getTempFile() {
		return tempFile;
	}

	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
	}
}