package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum CoursePlaybookStatus {

	// TODO: retrieve the ids from the static data service
	UNDER_CONSTRUCT (1, "Under Construction"),
	REVIEW          (2, "Under Review"),
	ACTIVE         	(3, "Active"),
	RELEASE        	(4, "Ready for release"),
	HOLD      		(5, "Hold"),
	ARCHIVED       	(6, "Archived");
	

	private final int id;
	
	private final String name;

	private CoursePlaybookStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CoursePlaybookStatus getCoursePlaybookStatus(int ID) {
		for (CoursePlaybookStatus pbStatus : CoursePlaybookStatus.values()) {
			if (pbStatus.getID() == ID) {
				return pbStatus;
			}
		}

		throw new NoSuchElementException("CoursePlaybook Status ID [" + ID + "] not found");
	}

	public String toString() {
		return "CoursePlaybook Status [" + getName() + "] ID [" + getID() + "]";
	}
}
