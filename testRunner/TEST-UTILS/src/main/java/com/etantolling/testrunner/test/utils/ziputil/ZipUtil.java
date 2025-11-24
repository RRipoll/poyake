package com.etantolling.testrunner.test.utils.ziputil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ZipUtil{

	


	public static File compressZipfiles(File[] fileList , String outputFile, boolean deleteOriginal) throws IOException, FileNotFoundException {
	    ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream(outputFile));
	    compressFilesToZipfile(fileList, zipFile,deleteOriginal);
	    IOUtils.closeQuietly(zipFile);
	    return new File(outputFile);
	}

	
	private static void compressFilesToZipfile(File[] fileList , ZipOutputStream out, boolean deleteOriginal) throws IOException, FileNotFoundException {
	    for (File file : fileList) {
	        if(null==file)continue;
	    	if (file.isDirectory()) {
	            compressFilesToZipfile(file.listFiles(), out,deleteOriginal);
	        } else {
	            ZipEntry entry = new ZipEntry(file.getName());
	            out.putNextEntry(entry);

	            FileInputStream in = new FileInputStream(file.getAbsolutePath());
	            IOUtils.copy(in, out);
	            IOUtils.closeQuietly(in);
	            if(deleteOriginal)FileUtils.forceDelete(file);
	        }
	    }
	}
	
	public static File pack(String sourceDirPath, String zipFilePath) throws IOException {
	    Path p = Files.createFile(Paths.get(zipFilePath));
	    try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p))) {
	        Path pp = Paths.get(sourceDirPath);
	        Files.walk(pp)
	          .filter(path -> !Files.isDirectory(path))
	          .forEach(path -> {
	              ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
	              try {
	                  zs.putNextEntry(zipEntry);
	                  zs.write(Files.readAllBytes(path));
	                  zs.closeEntry();
	            } catch (Exception e) {
	                System.err.println(e);
	            }
	          });
	    }
	    return new File(zipFilePath); 
	}
	
}    