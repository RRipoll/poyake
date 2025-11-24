package com.etantolling.testrunner.test.core.cli;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.etantolling.testrunner.test.core.cli.configfolder.ConfigFolderHelper;

public class JAXBHelper<T> {
	
	public T loadXmlFile(String filePath, String packageName) throws IOException{
    	try{
	        final JAXBContext jc = JAXBContext.newInstance(packageName);
	        final Unmarshaller u = jc.createUnmarshaller();
	        @SuppressWarnings("unchecked")
			final JAXBElement<T> menuElement = (JAXBElement<T>)u.unmarshal(new FileInputStream(filePath));

	        return menuElement.getValue();
    	}
    	catch (JAXBException e){
    		throw new IOException(e);
    	}
	}

	public T loadXmlString(String xml, String packageName) throws IOException{
    	try{
	        final JAXBContext jc = JAXBContext.newInstance(packageName);
	        final Unmarshaller u = jc.createUnmarshaller();
	        @SuppressWarnings("unchecked")
			final JAXBElement<T> menuElement = (JAXBElement<T>)u.unmarshal(new StringInputStream(xml));

	        return menuElement.getValue();
    	}
    	catch (JAXBException e){
    		throw new IOException(e);
    	}
	}
	
	public T loadConfigurationFile(String fileName, String packageName) throws IOException{
    	try{
	        final JAXBContext jc = JAXBContext.newInstance(packageName);
	        final Unmarshaller u = jc.createUnmarshaller();
	        File file = ConfigFolderHelper.getConfigFile(fileName);
	        System.out.println("Loading config file: " + file.getCanonicalPath());
	        @SuppressWarnings("unchecked")
			final JAXBElement<T> menuElement = (JAXBElement<T>)u.unmarshal(new FileInputStream(file));

	        return menuElement.getValue();
    	}
    	catch (JAXBException e){
    		throw new IOException(e);
    	}
	}
	
	class StringInputStream extends ByteArrayInputStream {

		public StringInputStream(String s) {
			super(s.getBytes());
		}

		public StringInputStream(String s, String charset) throws UnsupportedEncodingException {
			super(s.getBytes(charset));
		}
	}	
}
