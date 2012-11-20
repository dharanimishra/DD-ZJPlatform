package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum RecipientStudentModel {

	// TODO: retrieve the ids from the static data service
	MODEL1     		(1, "Model 1"),
	MODEL2      	(2, "Model 2");
	

	private final int id;
	
	private final String name;

	private RecipientStudentModel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static RecipientStudentModel getRecipientStudentModel(int ID) {
		for (RecipientStudentModel rsModel : RecipientStudentModel.values()) {
			if (rsModel.getID() == ID) {
				return rsModel;
			}
		}

		throw new NoSuchElementException("RecipientStudent Model ID [" + ID + "] not found");
	}

	public String toString() {
		return "RecipientStudent Model [" + getName() + "] ID [" + getID() + "]";
	}
}
