package com.ziksana.domain.course;

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.TagCloud;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author Ratnesh Kumar
 */
public class CourseTagcloud extends TagCloud {

	public CourseTagcloud() {
		super();
	}

	public CourseTagcloud(String tagName, TagType tagType) {
		super(tagName, tagType);
	}

	private ZID courseTagCloudId;
	private Course course = null;
	private Integer tagCloudId = null;

	public Integer getTagCloudId() {
		return tagCloudId;
	}

	public void setTagCloudId(Integer tagCloudId) {
		this.tagCloudId = tagCloudId;
	}

	private Integer courseId = null;

	private Integer learningComponentId = null;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * @return the courseTagCloudId
	 */
	public ZID getCourseTagCloudId() {
		return courseTagCloudId;
	}

	/**
	 * @param courseTagCloudId
	 *            the courseTagCloudId to set
	 */
	public void setCourseTagCloudId(Integer courseTagCloudId) {

		this.courseTagCloudId = new IntegerZID(courseTagCloudId);
	}

	public void setCourseTagCloudId(ZID courseTagCloudId) {
		this.courseTagCloudId = courseTagCloudId;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

}
