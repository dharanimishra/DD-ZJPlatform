package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;



/**
 * @author Ratnesh Kumar
 */

public enum PropertyDataType {

	// TODO: retrieve the ids from the static data service
	NUMBER  		(3425, "Number"),
	DATE    		(3426, "Date"),
	PERCENTAGE    	(3426, "Percentage"),
	ALPHANUMERIC    (3426, "Alphanumeric");
	

	private final int id;
	
	private final String name;
	
	
	private final static String category ="Property Data Type";
	
	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();
	
	static {
//		EnumUtil enumUtil = new EnumUtil();
//		mapUtil = enumUtil.getEnumData(category);
//		System.out.println("Getting static values :category :mapUtil :"
//				+ mapUtil.size());
	}


	private PropertyDataType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PropertyDataType getPropertyDataType(int ID) {
		for (PropertyDataType dataType : PropertyDataType.values()) {
			if (dataType.getID() == ID) {
				return dataType;
			}
		}

		throw new NoSuchElementException("PropertyDataType ID [" + ID + "] not found");
	}

	public String toString() {
		return "PropertyDataType [" + getName() + "] ID [" + getID() + "]";
	}
}
