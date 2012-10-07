package com.ziksana.domain.course;


public enum LinkType {

	//TODO: retrieve the ids from the static data service
	EXTERNAL_URI(1, "External URI"),
	INTERNAL_URI(2, "Internal URI");

	private final int id;
	private final String name;

	private LinkType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static LinkType getLinkType(int ID){
		for (LinkType t : LinkType.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("LinkType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Link Type [" + getName() + "] ID [" + getID() + "]";
	}
}
