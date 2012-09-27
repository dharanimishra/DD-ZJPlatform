package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum PlaybookType {

	// TODO: retrieve the ids from the static data service
	TYPE1(1, "Type 1"), TYPE2(2, "Type 2");
	

	private final int id;
	
	private final String name;

	private PlaybookType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PlaybookType getPlaybookType(int ID) throws CourseException {
		for (PlaybookType playbookType : PlaybookType.values()) {
			if (playbookType.getID() == ID) {
				return playbookType;
			}
		}

		throw new CourseException("PlaybookType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Playbook Type [" + getName() + "] ID [" + getID() + "]";
	}
}
