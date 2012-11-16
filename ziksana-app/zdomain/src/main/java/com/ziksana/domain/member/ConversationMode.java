package com.ziksana.domain.member;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum ConversationMode {

	// TODO: retrieve the ids from the static data service
	IM_CHAT      		(1, "IM Chat"),
	AUDIO_CHAT      	(2, "Audio Chat"),
	VIDEO_CHAT   		(3, "Video Chat"),
	EMAIL 				(4, "Email"),
	FACE_TO_FACE		(5, "Face to Face");
	

	private final int id;
	
	private final String name;

	private ConversationMode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ConversationMode getConversationMode(int ID) {
		for (ConversationMode mode : ConversationMode.values()) {
			if (mode.getID() == ID) {
				return mode;
			}
		}

		throw new NoSuchElementException("Conversation Mode ID [" + ID + "] not found");
	}

	public String toString() {
		return "Conversation Mode [" + getName() + "] ID [" + getID() + "]";
	}
}
