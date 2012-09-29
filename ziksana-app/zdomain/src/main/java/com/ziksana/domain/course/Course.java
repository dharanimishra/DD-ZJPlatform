package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.common.exception.CourseException;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utilz.SubjectClassification;

/**
 * @author bhashasp
 */
public class Course extends AuditHistory{

	//TODO: Separator will change, based on requirement
	private static String NAME_IDENTIFIER_SEPARATOR = "-";

	public Course() {
		setCourseStatus(CourseStatus.DRAFT);
	}

	public Course(Integer courseId) {
		this.courseId = courseId;
		setCourseStatus(CourseStatus.ADMINISTER_EVAL);
	}

	private Integer courseId;
	/**
	 * Maximum Length:45
	 */
	private String name;
	/**
	 * Identifier for the Course<br>Maximum Length:45
	 */
	private String courseIdentifier;
	/**
	 * Maximum Length:240
	 */
	private String description;
	/**
	 * Course Start Date is for when Course is associate to curriculumm
	 */
	private Date validFrom;
	/**
	 * Course End Date is for When Course is associate to curriculumm
	 */
	private Date 			validTo;
	private CourseStatus 	courseStatus;
	private Rating 			rating;
	/**
	 * Maximum Length:1
	 */
	private Boolean securityNeededIndicator;
	/**
	 * Maximum Length:5
	 */
	private String totalCredits;

	/**
	 * Maximum Length:1
	 */
	private Boolean extraCreditsIndicator;
	/**
	 *  Maximum Length:5
	 */
	private String extraCredits;
	/**
	 * Maximum Length:1
	 */
	private Boolean additionalPropertyIndicator;
	/**
	 * Maximum Length:72
	 */
	private String thumbnailPicturePath;
	/**
	 * Maximum Length:1
	 */
	private Boolean templateIndicator;
	private Integer courseDuration;

	private SubjectClassification 	subjClassification	 	= null;

	private MemberPersona 			accountableMember 		= null;

	private CourseDetails 			courseDetails 			= null;

	private Integer version;

	/**
	 * This method returns the value of the property Name
	 * @return the value of attribute Name
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method returns the value of the attribute CourseIdentifier
	 * @return the value of attribute CourseIdentifier
	 */
	public String getCourseIdentifier() {
		return courseIdentifier;
	}
	/**
	 * This method sets the value of the attribute CourseIdentifier
	 * @param courseIdentifier
	 *            the value for attribute CourseIdentifier
	 */
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier == null ? null
				: courseIdentifier.trim();
	}
	/**
	 * Sets the name and identifier from UI input field {name}, and separates both by defined separtor
	 * @param name
	 * @throws CourseException
	 */
	public void setCourseName(String name) throws CourseException {
		if (name == null) {
			throw new CourseException("Null name passed");
		}
		String courseNameArr[] = name.split(NAME_IDENTIFIER_SEPARATOR, 2);

		if (courseNameArr.length < 2) {
			throw new CourseException("Name is not given in a format [ identifier"+NAME_IDENTIFIER_SEPARATOR+"name ]");
		}
		this.name = courseNameArr[1];
		setCourseIdentifier(courseNameArr[0]);
	}
	/**
	 * This method gets the name and courseidentifier from database retrieval and appends
	 * with defined separtor to display in UI
	 * @param courseIdentifier
	 * @param name
	 * @throws CourseException
	 */
	public void setCourseNameFromData(String courseIdentifier, String name)
			throws CourseException {
		if (courseIdentifier == null || name == null) {
			throw new CourseException(" Name or Course Identifier are Null");
		}
		this.name = courseIdentifier + NAME_IDENTIFIER_SEPARATOR + name;
	}
	/**
	 * This method returns the value of the attribute Description
	 * @return the value of attribute Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the value of the property Description
	 * @param description
	 *            the value for attribute Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method returns the value of the property Version
	 * @return the value of attribute Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method sets the value of the property Version
	 * @param version
	 *            the value for attribute Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * This method returns the value of the property courseId
	 * @return the value of attribute courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method sets the value of the property courseId
	 * @param courseId
	 *            the value for attribute courseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseDetails
	 */
	public CourseDetails getCourseDetails() {
		return courseDetails;
	}

	/**
	 * @param courseDetails
	 *            the courseDetails to set
	 */
	public void setCourseDetails(CourseDetails courseDetails) {
		this.courseDetails = courseDetails;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Boolean getSecurityNeededIndicator() {
		return securityNeededIndicator;
	}

	public void setSecurityNeededIndicator(Boolean securityNeededIndicator) {
		this.securityNeededIndicator = securityNeededIndicator;
	}

	public String getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Boolean getExtraCreditsIndicator() {
		return extraCreditsIndicator;
	}

	public void setExtraCreditsIndicator(Boolean extraCreditsIndicator) {
		this.extraCreditsIndicator = extraCreditsIndicator;
	}

	public String getExtraCredits() {
		return extraCredits;
	}

	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits;
	}

	public Boolean getAdditionalPropertyIndicator() {
		return additionalPropertyIndicator;
	}

	public void setAdditionalPropertyIndicator(
			Boolean additionalPropertyIndicator) {
		this.additionalPropertyIndicator = additionalPropertyIndicator;
	}

	public Integer getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	public Boolean getTemplateIndicator() {
		return templateIndicator;
	}

	public void setTemplateIndicator(Boolean templateIndicator) {
		this.templateIndicator = templateIndicator;
	}

	/**
	 * @return the courseStatus
	 */
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	/**
	 * @param courseStatus
	 *            the courseStatus to set
	 */
	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	/**
	 * @return the accountableMember
	 */
	public MemberPersona getAccountableMember() {
		return accountableMember;
	}

	/**
	 * @param accountableMember the accountableMember to set
	 */
	public void setAccountableMember(MemberPersona accountableMember) {
		this.accountableMember = accountableMember;
	}

	public String toString() {
		return "Course [name=" + name + ", courseIdentifier="
				+ courseIdentifier + ", courseStatus=" + courseStatus
				+ ", courseDuration=" + courseDuration + "]";
	}

	/**
	 * @return the subjClassification
	 */
	public SubjectClassification getSubjClassification() {
		return subjClassification;
	}

	/**
	 * @param subjClassification the subjClassification to set
	 */
	public void setSubjClassification(SubjectClassification subjClassification) {
		this.subjClassification = subjClassification;
	}

	}