package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum ContentStatus {

	// TODO: retrieve the ids from the static data service
	DRAFT(), REVIEW(), ACTIVE(), RELEASE(), HOLD(), ARCHIVED();

	private int id;

	private String name;

	private final static String category = "Course Status";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		DRAFT.setID(mapUtil.get("Under Construction").intValue());
		REVIEW.setID(mapUtil.get("Under Review").intValue());
		RELEASE.setID(mapUtil.get("Ready for Release").intValue());
		ACTIVE.setID(mapUtil.get("Active").intValue());
		HOLD.setID(mapUtil.get("Hold").intValue());
		ARCHIVED.setID(mapUtil.get("Archived").intValue());

	}

	private ContentStatus() {

	}

	private ContentStatus(int id, String name) {
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

	public static ContentStatus getContentStatus(int ID) {
		for (ContentStatus contentStatus : ContentStatus.values()) {
			if (contentStatus.getID() == ID) {
				return contentStatus;
			}
		}

		throw new NoSuchElementException("Content Status ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Content Status [" + getName() + "] ID [" + getID() + "]";
	}
}
