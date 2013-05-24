package com.ziksana.controller.course;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.AssociateContentService;
import com.ziksana.service.security.MediaService;
import com.ziksana.util.JSONUtil;

/**
 * @author Arvind Rathod
 */
@Controller
@RequestMapping("/zcourse")
public class AssociateContentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AssociateContentController.class);

	@Autowired
	AssociateContentService associateContentService;
	
	@Autowired
	MediaService mediaService;
	

	
	
	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "/1/repositorycontents/{courseId}", method = { RequestMethod.GET })
	public @ResponseBody
	ModelAndView showAssociateContent(@PathVariable Integer courseId) {
		LOGGER.debug("Entering showAssociateCourse(): ");
		ModelAndView modelView = new ModelAndView("associatecontent");
		try {
			
			if (courseId > 0) {
				modelView.addObject("courseId",courseId);
				associateContentService.getCourse(courseId);
				Boolean isModuleExists = associateContentService.isModuleExist(courseId); 
				LOGGER.debug("Module Size= >"+isModuleExists);
				if(isModuleExists){
					LearningContent content = new LearningContent();
					content.setContentType(ContentType.getContentType(612));
					Integer memberId = Integer.valueOf(SecurityTokenUtil
								.getToken().getMemberPersonaId().getStorageID());
						List<LearningContent> learningContents = associateContentService.getLearningContents(memberId);
						for (LearningContent learningContent : learningContents) {
							System.out.println("learningContent " + learningContent.getLearningContentId());
						}
						String jsonString = JSONUtil.objectToJSONString(learningContents);
						
						modelView.addObject("learningContentAsJSONString", jsonString);
						

						mediaServerURL = mediaService.getMediaContents();
						modelView.addObject("ms", mediaServerURL);
				}else{
					return new ModelAndView("redirect:/zcourse/createcourse/"+courseId+"");
				}
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
		}
		return modelView;
	}

	@RequestMapping(value = "/1/associatecontent/", method = {
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView associateContents(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "learningComponentId", required = false) String learningComponentId,
			@RequestParam(value = "learningContentsToBeAssociated", required = true) String learningContentsToBeAssociated
			) {
		ModelAndView modelView =  new ModelAndView("associatecontent");
		Integer authMemberRoleId = Integer.valueOf(SecurityTokenUtil
				.getToken().getMemberPersonaId().getStorageID());
		associateContentService.associateContents(authMemberRoleId, Integer.parseInt(courseId), Integer.parseInt(learningComponentId), learningContentsToBeAssociated);
		try {
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
		}
		return modelView;
	}
	
	
	
	
	
	@RequestMapping(value = "/modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showModalplayer(@PathVariable String contentId) {
		LOGGER.debug("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/modalplayer");
		try {
			mediaServerURL = mediaService.getMediaContents();
			LearningContent learningContent = associateContentService.getLearningContent(Integer.valueOf(contentId));
			mv.addObject("content", learningContent);
			mv.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		//test
		return mv;
	}
	
	
	@RequestMapping(value = "/ev_modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showEVModalplayer(@PathVariable String contentId) {
		LOGGER.debug("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/ev_modalplayer");

		try {
			LearningContent learningContent = associateContentService.getLearningContent(Integer.valueOf(contentId));
			
			mv.addObject("content", learningContent);
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return mv;
	}

	
	@RequestMapping(value = "/1/unassociatecontent", method = RequestMethod.POST)
	public @ResponseBody
	String unAssociateContent(
			@RequestParam(value = "contentId", required = true) Integer contentId,
			@RequestParam(value = "courseId", required = true) Integer courseId,
			@RequestParam(value = "componentId", required = true) Integer componentId)
			{
		try {
			associateContentService.unAssociateContent(componentId, contentId);
			LOGGER.debug("Un-Associated course "+ courseId + " component " + componentId + " content for " + contentId);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return "redirect:associatecontent";

	}

		/*	@RequestMapping(value = "/1/associatecontent/{courseId}", method = {
		RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showAssociateCourse(@PathVariable String courseId) {
	Integer course_id = 0;
	ModelAndView modelView =  new ModelAndView("associatecontent");
	try {
		LOGGER.debug("Entering showAssociateCourse(): ");
		course_id = Integer.parseInt(courseId.split("_")[1]);
		if (course_id > 0) {
			
			//TODO we should throw module exist exception here??
			int isModuleExists = courseService.isModuleExists(course_id);
			LOGGER.debug("Module Size= >"+isModuleExists);
			if(isModuleExists == 0 ){
				return new ModelAndView("redirect:/zcourse/createcourse/"+courseId+"");
			}else{
			Integer memberId = Integer.valueOf(SecurityTokenUtil
					.getToken().getMemberPersonaId().getStorageID());
			List<LearningContent> learningContents = contentService.getLearningContents(memberId);
			String jsonString = JSONUtil.objectToJSONString(learningContents);
			
			modelView.addObject("learningContentAsJSONString", jsonString);
			modelView.addObject("CourseId", courseId);
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			}
		} else {
			modelView = new ModelAndView("createcourse");
			modelView.addObject("CourseId", courseId);
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
		}
	} catch (ZiksanaException exception) {
		LOGGER.error(exception.getMessage() + exception);
	}
	return modelView;
	}
	*/

}
