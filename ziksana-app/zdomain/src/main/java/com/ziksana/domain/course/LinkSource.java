package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum LinkSource {

	//TODO: retrieve the ids from the static data service
	LINK_SOURCE1(1, "Link Source1"), LINK_SOURCE2(1, "Link Source2");

	private final int id;
	private final String name;

	private LinkSource(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static LinkSource getLinkSource(int ID) throws CourseException {
		for (LinkSource t : LinkSource.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new CourseException("LinkSource ID [" + ID + "] not found");
	}

	public String toString() {
		return "LinkSource [" + getName() + "] ID [" + getID() + "]";
	}
}
