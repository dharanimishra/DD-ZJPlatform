package com.ziksana.domain.course;

import java.util.NoSuchElementException;


public enum ContentType {

	// TODO: retrieve the ids from the static data service
	VIDEO      (1, "VIDEO"),
	ENHANCED_VIDEO (11, "ENHANCED_VIDEO"),
	AUDIO      (2, "AUDIO"),
	TEXTUAL   (3, "TEXTUAL"),
	PDF (4, "PDF"),
	DOC (5, "DOC"),
	PPT (6, "PPT"),
	EXCEL (7, "EXCEL"),
	IMAGE (8, "IMAGE"),
	LINK (9, "LINK");
	

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

	public static ContentType getContentType(int ID) {
		for (ContentType comntentType : ContentType.values()) {
			if (comntentType.getID() == ID) {
				return comntentType;
			}
		}

		throw new NoSuchElementException("Content Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Content Type [" + getName() + "] ID [" + getID() + "]";
	}
}
