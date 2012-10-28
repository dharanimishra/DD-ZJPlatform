/**
 * 
 */
package com.ziksana.domain.course;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum ParticipantType {

	// TODO: retrieve the ids from the static data service
	AUTHOR      		(1, "Author"),
	PEER_REVIEWER      	(2, "Peer Reviewer"),
	ELEVATED_REVIEWER   (3, "Elevated  Reviewer"),
	LEARNER_REVIEWER 	(4, "Learner Reviewer"),
	EXTERNAL_REVIEWER 	(5, "Exterrnal Reviewer"),
	ADMINISTRATOR		(6, "Administrator");
	

	private final int id;
	
	private final String name;

	private ParticipantType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ParticipantType getParticipantType(int ID) {
		for (ParticipantType participantType : ParticipantType.values()) {
			if (participantType.getID() == ID) {
				return participantType;
			}
		}

		throw new NoSuchElementException("Participant Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Participant Type [" + getName() + "] ID [" + getID() + "]";
	}
}
