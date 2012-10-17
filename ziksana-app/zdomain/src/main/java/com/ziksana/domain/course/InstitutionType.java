package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum InstitutionType {

	// TODO: retrieve the ids from the static data service
	EDUCATOR           (1, "Draft");
	
	private final int id;
	private final String name;

	private InstitutionType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static InstitutionType getInstitutionType(int ID) {
		for (InstitutionType instType : InstitutionType.values()) {
			if (instType.getID() == ID) {
				return instType;
			}
		}

		throw new NoSuchElementException("InstitutionType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Institution Type [" + getName() + "] ID [" + getID() + "]";
	}
}
