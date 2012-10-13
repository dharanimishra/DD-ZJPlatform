package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum Visibility {

	// TODO: retrieve the ids from the static data service
	ALL        (1, "All"),
	RESTRICTED (2, "Restricted");
	

	private final int id;
	
	private final String name;

	private Visibility(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Visibility getEnrichVisibility(int ID) {
		for (Visibility visibility : Visibility.values()) {
			if (visibility.getID() == ID) {
				return visibility;
			}
		}

		throw new NoSuchElementException("Visibility ID [" + ID + "] not found");
	}

	public String toString() {
		return "Visibility [" + getName() + "] ID [" + getID() + "]";
	}
}
