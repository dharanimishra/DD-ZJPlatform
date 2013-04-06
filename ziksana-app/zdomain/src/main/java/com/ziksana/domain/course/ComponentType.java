package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum ComponentType {

	// TODO: retrieve the ids from the static data service
	MODULE(), SUBJECT(), SUBJECT_AREA(), SECTION(), SUB_SECTION(), TOPIC(), CHAPTER(), POLICY(), PREREQUISTE(), COREQUISTE();

	private int id;

	private String name;

	private final static String category = "Component Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		MODULE.setID(mapUtil.get("Module").intValue());
		SUBJECT.setID(mapUtil.get("Subject").intValue());
		SUBJECT_AREA.setID(mapUtil.get("Subject Area").intValue());
		SECTION.setID(mapUtil.get("Section").intValue());
		SUB_SECTION.setID(mapUtil.get("Sub Section").intValue());
		TOPIC.setID(mapUtil.get("Topic").intValue());
		CHAPTER.setID(mapUtil.get("Chapter").intValue());
		POLICY.setID(mapUtil.get("Policy").intValue());
		PREREQUISTE.setID(mapUtil.get("Pre Requiste").intValue());
		COREQUISTE.setID(mapUtil.get("Co Requiste").intValue());

	}

	private ComponentType() {

	}

	private ComponentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private void setID(int id) {
		this.id = id;

	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ComponentType getComponentType(int ID) {
		for (ComponentType compType : ComponentType.values()) {
			if (compType.getID() == ID) {
				return compType;
			}
		}

		throw new NoSuchElementException("ComponentType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Component Type [" + getName() + "] ID [" + getID() + "]";
	}
}
