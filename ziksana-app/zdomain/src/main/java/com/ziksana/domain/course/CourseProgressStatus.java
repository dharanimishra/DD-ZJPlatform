package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum CourseProgressStatus {

	// TODO: retrieve the ids from the static data service
	DRAFT(1, "Draft"), WIP(2, "Work In Progress");
	

	private final int id;
	
	private final String name;

	private CourseProgressStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CourseProgressStatus getCourseProgressStatus(int ID) throws CourseException {
		for (CourseProgressStatus progressStatus : CourseProgressStatus.values()) {
			if (progressStatus.getID() == ID) {
				return progressStatus;
			}
		}

		throw new CourseException("CourseProgressStatus ID [" + ID + "] not found");
	}

	public String toString() {
		return "CourseProgressStatus [" + getName() + "] ID [" + getID() + "]";
	}
}
