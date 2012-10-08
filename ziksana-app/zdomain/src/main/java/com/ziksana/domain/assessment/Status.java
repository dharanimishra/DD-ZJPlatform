package com.ziksana.domain.assessment;


/**
 * @author bhashasp
 */
public enum Status {

	// TODO: retrieve the ids from the static data service
	STATUS1		(1, "status 1"), 
	STATUS2		(2, "status2");
	

	private final int id;
	
	private final String name;

	private Status(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Status getAssignmentStatus(int ID){
		for (Status status : Status.values()) {
			if (status.getID() == ID) {
				return status;
			}
		}

		throw new IndexOutOfBoundsException("Status ID [" + ID + "] not found");
	}

	public String toString() {
		return "Status [" + getName() + "] ID [" + getID() + "]";
	}

}
