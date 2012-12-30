package com.ziksana.controller.course;

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
public class CourseTreeNodeController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseTreeNodeController.class);

	@Autowired
	CourseTreeNodeService courseTreeNodeService;

	@RequestMapping(value = "/coursetreenode", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTreeNode() {
		LOGGER.info("Entering Class " + getClass() + " showCourseTreeNode()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass() + " showCourseTreeNode(): ");

		return mv;
	}

	@RequestMapping(value = "/getcoursetree/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showMyTreenode(@PathVariable String courseId) throws CourseException {
		LOGGER.info("Entering showMyTreenode(): " + courseId);
		Integer courseIds = 0;
		String courseIdValue="";
		String coursename = "";
		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.info("Exiting showMyTreenode():  courseIds :" + courseIds);

		} catch (NumberFormatException nfe) {
			courseIds = 100;
			LOGGER.debug("Class :" + getClass()
					+ "showMyTreenode(): NumberFormatException :"
					+ nfe.getMessage());
		}
		List<TreeNode> treeNodeList = courseTreeNodeService
				.getTreeComponents(courseIds);

		for (TreeNode node : treeNodeList) {
			courseIdValue =node.getCourseId().toString();
			coursename = node.getCoursename();
		}
		ModelAndView modelView = new ModelAndView("xml/treenode");

		modelView.addObject("courseIds",courseIdValue);
		modelView.addObject("coursename", coursename);
		modelView.addObject("treeList", treeNodeList);

		LOGGER.info("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}
}
