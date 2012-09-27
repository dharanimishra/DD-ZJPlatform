package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum ContentFormat {

	// TODO: retrieve the ids from the static data service
	FORMAT1(1, "Format1"), FORMAT2SUBJECT(2, "Format2");
	

	private final int id;
	
	private final String name;

	private ContentFormat(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentFormat getContentFormat(int ID) throws CourseException {
		for (ContentFormat cotentFormat : ContentFormat.values()) {
			if (cotentFormat.getID() == ID) {
				return cotentFormat;
			}
		}

		throw new CourseException("Content Format ID [" + ID + "] not found");
	}

	public String toString() {
		return "Content Format [" + getName() + "] ID [" + getID() + "]";
	}
}
