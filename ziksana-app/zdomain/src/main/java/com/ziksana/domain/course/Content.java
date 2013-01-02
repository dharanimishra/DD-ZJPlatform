/**
 * 
 */
package com.ziksana.domain.course;

/**
 * @author prabu
 *
 */
public class Content {
	Integer contentId;
	Integer contentType;
	String  contentUrl;
	String contentTypeString;
	
	
	public String getContentTypeString() {
		return this.contentTypeString;
	}
	
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
		this.contentTypeString = ContentType.getContentType(contentType).getName();
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	
	
	
	
	

}
