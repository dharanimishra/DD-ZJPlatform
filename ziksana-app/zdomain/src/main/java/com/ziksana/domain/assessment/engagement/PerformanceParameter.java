package com.ziksana.domain.assessment.engagement;

import java.util.NoSuchElementException;

/**
 * @author bhashasp
 */
public enum PerformanceParameter {

	// TODO: retrieve the ids from the static data service
	ATTENDANCE 			(1, "Attendance"),
	GRADE          		(2, "Grade"),
	PARTICIPATION       (3, "Participation"),
	TIME_TO_COMPLETE    (4, "Time to Complete"),
	TIME_PERIOD      	(5, "Time period"),
	FREQUENCY       	(6, "frequency");
	
	private final int id;
	private final String name;

	private PerformanceParameter(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PerformanceParameter getPerformanceParameter(int ID) {
		for (PerformanceParameter param : PerformanceParameter.values()) {
			if (param.getID() == ID) {
				return param;
			}
		}

		throw new NoSuchElementException("PerformanceParameter ID [" + ID + "] not found");
	}

	public String toString() {
		return "PerformanceParameter [" + getName() + "] ID [" + getID() + "]";
	}
}
