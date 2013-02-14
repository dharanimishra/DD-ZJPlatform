package com.ziksana.domain.course;

public class CourseSubjectClassification {

	private Integer subjClassificationId;

	private String subjectCategory;

	private String subjectArea;

	private String subjectTopic;

	public CourseSubjectClassification() {
		super();
	}

	public CourseSubjectClassification(Integer subjClassificationId,
			String subjectCategory, String subjectArea, String subjectTopic) {
		super();
		this.subjClassificationId = subjClassificationId;
		this.subjectCategory = subjectCategory;
		this.subjectArea = subjectArea;
		this.subjectTopic = subjectTopic;
	}

	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public String getSubjectArea() {
		return subjectArea;
	}

	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}

	public String getSubjectTopic() {
		return subjectTopic;
	}

	public void setSubjectTopic(String subjectTopic) {
		this.subjectTopic = subjectTopic;
	}

	@Override
	public String toString() {
		return "CourseSubjectClassification [subjClassificationId="
				+ subjClassificationId + ", subjectCategory=" + subjectCategory
				+ ", subjectArea=" + subjectArea + ", subjectTopic="
				+ subjectTopic + "]";
	}

}
