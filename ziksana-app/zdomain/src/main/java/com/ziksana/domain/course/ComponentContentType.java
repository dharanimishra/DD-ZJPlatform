package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum ComponentContentType {

	// TODO: retrieve the ids from the static data service
	PREVIEW_CONTENT      	(1, "Preview Content"),
	PROMOTIONAL_CONTENT     (2, "Promotional Content"),
	PRACTICE_CONTENT   		(3, "Practice Content"),
	COURSE_CONTENT			(4, "Course Content");
	

	private final int id;
	
	private final String name;

	private ComponentContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ComponentContentType getComponentContentType(int ID) {
		for (ComponentContentType compContentType : ComponentContentType.values()) {
			if (compContentType.getID() == ID) {
				return compContentType;
			}
		}

		throw new NoSuchElementException("Component Content Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Component  Content Type [" + getName() + "] ID [" + getID() + "]";
	}
}
