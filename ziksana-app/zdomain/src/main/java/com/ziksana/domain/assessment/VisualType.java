package com.ziksana.domain.assessment;

public enum VisualType {

	// TODO: retrieve the ids from the static data service
	VISUAL_TYPE1		(1, "Visual Type1"),
	VISUAL_TYPE2		(2, "Visual Type2");
		

	private final int id;
	
	private final String name;

	private VisualType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static VisualType getVisualType(int ID){
		for (VisualType visualType : VisualType.values()) {
			if (visualType.getID() == ID) {
				return visualType;
			}
		}

		throw new IndexOutOfBoundsException("VisualType ID [" + ID + "] not found");
	}

	public String toString() {
		return "VisualType [" + getName() + "] ID [" + getID() + "]";
	}
}
