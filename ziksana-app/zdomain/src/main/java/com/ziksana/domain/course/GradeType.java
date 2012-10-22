package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum GradeType {

	// TODO: retrieve the ids from the static data service
	PERCENTAGE      	(1, "Perncentage"),
	PERCENTILE      	(2, "Percentile"),
	RELATIVE_POSITION   (3, "Relative Position"),
	GPA 				(4,"GPA"),
	A_PLUS				(5,"A +");
	

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

	public static GradeType getGradeType(int ID) {
		for (GradeType gradeType : GradeType.values()) {
			if (gradeType.getID() == ID) {
				return gradeType;
			}
		}

		throw new NoSuchElementException("Grade Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Grade Type [" + getName() + "] ID [" + getID() + "]";
	}
}
