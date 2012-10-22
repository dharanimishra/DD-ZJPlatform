package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum PlaybookStatus {

	// TODO: retrieve the ids from the static data service
	IN_PROGRESS     (1, "In Progress"),
	ACTIVE      	(2, "Active"),
	INACTIVE   		(3, "In Active"),
	ARCHIVED		(4, "Archived");
	

	private final int id;
	
	private final String name;

	private PlaybookStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PlaybookStatus getPlaybookStatus(int ID) {
		for (PlaybookStatus pbStatus : PlaybookStatus.values()) {
			if (pbStatus.getID() == ID) {
				return pbStatus;
			}
		}

		throw new NoSuchElementException("Playbook Status ID [" + ID + "] not found");
	}

	public String toString() {
		return "Playbook Status [" + getName() + "] ID [" + getID() + "]";
	}
}
