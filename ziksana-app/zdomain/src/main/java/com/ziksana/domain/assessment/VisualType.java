package com.ziksana.domain.assessment;

public enum VisualType {

	// TODO: retrieve the ids from the static data service
	VIDEO				(1, "Video"),
	ANNOTATED_VIDEO		(2, "Annotated Video"),
	PICTURE				(3, "Picture"),
	ANNOTATED_PICTURE	(4, "Annotated Picture");
		

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

	public static VisualType getVisualType(int ID) throws NoSuchMethodException{
		for (VisualType visualType : VisualType.values()) {
			if (visualType.getID() == ID) {
				return visualType;
			}
		}

		throw new NoSuchMethodException("VisualType ID [" + ID + "] not found");
	}

	public String toString() {
		return "VisualType [" + getName() + "] ID [" + getID() + "]";
	}
}
