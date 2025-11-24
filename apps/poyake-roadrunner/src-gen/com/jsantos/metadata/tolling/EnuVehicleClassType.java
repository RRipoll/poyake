package com.jsantos.metadata.tolling;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.label.Label;

public class EnuVehicleClassType extends MTEnumeration{
	static protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();
	static protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();
	static protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();

	public static final int UNKNOWN = 1;
	public static final int CARXPORTER = 2;
	public static final int AUTOSUV = 3;
	public static final int BUS = 4;
	public static final int MINIBUS = 5;
	public static final int MOTORCYCLE = 6;
	public static final int PICKUP = 7;
	public static final int RV = 8;
	public static final int TANDEM = 9;
	public static final int MOBHOME = 10;
	public static final int TRACTRLER = 11;
	public static final int TRUCKS = 12;
	public static final int PASSVAN = 13;

	static {
		values.put(1,"Unknown Vehicle Type");
		shortCodes.put("UNKNOWN",1);
		labels.put(1, new ArrayList<Label>());
		values.put(2,"AUTO TRANSPORTER");
		shortCodes.put("CARXPORTER",2);
		labels.put(2, new ArrayList<Label>());
		values.put(3,"AUTOMOBILE/SPORT UTILITY VEHICLE");
		shortCodes.put("AUTOSUV",3);
		labels.put(3, new ArrayList<Label>());
		values.put(4,"BUSES");
		shortCodes.put("BUS",4);
		labels.put(4, new ArrayList<Label>());
		values.put(5,"MINIBUS/TEAM VAN/STRETCH LIMO S  Seating 10-15 passengers");
		shortCodes.put("MINIBUS",5);
		labels.put(5, new ArrayList<Label>());
		values.put(6,"MOTORCYCLE");
		shortCodes.put("MOTORCYCLE",6);
		labels.put(6, new ArrayList<Label>());
		values.put(7,"PICK-UP TRUCK");
		shortCodes.put("PICKUP",7);
		labels.put(7, new ArrayList<Label>());
		values.put(8,"RECREATIONAL VEHICLE RV OR MOTOR HOME");
		shortCodes.put("RV",8);
		labels.put(8, new ArrayList<Label>());
		values.put(9,"TANDEM TRAILER COMBINATION  TRACTOR WITH 2 TRAILERS");
		shortCodes.put("TANDEM",9);
		labels.put(9, new ArrayList<Label>());
		values.put(10,"TRACTOR/MOBILE HOME COMBINATION");
		shortCodes.put("MOBHOME",10);
		labels.put(10, new ArrayList<Label>());
		values.put(11,"TRACTOR TRAILER COMBINATION");
		shortCodes.put("TRACTRLER",11);
		labels.put(11, new ArrayList<Label>());
		values.put(12,"TRUCKS");
		shortCodes.put("TRUCKS",12);
		labels.put(12, new ArrayList<Label>());
		values.put(13,"PASSENGER/CARGO VAN  Seating 1-9 passengers");
		shortCodes.put("PASSVAN",13);
		labels.put(13, new ArrayList<Label>());
	}

	@Override
	public LinkedHashMap<Integer, String> getHashmap() {
		return values;
	}

	@Override
	public LinkedHashMap<String, Integer> getShortCodes() {
		return shortCodes;
	}
	@Override
	public LinkedHashMap<Integer, ArrayList<Label>> getLabels() {
		return labels;
	}
}