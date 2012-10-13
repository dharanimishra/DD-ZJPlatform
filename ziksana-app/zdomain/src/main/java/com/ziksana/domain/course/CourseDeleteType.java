/**
 * 
 */
package com.ziksana.domain.course;

/**
 * @author bhashasp
 */
public enum CourseDeleteType {
	
	CONTENT					(1, "Content Only"),  
	CONTENT_PARTS 			(2, "Content Parts only"),
	CONTENT_AND_PARTS		(3, "Content and its Parts");
	  
	
	private final int id;
	
	private final String name;

	private CourseDeleteType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CourseDeleteType getCourseDeleteType(int ID) throws NoSuchMethodException  {
		for (CourseDeleteType deleteType : CourseDeleteType.values()) {
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
