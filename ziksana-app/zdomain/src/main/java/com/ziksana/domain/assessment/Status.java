package com.ziksana.domain.assessment;


/**
 * @author bhashasp
 */
public enum Status {

	// TODO: retrieve the ids from the static data service
	ACTIVE			(1, "Active"), 
	INACTIVE		(2, "Inactive"),
	ARCHIVED		(3, "Archived");
	

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

	public static Status getAssignmentStatus(int ID) throws NoSuchMethodException{
		for (Status status : Status.values()) {
			if (status.getID() == ID) {
				return status;
			}
		}

		throw new NoSuchMethodException("Status ID [" + ID + "] not found");
	}

	public String toString() {
		return "Status [" + getName() + "] ID [" + getID() + "]";
	}

}
