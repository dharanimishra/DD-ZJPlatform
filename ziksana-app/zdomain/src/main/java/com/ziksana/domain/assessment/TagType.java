package com.ziksana.domain.assessment;

public enum TagType {

	// TODO: retrieve the ids from the static data service
	TAG_TYPE1		(1, "Tag Type1"),
	TAG_TYPE2		(2, "Tag Type2");
		

	private final int id;
	
	private final String name;

	private TagType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static TagType getTagType(int ID) throws NoSuchMethodException{
		for (TagType tagType : TagType.values()) {
			if (tagType.getID() == ID) {
				return tagType;
			}
		}

		throw new NoSuchMethodException("TagType ID [" + ID + "] not found");
	}

	public String toString() {
		return "TagType [" + getName() + "] ID [" + getID() + "]";
	}
}
