package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum CourseStatus {

	// TODO: retrieve the ids from the static data service
	UNDER_CONSTRUCT(), REVIEW(), RELEASE(), ACTIVE(), HOLD(), ARCHIVED();

	private int id;
	private String name;

	private final static String category = "Course Status";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
//		EnumUtil enumUtil = new EnumUtil();
//		mapUtil = enumUtil.getEnumData(category);
//		UNDER_CONSTRUCT.setID(mapUtil.get("Under Construction").intValue());
//		REVIEW.setID(mapUtil.get("Under Review").intValue());
//		RELEASE.setID(mapUtil.get("Ready for Release").intValue());
//		ACTIVE.setID(mapUtil.get("Active").intValue());
//		HOLD.setID(mapUtil.get("Hold").intValue());
//		ARCHIVED.setID(mapUtil.get("Archived").intValue());

	}

	private CourseStatus() {

	}

	private CourseStatus(int id, String name) {
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

	public static CourseStatus getCourseStatus(int ID) {
		for (CourseStatus t : CourseStatus.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new NoSuchElementException("CourseStatus ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Course Status [" + getName() + "] ID [" + getID() + "]";
	}
}