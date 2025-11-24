package com.jsantos.runningTest;

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
import org.zkoss.zul.Filedownload;

public class SystemOut {

	private static final Logger log = LoggerFactory.getLogger(SystemOut.class);
	private static boolean setToFile = true;
	private static PrintStream original=System.out;
	
	static public File setSystemOutToFile() {
		if (setToFile) {
			String fileNameTmp = "log_" + UUID.randomUUID().toString() + ".txt";
			String path = "../temp/";
			File file = new File(path);
			if (!file.exists())
				file.mkdirs();
			File tempFile = new File(path + fileNameTmp);
			try {
				tempFile.createNewFile();
			} catch (IOException e) {
				log.error("Couldnt create file: " + fileNameTmp);
			}
			if (tempFile.exists()) {
				PrintStream printStream = null;
				try {
					printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(tempFile)), true);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("System.out goes to :"+ tempFile.getName());
				System.setOut(printStream);
				System.setErr(printStream);
				
			}
			return tempFile;
		}
		return null;
	}

	static public File closeFileSystemLog(File tempFile) {

		if (setToFile) {
			System.out.flush();
			System.err.flush();
		}
		
		System.setOut(original);
		System.out.println("Return System.out from :"+ tempFile.getName());
		return tempFile;
	}

	static private void handleDownloadLog(File tempFile) {

		System.out.flush();
		System.err.flush();

		try {
			Filedownload.save(tempFile, new MimetypesFileTypeMap().getContentType(tempFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
