package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum PropertyUsageType {

	// TODO: retrieve the ids from the static data service
	DEFINITION(), // Course Addnl property
	VALIDATION(), // Member Addnl property
	ANALYTICS(); // Curriculum Addnl property

	private int id;

	private String name;

	private final static String category = "Property Usage Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		DEFINITION.setID(mapUtil.get("Definition").intValue());
		VALIDATION.setID(mapUtil.get("Validation").intValue());
		ANALYTICS.setID(mapUtil.get("Analytics").intValue());

	}

	private PropertyUsageType() {

	}

	private void setID(int id) {
		this.id = id;
	}

	private PropertyUsageType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PropertyUsageType getPropertyUsageType(int ID) {
		for (PropertyUsageType usageType : PropertyUsageType.values()) {
			if (usageType.getID() == ID) {
				return usageType;
			}
		}

		throw new NoSuchElementException("Property UsageType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Property UsageType [" + getName() + "] ID [" + getID() + "]";
	}
}
