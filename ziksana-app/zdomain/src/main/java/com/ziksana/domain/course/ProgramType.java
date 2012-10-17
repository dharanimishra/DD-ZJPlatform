package com.ziksana.domain.course;


public enum ProgramType {
	
	// TODO: retrieve the ids from the static data service
	MASTER 				(1, "Masters"),  
	BACHELORS 			(2, "Bachelors"), 
	EXECUTIVE 			(3, "Executive"),  
	DIPLOMA				(4, "Diploma"), 
	CERTIFICATE 		(5, "Certificate"), 
	DOCTORATE 			(6, "Doctorate"), 
	UNDERGRADUATE 		(7, "Undergraduate"), 
	VOCATIONAL 			(8, "Vocational"), 
	OPEN_LEARNING 		(9, "Open Learning");
	
	private final int id;
	
	private final String name;

	private ProgramType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ProgramType getProgramType(int ID) throws NoSuchMethodException  {
		for (ProgramType progType : ProgramType.values()) {
			if (progType.getID() == ID) {
				return progType;
			}
		}

		throw new NoSuchMethodException("ProgramType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Program Type [" + getName() + "] ID [" + getID() + "]";
	}

}
