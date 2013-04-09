package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author Ratnesh Kumar
 */

public enum Rating {

	// TODO: retrieve the ids from the static data service
	STAR_1(1, "1 Star"), STAR_2(2, "2 Star"), STAR_3(3, "3 Star"), STAR_4(4,
			"4 Star"), STAR_5(5, "5 Star");

	private final int id;
	private final String name;

	private final static String category = "Rating";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {

	}

	private Rating(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Rating getRating(int ID) {
		for (Rating t : Rating.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}
		throw new NoSuchElementException("Rating ID [" + ID + "] not found");
	}

	public String toString() {
		return "Rating [" + getName() + "] ID [" + getID() + "]";
	}
}
