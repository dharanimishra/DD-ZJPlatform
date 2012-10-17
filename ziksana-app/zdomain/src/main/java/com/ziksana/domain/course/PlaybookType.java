/**
 * 
 */
package com.ziksana.domain.course;

/**
 * @author bhashasp
 */
public enum PlaybookType {
	
	// TODO: retrieve the ids from the static data service
	PREVIEW 				(1, "Preview"),  
	PROMOTIONAL 			(2, "Promotional"), 
	REGULAR 				(3, "Regular");  
	
	private final int id;
	
	private final String name;

	private PlaybookType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PlaybookType getPlaybookType(int ID) throws NoSuchMethodException  {
		for (PlaybookType playbookType : PlaybookType.values()) {
			if (playbookType.getID() == ID) {
				return playbookType;
			}
		}

		throw new NoSuchMethodException("PlaybookType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Playbook Type [" + getName() + "] ID [" + getID() + "]";
	}

}
