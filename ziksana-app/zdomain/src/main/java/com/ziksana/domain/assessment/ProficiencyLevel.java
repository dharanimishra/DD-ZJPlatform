package com.ziksana.domain.assessment;

public enum ProficiencyLevel {

	// TODO: retrieve the ids from the static data service
	Expert		(1, "Expert"),
	Research	(2, "Research");

	
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

		throw new IndexOutOfBoundsException("ProficiencyLevel ID [" + ID + "] not found");
	}

	public String toString() {
		return "ProficiencyLevel [" + getName() + "] ID [" + getID() + "]";
	}
}
