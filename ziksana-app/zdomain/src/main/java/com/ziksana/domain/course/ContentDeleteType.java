/**
 * 
 */
package com.ziksana.domain.course;

/**
 * @author bhashasp
 */
public enum ContentDeleteType {
	
	LEARNNGOBJECT					(1, "Learning Object Only"),  
	LEARNNGOBJECT_CONTENTS 			(2, "Learning Object Contents only"),
	LEARNNGOBJECT_AND_CONTENTS		(3, "Learning Object and its Contents");
	  
	
	private final int id;
	
	private final String name;

	private ContentDeleteType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentDeleteType getCourseDeleteType(int ID) throws NoSuchMethodException  {
		for (ContentDeleteType deleteType : ContentDeleteType.values()) {
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
