package com.ziksana.domain.course;


public enum ContentStatus {

	// TODO: retrieve the ids from the static data service
	ARCHIVED(1, "Archived"),
	OTHER(2, "Other");
	

	private final int id;
	
	private final String name;

	private ContentStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentStatus getContentStatus(int ID) {
		for (ContentStatus contentStatus : ContentStatus.values()) {
			if (contentStatus.getID() == ID) {
				return contentStatus;
			}
		}

		throw new IndexOutOfBoundsException("Content Status ID [" + ID + "] not found");
	}

	public String toString() {
		return "Content Status [" + getName() + "] ID [" + getID() + "]";
	}
}
