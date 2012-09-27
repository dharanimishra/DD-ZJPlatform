package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum CurriculumUseType {

	// TODO: retrieve the ids from the static data service
	MAJOR(1, "Major"), MINOR(2, "Minor"), ELECTIVE(2, "Elective"), EXTRA_CREDIT(4,"Extra Credit");
	

	private final int id;
	
	private final String name;

	private CurriculumUseType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CurriculumUseType getCurriculumUseType(int ID) throws CourseException {
		for (CurriculumUseType currUseType : CurriculumUseType.values()) {
			if (currUseType.getID() == ID) {
				return currUseType;
			}
		}

		throw new CourseException("CurriculumUseType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Curriculum Use Type [" + getName() + "] ID [" + getID() + "]";
	}
}
