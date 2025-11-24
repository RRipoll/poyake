package com.jsantos.common.registry;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.List;

import org.springframework.core.io.Resource;

import com.jsantos.common.constraint.ConstraintsComponentProvider;
import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.fieldMapper.FieldMapperComponentProvider;
import com.jsantos.common.fieldMapper.IFieldMapper;
import com.jsantos.common.util.ListValues;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

public class AppClassRegistry {
	private static String GUI_PACKAGE = "com.jsantos.custom";

	
	public static Class<?> getClasses(String GUI_PACKAGE,String className) {
		ClassGraph classGraph = new ClassGraph();
		
		classGraph.whitelistPackages(GUI_PACKAGE);

		try (ScanResult scanResult = classGraph.scan()) {

			System.out.println("---------------------------------APPCLASSREGISTRY BUILDERS--------------------------------");
			System.out.println(GUI_PACKAGE+" "+className);

			for (ClassInfo info:scanResult.getClassesImplementing(className)){
	    		Class<?> clazz = Class.forName(info.getName());
	    		if (!info.isAbstract() && hasParameterlessPublicConstructor(clazz)) {
	    			System.out.println("Registered class : " + clazz.getName());
	    			return clazz;
	    		}
			}			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("no class found for " +GUI_PACKAGE+className );
		return null;

	}
	
	
	
	public static void loadClasses() {
		ClassGraph classGraph = new ClassGraph();
		classGraph.whitelistPackages(GUI_PACKAGE);

		try (ScanResult scanResult = classGraph.scan()) {
			
			// FIELD RENDERERS
			FieldRendererProvider.initialize();
			System.out.println("-----------------------------------FIELD RENDERER-------------------------------");
			System.out.println("com.jsantos.common.registry.IMTFieldRenderer");
			for (ClassInfo info:scanResult.getClassesImplementing("com.jsantos.common.registry.IMTFieldRenderer")){
	    		Class<?> clazz = Class.forName(info.getName());
    			IMTFieldRenderer fieldRenderer = (IMTFieldRenderer) clazz.newInstance();
				if (null != fieldRenderer.forField()) 
					FieldRendererProvider.putBymtfield(fieldRenderer.forField(), fieldRenderer);
				if (null != fieldRenderer.forModelDataType()) 
					FieldRendererProvider.putByModelDataType(fieldRenderer.forModelDataType(), fieldRenderer);
				System.out.println("Registered Field Renderer: " + clazz.getName());
		    }
			FieldRendererProvider.logBindings();

			
			
			
			
			// CUSTOM FIELD MAPPERS
			System.out.println("------------------------------CUSTOM FIELD MAPPERS------------------------------");
			System.out.println("com.jsantos.common.fieldMapper.IFieldMapper");
			for (ClassInfo info:scanResult.getClassesImplementing("com.jsantos.common.fieldMapper.IFieldMapper")){
	    		Class<?> clazz = Class.forName(info.getName());
	    		IFieldMapper container = (IFieldMapper)  clazz.newInstance();
	    		
	    		if (null != container.forField()) 
	    			FieldMapperComponentProvider.putBymtfield(container.forField(), container);
	    		if (null != container.forModelType()) 
	    			FieldMapperComponentProvider.putByModelDataType(container.forModelType(), container);
	    		System.out.println("Registered  Field Mapper: " + clazz.getName());
	    		
			}		

			FieldMapperComponentProvider.logBindings();
			
			
		
			// CUSTOM CONSTRAINTS
			System.out.println("--------------------------------CUSTOM CONSTRAINTS-------------------------------");
			System.out.println("com.jsantos.common.constraint.IConstraintsBuilder");
			for (ClassInfo info:scanResult.getClassesImplementing("com.jsantos.common.constraint.IConstraintsBuilder")){
	    		Class<?> clazz = Class.forName(info.getName());
				IConstraintsBuilder constraintComponent = (IConstraintsBuilder)  clazz.newInstance();
				if (null != constraintComponent.forField()) {
					List<IConstraintsBuilder> constraints=ConstraintsComponentProvider.getBymtfield(constraintComponent.forField());
					if(null==constraints)ConstraintsComponentProvider.putBymtfield(constraintComponent.forField(), new ListValues<IConstraintsBuilder>());
					ConstraintsComponentProvider.getBymtfield(constraintComponent.forField()).add(constraintComponent);
				}
				if (null != constraintComponent.forModelType()) {
					List<IConstraintsBuilder> constraints=ConstraintsComponentProvider.getByModelDataType(constraintComponent.forModelType());
					if(null==constraints)ConstraintsComponentProvider.putByModelDataType(constraintComponent.forModelType(), new ListValues<IConstraintsBuilder>());
					ConstraintsComponentProvider.getByModelDataType(constraintComponent.forModelType()).add(constraintComponent);
					}
				System.out.println("Registered Constraints Renderer: " + clazz.getName());
			}
			ConstraintsComponentProvider.logBindings();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	public static Object loadClass(Resource resource) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		String className = resource.getURL().toString();
		//String classNameOriginal = resource.getURL().toString();
		try{
			className = className.substring(className.indexOf("!/") +2, className.length());
			className = className.replace("/", ".");
			className = className.substring(0, className.lastIndexOf('.'));
			Class<?> clazz = Class.forName(className);
			return clazz.newInstance();
		}
		catch (InstantiationException|ClassNotFoundException e) {
			System.err.println("Couldn't instantiate class: " + className);
			throw e;
		}
	}
	
	static boolean hasParameterlessPublicConstructor(Class<?> clazz) {
	    for (Constructor<?> constructor : clazz.getConstructors()) {
	        if (constructor.getParameterCount() == 0) { 
	            return true;
	        }
	    }
	    return false;
	}

}
