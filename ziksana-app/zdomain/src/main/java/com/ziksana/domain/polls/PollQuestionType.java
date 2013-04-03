package com.ziksana.domain.polls;

import java.util.HashMap;
import java.util.Map;

import com.ziksana.util.EnumUtil;

public enum PollQuestionType {

	// TODO: We may want to fetch the ids from the static data service
	SINGLE_CHOICE(1, "Single Choice"), MULTI_CHOICE(2, "Multi Choice");

	private final int id;
	private final String name;

	private final static String category = "Poll Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category :mapUtil :"
				+ mapUtil.size());
	}

	private PollQuestionType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PollQuestionType getType(int ID) {
		for (PollQuestionType t : PollQuestionType.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("PollQuestionType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Poll Question Type [" + getName() + "] ID [" + getID() + "]";
	}
}
