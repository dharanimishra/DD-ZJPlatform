package com.ziksana.domain.member;


public enum Gender {

	// TODO: We may want to retrieve the ids from the static data service
	MALE(1, "Male"),
	FEMALE(2, "Female"),
	UNKNOWN(3, "Unknown"),
	NOT_DISCLOSED(4, "Not Disclosed"),
	NOT_APPLICABLE(5, "Not Applicable");
	
	private final int     id;
	private final String  name;
	
	private Gender(int id, String name) {
		this.id   = id;
		this.name = name;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static Gender getGender(int ID) {
		for (Gender g : Gender.values()) {
			if (g.getID() == ID) {
				return g;
			}
		}
		
		throw new IndexOutOfBoundsException("Gender ID [" + ID + "] not found");
	}
	
	public String toString() {
		return "Gender [" + getName() + "] ID [" + getID() + "]";
	}
}
