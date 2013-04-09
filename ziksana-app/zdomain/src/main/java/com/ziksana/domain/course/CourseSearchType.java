package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * This enum is for searching the course components (either Learning
 * Object/Component Content).
 * 
 * @author Ratnesh Kumar
 */
public enum CourseSearchType {

	// TODO: retrieve the ids from the static data service
	LEARNINGCOMPONENT(), COMPONENTCONTENT(), OTHER();

	private int id;

	private String name;

	private final static String category = "Course Search Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		
		LEARNINGCOMPONENT.setID(mapUtil.get("Learning Component").intValue());
		COMPONENTCONTENT.setID(mapUtil.get("Component Content").intValue());
		OTHER.setID(mapUtil.get("Other").intValue());
	}

	private CourseSearchType() {

	}

	private CourseSearchType(int id, String name) {
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

	public static CourseSearchType getCourseSearchType(int ID) {
		for (CourseSearchType courseSearchType : CourseSearchType.values()) {
			if (courseSearchType.getID() == ID) {
				return courseSearchType;
			}
		}

		throw new NoSuchElementException("CourseSearch Type ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "CourseSearch Type [" + getName() + "] ID [" + getID() + "]";
	}

}
