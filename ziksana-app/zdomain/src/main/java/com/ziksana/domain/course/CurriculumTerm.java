package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum CurriculumTerm {

	// TODO: retrieve the ids from the static data service
	SUMMER      (1, "Summer"),
	FALL      	(2, "Fall"),
	WINTER   	(3, "Winter"),
	SPRING		(4, "Spring");
	

	private final int id;
	
	private final String name;

	private CurriculumTerm(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CurriculumTerm getCurriculumTerm(int ID) {
		for (CurriculumTerm term : CurriculumTerm.values()) {
			if (term.getID() == ID) {
				return term;
			}
		}

		throw new NoSuchElementException("CurriculumTerm ID [" + ID + "] not found");
	}

	public String toString() {
		return "CurriculumTerm [" + getName() + "] ID [" + getID() + "]";
	}
}
