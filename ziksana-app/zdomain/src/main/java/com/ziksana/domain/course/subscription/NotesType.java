package com.ziksana.domain.course.subscription;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum NotesType {

	// TODO: retrieve the ids from the static data service
	CLASS_NOTES        	(1,  "Class Notes"), 
	TEST_NOTES       	(2,  "Test Notes"), 
	QUICK_READ  		(3,  "Quick Read"), 
	SUMMARY       		(4,  "Summary");
	

	private final int id;
	
	private final String name;

	private NotesType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static NotesType getNotesType(int ID){
		for (NotesType notesType : NotesType.values()) {
			if (notesType.getID() == ID) {
				return notesType;
			}
		}

		throw new NoSuchElementException("NotesType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Notes Type [" + getName() + "] ID [" + getID() + "]";
	}
}
