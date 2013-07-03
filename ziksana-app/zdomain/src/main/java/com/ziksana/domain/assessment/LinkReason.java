package com.ziksana.domain.assessment;

public enum LinkReason {

	// TODO: retrieve the ids from the static data service
	HIGHER_PROFICIENCY		(1, "Higher Proficiency"), 
	ADDITIONAL_CARDS		(2, "Additional Cards"),
	CURIOSITY				(3, "Curiosity");
	

	private final int id;
	
	private final String name;

	private LinkReason(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static LinkReason getAssignmentLinkReason(int ID) throws NoSuchMethodException{
		for (LinkReason linkReason : LinkReason.values()) {
			if (linkReason.getID() == ID) {
				return linkReason;
			}
		}

		throw new NoSuchMethodException("Link Reason ID [" + ID + "] not found");
	}

	public String toString() {
		return "Link Reason [" + getName() + "] ID [" + getID() + "]";
	}

}
