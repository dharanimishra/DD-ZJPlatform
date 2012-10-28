/**
 * 
 */
package com.ziksana.domain.institution;

/**
 * @author bhashasp
 */
public enum ProgramNameType {
	
	LEARNING_PROGRAM	(1, "Learning Program"),  
	COURSE 				(2, "Course"),
	LEARNING_OBJECT		(3, "Learning Object"),
	LEARNING_CONTENT	(4, "Learning Content"); 
	  
	
	private final int id;
	
	private final String name;

	private ProgramNameType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ProgramNameType getProgramNameType(int ID) throws NoSuchMethodException  {
		for (ProgramNameType progType : ProgramNameType.values()) {
			if (progType.getID() == ID) {
				return progType;
			}
		}

		throw new NoSuchMethodException("ProgramNameType ID [" + ID + "] not found");
	}

	public String toString() {
		return "ProgramName Type [" + getName() + "] ID [" + getID() + "]";
	}

}
