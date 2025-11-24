package com.etantolling.testrunner.test.core.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataUtil {

	 public static  <T> List<T> filter(List<T> list, Predicate<T> p){
	    	return list.stream().filter(record ->  p.test(record)).collect(Collectors.toList());
	 }
	 public static  <T> Vector<T> filter(Vector<T> list, Predicate<T> p){
		 List<T> data = list.stream().filter(record ->  p.test(record)).collect(Collectors.toList());
		 Vector<T> vct = new Vector<T>();
		 vct.addAll(data);
		 return vct;
	 }
	public static <T> List<T> getDuplicateItemsFromList(List<T> data) {
		Set<T> allItems = new HashSet<T>();
		return data.stream().filter(record -> !allItems.add(record)).collect(Collectors.toList());
	}
	public static <T> List<T> getDuplicateItemsFromListBasedOnComparator(List<T> data, Comparator<T> comparator) {
		Set<T> allItems = new TreeSet<T>(comparator);
		return data.stream().filter(record -> !allItems.add(record)).collect(Collectors.toList());
	}
	@SuppressWarnings("unchecked")
	public static <T> List<T> getListFromCommaSeparatedString(String commaSeparatedString) {
		List<T> items = (List<T>) Arrays.asList(commaSeparatedString.split("\\s*,\\s*"));
		return items;
	}
	
}
  