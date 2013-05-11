package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum Sync {

	// TODO: retrieve the ids from the static data service
	YES      	(1, "Yes"),
	NO      	(2, "No"),
	ANY_TIME   	(3, "Any time"),
	NA 			(4,"Not Applicable");
	

	private final int id;
	
	private final String name;

	private Sync(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Sync getSync(int ID) {
		for (Sync sync : Sync.values()) {
			if (sync.getID() == ID) {
				return sync;
			}
		}

		throw new NoSuchElementException("Sync ID [" + ID + "] not found");
	}

	public String toString() {
		return "Sync [" + getName() + "] ID [" + getID() + "]";
	}
}
