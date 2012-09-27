package com.ziksana.domain.assessment;

import com.ziksana.common.exception.CourseException;

public enum TestType {

	// TODO: retrieve the ids from the static data service
	SELF_TYPE(1, "Self Test"), PRACTICE_TEST(2, "Practice Test"), PREPARATORY_TEST(1, "Preparatory Test"), PEER_VALUED(2, "Peer Valued Test"),
	SELF_CHALLENGE(1, "Self Challenge Test"), EXIT_TEST(2, "Exit Test"), PREREQUISTE_TEST(1, "Prerequiste Test");
	

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

	public static TestType getTestType(int ID) throws CourseException {
		for (TestType testType : TestType.values()) {
			if (testType.getID() == ID) {
				return testType;
			}
		}

		throw new CourseException("TestType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Test Type [" + getName() + "] ID [" + getID() + "]";
	}
}
