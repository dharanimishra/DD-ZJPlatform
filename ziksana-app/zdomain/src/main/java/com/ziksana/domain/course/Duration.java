package com.ziksana.domain.course;

/**
 * @author bhashasp
 */
public class Duration {
	
	public Duration(Integer duration, DurationUnits durationUnits) {
		this.duration = duration;
		this.durationUnits = durationUnits;
	}
	
	private Integer 		duration 	= null;
	private DurationUnits 	durationUnits 	= null;
	
	/**
	 * @return the courseDuration
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * @param courseDuration the courseDuration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
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
