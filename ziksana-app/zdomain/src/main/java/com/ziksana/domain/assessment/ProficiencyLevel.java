package com.ziksana.domain.assessment;

import java.util.NoSuchElementException;

public enum ProficiencyLevel {

	// TODO: retrieve the ids from the static data service
	BEGINNER			(1, "Beginner"),
	INTERMEDIATE		(2, "Intermediate"),
	SENIOR				(3, "Senior"),
	ADVANCED			(4, "Advanced"),
	RECOGNIZED_EXPERT	(5, "Recpgnized Expert"),
	RESEARCH			(6, "Research");
	
	private final int id;
	
	private final String name;

	private ProficiencyLevel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ProficiencyLevel getProficiencyLevel(int ID) {
		for (ProficiencyLevel profLevel : ProficiencyLevel.values()) {
			if (profLevel.getID() == ID) {
				return profLevel;
			}
		}

		throw new NoSuchElementException("ProficiencyLevel ID [" + ID + "] not found");
	}

	public String toString() {
		return "ProficiencyLevel [" + getName() + "] ID [" + getID() + "]";
	}
}
