package com.ziksana.domain.course;

import java.util.Date;

/**
 * This object contains more information about Course 
 */
public class CourseDetails {

	/**
	 * This field corresponds to the property ValidFrom
	 */
	private Date validFrom;

	/**
	 * This field corresponds to the property ValidTo
	 */
	private Date validTo;

	/**
	 * This field corresponds to the property CourseStatus
	 */
	private Integer courseStatus;

	/**
	 * This field corresponds to the property Rating
	 */
	private Integer rating;

	/**
	 * This field corresponds to the database column
	 * corcourse.ContentSecurityNeededIndicator
	 */
	private Boolean contentSecurityNeededIndicator;

	/**
	 * This field corresponds to the property CourseWeightage
	 */
	private Integer courseWeightage;

	/**
	 * This field corresponds to the property TotalCredits
	 */
	private String totalCredits;

	/**
	 * This field corresponds to the database column
	 * corcourse.ExtraCreditsIndicator
	 */
	private Boolean extraCreditsIndicator;

	/**
	 * This field corresponds to the property ExtraCredits
	 */
	private String extraCredits;

	/**
	 * This field corresponds to the database column
	 * corcourse.AdditionalPropertyIndicator
	 */
	private Boolean additionalPropertyIndicator;

	private Integer courseDuration;

	private String thumbnailPicturePath;

	private Boolean templateIndicator;
	
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

	public Integer getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Boolean getContentSecurityNeededIndicator() {
		return contentSecurityNeededIndicator;
	}

	public void setContentSecurityNeededIndicator(
			Boolean contentSecurityNeededIndicator) {
		this.contentSecurityNeededIndicator = contentSecurityNeededIndicator;
	}

	public Integer getCourseWeightage() {
		return courseWeightage;
	}

	public void setCourseWeightage(Integer courseWeightage) {
		this.courseWeightage = courseWeightage;
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

	public void setAdditionalPropertyIndicator(Boolean additionalPropertyIndicator) {
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



}
