/**
 * 
 */
package com.ziksana.domain.institution;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.Duration;
import com.ziksana.domain.course.Rating;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class ProgramCurriculum extends AuditHistory {
	
	public ProgramCurriculum(Duration duration, Date validityStartDate,
			Date validityEndDate, String name, Integer curriculumIdentifier) {
		this.duration = duration;
		this.validityStartDate = validityStartDate;
		this.validityEndDate = validityEndDate;
		this.name = name;
		this.curriculumIdentifier = curriculumIdentifier;
	}

	private ZID 				programCurriculumId;
	private Duration 			duration 				= null;
	private Date 				validityStartDate 		= null;
	private Date 				validityEndDate 		= null;
	private String 				name 					= null;
	private String 				description 			= null;
	private Boolean 			active 					= null;
	private Integer 			curriculumIdentifier 	= null;
	private Rating 				overallEducatorRating 	= null;
	private Rating 				overallLearnerRating 	= null;
	
	private LearningProgram		learningProgram			= null;
	
	/**
	 * @return the programCurriculumId
	 */
	public ZID getProgramCurriculumId() {
		return programCurriculumId;
	}
	/**
	 * @param programCurriculumId the programCurriculumId to set
	 */
	public void setProgramCurriculumId(Integer programCurriculumId) {
		this.programCurriculumId = new IntegerZID(programCurriculumId);
	}
	/**
	 * @return the duration
	 */
	public Duration getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	/**
	 * @return the validityStartDate
	 */
	public Date getValidityStartDate() {
		return validityStartDate;
	}
	/**
	 * @param validityStartDate the validityStartDate to set
	 */
	public void setValidityStartDate(Date validityStartDate) {
		this.validityStartDate = validityStartDate;
	}
	/**
	 * @return the validityEndDate
	 */
	public Date getValidityEndDate() {
		return validityEndDate;
	}
	/**
	 * @param validityEndDate the validityEndDate to set
	 */
	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the curriculumIdentifier
	 */
	public Integer getCurriculumIdentifier() {
		return curriculumIdentifier;
	}
	/**
	 * @param curriculumIdentifier the curriculumIdentifier to set
	 */
	public void setCurriculumIdentifier(Integer curriculumIdentifier) {
		this.curriculumIdentifier = curriculumIdentifier;
	}
	/**
	 * @return the overallEducatorRating
	 */
	public Rating getOverallEducatorRating() {
		return overallEducatorRating;
	}
	/**
	 * @param overallEducatorRating the overallEducatorRating to set
	 */
	public void setOverallEducatorRating(Rating overallEducatorRating) {
		this.overallEducatorRating = overallEducatorRating;
	}
	/**
	 * @return the overallLearnerRating
	 */
	public Rating getOverallLearnerRating() {
		return overallLearnerRating;
	}
	/**
	 * @param overallLearnerRating the overallLearnerRating to set
	 */
	public void setOverallLearnerRating(Rating overallLearnerRating) {
		this.overallLearnerRating = overallLearnerRating;
	}
	/**
	 * @return the learningProgram
	 */
	public LearningProgram getLearningProgram() {
		return learningProgram;
	}
	/**
	 * @param learningProgram the learningProgram to set
	 */
	public void setLearningProgram(LearningProgram learningProgram) {
		this.learningProgram = learningProgram;
	}

	@Override
	public String toString() {
		return "ProgramCurriculum [duration=" + duration
				+ ", validityStartDate=" + validityStartDate
				+ ", validityEndDate=" + validityEndDate + ", name=" + name
				+ ", description=" + description + ", active=" + active
				+ ", curriculumIdentifier=" + curriculumIdentifier + "]";
	}

}
