package com.ziksana.domain.course;

import java.util.NoSuchElementException;


/**
 * @author Ratnesh Kumar
 */

public enum PropertyUsageType {

	// TODO: retrieve the ids from the static data service
	DEFINITION 		(3400, "Definition"),// Course Addnl property
	VALIDATION    	(3401, "Validation"),// Member Addnl property 
	ANALYTICS    	(3402, "Analytics"); // Curriculum Addnl property
	

	private final int id;
	
	private final String name;

	private PropertyUsageType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PropertyUsageType getPropertyUsageType(int ID) {
		for (PropertyUsageType usageType : PropertyUsageType.values()) {
			if (usageType.getID() == ID) {
				return usageType;
			}
		}

		throw new NoSuchElementException("Property UsageType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Property UsageType [" + getName() + "] ID [" + getID() + "]";
	}
}
