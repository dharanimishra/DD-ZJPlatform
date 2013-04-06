package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum PropertyDataType {

	// TODO: retrieve the ids from the static data service
	NUMBER(), DATE(), PERCENTAGE(), ALPHANUMERIC();

	private int id;

	private String name;

	private final static String category = "Property Data Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		NUMBER.setID(mapUtil.get("Number").intValue());
		DATE.setID(mapUtil.get("Date").intValue());
		PERCENTAGE.setID(mapUtil.get("Percentage").intValue());
		ALPHANUMERIC.setID(mapUtil.get("Alphanumeric").intValue());
	}

	private PropertyDataType() {

	}

	private PropertyDataType(int id, String name) {
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

	public static PropertyDataType getPropertyDataType(int ID) {
		for (PropertyDataType dataType : PropertyDataType.values()) {
			if (dataType.getID() == ID) {
				return dataType;
			}
		}

		throw new NoSuchElementException("PropertyDataType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "PropertyDataType [" + getName() + "] ID [" + getID() + "]";
	}
}
