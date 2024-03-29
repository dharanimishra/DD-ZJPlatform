package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;
import com.ziksana.domain.course.TreeNode;
import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.persistence.course.CourseTreeNodeMapper;
import com.ziksana.service.course.CourseTreeNodeService;

/**
 * @author ratneshkumar
 */
@Service
public class CourseTreeNodeServiceImpl implements CourseTreeNodeService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseTreeNodeServiceImpl.class);

	@Autowired
	public CourseMapper courseMapper;

	@Autowired
	public CourseTreeNodeMapper courseTreeNodeMapper;

	public List<CourseLearningComponent> getLearningComponents(Integer courseId) {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getLearningComponents(Integer courseId)"
				+ courseId);
		List<CourseLearningComponent> courseLearningComponent = courseMapper
				.getLearningComponents(courseId);
		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :getLearningComponents(Integer courseId)"
				+ courseLearningComponent.size());

		return courseLearningComponent;
	}

	public LearningComponentType getLearningComponentType(
			Integer learningComponentTypeId) {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getLearningComponentType(Integer learningComponentTypeId)"
				+ learningComponentTypeId);
		LearningComponentType learningComponentType = courseMapper
				.getLearningComponentType(learningComponentTypeId);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getLearningComponentType(Integer learningComponentTypeId)"
				+ learningComponentType.getLearningComponentTypeId());

		return learningComponentType;
	}

	public LearningComponent getLearningComponent(Integer learningComponentId) {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getLearningComponent(Integer learningComponentId)"
				+ learningComponentId);
		LearningComponent learningComponent = courseMapper
				.getLearningComponent(learningComponentId);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getLearningComponent(Integer learningComponentId)"
				+ learningComponent.getLearningComponentId());

		return learningComponent;
	}

	public LearningComponentNest getLearningComponentNest(
			Integer learningComponentNestId) {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getLearningComponentNest(Integer learningComponentNestId)"
				+ learningComponentNestId);
		LearningComponentNest learningComponentNest = courseMapper
				.getLearningComponentNest(learningComponentNestId);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getLearningComponentNest(Integer learningComponentNestId)"
				+ learningComponentNest.getComponentNestId());

		return learningComponentNest;
	}

	public List<LearningComponentContent> getLearningComponentContents(
			Integer learningComponentId) {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getLearningComponentContents(Integer learningComponentId)"
				+ learningComponentId);
		List<LearningComponentContent> list = courseMapper
				.getLearningComponentContents(learningComponentId);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getLearningComponentContents(Integer learningComponentId)"
				+ list.size());

		return list;
	}

	public LearningContent getLearningContent(Integer learningContentId) {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getLearningContent(Integer learningContentId)"
				+ learningContentId);
		LearningContent learningContent = courseMapper
				.getLearningContent(learningContentId);
		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :getLearningContent(Integer learningContentId)"
				+ learningContent.getLearningContentId());

		return learningContent;
	}

	public List<LearningContentParts> getLearningContentParts(
			Integer learningContentId) {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getLearningContentParts(Integer learningContentId)"
				+ learningContentId);
		List<LearningContentParts> list = courseMapper
				.getLearningContentParts(learningContentId);
		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getLearningContentParts(Integer learningContentId)"
				+ list.size());

		return list;
	}

	public List<TreeNode> getParentTreeComponents(Integer courseId) {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getCourseComponents(Integer courseId)"
				+ courseId);
		List<TreeNode> list = courseTreeNodeMapper
				.getParentTreeComponents(courseId);
		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :getCourseComponents(Integer courseId)");
		return list;
	}

	public List<TreeNode> getTreeContentComponents(Integer courseId) {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getTreeContentComponents(Integer courseId)"
				+ courseId);
		List<TreeNode> list = courseTreeNodeMapper
				.getTreeContentComponents(courseId);
		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :getTreeContentComponents(Integer courseId)");

		return list;
	}

	public Course getCourseComponents(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TreeNode> getModuleComponents(Integer courseId) {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getModuleComponents(Integer courseId)"
				+ courseId);
		List<TreeNode> list = courseTreeNodeMapper
				.getModuleComponents(courseId);
		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :getModuleComponents(Integer courseId)");
		return list;
	}

	public List<TreeNode> getModuleContents(Integer learningComponentId) {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getModuleContents(Integer learningComponentId)"
				+ learningComponentId);
		List<TreeNode> list = courseTreeNodeMapper
				.getModuleContents(learningComponentId);

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getModuleContents(Integer learningComponentId)");
		return list;
	}

	public List<TreeNode> getCourseComponent(Integer courseId) {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getCourseComponent(Integer courseId)"
				+ courseId);
		List<TreeNode> list = courseTreeNodeMapper.getCourseComponent(courseId);

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getCourseComponent(Integer learningComponentId)");
		return list;
	}
}
