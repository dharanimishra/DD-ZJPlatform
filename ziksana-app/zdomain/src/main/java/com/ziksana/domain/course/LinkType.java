package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;


/**
 * @author Ratnesh Kumar
 */

public enum LinkType {

	
	
	//TODO: retrieve the ids from the static data service
	REFERENCE			(1, "Reference"),
	ADDITIONAL_INFO		(2, "Additional information"),
	VARIATION_INFO		(3, "Variation information"),
	LOCALIZATION_INFO	(4, "Localization information"),
	EXAMPLE_INFO		(5, "External URI"),
	TEST_INFO			(6, "Test information"),
	TOC					(7, "Table of Contents / Topic"),
	NOTE				(8, "Note");

	private final int id;
	private final String name;

	private final static String category ="Link Type";
	
	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();
	
	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category :mapUtil :"
				+ mapUtil.size());
	}

	
	private LinkType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static LinkType getLinkType(int ID){
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
