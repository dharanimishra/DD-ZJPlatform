/**
 * 
 */
package com.ziksana.domain.course;

/**
 * @author prabu
 *
 */
public class EducatorContent {
	 
	 Integer id;
	
	 Integer contentType;
	 Integer duration;
	 String title;
	 String description;
	 String coordinates;
	 String url;
	 Integer parentId;
	 
	 
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	 
	 public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
	 

}
