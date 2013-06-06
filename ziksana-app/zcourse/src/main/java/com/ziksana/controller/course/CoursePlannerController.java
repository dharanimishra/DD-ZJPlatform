package com.ziksana.controller.course;

import java.util.List;

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
		ModelAndView modelAndView = new ModelAndView("mastercourseplanner");
		Integer courseIds = 0;
		Integer courseIdValue = 0;
		String coursename = null;
		try {
			courseIds = Integer.parseInt(courseId);
		
			List<NestTreeNode> nodeList = courseNestTreeService
					.getCourseComponent(courseIds);

			for (NestTreeNode node : nodeList) {
				courseIdValue = node.getCourseId();
				coursename = node.getCoursename();
				modelAndView.addObject("courseIds", courseIdValue);
				modelAndView.addObject("coursename", coursename);
				break;
			}
			List<NestTreeNode> treeNodeList = courseNestTreeService
					.getModuleComponents(courseIds);

			
			modelAndView.addObject("parentList", treeNodeList);
			modelAndView.addObject("courseIds", courseIds);
			modelAndView.addObject("parentIcon", parentIcon);
			modelAndView.addObject("courseIcon", courseIcon);
			modelAndView.addObject("chapterIcon", chapterIcon);
			modelAndView.addObject("docIcon", docIcon);
			modelAndView.addObject("pdfIcon", pdfIcon);
			modelAndView.addObject("pptIcon", pptIcon);
			modelAndView.addObject("videoIcon", videoIcon);
			modelAndView.addObject("linkIcon", linkIcon);
			modelAndView.addObject("noteIcon", noteIcon);
			modelAndView.addObject("imageIcon", imageIcon);
			modelAndView.addObject("audioIcon", audioIcon);
			modelAndView.addObject("excelIcon", excelIcon);
			modelAndView.addObject("folderClosed", folderClosed);
			modelAndView.addObject("folderOpen", folderOpen);
		} catch (ZiksanaException exception) {
			
		}

	
		return modelAndView;
		
	}
	
}
