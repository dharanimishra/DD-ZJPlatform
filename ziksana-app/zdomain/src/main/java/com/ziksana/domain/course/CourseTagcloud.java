package com.ziksana.domain.course;

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.common.TagCloud;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseTagcloud extends TagCloud{
	
	public CourseTagcloud() {
		super();
	}


	public CourseTagcloud(String tagName, TagType tagType) {
		super(tagName, tagType);
	}

	private ZID 				courseTagCloudId;
	private Course				course					= null;
	
	/**
	 * @return the courseTagCloudId
	 */
	public ZID getCourseTagCloudId() {
		return courseTagCloudId;
	}
	/**
	 * @param courseTagCloudId the courseTagCloudId to set
	 */
	public void setCourseTagCloudId(Integer courseTagCloudId) {
		
		this.courseTagCloudId = new IntegerZID(courseTagCloudId);
	}
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

}
