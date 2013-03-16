package com.ziksana.service.course.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.NestContentNode;
import com.ziksana.domain.course.NestTreeNode;
import com.ziksana.domain.course.TreeNodeList;
import com.ziksana.exception.course.CourseException;
import com.ziksana.persistence.course.TreeNodeMapper;
import com.ziksana.service.course.CourseNestTreeService;

@Service
public class CourseNestTreeServiceImpl implements CourseNestTreeService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseNestTreeServiceImpl.class);

	@Autowired
	public TreeNodeMapper courseNestTreeNodeMapper;

	@Override
	public List<NestTreeNode> getCourseComponent(Integer courseId)
			throws CourseException {
		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getCourseComponent(Integer courseId)"
				+ courseId);

		List<NestTreeNode> list = courseNestTreeNodeMapper
				.getCourseComponent(courseId);

		if (list == null) {
			LOGGER.error("No course for course Id [" + courseId + "] found");
			throw new CourseException("Unable to find a course for course Id ["
					+ courseId + "]");

		} else if (list.size() > 1) {
			LOGGER.error("Multiple courses for course Id [" + courseId
					+ "] found. Names [" + list + "]");

			throw new CourseException("Multiple courses for course Id ["
					+ courseId + "] found. Names [" + list + "]");
		}

		LOGGER.debug("Exiting Class :"
				+ getClass()
				+ " Method Name :getCourseComponent(Integer learningComponentId)");

		return list;
	}

	@Override
	public List<NestTreeNode> getModuleComponents(Integer courseId)
			throws CourseException {

		LOGGER.debug("Entering Class :" + getClass()
				+ " Method Name :getModuleComponents(Integer courseId)"
				+ courseId);

		List<NestTreeNode> list = courseNestTreeNodeMapper.getModuleComponents(courseId);
		if (list == null) {
			throw new CourseException(
					"Unable to retrieve nested learning components from mapper for course ID ["
							+ courseId + "]");
		}

		List<NestContentNode> contentlist = courseNestTreeNodeMapper
							.getContentComponents(courseId);

		TreeNodeList rawList = new TreeNodeList(list, contentlist);
		LOGGER.debug("CourseNestTreeService.getModuleComponents :" + rawList.debugTrace());

		List<NestTreeNode> tree = null;

		try {
			tree = rawList.getTree();
		} catch (Exception exp) {
			LOGGER.error("CourseNestTreeService.getModuleComponents getTree() :" + exp);
			throw new CourseException(
					"Unable to create learning component tree", exp);
		}

		if (tree == null) {
			LOGGER.error("CourseNestTreeService.getModuleComponents getTree() : null");
			throw new CourseException(
					"Unable to create learning component tree for course ID ["
							+ courseId + "]");
		}

		LOGGER.debug("Exiting Class :" + getClass()
				+ " Method Name :getModuleComponents(Integer courseId)");

		return tree;
	}

	@Override
	public List<NestContentNode> getContentComponents(
			Integer courseId) throws CourseException {
		LOGGER.debug("Entering Class :"
				+ getClass()
				+ " Method Name :getContentComponents(Integer learningComponentId)"
				+ courseId);
		List<NestContentNode> tree = null;

		// List<NestContentTreeNode> list = courseNestTreeNodeMapper
		// .getContentComponents(learningComponentId);
		// if (list == null) {
		// LOGGER.debug("Entering Class :"
		// + getClass()
		// +
		// " Method Name :getContentComponents(Integer learningComponentId) - no raw list from the mapper for LearningComponent ID ["
		// + learningComponentId + "]");
		// throw new CourseException(
		// "Unable to retrieve nested learning components from mapper for LearningComponent ID ["
		// + learningComponentId + "]");
		// }
		//
		// // TreeNodeList setChildRawList = new
		// // TreeNodeList(list,learningComponentId);
		// //
		// List<NestContentTreeNode> tree = null;
		// //
		// // try {
		// // tree = setChildRawList.getChildTree();
		// // } catch (Exception exp) {
		// // throw new CourseException(
		// // "Unable to create learning component tree", exp);
		// // }
		// //
		// // if (tree == null) {
		// // throw new CourseException(
		// //
		// "Unable to create learning component tree for LearningComponent ID ["
		// // + learningComponentId + "]");
		// // }
		//
		// // LOGGER.debug("Class :"
		// // + getClass()
		// // +
		// //
		// " Method Name :getContentComponents(Integer learningComponentId) : rawList Size:"
		// // + setChildRawList);
		// //
		// LOGGER.debug("Class :"
		// + getClass()
		// +
		// " Method Name :getContentComponents(Integer learningComponentId) : tree"
		// + tree);
		//
		// LOGGER.debug("Exiting Class :"
		// + getClass()
		// + " Method Name :getContentComponents(Integer learningComponentId)");

		return tree;
	}

}
