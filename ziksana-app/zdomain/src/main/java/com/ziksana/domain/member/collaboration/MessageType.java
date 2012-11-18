package com.ziksana.domain.member.collaboration;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum MessageType {

	// TODO: retrieve the ids from the static data service
	PRIVATE      						(1, "Private"),
	MY_CIRCLE      						(2, "My Cicle"),
	MY_CLASS							(3, "My Class"),
	ALL_TALKING_THIS_CLASS 				(4, "All talking this class"),
	PUBLIC								(5,"Public");
	

	private final int id;
	
	private final String name;

	private MessageType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static MessageType getMessageType(int ID) {
		for (MessageType messageType : MessageType.values()) {
			if (messageType.getID() == ID) {
				return messageType;
			}
		}

		throw new NoSuchElementException("Message Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Message Type [" + getName() + "] ID [" + getID() + "]";
	}
}
