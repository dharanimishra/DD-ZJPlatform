package com.ziksana.domain.assessment;

import java.util.NoSuchElementException;


public enum DifficultyLevel {

	// TODO: retrieve the ids from the static data service
	BEGINNER	(1, "Beginner"),
	INTERRMEDIATE	(1, "Beginner");

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

	public static DifficultyLevel getDifficultyLevel(int ID) {
		for (DifficultyLevel difficultyLevel : DifficultyLevel.values()) {
			if (difficultyLevel.getID() == ID) {
				return difficultyLevel;
			}
		}

		throw new NoSuchElementException("DifficultyLevel ID [" + ID + "] not found");
	}

	public String toString() {
		return "DifficultyLevel [" + getName() + "] ID [" + getID() + "]";
	}
}
