package com.ziksana.domain.course;

/**
 * @author bhashasp
 */
public class Duration {

	public Duration(Integer duration, DurationUnits durationUnits) {
		this.duration = duration;
		this.durationUnits = durationUnits;
	}

	public Duration(Integer duration, Integer durationUnit) {
		this.duration = duration;
		this.durationUnit = durationUnit;
	}

	private Integer duration = null;

	private Integer durationUnit = 0;

	public Integer getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(Integer durationUnit) {
		this.durationUnit = durationUnit;
	}

	private DurationUnits durationUnits = null;

	/**
	 * @return the courseDuration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param courseDuration
	 *            the courseDuration to set
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
	 * @param durationUnits
	 *            the durationUnits to set
	 */
	public void setDurationUnits(DurationUnits durationUnits) {
		this.durationUnits = durationUnits;
	}

}
