package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum TagType {


	// TODO: retrieve the ids from the static data service
	TAGTYPE1(1, "Tag Type1"), TAGTYPE2(2, "Tag Type2");
	

	private final int id;
	
	private final String name;

	private TagType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static TagType getTagType(int ID) throws CourseException {
		for (TagType tagType : TagType.values()) {
			if (tagType.getID() == ID) {
				return tagType;
			}
		}

		throw new CourseException("TagType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Tag Type [" + getName() + "] ID [" + getID() + "]";
	}

}
