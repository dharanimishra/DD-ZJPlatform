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
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.course.CourseNestTreeService;

@Controller
@RequestMapping("/zcourse/")
public class CoursePlannerController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CoursePlannerController.class);
	
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


	@RequestMapping(value = "1/planner/{courseId}", method = { RequestMethod.GET })
	public @ResponseBody
	ModelAndView getCoursePlannerDetails(@PathVariable String courseId) {
		LOGGER.debug("Entering showTreenode(): " + courseId);
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;

		ModelAndView modelView = new ModelAndView("mastercourseplanner");

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
}