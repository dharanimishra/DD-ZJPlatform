package com.ziksana.domain.course;

import java.util.NoSuchElementException;


/**
 * @author Ratnesh Kumar
 */

public enum Criticality {

	// TODO: retrieve the ids from the static data service
	LOW      		(1, "Low Criticality"),
	MEDIUM      	(2, "Medium Criticality"),
	HIGH   			(3, "High Criticality"),
	FLAME 			(4, "Flame Criticality");

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
				return criticality;			}
		}

		throw new NoSuchElementException("Criticality Id [" + ID + "] not found");
	}

	public String toString() {
		return "Criticality [" + getName() + "] ID [" + getID() + "]";
	}
}
