package com.ziksana.domain.assessment.member;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum GradeVisibility {

	// TODO: retrieve the ids from the static data service
	LEARNER      						(1, "Learner"),
	LEARNER_AND_EDUCATOR      			(2, "Learner and Educator"),
	LEARNER_AND_ALL_EDUCATORS			(3, "Learner and All Educators"),
	CLASS 								(4, "Class"),
	PUBLIC								(5, "Public");
	

	private final int id;
	
	private final String name;

	private GradeVisibility(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static GradeVisibility getGradeVisibility(int ID) {
		for (GradeVisibility visibility : GradeVisibility.values()) {
			if (visibility.getID() == ID) {
				return visibility;
			}
		}

		throw new NoSuchElementException("Grade Visibility ID [" + ID + "] not found");
	}

	public String toString() {
		return "Grade Visibility [" + getName() + "] ID [" + getID() + "]";
	}
}
