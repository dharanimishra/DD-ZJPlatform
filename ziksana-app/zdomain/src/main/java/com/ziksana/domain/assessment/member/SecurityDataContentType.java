package com.ziksana.domain.assessment.member;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum SecurityDataContentType {

	// TODO: retrieve the ids from the static data service
	VIDEO      		(1, "Video"),
	IMAGE      		(2, "Image"),
	FINGERPRINT   	(3, "Fingerprint"),
	TIME 			(4, "Time");
	

	private final int id;
	
	private final String name;

	private SecurityDataContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static SecurityDataContentType getSecurityDataContentType(int ID) {
		for (SecurityDataContentType dataContentType : SecurityDataContentType.values()) {
			if (dataContentType.getID() == ID) {
				return dataContentType;
			}
		}

		throw new NoSuchElementException("SecurityDataContent Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "SecurityDataContent Type [" + getName() + "] ID [" + getID() + "]";
	}
}
