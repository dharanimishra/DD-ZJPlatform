package com.ziksana.domain.course.subscription;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum ActivityType {

	// TODO: retrieve the ids from the static data service
	CONTENT_STUDY        	(1,  "Content Study"), 
	ASSIGNMENT       		(2,  "Assignment"), 
	SOCIAL_INTERACTION  	(3,  "Social Interaction"), 
	GUIDANCE       			(4,  "Guidance");
	

	private final int id;
	
	private final String name;

	private ActivityType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ActivityType getActivityType(int ID){
		for (ActivityType activityType : ActivityType.values()) {
			if (activityType.getID() == ID) {
				return activityType;
			}
		}

		throw new NoSuchElementException("ActivityType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Activity Type [" + getName() + "] ID [" + getID() + "]";
	}
}
