package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ratnesh Kumar
 */

public enum LearningObjectDeleteType {

	LEARNINGOBJECT(1, "Learning Object Only"), LEARNINGOBJECT_AND_CONTENTS(2,
			"Learning Object and its Contents");

	private final int id;

	private final String name;

	private final static String category = "ObjectDeleteType";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {

	}

	private LearningObjectDeleteType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static LearningObjectDeleteType getCourseDeleteType(int ID)
			throws NoSuchMethodException {
		for (LearningObjectDeleteType deleteType : LearningObjectDeleteType
				.values()) {
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
