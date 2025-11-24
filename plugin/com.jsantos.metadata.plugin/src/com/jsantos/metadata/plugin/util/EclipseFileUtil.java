package com.jsantos.metadata.plugin.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

import com.jsantos.metadata.plugin.metaDsl.Entity;

public class EclipseFileUtil {
	
	public static String readProjectFile(String platformPath) {
		    String result;
			try {
			    java.net.URL url = new java.net.URL("platform:/resource/" + platformPath);
			    InputStream is = url.openConnection().getInputStream();
				result = IOUtils.toString(is, StandardCharsets.UTF_8);
			    is.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		    return result;
	}

	public static String readProjectFile(URI uri) throws URISyntaxException, CoreException {
		URIConverter uriConverter = new ExtensibleURIConverterImpl();
		try {
			InputStream is = uriConverter.createInputStream(uri);
			String contents = IOUtils.toString(is, StandardCharsets.UTF_8);
		    is.close();
			return contents;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String readProjectFile(IFile file) throws CoreException {
		
	    String result;
		try {
		    InputStream is = file.getContents();
			result = IOUtils.toString(is, StandardCharsets.UTF_8);
		    is.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	    return result;
}
	
	public String readResourceFile(String fileName) throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		if (null == inputStream)
			throw new IOException("Resource doesn't exist " + fileName);
		String contents = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
		return contents;
	}
	
	public static URI buildFileURI(Entity entity, String dependencyResourcePath) throws URISyntaxException {
		String sUri;
		String entityUri = entity.eResource().getURI().toString();
		if (entityUri.contains(".jar!") && dependencyResourcePath.contains("src/main/resources")) {
			int start = dependencyResourcePath.indexOf("src/main/resources") + "src/main/resources".length();
			int end = dependencyResourcePath.length();
			sUri = entityUri.substring(0, entityUri.indexOf(".jar!") + 5)  + dependencyResourcePath.substring(start, end);
		}
		else { 
			sUri = "platform:/resource/" + dependencyResourcePath;
		}
		return URI.createURI(sUri);
	}
	
}
