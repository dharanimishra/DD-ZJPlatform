/**
 * 
 */
package com.ziksana.domain.course;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum WorkflowItemStatus {

	// TODO: retrieve the ids from the static data service
	OPEN_FOR_REVIEW      		(1, "Open for Review"),
	REVIEW_IN_PROGRESS      	(2, "Review in Progress"),
	REVIEW_COMPLETE   			(3, "Review Complete"),
	REFINEMENT_IN_PROGRESS 		(4, "Refinement in Progress"),
	REFINEMENT_COMPLETE 		(5, "Refinement Complete");
	

	private final int id;
	
	private final String name;

	private WorkflowItemStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static WorkflowItemStatus getWorkflowItemStatus(int ID) {
		for (WorkflowItemStatus status : WorkflowItemStatus.values()) {
			if (status.getID() == ID) {
				return status;
			}
		}

		throw new NoSuchElementException("WorkflowItemStatus ID [" + ID + "] not found");
	}

	public String toString() {
		return "WorkflowItemStatus [" + getName() + "] ID [" + getID() + "]";
	}
}
