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

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.NestTreeNode;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseNestTreeService;
import com.ziksana.service.security.MediaService;

@Controller
@RequestMapping("/zcourse")
public class CourseNestTreeController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseNestTreeController.class);

	@Autowired
	CourseNestTreeService courseNestTreeService;

	@Autowired
	MediaService mediaService ;


	private String treeImagePath = null;
	private String treeImageFolder = null;
	private String courseIcon = null;
	private String chapterIcon = null;
	private String parentIcon = null;
	private String videoIcon = null;
	private String audioIcon = null;
	private String folderClosed = null;
	private String folderOpen = null;
	private String pptIcon = null;
	private String docIcon = null;
	private String excelIcon = null;
	private String pdfIcon = null;
	private String imageIcon = null;
	private String noteIcon = null;
	private String linkIcon = null;

	@RequestMapping(value = "/gettreesample", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTree1() {
		LOGGER.debug("Entering Class " + getClass() + " showCourseTree()");
		ModelAndView mv = new ModelAndView("xml/context");
		LOGGER.debug("Exiting Class " + getClass() + " showCourseTree(): ");

		return mv;
	}

	@RequestMapping(value = "/gettree", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTree() {
		LOGGER.debug("Entering Class " + getClass() + " showCourseTree()");
		ModelAndView mv = new ModelAndView("xml/context");
		LOGGER.debug("Exiting Class " + getClass() + " showCourseTree(): ");

		return mv;
	}

	@RequestMapping(value = "/getparent/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showGetparent(@PathVariable String courseId)
			throws CourseException {
		LOGGER.debug("Entering showTreenode(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("xml/gettree");
		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.debug("showTreenode():  courseIds :" + courseIds);
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
			}

			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);

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
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}

	@RequestMapping(value = "/getchildtree/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showChildTreenode(@PathVariable String courseId)
			throws CourseException {

		LOGGER.debug("Entering showTreenode(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("xml/getchildtree");

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.debug("showTreenode():  courseIds :" + courseIds);
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
				break;
			}
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);
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
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}

	@RequestMapping(value = "/getenrichtree/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showEnrichTree(@PathVariable String courseId)
			throws CourseException {
		ModelAndView modelView = new ModelAndView("xml/getenrichtree");
		setPaths();
		LOGGER.debug("Entering showEnrichTree(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;
		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.debug("showEnrichTree():  courseIds :" + courseIds);
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
			}
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);

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
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}

	@RequestMapping(value = "/getcoursetree/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showCourseTree(@PathVariable String courseId)
			throws CourseException {
		LOGGER.debug("Entering showCourseTree(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("xml/treenode");

		try {
			courseIds = Integer.parseInt(courseId);
			LOGGER.debug("showCourseTree():  courseIds :" + courseIds);

			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelView.addObject("courseIds", courseIdValue);
				modelView.addObject("coursename", coursename);
			}
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			LOGGER.debug(NestTreeNode.debugTrace(treeNodeList));

			modelView.addObject("parentList", treeNodeList);
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
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showCourseTree(): " + courseId);
		return modelView;
	}
	
	private void setPaths(){
		MediaServerURL mediaServerURL = mediaService.getMediaContents();
		treeImagePath = mediaService.getMediaContents().getTreeImagePath() + mediaService.getMediaContents().getStaticFileServer();
		treeImageFolder = treeImagePath + "resources/images/tree_icons/";
		courseIcon = treeImageFolder + "course.png";
		chapterIcon =treeImageFolder + "chapter.png";
		parentIcon = treeImageFolder + "chapter.png";
		videoIcon = treeImageFolder + "video.png";
		audioIcon = treeImageFolder + "audio.png";
		folderClosed = treeImageFolder + "folderClosed.gif";
		folderOpen = treeImageFolder + "folderOpen.gif";
		pptIcon = treeImageFolder + "powerpoint.png";
		docIcon = treeImageFolder + "word.png";
		excelIcon = treeImageFolder + "excel.png";
		pdfIcon = treeImageFolder + "pdf.png";
		imageIcon = treeImageFolder + "image.png";
		noteIcon = treeImageFolder + "note.png";
		linkIcon = treeImageFolder + "link.png";
	}
}
