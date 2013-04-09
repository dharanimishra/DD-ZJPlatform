package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum EmbeddedContentType {

	// TODO: retrieve the ids from the static data service
	SUMMARY(), RECAP(), QUIZ(), ASSIGNMENT();

	private int id;

	private String name;

	private final static String category = "Embedded Content Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);

		SUMMARY.setID(mapUtil.get("Summary").intValue());
		RECAP.setID(mapUtil.get("Recap").intValue());
		QUIZ.setID(mapUtil.get("Quiz").intValue());
		ASSIGNMENT.setID(mapUtil.get("Assignment").intValue());
	}

	private EmbeddedContentType() {

	}

	private EmbeddedContentType(int id, String name) {
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

	public static EmbeddedContentType getEmbeddedContentType(int ID)
			throws NoSuchMethodException {
		for (EmbeddedContentType embedContentType : EmbeddedContentType
				.values()) {
			if (embedContentType.getID() == ID) {
				return embedContentType;
			}
		}

		throw new NoSuchMethodException("EmbeddedContentType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "EmbeddedContent Type [" + getName() + "] ID [" + getID() + "]";
	}

}
