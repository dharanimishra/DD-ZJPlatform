package com.ziksana.domain.course;


/**
 * @author Ratnesh Kumar
 */

public enum EmbeddedContentType {
	
	// TODO: retrieve the ids from the static data service
	SUMMARY 		(1, "Summary"),  
	RECAP 			(2, "Recap"), 
	QUIZ 			(3, "Quiz"),  
	ASSIGNMENT		(4, "Assignment"); 
	
	private final int id;
	
	private final String name;

	private EmbeddedContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static EmbeddedContentType getEmbeddedContentType(int ID) throws NoSuchMethodException  {
		for (EmbeddedContentType embedContentType : EmbeddedContentType.values()) {
			if (embedContentType.getID() == ID) {
				return embedContentType;
			}
		}

		throw new NoSuchMethodException("EmbeddedContentType ID [" + ID + "] not found");
	}

	public String toString() {
		return "EmbeddedContent Type [" + getName() + "] ID [" + getID() + "]";
	}

}
