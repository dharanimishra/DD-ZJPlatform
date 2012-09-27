package com.ziksana.domain.assessment;

import com.ziksana.common.exception.CourseException;

public enum DifficultyLevel {

	// TODO: retrieve the ids from the static data service
	Beginner(1, "Beginner"), Advanced(2, "Advanced");
	

	private final int id;
	
	private final String name;

	private DifficultyLevel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static DifficultyLevel getDifficultyLevel(int ID) throws CourseException {
		for (DifficultyLevel difficultyLevel : DifficultyLevel.values()) {
			if (difficultyLevel.getID() == ID) {
				return difficultyLevel;
			}
		}

		throw new CourseException("DifficultyLevel ID [" + ID + "] not found");
	}

	public String toString() {
		return "DifficultyLevel [" + getName() + "] ID [" + getID() + "]";
	}
}
