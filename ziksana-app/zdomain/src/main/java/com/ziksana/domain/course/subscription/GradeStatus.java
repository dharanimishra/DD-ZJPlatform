package com.ziksana.domain.course.subscription;

/**
 * @author bhashasp
 */
public enum GradeStatus {

	// TODO: retrieve the ids from the static data service
	INTERMEDIATE			(1, "Intermediate"), 
	FINAL					(2, "Final"),
	BASELINED				(3, "Baselined");

	private final int id;
	
	private final String name;

	private GradeStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static GradeStatus getGradeStatus(int ID) throws NoSuchMethodException{
		for (GradeStatus status : GradeStatus.values()) {
			if (status.getID() == ID) {
				return status;
			}
		}

		throw new NoSuchMethodException("GradeStatus ID [" + ID + "] not found");
	}

	public String toString() {
		return "GradeStatus [" + getName() + "] ID [" + getID() + "]";
	}

}
