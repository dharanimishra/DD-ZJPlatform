package com.ziksana.domain.member;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum MessageVisibility {

	// TODO: retrieve the ids from the static data service
	PRIVATE      						(1, "Private"),
	MY_CIRCLE      						(2, "My Cicle"),
	MY_CLASS							(3, "My Class"),
	ALL_TALKING_THIS_CLASS 				(4, "All talking this class"),
	PUBLIC								(5,"Public");
	

	private final int id;
	
	private final String name;

	private MessageVisibility(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static MessageVisibility getMessageVisibility(int ID) {
		for (MessageVisibility visibility : MessageVisibility.values()) {
			if (visibility.getID() == ID) {
				return visibility;
			}
		}

		throw new NoSuchElementException("Message Visibility ID [" + ID + "] not found");
	}

	public String toString() {
		return "Message Visibility [" + getName() + "] ID [" + getID() + "]";
	}
}
