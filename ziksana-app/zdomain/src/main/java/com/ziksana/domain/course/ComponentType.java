package com.ziksana.domain.course;

import com.ziksana.exception.course.CourseException;


public enum ComponentType {

	// TODO: retrieve the ids from the static data service
	MODULE(1, "Module"), SUBJECT(2, "Subject"), SUBJECT_AREA(3, "Subject Area"), SECTION(4,
			"Section"), SUB_SECTION(5, "Sub Section"), TOPIC(6, "Topic"), CHAPTER(
			7, "Chapter"),POLICY(5, "Policy"), PREREQUISTE(6, "Pre Requiste"),COREQUISTE(5, "Co Requiste");
	

	private final int id;
	
	private final String name;

	private ComponentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ComponentType getComponentType(int ID) throws CourseException {
		for (ComponentType compType : ComponentType.values()) {
			if (compType.getID() == ID) {
				return compType;
			}
		}

		throw new CourseException("ComponentType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Component Type [" + getName() + "] ID [" + getID() + "]";
	}
}
