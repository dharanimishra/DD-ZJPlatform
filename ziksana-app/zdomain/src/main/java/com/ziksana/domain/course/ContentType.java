package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum ContentType {

	// TODO: retrieve the ids from the static data service
	VIDEO(1, "Video"), AUDIO(2, "Audio"), DOCUMENT(3, "Document"), MULTIMEDIA(4,
			"Multimedia"), THESIS(5, "Thesis");
	

	private final int id;
	
	private final String name;

	private ContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentType getContentType(int ID) throws CourseException {
		for (ContentType comntentType : ContentType.values()) {
			if (comntentType.getID() == ID) {
				return comntentType;
			}
		}

		throw new CourseException("Content Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Content Type [" + getName() + "] ID [" + getID() + "]";
	}
}
