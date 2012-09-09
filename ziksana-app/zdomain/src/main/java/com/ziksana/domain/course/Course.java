package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class Course  implements Serializable{
	/**
	 */
	private static final long serialVersionUID = -4593599726417168177L;

	/**
	 This field corresponds to the database column corcourse.courseId
	 */
	private Integer courseId;

	/**
	 This field corresponds to the database column corcourse.Name
	 */
	private String name;

	/**
	 This field corresponds to the database column corcourse.CourseIdentifier
	 */
	private String courseIdentifier;

	/**
	 This field corresponds to the database column corcourse.Description
	 */
	private String description;

	/**
	 This field corresponds to the database column corcourse.ValidFrom
	 */
	private Date validFrom;

	/**
	 This field corresponds to the database column corcourse.ValidTo
	 */
	private Date validTo;

	/**
	 This field corresponds to the database column corcourse.CourseStatus
	 */
	private Integer courseStatus;

	/**
	 This field corresponds to the database column corcourse.Rating
	 */
	private Integer rating;

	/**
	 This field corresponds to the database column
	 corcourse.ContentSecurityNeededIndicator
	 */
	private Boolean contentSecurityNeededIndicator;

	/**
	 This field corresponds to the database column corcourse.CourseWeightage
	 */
	private Integer courseWeightage;

	/**
	 This field corresponds to the database column corcourse.TotalCredits
	 */
	private String totalCredits;

	/**
	 This field corresponds to the database column
	 corcourse.ExtraCreditsIndicator
	 */
	private Boolean extraCreditsIndicator;

	/**
	 This field corresponds to the database column corcourse.ExtraCredits
	 */
	private String extraCredits;

	/**
	 This field corresponds to the database column
	 corcourse.AdditionalPropertyIndicator
	 */
	private Boolean additionalPropertyIndicator;
	
	private Integer courseDuration;
	
	private String thumbnailPicturePath;
	
	private Boolean templateIndicator;
	
	private Integer subjClassificationId;
	
	private Integer memberRoleId;
	
	//private CorCoursePlaybook corCoursePlaybook;
	
	//private List<CorCourseComponent> courseComponents;
	/**
	 This field corresponds to the database column corcourse.Version
	 */
	private Integer version;

/*	private List<CorCurriculumCourse> curriculumCourses;

	private List<CorCourseAdditionalProperty> courseAddnlPropertys;

	private List<CorProgramParticipants> progParticipants;

	private List<CorContent> corContents;
*/
	// TODO: Below associations will be used for later release,
	// private List<CorGroupContext> groupContexts;
	// private List<CorCoursePlayBook> coursePlayBook;
	// private List<CorCourseProgress> courseProgresses;
	// private List<CorCourseContentSecurity> courseContentSecuritys;

	/**
	 . This method returns the value of the database column corcourse.Name
	 
	 @return the value of corcourse.Name
	 
	 */
	public String getName() {
		return name;
	}

	/**
	 . This method sets the value of the database column corcourse.Name
	 
	 @param name
	            the value for corcourse.Name
	 
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 . This method returns the value of the database column
	 corcourse.CourseIdentifier
	 
	 @return the value of corcourse.CourseIdentifier
	 
	 */
	public String getCourseIdentifier() {
		return courseIdentifier;
	}

	/**
	 . This method sets the value of the database column
	 corcourse.CourseIdentifier
	 
	 @param courseIdentifier
	            the value for corcourse.CourseIdentifier
	 
	 */
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier == null ? null
				: courseIdentifier.trim();
	}

	/**
	 . This method returns the value of the database column
	 corcourse.Description
	 
	 @return the value of corcourse.Description
	 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 . This method sets the value of the database column corcourse.Description
	 
	 @param description
	            the value for corcourse.Description
	 
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 . This method returns the value of the database column
	 corcourse.ValidFrom
	 
	 @return the value of corcourse.ValidFrom
	 
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 . This method sets the value of the database column corcourse.ValidFrom
	 
	 @param ValidFrom
	            the value for corcourse.ValidFrom
	 
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 . This method returns the value of the database column corcourse.ValidTo
	 
	 @return the value of corcourse.ValidTo
	 
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 . This method sets the value of the database column corcourse.ValidTo
	 
	 @param ValidTo
	            the value for corcourse.ValidTo
	 
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 . This method returns the value of the database column
	 corcourse.CourseStatus
	 
	 @return the value of corcourse.CourseStatus
	 
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}

	/**
	 . This method sets the value of the database column
	 corcourse.CourseStatus
	 
	 @param courseStatus
	            the value for corcourse.CourseStatus
	 
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 . This method returns the value of the database column corcourse.Rating
	 
	 @return the value of corcourse.Rating
	 
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 . This method sets the value of the database column corcourse.Rating
	 
	 @param rating
	            the value for corcourse.Rating
	 
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 . This method returns the value of the database column
	 corcourse.ContentSecurityNeededIndicator
	 
	 @return the value of corcourse.ContentSecurityNeededIndicator
	 
	 */
	public Boolean getContentSecurityNeededIndicator() {
		return contentSecurityNeededIndicator;
	}

	/**
	 . This method sets the value of the database column
	 corcourse.ContentSecurityNeededIndicator
	 
	 @param contentSecurityNeededIndicator
	            the value for corcourse.ContentSecurityNeededIndicator
	 
	 */
	public void setContentSecurityNeededIndicator(
			Boolean contentSecurityNeededIndicator) {
		this.contentSecurityNeededIndicator = contentSecurityNeededIndicator;
	}

	/**
	 . This method returns the value of the database column
	 corcourse.CourseWeightage
	 
	 @return the value of corcourse.CourseWeightage
	 
	 */
	public Integer getCourseWeightage() {
		return courseWeightage;
	}

	/**
	 . This method sets the value of the database column
	 corcourse.CourseWeightage
	 
	 @param courseWeightage
	            the value for corcourse.CourseWeightage
	 
	 */
	public void setCourseWeightage(Integer courseWeightage) {
		this.courseWeightage = courseWeightage;
	}

	/**
	 . This method returns the value of the database column
	 corcourse.TotalCredits
	 
	 @return the value of corcourse.TotalCredits
	 
	 */
	public String getTotalCredits() {
		return totalCredits;
	}

	/**
	 . This method sets the value of the database column
	 corcourse.TotalCredits
	 
	 @param totalCredits
	            the value for corcourse.TotalCredits
	 
	 */
	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits == null ? null : totalCredits.trim();
	}

	/**
	 . This method returns the value of the database column
	 corcourse.ExtraCreditsIndicator
	 
	 @return the value of corcourse.ExtraCreditsIndicator
	 
	 */
	public Boolean getExtraCreditsIndicator() {
		return extraCreditsIndicator;
	}

	/**
	 . This method sets the value of the database column
	 corcourse.ExtraCreditsIndicator
	 
	 @param extraCreditsIndicator
	            the value for corcourse.ExtraCreditsIndicator
	 
	 */
	public void setExtraCreditsIndicator(Boolean extraCreditsIndicator) {
		this.extraCreditsIndicator = extraCreditsIndicator;
	}

	/**
	 . This method returns the value of the database column
	 corcourse.ExtraCredits
	 
	 @return the value of corcourse.ExtraCredits
	 
	 */
	public String getExtraCredits() {
		return extraCredits;
	}

	/**
	 . This method sets the value of the database column
	 corcourse.ExtraCredits
	 
	 @param extraCredits
	            the value for corcourse.ExtraCredits
	 
	 */
	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits == null ? null : extraCredits.trim();
	}

	/**
	 . This method returns the value of the database column
	 corcourse.AdditionalPropertyIndicator
	 
	 @return the value of corcourse.AdditionalPropertyIndicator
	 
	 */
	public Boolean getAdditionalPropertyIndicator() {
		return additionalPropertyIndicator;
	}

	/**
	 . This method sets the value of the database column
	 corcourse.AdditionalPropertyIndicator
	 
	 @param additionalPropertyIndicator
	            the value for corcourse.AdditionalPropertyIndicator
	 
	 */
	public void setAdditionalPropertyIndicator(
			Boolean additionalPropertyIndicator) {
		this.additionalPropertyIndicator = additionalPropertyIndicator;
	}


	/**
	 . This method returns the value of the database column corcourse.Version
	 
	 @return the value of corcourse.Version
	 
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 . This method sets the value of the database column corcourse.Version
	 
	 @param version
	            the value for corcourse.Version
	 
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

/*	public CorCoursePlaybook getCorCoursePlaybook() {
		return corCoursePlaybook;
	}

	public void setCorCoursePlaybook(CorCoursePlaybook corCoursePlaybook) {
		this.corCoursePlaybook = corCoursePlaybook;
	}

	*//**
	 @return the courseComponents
	 *//*
	public List<CorCourseComponent> getCourseComponents() {
		return courseComponents;
	}

	*//**
	 @param courseComponents the courseComponents to set
	 *//*
	public void setCourseComponents(List<CorCourseComponent> courseComponents) {
		this.courseComponents = courseComponents;
	}
*/
	/**
	 @return the courseDuration
	 */
	public Integer getCourseDuration() {
		return courseDuration;
	}

	/**
	 @param courseDuration the courseDuration to set
	 */
	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}

	/**
	 @return the thumbnailPicturePath
	 */
	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	/**
	 @param thumbnailPicturePath the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	/**
	 @return the templateIndicator
	 */
	public Boolean getTemplateIndicator() {
		return templateIndicator;
	}

	/**
	 @param templateIndicator the templateIndicator to set
	 */
	public void setTemplateIndicator(Boolean templateIndicator) {
		this.templateIndicator = templateIndicator;
	}

	/**
	 @return the subjClassificationId
	 */
	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	/**
	 @param subjClassificationId the subjClassificationId to set
	 */
	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	/**
	 @return the memberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 @param memberRoleId the memberRoleId to set
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * This method returns the value of the database column corcourse.courseId
	 * @return the value of corcourse.courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 *This method sets the value of the database column corcourse.courseId
	 * @param courseId
	 *            the value for corcourse.courseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

/*	*//**
	 @return the curriculumCourses
	 *//*
	public List<CorCurriculumCourse> getCurriculumCourses() {
		return curriculumCourses;
	}

	*//**
	 @param curriculumCourses
	            the curriculumCourses to set
	 *//*
	public void setCurriculumCourses(List<CorCurriculumCourse> curriculumCourses) {
		this.curriculumCourses = curriculumCourses;
	}

	*//**
	 @return the courseAddnlPropertys
	 *//*
	public List<CorCourseAdditionalProperty> getCourseAddnlPropertys() {
		return courseAddnlPropertys;
	}

	*//**
	 @param courseAddnlPropertys
	            the courseAddnlPropertys to set
	 *//*
	public void setCourseAddnlPropertys(
			List<CorCourseAdditionalProperty> courseAddnlPropertys) {
		this.courseAddnlPropertys = courseAddnlPropertys;
	}

	*//**
	 @return the progParticipants
	 *//*
	public List<CorProgramParticipants> getProgParticipants() {
		return progParticipants;
	}

	*//**
	 @param progParticipants
	            the progParticipants to set
	 *//*
	public void setProgParticipants(
			List<CorProgramParticipants> progParticipants) {
		this.progParticipants = progParticipants;
	}

	*//**
	 @return the corContents
	 */
	/*
	 * public List<CorContent> getCorContents() { return corContents; }
	 *//**
	 * @param corContents
	 *            the corContents to set
	 *//*
	public void setCorContents(List<CorContent> corContents) {
		this.corContents = corContents;
	}
*/}