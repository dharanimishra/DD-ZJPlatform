package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProgrammCurriculum implements Serializable{
	/**
	 * serial versioID
	 */
	private static final long serialVersionUID = 255937390378884100L;

	/**
	 * This field corresponds to the database column corprogramcurriculum.ID
	 */
	private Integer progCurriculumId;

	/**
	 * This field corresponds to the database column
	 * corprogramcurriculum.StartDate
	 */
	private Date startDate;

	/**
	 * This field corresponds to the database column
	 * corprogramcurriculum.EndDate
	 */
	private Date endDate;

	/**
	 * This field corresponds to the database column corprogramcurriculum.Name
	 */
	private String name;

	/**
	 * This field corresponds to the database column
	 * corprogramcurriculum.Description
	 */
	private String description;

	/**
	 * This field corresponds to the database column corprogramcurriculum.Active
	 */
	private Boolean active;

	/**
	 * This field corresponds to the database column
	 * corprogramcurriculum.CurriculumIdentifier
	 */
	private String curriculumIdentifier;
	
	/**
	 * This field corresponds to the database column
	 * corprogramcurriculum.OverallLearnerRating
	 */
	private Integer OverallLearnerRating;
	/**
	 * This field corresponds to the database column
	 * corprogramcurriculum.OverallEducatorRating
	 */
	private Integer OverallEducatorRating;

	/**
	 * This field corresponds to the database column
	 * corprogramcurriculum.learningProgramId
	 */
	private Integer learningProgramId;

	/**
	 * This field corresponds to the database column
	 * corprogramcurriculum.Version
	 */
	private Integer version;

	private List<CurriculumCourse> curriculumCourseList;
	//private List<CurriculumDelivery> curriculumDeliveryList;
	//private List<ProgramCurriculumPlaybook> progCurriculumPlaybookList;
	// private List<LearningElementPricing> learningElementPricingList;
	
	
	/**
	 *This method returns the value of the database column
	 * corprogramcurriculum.progCurriculumId
	 * @return the value of corprogramcurriculum.progCurriculumId
	 */
	public Integer getProgCurriculumId() {
		return progCurriculumId;
	}

	/**
	 *This method sets the value of the database column
	 * corprogramcurriculum.ID
	 * @param ID
	 *            the value for corprogramcurriculum.progCurriculumId
	 */
	public void setProgCurriculumId(Integer progCurriculumId) {
		this.progCurriculumId = progCurriculumId;
	}

	/**
	 *This method returns the value of the database column
	 * corprogramcurriculum.StartDate
	 * @return the value of corprogramcurriculum.StartDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 *This method sets the value of the database column
	 * corprogramcurriculum.StartDate
	 * @param startDate
	 *            the value for corprogramcurriculum.StartDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 *This method returns the value of the database column
	 * corprogramcurriculum.EndDate
	 * @return the value of corprogramcurriculum.EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 *This method sets the value of the database column
	 * corprogramcurriculum.EndDate
	 * @param endDate
	 *            the value for corprogramcurriculum.EndDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 *This method returns the value of the database column
	 * corprogramcurriculum.Name
	 * @return the value of corprogramcurriculum.Name
	 */
	public String getName() {
		return name;
	}

	/**
	 *This method sets the value of the database column
	 * corprogramcurriculum.Name
	 * @param name
	 *            the value for corprogramcurriculum.Name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 *This method returns the value of the database column
	 * corprogramcurriculum.Description
	 * @return the value of corprogramcurriculum.Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 *This method sets the value of the database column
	 * corprogramcurriculum.Description
	 * @param description
	 *            the value for corprogramcurriculum.Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 *This method returns the value of the database column
	 * corprogramcurriculum.Active
	 * @return the value of corprogramcurriculum.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 *This method sets the value of the database column
	 * corprogramcurriculum.Active
	 * @param active
	 *            the value for corprogramcurriculum.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 *This method returns the value of the database column
	 * corprogramcurriculum.CurriculumIdentifier
	 * @return the value of corprogramcurriculum.CurriculumIdentifier
	 */
	public String getCurriculumIdentifier() {
		return curriculumIdentifier;
	}

	/**
	 *This method sets the value of the database column
	 * corprogramcurriculum.CurriculumIdentifier
	 * @param curriculumIdentifier
	 *            the value for corprogramcurriculum.CurriculumIdentifier
	 */
	public void setCurriculumIdentifier(String curriculumIdentifier) {
		this.curriculumIdentifier = curriculumIdentifier == null ? null
				: curriculumIdentifier.trim();
	}

	public Integer getLearningProgramId() {
		return learningProgramId;
	}

	public void setLearningProgramId(Integer learningProgramId) {
		this.learningProgramId = learningProgramId;
	}

	/**
	 *This method returns the value of the database column
	 * corprogramcurriculum.Version
	 * @return the value of corprogramcurriculum.Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 *This method sets the value of the database column
	 * corprogramcurriculum.Version
	 * @param version
	 *            the value for corprogramcurriculum.Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
/*
	*//**
	 * @return the corCourses
	 *//*
	public List<CorCourse> getCorCourses() {
		return corCourses;
	}

	*//**
	 * @param corCourses
	 *            the corCourses to set
	 *//*
	public void setCorCourses(List<CorCourse> corCourses) {
		this.corCourses = corCourses;
	}

*/	/**
	 * @return the overallLearnerRating
	 */
	public Integer getOverallLearnerRating() {
		return OverallLearnerRating;
	}

	/**
	 * @param overallLearnerRating the overallLearnerRating to set
	 */
	public void setOverallLearnerRating(Integer overallLearnerRating) {
		OverallLearnerRating = overallLearnerRating;
	}

	/**
	 * @return the overallEducatorRating
	 */
	public Integer getOverallEducatorRating() {
		return OverallEducatorRating;
	}

	/**
	 * @param overallEducatorRating the overallEducatorRating to set
	 */
	public void setOverallEducatorRating(Integer overallEducatorRating) {
		OverallEducatorRating = overallEducatorRating;
	}

	/**
	 * @return the curriculumCourseList
	 */
	public List<CurriculumCourse> getCurriculumCourseList() {
		return curriculumCourseList;
	}

	/**
	 * @param curriculumCourseList the curriculumCourseList to set
	 */
	public void setCurriculumCourseList(List<CurriculumCourse> curriculumCourseList) {
		this.curriculumCourseList = curriculumCourseList;
	}

/*	*//**
	 * @return the corCurriculumCourses
	 *//*
	public List<CorCurriculumCourse> getCorCurriculumCourses() {
		return corCurriculumCourses;
	}

	*//**
	 * @param corCurriculumCourses
	 *            the corCurriculumCourses to set
	 *//*
	public void setCorCurriculumCourses(
			List<CorCurriculumCourse> corCurriculumCourses) {
		this.corCurriculumCourses = corCurriculumCourses;
	}*/
}