package com.ziksana.domain.assessment;

public enum TestModel {

	// TODO: retrieve the ids from the static data service
	STANDARD		(1, "Standard"),
	COMPETENCY		(2, "Competency based"), 
	PROFICIENCY		(3, "Proficiency based"), 
	ADAPTIVE		(4, "Adaptive");
	

	private final int id;
	
	private final String name;

	private TestModel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static TestModel getTestModel(int ID) throws NoSuchMethodException  {
		for (TestModel testModel : TestModel.values()) {
			if (testModel.getID() == ID) {
				return testModel;
			}
		}

		throw new NoSuchMethodException("TestModel ID [" + ID + "] not found");
	}

	public String toString() {
		return "Test Model [" + getName() + "] ID [" + getID() + "]";
	}
}
