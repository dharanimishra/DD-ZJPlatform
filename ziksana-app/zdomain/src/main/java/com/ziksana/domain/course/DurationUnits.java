package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author Ratnesh Kumar
 */

public enum DurationUnits {

	// TODO: retrieve the ids from the static data service
	DAY(1, "Days"), WEEK(2, "Weeks"), MONTH(3, "Months");

	private final int id;
	private final String name;

	private final static String category = "Duration Unit";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
//		EnumUtil enumUtil = new EnumUtil();
//		mapUtil = enumUtil.getEnumData(category);
//		System.out.println("Getting static values :category :mapUtil :"
//				+ mapUtil.size());
	}

	private DurationUnits(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static DurationUnits getDurationUnits(int ID) {
		for (DurationUnits units : DurationUnits.values()) {
			if (units.getID() == ID) {
				return units;
			}
		}

		throw new NoSuchElementException("DurationUnits ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Course Status [" + getName() + "] ID [" + getID() + "]";
	}
}
