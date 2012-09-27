package com.ziksana.domain.assessment;

import com.ziksana.common.exception.CourseException;

public enum AssignmentStatus {

	// TODO: retrieve the ids from the static data service
	STATUS1(1, "status 1"), STATUS2(2, "status2");
	

	private final int id;
	
	private final String name;

	private AssignmentStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static AssignmentStatus getAssignmentStatus(int ID) throws CourseException {
		for (AssignmentStatus assignmentStatus : AssignmentStatus.values()) {
			if (assignmentStatus.getID() == ID) {
				return assignmentStatus;
			}
		}

		throw new CourseException("AssignmentStatus ID [" + ID + "] not found");
	}

	public String toString() {
		return "AssignmentStatus [" + getName() + "] ID [" + getID() + "]";
	}
}
