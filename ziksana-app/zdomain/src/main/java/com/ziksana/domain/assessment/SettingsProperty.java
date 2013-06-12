package com.ziksana.domain.assessment;

public enum SettingsProperty {

	// TODO: retrieve the ids from the static data service
	MINIMUM_TIME				(1, "Minimum Time"),
	MAXIMUM_TIME				(2, "Maximum Time"),
	MINIMUM_GRADE_TO_PASS		(3, "Minimum grade to pass"),
	NUMBER_OF_ATTEMPTS_ALLOWED	(4, "Number of attempts allowed"),
	NUMBER_OF_SKIPS_ALLOWED		(5, "Number of Skips allowed");
		

	private final int id;
	
	private final String name;

	private SettingsProperty(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static SettingsProperty getVisuaSource(int ID) throws NoSuchMethodException{
		for (SettingsProperty settingsProperty : SettingsProperty.values()) {
			if (settingsProperty.getID() == ID) {
				return settingsProperty;
			}
		}

		throw new NoSuchMethodException("Settings Property ID [" + ID + "] not found");
	}

	public String toString() {
		return "Settings Property [" + getName() + "] ID [" + getID() + "]";
	}
}
