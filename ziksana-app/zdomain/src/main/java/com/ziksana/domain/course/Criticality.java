package com.ziksana.domain.course;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum Criticality {

	// TODO: retrieve the ids from the static data service
	LOW      		(1, "Low"),
	MEDIUM      	(2, "Medium"),
	HIGH   			(3, "High"),
	FLAME 			(4, "Flame");

	private final int id;
	
	private final String name;

	private Criticality(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Criticality getCriticality(int ID) {
		for (Criticality criticality : Criticality.values()) {
			if (criticality.getID() == ID) {
				return criticality;
			}
		}

		throw new NoSuchElementException("Criticality ID [" + ID + "] not found");
	}

	public String toString() {
		return "Criticality [" + getName() + "] ID [" + getID() + "]";
	}
}
