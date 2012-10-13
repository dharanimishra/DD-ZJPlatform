/**
 * 
 */
package com.ziksana.domain.course;

import java.sql.Timestamp;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class ContentEmbed extends AuditHistory {
	
	public ContentEmbed(Timestamp startTime, Timestamp endTime,
			EmbeddedContentType contentType, String embeddedContentPath,
			String embeddedContent, ApplyEmbed applyEmbed) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.contentType = contentType;
		this.embeddedContentPath = embeddedContentPath;
		this.embeddedContent = embeddedContent;
		this.applyEmbed = applyEmbed;
	}

	private ZID 					contentEmbedId;
	private Timestamp 				startTime 				= null;
	private Timestamp 				endTime 				= null;
	private EmbeddedContentType 	contentType 			= null;
	private String 					embeddedContentPath 	= null;
	private String 					embeddedContent 		= null;
	private Boolean 				active 					= null;
	private ApplyEmbed				applyEmbed 				= null;
	/**
	 * @return the contentEmbedId
	 */
	public ZID getContentEmbedId() {
		return contentEmbedId;
	}
	/**
	 * @param contentEmbedId the contentEmbedId to set
	 */
	public void setContentEmbedId(ZID contentEmbedId) {
		this.contentEmbedId = contentEmbedId;
	}
	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the contentType
	 */
	public EmbeddedContentType getContentType() {
		return contentType;
	}
	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(EmbeddedContentType contentType) {
		this.contentType = contentType;
	}
	/**
	 * @return the embeddedContentPath
	 */
	public String getEmbeddedContentPath() {
		return embeddedContentPath;
	}
	/**
	 * @param embeddedContentPath the embeddedContentPath to set
	 */
	public void setEmbeddedContentPath(String embeddedContentPath) {
		this.embeddedContentPath = embeddedContentPath;
	}
	/**
	 * @return the embeddedContent
	 */
	public String getEmbeddedContent() {
		return embeddedContent;
	}
	/**
	 * @param embeddedContent the embeddedContent to set
	 */
	public void setEmbeddedContent(String embeddedContent) {
		this.embeddedContent = embeddedContent;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the applyEmbed
	 */
	public ApplyEmbed getApplyEmbed() {
		return applyEmbed;
	}
	/**
	 * @param applyEmbed the applyEmbed to set
	 */
	public void setApplyEmbed(ApplyEmbed applyEmbed) {
		this.applyEmbed = applyEmbed;
	}
	
	@Override
	public String toString() {
		return "ContentEmbed [startTime=" + startTime + ", endTime=" + endTime
				+ ", contentType=" + contentType + ", embeddedContentPath="
				+ embeddedContentPath + ", embeddedContent=" + embeddedContent
				+ ", active=" + active + "]";
	}
	

}
