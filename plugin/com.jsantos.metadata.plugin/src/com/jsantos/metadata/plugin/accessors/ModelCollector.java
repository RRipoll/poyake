package com.jsantos.metadata.plugin.accessors;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.metaDsl.Configuration;
import com.jsantos.metadata.plugin.metaDsl.Entity;

public class ModelCollector {
	ArrayList<Entity> entities = new ArrayList<>();
	Configuration configuration = null;
	
	public ModelCollector(String project) throws CoreException{
		ResourceSet rSet = new ResourceCollector().collectResources(project);
		EcoreUtil2.resolveAll(rSet);

		
		Iterators.<Entity>filter(rSet.getAllContents(), Entity.class).forEachRemaining(
				entity -> {
					if (!entities.contains(entity))
						entities.add(entity);
				}
				);
		
		Iterators.<Configuration>filter(rSet.getAllContents(), Configuration.class).forEachRemaining(
				configuration -> {
					this.configuration = configuration;
				}
				);			
		
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

}
