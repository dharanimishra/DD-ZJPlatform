package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum LinkSource {

	// TODO: retrieve the ids from the static data service
	ZIKSANA_INTERNAL(), UNIVERSITY_INTERNAL(), PRIVATE(), PUBLIC();

	private int id;
	private String name;

	private final static String category = "Link Source";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		ZIKSANA_INTERNAL.setID(mapUtil.get("Ziksana Internal").intValue());
		UNIVERSITY_INTERNAL
				.setID(mapUtil.get("University Internal").intValue());
		PRIVATE.setID(mapUtil.get("Relative Private").intValue());
		PUBLIC.setID(mapUtil.get("Public").intValue());

	}

	private LinkSource() {

	}

	private LinkSource(int id, String name) {
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

	public static LinkSource getLinkSource(int ID) {
		for (LinkSource t : LinkSource.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new NoSuchElementException("LinkSource ID [" + ID + "] not found");
	}

	public String toString() {
		return "LinkSource [" + getName() + "] ID [" + getID() + "]";
	}
}
