package com.jsantos.runningTest;

import java.util.ArrayList;
import java.util.HashMap;

import com.jsantos.common.util.MapValues;
import com.jsantos.metadata.testrunner.EventTypeDTO;
import com.jsantos.service.ITestEventRunner;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

public class TestEventTypeFactory {

	static final HashMap<String, ITestEventRunner> eventTypeRegistry = new HashMap<>();
	private static String GUI_PACKAGE = "com.jsantos.custom.eventRunner";
	private static String className =   "com.jsantos.custom.service.ITestEventRunner";
	private static ArrayList<String> paths = new ArrayList<String>();
	private static ITestEventRunner defaultEventRunner;// = new RestWebService();
	private static MapValues<EventTypeDTO> types= new MapValues<EventTypeDTO>();
	
	public static MapValues<EventTypeDTO> getTypes() {
		if (types.isEmpty())
			init();
		return types;
	}

	public static void setTypes(MapValues<EventTypeDTO> types) {
		TestEventTypeFactory.types = types;
	}

	public static HashMap<String, ITestEventRunner> getEventtypeRegistry() {
		if (eventTypeRegistry.isEmpty())
			init();
		return eventTypeRegistry;
	}

	public static void init() {
		loadClasses();
		logInfo();
	}

	public static ITestEventRunner getProvider(String eventTypeId) {
		if (eventTypeRegistry.isEmpty())
			init();
		return get(eventTypeId);
	}

	public static ITestEventRunner get(String eventType) {
		ITestEventRunner retValue = eventTypeRegistry.get(eventType);
		if (null == retValue)
			retValue = defaultEventRunner;
		return retValue;
	}

	public static void loadClasses() {
		ClassGraph classGraph = new ClassGraph();
		paths.add(GUI_PACKAGE);
		
		for (String path : paths) {
			classGraph.whitelistPackages(path);
		}
		try (ScanResult scanResult = classGraph.scan()) {

			for (ClassInfo info : scanResult.getAllClasses()) {
				
				//if(info instanceof ITestEventRunner) {
				try {
					Class<?> clazz = Class.forName(info.getName());
					ITestEventRunner dto = (ITestEventRunner) clazz.newInstance();
					//ITestEventRunner dto = (ITestEventRunner) clazz.newInstance();
					EventTypeDTO eventType= new EventTypeDTO();
					eventType.setShortCode(dto.forEventType());
					eventType.setEventTypeId(dto.forEventType());
					eventType.setDescription(dto.getDescription());
					types.add(dto.forEventType(), eventType);
					eventTypeRegistry.put(dto.forEventType(), dto);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//}
			}
		}
	}

	public static void logInfo() {
		System.out.println("EventTypeRegistry: ==========================================");
		for (String eventName : eventTypeRegistry.keySet())
			System.out.println("\t" + eventTypeRegistry.get(eventName) + " ---> " + eventName);
		System.out.println("------------------------------------------------------");
		System.out.println("");
	}

	public static void put(String eventName, ITestEventRunner loadClass) {
		eventTypeRegistry.put(eventName, loadClass);
	}
}
