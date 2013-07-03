package com.ziksana.domain.course.subscription;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum NotesVisibility {

	// TODO: retrieve the ids from the static data service
	PRIVATE        			(1, "Private"),
	MY_CIRCLE 				(2, "My Circle"),
	MY_CLASS 				(3, "My Class"),
	ALL_TAKING_THIS_CLASS 	(4, "All Taking this Class"),
	PUBLIC 					(5, "Public");

	private final int id;
	
	private final String name;

	private NotesVisibility(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public NotesVisibility getEnrichNotesVisibility(int ID) {
		for (NotesVisibility visibility : NotesVisibility.values()) {
			if (visibility.getID() == ID) {
				return visibility;
			}
		}

		throw new NoSuchElementException("NotesVisibility ID [" + ID + "] not found");
	}

	public String toString() {
		return "NotesVisibility [" + getName() + "] ID [" + getID() + "]";
	}
}
