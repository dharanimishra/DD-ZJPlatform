package com.ziksana.domain.institution;

/**
 * @author bhashasp
 */
public enum ParticipatingType {

	// TODO: retrieve the ids from the static data service
	LEAD_PROFESSOR			(1, "Lead Professor"), 
	ASSISSTANT_PROFESSOR	(2,	"Assisstant Professor"), 
	VISITING_PROFESSOR		(3, "Visiting Professor"), 
	TEACHING_ASSISSTANT		(4, "Teaching Assisstant"), 
	LAB_ASSISSTANT			(5, "Lab Assisstant"), 
	OTHER					(6, "Other");

	private final int id;

	private final String name;

	private ParticipatingType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ParticipatingType getParticipatingType(int ID)
			throws NoSuchMethodException {
		for (ParticipatingType partType : ParticipatingType.values()) {
			if (partType.getID() == ID) {
				return partType;
			}
		}

		throw new NoSuchMethodException("ParticipatingType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Participating Type [" + getName() + "] ID [" + getID() + "]";
	}

}
