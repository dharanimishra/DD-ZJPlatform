package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningContent;

/**
 * @author ratneshkumar
 * 
 */

public class TreeNodeObject {

	public TreeNodeObject() {
		super();
	}

	private Course course;

	private List<CourseLearningComponent> courseLearningComponent;

	private Map<String, List<LearningContent>> map = new HashMap<String, List<LearningContent>>();

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<CourseLearningComponent> getCourseLearningComponent() {
		return courseLearningComponent;
	}

	public void setCourseLearningComponent(
			List<CourseLearningComponent> courseLearningComponent) {
		this.courseLearningComponent = courseLearningComponent;
	}

	public Map<String, List<LearningContent>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<LearningContent>> map) {
		this.map = map;
	}

}
