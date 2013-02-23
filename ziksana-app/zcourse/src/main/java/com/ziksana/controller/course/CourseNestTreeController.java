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

import com.ziksana.domain.course.NestTreeNode;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseNestTreeService;

@Controller
@RequestMapping("/secure")
public class CourseNestTreeController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseNestTreeController.class);

	@Autowired
	CourseNestTreeService courseNestTreeService;

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

	@RequestMapping(value = "/gettree1", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTree1() {
		LOGGER.info("Entering Class " + getClass() + " showCourseTree()");
		ModelAndView mv = new ModelAndView("xml/context");
		LOGGER.info("Exiting Class " + getClass() + " showCourseTree(): ");

		return mv;
	}

	@RequestMapping(value = "/getparent/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showGetparent(@PathVariable String courseId)
			throws CourseException {
		LOGGER.info("Entering showTreenode(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("xml/gettree");

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.info("showTreenode():  courseIds :" + courseIds);
		} catch (NumberFormatException nfe) {
			LOGGER.error("Class :" + getClass()
					+ ".showGetParent(): NumberFormatException :"
					+ nfe.getMessage());
			modelView.addObject("Exception", nfe);
			return modelView;
		}

		try {
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
			}
		} catch (Exception exp) {
			LOGGER.error("Class :" + getClass()
					+ ".showGetParent() getCourseComp() : " + exp);
			modelView.addObject("Exception", exp);
			return modelView;
		}

		try {
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);
		} catch (Exception exp) {
			LOGGER.error("Class :" + getClass()
					+ ".showGetParent() getModuleCom() : " + exp);
			modelView.addObject("Exception", exp);
			return modelView;
		}

		modelView.addObject("courseIds", courseIds);
		modelView.addObject("parentIcon", parentIcon);
		modelView.addObject("courseIcon", courseIcon);
		modelView.addObject("chapterIcon", chapterIcon);
		modelView.addObject("docIcon", docIcon);
		modelView.addObject("pdfIcon", pdfIcon);
		modelView.addObject("pptIcon", pptIcon);
		modelView.addObject("videoIcon", videoIcon);
		modelView.addObject("linkIcon", linkIcon);
		modelView.addObject("noteIcon", noteIcon);
		modelView.addObject("imageIcon", imageIcon);
		modelView.addObject("audioIcon", audioIcon);
		modelView.addObject("excelIcon", excelIcon);
		modelView.addObject("folderClosed", folderClosed);
		modelView.addObject("folderOpen", folderOpen);

		LOGGER.info("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}

	@RequestMapping(value = "/getchildtree/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showChildTreenode(@PathVariable String courseId)
			throws CourseException {

		LOGGER.info("Entering showTreenode(): " + courseId);

		LOGGER.info("Entering showTreenode(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("xml/getchildtree");

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.info("showTreenode():  courseIds :" + courseIds);
		} catch (NumberFormatException nfe) {
			LOGGER.error("Class :" + getClass()
					+ ".showGetParent(): NumberFormatException :"
					+ nfe.getMessage());
			modelView.addObject("Exception", nfe);
			return modelView;
		}

		try {
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
			}
		} catch (Exception exp) {
			LOGGER.error("Class :" + getClass()
					+ ".showGetParent() getCourseComp() : " + exp);
			modelView.addObject("Exception", exp);
			return modelView;
		}

		try {
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);
		} catch (Exception exp) {
			LOGGER.error("Class :" + getClass()
					+ ".showGetParent() getModuleCom() : " + exp);
			modelView.addObject("Exception", exp);
			return modelView;
		}

		modelView.addObject("courseIds", courseIds);
		modelView.addObject("parentIcon", parentIcon);
		modelView.addObject("courseIcon", courseIcon);
		modelView.addObject("chapterIcon", chapterIcon);
		modelView.addObject("docIcon", docIcon);
		modelView.addObject("pdfIcon", pdfIcon);
		modelView.addObject("pptIcon", pptIcon);
		modelView.addObject("videoIcon", videoIcon);
		modelView.addObject("linkIcon", linkIcon);
		modelView.addObject("noteIcon", noteIcon);
		modelView.addObject("imageIcon", imageIcon);
		modelView.addObject("audioIcon", audioIcon);
		modelView.addObject("excelIcon", excelIcon);
		modelView.addObject("folderClosed", folderClosed);
		modelView.addObject("folderOpen", folderOpen);

		LOGGER.info("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}

	@RequestMapping(value = "/getenrichtree/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showEnrichTree(@PathVariable String courseId)
			throws CourseException {

		LOGGER.info("Entering showEnrichTree(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("xml/getenrichtree");

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.info("showEnrichTree():  courseIds :" + courseIds);
		} catch (NumberFormatException nfe) {
			LOGGER.error("Class :" + getClass()
					+ ".showEnrichTree(): NumberFormatException :"
					+ nfe.getMessage());
			modelView.addObject("Exception", nfe);
			return modelView;
		}

		try {
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
			}
		} catch (Exception exp) {
			LOGGER.error("Class :" + getClass()
					+ ".showEnrichTree() getCourseComp() : " + exp);
			modelView.addObject("Exception", exp);
			return modelView;
		}

		try {
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);
		} catch (Exception exp) {
			LOGGER.error("Class :" + getClass()
					+ ".showEnrichTree() getModuleCom() : " + exp);
			modelView.addObject("Exception", exp);
			return modelView;
		}

		modelView.addObject("courseIds", courseIds);
		modelView.addObject("parentIcon", parentIcon);
		modelView.addObject("courseIcon", courseIcon);
		modelView.addObject("chapterIcon", chapterIcon);
		modelView.addObject("docIcon", docIcon);
		modelView.addObject("pdfIcon", pdfIcon);
		modelView.addObject("pptIcon", pptIcon);
		modelView.addObject("videoIcon", videoIcon);
		modelView.addObject("linkIcon", linkIcon);
		modelView.addObject("noteIcon", noteIcon);
		modelView.addObject("imageIcon", imageIcon);
		modelView.addObject("audioIcon", audioIcon);
		modelView.addObject("excelIcon", excelIcon);
		modelView.addObject("folderClosed", folderClosed);
		modelView.addObject("folderOpen", folderOpen);

		LOGGER.info("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}

	@RequestMapping(value = "/getcoursetree/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTree(@PathVariable String courseId)
			throws CourseException {
		LOGGER.info("Entering showCourseTree(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("xml/treenode");

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.info("showCourseTree():  courseIds :" + courseIds);
		} catch (NumberFormatException nfe) {
			LOGGER.error("Class :" + getClass()
					+ ".showCourseTree(): NumberFormatException :"
					+ nfe.getMessage());
			modelView.addObject("Exception", nfe);
			return modelView;
		}

		try {
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
			}
		} catch (Exception exp) {
			LOGGER.error("Class :" + getClass()
					+ ".showCourseTree() getCourseComp() : " + exp);
			modelView.addObject("Exception", exp);
			return modelView;
		}

		try {
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);
		} catch (Exception exp) {
			LOGGER.error("Class :" + getClass()
					+ ".showCourseTree() getModuleCom() : " + exp);
			modelView.addObject("Exception", exp);
			return modelView;
		}

		modelView.addObject("courseIds", courseIds);
		modelView.addObject("parentIcon", parentIcon);
		modelView.addObject("courseIcon", courseIcon);
		modelView.addObject("chapterIcon", chapterIcon);
		modelView.addObject("docIcon", docIcon);
		modelView.addObject("pdfIcon", pdfIcon);
		modelView.addObject("pptIcon", pptIcon);
		modelView.addObject("videoIcon", videoIcon);
		modelView.addObject("linkIcon", linkIcon);
		modelView.addObject("noteIcon", noteIcon);
		modelView.addObject("imageIcon", imageIcon);
		modelView.addObject("audioIcon", audioIcon);
		modelView.addObject("excelIcon", excelIcon);
		modelView.addObject("folderClosed", folderClosed);
		modelView.addObject("folderOpen", folderOpen);

		LOGGER.info("Exiting showCourseTree(): " + courseId);
		return modelView;
	}
}
