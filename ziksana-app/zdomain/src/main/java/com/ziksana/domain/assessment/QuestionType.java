package com.ziksana.domain.assessment;

import java.util.NoSuchElementException;

public enum QuestionType {

	// TODO: retrieve the ids from the static data service
	OBJECTIVE_SINGLE		(1, "Objective type - Single"),
	OBJECTIVE_MULTIPLE		(2, "Objective type - Multiple"),
	FILL_BLANKS				(3, "Fill in the blanks"),
	MATCH_ITEMS_SINGLE		(4, "Match items - Single"),
	MATCH_ITEMS_MULTIPLE	(5, "Match items - Multiple"),
	NAME_THE_ITEMS			(6, "Name the Items"),
	VISUAL					(7, "Visual"),
	AUDIO					(8, "Audio"),
	WHAT_IS					(9, "What is"),
	ESSAY					(10, "Essay type");
	

	private final int id;
	
	private final String name;

	private QuestionType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static QuestionType getQuestionType(int ID){
		for (QuestionType qtnType : QuestionType.values()) {
			if (qtnType.getID() == ID) {
				return qtnType;
			}
		}

		throw new NoSuchElementException("QuestionType ID [" + ID + "] not found");
	}

	public String toString() {
		return "QuestionType [" + getName() + "] ID [" + getID() + "]";
	}
}
