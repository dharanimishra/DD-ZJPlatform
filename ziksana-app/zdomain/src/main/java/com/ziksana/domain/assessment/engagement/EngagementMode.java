package com.ziksana.domain.assessment.engagement;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum EngagementMode {

	// TODO: retrieve the ids from the static data service
	IM_CHAT 			(1, "IM Chat"),
	AUDIO_CHAT          (2, "Audio chat"),
	VIDEO_CHAT        	(3, "Video chat"),
	EMAIL         		(4, "Email"),
	FACE_TO_FACE      	(5, "Face to Face");
	
	private final int id;
	private final String name;

	private EngagementMode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static EngagementMode getEngagementMode(int ID) {
		for (EngagementMode mode : EngagementMode.values()) {
			if (mode.getID() == ID) {
				return mode;
			}
		}

		throw new NoSuchElementException("EngagementMode ID [" + ID + "] not found");
	}

	public String toString() {
		return "EngagementMode [" + getName() + "] ID [" + getID() + "]";
	}
}
