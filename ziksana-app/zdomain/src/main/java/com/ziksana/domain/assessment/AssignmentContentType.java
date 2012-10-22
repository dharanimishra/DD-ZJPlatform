/**
 * 
 */
package com.ziksana.domain.assessment;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum AssignmentContentType {

	// TODO: retrieve the ids from the static data service
	TEST      	(1, "Test"),
	ASSIGNMENT  (2, "Assignment"),
	NOTES   	(3, "Notes");
	

	private final int id;
	
	private final String name;

	private AssignmentContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static AssignmentContentType getAssignmentContentType(int ID) {
		for (AssignmentContentType assignmentType : AssignmentContentType.values()) {
			if (assignmentType.getID() == ID) {
				return assignmentType;
			}
		}

		throw new NoSuchElementException("Assignment Content Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Assignment  Content Type [" + getName() + "] ID [" + getID() + "]";
	}
}
