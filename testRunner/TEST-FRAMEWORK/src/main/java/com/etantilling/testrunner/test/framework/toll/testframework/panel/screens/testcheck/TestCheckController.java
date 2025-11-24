package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.testcheck;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Messagebox;

import com.etantolling.testrunner.test.zkweb.IPanel;

public class TestCheckController implements Composer, EventListener<Event> ,IPanel{
	
	private Component panel;
	TestCheckView view;
	 private LinkedHashMap<Integer,Integer> sequenceNumberByFileRefId = new LinkedHashMap<Integer,Integer>();
	 private LinkedHashMap<Integer,Integer> fileWithIncorrectSequenceNumberByFileRefId = new LinkedHashMap<Integer,Integer>();
	 StringBuilder sb =null;
	 Vector<Integer> correctSequences = new Vector<Integer>();
	 LinkedHashMap<Integer,String> fileRefIdToBeUpdated = new LinkedHashMap<Integer,String>();
	 private static final Logger log = LoggerFactory.getLogger(TestCheckController.class);
	public void doAfterCompose(Component panel) throws Exception {
        this.panel=panel;       
	    layout();
	}

	@Override
	public Component getPanel() {
		return panel;
	}

	@Override
	public void layout() throws SQLException {
		view=new TestCheckView(panel,this);
	}
	@Override
	public void refresh() throws SQLException  {
	view.dtc.render();
	
	}
	

	@Override
	public void setId(Object Id) {
	}

	@Override
	public void onEvent(Event event) throws Exception {	  
		if(event.getTarget().equals(view.getCheckBtn())){
			clearCollections();
			sb= new StringBuilder();
		 String testIdstr = view.getTestIdTb().getValue();
		 if(null!=testIdstr && StringUtils.isNumeric(testIdstr)&&!StringUtils.isEmpty(testIdstr)){
		   Integer testId = Integer.parseInt(testIdstr);
		    view.getFilesToBeChecked(testId);
		    for(Integer fileRefId : view.getFileUrlByFileRefId().keySet()){
		    	this.getSequenceNumberByFileRefId(fileRefId, view.getFileUrlByFileRefId().get(fileRefId));
		    }
		    this.getFilesWithIncorrectSequence();
		    view .getResultsTb().setValue(sb.toString());
		    if(this.getFileWithIncorrectSequenceNumberByFileRefId().size()>0){
		    	view.getFixSequenceNumber().setDisabled(false);
		    }else{
		    	Messagebox.show("No problems found \n ", "Alert", Messagebox.OK, Messagebox.INFORMATION);
		    }
		 }else{
			 Messagebox.show("Please enter a correct test Id. \n ", "Alert", Messagebox.OK, Messagebox.EXCLAMATION);
		 }
		}
		if(event.getTarget().equals(view.getFixSequenceNumber())){
			this.fixFilesSequeceNumber();
		}
		
			
	}
	
	public void getSequenceNumberByFileRefId(Integer fileRefId,String fileUrl){
		try {
			Cell cell = null;
			FileInputStream file = new FileInputStream(new File(fileUrl));//new File("/nasshare/tests/test_15764/event_30557/14887_AccountViolationStatus.xlsx"));
            if(view.getFileNameByFileRefId().get(fileRefId).endsWith(".xlsx")){
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
				cell = sheet.getRow(7).getCell(4);
				workbook.close();
            }else if(view.getFileNameByFileRefId().get(fileRefId).endsWith(".xls")){
            	HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheetAt(0);
				cell = sheet.getRow(7).getCell(4);
				workbook.close();
            }else {
            	file.close();
            	return;
            }  
			
			this.sequenceNumberByFileRefId.put(fileRefId, Integer.valueOf((int)cell.getNumericCellValue()));			
			
		} catch (FileNotFoundException e) {
			log.error("ERROR STACKTRACE:",e);
		} catch (IOException e) {
			log.error("ERROR STACKTRACE:",e);
		}
	}
	
