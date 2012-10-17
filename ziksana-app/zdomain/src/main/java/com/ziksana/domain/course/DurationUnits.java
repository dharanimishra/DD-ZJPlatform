package com.ziksana.domain.course;

import java.util.NoSuchElementException;
 
/**
 * @author bhashasp
 */
public enum DurationUnits {

	// TODO: retrieve the ids from the static data service
	DAYS           (1, "Days"),
	WEEKS          (2, "Weeks"),
	MONTHS         (3, "Months");
	
	private final int id;
	private final String name;

	private DurationUnits(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static DurationUnits getDurationUnits(int ID) {
		for (DurationUnits units : DurationUnits.values()) {
			if (units.getID() == ID) {
				return units;
			}
		}

		throw new NoSuchElementException("DurationUnits ID [" + ID + "] not found");
	}

	public String toString() {
		return "Course Status [" + getName() + "] ID [" + getID() + "]";
	}
}
