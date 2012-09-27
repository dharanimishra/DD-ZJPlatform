package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum GradeType {


	// TODO: retrieve the ids from the static data service
	GRADETYPE1(1, "Module"), GRADETYPE2(2, "Subject");
	

	private final int id;
	
	private final String name;

	private GradeType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static GradeType getGradeType(int ID) throws CourseException {
		for (GradeType gradeType : GradeType.values()) {
			if (gradeType.getID() == ID) {
				return gradeType;
			}
		}

		throw new CourseException("GradeType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Grade Type [" + getName() + "] ID [" + getID() + "]";
	}

}
