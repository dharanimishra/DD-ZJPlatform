package com.ziksana.domain.polls;

import com.ziksana.common.exception.PollException;

public enum PollVisibility {

	// TODO: We may want to retrieve the ids from the static data service
	ALL        (1, "All"),         // Poll is shown to everyone
	RESTRICTED (2, "Restricted");  // Poll Questions are shown based on
	                               // Poll.targetMemberRole
	
	private final int    id;
	private final String name;
	
	private PollVisibility(int id, String name) {
		this.id   = id;
		this.name = name;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static PollVisibility getVisibility(int ID) 
	throws PollException {
		for (PollVisibility v : PollVisibility.values()) {
			if (v.getID() == ID) {
				return v;
			}
		}
		
		throw new PollException("PollVisibility ID [" + ID + "] not found");
	}
	
	public String toString() {
		return "Poll Visibility [" + getName() + "] ID [" + getID() + "]";
	}
}
