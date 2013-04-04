package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;




/**
 * @author Ratnesh Kumar
 */

public enum CourseUseType {

	// TODO: retrieve the ids from the static data service
	MAJOR      (1, "Major"),
	MINOR      (2, "Minor"),
	ELECTIVE   (3, "Elective"),
	ADDITIONAL (4, "Additional");
	

	private final int id;
	
	private final String name;
	
	private final static String category ="Course Status";
	
	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();
	
	static {
//		EnumUtil enumUtil = new EnumUtil();
//		mapUtil = enumUtil.getEnumData(category);
//		System.out.println("Getting static values :category :mapUtil :"
//				+ mapUtil.size());
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

		throw new NoSuchElementException("CourseUse Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "CourseUse Type [" + getName() + "] ID [" + getID() + "]";
	}
}
