package com.ziksana.domain.assessment.engagement;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum Operator {

	// TODO: retrieve the ids from the static data service
	EQUALS 				(1, "Equals"),
	LESSTHAN          	(2, "Less than"),
	LESSTHAN_EQUALS     (3, "Less than or Equals"),
	MORETHAN         	(4, "More than"),
	MORETHAN_EQUALS     (5, "More than or Equals");

	private final int id;
	private final String name;

	private Operator(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Operator getOperator(int ID) {
		for (Operator operator : Operator.values()) {
			if (operator.getID() == ID) {
				return operator;
			}
		}

		throw new NoSuchElementException("Operator ID [" + ID + "] not found");
	}

	public String toString() {
		return "Operator [" + getName() + "] ID [" + getID() + "]";
	}
}
