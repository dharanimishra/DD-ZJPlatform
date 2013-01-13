package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.TreeNode;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseTreeNodeService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/secure")
public class CourseTreeController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseTreeController.class);

	@Autowired
	CourseTreeNodeService courseTreeNodeService;

	private String parentIcon = "../resources/images/tree_icons/chapter.png";
	private String docIcon = "../resources/images/tree_icons/pdf.png";
	private String videoIcon = "../resources/images/tree_icons/video.png";
	private String audioIcon = "../resources/images/tree_icons/audio.png";
	private String folderClosed = "../resources/images/tree_icons/folderClosed.gif";
	private String folderOpen = "../resources/images/tree_icons/folderOpen.gif";

	@RequestMapping(value = "/gettree", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTree() {
		LOGGER.info("Entering Class " + getClass() + " showCourseTree()");
		ModelAndView mv = new ModelAndView("xml/context");
		LOGGER.info("Exiting Class " + getClass() + " showCourseTree(): ");

		return mv;
	}

	@RequestMapping(value = "/getparenttree/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showTreenode(@PathVariable String courseId)
			throws CourseException {
		LOGGER.info("Entering showTreenode(): " + courseId);
		Integer courseIds = 0;
		String courseIdValue = "";
		String coursename = "";

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.info("Exiting showTreenode():  courseIds :" + courseIds);
		} catch (NumberFormatException nfe) {
			courseIds = 100;
			LOGGER.debug("Class :" + getClass()
					+ "showTreenode(): NumberFormatException :"
					+ nfe.getMessage());
		}

		List<TreeNode> treeNodeList = courseTreeNodeService
				.getModuleComponents(courseIds);

		LOGGER.debug("Class :" + getClass()
				+ "showTreenode(): treeNodeList Size :" + treeNodeList.size());

		for (TreeNode node : treeNodeList) {
			courseIdValue = node.getCourseId().toString();
			coursename = node.getCoursename();

		}

		ModelAndView modelView = new ModelAndView("xml/getparenttree");

		modelView.addObject("courseIds", courseIdValue);
		modelView.addObject("coursename", coursename);
		modelView.addObject("parentIcon", parentIcon);
		modelView.addObject("docIcon", docIcon);
		modelView.addObject("folderClosed", folderClosed);
		modelView.addObject("folderOpen", folderOpen);
		modelView.addObject("videoIcon", videoIcon);
		modelView.addObject("audioIcon", audioIcon);
		modelView.addObject("treeList", treeNodeList);

		LOGGER.info("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}

	@RequestMapping(value = "/getchildtree/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showChildTreenode(@PathVariable String courseId)
			throws CourseException {
		LOGGER.info("Entering showChildTreenode(): " + courseId);
		Integer courseIds = 0;
		String courseIdValue = "";
		String coursename = "";
		Integer learningComponentId = 0;
		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.info("Exiting showChildTreenode():  courseIds :" + courseIds);

		} catch (NumberFormatException nfe) {
			courseIds = 100;
			LOGGER.debug("Class :" + getClass()
					+ "showChildTreenode(): NumberFormatException :"
					+ nfe.getMessage());
		}

		List<TreeNode> childList = new ArrayList<TreeNode>();
		List<TreeNode> treeNodeList = courseTreeNodeService
				.getModuleComponents(courseIds);
		List<TreeNode> childtreeNodeList = null;

		try {
			for (TreeNode node : treeNodeList) {
				courseIdValue = node.getCourseId().toString();
				coursename = node.getCoursename();
				learningComponentId = node.getId();
				childtreeNodeList = courseTreeNodeService
						.getModuleContents(learningComponentId);
				LOGGER.debug("Class :" + getClass()
						+ " childtreeNodeList size " + childtreeNodeList.size());
				LOGGER.debug("Class :"
						+ getClass()
						+ "showParentTreenode(): List size found : learningComponentId:"
						+ learningComponentId);
				try {
					for (TreeNode childnode : childtreeNodeList) {
						childList.add(childnode);

					}
					LOGGER.info("Class :" + getClass()
							+ "showChildTreenode(): List size found");
				} catch (Exception e) {
					LOGGER.debug("Class :" + getClass()
							+ "showChildTreenode(): List size not found"
							+ e.getMessage());
				}

			}
		} catch (Exception e) {
			LOGGER.debug("Class :" + getClass()
					+ "showParentTreenode(): List size not found"
					+ e.getMessage());
		}

		ModelAndView modelView = new ModelAndView("xml/getchildtree");

		modelView.addObject("courseIds", courseIdValue);
		modelView.addObject("coursename", coursename);
		modelView.addObject("parentIcon", parentIcon);
		modelView.addObject("docIcon", docIcon);
		modelView.addObject("videoIcon", videoIcon);
		modelView.addObject("audioIcon", audioIcon);
		modelView.addObject("folderClosed", folderClosed);
		modelView.addObject("folderOpen", folderOpen);
		modelView.addObject("parentList", treeNodeList);
		modelView.addObject("childList", childList);

		LOGGER.info("Exiting showChildTreenode(): " + courseId);
		return modelView;
	}
}
