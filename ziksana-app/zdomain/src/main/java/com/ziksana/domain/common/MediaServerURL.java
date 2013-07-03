package com.ziksana.domain.common;



public class MediaServerURL {
	
	private String url;
	
	
	private String uploadScript;
	
	
	private String uploadContent;
	
	private String flashRecordingScript;
	
	private String flashRecordingFolder;
	
	private String staticFileServer;
	
	private String treeImagePath;
	
	private String staticResources;

	public String getStaticResources() {
		return staticResources;
	}

	public void setStaticResources(String staticResources) {
		this.staticResources = staticResources;
	}

	public String getStaticFileServer() {
		return staticFileServer;
	}

	public void setStaticFileServer(String staticFileServer) {
		this.staticFileServer = staticFileServer;
	}

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

	/**
	 * @return the treeImagePath
	 */
	public String getTreeImagePath() {
		return treeImagePath;
	}

	/**
	 * @param treeImagePath the treeImagePath to set
	 */
	public void setTreeImagePath(String treeImagePath) {
		this.treeImagePath = treeImagePath;
	}
	
}
