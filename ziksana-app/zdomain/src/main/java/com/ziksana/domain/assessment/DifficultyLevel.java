package com.ziksana.domain.assessment;


public enum DifficultyLevel {

	// TODO: retrieve the ids from the static data service
	Beginner	(1, "Beginner"),
	Advanced	(2, "Advanced"),
	Expert		(3, "Expert");

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

		throw new IndexOutOfBoundsException("DifficultyLevel ID [" + ID + "] not found");
	}

	public String toString() {
		return "DifficultyLevel [" + getName() + "] ID [" + getID() + "]";
	}
}
