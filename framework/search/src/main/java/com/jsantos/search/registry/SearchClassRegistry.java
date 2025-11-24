package com.jsantos.search.registry;

import java.lang.reflect.Modifier;

import com.jsantos.custom.sqlextended.ISqlExtended;
import com.jsantos.search.sqlextended.SqlExtended;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

public class SearchClassRegistry {

	private static String GUI_PACKAGE = "com.jsantos.custom";

	public static void loadClasses() {
		ClassGraph classGraph = new ClassGraph();
		classGraph.whitelistPackages(GUI_PACKAGE);

		try (ScanResult scanResult = classGraph.scan()) {

			// SQLEXTENDED COMPONENTS
			System.out.println(
					"----------------------------------SQLEXTENDED COMPONENTS--------------------------------");
			System.out.println(GUI_PACKAGE + ".sqlextended.ISqlExtended");
			for (ClassInfo info : scanResult.getClassesImplementing(GUI_PACKAGE + ".sqlextended.ISqlExtended")) {
				Class<?> clazz = Class.forName(info.getName());
				if (Modifier.isAbstract(clazz.getModifiers()))
					continue;
				ISqlExtended sqlComponent = (ISqlExtended) clazz.newInstance();
				if (null != sqlComponent.forField()) {
					SqlExtendedProvider.putBymtfield(sqlComponent.forField(), (SqlExtended) sqlComponent);
					System.out.println("Registered SqlExtended Renderer: " + clazz.getName());
				} else if (null != sqlComponent.forModelType()) {
					SqlExtendedProvider.putByModelDataType(sqlComponent.forModelType(), sqlComponent);
					System.out.println("Registered SqlExtended Renderer: " + clazz.getName());
				}
			}
			SqlExtendedProvider.logBindings();
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
