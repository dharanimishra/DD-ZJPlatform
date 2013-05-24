package com.ziksana.domain.course.json;

import com.ziksana.domain.course.LearningContent;

public class JSONLearningContent {
	private Integer id;
	private String contentDescription;
	private String contentName;
	private String contentType;
	private String contentURL;
	private String thumbnailPicturePath;


	public JSONLearningContent(LearningContent learningContent){
		this.setContentDescription(learningContent.getContentDescription());
		this.setContentName(learningContent.getContentName());
		this.setContentType(learningContent.getContentType().getName());
		this.setContentURL(learningContent.getContentUrl());
		this.id = Integer.parseInt(learningContent.getLearningContentId().getDisplayID());
		this.setThumbnailPicturePath(learningContent.getThumbnailPicturePath());
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}


	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}


}
