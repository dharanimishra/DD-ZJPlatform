package com.ziksana.domain.course;

import com.ziksana.exception.course.CourseException;

/**This enum is for searching the course components (either Learning Object/Component Content).
 * @author bhashasp
 */
public enum CourseSearchType {


	// TODO: retrieve the ids from the static data service
	LEARNINGCOMPONENT(1, "Learning Component"), COMPONENTCONTENT(2, "Component Content"), OTHER(3, "Other");
	

	private final int id;
	
	private final String name;

	private CourseSearchType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CourseSearchType getCourseSearchType(int ID) throws CourseException {
		for (CourseSearchType courseSearchType : CourseSearchType.values()) {
			if (courseSearchType.getID() == ID) {
				return courseSearchType;
			}
		}

		throw new CourseException("CourseSearch Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "CourseSearch Type [" + getName() + "] ID [" + getID() + "]";
	}


}
