package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum GradeType {

	// TODO: retrieve the ids from the static data service
	PERCENTAGE(1, "Perncentage"), PERCENTILE(2, "Percentile"), RELATIVE_POSITION(
			3, "Relative Position"), GPA(4, "GPA"), A_PLUS(5, "A +");

	private int id;

	private String name;

	private final static String category = "Grade Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category " + category
				+ " :mapUtil :" + mapUtil.size());

		PERCENTAGE.setID(mapUtil.get("Perncentage").intValue());
		PERCENTILE.setID(mapUtil.get("Percentile").intValue());
		RELATIVE_POSITION.setID(mapUtil.get("Relative Position").intValue());
		GPA.setID(mapUtil.get("GPA").intValue());
		A_PLUS.setID(mapUtil.get("A +").intValue());
	}

	private GradeType() {

	}

	private void setID(int id) {
		this.id = id;
	}

	private GradeType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static GradeType getGradeType(int ID) {
		for (GradeType gradeType : GradeType.values()) {
			if (gradeType.getID() == ID) {
				return gradeType;
			}
		}

		throw new NoSuchElementException("Grade Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Grade Type [" + getName() + "] ID [" + getID() + "]";
	}
}
