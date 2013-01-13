package com.ziksana.domain.course;

public class CourseSubjectClassification {

	private Integer subjClassificationId;

	private String subjectCategory;

	private String SubjectArea;

	private String SubjectTopic;

	public CourseSubjectClassification() {
		super();
	}

	public CourseSubjectClassification(Integer subjClassificationId,
			String subjectCategory, String subjectArea, String subjectTopic) {
		super();
		this.subjClassificationId = subjClassificationId;
		this.subjectCategory = subjectCategory;
		SubjectArea = subjectArea;
		SubjectTopic = subjectTopic;
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
		return SubjectArea;
	}

	public void setSubjectArea(String subjectArea) {
		SubjectArea = subjectArea;
	}

	public String getSubjectTopic() {
		return SubjectTopic;
	}

	public void setSubjectTopic(String subjectTopic) {
		SubjectTopic = subjectTopic;
	}

}
