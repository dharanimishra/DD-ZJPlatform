package com.ziksana.controller.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			modelView.addObject("imagePathMap", getImagePathMap());
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
		modelView.addObject("courseIds", courseIds);
		modelView.addObject("imagePathMap", getImagePathMap());
		modelView.addObject("cIcon", getCourseIcon());

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
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showMyTreenode(): " + courseId);
		return modelView;
	}
	
	private String getCourseIcon(){
		MediaServerURL mediaServerURL = mediaService.getMediaContents();
		treeImagePath = mediaServerURL.getTreeImagePath() + mediaServerURL.getStaticFileServer();
		treeImageFolder = treeImagePath + "resources/images/tree_icons/";
		String courseIcon = treeImageFolder + "course.png";
		return courseIcon;
	}

	@RequestMapping(value = "/getenrichtree/{courseId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showEnrichTree(@PathVariable String courseId)
			throws CourseException {
		ModelAndView modelView = new ModelAndView("xml/getenrichtree");
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
			modelView.addObject("imagePathMap", getImagePathMap());
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
			modelView.addObject("imagePathMap", getImagePathMap());
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}

		LOGGER.debug("Exiting showCourseTree(): " + courseId);
		return modelView;
	}
	
	
	private Map<String, String> getImagePathMap(){
		HashMap<String, String> imagePathMap = new HashMap<String, String>();
		MediaServerURL mediaServerURL = mediaService.getMediaContents();
		treeImagePath = mediaServerURL.getTreeImagePath() + mediaServerURL.getStaticFileServer();
		treeImageFolder = treeImagePath + "resources/images/tree_icons/";
		String courseIcon = treeImageFolder + "course.png";
		imagePathMap.put("courseIcon", courseIcon);
		
		String chapterIcon =treeImageFolder + "chapter.png";
		imagePathMap.put("chapterIcon", chapterIcon);
		
		String parentIcon = treeImageFolder + "chapter.png";
		imagePathMap.put("parentIcon", parentIcon);
		
		String videoIcon = treeImageFolder + "video.png";
		imagePathMap.put("videoIcon", videoIcon);
		
		String audioIcon = treeImageFolder + "audio.png";
		imagePathMap.put("audioIcon", audioIcon);
		
		String folderClosed = treeImageFolder + "folderClosed.gif";
		imagePathMap.put("folderClosed", folderClosed);
		
		String folderOpen = treeImageFolder + "folderOpen.gif";
		imagePathMap.put("folderOpen", folderOpen);
		
		String pptIcon = treeImageFolder + "powerpoint.png";
		imagePathMap.put("pptIcon", pptIcon);
		
		String docIcon = treeImageFolder + "word.png";
		imagePathMap.put("docIcon", docIcon);
		
		String excelIcon = treeImageFolder + "excel.png";
		imagePathMap.put("excelIcon", excelIcon);
		
		String pdfIcon = treeImageFolder + "pdf.png";
		imagePathMap.put("pdfIcon", pdfIcon);
		
		String imageIcon = treeImageFolder + "image.png";
		imagePathMap.put("imageIcon", imageIcon);
		
		String noteIcon = treeImageFolder + "note.png";
		imagePathMap.put("noteIcon", noteIcon);
		
		String linkIcon = treeImageFolder + "link.png";
		imagePathMap.put("linkIcon", linkIcon);
		
		
		return imagePathMap;
	}
}
