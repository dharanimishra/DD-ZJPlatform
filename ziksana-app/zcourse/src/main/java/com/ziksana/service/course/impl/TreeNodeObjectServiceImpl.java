package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.TreeNodeObject;
import com.ziksana.service.course.CourseTreeNodeService;
import com.ziksana.service.course.TreeNodeObjectService;

@Service
public class TreeNodeObjectServiceImpl implements TreeNodeObjectService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(TreeNodeObjectServiceImpl.class);

	@Autowired
	public CourseTreeNodeService courseTreeNodeService;

	public TreeNodeObject getTreeNodeObject(Integer courseId) {

		LOGGER.info("Entering Class :" + getClass()
				+ " Method Name :getTreeNodeObject(Integer courseId)");

		TreeNodeObject nodeObject = new TreeNodeObject();
		Course course = courseTreeNodeService.getCourseComponents(courseId);
		nodeObject.setCourse(course);

		List<CourseLearningComponent> courseLearningComponentList = courseTreeNodeService
				.getLearningComponents(courseId);

		nodeObject.setCourseLearningComponent(courseLearningComponentList);

		Map<String, List<LearningContent>> contentMap = new HashMap<String, List<LearningContent>>();

		List<LearningContent> learningContentList = new ArrayList<LearningContent>();
		for (CourseLearningComponent courseLearningComponent : courseLearningComponentList) {

			String getCourseLearningComponentId = courseLearningComponent
					.getCourseLearningComponentId().getStorageID();
			LearningContent LearningContent = courseTreeNodeService
					.getLearningContent(Integer
							.valueOf(getCourseLearningComponentId));
			learningContentList.add(LearningContent);

			contentMap.put(LearningContent.getLearningContentId()
					.getStorageID(), learningContentList);

		}
		nodeObject.setMap(contentMap);

		LOGGER.info("Exiting Class :" + getClass()
				+ " Method Name : getTreeNodeObject(Integer courseId)");
		return nodeObject;
	}

}
