package com.ziksana.domain.course;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum WorkflowType {

	// TODO: retrieve the ids from the static data service
	CREATION      		(1, "Creation"),
	REVIEW      		(2, "Review"),
	ADMINISTRATION   	(3, "Administration"),
	PUBLISHING 			(4, "Publishing");
	

	private final int id;
	
	private final String name;

	private WorkflowType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static WorkflowType getWorkflowType(int ID) {
		for (WorkflowType wfType : WorkflowType.values()) {
			if (wfType.getID() == ID) {
				return wfType;
			}
		}

		throw new NoSuchElementException("Workflow Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Workflow Type [" + getName() + "] ID [" + getID() + "]";
	}
}
