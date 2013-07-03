/**
 * 
 */
package com.ziksana.domain.course;

import com.ziksana.domain.utils.Topic;

/**
 * @author bhashasp
 *
 */
public class ReferenceSearchCriteria {
	
	
	/**
	 * advanced Search criteria
	 * @param name
	 * @param indicatorType
	 * @param contentType
	 * @param topic
	 * @param tags
	 */
	public ReferenceSearchCriteria(String name,
			ContentIndicatorType indicatorType, ContentType contentType,
			Topic topic, String tags) {
		this.name = name;
		this.indicatorType = indicatorType;
		this.contentType = contentType;
		this.topic = topic;
		this.tags = tags;
		this.setLinkType(LinkType.REFERENCE);
	}
	
	
	/**
	 * Basic Search criteria
	 * @param name
	 * @param indicatorType
	 */
	public ReferenceSearchCriteria(String name,
			ContentIndicatorType indicatorType) {
		this.name = name;
		this.indicatorType = indicatorType;
		this.setLinkType(LinkType.REFERENCE);
		
	}
	
	
	private String 					name 			= null;
	private ContentIndicatorType 	indicatorType 	= null;
	private ContentType				contentType		= null;
	private Topic					topic			= null;
	private String					tags			= null;
	private LinkType				linkType		= null;	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the indicatorType
	 */
	public ContentIndicatorType getIndicatorType() {
		return indicatorType;
	}
	/**
	 * @param indicatorType the indicatorType to set
	 */
	public void setIndicatorType(ContentIndicatorType indicatorType) {
		this.indicatorType = indicatorType;
	}
	/**
	 * @return the contetType
	 */
	public ContentType getContentType() {
		return contentType;
	}
	/**
	 * @param contetType the contetType to set
	 */
	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the linkType
	 */
	public LinkType getLinkType() {
		return linkType;
	}

	/**
	 * @param linkType the linkType to set
	 */
	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}
	
	

}
