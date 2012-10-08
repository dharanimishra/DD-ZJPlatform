/**
 * 
 */
package com.ziksana.domain.course;


/**
 * @author bhashasp
 */
public enum CourseStatus {

	// TODO: retrieve the ids from the static data service
	DRAFT           (1, "Draft"),
	REVIEW          (2, "Review"),
	PUBLISH         (3, "Publish"),
	RELEASED        (4,"Released"),
	SUBSCRIBED      (5, "Subscribed"),
	SOCIALIZE       (6, "Socialized"),
	ADMINISTER_EVAL (7, "Administer Evaluation");

	private final int id;
	private final String name;

	private CourseStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CourseStatus getCourseStatus(int ID) {
		for (CourseStatus t : CourseStatus.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("CourseStatus ID [" + ID + "] not found");
	}

	public String toString() {
		return "Course Status [" + getName() + "] ID [" + getID() + "]";
	}
}