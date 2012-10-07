package com.ziksana.domain.course;


/**
 * @author bhashasp
 */
public enum Rating {

	// TODO: retrieve the ids from the static data service
	NOT_HAPPY(1, "Not Happy"),
	NO_COMMENTS(2, "No Comments"),
	AVERAGE(3,"Average"),
	HAPPY(4, "Happy"),
	EXCELLENT(5, "Excellent");

	private final int 		id;
	private final String 	name;

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
		throw new IndexOutOfBoundsException("Rating ID [" + ID + "] not found");
	}

	public String toString() {
		return "Rating [" + getName() + "] ID [" + getID() + "]";
	}
}
