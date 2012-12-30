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
	ModelAndView showMyTreenode(@PathVariable String courseId) {
		LOGGER.info("Entering showMyTreenode(): " + courseId);
		Integer courseIds = 100;
		List<TreeNode> treeNodeList = courseTreeNodeService
				.getTreeComponents(courseIds);
		ModelAndView modelView = new ModelAndView("xml/treenode");

		modelView.addObject("treeList", treeNodeList);
		modelView.addObject("treeList", treeNodeList);

		LOGGER.info("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}
}
