/**
 * 
 */
package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;



/**
 * @author Ratnesh Kumar
 */

public enum LearningContentDeleteType {
	
	LEARNINGCONTENT					(1, "Learning Content Only"),  
	LEARNINGCONTENT_PARTS 			(2, "Learning Content Parts only"),
	LEARNINGCONTENT_AND_PARTS		(3, "Learning Content and its Parts");
	  
	
	private final int id;
	
	private final String name;

	private final static String category ="ContentDeleteType";
	
	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();
	
	static {

	}

	
	private LearningContentDeleteType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static LearningContentDeleteType getCourseDeleteType(int ID) throws NoSuchMethodException  {
		for (LearningContentDeleteType deleteType : LearningContentDeleteType.values()) {
			if (deleteType.getID() == ID) {
				return deleteType;
			}
		}

		throw new NoSuchMethodException("CourseDeleteType ID [" + ID + "] not found");
	}

	public String toString() {
		return "CourseDelete Type [" + getName() + "] ID [" + getID() + "]";
	}

}
