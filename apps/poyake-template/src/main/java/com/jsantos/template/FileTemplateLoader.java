package com.jsantos.template;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import com.jsantos.metadata.common.TemplateDTO;

import freemarker.cache.TemplateLoader;

public class FileTemplateLoader implements TemplateLoader{
	


@Override
public Object findTemplateSource(String template) throws IOException {
	Integer templateTypeId=Integer.parseInt(template.substring(0,template.indexOf("_")));
	return  new TemplateDTO("enutemplatetypeId="+templateTypeId);

}

@Override
public long getLastModified(Object templateSource) {
	return ((TemplateDTO)templateSource).getCreated().getTime();
}

@Override
public Reader getReader(Object templateSource, String encoding) throws IOException {
	return new StringReader(((TemplateDTO) templateSource).getBody());
}

@Override
public void closeTemplateSource(Object templateSource) throws IOException {
	
}
}
