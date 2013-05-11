package com.ziksana.domain.assessment;


public enum TestType {

	// TODO: retrieve the ids from the static data service
	PRACTICE_TEST		(2, "Practice Test"), 
	PREPARATORY_TEST	(3, "Preparatory Test"), 
	PEER_VALUED			(4, "Peer Valued Test"),
	SELF_CHALLENGE		(5, "Self Challenge Test"), 
	EXIT_TEST			(6, "Exit Test"), 
	PREREQUISTE_TEST	(7, "Prerequiste Test");
	

	private final int id;
	
	private final String name;

	private TestType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static TestType getTestType(int ID) throws NoSuchMethodException  {
		for (TestType testType : TestType.values()) {
			if (testType.getID() == ID) {
				return testType;
			}
		}

		throw new NoSuchMethodException("TestType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Test Type [" + getName() + "] ID [" + getID() + "]";
	}
}
