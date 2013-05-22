package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.Date;
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
import com.ziksana.domain.course.ComponentContentType;
import com.ziksana.domain.course.Content;
import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.ContentService;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.LearningComponentService;
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
	ContentService contentService;
	
	@Autowired
	MediaService mediaService;
	
	@Autowired
	CourseService courseService;

	//@Autowired
	//LearningComponentService learningComponentService;
	
	
	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "/1/associatecontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView showAssociateContent() {
		LOGGER.debug("Entering showAssociateCourse(): ");
		ModelAndView modelView = new ModelAndView("associatecontent");
		try {
			LearningContent content = new LearningContent();
			content.setContentType(ContentType.getContentType(612));
			//Map listttt = enumDataService.fetchData("corLearningContent_Content Type");	
			
			Integer memberId = Integer.valueOf(SecurityTokenUtil
						.getToken().getMemberPersonaId().getStorageID());
				List<LearningContent> learningContents = contentService.getUserContent(memberId);
				String jsonString = JSONUtil.objectToJSONString(learningContents);
				
				modelView.addObject("learningContentAsJSONString", jsonString);
				

				mediaServerURL = mediaService.getMediaContents();
				modelView.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
		}
		return modelView;
	}

	@RequestMapping(value = "/1/associatecontent/{courseId}", method = {
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
				List<LearningContent> learningContents = contentService.getUserContent(memberId);
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

	@RequestMapping(value = "/1/associatecontent/", method = {
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView associateContents(
			@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "learningComponentId", required = false) String learningComponentId,
			@RequestParam(value = "learningContentToBeAssociated", required = true) String learningContentToBeAssociated
			) {
		Integer course_id = 0;
		ModelAndView modelView =  new ModelAndView("associatecontent");
		
		try {
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage() + exception);
		}
		return modelView;
	}
	
	private List<LearningComponentContent> getLearningComponentContents(int courseId, int learningComponentId, String learningContentsToBeAssociated){
		
		String[] contentIdArray = learningContentsToBeAssociated.split(",");
		
		Integer memberId = Integer.valueOf(SecurityTokenUtil
				.getToken().getMemberPersonaId().getStorageID());
		List<LearningComponentContent> learningComponentContentList = new ArrayList<LearningComponentContent>();
		
		Course course = courseService.getCourseByCourseId(courseId);
		LearningComponent learningComponent = null;//learningComponentService.getLearningComponent(learningComponentId);
		
		for (String stringContentId : contentIdArray) {
			
			LearningContent learningContent = contentService.getLearningContent(Integer.parseInt(stringContentId));
			LearningComponentContent learningComponentContent = new LearningComponentContent();
			learningComponentContent.setActive(true);
			learningComponentContent.setCompContentType(ComponentContentType.PREVIEW_CONTENT);
			learningComponentContent.setCompContentTypeId(ComponentContentType.PREVIEW_CONTENT.getID());
			learningComponentContent.setContentDescription(learningContent.getContentDescription());
			learningComponentContent.setCourseStatus(course.getCourseStatus());
			learningComponentContent.setCourseStatusId(course.getCourseStatus().getID());
			
			//componentContent.setCreatedBy(memberId);
			learningComponentContent.setCreatedOn(new Date());
			learningComponentContent.setCreationDate(new Date());
			learningComponentContent.setLearningComponent(learningComponent);
			learningComponentContent.setBaseLearningContent(learningContent);
			//set learning component content details
			//componentContent.setModifiedBy(modifiedBy);
			learningComponentContent.setModifiedOn(new Date());
			//componentContent.setSynchronizeWithVideo(synchronizeWithVideo);
			learningComponentContentList.add(learningComponentContent);
		}
		
		
		
		return learningComponentContentList;
	}
	
	
	
	
	@RequestMapping(value = "/modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showmodalplayer(@PathVariable String contentId) {
		LOGGER.debug("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/modalplayer");
		try {
			mediaServerURL = mediaService.getMediaContents();
			Content content = contentService.getContent(Integer.valueOf(contentId));
			mv.addObject("content", content);
			mv.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return mv;
	}
	
	@RequestMapping(value = "/ev_modalplayer/{contentId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	ModelAndView showevmodalplayer(@PathVariable String contentId) {
		LOGGER.debug("Entering showmodalplayer(): ");
		ModelAndView mv = new ModelAndView("courses/ev_modalplayer");

		try {
			Content content = contentService.getContent(Integer.valueOf(contentId));
			
			mv.addObject("content", content);
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return mv;
	}

	@RequestMapping(value = "/enhance", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView enhance(
			@RequestParam(value = "flashcontentpath", required = true) String flashcontentpath) {
		ModelAndView mav = new ModelAndView("courses/enrich_player");
		try {
			mav.addObject("flashcontentpath", flashcontentpath);
			mediaServerURL = mediaService.getMediaContents();
			mav.addObject("ms", mediaServerURL);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		return mav;

	}
}
