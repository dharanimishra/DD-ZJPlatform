package com.ziksana.domain.course;

import com.ziksana.common.exception.CourseException;

public enum MessageVisibility {


	// TODO: retrieve the ids from the static data service
	CIRCLE1(1, "Circle 1"), CIRCLE2(2, "Circle 2"), CIRCLE3(3, "Circle 3"), INSTITUTE_MEMBERS(4,
			"Institution Members"), PUBLIC(5, "Public");
	

	private final int id;
	
	private final String name;

	private MessageVisibility(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static MessageVisibility getMessageVisibility(int ID) throws CourseException {
		for (MessageVisibility compsgVisibility : MessageVisibility.values()) {
			if (compsgVisibility.getID() == ID) {
				return compsgVisibility;
			}
		}

		throw new CourseException("Message Visibility ID [" + ID + "] not found");
	}

	public String toString() {
		return "Message Visibility [" + getName() + "] ID [" + getID() + "]";
	}


}
