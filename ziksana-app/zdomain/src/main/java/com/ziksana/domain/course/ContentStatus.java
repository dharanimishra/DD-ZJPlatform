package com.ziksana.domain.course;

import java.util.NoSuchElementException;


/**
 * @author Ratnesh Kumar
 */

public enum ContentStatus {

	// TODO: retrieve the ids from the static data service
	DRAFT           (1, "Under Construction"),
	REVIEW          (2, "Under Review"),
	ACTIVE         	(3, "Active"),
	RELEASE        	(4,"Ready for release"),
	HOLD      		(5, "Hold"),
	ARCHIVED       	(6, "Archived");
	

	private final int id;
	
	private final String name;

	private ContentStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentStatus getContentStatus(int ID) {
		for (ContentStatus contentStatus : ContentStatus.values()) {
			if (contentStatus.getID() == ID) {
				return contentStatus;
			}
		}

		throw new NoSuchElementException("Content Status ID [" + ID + "] not found");
	}

	public String toString() {
		return "Content Status [" + getName() + "] ID [" + getID() + "]";
	}
}
