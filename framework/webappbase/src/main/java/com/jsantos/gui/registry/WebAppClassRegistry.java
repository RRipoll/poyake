package com.jsantos.gui.registry;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.springframework.core.io.Resource;

import com.jsantos.custom.cell.GridCellComponentProvider;
import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.custom.customfield.CustomFieldContainerProvider;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.filter.FilterFieldComponentProvider;
import com.jsantos.custom.filter.IFilterComponent;
import com.jsantos.custom.menu.IMenuProvider;
import com.jsantos.custom.menu.MenuProvider;
import com.jsantos.gui.detail.DetailContainerProvider;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

public class WebAppClassRegistry {
	private static String GUI_PACKAGE = "com.jsantos.custom";
	private static String SERVICE_PACKAGE = "com.jsantos.service";
	public static void loadClasses() {
		ClassGraph classGraph = new ClassGraph();
		classGraph.whitelistPackages(GUI_PACKAGE);
		classGraph.whitelistPackages(SERVICE_PACKAGE);
		
		try (ScanResult scanResult = classGraph.scan()) {

			System.out.println("---------------------------------GRID CELL BUILDERS--------------------------------");
			System.out.println(GUI_PACKAGE+".cell.IGridCellBuilder");

			// GRID CELL BUILDERS
			for (ClassInfo info:scanResult.getClassesImplementing(GUI_PACKAGE+".cell.IGridCellBuilder")){
	    		Class<?> clazz = Class.forName(info.getName());
	    		if (!info.isAbstract() && hasParameterlessPublicConstructor(clazz)) {
					IGridCellBuilder fieldComponent = (IGridCellBuilder) clazz.newInstance();
					if (null != fieldComponent.forField()) 
						GridCellComponentProvider.putBymtfield(fieldComponent.forField(), fieldComponent);
					if (null != fieldComponent.forModelType()) 
						GridCellComponentProvider.putByModelDataType(fieldComponent.forModelType(), fieldComponent);
					System.out.println("Registered cell Renderer: " + clazz.getName());
	    		}
			}			
			GridCellComponentProvider.logBindings();
				
			
			// FILTER COMPONENTS
			System.out.println("----------------------------------FILTER COMPONENTS--------------------------------");
			System.out.println(GUI_PACKAGE + ".filter.IFilterComponent");
			for (ClassInfo info : scanResult.getClassesImplementing(GUI_PACKAGE + ".filter.IFilterComponent")) {
				Class<?> clazz = Class.forName(info.getName());
				if (Modifier.isAbstract(clazz.getModifiers()))
					continue;
				IFilterComponent fieldComponent = (IFilterComponent) clazz.newInstance();
				if (null != fieldComponent.forField()) {
					FilterFieldComponentProvider.putBymtfield(fieldComponent.forField(),
							(IFilterComponent) fieldComponent);
					System.out.println("Registered filter Renderer: " + clazz.getName());
				} else if (null != fieldComponent.forModelType()) {
					FilterFieldComponentProvider.putByModelDataType(fieldComponent.forModelType(),
							fieldComponent);
					System.out.println("Registered filter Renderer: " + clazz.getName());
				}
			}
			FilterFieldComponentProvider.logBindings();

			// CUSTOM FIELD CONTAINERS
			System.out.println("------------------------------CUSTOM FIELD CONTAINERS------------------------------");
			System.out.println(GUI_PACKAGE + ".customfield.IMTComponent");
			for (ClassInfo info : scanResult
					.getClassesImplementing(GUI_PACKAGE + ".customfield.IMTComponent")) {
				Class<?> clazz = Class.forName(info.getName());
				IMTComponent container =  (IMTComponent) clazz.newInstance();

				if (null != container.forPKTable()) {
					CustomFieldContainerProvider.putByPkTable(container.forPKTable(), container);
					System.out.println("Registered Custom Field Containers: " + clazz.getName());
				} else if (null != container.forField()) {
					CustomFieldContainerProvider.putBymtfield(container.forField(), container);
					System.out.println("Registered Custom Field Containers: " + clazz.getName());
				} else if (null != container.forModelType()) {
					CustomFieldContainerProvider.putByModelDataType(container.forModelType(), container);
					System.out.println("Registered Custom Field Containers: " + clazz.getName());
				}
			}

			CustomFieldContainerProvider.logBindings();

			// DETAIL CONTAINER
			System.out.println("-------------------------------DETAIL CONTAINER------------------------------------");
			System.out.println(GUI_PACKAGE + ".detail.IDetailContainer");
			for (ClassInfo info : scanResult.getClassesImplementing(GUI_PACKAGE + ".detail.IDetailContainer")) {
				Class<?> clazz = Class.forName(info.getName());
				IDetailContainer container = (IDetailContainer) clazz.newInstance();

				if (null != container.getmTTable()) {
					DetailContainerProvider.putByTable(container.getmTTable(), container);
				System.out.println("Registered DetailContainer Renderer: " + clazz.getName());
			}}
			DetailContainerProvider.logBindings();
			
			
			// MENU PROVIDER
			System.out.println("-------------------------------MENU PROVIDER------------------------------------");
			System.out.println(GUI_PACKAGE + ".IMenuProvider");
			for (ClassInfo info : scanResult.getClassesImplementing(GUI_PACKAGE + ".menu.IMenuProvider")) {
				Class<?> clazz = Class.forName(info.getName());
				IMenuProvider provider = (IMenuProvider) clazz.newInstance();

				MenuProvider.put(provider);
				System.out.println("Menu Provider: " + clazz.getName());
			}
			MenuProvider.logBindings();
			
			
				
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

							

				
		
		
		
	}

	public static Object loadClass(Resource resource)
			throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		String className = resource.getURL().toString();
		// String classNameOriginal = resource.getURL().toString();
		try {
			className = className.substring(className.indexOf("!/") + 2, className.length());
			className = className.replace("/", ".");
			className = className.substring(0, className.lastIndexOf('.'));
			Class<?> clazz = Class.forName(className);
			return clazz.newInstance();
		} catch (InstantiationException | ClassNotFoundException e) {
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
