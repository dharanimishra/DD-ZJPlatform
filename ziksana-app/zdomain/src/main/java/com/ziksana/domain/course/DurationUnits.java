package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum DurationUnits {

	// TODO: retrieve the ids from the static data service
	DAY(), WEEK(), MONTH();

	private int id;
	private String name;

	private final static String category = "Duration Unit";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		DAY.setID(mapUtil.get("Days").intValue());
		WEEK.setID(mapUtil.get("Weeks").intValue());
		MONTH.setID(mapUtil.get("Months").intValue());

	}

	private DurationUnits() {

	}

	private DurationUnits(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private void setID(int id) {
		this.id = id;

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
