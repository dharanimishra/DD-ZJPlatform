package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum ComponentContentType {

	// TODO: retrieve the ids from the static data service
	PREVIEW_CONTENT(), PROMOTIONAL_CONTENT(), PRACTICE_CONTENT(), COURSE_CONTENT();

	private int id;

	private String name;

	private final static String category = "Course Status";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		PREVIEW_CONTENT.setID(mapUtil.get("Preview Content").intValue());
		PROMOTIONAL_CONTENT
				.setID(mapUtil.get("Promotional Content").intValue());
		PRACTICE_CONTENT.setID(mapUtil.get("Practice Content").intValue());
		COURSE_CONTENT.setID(mapUtil.get("Course Content").intValue());

	}

	private ComponentContentType() {

	}

	private void setID(int id) {
		this.id = id;

	}

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
		for (ComponentContentType compContentType : ComponentContentType
				.values()) {
			if (compContentType.getID() == ID) {
				return compContentType;
			}
		}

		throw new NoSuchElementException("Component Content Type ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Component  Content Type [" + getName() + "] ID [" + getID()
				+ "]";
	}
}
