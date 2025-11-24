package com.etantolling.testrunner.test.zkweb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.activation.MimetypesFileTypeMap;

import org.zkoss.zul.Filedownload;

public class FileUtil {

	
	public static void ShowFile(File file) throws IOException{


		FileInputStream inputStream;

		inputStream = new FileInputStream(file);
		Filedownload.save(file, new MimetypesFileTypeMap().getContentType(file) );
		inputStream.close();

	}
	
}
