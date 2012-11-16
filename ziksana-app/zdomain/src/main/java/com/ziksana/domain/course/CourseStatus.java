package com.ziksana.domain.course;

import java.util.NoSuchElementException;


/**
 * @author bhashasp
 */
public enum CourseStatus {

	// TODO: retrieve the ids from the static data service
	UNDER_CONSTRUCT (1, "Under Construction"),
	REVIEW          (2, "Under Review"),
	RELEASE        	(3, "Ready for release"),
	ACTIVE         	(4, "Active"),
	HOLD      		(5, "Hold"),
	ARCHIVED       	(6, "Archived");
	
	private final int id;
	private final String name;

	private CourseStatus(int id, String name) {
		this.id = id;
		this.name = name;
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

		throw new NoSuchElementException("CourseStatus ID [" + ID + "] not found");
	}

	public String toString() {
		return "Course Status [" + getName() + "] ID [" + getID() + "]";
	}
}