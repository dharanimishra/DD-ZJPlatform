package com.ziksana.domain.course;

public class ModuleEditResponse {

	private String id;

	private String modulename;
	private String moduledesc;
	private String subjectarea;
	private String subject;
	private String topic;
	private String tagfield;
	private String prescribedLCDuration;
	private String prescribedLCDurationUnit;
	private String subjClassificationId;
	private String imageupload;
	private String response;
	private String message;

	private Boolean learningObjectIndicator;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public String getModuledesc() {
		return moduledesc;
	}

	public void setModuledesc(String moduledesc) {
		this.moduledesc = moduledesc;
	}

	public Boolean getLearningObjectIndicator() {
		return learningObjectIndicator;
	}

	public void setLearningObjectIndicator(Boolean learningObjectIndicator) {
		this.learningObjectIndicator = learningObjectIndicator;
	}

	public String getPrescribedLCDuration() {
		return prescribedLCDuration;
	}

	public void setPrescribedLCDuration(String prescribedLCDuration) {
		this.prescribedLCDuration = prescribedLCDuration;
	}

	public String getPrescribedLCDurationUnit() {
		return prescribedLCDurationUnit;
	}

	public void setPrescribedLCDurationUnit(String prescribedLCDurationUnit) {
		this.prescribedLCDurationUnit = prescribedLCDurationUnit;
	}

	public String getSubjClassificationId() {
		return subjClassificationId;
	}

	public void setSubjClassificationId(String subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	public String getSubjectarea() {
		return subjectarea;
	}

	public void setSubjectarea(String subjectarea) {
		this.subjectarea = subjectarea;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTagfield() {
		return tagfield;
	}

	public void setTagfield(String tagfield) {
		this.tagfield = tagfield;
	}

	public String getImageupload() {
		return imageupload;
	}

	public void setImageupload(String imageupload) {
		this.imageupload = imageupload;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
