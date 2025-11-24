package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;

import java.net.URISyntaxException;

import org.eclipse.emf.common.util.URI;

import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.SqlFileDependency;
import com.jsantos.metadata.plugin.util.EclipseFileUtil;

public class ViewSQLGenerator {
	
	public static String renderCreate(Entity entity, DependencySqlGenerator dependencySqlGenerator) throws URISyntaxException {
		StringBuffer out = new StringBuffer();
		
		System.out.println(entity.eResource().getURI());
		//dependencies
		if (null !=entity.getSqlFileDependencies()) {
			for (SqlFileDependency dependency:entity.getSqlFileDependencies()) {
				try {
					String fileName = dependency.getSqlFileDependency();
					URI uri = EclipseFileUtil.buildFileURI(entity, fileName);
					dependencySqlGenerator.render(out, uri, fileName);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (null != entity.getFromSQLFile()) {
			String fileName = entity.getFromSQLFile();
			URI uri = EclipseFileUtil.buildFileURI(entity, fileName);
			dependencySqlGenerator.render(out, uri, fileName);
		}
		return out.toString();
	}
	
		
	public static String renderDrop(Entity entity) {
		return "DROP VIEW " + entity.getName();
		
	}
}
