package com.jsantos.custom.cell;

import java.util.LinkedHashMap;
import java.util.Locale;

import org.zkoss.zk.ui.Component;

import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class GridCellComponentProvider {
	static final LinkedHashMap<String, IGridCellBuilder> byMTField = new LinkedHashMap<>();
	static final LinkedHashMap<String, IGridCellBuilder> byModelDataType = new LinkedHashMap<>();

	public static IGridCellBuilder getCellBuilder(MTField field) {
		try {

			if (null != byMTField.get(field.getFullyQualifiedName()))
				return byMTField.get(field.getFullyQualifiedName()).getClass().newInstance();
			if (null!=field.getSameAs() && null != byMTField.get(field.getSameAs().getFullyQualifiedName()))
				return byMTField.get(field.getSameAs().getFullyQualifiedName()).getClass().newInstance();
			if (null != byModelDataType.get(field.getDataType().getName()))
				return byModelDataType.get(field.getDataType().getName()).getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	public static Component buildAndInitializeGridComponent(MTField field, Object value, IDetachedRecord values,
			Locale locale) {
		if (null == value)
			return null;
		IGridCellBuilder builder = getCellBuilder(field);
		if (null != builder)
			return builder.buildGridComponent(field, value, values, locale);
		return null;
	}

	

	public static void logBindings() {
		System.out.println("Grid Field Component Provider: =================================================");
		for (String modelDataType : byModelDataType.keySet())
			System.out.println("\t DataType: " + modelDataType + " -> "
					+ byModelDataType.get(modelDataType).getClass().getSimpleName());
		for (String field : byMTField.keySet())
			System.out.println("\t Entity Field: " + field+ " -> "
					+ byMTField.get(field).getClass().getSimpleName());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("");
	}

	public static void putBymtfield(MTField field, IGridCellBuilder fieldComponent) {
		byMTField.put(field.getFullyQualifiedName(), fieldComponent);
		
	}

	public static void putByModelDataType(MTDataType forModelType, IGridCellBuilder fieldComponent) {
		byModelDataType.put(forModelType.getName(), fieldComponent);
		
	}
}
