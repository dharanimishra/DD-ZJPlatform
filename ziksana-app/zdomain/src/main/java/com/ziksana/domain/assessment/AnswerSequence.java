package com.ziksana.domain.assessment;


/**
 * @author bhashasp
 */
public enum AnswerSequence {

	// TODO: retrieve the ids from the static data service
	SEQUENCE1     (1,  "Sequence 1"), 
	SEQUENCE2     (2,  "Sequence 1");
	

	private final int id;
	
	private final String name;

	private AnswerSequence(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static AnswerSequence getAnswerSequence(int ID){
		for (AnswerSequence ansSequence : AnswerSequence.values()) {
			if (ansSequence.getID() == ID) {
				return ansSequence;
			}
		}

		throw new IndexOutOfBoundsException("AnswerSequence ID [" + ID + "] not found");
	}

	public String toString() {
		return "AnswerSequence Type [" + getName() + "] ID [" + getID() + "]";
	}
}
