package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author Ratnesh Kumar
 */

public enum LinkSource {

	// TODO: retrieve the ids from the static data service
	ZIKSANA_INTERNAL(1, "Ziksana Internal"), UNIVERSITY_INTERNAL(2,
			"University Internal"), PRIVATE(3, "Private"), PUBLIC(4, "Public");

	private final int id;
	private final String name;

	private final static String category = "Link Source";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
//		EnumUtil enumUtil = new EnumUtil();
//		mapUtil = enumUtil.getEnumData(category);
//		System.out.println("Getting static values :category :mapUtil :"
//				+ mapUtil.size());
	}

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
