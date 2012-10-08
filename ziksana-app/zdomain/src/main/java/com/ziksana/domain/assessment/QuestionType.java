package com.ziksana.domain.assessment;

public enum QuestionType {

	// TODO: retrieve the ids from the static data service
	TRUE_OR_FALSE					(1, "True or False"),
	MULTICHOICE_SINGLE_ANSWER		(2, "Multi Choice Single Answer"),
	MULTICHOICE_MULTIPLE_ANSWER		(3, "Multi Choice Multi Answer"),
	ORDERING_CHOICE					(4, "Ordering Choices"),
	MATCH_THE_FOLLOWING				(5, "Match the Following"),
	FILL_BLANKS						(6, "Fill in the blanks"),
	JUMBLED_SEQUENCE				(7, "Jumbled sequence"),
	DESCRIPTIVE						(8, "Descriptive"),
	IMAGE_HOTSPOT					(9, "Image Hotspot"),
	VIDEO_HOTSPOT					(10, "Video Hotspot"),
	MATHEMATICAL					(11, "Mathematical Questions"),
	FRAME_THE_QUESTION				(12, "Frame the Question");
	

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

		throw new IndexOutOfBoundsException("QuestionType ID [" + ID + "] not found");
	}

	public String toString() {
		return "QuestionType [" + getName() + "] ID [" + getID() + "]";
	}
}
