package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum LinkType {

	// TODO: retrieve the ids from the static data service
	REFERENCE(), ADDITIONAL_INFO(), VARIATION_INFO(), LOCALIZATION_INFO(), EXAMPLE_INFO(), TEST_INFO(), TOC(), NOTE();

	private int id;
	private String name;

	private final static String category = "Link Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);

		REFERENCE.setID(mapUtil.get("Reference").intValue());
		ADDITIONAL_INFO.setID(mapUtil.get("Additional information").intValue());
		VARIATION_INFO.setID(mapUtil.get("Variation information").intValue());
		LOCALIZATION_INFO.setID(mapUtil.get("Localization information")
				.intValue());

		EXAMPLE_INFO.setID(mapUtil.get("External URI").intValue());
		TEST_INFO.setID(mapUtil.get("Test information").intValue());
		TOC.setID(mapUtil.get("Table of Contents / Topic").intValue());
		NOTE.setID(mapUtil.get("Note").intValue());

	}

	private LinkType() {

	}

	private LinkType(int id, String name) {
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

	public static LinkType getLinkType(int ID) {
		for (LinkType t : LinkType.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new NoSuchElementException("LinkType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Link Type [" + getName() + "] ID [" + getID() + "]";
	}
}
