package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum CourseUseType {

	// TODO: retrieve the ids from the static data service
	MAJOR(), MINOR(), ELECTIVE(), ADDITIONAL();

	private int id;

	private String name;

	private final static String category = "Course Use Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		MAJOR.setID(mapUtil.get("Major").intValue());
		MINOR.setID(mapUtil.get("Minor").intValue());
		ELECTIVE.setID(mapUtil.get("Elective").intValue());
		ADDITIONAL.setID(mapUtil.get("Additional").intValue());
	}

	private CourseUseType() {

	}

	private void setID(int id) {
		this.id = id;

	}

	private CourseUseType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CourseUseType getCourseUseType(int ID) {
		for (CourseUseType useType : CourseUseType.values()) {
			if (useType.getID() == ID) {
				return useType;
			}
		}

		throw new NoSuchElementException("CourseUse Type ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "CourseUse Type [" + getName() + "] ID [" + getID() + "]";
	}
}
