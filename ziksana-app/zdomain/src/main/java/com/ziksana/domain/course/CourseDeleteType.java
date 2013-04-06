/**
 * 
 */
package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum CourseDeleteType {

	CONTENT(), CONTENT_PARTS(), CONTENT_AND_PARTS();

	private int id;

	private String name;

	private final static String category = "Course Status";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		CONTENT.setID(mapUtil.get("Content Only").intValue());
		CONTENT_PARTS.setID(mapUtil.get("Content Parts only").intValue());
		CONTENT_AND_PARTS
				.setID(mapUtil.get("Content and its Parts").intValue());
	}

	private CourseDeleteType() {

	}

	private CourseDeleteType(int id, String name) {
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

	public static CourseDeleteType getCourseDeleteType(int ID)
			throws NoSuchMethodException {
		for (CourseDeleteType deleteType : CourseDeleteType.values()) {
			if (deleteType.getID() == ID) {
				return deleteType;
			}
		}

		throw new NoSuchMethodException("CourseDeleteType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "CourseDelete Type [" + getName() + "] ID [" + getID() + "]";
	}

}
