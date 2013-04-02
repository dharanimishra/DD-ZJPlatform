package com.ziksana.domain.course;

import java.util.NoSuchElementException;


/**
 * @author Ratnesh Kumar
 */

public enum Sequence {

	// TODO: retrieve the ids from the static data service
	SEQUENCE  	(1, "SEQUENCE1");
	

	private final int id;
	
	private final String name;

	private Sequence(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Sequence getSequence(int ID) {
		for (Sequence seq : Sequence.values()) {
			if (seq.getID() == ID) {
				return seq;
			}
		}

		throw new NoSuchElementException("Sequence ID [" + ID + "] not found");
	}

	public String toString() {
		return "Sequence [" + getName() + "] ID [" + getID() + "]";
	}
}
