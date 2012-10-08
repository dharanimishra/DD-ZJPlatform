package com.ziksana.domain.assessment;

public enum QuestionApplicableType {

	// TODO: retrieve the ids from the static data service
	Type1		(1, "Type 1"),
	Type2		(2, "Type 2");

	
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

		throw new IndexOutOfBoundsException("QuestionApplicableType ID [" + ID + "] not found");
	}

	public String toString() {
		return "QuestionApplicableType [" + getName() + "] ID [" + getID() + "]";
	}
}
