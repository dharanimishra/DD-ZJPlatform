package com.ziksana.domain.course;


/**
 * @author Ratnesh Kumar
 */

public enum LearningObjectDeleteType {
	
	LEARNINGOBJECT					(1, "Learning Object Only"),  
	LEARNINGOBJECT_AND_CONTENTS		(2, "Learning Object and its Contents");
	  
	
	private final int id;
	
	private final String name;

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

	public static LearningObjectDeleteType getCourseDeleteType(int ID) throws NoSuchMethodException  {
		for (LearningObjectDeleteType deleteType : LearningObjectDeleteType.values()) {
			if (deleteType.getID() == ID) {
				return deleteType;
			}
		}

		throw new NoSuchMethodException("CourseDeleteType ID [" + ID + "] not found");
	}

	public String toString() {
		return "CourseDelete Type [" + getName() + "] ID [" + getID() + "]";
	}

}
