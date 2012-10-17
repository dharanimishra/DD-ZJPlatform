package com.ziksana.domain.course;

/**
 * @author bhashasp
 */
public class Duration {
	
	public Duration(Integer courseDuration, DurationUnits durationUnits) {
		this.courseDuration = courseDuration;
		this.durationUnits = durationUnits;
	}
	
	private Integer 		courseDuration 	= null;
	private DurationUnits 	durationUnits 	= null;
	
	/**
	 * @return the courseDuration
	 */
	public Integer getCourseDuration() {
		return courseDuration;
	}
	/**
	 * @param courseDuration the courseDuration to set
	 */
	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}
	/**
	 * @return the durationUnits
	 */
	public DurationUnits getDurationUnits() {
		return durationUnits;
	}
	/**
	 * @param durationUnits the durationUnits to set
	 */
	public void setDurationUnits(DurationUnits durationUnits) {
		this.durationUnits = durationUnits;
	}
	

}
