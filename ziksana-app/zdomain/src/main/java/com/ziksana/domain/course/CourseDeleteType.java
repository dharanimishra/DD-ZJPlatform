/**
 * 
 */
package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;




/**
 * @author Ratnesh Kumar
 */

public enum CourseDeleteType {
	
	CONTENT					(1, "Content Only"),  
	CONTENT_PARTS 			(2, "Content Parts only"),
	CONTENT_AND_PARTS		(3, "Content and its Parts");
	  
	
	private final int id;
	
	private final String name;
	
	private final static String category ="Course Status";
	
	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();
	
	static {
//		EnumUtil enumUtil = new EnumUtil();
//		mapUtil = enumUtil.getEnumData(category);
//		System.out.println("Getting static values :category :mapUtil :"
//				+ mapUtil.size());
	}


	private CourseDeleteType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CourseDeleteType getCourseDeleteType(int ID) throws NoSuchMethodException  {
		for (CourseDeleteType deleteType : CourseDeleteType.values()) {
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
