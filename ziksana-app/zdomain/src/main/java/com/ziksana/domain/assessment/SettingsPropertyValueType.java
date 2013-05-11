package com.ziksana.domain.assessment;

import java.util.NoSuchElementException;

public enum SettingsPropertyValueType {

	// TODO: retrieve the ids from the static data service
	NUMBER   		(1, "Number"),
	PERCENTAGE 		(2, "Percentage"),
	DATE   			(3, "Date"),
	TIME			(4, "Time	");

	private final int 		id;
	private final String 	name;

	private SettingsPropertyValueType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static SettingsPropertyValueType getSettingsPropertyValueType(int ID) {
		for (SettingsPropertyValueType propValueType : SettingsPropertyValueType.values()) {
			if (propValueType.getID() == ID) {
				return propValueType;
			}
		}
		throw new NoSuchElementException("SettingsProperty ValueType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Settings Property Value Type [" + getName() + "] ID [" + getID() + "]";
	}
}
