package com.ziksana.domain.common;



public class MediaServerURL {
	
	private String url;
	
	
	private String uploadScript;
	
	
	private String uploadContent;
	
	private String flashRecordingScript;
	
	private String flashRecordingFolder;

	public String getFlashRecordingFolder() {
		return flashRecordingFolder;
	}

	public void setFlashRecordingFolder(String flashRecordingFolder) {
		this.flashRecordingFolder = flashRecordingFolder;
	}

	

	public String getFlashRecordingScript() {
		return flashRecordingScript;
	}

	public void setFlashRecordingScript(String flashRecordingScript) {
		this.flashRecordingScript = flashRecordingScript;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUploadScript() {
		return uploadScript;
	}
	public void setUploadScript(String uploadScript) {
		this.uploadScript = uploadScript;
	}

	public String getUploadContent() {
		return uploadContent;
	}

	public void setUploadContent(String uploadContent) {
		this.uploadContent = uploadContent;
	}
}
