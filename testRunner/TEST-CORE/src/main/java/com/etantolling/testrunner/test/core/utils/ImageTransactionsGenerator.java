package com.etantolling.testrunner.test.core.utils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * This class is a homebrew tool to generate valid transaction files of type 1 (Ticketed transactions) based on 
 * the content of a folder with images following Kapsch naming convention (TKT_NUM_FRONT.jpg or REAR.jpg)
 * 
 * @author davidmartin
 *
 */
public class ImageTransactionsGenerator {

	private static final String KAPSCH = "KAPSCH";
	private static final String XEROX = "XEROX";
	private static String FORMAT = KAPSCH;
	private static Integer ETC_TRX_SERIAL_NUM = 1;
	private static String ETC_REVENUE_DATE = new SimpleDateFormat("yyyyMMdd").format(new Date());
	private static Calendar ETC_EXIT_TIME = Calendar.getInstance();
	private static String ETC_EXIT_PLAZA = "11";
	private static String ETC_EXIT_LANE = "S3"; 
	private static File inboundFolder;
	private static String outputFolder=".";
	
	public static void main(String[] args) throws Exception {
		if (args.length<1) throw new RuntimeException("Usage:ImageTransactionsGenerator inputImagesFolder [outputFolder] [KAPSCH | XEROX] [ETC_TRX_SERIAL_NUM] [ETC_REVENUE_DATE] [ETC_EXIT_PLAZA] [ETC_EXIT_LANE]");
		inboundFolder = new File(args[0]);
		for (int i=1; i<args.length; i++) {
			switch (i) {
			case 1:
				outputFolder = args[1];
				break;
			case 2:
				FORMAT = args[2];
				break;
			case 3:
				ETC_TRX_SERIAL_NUM = Integer.parseInt(args[3]);
				break;
			case 4:
				ETC_REVENUE_DATE = args[4];
				break;
			case 5:
				ETC_EXIT_PLAZA = args[5];
				break;
			case 6:
				ETC_EXIT_LANE = args[6];
				break;
			}
		}

		generateFile();
	}

	private static void generateFile() throws Exception {
		File imageFiles[] = inboundFolder.listFiles((directory, fileName) -> fileName.matches("^[0-9]{11}\\_FRONT.jpg"));
		List<String> lstXCTXRows = new LinkedList<String>();
		for (File imageFile: Arrays.asList(imageFiles)) {
			String line=StringUtils.leftPad(""+ETC_TRX_SERIAL_NUM++, 12, '0');
			line+=ETC_REVENUE_DATE;
			line+="T26"; //ETC_FAC_AGENCY CHAR(3)
			line+="B"; //ETC_TRX_TYPE CHAR(1)
			if (FORMAT.equals(XEROX)) {
				line+="********"; //ETC_ENTRY_DATE CHAR(8)
				line+="******"; //ETC_ENTRY_TIME CHAR(6)
				line+="***"; //ETC_ENTRY_PLAZA CHAR(3)
				line+="***"; //ETC_ENTRY_LANE CHAR(3)
			}
			line+="***"; //AVI_TAG_AGENCY CHAR(3) notag violation = ***
			line+="********"; //AVI_TAG_SERIAL_NUMBER CHAR(8) notag = ********
			line+="**"; //AVI_READ_PERFORMANCE CHAR(2) notag = **
			line+="**"; //AVI_WRITE_PERFORMANCE CHAR(2) notag = **
			line+="*"; //AVI_TAG_PGM_STATUS CHAR(1) notag = *
			line+="E"; //ETC_LANE_MODE CHAR(1) E=ETC
			line+="*"; //AVI_VALIDATION_STATUS CHAR(1) notag = *
			line+="**"; //VES_CONFIDENCE CHAR(2) 00 to 99 only for ETC lanes. We keep as null for now (low confidence)
			line+="**********"; //VES_LIC_PLATE CHAR(10) ********** for lowconfidence OCR
			line+="****"; //IAG_CLASS_READ CHAR(4) **** For untagged violation when lane is operating in ETC-only mode
			line+="02"; // AVC_ACTUAL_AXLES CHAR(2) 00to96
			line+="060"; // ETC_EXIT_SPEED CHAR(3)
			line+="N"; // ETC_OVER_SPEED CHAR(1) N=No speeding violation (violation type2)
			ETC_EXIT_TIME.add(Calendar.SECOND, 20); // We have to add sometime between transactions to avoid firing the duplicate check rule at the BOS
			if (FORMAT.equals(XEROX)) {
				line+=ETC_REVENUE_DATE; // ETC_EXIT_DATE CHAR(8) = ETC_REVENUE_DATE
				line+=new SimpleDateFormat("hhmmss").format(ETC_EXIT_TIME.getTime()); // ETC_EXIT_TIME CHAR(6) hhmmss
			}
			line+=StringUtils.rightPad(ETC_EXIT_PLAZA,3,' '); //ETC_EXIT_PLAZA CHAR(3) in the production files it looks like they use 2chars right padded with spaces.
			line+=StringUtils.rightPad(ETC_EXIT_LANE,3,' '); //ETC_EXIT_LANE CHAR(3) in the production files it looks like they use 2chars right padded with spaces.
			if (FORMAT.equals(KAPSCH)) {
				line+=ETC_REVENUE_DATE; // ETC_EXIT_DATE CHAR(8) = ETC_REVENUE_DATE
				line+=new SimpleDateFormat("hhmmss").format(ETC_EXIT_TIME.getTime()); // ETC_EXIT_TIME CHAR(6) hhmmss
				line+=new SimpleDateFormat("SSS").format(ETC_EXIT_TIME.getTime()) + "000"; // ETC_EXIT_MICROSECOND CHAR(6) hhmmss
			}
			line+="+"; //ETC_DEBIT_CREDIT CHAR(1) always +
			line+="**"; //AVI_NHDOT_CLASS CHAR(2) ** when AVI not available
			line+="*****"; //AVI_NHDOT_FARE CHAR(5) ***** when AVI not available
			if (FORMAT.equals(KAPSCH)){
				line+="1"; // VIOLATION_TYPE CHAR(1) 0=normal, 1=type1 (untagged), 2=type2 (speeding)
			}
			line+="01"; //AVC_NHDOT_CLASS CHAR(2) we set class always to 01
			line+="00999"; //AVC_NHDOT_FARE CHAR(5) we set the fare always to $9.99 to identify easily these transactions in the TollEvent and TollTransaction tables.
			line+=StringUtils.leftPad(imageFile.getName().split("\\_")[0], 11, "0"); // TKT_NUM
			lstXCTXRows.add(line);
		}
		// HEADER
		String header=(FORMAT.equals(XEROX))?"XCTX":"XOTX";
		header+="T26";
		header+=(FORMAT.equals(XEROX))?"V26":"X26";
		header+=ETC_REVENUE_DATE; // FILE_DATE
		header+="235959"; // FILE_TIME
		header+=StringUtils.leftPad(""+lstXCTXRows.size(), 8, '0'); // RECORD_COUNT
		header+="000001";
		lstXCTXRows.add(0, header);
		// FILE NAME
		String outputFileName=(FORMAT.equals(XEROX))?"T26_V26_":"C26_";
		outputFileName+=ETC_REVENUE_DATE + "235959";
		outputFileName+=(FORMAT.equals(XEROX))?".XCTX":".XOTX";
		Files.write(new File(outputFolder + "/" + outputFileName).toPath(),lstXCTXRows,Charset.defaultCharset(),StandardOpenOption.CREATE_NEW);
	}
}
