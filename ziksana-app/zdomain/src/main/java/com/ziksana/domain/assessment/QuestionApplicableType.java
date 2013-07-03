package com.ziksana.domain.assessment;

import java.util.NoSuchElementException;

public enum QuestionApplicableType {

	// TODO: retrieve the ids from the static data service
	BEGINNER		(1, "Beginner"),
	INTERMEDIATE	(2, "Intermediate"),
	ADVANCED		(3, "Advanced"),
	EXPERT			(4, "Expert"),
	RESEARCH		(5, "Research"),;

	
	private final int id;
	
	private final String name;

	private QuestionApplicableType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static QuestionApplicableType getQuestionApplicableType(int ID) {
		for (QuestionApplicableType qtnAppcType : QuestionApplicableType.values()) {
			if (qtnAppcType.getID() == ID) {
				return qtnAppcType;
			}
		}

		throw new NoSuchElementException("QuestionApplicableType ID [" + ID + "] not found");
	}

	public String toString() {
		return "QuestionApplicableType [" + getName() + "] ID [" + getID() + "]";
	}
}
