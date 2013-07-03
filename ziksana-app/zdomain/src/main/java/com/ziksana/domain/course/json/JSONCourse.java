/**
 * 
 */
package com.ziksana.domain.course.json;

import com.ziksana.domain.course.Course;

/**
 * @author Ratnesh Kumar
 * 
 */
public class JSONCourse {
	private Integer id;
	private String courseName;
	private String courseDescription;
	private String courseStatus;
	private String thumbnailPicturePath;

	public JSONCourse(Course course) {

		this.id = Integer.parseInt(course.getCourseId().getDisplayID());
		this.setCourseName(course.getName());
		//this.setCourseDescription(course.getDescription());
		this.setCourseStatus(course.getCourseStatus().getName());
		this.setThumbnailPicturePath(course.getThumbnailPicturePath());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	@Override
	public String toString() {
		return "JSONCourse [id=" + id + ", courseName=" + courseName
				+ ", courseDescription=" + courseDescription
				+ ", courseStatus=" + courseStatus + ", thumbnailPicturePath="
				+ thumbnailPicturePath + "]";
	}

}
