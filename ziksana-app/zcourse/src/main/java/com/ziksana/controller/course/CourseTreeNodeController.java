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
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseTreeNodeService;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/zcourse")
public class CourseTreeNodeController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseTreeNodeController.class);

	@Autowired
	CourseTreeNodeService courseTreeNodeService;

	private String courseIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/course.png";
	private String chapterIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/chapter.png";
	private String parentIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/chapter.png";
	private String videoIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/video.png";
	private String audioIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/audio.png";
	private String folderClosed = "../../../../../../../../ziksana-web/resources/images/tree_icons/folderClosed.gif";
	private String folderOpen = "../../../../../../../../ziksana-web/resources/images/tree_icons/folderOpen.gif";
	private String pptIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/powerpoint.png";
	private String docIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/word.png";
	private String excelIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/excel.png";
	private String pdfIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/pdf.png";
	private String imageIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/image.png";
	private String noteIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/note.png";
	private String linkIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/link.png";

	@RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTreeNode(@PathVariable String courseId) {
		LOGGER.debug("Entering Class " + getClass() + " showCourseTreeNode()");
		ModelAndView mv = new ModelAndView("courses/course");
		mv.addObject("CourseId", courseId);
		LOGGER.debug("Exiting Class " + getClass() + " showCourseTreeNode(): ");

		return mv;
	}

	@RequestMapping(value = "/getcoursetree1/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showMyTreenode(@PathVariable String courseId)
			throws CourseException {
		LOGGER.debug("Entering showMyTreenode(): " + courseId);
		ModelAndView modelView = new ModelAndView("xml/treenode");
		try {
			Integer courseIds = 0;
			String courseIdValue = "";
			String coursename = "";
			Integer learningComponentId = 0;
			courseIds = Integer.parseInt(courseId);
			LOGGER.debug("Exiting showMyTreenode():  courseIds :" + courseIds);

			List<TreeNode> NodeList = courseTreeNodeService
					.getCourseComponent(courseIds);
			for (TreeNode node : NodeList) {
				courseIdValue = node.getCourseId().toString();
				coursename = node.getCoursename();
			}

			List<TreeNode> childList = new ArrayList<TreeNode>();
			List<TreeNode> treeNodeList = courseTreeNodeService
					.getParentTreeComponents(courseIds);
			List<TreeNode> childtreeNodeList = null;

			LOGGER.debug("PAENT NODE SIZE" + treeNodeList.size());
			for (TreeNode node : treeNodeList) {
				courseIdValue = node.getCourseId().toString();
				learningComponentId = node.getId();
				LOGGER.error("childtreeNodeListlearningComponentId : "
						+ learningComponentId);
				childtreeNodeList = courseTreeNodeService
						.getTreeContentComponents(learningComponentId);
				LOGGER.error("childtreeNodeList NODE SIZE : "
						+ childtreeNodeList.size());
				for (TreeNode childnode : childtreeNodeList) {

					childList.add(childnode);
				}
			}

			modelView.addObject("courseIds", courseIdValue);
			modelView.addObject("coursename", coursename);
			modelView.addObject("parentIcon", parentIcon);
			modelView.addObject("imageIcon", imageIcon);
			modelView.addObject("pdfIcon", pdfIcon);
			modelView.addObject("linkIcon", linkIcon);
			modelView.addObject("docIcon", docIcon);
			modelView.addObject("pptIcon", pptIcon);
			modelView.addObject("videoIcon", videoIcon);
			modelView.addObject("audioIcon", audioIcon);
			modelView.addObject("treeList", treeNodeList);
			modelView.addObject("childList", childList);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}
}
