package com.ziksana.domain.assessment;

public enum VisualSource {

	// TODO: retrieve the ids from the static data service
	UNIVERSITY				(1, "University"),
	PARTNER					(2, "Partner"),
	AFFILIATED_SOURCE		(3, "Affiliated Source"),
	PUBLIC_SOURCE			(4, "Public Source");
		

	private final int id;
	
	private final String name;

	private VisualSource(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static VisualSource getVisuaSource(int ID) throws NoSuchMethodException{
		for (VisualSource visualSource : VisualSource.values()) {
			if (visualSource.getID() == ID) {
				return visualSource;
			}
		}

		throw new NoSuchMethodException("Visual Source ID [" + ID + "] not found");
	}

	public String toString() {
		return "Visual Source [" + getName() + "] ID [" + getID() + "]";
	}
}
