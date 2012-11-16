package com.ziksana.domain.member;

import java.util.NoSuchElementException;

/** 
 * @author bhashasp
 */
public enum GroupPersonality {

	// TODO: retrieve the ids from the static data service
	INTROVERT      	(1, "Introvert"),
	EXTRAVERT      	(2, "Extravert"),
	RESERVED   		(3, "Reserved"),
	VOCAL 			(4, "Vocal"),
	GENERAL			(5, "General");
	

	private final int id;
	
	private final String name;

	private GroupPersonality(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static GroupPersonality getGroupPersonality(int ID) {
		for (GroupPersonality groupPersonality : GroupPersonality.values()) {
			if (groupPersonality.getID() == ID) {
				return groupPersonality;
			}
		}

		throw new NoSuchElementException("GroupPersonality ID [" + ID + "] not found");
	}

	public String toString() {
		return "GroupPersonality [" + getName() + "] ID [" + getID() + "]";
	}
}
