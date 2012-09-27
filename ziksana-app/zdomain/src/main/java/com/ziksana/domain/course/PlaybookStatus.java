package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum PlaybookStatus {

	// TODO: retrieve the ids from the static data service
	ADMINISTER(1, "Administered"), RELEASED(2, "Released");
	

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

	public static PlaybookStatus getPlaybookStatus(int ID) throws CourseException {
		for (PlaybookStatus playbookStatus : PlaybookStatus.values()) {
			if (playbookStatus.getID() == ID) {
				return playbookStatus;
			}
		}

		throw new CourseException("PlaybookStatus ID [" + ID + "] not found");
	}

	public String toString() {
		return "Playbook status [" + getName() + "] ID [" + getID() + "]";
	}
}
