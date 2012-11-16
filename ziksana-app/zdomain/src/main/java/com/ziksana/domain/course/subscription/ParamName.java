package com.ziksana.domain.course.subscription;


/**
 * @author bhashasp
 */
public enum ParamName {

	// TODO: retrieve the ids from the static data service
	PARAM1			(1, "Param1"), 
	PARAM2		(2, "Param2");
	

	private final int id;
	
	private final String name;

	private ParamName(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ParamName getParamName(int ID) throws NoSuchMethodException{
		for (ParamName paramName : ParamName.values()) {
			if (paramName.getID() == ID) {
				return paramName;
			}
		}

		throw new NoSuchMethodException("ParamName ID [" + ID + "] not found");
	}

	public String toString() {
		return "ParamName [" + getName() + "] ID [" + getID() + "]";
	}

}
