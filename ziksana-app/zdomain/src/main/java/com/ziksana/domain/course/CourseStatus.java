/**
 * 
 */
package com.ziksana.domain.course;

import java.util.NoSuchElementException;


/**
 * @author bhashasp
 */
public enum CourseStatus {

	// TODO: retrieve the ids from the static data service
	DRAFT           (1, "Under Construction"),
	REVIEW          (2, "Under Review"),
	ACTIVE         	(3, "Active"),
	RELEASE        	(4,"Ready for release"),
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