	public void getFilesWithIncorrectSequence(){
		Integer antFileRefId = null;
		Integer antFileSequence = null;
		boolean addFileToBeUpdated = false;
		fileWithIncorrectSequenceNumberByFileRefId.clear();
		this.correctSequences.clear();
		fileRefIdToBeUpdated.clear();
		for(Integer fileRefId:this.getSequecesByFileRefId().keySet()){
			if(null==antFileRefId){
				antFileRefId = fileRefId;
				antFileSequence = this.getSequecesByFileRefId().get(fileRefId);
			}
			if(fileRefId!=antFileRefId){
				if(antFileSequence+1!=this.getSequecesByFileRefId().get(fileRefId)){
					fileWithIncorrectSequenceNumberByFileRefId.put(fileRefId, getSequecesByFileRefId().get(fileRefId));
					this.correctSequences.add(antFileSequence);					
					if(StringUtils.isNotEmpty(sb.toString()))sb.append("\n");
					sb.append(getSequecesByFileRefId().get(fileRefId));
					sb.append(" | ");
					sb.append(view.getPostingDateByFileRefId().get(fileRefId));
					sb.append(" | ");
					sb.append(view.getEventIdByFileRefId().get(fileRefId));
					sb.append(" | ");
					sb.append(view.getFileNameByFileRefId().get(fileRefId));
					addFileToBeUpdated = true;
				}
				if(addFileToBeUpdated)fileRefIdToBeUpdated.put(fileRefId,view.getFileUrlByFileRefId().get(fileRefId));
				antFileRefId = fileRefId;
				antFileSequence = this.getSequecesByFileRefId().get(fileRefId);
			}
			
		}
	}
	public void fixFilesSequeceNumber(){
		Integer lastFileileCorrectSequence = this.correctSequences.get(0);
		for(Integer fileRefId : fileRefIdToBeUpdated.keySet()){			
				lastFileileCorrectSequence++;
				try {
					Cell cell = null;
					FileInputStream file = new FileInputStream(new File(fileRefIdToBeUpdated.get(fileRefId)));
		            if(view.getFileNameByFileRefId().get(fileRefId).endsWith(".xlsx")){
						XSSFWorkbook workbook = new XSSFWorkbook(file);
						XSSFSheet sheet = workbook.getSheetAt(0);
						cell = sheet.getRow(7).getCell(4);
						cell.setCellValue(lastFileileCorrectSequence);
						file.close();						
						FileOutputStream outFile =new FileOutputStream(new File(fileRefIdToBeUpdated.get(fileRefId)));
						workbook.write(outFile);
						outFile.close();
						workbook.close();
		            }else if(view.getFileNameByFileRefId().get(fileRefId).endsWith(".xls")){
		            	HSSFWorkbook workbook = new HSSFWorkbook(file);
						HSSFSheet sheet = workbook.getSheetAt(0);
						cell = sheet.getRow(7).getCell(4);
						cell.setCellValue(lastFileileCorrectSequence);
						file.close();						
						FileOutputStream outFile =new FileOutputStream(new File(fileRefIdToBeUpdated.get(fileRefId)));//"C:\\update.xls"));
						workbook.write(outFile);
						outFile.close();
						workbook.close();
		            }else {
		            	file.close();
		            	return;
		            }					
				} catch (FileNotFoundException e) {
					log.error("ERROR STACKTRACE:",e);
				} catch (IOException e) {
					log.error("ERROR STACKTRACE:",e);
				}
			log.info("Sequence Update for file:"+fileRefIdToBeUpdated.get(fileRefId));
			
		}
		Messagebox.show("The Sequence numbers have been fixed correctly. \n ", "Success", Messagebox.OK, Messagebox.INFORMATION);
		view.getFixSequenceNumber().setDisabled(true);
		
	}
	public LinkedHashMap<Integer,Integer> getSequecesByFileRefId(){
		return this.sequenceNumberByFileRefId;
	}
	public LinkedHashMap<Integer,Integer> getFileWithIncorrectSequenceNumberByFileRefId(){
		return fileWithIncorrectSequenceNumberByFileRefId;
	}
	public void clearCollections(){
		fileWithIncorrectSequenceNumberByFileRefId.clear();
		this.correctSequences.clear();
		sequenceNumberByFileRefId.clear();
		fileRefIdToBeUpdated.clear();
	}
}