package com.ziksana.domain.assessment;

public enum PenaltyFactor {

	// TODO: retrieve the ids from the static data service
	PENALTY_FACTOR1		(1, "Factor1"),
	PENALTY_FACTOR2		(2, "Factor2");
		

	private final int id;
	
	private final String name;

	private PenaltyFactor(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PenaltyFactor getPenaltyFactor(int ID){
		for (PenaltyFactor penaltyFactor : PenaltyFactor.values()) {
			if (penaltyFactor.getID() == ID) {
				return penaltyFactor;
			}
		}

		throw new IndexOutOfBoundsException("PenaltyFactor ID [" + ID + "] not found");
	}

	public String toString() {
		return "PenaltyFactor [" + getName() + "] ID [" + getID() + "]";
	}
}
