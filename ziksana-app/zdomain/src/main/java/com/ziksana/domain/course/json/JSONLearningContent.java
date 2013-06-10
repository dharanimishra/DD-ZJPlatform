package com.ziksana.domain.course.json;

import java.util.ArrayList;
import java.util.List;

import com.ziksana.domain.course.ContentDecorationType;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDecoration;

public class JSONLearningContent {
	private Integer id;
	private String contentDescription;
	private String contentName;
	private String contentType;
	private String contentURL;
	private String thumbnailPicturePath;
	private String screenshotPath;
	private List<String> decorationTypeList;  

	public JSONLearningContent(LearningContent learningContent){
		this.setContentDescription(learningContent.getContentDescription());
		this.setContentName(learningContent.getContentName());
		this.setContentType(learningContent.getContentType().getName());
		this.setContentURL(learningContent.getContentUrl());
		this.id = Integer.parseInt(learningContent.getLearningContentId().getDisplayID());
		this.setThumbnailPicturePath(learningContent.getThumbnailPicturePath());
		this.setScreenshotPath(learningContent.getScreenshotPath());
		this.setDecorationTypeList(getContentDecorationsAsString(learningContent.getLearningContentDecorationList()));
	}

	private List<String> getContentDecorationsAsString(List<LearningContentDecoration> learningContentDecorationList){
		List<String> decorationTypeList = new ArrayList<String>();
		if(learningContentDecorationList != null && !learningContentDecorationList.isEmpty()){
			for (LearningContentDecoration learningContentDecoration : learningContentDecorationList) {
				decorationTypeList.add(ContentDecorationType.getContentDecorationType(learningContentDecoration.getContentDecorationTypeId()).getName());
			}
		}
		return decorationTypeList;
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


	public String getScreenshotPath() {
		return screenshotPath;
	}


	public void setScreenshotPath(String screenshotPath) {
		this.screenshotPath = screenshotPath;
	}

	/**
	 * @return the decorationTypeList
	 */
	public List<String> getDecorationTypeList() {
		return decorationTypeList;
	}

	/**
	 * @param decorationTypeList the decorationTypeList to set
	 */
	public void setDecorationTypeList(List<String> decorationTypeList) {
		this.decorationTypeList = decorationTypeList;
	}



}
