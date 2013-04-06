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

public enum ContentDeleteType {

	LEARNNGOBJECT(), LEARNNGOBJECT_CONTENTS(), LEARNNGOBJECT_AND_CONTENTS();

	private int id;

	private String name;

	private final static String category = "Component Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		LEARNNGOBJECT.setID(mapUtil.get("Learning Object Only").intValue());
		LEARNNGOBJECT_CONTENTS.setID(mapUtil.get(
				"Learning Object Contents only").intValue());
		LEARNNGOBJECT_AND_CONTENTS.setID(mapUtil.get(
				"Learning Object and its Contents").intValue());

	}

	private ContentDeleteType() {

	}

	private ContentDeleteType(int id, String name) {
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

	public static ContentDeleteType getCourseDeleteType(int ID)
			throws NoSuchMethodException {
		for (ContentDeleteType deleteType : ContentDeleteType.values()) {
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
