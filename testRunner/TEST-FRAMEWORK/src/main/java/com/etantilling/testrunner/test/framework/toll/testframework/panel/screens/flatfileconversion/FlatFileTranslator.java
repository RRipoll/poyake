package com.etantilling.testrunner.test.framework.toll.testframework.panel.screens.flatfileconversion;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface FlatFileTranslator {
	
	public File writeFileHeader(File toGenerateFile,String toTranslateFilePath) throws Exception ;
	public void writeTransactions( File toGenerateFile, String toTranslateFilePath) throws Exception;
	public XSSFCellStyle style(XSSFWorkbook workbook);
	public void log(String message);
	public String getLogHistory();

}
