package com.ziksana.domain.assessment.member;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum SecurityType {

	// TODO: retrieve the ids from the static data service
	NONE      			(1, "None"),
	PROMETRIC      		(2, "Prometric"),
	PROCTORED   		(3, "Proctored"),
	LEARNER_IMAGE 		(4, "Learner Image"),
	ACCESS_KEY			(5, "Access Key");
	

	private final int id;
	
	private final String name;

	private SecurityType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static SecurityType getSecurityType(int ID) {
		for (SecurityType secType : SecurityType.values()) {
			if (secType.getID() == ID) {
				return secType;
			}
		}

		throw new NoSuchElementException("Security Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Security Type [" + getName() + "] ID [" + getID() + "]";
	}
}
