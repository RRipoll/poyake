package com.jsantos.auditimmo.orm;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import com.jsantos.metadata.general.MTTableTEMPLATE;
import com.jsantos.metadata.general.TemplateDTO;
import com.jsantos.orm.fileexport.service.FileLoader;

import freemarker.cache.TemplateLoader;

public class FileTemplateLoader implements TemplateLoader{
	


@Override
public Object findTemplateSource(String template) throws IOException {
	Integer templateTypeId=Integer.parseInt(template.substring(0,template.indexOf("_")));
	String locale=template.substring(template.indexOf("_")+1);
	return  new TemplateDTO("enutemplatetypeId="+templateTypeId+" and enulocaleId=(select enulocaleid from config.enulocale where shortcode= '"+locale+"')");
}

@Override
public long getLastModified(Object templateSource) {
	return ((TemplateDTO)templateSource).getPostingDate().getTime();
}

@Override
public Reader getReader(Object templateSource, String encoding) throws IOException {
	return new StringReader(((TemplateDTO) templateSource).getBody());
}

@Override
public void closeTemplateSource(Object templateSource) throws IOException {
	
}
}
